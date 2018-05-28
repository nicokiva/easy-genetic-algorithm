/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafica;

import Clase.Principal.EGA;
import Formularios.frmSolucion;
import Grafica.Enum.Tipo;
import java.awt.Container;
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
    
    private Grafica grafica;

    
    public Listener(Grafica grafica){
        this.grafica = grafica;
    }
    
    public void actionPerformed (ActionEvent e)
    {
        JToggleButton btnPausa = new JToggleButton();
        JButton btnSalir;
        JComboBox cmbCombo;
        JSlider sldGrafica;
        Object item;
        Integer iCantidad;
        Tipo TipoGrafica;
        Container padre;
        frmSolucion frmSol;

        
        Object fuente = e.getSource();
        
        switch (e.getActionCommand())
        {
            case "Pausar":
            
                btnPausa = (JToggleButton)fuente;
                btnPausa.setText("Reanudar");
                this.grafica.pausa();
                break;

            case "Reanudar":
            
                btnPausa = (JToggleButton)fuente;
                btnPausa.setText("Pausar");
                this.grafica.reanudacion();
                break;    
                
            case "Salir":
            
                btnSalir = (JButton)fuente;
                //EGA.ControlGlobal.Grafica = null;
                break; 
                
            case "comboBoxChanged":
                
                String sNombre;
                boolean reanudar = false;
                
                cmbCombo=(JComboBox)fuente;
                sNombre = cmbCombo.getName();
                item = cmbCombo.getSelectedItem();
                frmSol = this.grafica.getFrmSolucion();
                
                if (sNombre == "cmbPuntos")
                {
                    if ((item instanceof Integer) == true)
                    {
                        iCantidad = (Integer)item;
                        
                        if (frmSol.procesoActual.estaEjecutando()==true)
                        {
                            frmSol.pausarProceso();
                            reanudar = true;
                        }

                        frmSol.Grafica.MostrarSubconjunto(iCantidad);
                        
                        if (reanudar == true)
                            frmSol.reanudarProceso();
                    }
                    else if (item == "*.*")
                    {
                        iCantidad = -1;
                        frmSol.Grafica.MostrarSubconjunto(iCantidad);
                    }
                }
                else if (sNombre == "cmbTipoGrafica")
                {
                    TipoGrafica = (Tipo)item;
                    frmSol.Grafica.Crear(TipoGrafica);
                    frmSol.Grafica.Refrescar();
                }
                else if (sNombre == "cmbRetardo")
                {
                    frmSol.Sleep = (int)item;
                }
                    
                break;

                
            case "sldGrafica":
            
                //sldGrafica = (JSlider)fuente;
                break;
                
            default:
                    break;
        } // switch (fuente.getClass().getName())
        
    } // FIN public void actionPerformed (ActionEvent e)
    
} // FIN CALSE LISTENER.
