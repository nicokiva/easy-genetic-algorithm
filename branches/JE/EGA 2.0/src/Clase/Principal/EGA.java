        
package Clase.Principal;

import Formularios.MDI;
import javax.swing.JFrame;



public class EGA 
{
    public static Control.Global ControlGlobal = new Control.Global();
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        
        ControlGlobal.frmMDI = new MDI();
        ControlGlobal.frmMDI.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        ControlGlobal.frmMDI.setVisible(true);
    }
}
