        
package Clase.Principal;

import Formularios.FrmInstalador;


public class EGA 
{
    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) 
    {
        
        FrmInstalador frmInstalador = new FrmInstalador();
        frmInstalador.setLocationRelativeTo(null); 
        frmInstalador.setVisible(true);

        if (frmInstalador.ExisteInstalacion() == true)
        {
            frmInstalador.MostrarDesinstalar(true);
        }
        else
        {
            frmInstalador.MostrarDesinstalar(false);
        }
        
        frmInstalador.DetectarEquipo();
                
    }
    
}
