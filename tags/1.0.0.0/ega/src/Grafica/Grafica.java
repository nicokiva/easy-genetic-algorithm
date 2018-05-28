/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafica;

import Formularios.frmSolucion;
import Grafica.Enum.*;
import javax.swing.JInternalFrame;
import java.util.ArrayList;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.Dimension;
import javax.swing.JSlider;
import javax.swing.JToggleButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.Iterator;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset; 
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.axis.NumberAxis;
/**
 *
 * @author Triton
 */

public class Grafica 
{

    // Constructores
    public Grafica( frmSolucion frmSol) 
    {
        Etiqueta1 = Etiqueta.Mínima;
        Etiqueta2 = Etiqueta.Media;
        Etiqueta3 = Etiqueta.Máxima;
        iEjeX = 0;
        FrameClosable = true;
        FrameMaximizable = true;
        FrameResizable = true;
        CantidadSubConjuntoMaximo = 500;
        MaximoVisualizable = 1000;
        
        if (frmSol.Grafica == null)
        {
            TipoGrafica = Tipo.LineChart3D;
            CantidadSubConjunto = 40;
        }
        else
        {
            if (frmSol.Grafica.TipoGrafica == null)
            {
                TipoGrafica = Tipo.LineChart3D;
            }
            else
            {
                TipoGrafica = frmSol.Grafica.TipoGrafica;
            }
            CantidadSubConjunto = frmSol.Grafica.CantidadSubConjunto;
        }        
        this.frmSolucion=frmSol;
       
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
        CantidadSubConjunto = 40;
        CantidadSubConjuntoMaximo = 500;
        MaximoVisualizable = 1000;
        TipoGrafica = Tipo.LineChart3D;
        
    }
    
   
    // Atributos
    public String Titulo;
    public String NombreEjeX;
    public String NombreEjeY;
    public boolean FrameClosable;
    public boolean FrameResizable;
    public boolean FrameMaximizable;
    public ChartPanel PanelGrafico;
    public Tipo TipoGrafica;
    private int Sleep = 0;
    
    private JInternalFrame Frame;
    private Etiqueta Etiqueta1;
    private Etiqueta Etiqueta2;
    private Etiqueta Etiqueta3;
    private Integer iEjeX;
    private DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    private ArrayList<Integer> iValor1 = new ArrayList<>();
    private ArrayList<Integer> iValor2 = new ArrayList<>();
    private ArrayList<Integer> iValor3 = new ArrayList<>();
    
    private Integer CantidadSubConjunto;
    private Integer CantidadSubConjuntoMaximo;
    private Integer MaximoVisualizable;
    private JFreeChart Grafica;
    private  frmSolucion frmSolucion;
    private JComboBox cmbRetardo = new JComboBox();
    

    public boolean esNueva() {
        boolean bool = false;
        
        if (this.iEjeX == 0)
            bool = true;
        
        return bool;
    }
    
    
    public int getSleep() {
        return Sleep;
    }

   public void setSleep(int ms) {
        Sleep = ms;
        this.cmbRetardo.setSelectedItem(ms);
    }

    public frmSolucion getFrmSolucion() {
        return frmSolucion;
    }

    public void setFrmSolucion(frmSolucion frmSolucion) {
        this.frmSolucion = frmSolucion;
    }
    
///////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////

    public void MostrarPunto( int Valor )
    {
        this.iValor1.add(iEjeX, Valor);
        
        iEjeX++;
        this.dataset.setValue(Valor, this.Etiqueta1.toString(), iEjeX.toString());
        
    }

///////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////
  
    public void MostrarPunto( int Valor_1, int Valor_2 )
    {

        this.iValor1.add(iEjeX, Valor_1);
        this.iValor2.add(iEjeX, Valor_2);

        iEjeX++;
        this.dataset.setValue(Valor_1, this.Etiqueta1.toString(), iEjeX.toString());
        this.dataset.setValue(Valor_2, this.Etiqueta2.toString(), iEjeX.toString());

    }

    
///////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////
    
    public void MostrarPunto( int Valor_1, int Valor_2, int Valor_3 )
    {
        int k;
        int q;
        Comparable key;
        
//System.out.println("***************  E N T R A D A  ******************* ");
//System.out.println("Valor_1 = " + Valor_1 + "     Valor_2 = " + Valor_2 + "Valor_3 = " + Valor_3);

  //      System.out.print("   ArrayList.add() .... "); 
        
        this.iValor1.add(iEjeX, new Integer(Valor_1));
        this.iValor2.add(iEjeX, new Integer(Valor_2));
        this.iValor3.add(iEjeX, new Integer(Valor_3));

 //       System.out.print("OK\n");        
  
        iEjeX++;
        
  //      System.out.print("   datase.setvalue() .. ");        
        this.dataset.setValue((Number)Valor_1, this.Etiqueta1.toString(), iEjeX);
        this.dataset.setValue((Number)Valor_2, this.Etiqueta2.toString(), iEjeX);
        this.dataset.setValue((Number)Valor_3, this.Etiqueta3.toString(), iEjeX);
  //      System.out.print("OK\n");        
       
        
        // SI ELIGICIO MOSTAR TODOS LOS PUNTOS, QUE SALGA SIN QUITAR NINGUNO
        if (this.CantidadSubConjunto == -1 ) 
            return;
        
        // me aseguro de que hayan más en data set que lo que puedo mostrar, 
        // de modo de poder sacar el primero, sin riesgo a error.
        q = this.dataset.getColumnCount();
        k = q - this.CantidadSubConjunto.intValue();
        if ( k > 0 )
        {
           // try
            //{
                
              /*
                List <Comparable> Keys;
                System.out.println("\n\nCONSULTANDO LA LISTA....  ");
                Keys = this.dataset.getColumnKeys();
                System.out.print("REALES = ");
                for (Comparable c: Keys)
                {
                    System.out.print(" " + c.toString());
                }
                
                //key = this.dataset.getColumnKey(0);
                //System.out.println("\nBORRANDO CLAVE... " + key.toString());
                System.out.println("\nBORRANDO INDICE 0 ... ");
                */
                this.dataset.removeColumn(0);
                //System.out.println("OK !!");
                
            //}
            //catch (Exception e)
            //{
            //    System.out.println("[ Error ]: Grafica.MostrarPunto() -> this.dataset.removeColumn(key) ");
            //}
            
            
        }

//System.out.println("***************  S A L I D A  ********************* ");        
    
/*
    }
    catch (Exception e)
    {
        System.out.println("[ Error ]: Grafica.MostrarPunto() -> this.dataset.removeColumn(key) ");
        e.printStackTrace();
    }
*/
    } // FIN MostrarPunto();

    
///////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////
  
    public void MostrarSubconjunto (int Puntos)
    {
        int x;
        int k; 
        int q;
        int ValEjeX = this.iEjeX.intValue();
        Integer columna;
        Number nValor1;
        Number nValor2;
        Number nValor3;


        this.CantidadSubConjunto = new Integer(Puntos);
        
        // si no existen valores para mostrar, me voy.
        if (this.iValor1.size() == 0 )
            return;
        
        this.Limpiar();

        k = ValEjeX - this.CantidadSubConjunto.intValue();
        if (k <= 0)
        {
            k = 1; // si definió una ventana mayor a la cantidad total de puntos existentes, entonces muestro todo comenzando desde 1.
        }
        
        try
        {
            q = k;
            for (k=q; k < ValEjeX; k++)
            {
                columna = new Integer(k + 1);
                nValor1 = (Number)(this.iValor1.get(k).intValue());
                nValor2 = (Number)(this.iValor2.get(k).intValue());
                nValor3 = (Number)(this.iValor3.get(k).intValue());

                this.dataset.setValue(nValor1, this.Etiqueta1.toString(), columna);
                this.dataset.setValue(nValor2, this.Etiqueta2.toString(), columna);
                this.dataset.setValue(nValor3, this.Etiqueta3.toString(), columna);
            }
        }
        catch(Exception e)
        {
            System.out.println("\n[ Error ]: Grafica.MostrarSubconjunto()");
        }


    } // FIN MostrarSubconjunto()
    

///////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////
    
    public void MostrarFuncion( int Valor[], Etiqueta Funcion )
    {
        for (int i: Valor)
        {
            iEjeX++;
            this.dataset.setValue(i, Funcion.toString(), iEjeX.toString() );        
        }
    }
    

///////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////
    
    public void Limpiar()
    {
        this.dataset.clear();
    }

    
///////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////
    
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
        
        Color COLOR_LINEAS_GRAFICA = new Color(31, 87, 4);
        CategoryPlot plot = this.Grafica.getCategoryPlot();
        plot.setDomainGridlinePaint(COLOR_LINEAS_GRAFICA);
        plot.setRangeGridlinePaint(COLOR_LINEAS_GRAFICA);
        plot.setBackgroundPaint(Color.white);
        
        // esto funciona, pero no tiene sentido limitar el raqngo automáticamente acá.
        //NumberAxis rangeAxis = (NumberAxis)plot.getRangeAxis();
        //rangeAxis.setRange(79000, 88000);
        
    }

    
///////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////
   
    public void AdaptarForm (JInternalFrame frm, boolean Closable, boolean resizable, boolean maximizable)
    {
        JPanel panNorte = new JPanel();
        JPanel panSur = new JPanel();
        JPanel panSur1 = new JPanel();
        JPanel panSur2 = new JPanel();
        JButton btnSalir = new JButton();
        JToggleButton btnPausa = new JToggleButton();
        JComboBox cmbTipoGrafica = new JComboBox();
        JComboBox cmbPuntos = new JComboBox();
        JSlider sldGrafica = new JSlider();
        Listener listener = new Listener(this);
        JLabel lblPuntos = new JLabel("Puntos ->");
        JLabel lblRetardo = new JLabel(" <- Retardo (ms)");
        
        
        
        //ChangeListener changeListener = new ChangeListener();
        
        this.PanelGrafico = new ChartPanel(this.Grafica);
        this.Frame = frm;
        
        //cmbCantidad.addItem("*.*");
        for (int i = 1; i<this.MaximoVisualizable+1; i++)
        {
            cmbPuntos.addItem(i);
        }

        for (int i = 0; i<=1000; i++)
        {
            cmbRetardo.addItem(i);
        }
     
        cmbPuntos.setSelectedItem(this.CantidadSubConjunto);
        cmbRetardo.setSelectedItem(this.Sleep);
        
        for (Tipo T: Tipo.values()) {cmbTipoGrafica.addItem(T);}
        cmbTipoGrafica.setSelectedItem(this.TipoGrafica);
        
        
        panSur1.setBackground(Color.WHITE);
        sldGrafica.setPaintTrack(false);
        //sldGrafica.setBackground(Color.LIGHT_GRAY);
        panSur1.add(sldGrafica);
        panSur2.add(lblPuntos);
        panSur2.add(cmbPuntos);
        panSur2.add(cmbTipoGrafica);
        panSur2.add(cmbRetardo);
        panSur2.add(lblRetardo);
        
        //panSur2.add(btnPausa);
        //panSur2.add(btnSalir);
        panSur.setLayout(new BorderLayout());
        //panSur.add(panSur1, BorderLayout.NORTH);
        panSur.add(panSur2,BorderLayout.SOUTH);
        btnSalir.setText("Salir");
        btnPausa.setText("Pausar");
        btnPausa.setFont(new java.awt.Font(Font.SANS_SERIF, 0, 12));
        btnSalir.setFont(new java.awt.Font(Font.SANS_SERIF, 0, 12));
        cmbTipoGrafica.setFont(new java.awt.Font(Font.SANS_SERIF, 0, 12));
        cmbPuntos.setFont(new java.awt.Font(Font.SANS_SERIF, 0, 12));
        cmbRetardo.setFont(new java.awt.Font(Font.SANS_SERIF, 0, 12));
        lblPuntos.setFont(new java.awt.Font(Font.MONOSPACED, 0, 12));
        lblRetardo.setFont(new java.awt.Font(Font.MONOSPACED, 0, 12));
        cmbPuntos.setName("cmbPuntos");
        cmbRetardo.setName("cmbRetardo");
        cmbTipoGrafica.setName("cmbTipoGrafica");
       
        //btnSalir.addActionListener(listener);
        btnPausa.addActionListener(listener);
        cmbPuntos.addActionListener(listener);
        cmbTipoGrafica.addActionListener(listener);
        cmbRetardo.addActionListener(listener);
        
        
        // no se puede, no existe import javax.swing.Event !!!!
        //sldGrafica.addChangeListener(changeListener);
        

        frm.getContentPane().setLayout(new BorderLayout());
        frm.getContentPane().add(panNorte, BorderLayout.NORTH, 0);
        frm.getContentPane().add(this.PanelGrafico, BorderLayout.CENTER, 1);
        frm.getContentPane().add(panSur, BorderLayout.SOUTH, 2);        

        
        frm.pack();
        frm.setClosable(Closable);
        frm.setResizable(resizable);
        frm.setMaximizable(maximizable);

    }
    
///////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////
    
    public void Refrescar()
    {
        this.Frame.getContentPane().remove(1);
        this.PanelGrafico = new ChartPanel(this.Grafica);
        this.Frame.getContentPane().add(this.PanelGrafico, BorderLayout.CENTER, 1);
        //EGA.ControlGlobal.Grafica.PanelGrafico
        this.Frame.setVisible(false);
        this.Frame.setVisible(true);
        //this.Frame.repaint();
        //this.PanelGrafico.repaint();

    }
        
///////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////
   
    public java.awt.Image crearImagen(int iAncho, int iAlto, Tipo TipoGrafica, String sEjeX, String sEjeY, int iValores1[], int iValores2[], int iValores3[] )
    {
        JFreeChart jGrafica = null;
        Integer iEje = 0;
        int iMIN = 2147483647; // el máximo valor poisble del tipo int
        int iMAX = -2147483648 ; // el mínimo valor poisble del tipo int

        for (int i: iValores1)
        {
            if (iValores1[iEje]==0 && iValores2[iEje]==0 && iValores3[iEje]==0)
                break;
            
            iEje++;
            this.dataset.setValue(i, this.Etiqueta1.toString(), iEje.toString() );
            if (i < iMIN)
            {
                iMIN = i;
            }
            if (i > iMAX)
            {
                iMAX = i;
            }
        }

        iEje = 0;
        for (int i: iValores2)
        {
           if (iValores1[iEje]==0 && iValores2[iEje]==0 && iValores3[iEje]==0)
                break;

            iEje++;
            this.dataset.setValue(i, this.Etiqueta2.toString(), iEje.toString() );        
            if (i < iMIN)
            {
                iMIN = i;
            }
            if (i > iMAX)
            {
                iMAX = i;
            }
        }

        iEje = 0;
        for (int i: iValores3)
        {
            if (iValores1[iEje]==0 && iValores2[iEje]==0 && iValores3[iEje]==0)
                break;
            
            iEje++;
            this.dataset.setValue(i, this.Etiqueta3.toString(), iEje.toString() );        
            if (i < iMIN)
            {
                iMIN = i;
            }
            if (i > iMAX)
            {
                iMAX = i;
            }
        }


        switch (TipoGrafica)
        {
            case AreaChart:
            jGrafica = ChartFactory.createAreaChart(null, sEjeX, sEjeY, 
                       this.dataset, PlotOrientation.VERTICAL, true, true, false);
            break;

            case BarChart:
            jGrafica = ChartFactory.createBarChart(null, sEjeX, sEjeY, 
                       this.dataset, PlotOrientation.VERTICAL, true, true, false);
            break;

            case BarChart3D:
            jGrafica = ChartFactory.createBarChart3D(null, sEjeX, sEjeY, 
                       this.dataset, PlotOrientation.VERTICAL, true, true, false);
            break;

            case LineChart:
            jGrafica = ChartFactory.createLineChart(null, sEjeX, sEjeY, 
                       this.dataset, PlotOrientation.VERTICAL, true, true, false);
            break;

            case LineChart3D:
            jGrafica = ChartFactory.createLineChart3D(null, sEjeX, sEjeY, 
                       this.dataset, PlotOrientation.VERTICAL, true, true, false);
            break;

        }

        //jGrafica.setBackgroundPaint(Color.GREEN);
        Color COLOR_LINEAS_GRAFICA = new Color(31, 87, 4);
        CategoryPlot plot = jGrafica.getCategoryPlot();
        plot.setBackgroundPaint(Color.white);
        plot.setDomainGridlinePaint(COLOR_LINEAS_GRAFICA);
        plot.setRangeGridlinePaint(COLOR_LINEAS_GRAFICA);
        
       NumberAxis rangeAxis = (NumberAxis)plot.getRangeAxis();
       rangeAxis.setRange(iMIN, iMAX);
        
       return jGrafica.createBufferedImage(iAncho, iAlto);
    }    


///////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////
    
    // devuelve un vector que contiene otros 3 vectores. Cada uno
    // contiene los ultimos 10 valores de su serie, independientemente
    // de cuántos de esos 10 se esten mstrando en pantalla.
    public ArrayList<Integer>[] TraerSubconjuntoCompleto()
    {
        ArrayList valores[] = new ArrayList[3];
        ArrayList<Integer> minima = new ArrayList<>();
        ArrayList<Integer> media = new ArrayList<>();
        ArrayList<Integer> maxima = new ArrayList<>();
        int k = 0;


        if (this.iValor1.size() > this.CantidadSubConjuntoMaximo)
        {
            k = this.iValor1.size() - this.CantidadSubConjuntoMaximo;
        }

        for(int i = k; i < this.iValor1.size(); i++)
        {
            minima.add(this.iValor1.get(i));
            media.add(this.iValor2.get(i));
            maxima.add(this.iValor3.get(i));
        }

        valores[0] = minima;
        valores[1] = media;
        valores[2] = maxima;

/*        
        // BORRAR ESTO DESPUES DE UQE NICO GUARDE BIEN EN EL XML...
        for(int i = 0; i < 5; i++)
        {
            minima.add((i+1)*5);
            media.add((i+1)*7);
            maxima.add((i+1)*10);
        }
 */      
        return valores;
    }

///////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////

    void pausa() {
        this.frmSolucion.pausarProceso();
    }

    void reanudacion() {
        this.frmSolucion.reanudarProceso();
    }
    
    
}// FIN CLASE GRAFICA
