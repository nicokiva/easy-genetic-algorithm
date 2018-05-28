        
package Clase.Principal;

import Formularios.MDI;
import Formularios.frmSplash;
import configuration.Messages;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class EGA 
{
    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) 
    {
        
        MDI frmMDI = new MDI();
        frmMDI.setIconImage (new ImageIcon("system/res/mdi.png").getImage());
        EGA.showSplash();
        frmMDI.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        frmMDI.setVisible(true);
    }
    
    
    private static void showSplash(){
        
        
        frmSplash frm = new frmSplash();
        JLabel lbl = frm.Estado();
        frm.setLocationRelativeTo(null); 
        frm.setVisible(true);
        try {
            for (int i=0; i<5; i++)
            {
                Thread.sleep(500);
                lbl.setText(lbl.getText() + ".");
            }
        } catch (InterruptedException ex) {
            
        }
        frm.setVisible(false);
    
    }
    
  
}
