/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import dtm.Santri;
import java.sql.Statement;
import java.time.LocalDate;

/**
 *
 * @author HP820
 */
public class Students {
    private static final String URL = "jdbc:mysql://localhost:3306/tpq_almujahidin";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public String generateNIS() {
        int nextNumber = 1;
        int year = LocalDate.now().getYear();

        String sql = "SELECT MAX(nis) AS last_nis FROM santri WHERE nis LIKE ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setString(1, year + "%");
            ResultSet rs = stmt.executeQuery();

            if (rs.next() && rs.getString("last_nis") != null) {
                String lastNIS = rs.getString("last_nis");
                int lastNumber = Integer.parseInt(lastNIS.substring(4));
                nextNumber = lastNumber + 1;
            }

            return year + String.format("%03d", nextNumber);

        } catch (SQLException e) {
            System.err.println("Error saat menghasilkan NIS! Error: " + e.getMessage());
            throw new RuntimeException("Terdapat masalah", e);
        }
    }

    public boolean insert(String name, String kelas, String gender, String ttl, String wali, String note) {
        String nis = generateNIS();
        String sql = "INSERT INTO santri (id, nis, nama, kelas, gender, ttl, wali, note) VALUES (NULL, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nis);
            stmt.setString(2, name);
            stmt.setString(3, kelas);
            stmt.setString(4, gender);
            stmt.setString(5, ttl);
            stmt.setString(6, wali);
            stmt.setString(7, note);

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            System.err.println("Error saat menyimpan data santri! Error: " + e.getMessage());
            return false;
        }
    }

    public ArrayList<Santri> viewStudents(String genderFilter) {    // Param: "Laki-Laki" atau "Perempuan"
        String sql = "SELECT * FROM santri";
        if (genderFilter != null) {
            sql += " WHERE gender = ?";
        }

        ArrayList<Santri> result = new ArrayList<>();

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            if (genderFilter != null) {
                stmt.setString(1, genderFilter);
            }

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    String nis = rs.getString("nis");
                    String name = rs.getString("nama");
                    String kelas = rs.getString("kelas");
                    String gender = rs.getString("gender");
                    String ttl = rs.getString("ttl");
                    String wali = rs.getString("wali");
                    String note = rs.getString("note");

                    Santri student = new Santri(nis, name, kelas, gender, ttl, wali, note);
                    result.add(student);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error saat mengambil data santri! Error: " + e.getMessage());
        }

        return result;
    }

    public static int count(String type) {
        String query;

        switch (type) {
            case "all":
                query = "SELECT COUNT(*) FROM santri";
                break;
            case "santri":
                query = "SELECT COUNT(*) FROM santri WHERE gender = 'Laki-Laki'";
                break;
            case "santriwati":
                query = "SELECT COUNT(*) FROM santri WHERE gender = 'Perempuan'";
                break;
            default:
                throw new IllegalArgumentException("Invalid type: " + type);
        }

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
