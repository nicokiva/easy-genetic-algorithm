/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clase.Principal;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.border.Border;
/**
 *
 * @author Triton
 */
public class ImagenFondo  implements Border  
{
    
    BufferedImage fondo;
    public ImagenFondo(){    
        try 
        {       
            URL url = new URL(getClass().getResource("/system/res/mdi_fondo.png").toString());
            fondo = ImageIO.read(url);
      
        } catch (IOException ex) {
            System.out.println("[ Error ]: -> " + ex.getMessage());
            //Logger.getLogger(ImagenFondo.class.getName()).log(Level.SEVERE, null, ex);
        }      
    }
    // sobreescribo los métodos de Border
    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height){     
        //centrado automático de la imagen 
        g.drawImage(fondo, (x + (width - fondo.getWidth())/2),(y + (height - fondo.getHeight())/2), null);
    }

    @Override
    public Insets getBorderInsets(Component c){
    return new Insets(0,0,0,0);
    }

    @Override
    public boolean isBorderOpaque(){
    return true;
    }

} // FIN class ImagenFondo
   
