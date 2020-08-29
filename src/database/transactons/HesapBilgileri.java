
package database.transactons;

import database.DbVeriMerkezi;
import database.IBilgiController;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HesapBilgileri extends DbVeriMerkezi implements IBilgiController{
    
    private static HesapBilgileri hesapBilgileri=null;
    
    public static HesapBilgileri getInstance()
    {
        if(hesapBilgileri==null)
        {
            hesapBilgileri=new HesapBilgileri();
        }
        return hesapBilgileri;
    }
    public void girisYap(String musteriKimlik)
    {
      this.kullaniciyiAl(musteriKimlik);
      this.bakiyeAl();
      this.faturalariAl();
        
    }
    public  void cıkısYap()
    {
        this.kullanici_id=0;
        this.adSoyad=null;
        this.telNo=null;
        this.tcNo=null;
        this.musteriNo=null;
        this.bakiye=0;
        this.elektrikFaturasi=0;
        this.suFaturasi=0;
        this.dogalgazFaturasi=0;
        this.internetFaturasi=0;
        
    }

    @Override
    public boolean bilgilerGecerliMi() {
           return !(super.kullanici_id==0);
   }
    
    
    private void kullaniciyiAl(String musteriKimlik)
    {
        String query="SELECT * FROM kullanicilar WHERE "
                + "tc_no='"+ musteriKimlik+ "'"
                + " OR "
                + "musteri_no='"+ musteriKimlik+"'";
        
        try {
            super.statement=super.connection.createStatement();
            ResultSet rs=statement.executeQuery(query);
            while(rs.next())
            {
                super.kullanici_id=rs.getInt("kullanici_id");
                super.adSoyad=rs.getNString("ad_soyad");
                super.tcNo=rs.getNString("tc_no");
                super.telNo=rs.getNString("tel_no");
                super.musteriNo=rs.getNString("musteri_no");
            }
                    } catch (SQLException ex) {
            Logger.getLogger(HesapBilgileri.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void bakiyeAl()
    {
        if(bilgilerGecerliMi())
        {
            String query="SELECT * FROM kullanici_bakiye "
                + "WHERE "
                + "kullanici_id= '" +super.getKullanici_id()+"'";
            
            try {
                super.statement=super.connection.createStatement();
                ResultSet rs=statement.executeQuery(query);
            while(rs.next())
            {
                super.bakiye=rs.getDouble("bakiye");
            }
            } catch (SQLException ex) {
                Logger.getLogger(HesapBilgileri.class.getName()).log(Level.SEVERE, null, ex);
            }
          
        }
        
    }
    
    public void faturalariAl()
    {
        if(bilgilerGecerliMi())
        {
            String query=" SELECT * FROM kullanici_bakiye "
                + " WHERE "
                + " kullanici_id = '" +super.getKullanici_id()+"' ";
            
            try {
                super.statement=super.connection.createStatement();
                ResultSet rs=statement.executeQuery(query);
            while(rs.next())
            {
                super.elektrikFaturasi=rs.getDouble("elektrik");
                super.suFaturasi=rs.getDouble("su");
                super.dogalgazFaturasi=rs.getDouble("dogalgaz");
                super.internetFaturasi=rs.getDouble("internet");
                
            }
            } catch (SQLException ex) {
                Logger.getLogger(HesapBilgileri.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }    
    }

    @Override
    public HesapBilgileri getHesapBilgileri() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
