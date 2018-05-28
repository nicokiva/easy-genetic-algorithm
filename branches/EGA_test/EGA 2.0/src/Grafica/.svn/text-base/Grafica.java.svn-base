/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafica;

import Clase.Principal.EGA;
import Grafica.Enum.*;
import javax.swing.JInternalFrame;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JSlider;
import javax.swing.JToggleButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset; 
import org.jfree.chart.plot.PlotOrientation;


//import java.util.ResourceBundle;
//import javax.swing.JDesktopPane;
//import java.awt.Dimension;

//import java.awt.Color;
//import javax.swing.JPanel;
//import org.jfree.chart.axis.NumberAxis;
//import org.jfree.chart.plot.XYPlot;
//import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
//import org.jfree.data.xy.XYDataset;
//import org.jfree.data.xy.XYSeries;
//import org.jfree.data.xy.XYSeriesCollection;
//import org.jfree.ui.ApplicationFrame;
//import org.jfree.ui.RectangleInsets;
//import org.jfree.ui.RefineryUtilities;
//import org.jfree.chart.axis.Axis;
//import org.jfree.chart.ChartUtilities; 
//import org.jfree.data.category.CategoryDataset; 
//import org.jfree.util.TableOrder; 

/**
 *
 * @author Triton
 */
    // Tipos Enumerados accesibles


public class Grafica 
{

    // Constructores
    public Grafica( ) 
    {
        Etiqueta1 = Etiqueta.Mínima;
        Etiqueta2 = Etiqueta.Media;
        Etiqueta3 = Etiqueta.Máxima;
        iEjeX = 0;
        FrameClosable = true;
        FrameMaximizable = true;
        FrameResizable = true;
        CantidadSubConjunto = 10;
        TipoGrafica = Tipo.BarChart3D;
       
    }
    
    public Grafica(Etiqueta Etiqueta_1, Etiqueta Etiqueta_2, Etiqueta Etiqueta_3) 
    {
        Etiqueta1 = Etiqueta_1;
        Etiqueta2 = Etiqueta_2;
        Etiqueta3 = Etiqueta_3;
        iEjeX = 0;
        FrameClosable = true;
        FrameMaximizable = true;
        FrameResizable = true;
        CantidadSubConjunto = 10;
        TipoGrafica = Tipo.BarChart3D;
        
    }
    
   
    // Atributos
    public JInternalFrame Borrar; // esto borrarlo a la mierda junto con su seteo en frmGrafica y su mensaje en listener.
    
    public String Titulo;
    public String NombreEjeX;
    public String NombreEjeY;
    public boolean FrameClosable;
    public boolean FrameResizable;
    public boolean FrameMaximizable;
    public ChartPanel PanelGrafico;
    public Tipo TipoGrafica;
    
    private JInternalFrame Frame;
    private Etiqueta Etiqueta1;
    private Etiqueta Etiqueta2;
    private Etiqueta Etiqueta3;
    private Integer iEjeX;
    private DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    private ArrayList<Integer> iValor1 = new ArrayList();
    private ArrayList<Integer> iValor2 = new ArrayList();
    private ArrayList<Integer> iValor3 = new ArrayList();
    
    private Integer CantidadSubConjunto;
    private JFreeChart Grafica;

    
    // Métodos
    public void MostrarPunto( int Valor )
    {
        this.iValor1.add(iEjeX, Valor);
        
        iEjeX++;
        this.dataset.setValue(Valor, this.Etiqueta1.toString(), iEjeX.toString());
        
    }

    
    public void MostrarPunto( int Valor_1, int Valor_2 )
    {

        this.iValor1.add(iEjeX, Valor_1);
        this.iValor2.add(iEjeX, Valor_2);

        iEjeX++;
        this.dataset.setValue(Valor_1, this.Etiqueta1.toString(), iEjeX.toString());
        this.dataset.setValue(Valor_2, this.Etiqueta2.toString(), iEjeX.toString());

    }

    public void MostrarPunto( int Valor_1, int Valor_2, int Valor_3 )
    {
        Integer k = 0;
        
        this.iValor1.add(iEjeX, Valor_1);
        this.iValor2.add(iEjeX, Valor_2);
        this.iValor3.add(iEjeX, Valor_3);

        iEjeX++;
        this.dataset.setValue(Valor_1, this.Etiqueta1.toString(), iEjeX.toString());
        this.dataset.setValue(Valor_2, this.Etiqueta2.toString(), iEjeX.toString());
        this.dataset.setValue(Valor_3, this.Etiqueta3.toString(), iEjeX.toString());
        
        k = iEjeX - this.CantidadSubConjunto;
        if (k > 0)
            this.dataset.removeColumn(k.toString());
    }
    

    public void MostrarFuncion( int Valor[], Etiqueta Funcion )
    {
        for (int i: Valor)
        {
            iEjeX++;
            this.dataset.setValue(i, Funcion.toString(), iEjeX.toString() );        
        }
    }
    
    
    public void Limpiar()
    {
        this.dataset.clear();
    }
    
    
    public void Crear (Tipo tipo)
    {
        
        this.TipoGrafica= tipo;
        
        switch (tipo)
        {
            case AreaChart:
            this.Grafica = ChartFactory.createAreaChart(this.Titulo, this.NombreEjeX,
            this.NombreEjeY, this.dataset, PlotOrientation.VERTICAL, true, true, false);
            break;
                
            case BarChart:
            this.Grafica = ChartFactory.createBarChart(this.Titulo, this.NombreEjeX,
            this.NombreEjeY, this.dataset, PlotOrientation.VERTICAL, true, true, false);
            break;

            case BarChart3D:
            this.Grafica = ChartFactory.createBarChart3D(this.Titulo, this.NombreEjeX,
            this.NombreEjeY, this.dataset, PlotOrientation.VERTICAL, true, true, false);
            break;

            case LineChart:
            this.Grafica = ChartFactory.createLineChart(this.Titulo, this.NombreEjeX,
            this.NombreEjeY, this.dataset, PlotOrientation.VERTICAL, true, true, false);
            break;

            case LineChart3D:
            this.Grafica = ChartFactory.createLineChart3D(this.Titulo, this.NombreEjeX,
            this.NombreEjeY, this.dataset, PlotOrientation.VERTICAL, true, true, false);
            break;
              
        }

    }
    
    
    
    public void AdaptarForm (JInternalFrame frm, boolean Closable, boolean resizable, boolean maximizable)
    {
        JPanel panNorte = new JPanel();
        JPanel panSur = new JPanel();
        JPanel panSur1 = new JPanel();
        JPanel panSur2 = new JPanel();
        JButton btnSalir = new JButton();
        JToggleButton btnPausa = new JToggleButton();
        JComboBox cmbTipoGrafica = new JComboBox();
        JComboBox cmbCantidad = new JComboBox();
        JSlider sldGrafica = new JSlider();
        Listener listener = new Listener();
        //ChangeListener changeListener = new ChangeListener();
        
        this.PanelGrafico = new ChartPanel(this.Grafica);
        this.Frame = frm;
        
        for (int i = 1; i<11; i++)
        {
            cmbCantidad.addItem(i);
        }
        
        cmbCantidad.setSelectedItem(10);
        
        for (Tipo T: Tipo.values()) {cmbTipoGrafica.addItem(T);}
        cmbTipoGrafica.setSelectedItem(this.TipoGrafica);
        
        
        panSur1.setBackground(Color.WHITE);
        sldGrafica.setPaintTrack(false);
        //sldGrafica.setBackground(Color.LIGHT_GRAY);
        panSur1.add(sldGrafica);
        panSur2.add(cmbCantidad);
        panSur2.add(cmbTipoGrafica);
        panSur2.add(btnPausa);
        panSur2.add(btnSalir);
        panSur.setLayout(new BorderLayout());
        panSur.add(panSur1, BorderLayout.NORTH);
        panSur.add(panSur2,BorderLayout.SOUTH);
        btnSalir.setText("Salir");
        btnPausa.setText("Pausar");
        btnPausa.setFont(new java.awt.Font(Font.SANS_SERIF, 0, 12));
        btnSalir.setFont(new java.awt.Font(Font.SANS_SERIF, 0, 12));
        cmbTipoGrafica.setFont(new java.awt.Font(Font.SANS_SERIF, 0, 12));
        cmbCantidad.setFont(new java.awt.Font(Font.SANS_SERIF, 0, 12));
       
        btnSalir.addActionListener(listener);
        btnPausa.addActionListener(listener);
        cmbCantidad.addActionListener(listener);
        cmbTipoGrafica.addActionListener(listener);
        
        // no se puede, no existe import javax.swing.Event !!!!
        //sldGrafica.addChangeListener(changeListener);
        
        
       
        frm.getContentPane().setLayout(new BorderLayout());
        frm.getContentPane().add(panNorte, BorderLayout.NORTH, 0);
        frm.getContentPane().add(EGA.ControlGlobal.Grafica.PanelGrafico, BorderLayout.CENTER, 1);
        frm.getContentPane().add(panSur, BorderLayout.SOUTH, 2);        

        
        frm.pack();
        frm.setClosable(Closable);
        frm.setResizable(resizable);
        frm.setMaximizable(maximizable);

    }
    
    
    public void Refrescar()
    {
        this.Frame.getContentPane().remove(1);
        this.PanelGrafico = new ChartPanel(this.Grafica);
        this.Frame.getContentPane().add(EGA.ControlGlobal.Grafica.PanelGrafico, BorderLayout.CENTER, 1);
        
        this.Frame.setVisible(false);
        this.Frame.setVisible(true);
        //this.Frame.repaint();
        //this.PanelGrafico.repaint();

    }
    
    public void MostrarSubconjunto (int Cantidad)
    {
        Integer x;
        Integer k; 
        Integer q= this.iEjeX - Cantidad;
        
        this.Limpiar();
        this.CantidadSubConjunto = Cantidad;
        
        for (k=q; k < this.iEjeX; k++)
        {
            x = k+1;
            this.dataset.setValue(this.iValor1.get(k), this.Etiqueta1.toString(), x.toString());
            this.dataset.setValue(this.iValor2.get(k), this.Etiqueta2.toString(), x.toString());
            this.dataset.setValue(this.iValor3.get(k), this.Etiqueta3.toString(), x.toString());
        }
    }
    
}// FIN CLASE GRAFICA
