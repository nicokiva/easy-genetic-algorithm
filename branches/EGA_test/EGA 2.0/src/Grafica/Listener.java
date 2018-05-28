/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafica;

import Clase.Principal.EGA;
import Grafica.Enum.Tipo;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
/**
 *
 * @author Triton
 */

public class Listener implements ActionListener
{

    public void actionPerformed (ActionEvent e)
    {
        JToggleButton btnPausa = new JToggleButton();
        JButton btnSalir;
        JComboBox cmbCombo;
        JSlider sldGrafica;
        Object item;
        Integer iCantidad;
        Tipo TipoGrafica;

        
        Object fuente = e.getSource();
        
        switch (e.getActionCommand())
        {
            case "Pausar":
            
            btnPausa = (JToggleButton)fuente;
            btnPausa.setText("Reanudar");
            break;

            case "Reanudar":
            
            btnPausa = (JToggleButton)fuente;
            btnPausa.setText("Pausar");
            break;    
                
            case "Salir":
            
            btnSalir = (JButton)fuente;
            //EGA.ControlGlobal.Grafica = null;
            break; 
                

            case "comboBoxChanged":
            
            cmbCombo=(JComboBox)fuente;
            item = cmbCombo.getSelectedItem();
            if ((item instanceof Integer) == true)
            {
                iCantidad = (Integer)item;
                EGA.ControlGlobal.Grafica.MostrarSubconjunto(iCantidad);
            }
            else
            {
                TipoGrafica = (Tipo)item;
                EGA.ControlGlobal.Grafica.Crear(TipoGrafica);
                EGA.ControlGlobal.Grafica.Refrescar();
            }
            break;

                
            case "sldGrafica":
            
            JOptionPane.showConfirmDialog(EGA.ControlGlobal.Grafica.Borrar, "No implementado.","EGA", 0);
            sldGrafica = (JSlider)fuente;
            break;
                
                
        } // switch (fuente.getClass().getName())
        
    } // FIN public void actionPerformed (ActionEvent e)
    
} // FIN CALSE LISTENER
