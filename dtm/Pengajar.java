/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtm;

/**
 *
 * @author HP820
 */
public class Pengajar {
    private String nama, gender, ttl, waliKelas;
    
    public Pengajar(String nama, String kelamin, String ttl, String waliKelas){
        this.nama = nama;
        this.gender = kelamin;
        this.ttl = ttl;
        this.waliKelas = waliKelas;
    }

    // Getter untuk nama
    public String getNama() {
        return nama;
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
    public String getWaliKelas() {
        return waliKelas;
    }
    
    public String getStatus(){
        return "Pengajar";
    }
}

