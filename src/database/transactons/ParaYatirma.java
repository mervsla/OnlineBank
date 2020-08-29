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


public class ParaYatirma extends DbConnection implements IBilgiController{

    private int yatirilacaMiktar=0;

    public int getYatirilacaMiktar() {
        return yatirilacaMiktar;
    }

    public void setYatirilacaMiktar(int yatirilacaMiktar) {
        this.yatirilacaMiktar = yatirilacaMiktar;
    }
    
    @Override
    public boolean bilgilerGecerliMi() {
         return !(this.yatirilacaMiktar==0);
    }

    @Override
    public HesapBilgileri getHesapBilgileri() {
      return HesapBilgileri.getInstance();
    }
    public boolean paraYatirildiMi()
    {
        if(bilgilerGecerliMi())
        {
            String query="UPDATE kullanici_bakiye "
                    + "SET bakiye = bakiye + '"+this.yatirilacaMiktar+"'"
                    + " WHERE kullanici_id = '"+this.getHesapBilgileri().getKullanici_id()+"'";
            
            try {
                super.statement=super.connection.createStatement();
                statement.executeUpdate(query);
                
                getHesapBilgileri().setBakiye(getHesapBilgileri().getBakiye() + yatirilacaMiktar);
 
            } catch (SQLException ex) {
                Logger.getLogger(ParaYatirma.class.getName()).log(Level.SEVERE, null, ex);
            }
            return true;
        }else
        {
            return false;
        }
        
    }
    
    
}
