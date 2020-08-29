/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.ayarlari;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class Dialogs {
    
    public static void bosOlamazMesaji(JFrame frame)
    {
        JOptionPane.showMessageDialog(frame, "Tüm alanlar dolu olmalıdır!");
        
    }
    public static void ozelMesaj(JFrame  frame,String message)
    {
        JOptionPane.showMessageDialog(frame, message);
    }
    public static int onayMesajiGoster(JFrame frame,String message)
    {
        int optionType  = JOptionPane.YES_NO_OPTION;
        int selected=JOptionPane.showConfirmDialog(frame, message, "UYARI", optionType);
        if(optionType==selected)
        {
            return 1;
        }
        return 0;
    }
}
