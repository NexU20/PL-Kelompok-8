/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtm;

/**
 *
 * @author HP820
 */
public class Santri {
    private String nis, nama, kelas, gender, ttl, wali, note;
    
    public Santri(String nis, String nama, String kelas, String kelamin, String ttl, String wali, String note){
        this.nis = nis;
        this.nama = nama;
        this.gender = kelamin;
        this.kelas = kelas;
        this.ttl = ttl;
        this.wali = wali;
        this.note = note;
    }
    
    // Getter NIS
    public String getNis() {
        return nis;
    }

    // Getter untuk nama
    public String getNama() {
        return nama;
    }

    // Getter untuk kelas
    public String getKelas() {
        return kelas;
    }

    // Getter untuk gender
    public String getGender() {
        return gender;
    }

    // Getter untuk ttl
    public String getTtl() {
        return ttl;
    }

    // Getter untuk wali
    public String getWali() {
        return wali;
    }

    // Getter untuk note
    public String getNote() {
        return note;
    }
}
