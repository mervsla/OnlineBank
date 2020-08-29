
package database.transactons;

import database.DbConnection;
import database.IBilgiController;
import gui.ayarlari.TextAyarlari;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class TelNoYenile extends DbConnection implements IBilgiController{

    private String telNo=null;
    
    public boolean TelNoYenilendiMi()
    {
        if(bilgilerGecerliMi())
        {
            String query="UPDATE kullanicilar "
                    + " SET tel_no = '"+this.telNo+"' "
                    + " WHERE kullanici_id = '" + getHesapBilgileri().getKullanici_id()+ "'";
            try {
                super.statement=super.connection.createStatement();
                statement.executeUpdate(query);
                getHesapBilgileri().setTelNo(this.telNo);
            } catch (SQLException ex) {
                Logger.getLogger(TelNoYenile.class.getName()).log(Level.SEVERE, null, ex);
            }
            return true;
        }else{
            return false;
        }
    }
            
    @Override
    public boolean bilgilerGecerliMi() {
     return !(telNo==null
             || TextAyarlari.uzunlukSundanKucukMu(11, telNo));
    }

    @Override
    public HesapBilgileri getHesapBilgileri() {
    return HesapBilgileri.getInstance();
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }
    
    
    
}
