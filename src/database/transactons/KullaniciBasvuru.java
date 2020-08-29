/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.transactons;

import database.DbConnection;
import database.IBilgiController;
import gui.ayarlari.TextAyarlari;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class KullaniciBasvuru extends DbConnection implements IBilgiController{
    
    private String adSoyad=null,tcNo=null,telNo=null;
    private String guvenlikSorusu=null,guvenlikCevap=null;
    
    private String musteriNo=null;
    private String sifre=null;

    @Override
    public boolean bilgilerGecerliMi() {
        return !(this.adSoyad==null
                ||this.tcNo==null
                ||this.telNo==null
                ||this.guvenlikSorusu==null
                ||this.guvenlikCevap==null
                ||this.musteriNo==null
                ||this.sifre==null)
                ||TextAyarlari.uzunlukSundanKucukMu(11, this.tcNo)
                ||TextAyarlari.uzunlukSundanKucukMu(11, this.telNo);
        
        
       }

    @Override
    public HesapBilgileri getHesapBilgileri() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

   

    public String getAdSoyad() {
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    public String getTcNo() {
        return tcNo;
    }

    public void setTcNo(String tcNo) {
        this.tcNo = tcNo;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public String getGuvenlikSorusu() {
        return guvenlikSorusu;
    }

    public void setGuvenlikSorusu(String guvenlikSorusu) {
        this.guvenlikSorusu = guvenlikSorusu;
    }

    public String getGuvenlikCevap() {
        return guvenlikCevap;
    }

    public void setGuvenlikCevap(String guvenlikCevap) {
        this.guvenlikCevap = guvenlikCevap;
    }

    public String getMusteriNo() {
        return musteriNo;
    }

    public void setMusteriNo(String musteriNo) {
        this.musteriNo = musteriNo;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }
    public boolean basvuruOnaylandiMi()
    {
        if(this.bilgilerGecerliMi())
        {
            
           if(this.tcNoTablodaVarMi())
           { return false;
           }
            else
            {
            this.basvuruOnayla();
            return true;
            }
        
        }else{
        
            return false;
            }
    }
    
   private boolean tcNoTablodaVarMi()
   {
       String query="SELECT tc_no FROM kullanicilar WHERE tc_no= '"+ this.tcNo +"' ";
        try {
            super.statement=super.connection.createStatement();
            ResultSet rs= statement.executeQuery(query);
            while(rs.next())
            {                
             return true;
            }
           
           } catch (SQLException ex) {
            Logger.getLogger(KullaniciBasvuru.class.getName()).log(Level.SEVERE, null, ex);
                 }
         return false;
   }
   public boolean musteriNoTablodaVarMi()
   {
       String query= " SELECT musteri_no FROM kullanicilar WHERE musteri_no= '"+this.musteriNo+"'";
        try {
            super.statement=super.connection.createStatement();
            ResultSet rs=statement.executeQuery(query);
            while (rs.next())
            {                
                return true;
            }
                    } catch (SQLException ex) {
            Logger.getLogger(KullaniciBasvuru.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
   }
   
   private void basvuruOnayla()
   {
       String query = "INSERT INTO kullanicilar(musteri_no,sifre,"
                + "ad_soyad,tc_no,tel_no,guvenlik_sorusu,guvenlik_cevap)"
                + " VALUES("
                + "'" + this.musteriNo + "',"
                + "'" + this.sifre + "',"
                + "'" + this.adSoyad + "',"
                + "'" + this.tcNo + "',"
                + "'" + this.telNo + "',"
                + "'" + this.guvenlikSorusu + "',"
                + "'" + this.guvenlikCevap + "'"
                + ")";

        try {
            super.statement = super.connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(KullaniciBasvuru.class.getName()).log(Level.SEVERE, null, ex);
        }

   }
   
   
}
