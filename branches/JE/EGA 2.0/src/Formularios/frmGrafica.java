/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;


import Clase.Principal.EGA;
import Grafica.Enum.Tipo;
import Grafica.Grafica;
import javax.swing.JInternalFrame;
import javax.swing.JButton;
import javax.swing.JComboBox;
/**
 *
 * @author Triton
 */
public class frmGrafica extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmGrafica
     */
    
    public frmGrafica() {
    
        boolean a;
        boolean b;
        boolean c;
        //initComponents();
        
        a = EGA.ControlGlobal.Grafica.FrameClosable;
        b = EGA.ControlGlobal.Grafica.FrameMaximizable;
        c = EGA.ControlGlobal.Grafica.FrameResizable;
        
        EGA.ControlGlobal.Grafica.Crear(EGA.ControlGlobal.Grafica.TipoGrafica);
        EGA.ControlGlobal.Grafica.AdaptarForm(this, a, b, c);
        
        
        // borrar esto cuando el slider funcione.
        EGA.ControlGlobal.Grafica.Borrar = this;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFreeChartResources1 = new org.jfree.chart.resources.JFreeChartResources();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("EGA - Gráfica de Convergencia.");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ICON.png"))); // NOI18N
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jfree.chart.resources.JFreeChartResources jFreeChartResources1;
    // End of variables declaration//GEN-END:variables
}
