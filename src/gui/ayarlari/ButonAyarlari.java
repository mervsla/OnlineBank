/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.ayarlari;

import java.awt.Color;
import javax.swing.JButton;


public class ButonAyarlari {
    private static Color originalBgColor;
    private static Color originalFgColor;
    
    public static void setBg(JButton button,Color bgColor,Color fgColor)
    {
        originalBgColor=button.getBackground();
        originalFgColor=button.getForeground();
        button.setBackground(bgColor);
        button.setForeground(fgColor);
    }
    
    public static void setOriginalBg(JButton button)
    {
       button.setBackground(originalBgColor);
       button.setForeground(originalFgColor);
       
    }
}
