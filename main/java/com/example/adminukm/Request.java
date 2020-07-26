package com.example.adminukm;

public class Request {
    private String namadepan;
    private String namabelakang;
    private String telepon;
    private String email;
    private String alamat;
    private String ukm;
    private String alasan;

    public Request() {

    }


    public String getNamadepan() {
        return namadepan;
    }

    public void setNamadepan(String namadepan) {
        this.namadepan = namadepan;
    }

    public String getNamabelakang() {
        return namabelakang;
    }

    public void setNamabelakang(String namabelakang) {
        this.namabelakang = namabelakang;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getUkm() {
        return ukm;
    }

    public void setUkm(String ukm) {
        this.ukm = ukm;
    }

    public String getAlasan() {
        return alasan;
    }

    public void setAlasan(String alasan) {
        this.alasan = alasan;
    }

}