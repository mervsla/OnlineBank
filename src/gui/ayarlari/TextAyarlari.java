/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.ayarlari;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class TextAyarlari {
    private static String originalText;
    private static Color originalFgColor;
    private static int limit;
    private static int miktar;
    
    
    
    public static void checTheThextFocusGained(JTextField textField,String org,Color fgColor)
    {
        originalText=org;
       
        
        if(textField.getText().trim().equals(org))
        {
            originalFgColor=textField.getForeground();
            textField.setText("");
        }
        textField.setForeground(Color.BLACK);
            
        
    }
    
    public static void chechTheTextFocusLost(JTextField textField)
    {
        if (textField.getText().trim().equals(""))
        {
            textField.setText(originalText);
            textField.setForeground(originalFgColor);
        }
        else
        {
            textField.setForeground(Color.BLACK);
        }
    }
    
    public static void setOnlyNumber(JTextField textField)
    {
        textField.addKeyListener(new KeyAdapter() 
        {
            @Override
            public void keyTyped(KeyEvent e) {
                char c=e.getKeyChar();
                if(!Character.isDigit(c))
                {
                    e.consume();
                }
            }                    
        }   );
        
    }
      
        
        public static void setOnlyAlphabet(JTextField textField)
    {
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c=e.getKeyChar();
                if(!Character.isAlphabetic(c) && c != KeyEvent.VK_SPACE)
                {
                    e.consume();
                }
            }                                  
        });
    }
        
    
        public static void setMaxLimit(JTextField textField,int lim)
        {
            limit=lim;
            textField.setDocument(new PlainDocument()
            {
                @Override
                public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
                     if(str==null)
                     {
                         return;
                     }
                     if((getLength() + str.length()) <= limit)
                     {
                         super.insertString(offs, str, a);
                     }
                }    
            });
        }
        
        public static boolean uzunlukSundanKucukMu(int length,String str)
        {
            return (str.length() < length);
        }
   public static int checkTheKeyRelased(JTextField textField,int moneyLimit)
   {
               String text=textField.getText();
        if(!text.equals(""))
        {
            miktar=Integer.valueOf(text);
            if(miktar > moneyLimit)
            {
                miktar= moneyLimit;
                textField.setText(String.valueOf(miktar));
            }
            return miktar;
        }
        
        return 0;
   }
  
   public static boolean texAlanlariDolumu(JPanel panel)
   {
       Component[] components=panel.getComponents();
       for(Component c:components)
       {
           if(c instanceof JTextField)
           {
               JTextField textField=(JTextField)c;
               if(textField.getText().trim().equals("")&&textField.isEnabled())
               {
                   return false;
               }
               
           }
       }
        return true;
   }
   
   
}
