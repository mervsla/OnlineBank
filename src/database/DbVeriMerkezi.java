/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;


public class DbVeriMerkezi extends DbConnection{
    protected int kullanici_id=0;
    protected String adSoyad,telNo,tcNo,musteriNo;
    protected double bakiye;
    protected double elektrikFaturasi,suFaturasi,dogalgazFaturasi,internetFaturasi;

    public int getKullanici_id() {
        return kullanici_id;
    }

    public void setKullanici_id(int kullanici_id) {
        this.kullanici_id = kullanici_id;
    }

    public String getAdSoyad() {
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public String getTcNo() {
        return tcNo;
    }

    public void setTcNo(String tcNo) {
        this.tcNo = tcNo;
    }

    public String getMusteriNo() {
        return musteriNo;
    }

    public void setMusteriNo(String musteriNo) {
        this.musteriNo = musteriNo;
    }

    public double getBakiye() {
        return bakiye;
    }

    public void setBakiye(double bakiye) {
        this.bakiye = bakiye;
    }

    public double getElektrikFaturasi() {
        return elektrikFaturasi;
    }

    public void setElektrikFaturasi(double eletrikFaturasi) {
        this.elektrikFaturasi = eletrikFaturasi;
    }

    public double getSuFaturasi() {
        return suFaturasi;
    }

    public void setSuFaturasi(double suFaturasi) {
        this.suFaturasi = suFaturasi;
    }

    public double getDogalgazFaturasi() {
        return dogalgazFaturasi;
    }

    public void setDogalgazFaturasi(double dogalgazFaturasi) {
        this.dogalgazFaturasi = dogalgazFaturasi;
    }

    public double getInternetFaturasi() {
        return internetFaturasi;
    }

    public void setInternetFaturasi(double internetFaturasi) {
        this.internetFaturasi = internetFaturasi;
    }
    
    
}
