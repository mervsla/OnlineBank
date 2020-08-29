/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.transactons;

import database.DbConnection;
import database.IBilgiController;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class Havale extends DbConnection implements IBilgiController{

    private int havaleMiktari =0;
    private String havaleAlacakKisi=null;

    public int getHavaleMiktari() {
        return havaleMiktari;
    }

    public void setHavaleMiktari(int havaleMiktari) {
        this.havaleMiktari = havaleMiktari;
    }

    public String getHavaleAlacakKisi() {
        return havaleAlacakKisi;
    }

    public void setHavaleAlacakKisi(String havaleAlacakKisi) {
        this.havaleAlacakKisi = havaleAlacakKisi;
    }
    
    @Override
    public boolean bilgilerGecerliMi() {
       return !(this.havaleMiktari==0
               || this.havaleAlacakKisi==null
               ||this.havaleMiktari > getHesapBilgileri().getBakiye()
               || this.havaleAlacakKisi.equals(getHesapBilgileri().getMusteriNo()));
    }

    @Override
    public HesapBilgileri getHesapBilgileri() {
     return HesapBilgileri.getInstance();
    }
    
    public boolean havaleYapildiMi()
    {
       if(bilgilerGecerliMi())
       {
           String query="UPDATE kullanici_bakiye "
                   + " SET bakiye = bakiye - '"+this.havaleMiktari+"' "
                   + " WHERE kullanici_id = '"+this.getHesapBilgileri().getKullanici_id()+"'";
           String query2=("UPDATE kullanici_bakiye "
                   + " SET bakiye = bakiye + '"+this.havaleMiktari+"'"
                   + " WHERE musteri_no = '"+this.havaleAlacakKisi+"'");
           try {
               super.statement=super.connection.createStatement();
               if(statement.executeUpdate(query2)==1)
                {
                  statement.executeUpdate(query);
                  getHesapBilgileri().setBakiye(getHesapBilgileri().getBakiye() - this.havaleMiktari);
                  
                    return true;
                }else
               {
                   return false;
               }
           
           } catch (SQLException ex) {
               Logger.getLogger(Havale.class.getName()).log(Level.SEVERE, null, ex);
               return false;
           }
           
       }
       else
       {
           return false;
       }
    }
}
