/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import Presentacion.Auxiliares.*;
import Grafica.Enum.Tipo;
import Grafica.Grafica;
import Listeners.InternalFrameCloseListener;
import Methods.*;
import Presentacion.Auxiliares.Encriptador;
import Renderer.PersonalTableRenderer;
import Solutions.*;
import comp.Compilador;
import configuration.Messages;
import configuration.Paths;
import enums.Acciones;
import java.awt.Cursor;
import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRXmlDataSource;
import net.sf.jasperreports.engine.query.JRXPathQueryExecuterFactory;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.util.JRXmlUtils;
import net.sf.jasperreports.view.JasperViewer;
import org.codehaus.commons.compiler.CompileException;
import org.w3c.dom.Document;
import proceso.Proceso;
        
/**
 *
 * @author Triton
 */
public class frmSolucion extends javax.swing.JInternalFrame {

    private boolean canceled = false;
    private String path;
    private Integer _intID;
    private int intLoading = 1;
    private String pathInforme;
    private boolean finished = false;
    private String COMENZAR="Comenzar";
    private String FINALIZAR="Finalizar";
    private String PAUSAR="Pausar";
    private String REANUDAR="Reanudar";
    private int ULTIMO_NRO_PRUEBA;
    private String GRABAR_RESULTADOS="Grabar Resultados";
    private String VER_INFORME="Ver Informe";
    

    public int getIntLoading() {
        return intLoading;
    }

    public void setIntLoading(int intLoading) {
        this.intLoading = intLoading;
    }

    public ArrayList<MethodInCombo> getArrMethodsInCombo() {
        return arrMethodsInCombo;
    }

    public void setArrMethodsInCombo(ArrayList<MethodInCombo> arrMethodsInCombo) {
        this.arrMethodsInCombo = arrMethodsInCombo;
    }

    public ArrayList<comboBox> getjComboBoxes() {
        return jComboBoxes;
    }

    public void setjComboBoxes(ArrayList<comboBox> jComboBoxes) {
        this.jComboBoxes = jComboBoxes;
    }
    private boolean modified = false;
    private ArrayList<javax.swing.JInternalFrame> _arrMySon = new ArrayList<javax.swing.JInternalFrame>();
    private ArrayList<Method> arrMethods = new ArrayList<Method>();
    private ArrayList<MethodInCombo> arrMethodsInCombo;
    private ArrayList<ResourceInList> arrResourceInList = new ArrayList<ResourceInList>();
    private HashMap<JList, Integer> timesResultActioned = new HashMap<JList, Integer>();
    private ResourceInList selectedResource;
    public OperationResult result = new OperationResult();
    public static final Object[] ROW_VACIA = {,};
    MDI frmParent;
    Solution solution;
    Solution solucionCreada;
    String[] strParamsTableHeader = {"NOMBRE", "VALOR"};
    file_handler fh = new file_handler();
    Paths paths = new Paths();
    ArrayList<comboBox> jComboBoxes = new ArrayList<>();
    ArrayList<JTable> jTables = new ArrayList<>();
    public Proceso procesoActual;
    private boolean blnImport = false;
    public Grafica Grafica;
    public int Sleep = 500;

    private TimerManager timer;

    public frmSolucion(MDI frmParent, Integer intSolutionID) {
        this.startLoading();
        this._intID = intSolutionID;
        this.frmParent = frmParent;
        this.Grafica = null;
        initComponents();


        this.setFormObjects();
        this.resetFormObjects();
        this.addCombosListenerToCombos();

        this.loadMethodsFromDB();
        this.fillComboBoxes();

        this.finishLoading();
        this.PrepararGrafica();
        this.ModificarTablas();
        
        
        this.timer = new TimerManager(this.txtDuracion);
        
        InternalFrameCloseListener closeListener = new InternalFrameCloseListener();
        this.addInternalFrameListener (closeListener.getInternalFrameCloseListener());
        
        
    }

    public frmSolucion(MDI frmParent, Integer intSolutionID, String strPathSolutionToOpen, boolean blnImport) {
        this.startLoading();
        this._intID = intSolutionID;
        this.frmParent = frmParent;
        this.Grafica = null;
        this.blnImport = blnImport;
        initComponents();
        this.setFormObjects();
        this.resetFormObjects();
        this.addCombosListenerToCombos();

        this.loadMethodsFromDB(); //Cargo de BD
        this.openExistingSolution(strPathSolutionToOpen); //Abro solución (importo)
        this.fillComboBoxes(); //Renderizo
        this.setInControls();

        this.timer = new TimerManager(this.txtDuracion);
        this.PrepararGrafica();
        this.ModificarTablas();
        
        this.finishLoading();
        
        tblResultados.setDefaultRenderer(Object.class, new PersonalTableRenderer());
        
        InternalFrameCloseListener closeListener = new InternalFrameCloseListener();
        this.addInternalFrameListener (closeListener.getInternalFrameCloseListener());
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFCSave = new javax.swing.JFileChooser();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        panProceso = new javax.swing.JPanel();
        btnComenzar = new javax.swing.JButton();
        btnPausa = new javax.swing.JToggleButton();
        btnVerInformeInicio = new javax.swing.JButton();
        lblHoraInicio = new javax.swing.JLabel();
        txtHoraInicio = new javax.swing.JTextField();
        lblDuracion = new javax.swing.JLabel();
        txtDuracion = new javax.swing.JTextField();
        lblPoblacionActual = new javax.swing.JLabel();
        txtPoblacionActual = new javax.swing.JTextField();
        lblCiclos = new javax.swing.JLabel();
        txtCiclos = new javax.swing.JTextField();
        lblMutaciones = new javax.swing.JLabel();
        txtMutaciones = new javax.swing.JTextField();
        lblAptitudMedia = new javax.swing.JLabel();
        txtAptitudMedia = new javax.swing.JTextField();
        lblAptitudMaxima = new javax.swing.JLabel();
        txtAptitudMaxima = new javax.swing.JTextField();
        lblAptitudMinima = new javax.swing.JLabel();
        txtAptitudMinima = new javax.swing.JTextField();
        lblPoblacionActual1 = new javax.swing.JLabel();
        txtPoblacionInicial1 = new javax.swing.JTextField();
        btnPublicarInicio = new javax.swing.JButton();
        btnExportarInforme = new javax.swing.JButton();
        btnSalirInformes = new javax.swing.JButton();
        frmGraficaFija = new javax.swing.JInternalFrame();
        jPanel1 = new javax.swing.JPanel();
        panGeneralObligatorio = new javax.swing.JPanel();
        txtNombreObligatorio = new javax.swing.JTextField();
        lblUbicacionArchivoSolucion = new javax.swing.JLabel();
        txtUbicacionArchivoSolucion = new javax.swing.JTextField();
        lblNombreObligatorio = new javax.swing.JLabel();
        txtArchivoSolucion = new javax.swing.JTextField();
        lblArchivoSolucion = new javax.swing.JLabel();
        btnUbicacionArchivoSolucion = new javax.swing.JButton();
        lblAutor = new javax.swing.JLabel();
        txtAutor = new javax.swing.JTextField();
        panGeneralFecha = new javax.swing.JPanel();
        lblFechaCreacion = new javax.swing.JLabel();
        txtFechaCreacion = new javax.swing.JFormattedTextField();
        lblFechaModificacion = new javax.swing.JLabel();
        txtFechaModificacion = new javax.swing.JFormattedTextField();
        lblFechaCompletado = new javax.swing.JLabel();
        txtFechaCompletado = new javax.swing.JFormattedTextField();
        lblFechaEjecucion = new javax.swing.JLabel();
        txtFechaEjecucion = new javax.swing.JFormattedTextField();
        lblFechaPublicacion = new javax.swing.JLabel();
        txtFechaPublicacion = new javax.swing.JFormattedTextField();
        panGeneralObservacion = new javax.swing.JPanel();
        panSolucionDescripcion6 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jEditorPane6 = new javax.swing.JEditorPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtObservacionSolucion = new javax.swing.JEditorPane();
        panGeneralDescripcion = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcionSolucion = new javax.swing.JEditorPane();
        panOtrasOpciones = new javax.swing.JPanel();
        panSolucionDescripcion8 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jEditorPane8 = new javax.swing.JEditorPane();
        chkSoloLectura = new javax.swing.JCheckBox();
        txtAutor3 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        lblAutor3 = new javax.swing.JLabel();
        lblCarpetaPublica = new javax.swing.JLabel();
        txtCarpetaPublica = new javax.swing.JTextField();
        btnCarpetaPublica = new javax.swing.JButton();
        btnGuardarGeneral = new javax.swing.JButton();
        btnPublicarGeneral = new javax.swing.JButton();
        btnLimpiarGeneral = new javax.swing.JButton();
        btnExportarGeneral = new javax.swing.JButton();
        btnSalirGeneral = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        panOperador = new javax.swing.JPanel();
        panSeleccion = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnEditarSeleccion = new javax.swing.JButton();
        btnNuevoSeleccion = new javax.swing.JButton();
        btnAyudaSeleccion = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblSeleccion = new javax.swing.JTable();
        cmbSeleccion = new javax.swing.JComboBox();
        btnRefreshSeleccion = new javax.swing.JButton();
        panCruzamiento = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblCruzamiento = new javax.swing.JTable();
        btnEditarCruzamiento = new javax.swing.JButton();
        btnNuevoCruzamiento = new javax.swing.JButton();
        btnAyudaCruzamiento = new javax.swing.JButton();
        cmbCruzamiento = new javax.swing.JComboBox();
        btnRefreshCruzamiento = new javax.swing.JButton();
        panMutacion = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblMutacion = new javax.swing.JTable();
        btnEditarMutacion = new javax.swing.JButton();
        btnNuevoMutacion = new javax.swing.JButton();
        btnAyudaMutacion = new javax.swing.JButton();
        cmbMutacion = new javax.swing.JComboBox();
        btnRefreshMutacion = new javax.swing.JButton();
        panParada = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblParada = new javax.swing.JTable();
        btnEditarParada = new javax.swing.JButton();
        btnNuevoParada = new javax.swing.JButton();
        btnAyudaParada = new javax.swing.JButton();
        cmbParada = new javax.swing.JComboBox();
        btnRefreshParada = new javax.swing.JButton();
        panDatos = new javax.swing.JPanel();
        cmbDatos = new javax.swing.JComboBox();
        jLabel19 = new javax.swing.JLabel();
        btnEditarCargaDatos = new javax.swing.JButton();
        btnAyudaCargaDatos = new javax.swing.JButton();
        btnNuevoCargaDatos = new javax.swing.JButton();
        jScrollPane11 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        btnRefreshCargaDatos = new javax.swing.JButton();
        panCromosoma = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        btnEditarCromosoma = new javax.swing.JButton();
        btnAyudaCromosoma = new javax.swing.JButton();
        btnNuevoCromosoma = new javax.swing.JButton();
        cmbCromosoma = new javax.swing.JComboBox();
        jScrollPane10 = new javax.swing.JScrollPane();
        tblCromosoma = new javax.swing.JTable();
        btnRefreshCromosoma = new javax.swing.JButton();
        panAptitud = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        btnEditarAptitud = new javax.swing.JButton();
        btnAyudaAptitud = new javax.swing.JButton();
        btnNuevoAptitud = new javax.swing.JButton();
        cmbAptitud = new javax.swing.JComboBox();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblAptitud = new javax.swing.JTable();
        btnRefreshAptitud = new javax.swing.JButton();
        panConfiguracionVisualizacion = new javax.swing.JPanel();
        cmbMetodoResultado = new javax.swing.JComboBox();
        btnEditarMetodoResultado = new javax.swing.JButton();
        btnNuevoMetodoResultado = new javax.swing.JButton();
        btnAyudaMetodoResultado = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        tblResultados = new javax.swing.JTable();
        btnRefreshMetodoResultado = new javax.swing.JButton();
        btnSalirConfiguracion = new javax.swing.JButton();
        btnExportarConfiguracion = new javax.swing.JButton();
        btnPublicarConfiguracion = new javax.swing.JButton();
        btnGuardarConfiguracion = new javax.swing.JButton();
        btnLimpiarConfiguracion = new javax.swing.JButton();
        panConfiguracion = new javax.swing.JPanel();
        cmbCrecimientoPoblacion = new javax.swing.JComboBox();
        lblPoblacionInicial = new javax.swing.JLabel();
        txtPoblacionInicial = new javax.swing.JTextField();
        panConfiguracion1 = new javax.swing.JPanel();
        btnProbarConfiguracion = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblGanadores = new javax.swing.JLabel();
        lblListaArchivos = new javax.swing.JLabel();
        btnSalirResultados = new javax.swing.JButton();
        btnExportarResultados = new javax.swing.JButton();
        btnEliminarArchivo = new javax.swing.JButton();
        btnPublicarResultados = new javax.swing.JButton();
        jScrollPane15 = new javax.swing.JScrollPane();
        lstArchivos = new javax.swing.JList();
        btnVerInformeResultados = new javax.swing.JButton();
        jScrollPane13 = new javax.swing.JScrollPane();
        txtGanadores = new javax.swing.JTextArea();

        jFCSave.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setIconifiable(true);
        setTitle("EGA - Solución                                                                                                                                                                                                                                                                                      ");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/system/res/ICON.png"))); // NOI18N
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(1010, 670));
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }
        setVisible(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentRemoved(java.awt.event.ContainerEvent evt) {
                formComponentRemoved(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jTabbedPane1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                jTabbedPane1ComponentHidden(evt);
            }
        });

        jPanel4.setNextFocusableComponent(btnComenzar);
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panProceso.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Proceso", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 12), java.awt.Color.black)); // NOI18N
        panProceso.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        panProceso.setMaximumSize(new java.awt.Dimension(1000, 99));
        panProceso.setMinimumSize(new java.awt.Dimension(500, 99));
        panProceso.setPreferredSize(new java.awt.Dimension(960, 99));
        panProceso.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnComenzar.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnComenzar.setText("Comenzar");
        btnComenzar.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnComenzar.setMaximumSize(new java.awt.Dimension(90, 23));
        btnComenzar.setMinimumSize(new java.awt.Dimension(50, 23));
        btnComenzar.setNextFocusableComponent(btnPausa);
        btnComenzar.setPreferredSize(new java.awt.Dimension(79, 23));
        btnComenzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComenzarActionPerformed(evt);
            }
        });
        panProceso.add(btnComenzar, new org.netbeans.lib.awtextra.AbsoluteConstraints(836, 36, 130, 28));

        btnPausa.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnPausa.setText("Pausar");
        btnPausa.setEnabled(false);
        btnPausa.setName(""); // NOI18N
        btnPausa.setNextFocusableComponent(btnVerInformeInicio);
        btnPausa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPausaActionPerformed(evt);
            }
        });
        panProceso.add(btnPausa, new org.netbeans.lib.awtextra.AbsoluteConstraints(836, 68, 130, 28));

        btnVerInformeInicio.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnVerInformeInicio.setText(GRABAR_RESULTADOS);
        btnVerInformeInicio.setEnabled(false);
        btnVerInformeInicio.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnVerInformeInicio.setMaximumSize(new java.awt.Dimension(90, 23));
        btnVerInformeInicio.setMinimumSize(new java.awt.Dimension(50, 23));
        btnVerInformeInicio.setPreferredSize(new java.awt.Dimension(79, 23));
        btnVerInformeInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerInformeInicioActionPerformed(evt);
            }
        });
        panProceso.add(btnVerInformeInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(836, 102, 130, 28));

        lblHoraInicio.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblHoraInicio.setText("Hora de Inicio:");
        panProceso.add(lblHoraInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 20, 150, -1));

        txtHoraInicio.setEditable(false);
        txtHoraInicio.setBackground(new java.awt.Color(255, 255, 255));
        txtHoraInicio.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        txtHoraInicio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtHoraInicio.setText("- -:- -");
        txtHoraInicio.setAlignmentX(3.5F);
        txtHoraInicio.setFocusable(false);
        txtHoraInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHoraInicioActionPerformed(evt);
            }
        });
        panProceso.add(txtHoraInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 40, 150, -1));

        lblDuracion.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblDuracion.setText("Duración:");
        panProceso.add(lblDuracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 80, -1, -1));

        txtDuracion.setEditable(false);
        txtDuracion.setBackground(new java.awt.Color(255, 255, 255));
        txtDuracion.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        txtDuracion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDuracion.setText("00:45:21");
        txtDuracion.setFocusable(false);
        txtDuracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDuracionActionPerformed(evt);
            }
        });
        panProceso.add(txtDuracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 100, 150, -1));

        lblPoblacionActual.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblPoblacionActual.setText("Población Inicial:");
        panProceso.add(lblPoblacionActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 148, -1));

        txtPoblacionActual.setEditable(false);
        txtPoblacionActual.setBackground(new java.awt.Color(255, 255, 255));
        txtPoblacionActual.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        txtPoblacionActual.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPoblacionActual.setText("500");
        txtPoblacionActual.setAlignmentX(1.5F);
        txtPoblacionActual.setFocusable(false);
        txtPoblacionActual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPoblacionActualActionPerformed(evt);
            }
        });
        panProceso.add(txtPoblacionActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(182, 100, 150, -1));

        lblCiclos.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblCiclos.setText("Ciclos Procesados:");
        panProceso.add(lblCiclos, new org.netbeans.lib.awtextra.AbsoluteConstraints(348, 20, -1, -1));

        txtCiclos.setEditable(false);
        txtCiclos.setBackground(new java.awt.Color(255, 255, 255));
        txtCiclos.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        txtCiclos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCiclos.setText("1346");
        txtCiclos.setFocusable(false);
        txtCiclos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCiclosActionPerformed(evt);
            }
        });
        panProceso.add(txtCiclos, new org.netbeans.lib.awtextra.AbsoluteConstraints(348, 40, 150, -1));

        lblMutaciones.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblMutaciones.setText("Mutaciones:");
        panProceso.add(lblMutaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 80, -1, -1));

        txtMutaciones.setEditable(false);
        txtMutaciones.setBackground(new java.awt.Color(255, 255, 255));
        txtMutaciones.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        txtMutaciones.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMutaciones.setText("14");
        txtMutaciones.setAlignmentX(1.5F);
        txtMutaciones.setFocusable(false);
        txtMutaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMutacionesActionPerformed(evt);
            }
        });
        panProceso.add(txtMutaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 100, 150, -1));

        lblAptitudMedia.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblAptitudMedia.setText("Aptitud Media:");
        panProceso.add(lblAptitudMedia, new org.netbeans.lib.awtextra.AbsoluteConstraints(516, 80, -1, -1));

        txtAptitudMedia.setEditable(false);
        txtAptitudMedia.setBackground(new java.awt.Color(255, 255, 255));
        txtAptitudMedia.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        txtAptitudMedia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAptitudMedia.setText("99");
        txtAptitudMedia.setFocusable(false);
        txtAptitudMedia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAptitudMediaActionPerformed(evt);
            }
        });
        panProceso.add(txtAptitudMedia, new org.netbeans.lib.awtextra.AbsoluteConstraints(516, 100, 150, -1));

        lblAptitudMaxima.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblAptitudMaxima.setText("Aptitud Máxima:");
        panProceso.add(lblAptitudMaxima, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 20, 136, -1));

        txtAptitudMaxima.setEditable(false);
        txtAptitudMaxima.setBackground(new java.awt.Color(255, 255, 255));
        txtAptitudMaxima.setFont(new java.awt.Font("SansSerif", 0, 36)); // NOI18N
        txtAptitudMaxima.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAptitudMaxima.setText("2901");
        txtAptitudMaxima.setAlignmentX(1.5F);
        txtAptitudMaxima.setFocusable(false);
        panProceso.add(txtAptitudMaxima, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 38, 134, 94));

        lblAptitudMinima.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblAptitudMinima.setText("Aptitud Mínima:");
        panProceso.add(lblAptitudMinima, new org.netbeans.lib.awtextra.AbsoluteConstraints(514, 20, 152, -1));

        txtAptitudMinima.setEditable(false);
        txtAptitudMinima.setBackground(new java.awt.Color(255, 255, 255));
        txtAptitudMinima.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        txtAptitudMinima.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAptitudMinima.setText("20");
        txtAptitudMinima.setFocusable(false);
        txtAptitudMinima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAptitudMinimaActionPerformed(evt);
            }
        });
        panProceso.add(txtAptitudMinima, new org.netbeans.lib.awtextra.AbsoluteConstraints(514, 40, 150, -1));

        lblPoblacionActual1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblPoblacionActual1.setText("Población Actual:");
        panProceso.add(lblPoblacionActual1, new org.netbeans.lib.awtextra.AbsoluteConstraints(182, 80, 148, -1));

        txtPoblacionInicial1.setEditable(false);
        txtPoblacionInicial1.setBackground(new java.awt.Color(255, 255, 255));
        txtPoblacionInicial1.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        txtPoblacionInicial1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPoblacionInicial1.setText("0");
        txtPoblacionInicial1.setAlignmentX(1.5F);
        txtPoblacionInicial1.setFocusable(false);
        txtPoblacionInicial1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPoblacionInicial1ActionPerformed(evt);
            }
        });
        panProceso.add(txtPoblacionInicial1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, 150, -1));

        jPanel4.add(panProceso, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 8, 980, 142));

        btnPublicarInicio.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnPublicarInicio.setText("Publicar");
        btnPublicarInicio.setEnabled(false);
        btnPublicarInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPublicarInicioActionPerformed(evt);
            }
        });
        jPanel4.add(btnPublicarInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(426, 578, 148, 23));

        btnExportarInforme.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnExportarInforme.setText("Exportar");
        btnExportarInforme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarInformeActionPerformed(evt);
            }
        });
        jPanel4.add(btnExportarInforme, new org.netbeans.lib.awtextra.AbsoluteConstraints(258, 578, 148, 23));

        btnSalirInformes.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnSalirInformes.setText("Salir");
        btnSalirInformes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirInformesActionPerformed(evt);
            }
        });
        jPanel4.add(btnSalirInformes, new org.netbeans.lib.awtextra.AbsoluteConstraints(592, 578, 148, 23));

        frmGraficaFija.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        frmGraficaFija.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        frmGraficaFija.setFocusable(false);
        frmGraficaFija.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        frmGraficaFija.setFrameIcon(null);
        frmGraficaFija.setMinimumSize(new java.awt.Dimension(684, 492));
        frmGraficaFija.setPreferredSize(new java.awt.Dimension(684, 492));
        frmGraficaFija.setVisible(true);
        frmGraficaFija.addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                frmGraficaFijaInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                frmGraficaFijaInternalFrameOpened(evt);
            }
        });
        frmGraficaFija.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel4.add(frmGraficaFija, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 154, 980, 416));

        jTabbedPane1.addTab("Inicio", jPanel4);

        jPanel1.setNextFocusableComponent(txtNombreObligatorio);
        jPanel1.setPreferredSize(new java.awt.Dimension(1010, 650));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panGeneralObligatorio.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Obligatorios de la Solución", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 12), java.awt.Color.black)); // NOI18N
        panGeneralObligatorio.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        panGeneralObligatorio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNombreObligatorio.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtNombreObligatorio.setText("Distribución de personas.");
        txtNombreObligatorio.setNextFocusableComponent(txtAutor);
        txtNombreObligatorio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreObligatorioKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreObligatorioKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreObligatorioKeyTyped(evt);
            }
        });
        panGeneralObligatorio.add(txtNombreObligatorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 30, 188, 22));

        lblUbicacionArchivoSolucion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblUbicacionArchivoSolucion.setText("Ubicación:");
        panGeneralObligatorio.add(lblUbicacionArchivoSolucion, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 94, 60, -1));

        txtUbicacionArchivoSolucion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtUbicacionArchivoSolucion.setText("C:\\Usuarios\\Triton\\Escritorio\\EGA\\Pruebas");
        txtUbicacionArchivoSolucion.setNextFocusableComponent(btnUbicacionArchivoSolucion);
        txtUbicacionArchivoSolucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUbicacionArchivoSolucionActionPerformed(evt);
            }
        });
        panGeneralObligatorio.add(txtUbicacionArchivoSolucion, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 90, 358, 22));

        lblNombreObligatorio.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblNombreObligatorio.setText("Nombre:");
        panGeneralObligatorio.add(lblNombreObligatorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 34, 50, -1));

        txtArchivoSolucion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtArchivoSolucion.setText("OrganizaciónEventos.sl");
        txtArchivoSolucion.setNextFocusableComponent(txtUbicacionArchivoSolucion);
        txtArchivoSolucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtArchivoSolucionActionPerformed(evt);
            }
        });
        txtArchivoSolucion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtArchivoSolucionKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtArchivoSolucionKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtArchivoSolucionKeyTyped(evt);
            }
        });
        panGeneralObligatorio.add(txtArchivoSolucion, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 60, 388, 22));

        lblArchivoSolucion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblArchivoSolucion.setText("Archivo:");
        panGeneralObligatorio.add(lblArchivoSolucion, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 64, 50, -1));

        btnUbicacionArchivoSolucion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnUbicacionArchivoSolucion.setText("...");
        btnUbicacionArchivoSolucion.setNextFocusableComponent(txtFechaCompletado);
        btnUbicacionArchivoSolucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbicacionArchivoSolucionActionPerformed(evt);
            }
        });
        panGeneralObligatorio.add(btnUbicacionArchivoSolucion, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 90, 30, 21));

        lblAutor.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblAutor.setText("Autor:");
        panGeneralObligatorio.add(lblAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(278, 34, 34, -1));

        txtAutor.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtAutor.setText("Pablo Pytel");
        txtAutor.setNextFocusableComponent(txtArchivoSolucion);
        txtAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAutorActionPerformed(evt);
            }
        });
        txtAutor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAutorKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAutorKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAutorKeyTyped(evt);
            }
        });
        panGeneralObligatorio.add(txtAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(312, 30, 158, 22));

        jPanel1.add(panGeneralObligatorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 490, 140));

        panGeneralFecha.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Información de Fechas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 12), java.awt.Color.black)); // NOI18N
        panGeneralFecha.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        panGeneralFecha.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFechaCreacion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblFechaCreacion.setText("Fecha de Creación:");
        panGeneralFecha.add(lblFechaCreacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 30, 110, -1));

        txtFechaCreacion.setEditable(false);
        txtFechaCreacion.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        txtFechaCreacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFechaCreacion.setToolTipText("");
        txtFechaCreacion.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtFechaCreacion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtFechaCreacion.setMargin(new java.awt.Insets(2, 10, 2, 2));
        panGeneralFecha.add(txtFechaCreacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 30, 95, -1));

        lblFechaModificacion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblFechaModificacion.setText("Fecha de Modificación:");
        panGeneralFecha.add(lblFechaModificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 60, 130, -1));

        txtFechaModificacion.setEditable(false);
        txtFechaModificacion.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        txtFechaModificacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFechaModificacion.setToolTipText("");
        txtFechaModificacion.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtFechaModificacion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtFechaModificacion.setMargin(new java.awt.Insets(2, 10, 2, 2));
        panGeneralFecha.add(txtFechaModificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 60, 95, -1));

        lblFechaCompletado.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblFechaCompletado.setText("Fecha de Completado:");
        panGeneralFecha.add(lblFechaCompletado, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 90, 130, -1));

        txtFechaCompletado.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        txtFechaCompletado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFechaCompletado.setToolTipText("");
        txtFechaCompletado.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtFechaCompletado.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtFechaCompletado.setMargin(new java.awt.Insets(2, 10, 2, 2));
        txtFechaCompletado.setNextFocusableComponent(txtFechaPublicacion);
        txtFechaCompletado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFechaCompletadoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFechaCompletadoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFechaCompletadoKeyTyped(evt);
            }
        });
        panGeneralFecha.add(txtFechaCompletado, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 90, 95, -1));

        lblFechaEjecucion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblFechaEjecucion.setText("Fecha de Ejecución:");
        panGeneralFecha.add(lblFechaEjecucion, new org.netbeans.lib.awtextra.AbsoluteConstraints(253, 30, 120, -1));

        txtFechaEjecucion.setEditable(false);
        txtFechaEjecucion.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        txtFechaEjecucion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFechaEjecucion.setToolTipText("");
        txtFechaEjecucion.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtFechaEjecucion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtFechaEjecucion.setMargin(new java.awt.Insets(2, 10, 2, 2));
        panGeneralFecha.add(txtFechaEjecucion, new org.netbeans.lib.awtextra.AbsoluteConstraints(375, 30, 95, -1));

        lblFechaPublicacion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblFechaPublicacion.setText("Fecha de Publicación:");
        panGeneralFecha.add(lblFechaPublicacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(253, 60, 130, -1));

        txtFechaPublicacion.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        txtFechaPublicacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFechaPublicacion.setToolTipText("");
        txtFechaPublicacion.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtFechaPublicacion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtFechaPublicacion.setMargin(new java.awt.Insets(2, 10, 2, 2));
        txtFechaPublicacion.setNextFocusableComponent(txtDescripcionSolucion);
        txtFechaPublicacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFechaPublicacionKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFechaPublicacionKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFechaPublicacionKeyTyped(evt);
            }
        });
        panGeneralFecha.add(txtFechaPublicacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(375, 60, 95, -1));

        jPanel1.add(panGeneralFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, 480, 140));

        panGeneralObservacion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Observaciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 12), java.awt.Color.black)); // NOI18N
        panGeneralObservacion.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        panGeneralObservacion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panSolucionDescripcion6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Observaciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 12), java.awt.Color.black)); // NOI18N
        panSolucionDescripcion6.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        panSolucionDescripcion6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jEditorPane6.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jEditorPane6.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jEditorPane6.setText("Esta solución está pensada para eventos de entre 70 y 100 personas. En las pruebas con otras cantidades superiores o inferiores, no se logravla misma convergencia, \nlo cual obliga a una reparemtrización y esto es cambiar la solución por otra.\n\nEs recomendable usar probabilidades de mutación por debajo del 1% y paremetrizar el cruzamiento multipunto de manera uniforme.\n\n\n");
        jEditorPane6.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jEditorPane6.setEnabled(false);
        jEditorPane6.setMargin(new java.awt.Insets(10, 20, 15, 5));
        jScrollPane6.setViewportView(jEditorPane6);

        panSolucionDescripcion6.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 940, 130));

        panGeneralObservacion.add(panSolucionDescripcion6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 980, 170));

        txtObservacionSolucion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtObservacionSolucion.setText("cosas pendientes para dar por finalizada la configuración de la solución:\n\n1. mejorar el método de selección, no me convence lo que veo en el log.\n2. habría que probar qué pasa si a la mutación le agrego un parámetero de período de tiempo dentro del cual no pueden suceder 2 mutaciones,\naún cuando la probabilidad se haya cumplido.\n");
        txtObservacionSolucion.setMargin(new java.awt.Insets(5, 10, 5, 10));
        txtObservacionSolucion.setNextFocusableComponent(chkSoloLectura);
        txtObservacionSolucion.setPreferredSize(new java.awt.Dimension(120, 90));
        txtObservacionSolucion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtObservacionSolucionKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtObservacionSolucionKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtObservacionSolucionKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(txtObservacionSolucion);

        panGeneralObservacion.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 946, 112));

        jPanel1.add(panGeneralObservacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 980, 160));

        panGeneralDescripcion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Descripción de la Solución", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 12), java.awt.Color.black)); // NOI18N
        panGeneralDescripcion.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        panGeneralDescripcion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtDescripcionSolucion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtDescripcionSolucion.setText("Esta solución está pensada para eventos de entre 70 y 100 personas. En las pruebas con otras cantidades superiores o inferiores, no se logra la misma \nconvergencia, lo cual obliga a una reparemtrización y esto es cambiar la solución por otra.  \n\nEs recomendable usar probabilidades de mutación por debajo del 1% y paremetrizar el cruzamiento multipunto de manera uniforme.  \n");
        txtDescripcionSolucion.setMargin(new java.awt.Insets(5, 10, 5, 10));
        txtDescripcionSolucion.setNextFocusableComponent(txtObservacionSolucion);
        txtDescripcionSolucion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDescripcionSolucionKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDescripcionSolucionKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescripcionSolucionKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(txtDescripcionSolucion);

        panGeneralDescripcion.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 946, 114));

        jPanel1.add(panGeneralDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 980, 160));

        panOtrasOpciones.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Otras Opciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 12), java.awt.Color.black)); // NOI18N
        panOtrasOpciones.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        panOtrasOpciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panSolucionDescripcion8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Observaciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 12), java.awt.Color.black)); // NOI18N
        panSolucionDescripcion8.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        panSolucionDescripcion8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jEditorPane8.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jEditorPane8.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jEditorPane8.setText("Esta solución está pensada para eventos de entre 70 y 100 personas. En las pruebas con otras cantidades superiores o inferiores, no se logravla misma convergencia, \nlo cual obliga a una reparemtrización y esto es cambiar la solución por otra.\n\nEs recomendable usar probabilidades de mutación por debajo del 1% y paremetrizar el cruzamiento multipunto de manera uniforme.\n\n\n");
        jEditorPane8.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jEditorPane8.setEnabled(false);
        jEditorPane8.setMargin(new java.awt.Insets(10, 20, 15, 5));
        jScrollPane8.setViewportView(jEditorPane8);

        panSolucionDescripcion8.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 940, 130));

        panOtrasOpciones.add(panSolucionDescripcion8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 980, 170));

        chkSoloLectura.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        chkSoloLectura.setText("Abrir Solución en modo lectura.");
        chkSoloLectura.setNextFocusableComponent(txtCarpetaPublica);
        chkSoloLectura.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkSoloLecturaItemStateChanged(evt);
            }
        });
        chkSoloLectura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkSoloLecturaActionPerformed(evt);
            }
        });
        panOtrasOpciones.add(chkSoloLectura, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 22, 256, -1));

        txtAutor3.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtAutor3.setText("C:\\Usuarios\\Triton\\Escritorio\\EGA\\Pruebas");
        txtAutor3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAutor3ActionPerformed(evt);
            }
        });
        panOtrasOpciones.add(txtAutor3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 350, 22));

        jButton4.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jButton4.setText("...");
        panOtrasOpciones.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 90, 30, 21));

        lblAutor3.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblAutor3.setText("Ubicación:");
        panOtrasOpciones.add(lblAutor3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 60, -1));

        lblCarpetaPublica.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblCarpetaPublica.setText("Carpeta Pública del Servidor:");
        panOtrasOpciones.add(lblCarpetaPublica, new org.netbeans.lib.awtextra.AbsoluteConstraints(284, 28, 164, -1));

        txtCarpetaPublica.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtCarpetaPublica.setText("//SERVER_01/files/pubs/Dropbox/ega");
        txtCarpetaPublica.setNextFocusableComponent(btnCarpetaPublica);
        txtCarpetaPublica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCarpetaPublicaActionPerformed(evt);
            }
        });
        panOtrasOpciones.add(txtCarpetaPublica, new org.netbeans.lib.awtextra.AbsoluteConstraints(446, 26, 304, 22));

        btnCarpetaPublica.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnCarpetaPublica.setText("...");
        btnCarpetaPublica.setNextFocusableComponent(btnLimpiarGeneral);
        btnCarpetaPublica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarpetaPublicaActionPerformed(evt);
            }
        });
        panOtrasOpciones.add(btnCarpetaPublica, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 26, 30, 21));

        jPanel1.add(panOtrasOpciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, 980, 60));

        btnGuardarGeneral.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnGuardarGeneral.setText("Guardar");
        btnGuardarGeneral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarGeneralActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardarGeneral, new org.netbeans.lib.awtextra.AbsoluteConstraints(244, 578, 148, 23));

        btnPublicarGeneral.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnPublicarGeneral.setText("Publicar");
        btnPublicarGeneral.setEnabled(false);
        btnPublicarGeneral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPublicarGeneralActionPerformed(evt);
            }
        });
        jPanel1.add(btnPublicarGeneral, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 578, 148, 23));

        btnLimpiarGeneral.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnLimpiarGeneral.setText("Limpiar");
        btnLimpiarGeneral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarGeneralActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpiarGeneral, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 578, 148, 23));

        btnExportarGeneral.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnExportarGeneral.setText("Exportar");
        btnExportarGeneral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarGeneralActionPerformed(evt);
            }
        });
        jPanel1.add(btnExportarGeneral, new org.netbeans.lib.awtextra.AbsoluteConstraints(412, 578, 148, 23));

        btnSalirGeneral.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnSalirGeneral.setText("Salir");
        btnSalirGeneral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirGeneralActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalirGeneral, new org.netbeans.lib.awtextra.AbsoluteConstraints(746, 578, 148, 23));

        jTabbedPane1.addTab("General", jPanel1);
        jPanel1.getAccessibleContext().setAccessibleName("");

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panOperador.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Métodos y Operadores", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 12))); // NOI18N
        panOperador.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panSeleccion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Operador de Selección", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 12))); // NOI18N
        panSeleccion.setAlignmentX(0.0F);
        panSeleccion.setAlignmentY(0.0F);
        panSeleccion.setFont(new java.awt.Font("Script MT Bold", 0, 12)); // NOI18N
        panSeleccion.setPreferredSize(new java.awt.Dimension(229, 205));
        panSeleccion.setLayout(null);

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel2.setText("Ingrese el Valor de los Parámetros:");
        panSeleccion.add(jLabel2);
        jLabel2.setBounds(16, 52, 197, 16);

        btnEditarSeleccion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnEditarSeleccion.setText("Editar");
        btnEditarSeleccion.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnEditarSeleccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarSeleccionActionPerformed(evt);
            }
        });
        panSeleccion.add(btnEditarSeleccion);
        btnEditarSeleccion.setBounds(14, 194, 60, 25);

        btnNuevoSeleccion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnNuevoSeleccion.setText("Nuevo");
        btnNuevoSeleccion.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnNuevoSeleccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoSeleccionActionPerformed(evt);
            }
        });
        panSeleccion.add(btnNuevoSeleccion);
        btnNuevoSeleccion.setBounds(80, 194, 60, 25);

        btnAyudaSeleccion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnAyudaSeleccion.setText("?");
        btnAyudaSeleccion.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnAyudaSeleccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAyudaSeleccionActionPerformed(evt);
            }
        });
        panSeleccion.add(btnAyudaSeleccion);
        btnAyudaSeleccion.setBounds(186, 194, 37, 25);

        tblSeleccion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"CANTIDAD", "10"}
            },
            new String [] {
                "NOMBRE", "VALOR"
            }
        ));
        tblSeleccion.getTableHeader().setReorderingAllowed(false);
        tblSeleccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblSeleccionKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(tblSeleccion);
        tblSeleccion.getColumnModel().getColumn(1).setPreferredWidth(15);

        panSeleccion.add(jScrollPane3);
        jScrollPane3.setBounds(16, 72, 208, 114);

        cmbSeleccion.setEditable(true);
        cmbSeleccion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        cmbSeleccion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Elija un método...", "Ranking", "Torneo", "Ruleta", "Control s/n esperado" }));
        cmbSeleccion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbSeleccionItemStateChanged(evt);
            }
        });
        panSeleccion.add(cmbSeleccion);
        cmbSeleccion.setBounds(16, 22, 208, 22);

        btnRefreshSeleccion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnRefreshSeleccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system/res/refresh.png"))); // NOI18N
        btnRefreshSeleccion.setMargin(new java.awt.Insets(8, 8, 8, 8));
        btnRefreshSeleccion.setMaximumSize(new java.awt.Dimension(35, 25));
        btnRefreshSeleccion.setMinimumSize(new java.awt.Dimension(35, 25));
        btnRefreshSeleccion.setPreferredSize(new java.awt.Dimension(35, 25));
        btnRefreshSeleccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshSeleccionActionPerformed(evt);
            }
        });
        panSeleccion.add(btnRefreshSeleccion);
        btnRefreshSeleccion.setBounds(146, 194, 35, 25);

        panOperador.add(panSeleccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 233, 238, 232));

        panCruzamiento.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Operador de Cruzamiento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 12))); // NOI18N
        panCruzamiento.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        panCruzamiento.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel3.setText("Ingrese el Valor de los Parámetros:");
        panCruzamiento.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 52, 197, -1));

        tblCruzamiento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "NOMBRE", "VALOR"
            }
        ));
        tblCruzamiento.getTableHeader().setReorderingAllowed(false);
        tblCruzamiento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblCruzamientoKeyReleased(evt);
            }
        });
        jScrollPane4.setViewportView(tblCruzamiento);
        tblCruzamiento.getColumnModel().getColumn(1).setPreferredWidth(15);

        panCruzamiento.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 72, 200, 114));

        btnEditarCruzamiento.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnEditarCruzamiento.setText("Editar");
        btnEditarCruzamiento.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnEditarCruzamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarCruzamientoActionPerformed(evt);
            }
        });
        panCruzamiento.add(btnEditarCruzamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 194, 60, 25));

        btnNuevoCruzamiento.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnNuevoCruzamiento.setText("Nuevo");
        btnNuevoCruzamiento.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnNuevoCruzamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoCruzamientoActionPerformed(evt);
            }
        });
        panCruzamiento.add(btnNuevoCruzamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 194, 60, 25));

        btnAyudaCruzamiento.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnAyudaCruzamiento.setText("?");
        btnAyudaCruzamiento.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnAyudaCruzamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAyudaCruzamientoActionPerformed(evt);
            }
        });
        panCruzamiento.add(btnAyudaCruzamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(184, 194, 37, 25));

        cmbCruzamiento.setEditable(true);
        cmbCruzamiento.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        cmbCruzamiento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Elija un método...", "Máscara Multipunto", "Máscara Simple", " " }));
        cmbCruzamiento.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbCruzamientoItemStateChanged(evt);
            }
        });
        panCruzamiento.add(cmbCruzamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 22, 200, -1));

        btnRefreshCruzamiento.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnRefreshCruzamiento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system/res/refresh.png"))); // NOI18N
        btnRefreshCruzamiento.setMargin(new java.awt.Insets(8, 8, 8, 8));
        btnRefreshCruzamiento.setMaximumSize(new java.awt.Dimension(35, 25));
        btnRefreshCruzamiento.setMinimumSize(new java.awt.Dimension(35, 25));
        btnRefreshCruzamiento.setPreferredSize(new java.awt.Dimension(35, 25));
        btnRefreshCruzamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshCruzamientoActionPerformed(evt);
            }
        });
        panCruzamiento.add(btnRefreshCruzamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 194, 37, 25));

        panOperador.add(panCruzamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(256, 233, 230, 232));

        panMutacion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Operador de Mutación", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 12))); // NOI18N
        panMutacion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        panMutacion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel4.setText("Ingrese el Valor de los Parámetros:");
        panMutacion.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 52, 197, -1));

        tblMutacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"PROBABILIDAD", "0,02"}
            },
            new String [] {
                "NOMBRE", "VALOR"
            }
        ));
        tblMutacion.getTableHeader().setReorderingAllowed(false);
        tblMutacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblMutacionKeyReleased(evt);
            }
        });
        jScrollPane5.setViewportView(tblMutacion);
        tblMutacion.getColumnModel().getColumn(1).setPreferredWidth(15);

        panMutacion.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 72, 210, 116));

        btnEditarMutacion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnEditarMutacion.setText("Editar");
        btnEditarMutacion.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnEditarMutacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarMutacionActionPerformed(evt);
            }
        });
        panMutacion.add(btnEditarMutacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 194, 60, 25));

        btnNuevoMutacion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnNuevoMutacion.setText("Nuevo");
        btnNuevoMutacion.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnNuevoMutacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoMutacionActionPerformed(evt);
            }
        });
        panMutacion.add(btnNuevoMutacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 194, 60, 25));

        btnAyudaMutacion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnAyudaMutacion.setText("?");
        btnAyudaMutacion.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnAyudaMutacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAyudaMutacionActionPerformed(evt);
            }
        });
        panMutacion.add(btnAyudaMutacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 194, 37, 25));

        cmbMutacion.setEditable(true);
        cmbMutacion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        cmbMutacion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Elija un método...", "Azar" }));
        cmbMutacion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbMutacionItemStateChanged(evt);
            }
        });
        panMutacion.add(cmbMutacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 22, 210, -1));

        btnRefreshMutacion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnRefreshMutacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system/res/refresh.png"))); // NOI18N
        btnRefreshMutacion.setMargin(new java.awt.Insets(8, 8, 8, 8));
        btnRefreshMutacion.setMaximumSize(new java.awt.Dimension(35, 25));
        btnRefreshMutacion.setMinimumSize(new java.awt.Dimension(35, 25));
        btnRefreshMutacion.setPreferredSize(new java.awt.Dimension(35, 25));
        btnRefreshMutacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshMutacionActionPerformed(evt);
            }
        });
        panMutacion.add(btnRefreshMutacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(146, 194, 37, 25));

        panOperador.add(panMutacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(492, 232, 240, 234));

        panParada.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Operador de Finalización", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 12))); // NOI18N
        panParada.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        panParada.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel5.setText("Ingrese el Valor de los Parámetros:");
        panParada.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 52, 197, -1));

        tblParada.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"SEGUNDOS", "3600"}
            },
            new String [] {
                "NOMBRE", "VALOR"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblParada.getTableHeader().setReorderingAllowed(false);
        tblParada.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tblParadaFocusLost(evt);
            }
        });
        tblParada.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblParadaKeyReleased(evt);
            }
        });
        jScrollPane9.setViewportView(tblParada);
        tblParada.getColumnModel().getColumn(1).setPreferredWidth(15);

        panParada.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 72, 197, 116));

        btnEditarParada.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnEditarParada.setText("Editar");
        btnEditarParada.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnEditarParada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarParadaActionPerformed(evt);
            }
        });
        panParada.add(btnEditarParada, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 194, 60, 25));

        btnNuevoParada.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnNuevoParada.setText("Nuevo");
        btnNuevoParada.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnNuevoParada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoParadaActionPerformed(evt);
            }
        });
        panParada.add(btnNuevoParada, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 194, 60, 25));

        btnAyudaParada.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnAyudaParada.setText("?");
        btnAyudaParada.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnAyudaParada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAyudaParadaActionPerformed(evt);
            }
        });
        panParada.add(btnAyudaParada, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 194, 37, 25));

        cmbParada.setEditable(true);
        cmbParada.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        cmbParada.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Elija un método...", "por Tiempo", "por Ciclos", "por Valor de Aptitud", "por Tamaño de Población" }));
        cmbParada.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbParadaItemStateChanged(evt);
            }
        });
        panParada.add(cmbParada, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 22, 198, -1));

        btnRefreshParada.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnRefreshParada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system/res/refresh.png"))); // NOI18N
        btnRefreshParada.setMargin(new java.awt.Insets(8, 8, 8, 8));
        btnRefreshParada.setMaximumSize(new java.awt.Dimension(35, 25));
        btnRefreshParada.setMinimumSize(new java.awt.Dimension(35, 25));
        btnRefreshParada.setPreferredSize(new java.awt.Dimension(35, 25));
        btnRefreshParada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshParadaActionPerformed(evt);
            }
        });
        panParada.add(btnRefreshParada, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 194, 37, 25));

        panOperador.add(panParada, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 232, 230, 234));

        panDatos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Método de Carga de Datos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 12))); // NOI18N
        panDatos.setPreferredSize(new java.awt.Dimension(229, 181));
        panDatos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cmbDatos.setEditable(true);
        cmbDatos.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        cmbDatos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbDatosItemStateChanged(evt);
            }
        });
        panDatos.add(cmbDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 24, 210, -1));

        jLabel19.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel19.setText("Ingrese el Valor de los Parámetros:");
        panDatos.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 50, -1, -1));

        btnEditarCargaDatos.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnEditarCargaDatos.setText("Editar");
        btnEditarCargaDatos.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnEditarCargaDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarCargaDatosActionPerformed(evt);
            }
        });
        panDatos.add(btnEditarCargaDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 166, 60, 25));

        btnAyudaCargaDatos.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnAyudaCargaDatos.setText("?");
        btnAyudaCargaDatos.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnAyudaCargaDatos.setMaximumSize(new java.awt.Dimension(35, 25));
        btnAyudaCargaDatos.setMinimumSize(new java.awt.Dimension(35, 25));
        btnAyudaCargaDatos.setPreferredSize(new java.awt.Dimension(35, 25));
        btnAyudaCargaDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAyudaCargaDatosActionPerformed(evt);
            }
        });
        panDatos.add(btnAyudaCargaDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 166, 37, 25));

        btnNuevoCargaDatos.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnNuevoCargaDatos.setText("Nuevo");
        btnNuevoCargaDatos.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnNuevoCargaDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoCargaDatosActionPerformed(evt);
            }
        });
        panDatos.add(btnNuevoCargaDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 166, 60, 25));

        tblDatos.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"USER", "guess"},
                {"PASSWORD", "*******"},
                {"DB SERVER", "127.0.0.1:1344"}
            },
            new String [] {
                "NOMBRE", "VALOR"
            }
        ));
        tblDatos.getTableHeader().setReorderingAllowed(false);
        tblDatos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tblDatosFocusLost(evt);
            }
        });
        tblDatos.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                tblDatosInputMethodTextChanged(evt);
            }
        });
        tblDatos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblDatosKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblDatosKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tblDatosKeyTyped(evt);
            }
        });
        jScrollPane11.setViewportView(tblDatos);

        panDatos.add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 70, 210, 92));

        btnRefreshCargaDatos.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnRefreshCargaDatos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system/res/refresh.png"))); // NOI18N
        btnRefreshCargaDatos.setMargin(new java.awt.Insets(8, 8, 8, 8));
        btnRefreshCargaDatos.setMaximumSize(new java.awt.Dimension(35, 25));
        btnRefreshCargaDatos.setMinimumSize(new java.awt.Dimension(35, 25));
        btnRefreshCargaDatos.setPreferredSize(new java.awt.Dimension(35, 25));
        btnRefreshCargaDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshCargaDatosActionPerformed(evt);
            }
        });
        panDatos.add(btnRefreshCargaDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(146, 166, 37, 25));

        panOperador.add(panDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 24, 240, 202));

        panCromosoma.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cromosoma", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 12))); // NOI18N
        panCromosoma.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel20.setText("Ingrese el Valor de los Parámetros:");
        panCromosoma.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 50, -1, -1));

        btnEditarCromosoma.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnEditarCromosoma.setText("Editar");
        btnEditarCromosoma.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnEditarCromosoma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarCromosomaActionPerformed(evt);
            }
        });
        panCromosoma.add(btnEditarCromosoma, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 166, 60, 25));

        btnAyudaCromosoma.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnAyudaCromosoma.setText("?");
        btnAyudaCromosoma.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnAyudaCromosoma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAyudaCromosomaActionPerformed(evt);
            }
        });
        panCromosoma.add(btnAyudaCromosoma, new org.netbeans.lib.awtextra.AbsoluteConstraints(186, 166, 37, 25));

        btnNuevoCromosoma.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnNuevoCromosoma.setText("Nuevo");
        btnNuevoCromosoma.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnNuevoCromosoma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoCromosomaActionPerformed(evt);
            }
        });
        panCromosoma.add(btnNuevoCromosoma, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 166, 60, 25));

        cmbCromosoma.setEditable(true);
        cmbCromosoma.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        cmbCromosoma.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbCromosomaItemStateChanged(evt);
            }
        });
        panCromosoma.add(cmbCromosoma, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 24, 210, -1));

        tblCromosoma.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"MUTABLE", "SI"},
                {"GEN_INTERCAMBIABLE", "SI"},
                {"MUTACIONES_MAXIMAS", "5"}
            },
            new String [] {
                "NOMBRE", "VALOR"
            }
        ));
        tblCromosoma.getTableHeader().setReorderingAllowed(false);
        tblCromosoma.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblCromosomaKeyReleased(evt);
            }
        });
        jScrollPane10.setViewportView(tblCromosoma);
        tblCromosoma.getColumnModel().getColumn(1).setPreferredWidth(15);

        panCromosoma.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 70, 208, 92));

        btnRefreshCromosoma.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnRefreshCromosoma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system/res/refresh.png"))); // NOI18N
        btnRefreshCromosoma.setMargin(new java.awt.Insets(8, 8, 8, 8));
        btnRefreshCromosoma.setMaximumSize(new java.awt.Dimension(35, 25));
        btnRefreshCromosoma.setMinimumSize(new java.awt.Dimension(35, 25));
        btnRefreshCromosoma.setPreferredSize(new java.awt.Dimension(35, 25));
        btnRefreshCromosoma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshCromosomaActionPerformed(evt);
            }
        });
        panCromosoma.add(btnRefreshCromosoma, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 166, 37, 25));

        panOperador.add(panCromosoma, new org.netbeans.lib.awtextra.AbsoluteConstraints(492, 24, 240, 202));

        panAptitud.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Función de Aptitud", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 12))); // NOI18N
        panAptitud.setAlignmentX(0.0F);
        panAptitud.setAlignmentY(0.0F);
        panAptitud.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel18.setText("Ingrese el Valor de los Parámetros:");
        panAptitud.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 50, -1, -1));

        btnEditarAptitud.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnEditarAptitud.setText("Editar");
        btnEditarAptitud.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnEditarAptitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarAptitudActionPerformed(evt);
            }
        });
        panAptitud.add(btnEditarAptitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 166, 60, 25));

        btnAyudaAptitud.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnAyudaAptitud.setText("?");
        btnAyudaAptitud.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnAyudaAptitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAyudaAptitudActionPerformed(evt);
            }
        });
        panAptitud.add(btnAyudaAptitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 166, 37, 25));

        btnNuevoAptitud.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnNuevoAptitud.setText("Nuevo");
        btnNuevoAptitud.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnNuevoAptitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoAptitudActionPerformed(evt);
            }
        });
        panAptitud.add(btnNuevoAptitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 166, 60, 25));

        cmbAptitud.setEditable(true);
        cmbAptitud.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        cmbAptitud.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbAptitudItemStateChanged(evt);
            }
        });
        panAptitud.add(cmbAptitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 24, 198, -1));

        tblAptitud.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"MULTIPLICADOR", "0,3"},
                {"RENDONDEAR", "SI"}
            },
            new String [] {
                "NOMBRE", "VALOR"
            }
        ));
        tblAptitud.getTableHeader().setReorderingAllowed(false);
        tblAptitud.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblAptitudKeyReleased(evt);
            }
        });
        jScrollPane7.setViewportView(tblAptitud);
        tblAptitud.getColumnModel().getColumn(1).setPreferredWidth(15);

        panAptitud.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 70, 198, 90));

        btnRefreshAptitud.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnRefreshAptitud.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system/res/refresh.png"))); // NOI18N
        btnRefreshAptitud.setMargin(new java.awt.Insets(8, 8, 8, 8));
        btnRefreshAptitud.setMaximumSize(new java.awt.Dimension(35, 25));
        btnRefreshAptitud.setMinimumSize(new java.awt.Dimension(35, 25));
        btnRefreshAptitud.setPreferredSize(new java.awt.Dimension(35, 25));
        btnRefreshAptitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshAptitudActionPerformed(evt);
            }
        });
        panAptitud.add(btnRefreshAptitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 166, 37, 25));

        panOperador.add(panAptitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 24, 230, 202));

        panConfiguracionVisualizacion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Método de Formato de Resultados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 12))); // NOI18N
        panConfiguracionVisualizacion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cmbMetodoResultado.setEditable(true);
        cmbMetodoResultado.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        cmbMetodoResultado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbMetodoResultadoItemStateChanged(evt);
            }
        });
        panConfiguracionVisualizacion.add(cmbMetodoResultado, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 24, 206, -1));

        btnEditarMetodoResultado.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnEditarMetodoResultado.setText("Editar");
        btnEditarMetodoResultado.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnEditarMetodoResultado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarMetodoResultadoActionPerformed(evt);
            }
        });
        panConfiguracionVisualizacion.add(btnEditarMetodoResultado, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 166, 60, 25));

        btnNuevoMetodoResultado.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnNuevoMetodoResultado.setText("Nuevo");
        btnNuevoMetodoResultado.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnNuevoMetodoResultado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoMetodoResultadoActionPerformed(evt);
            }
        });
        panConfiguracionVisualizacion.add(btnNuevoMetodoResultado, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 166, 60, 25));

        btnAyudaMetodoResultado.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnAyudaMetodoResultado.setText("?");
        btnAyudaMetodoResultado.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnAyudaMetodoResultado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAyudaMetodoResultadoActionPerformed(evt);
            }
        });
        panConfiguracionVisualizacion.add(btnAyudaMetodoResultado, new org.netbeans.lib.awtextra.AbsoluteConstraints(184, 166, 37, 25));

        jLabel21.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel21.setText("Ingrese el Valor de los Parámetros:");
        panConfiguracionVisualizacion.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 50, -1, -1));

        tblResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"TITULO", "Eventos UTN 2012"},
                {"SUBTITULO", "Solución Genética"},
                {"CANT_GANA", "5"},
                {"CANT_GANA_x_CICLO", "10"},
                {null, null}
            },
            new String [] {
                "NOMBRE", "VALOR"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblResultados.getTableHeader().setReorderingAllowed(false);
        tblResultados.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblResultadosKeyReleased(evt);
            }
        });
        jScrollPane12.setViewportView(tblResultados);
        tblResultados.getColumnModel().getColumn(1).setPreferredWidth(15);

        panConfiguracionVisualizacion.add(jScrollPane12, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 70, 204, 92));

        btnRefreshMetodoResultado.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnRefreshMetodoResultado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system/res/refresh.png"))); // NOI18N
        btnRefreshMetodoResultado.setMargin(new java.awt.Insets(8, 8, 8, 8));
        btnRefreshMetodoResultado.setMaximumSize(new java.awt.Dimension(35, 25));
        btnRefreshMetodoResultado.setMinimumSize(new java.awt.Dimension(35, 25));
        btnRefreshMetodoResultado.setPreferredSize(new java.awt.Dimension(35, 25));
        btnRefreshMetodoResultado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshMetodoResultadoActionPerformed(evt);
            }
        });
        panConfiguracionVisualizacion.add(btnRefreshMetodoResultado, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 166, 37, 25));

        panOperador.add(panConfiguracionVisualizacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(256, 24, 232, 202));

        jPanel2.add(panOperador, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 982, 472));

        btnSalirConfiguracion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnSalirConfiguracion.setText("Salir");
        btnSalirConfiguracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirConfiguracionActionPerformed(evt);
            }
        });
        jPanel2.add(btnSalirConfiguracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(746, 578, 148, 23));

        btnExportarConfiguracion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnExportarConfiguracion.setText("Exportar");
        btnExportarConfiguracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarConfiguracionActionPerformed(evt);
            }
        });
        jPanel2.add(btnExportarConfiguracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(412, 578, 148, 23));

        btnPublicarConfiguracion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnPublicarConfiguracion.setText("Publicar");
        btnPublicarConfiguracion.setEnabled(false);
        btnPublicarConfiguracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPublicarConfiguracionActionPerformed(evt);
            }
        });
        jPanel2.add(btnPublicarConfiguracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 578, 148, 23));

        btnGuardarConfiguracion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnGuardarConfiguracion.setText("Guardar");
        btnGuardarConfiguracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarConfiguracionActionPerformed(evt);
            }
        });
        jPanel2.add(btnGuardarConfiguracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(244, 578, 148, 23));

        btnLimpiarConfiguracion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnLimpiarConfiguracion.setText("Limpiar");
        btnLimpiarConfiguracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarConfiguracionActionPerformed(evt);
            }
        });
        jPanel2.add(btnLimpiarConfiguracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 578, 148, 23));

        panConfiguracion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Configuración de la Población", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 12))); // NOI18N
        panConfiguracion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cmbCrecimientoPoblacion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        cmbCrecimientoPoblacion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Población Fija", "Población Creciente", "Población Decreciente" }));
        cmbCrecimientoPoblacion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbCrecimientoPoblacionItemStateChanged(evt);
            }
        });
        panConfiguracion.add(cmbCrecimientoPoblacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 52, 210, -1));

        lblPoblacionInicial.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblPoblacionInicial.setText("Tamaño Inicial:");
        panConfiguracion.add(lblPoblacionInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 24, -1, -1));

        txtPoblacionInicial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPoblacionInicial.setText("500");
        txtPoblacionInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPoblacionInicialActionPerformed(evt);
            }
        });
        txtPoblacionInicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPoblacionInicialFocusLost(evt);
            }
        });
        txtPoblacionInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPoblacionInicialKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPoblacionInicialKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPoblacionInicialKeyTyped(evt);
            }
        });
        panConfiguracion.add(txtPoblacionInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 22, 120, -1));

        jPanel2.add(panConfiguracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 250, 90));

        panConfiguracion1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Verificación", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 12))); // NOI18N
        panConfiguracion1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnProbarConfiguracion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnProbarConfiguracion.setText("<html><p> Probar</p><p>Solución</p></html>");
        btnProbarConfiguracion.setAlignmentY(0.0F);
        btnProbarConfiguracion.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnProbarConfiguracion.setMaximumSize(new java.awt.Dimension(80, 23));
        btnProbarConfiguracion.setMinimumSize(new java.awt.Dimension(50, 23));
        btnProbarConfiguracion.setPreferredSize(new java.awt.Dimension(71, 23));
        btnProbarConfiguracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProbarConfiguracionActionPerformed(evt);
            }
        });
        panConfiguracion1.add(btnProbarConfiguracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 20, 114, 60));

        jLabel22.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel22.setText("<html>  Utilice el botón \"Probar Solución\" para evitar errores de dependencia entre los métodos que ha elegido.<p> Si carga un método que hace uso de otro que aún no ha elegido, la prueba indicará error y deberá elegir<p> primero el método faltante. Cuando la prueba resulte exitosa, la solución estará lista para ser ejecutada. </html>");
        jLabel22.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel22.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        panConfiguracion1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 14, 572, 70));

        jPanel2.add(panConfiguracion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(264, 10, 726, 92));

        jTabbedPane1.addTab("Configuración", jPanel2);

        jPanel3.setNextFocusableComponent(lstArchivos);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblGanadores.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblGanadores.setText("Cromosomas Ganadores del Archivo Elegido:");
        jPanel3.add(lblGanadores, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 352, -1));

        lblListaArchivos.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblListaArchivos.setText("Elija un Archivo de Resultados:");
        jPanel3.add(lblListaArchivos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 182, -1));

        btnSalirResultados.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnSalirResultados.setText("Salir");
        btnSalirResultados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirResultadosActionPerformed(evt);
            }
        });
        jPanel3.add(btnSalirResultados, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 580, 132, 23));

        btnExportarResultados.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnExportarResultados.setText("Exportar");
        btnExportarResultados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarResultadosActionPerformed(evt);
            }
        });
        jPanel3.add(btnExportarResultados, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 580, 132, 23));

        btnEliminarArchivo.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnEliminarArchivo.setText("Eliminar Archivo");
        btnEliminarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarArchivoActionPerformed(evt);
            }
        });
        jPanel3.add(btnEliminarArchivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 580, 132, 23));

        btnPublicarResultados.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnPublicarResultados.setText("Publicar");
        btnPublicarResultados.setEnabled(false);
        btnPublicarResultados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPublicarResultadosActionPerformed(evt);
            }
        });
        jPanel3.add(btnPublicarResultados, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 580, 132, 23));

        lstArchivos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstArchivos.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstArchivosValueChanged(evt);
            }
        });
        jScrollPane15.setViewportView(lstArchivos);

        jPanel3.add(jScrollPane15, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 30, 206, 536));

        btnVerInformeResultados.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnVerInformeResultados.setText("Ver Informe");
        btnVerInformeResultados.setNextFocusableComponent(btnEliminarArchivo);
        btnVerInformeResultados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerInformeResultadosActionPerformed(evt);
            }
        });
        jPanel3.add(btnVerInformeResultados, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 580, 132, 23));

        txtGanadores.setColumns(20);
        txtGanadores.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        txtGanadores.setRows(5);
        txtGanadores.setMargin(new java.awt.Insets(6, 8, 2, 2));
        jScrollPane13.setViewportView(txtGanadores);

        jPanel3.add(jScrollPane13, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 770, 536));

        jTabbedPane1.addTab("Resultados", jPanel3);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 640));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUbicacionArchivoSolucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUbicacionArchivoSolucionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUbicacionArchivoSolucionActionPerformed

    private void txtArchivoSolucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtArchivoSolucionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtArchivoSolucionActionPerformed

    private void chkSoloLecturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkSoloLecturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkSoloLecturaActionPerformed

    private void txtHoraInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHoraInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHoraInicioActionPerformed

    private void txtDuracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDuracionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDuracionActionPerformed

    private void txtPoblacionActualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPoblacionActualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPoblacionActualActionPerformed

    private void txtCiclosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCiclosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCiclosActionPerformed

    private void txtMutacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMutacionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMutacionesActionPerformed

    private void txtAptitudMediaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAptitudMediaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAptitudMediaActionPerformed

    private void txtAptitudMinimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAptitudMinimaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAptitudMinimaActionPerformed

    private void txtAutor3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAutor3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAutor3ActionPerformed

    private void txtCarpetaPublicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCarpetaPublicaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCarpetaPublicaActionPerformed

    private void txtPoblacionInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPoblacionInicialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPoblacionInicialActionPerformed

    private void btnAyudaCargaDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAyudaCargaDatosActionPerformed
        if (this.cmbDatos.getItemCount() > 0 && this.cmbDatos.getSelectedIndex() >= 0) {
            javax.swing.JInternalFrame frm = this.frmParent.AbrirVentana("frmDescripcionFuncion", this._intID, getSelectedMethodInCombo(this.cmbDatos), false);
            ((frmDescripcionFuncion) frm).frmOpener = this;
            this._arrMySon.add(frm);
        } else {
            JOptionPane.showMessageDialog(this, Messages.strElementNotSelected, "EGA", 1);
        }
    }//GEN-LAST:event_btnAyudaCargaDatosActionPerformed

    private void btnAyudaCromosomaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAyudaCromosomaActionPerformed
        if (this.cmbCromosoma.getItemCount() > 0 && this.cmbCromosoma.getSelectedIndex() >= 0) {
            javax.swing.JInternalFrame frm = this.frmParent.AbrirVentana("frmDescripcionFuncion", this._intID, getSelectedMethodInCombo(this.cmbCromosoma), false);
            ((frmDescripcionFuncion) frm).frmOpener = this;
            this._arrMySon.add(frm);
        } else {
            JOptionPane.showMessageDialog(this, Messages.strElementNotSelected, "EGA", 1);
        }
    }//GEN-LAST:event_btnAyudaCromosomaActionPerformed

    private void btnAyudaAptitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAyudaAptitudActionPerformed
        if (this.cmbAptitud.getItemCount() > 0 && this.cmbAptitud.getSelectedIndex() >= 0) {
            javax.swing.JInternalFrame frm = this.frmParent.AbrirVentana("frmDescripcionFuncion", this._intID, getSelectedMethodInCombo(this.cmbAptitud), false);
            ((frmDescripcionFuncion) frm).frmOpener = this;
            this._arrMySon.add(frm);
        } else {
            JOptionPane.showMessageDialog(this, Messages.strElementNotSelected, "EGA", 1);
        }
    }//GEN-LAST:event_btnAyudaAptitudActionPerformed

    private void btnAyudaSeleccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAyudaSeleccionActionPerformed
        if (this.cmbSeleccion.getItemCount() > 0 && this.cmbSeleccion.getSelectedIndex() >= 0) {
            javax.swing.JInternalFrame frm = this.frmParent.AbrirVentana("frmDescripcionFuncion", this._intID, getSelectedMethodInCombo(this.cmbSeleccion), false);
            ((frmDescripcionFuncion) frm).frmOpener = this;
            this._arrMySon.add(frm);
        } else {
            JOptionPane.showMessageDialog(this, Messages.strElementNotSelected, "EGA", 1);
        }
    }//GEN-LAST:event_btnAyudaSeleccionActionPerformed

    private void btnAyudaCruzamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAyudaCruzamientoActionPerformed
        if (this.cmbCruzamiento.getItemCount() > 0 && this.cmbCruzamiento.getSelectedIndex() >= 0) {
            javax.swing.JInternalFrame frm = this.frmParent.AbrirVentana("frmDescripcionFuncion", this._intID, getSelectedMethodInCombo(this.cmbCruzamiento), false);
            ((frmDescripcionFuncion) frm).frmOpener = this;
            this._arrMySon.add(frm);
        } else {
            JOptionPane.showMessageDialog(this, Messages.strElementNotSelected, "EGA", 1);
        }
    }//GEN-LAST:event_btnAyudaCruzamientoActionPerformed

    private void btnAyudaMutacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAyudaMutacionActionPerformed
        if (this.cmbMutacion.getItemCount() > 0 && this.cmbMutacion.getSelectedIndex() >= 0) {
            javax.swing.JInternalFrame frm = this.frmParent.AbrirVentana("frmDescripcionFuncion", this._intID, getSelectedMethodInCombo(this.cmbMutacion), false);
            ((frmDescripcionFuncion) frm).frmOpener = this;
            this._arrMySon.add(frm);
        } else {
            JOptionPane.showMessageDialog(this, Messages.strElementNotSelected, "EGA", 1);
        }
    }//GEN-LAST:event_btnAyudaMutacionActionPerformed

    private void btnAyudaParadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAyudaParadaActionPerformed
        if (this.cmbParada.getItemCount() > 0 && this.cmbParada.getSelectedIndex() >= 0) {
            javax.swing.JInternalFrame frm = this.frmParent.AbrirVentana("frmDescripcionFuncion", this._intID, getSelectedMethodInCombo(this.cmbParada), false);
            ((frmDescripcionFuncion) frm).frmOpener = this;
            this._arrMySon.add(frm);
        } else {
            JOptionPane.showMessageDialog(this, Messages.strElementNotSelected, "EGA", 1);
        }
    }//GEN-LAST:event_btnAyudaParadaActionPerformed

    private void btnEditarCargaDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarCargaDatosActionPerformed
        this.editingAction(this.cmbDatos);
    }//GEN-LAST:event_btnEditarCargaDatosActionPerformed

    private void btnLimpiarGeneralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarGeneralActionPerformed
        // TODO add your handling code here: 
        this.resetGeneralTab();
    }//GEN-LAST:event_btnLimpiarGeneralActionPerformed

    private void btnEditarCromosomaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarCromosomaActionPerformed
        this.editingAction(this.cmbCromosoma);
    }//GEN-LAST:event_btnEditarCromosomaActionPerformed

    private void btnEditarAptitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarAptitudActionPerformed
        this.editingAction(this.cmbAptitud);
    }//GEN-LAST:event_btnEditarAptitudActionPerformed

    private void btnEditarSeleccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarSeleccionActionPerformed
        this.editingAction(this.cmbSeleccion);
    }//GEN-LAST:event_btnEditarSeleccionActionPerformed

    private void btnEditarCruzamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarCruzamientoActionPerformed
        this.editingAction(this.cmbCruzamiento);
    }//GEN-LAST:event_btnEditarCruzamientoActionPerformed

    private void btnEditarParadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarParadaActionPerformed
        this.editingAction(this.cmbParada);
    }//GEN-LAST:event_btnEditarParadaActionPerformed

	private void txtAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAutorActionPerformed
            // TODO add your handling code here:
	}//GEN-LAST:event_txtAutorActionPerformed

//    public void StartExecution(){
//        this._blnExecuting = true;
//        this._blnPaused = false;
//    }
//    
//    public void StopExecution(){
//        this._blnExecuting = false;
//        this._blnPaused = false;
//    }
//    
//    public void PauseExcution(){
//        this._blnExecuting = false;
//        this._blnPaused = true;
//    }
//    public boolean isInStatus(String strStatus){
//        switch(strStatus.toUpperCase()){
//            case "EXECUTING":
//                return this._blnExecuting == true && this._blnPaused == false;
//            case "STOPPED":
//                return this._blnExecuting == false && this._blnPaused == false;
//            case "PAUSED":
//                return this._blnExecuting == false && this._blnPaused == true;
//        }
//        return false;
//    }
    private void btnPausaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPausaActionPerformed


        if (this.procesoActual.estaEjecutando()) {
            this.timer.pause();
            this.btnPausa.setText("Reanudar");
            this.btnVerInformeInicio.setEnabled(true);
            this.procesoActual.pausate();
            btnVerInformeInicio.setText(GRABAR_RESULTADOS);

        } else if (this.procesoActual.estaPausado()) {
            this.btnPausa.setText("Pausar");
            this.procesoActual.reanudate();
            this.timer.start();
            btnVerInformeInicio.setText(GRABAR_RESULTADOS);
            this.btnVerInformeInicio.setEnabled(false);
            
        }
    }//GEN-LAST:event_btnPausaActionPerformed
    public void procesoFinalizado(List results) {
        
        this.txtFechaEjecucion.setText(functions.getDate());
        this.execute(results, this.Grafica.TraerSubconjuntoCompleto());
//        this.btnVerInformeInicio.setEnabled(true);
//        this.btnVerInformeInicio.setText(VER_INFORME);

        this.btnComenzar.setText(COMENZAR);
        this.btnPausa.setSelected(false);
        this.btnPausa.setText(PAUSAR);
        this.btnPausa.setEnabled(false);
           this.btnVerInformeInicio.setText(VER_INFORME);
           this.btnVerInformeInicio.setEnabled(true);

           
       
    }

    private void btnEditarMutacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarMutacionActionPerformed
        this.editingAction(this.cmbMutacion);
    }//GEN-LAST:event_btnEditarMutacionActionPerformed

    private void btnNuevoCargaDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoCargaDatosActionPerformed
        // TODO add your handling code here:
        this._arrMySon.add(this.frmParent.AbrirVentana("frmEditor", this._intID, new Method("H"), true));
    }//GEN-LAST:event_btnNuevoCargaDatosActionPerformed

    private void btnNuevoCromosomaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoCromosomaActionPerformed
        // TODO add your handling code here:
        this._arrMySon.add(this.frmParent.AbrirVentana("frmEditor", this._intID, new Method("C"), true));
    }//GEN-LAST:event_btnNuevoCromosomaActionPerformed

    private void btnNuevoMutacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoMutacionActionPerformed
        // TODO add your handling code here:
        this._arrMySon.add(this.frmParent.AbrirVentana("frmEditor", this._intID, new Method("M"), true));
    }//GEN-LAST:event_btnNuevoMutacionActionPerformed

    private void btnNuevoAptitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoAptitudActionPerformed
        // TODO add your handling code here:
        this._arrMySon.add(this.frmParent.AbrirVentana("frmEditor", this._intID, new Method("A"), true));
    }//GEN-LAST:event_btnNuevoAptitudActionPerformed

    private void btnNuevoSeleccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoSeleccionActionPerformed
        // TODO add your handling code here:
        this._arrMySon.add(this.frmParent.AbrirVentana("frmEditor", this._intID, new Method("S"), true));
    }//GEN-LAST:event_btnNuevoSeleccionActionPerformed

    private void btnNuevoCruzamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoCruzamientoActionPerformed
        // TODO add your handling code here:
        this._arrMySon.add(this.frmParent.AbrirVentana("frmEditor", this._intID, new Method("X"), true));
    }//GEN-LAST:event_btnNuevoCruzamientoActionPerformed

    private void btnNuevoParadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoParadaActionPerformed
        // TODO add your handling code here:
        this._arrMySon.add(this.frmParent.AbrirVentana("frmEditor", this._intID, new Method("O"), true));
    }//GEN-LAST:event_btnNuevoParadaActionPerformed

    private void btnGuardarConfiguracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarConfiguracionActionPerformed
        // TODO add your handling code here:
        this.guardarSolucion();
    }//GEN-LAST:event_btnGuardarConfiguracionActionPerformed

    private void btnLimpiarConfiguracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarConfiguracionActionPerformed
        // TODO add your handling code here:
        this.resetConfigurationTab();
    }//GEN-LAST:event_btnLimpiarConfiguracionActionPerformed

    private void tblDatosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblDatosKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tblDatosKeyPressed

    private void tblDatosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblDatosKeyReleased
        // TODO add your handling code here:
        this.addRow((JTable) evt.getSource());
    }//GEN-LAST:event_tblDatosKeyReleased

    private void tblDatosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblDatosKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_tblDatosKeyTyped

    private void tblDatosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tblDatosFocusLost
        // TODO add your handling code here:
        //this.removeUnusedRows((JTable)evt.getSource());
    }//GEN-LAST:event_tblDatosFocusLost

    private void tblCromosomaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblCromosomaKeyReleased
        // TODO add your handling code here:
        this.addRow((JTable) evt.getSource());
    }//GEN-LAST:event_tblCromosomaKeyReleased

    private void tblAptitudKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblAptitudKeyReleased
        // TODO add your handling code here:
        this.addRow((JTable) evt.getSource());
    }//GEN-LAST:event_tblAptitudKeyReleased

    private void tblSeleccionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblSeleccionKeyReleased
        // TODO add your handling code here:
        this.addRow((JTable) evt.getSource());
    }//GEN-LAST:event_tblSeleccionKeyReleased

    private void tblCruzamientoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblCruzamientoKeyReleased
        // TODO add your handling code here:
        this.addRow((JTable) evt.getSource());
    }//GEN-LAST:event_tblCruzamientoKeyReleased

    private void tblMutacionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblMutacionKeyReleased
        // TODO add your handling code here:
        this.addRow((JTable) evt.getSource());
    }//GEN-LAST:event_tblMutacionKeyReleased

    private void tblParadaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblParadaKeyReleased
        // TODO add your handling code here:
        //this.addRow((JTable) evt.getSource());
    }//GEN-LAST:event_tblParadaKeyReleased

    private void btnSalirConfiguracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirConfiguracionActionPerformed
        // TODO add your handling code here:
        this.CloseAll();
    }//GEN-LAST:event_btnSalirConfiguracionActionPerformed

    private void formComponentRemoved(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_formComponentRemoved
        // TODO add your handling code here:
    }//GEN-LAST:event_formComponentRemoved

    private void jTabbedPane1ComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTabbedPane1ComponentHidden
        // TODO add your handling code here:
        this.CloseAll();
    }//GEN-LAST:event_jTabbedPane1ComponentHidden

    private void btnSalirGeneralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirGeneralActionPerformed
        // TODO add your handling code here:
        this.CloseAll();
    }//GEN-LAST:event_btnSalirGeneralActionPerformed

    private void btnProbarConfiguracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProbarConfiguracionActionPerformed
         this.armarSolucion();                
            if (this.solucionCreada.Puede(Acciones.Ejecutar)) {
                 
                ArrayList<Method> listaMetodos = solucionCreada.getArrMethods();
                
                List<String> paths= new ArrayList<>();
                
                for(Method metodo : listaMetodos){
                                          
                   
                    paths.add(metodo.getPath());
        
                    
                }
                
                StringBuilder strBuild=null;
                String nombrePaquete = "prueba"+ULTIMO_NRO_PRUEBA++;
                try {
                    
                    strBuild = Compilador.armarUnidadDeCompilacion(paths,nombrePaquete );
                    Compilador.pruebaCompilacion(strBuild.toString());

                } catch (FileNotFoundException ex) {
                     JOptionPane.showMessageDialog(this, "Archivo no encontrado "+ex.getMessage(), "EGA", 1);               
                } catch (IOException ex) {
                     JOptionPane.showMessageDialog(this, "IO Exception "+ ex.getMessage(), "EGA", 1);
                } catch (CompileException ex) {
                    String ruta="system/erroresCompilacion/"+nombrePaquete+".txt";
                    strBuild.append(ex.getMessage());
                    file_handler filehand = new file_handler();
                    filehand.setPathFileToWrite(ruta);
                    filehand.setText(strBuild.toString());
                    filehand.Write();
                    StringBuilder strBuildMsg= new StringBuilder();
                    strBuildMsg.append(ex.getMessage());
                    strBuildMsg.append('\r');
                    strBuildMsg.append('\n');
                    strBuildMsg.append("Look at: "+ruta);
                    JOptionPane.showMessageDialog(this, strBuildMsg.toString(), "EGA", 1);
                    return;
                }
                
            } else {
                JOptionPane.showMessageDialog(this, Messages.strSolutionNotCompleted, "EGA", 1);
                return;
           }
            
           JOptionPane.showMessageDialog(this, "Su solución esta lista para ser ejecutada.", "EGA", 1);
           

            
    }//GEN-LAST:event_btnProbarConfiguracionActionPerformed

    private void btnEditarMetodoResultadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarMetodoResultadoActionPerformed
        // TODO add your handling code here:
        this.editingAction(this.cmbMetodoResultado);
    }//GEN-LAST:event_btnEditarMetodoResultadoActionPerformed

    private void btnNuevoMetodoResultadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoMetodoResultadoActionPerformed
        // TODO add your handling code here:
        this._arrMySon.add(this.frmParent.AbrirVentana("frmEditor", this._intID, new Method("I"), true));
    }//GEN-LAST:event_btnNuevoMetodoResultadoActionPerformed

    private void btnAyudaMetodoResultadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAyudaMetodoResultadoActionPerformed
        // TODO add your handling code here:
        if (this.cmbMetodoResultado.getItemCount() > 0 && this.cmbMetodoResultado.getSelectedIndex() >= 0) {
            javax.swing.JInternalFrame frm = this.frmParent.AbrirVentana("frmDescripcionFuncion", this._intID, getSelectedMethodInCombo(this.cmbMetodoResultado), false);
            ((frmDescripcionFuncion) frm).frmOpener = this;
            this._arrMySon.add(frm);
        } else {
            JOptionPane.showMessageDialog(this, Messages.strElementNotSelected, "EGA", 1);
        }
    }//GEN-LAST:event_btnAyudaMetodoResultadoActionPerformed

    private void btnUbicacionArchivoSolucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbicacionArchivoSolucionActionPerformed
        // TODO add your handling code here:
        String strInitialPath = !(this.txtUbicacionArchivoSolucion.getText()).isEmpty() ? this.txtUbicacionArchivoSolucion.getText() : paths.strSoluciones;
        String path = this.getSelectedPath(strInitialPath, true);
        if (!path.isEmpty()){
            this.txtUbicacionArchivoSolucion.setText(path);
            this.solutionModified();
        }
    }//GEN-LAST:event_btnUbicacionArchivoSolucionActionPerformed

    private void btnSalirResultadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirResultadosActionPerformed
        // TODO add your handling code here:
        this.CloseAll();
    }//GEN-LAST:event_btnSalirResultadosActionPerformed

    private void btnSalirInformesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirInformesActionPerformed
        // TODO add your handling code here:
        this.CloseAll();
    }//GEN-LAST:event_btnSalirInformesActionPerformed

    private void btnCarpetaPublicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarpetaPublicaActionPerformed
        // TODO add your handling code here:
        String strInitialPath = !(this.txtCarpetaPublica.getText()).isEmpty() ? this.txtCarpetaPublica.getText() : paths.strSoluciones;
        String path = this.getSelectedPath(strInitialPath, true);
        if (!path.isEmpty()){
            txtCarpetaPublica.setText(path);
            this.solutionModified();
        }
    }//GEN-LAST:event_btnCarpetaPublicaActionPerformed

    private void btnGuardarGeneralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarGeneralActionPerformed
        this.guardarSolucion();
    }//GEN-LAST:event_btnGuardarGeneralActionPerformed

    private void btnPublicarGeneralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPublicarGeneralActionPerformed
        this.publicarSolucion();
    }//GEN-LAST:event_btnPublicarGeneralActionPerformed

    private void btnPublicarConfiguracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPublicarConfiguracionActionPerformed
        this.publicarSolucion();
    }//GEN-LAST:event_btnPublicarConfiguracionActionPerformed

    private void btnExportarConfiguracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarConfiguracionActionPerformed
        // TODO add your handling code here:
        this.exportarSolucion();
    }//GEN-LAST:event_btnExportarConfiguracionActionPerformed

    private void btnPublicarResultadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPublicarResultadosActionPerformed
        // TODO add your handling code here:
        this.publicarSolucion();
    }//GEN-LAST:event_btnPublicarResultadosActionPerformed

    private void btnPublicarInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPublicarInicioActionPerformed
        // TODO add your handling code here:
        this.publicarSolucion();
    }//GEN-LAST:event_btnPublicarInicioActionPerformed

    private void btnExportarGeneralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarGeneralActionPerformed
        // TODO add your handling code here:
        this.exportarSolucion();
    }//GEN-LAST:event_btnExportarGeneralActionPerformed

    private void btnExportarResultadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarResultadosActionPerformed
        // TODO add your handling code here:
        this.exportarSolucion();
    }//GEN-LAST:event_btnExportarResultadosActionPerformed

    private void btnExportarInformeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarInformeActionPerformed
        // TODO add your handling code here:
        this.exportarSolucion();
    }//GEN-LAST:event_btnExportarInformeActionPerformed

    private void btnVerInformeInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerInformeInicioActionPerformed
        
        if(btnVerInformeInicio.getText().equals(GRABAR_RESULTADOS)){
            
                this.execute(this.procesoActual.generarResultados(), this.Grafica.TraerSubconjuntoCompleto());
                btnVerInformeInicio.setText(VER_INFORME);
        }else{
        //if (this.pathInforme != null) {
        int i = 0;
        ArrayList<Integer> valores[];
        String sJRXML = "system/plantillas/InformeEstandar1.jrxml";
        String sDataSource = this.pathInforme;
        //"system/plantillas/InformeEstandar1.xml";

        int iMaxima[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                         0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                         0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                         0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                         0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int iMedia[] =  {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                         0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                         0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                         0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                         0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int iMinima[] =  {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                         0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                         0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                         0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                         0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        

        valores = this.Grafica.TraerSubconjuntoCompleto();
        for (Integer valor : valores[0]){
            iMinima[i] = valores[0].get(i);
            iMedia[i] = valores[1].get(i);
            iMaxima[i] = valores[2].get(i);
            i++;
            if (i == 500 ) //con esto salvo la posibilidad de que alguna vez reviente el cogido.
                break;
        }
        this.VerInforme(sJRXML, sDataSource, this.Grafica.TipoGrafica, iMinima, iMedia, iMaxima);

        }
    }//GEN-LAST:event_btnVerInformeInicioActionPerformed

    private void lstArchivosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstArchivosValueChanged
        // TODO add your handling code here:
        Integer timesActioned = this.timesResultActioned.get(this.lstArchivos);
        if (timesActioned == 0) {
            this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
            ResourceInList file = this.getResourceFromList((JList) evt.getSource(), ((JList) evt.getSource()).getSelectedIndex());
            this.selectedResource = file;
            this.loadResults(file.file.GetPath());
            this.timesResultActioned.put(this.lstArchivos, 1);
            this.txtGanadores.setCaretPosition(0);
        } else {
            this.timesResultActioned.put(this.lstArchivos, 0);
        }
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_lstArchivosValueChanged

    private void btnVerInformeResultadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerInformeResultadosActionPerformed
        // TODO add your handling code here:
        if (selectedResource == null) {
            JOptionPane.showMessageDialog(this, Messages.strElementNotSelected, "EGA", 1);
            return;
        }
    
        String sJRXML = "system/plantillas/InformeEstandar1.jrxml";
        String DataSourcePath = this.selectedResource.file.GetPath();
        if (this.fh.FileFound(DataSourcePath).equals(file_handler._fileFound))
        {
            ArrayList<Integer[]> valores = this.ReadPoints(DataSourcePath);

            int iMaxima[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                             0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                             0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                             0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                             0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            int iMedia[] =  {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                             0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                             0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                             0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                             0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            int iMinima[] =  {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                             0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                             0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                             0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                             0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

            
            int i = 0;
            for (Integer valor: valores.get(0))
            {
                iMinima[i] = valor;
                i++;
                if (i == 500 ) //con esto salvo la posibilidad de que alguna vez reviente el cogido.
                    break;
            }

            i = 0;
            for (Integer valor: valores.get(1))
            {
                iMedia[i] = valor;
                i++;
                if (i == 500 ) //con esto salvo la posibilidad de que alguna vez reviente el cogido.
                    break;
            }
            
            i = 0;
            for (Integer valor: valores.get(2))
            {
                iMaxima[i] = valor;
                i++;
                if (i == 500 ) //con esto salvo la posibilidad de que alguna vez reviente el cogido.
                    break;
            }

            this.VerInforme(sJRXML, DataSourcePath, this.Grafica.TipoGrafica, iMinima, iMedia, iMaxima);
        
        } //FIN if fh.FileFound
        
        
    }//GEN-LAST:event_btnVerInformeResultadosActionPerformed

    private void tblResultadosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblResultadosKeyReleased
        // TODO add your handling code here:
        this.addRow((JTable) evt.getSource());
    }//GEN-LAST:event_tblResultadosKeyReleased

    private void txtPoblacionInicial1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPoblacionInicial1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPoblacionInicial1ActionPerformed

    private void executionCompleted(){
        this.timer.stop();
        this.txtFechaCompletado.setText(functions.getDate());
        this.solucionCreada.ExecutionCompleted();
        if (this.finished)
            this.enablePublishButton();
    }

    private void execute(List results, ArrayList<Integer> valores[]){
        if (!canceled){
            int i = 0;

            Integer iMaxima[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                             0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                             0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                             0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                             0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            Integer iMedia[] =  {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                             0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                             0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                             0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                             0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            Integer iMinima[] =  {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                             0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                             0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                             0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                             0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};



            // ESTE MANEJO CON VECTORES Integer ACA ADENTRO NO ESTA BUENO,
            // PORQUE SI LA GRAFICA DEVUELVE MAS DE 10...REVIENTA EL CODIGO
            // LA FUNCION QUE GRABA ESTOS 3 VECTORES, DEBERIA RECIBIR ArraList<Integer>
            for (Integer valor : valores[0]){
                iMinima[i] = valores[0].get(i);
                iMedia[i] = valores[1].get(i);
                iMaxima[i] = valores[2].get(i);
                i++;
                if (i == 500 ) //con esto salvo la posibilidad de que alguna vez reviente el cogido.
                    break;
            }

            this.solucionCreada.setExecutionResults(Result.ToStore(this.txtHoraInicio.getText(), (Integer) Integer.parseInt(this.txtCiclos.getText()), (Integer) Integer.parseInt(this.txtPoblacionActual.getText()), (Integer) Integer.parseInt(this.txtMutaciones.getText()), (Integer) Integer.parseInt(this.txtAptitudMaxima.getText()), (Integer) Integer.parseInt(this.txtAptitudMinima.getText()), results, iMinima, iMedia, iMaxima));
            String FileName = functions.GetRandomNameForResults(this.solucionCreada.getStrName()) + paths.strSolucionesExtension;
            String ResultPath = this.paths.strInformesResultados + paths.strResultadoPrefijo + FileName;

            this.fh.setPathFileToWrite(ResultPath);
            this.fh.CreateNewFile();
            this.solucionCreada.SaveResult(ResultPath);
            if (this.solucionCreada.result.OperationSucceed()) {
                this.modified = true;
                this.solucionCreada.getResultEGAFiles().add(new EGAFile(ResultPath, ResultPath));

                this.putDataInListView(this.solucionCreada.getResultEGAFiles(), lstArchivos);
                this.executionCompleted();
                this.pathInforme = ResultPath;
            } else {
                JOptionPane.showMessageDialog(this, Messages.strCouldNotSaved, "EGA", 1);
            }
        }
    }

    private void resetProcessTextBox(Solution solution, Date today){
        txtPoblacionInicial1.setText(solution.getIntSize().toString());
        txtHoraInicio.setText("--:--:--");
        txtCiclos.setText("0");
        txtAptitudMinima.setText("0");
        txtAptitudMaxima.setText("0");
        txtAptitudMedia.setText("0");
        txtDuracion.setText("--:--:--");
        txtPoblacionActual.setText("0");
        txtMutaciones.setText("0");
    }    
    
    private void btnComenzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComenzarActionPerformed
      
          if (this.btnComenzar.getText().equals(COMENZAR) ) {
                canceled = false;

                this.btnVerInformeInicio.setEnabled(false); 
                this.armarSolucion();                
            if (this.solucionCreada.Puede(Acciones.Ejecutar)) {
                 
                this.procesoActual = new Proceso(this);
                this.procesoActual.usa(this.solucionCreada);
                this.procesoActual.ejecutate();
                this.btnPausa.setSelected(false);
                this.btnPausa.setText(PAUSAR);
                this.btnVerInformeInicio.setText(GRABAR_RESULTADOS);


            } else {
                JOptionPane.showMessageDialog(this, Messages.strSolutionNotCompleted, "EGA", 1);
                return;
           }
            
        } else if (this.btnComenzar.getText().equals(FINALIZAR)) {
                this.timer.stop();
                this.procesoActual.pausate();
                this.finished = false;

                int rta = JOptionPane.showConfirmDialog(this, Messages.strCancelExecution, "Finalizar", 1);

                if (rta == JOptionPane.YES_OPTION) {
                    // CODIGO SI ELIGIO FINALIZAR EL PROCESO Y GUARDAR LOS RESULTADOS
                    canceled = false;
                    this.procesoActual.finalizate();
                    // this.guardarResultados=true;
                    this.btnPausa.setSelected(false);
                    this.btnPausa.setEnabled(false);
                    this.btnPausa.setText(PAUSAR);
                    this.btnComenzar.setText(COMENZAR);
                    this.btnVerInformeInicio.setEnabled(true);
                    this.btnVerInformeInicio.setText(VER_INFORME);    
            
                } else if (rta == JOptionPane.NO_OPTION) {
                    canceled = true;
                    // CODIGO SI ELIGIO ABORTAR TODO EL PROCESO SIN HACER NADA
                    this.procesoActual.finalizateSinResultados();
                    this.btnPausa.setSelected(false);
                    this.btnPausa.setEnabled(false);
                    this.btnPausa.setText(PAUSAR);
                    this.btnComenzar.setText(COMENZAR);
                    this.btnVerInformeInicio.setText(GRABAR_RESULTADOS);
                    this.btnVerInformeInicio.setEnabled(false);

                    
                } else if (rta == JOptionPane.CANCEL_OPTION) {
                    // CODIGO SI ELIGIO VOLVER A LA EJECUCION Y CONTINUARLA
                    if (this.btnPausa.isSelected() == false)
                    {
                        this.procesoActual.reanudate();
                        this.btnPausa.setEnabled(true);
                        this.btnPausa.setText(PAUSAR);
                    }
          
                    //this.btnComenzar.setText("Reanudar");
                    //this.procesoActual.pausate();
                }

//            this.txtFechaEjecucion.setText(functions.getDate());   
//            this.execute();

        }
             
//        if ((this.procesoActual == null) ) {
//                this.armarSolucion();                
//            if (this.solucionCreada.Puede(Acciones.Ejecutar)) {
//                if (this.Grafica.esNueva() == false)
//                    this.PrepararGrafica();
//                
//                Date today = functions.getToday();
//                this.resetProcessTextBox(this.solucionCreada, today);
//                txtHoraInicio.setText(functions.getTime(today));
//                txtDuracion.setText("00:00:00");
//                this.timer.start();
//  
//                this.btnComenzar.setText("Finalizar");
//                this.btnPausa.setEnabled(true);
//                this.procesoActual = new Proceso(this);
//                this.procesoActual.usa(this.solucionCreada);
//                this.procesoActual.ejecutate();
//            } else {
//                JOptionPane.showMessageDialog(this, Messages.strSolutionNotCompleted, "EGA", 1);
//                return;
//           }
//            
//        } else if (this.procesoActual.estaEjecutando()) {
//                this.timer.stop();
//                this.procesoActual.pausate();
//                this.finished = false;
//                int rta;
//                rta = JOptionPane.showConfirmDialog(this, Messages.strCancelExecution, "Finalizar", 1);
//
//                if (rta == JOptionPane.YES_OPTION) {
//                    // CODIGO SI ELIGIO FINALIZAR EL PROCESO Y GUARDAR LOS RESULTADOS
//                    this.procesoActual.finalizate();
////                this.guardarResultados=true;
//                    this.btnPausa.setEnabled(false);
//                    this.btnComenzar.setText("Comenzar");
//                } else if (rta == JOptionPane.NO_OPTION) {
//                    // CODIGO SI ELIGIO ABORTAR TODO EL PROCESO SIN HACER NADA
//                    this.procesoActual.finalizate();
//                    this.btnPausa.setEnabled(false);
//                    this.btnComenzar.setText("Comenzar");
//                } else if (rta == JOptionPane.CANCEL_OPTION) {
//                    // CODIGO SI ELIGIO VOLVER A LA EJECUCION Y CONTINUARLA
//                    this.procesoActual.reanudate();
//                    //this.btnComenzar.setText("Reanudar");
//                    //this.procesoActual.pausate();
//                }
//
////            this.txtFechaEjecucion.setText(functions.getDate());   
////            this.execute();

//        }




//        if (this.isInStatus("EXECUTING")){
//            this.PauseExcution();
//            this.btnTrigger.setText("Reanudar");
//            this.procesoActual.pausate();
//        }else if (this.isInStatus("PAUSED")){
//            this.StartExecution();
//            this.btnTrigger.setText("Pausar");
//            this.procesoActual.reanudate();
//            //this.btnTrigger.setText("Comenzar");
//        }else if (this.isInStatus("STOPPED")){
//            this.StartExecution();
//            this.btnTrigger.setText("Pausar");
//            this.armarSolucion();
//            this.solucionActual= new Solucion();
//            this.solucionActual.armate(this.solucionCreada);
//            this.procesoActual= new Proceso(this,this.solucionActual);
//            this.procesoActual.iniciarEjecucion();
//        }

    }//GEN-LAST:event_btnComenzarActionPerformed

    private void frmGraficaFijaInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_frmGraficaFijaInternalFrameOpened
    }//GEN-LAST:event_frmGraficaFijaInternalFrameOpened

    private void frmGraficaFijaInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_frmGraficaFijaInternalFrameActivated
        //ejecuta este codigo cada vez que le haces click al form.
        // TODO add your handling code here:
    }//GEN-LAST:event_frmGraficaFijaInternalFrameActivated

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
    }//GEN-LAST:event_formComponentShown

    private void btnEliminarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarArchivoActionPerformed
        // TODO add your handling code here:
        if (selectedResource == null) {
            JOptionPane.showMessageDialog(this, Messages.strElementNotSelected, "EGA", 1);
            return;
        }
        this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        this.armarSolucion();
        if (this.fh.FileFound(selectedResource.file.GetPath()).equals(file_handler._fileFound)) {
            this.selectedResource.file.Remove();
            if (this.selectedResource.file.result.OperationSucceed()) {
                this.arrResourceInList.remove(this.selectedResource);
                this.solucionCreada.getResultEGAFiles().remove(this.selectedResource.file);
                this.selectedResource = null;
                this.txtGanadores.setText("");
                this.solutionModified();
            } else {
                JOptionPane.showMessageDialog(this, Messages.strCantDeleted, "EGA", 1);
            }
        } else {
            this.arrResourceInList.remove(this.selectedResource);
            this.solucionCreada.getResultEGAFiles().remove(this.selectedResource.file);
            this.selectedResource = null;
            this.txtGanadores.setText("");
            this.solutionModified();
        }

        this.putDataInListView(this.solucionCreada.getResultEGAFiles(), lstArchivos);
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_btnEliminarArchivoActionPerformed

    private void tblDatosInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_tblDatosInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_tblDatosInputMethodTextChanged

    private void btnRefreshCargaDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshCargaDatosActionPerformed
        this.solutionModified();
        evt.setSource(cmbDatos);
        this.reiniciarParametros(cmbDatos);
        this.reloadParameters(evt);
    }//GEN-LAST:event_btnRefreshCargaDatosActionPerformed

    private void btnRefreshMetodoResultadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshMetodoResultadoActionPerformed
        this.solutionModified();
        evt.setSource(cmbMetodoResultado);
        this.reiniciarParametros(cmbMetodoResultado);
        this.reloadParameters(evt);
    }//GEN-LAST:event_btnRefreshMetodoResultadoActionPerformed

    private void reiniciarParametros(JComboBox combo){
        for (comboBox cmbCombo : this.jComboBoxes) {
            if (cmbCombo.combo == combo){
                int indexSelected = cmbCombo.combo.getSelectedIndex();
                for (MethodInCombo cmbMethod : this.getArrMethodsInCombo()) {
                    if (indexSelected == cmbMethod.position) {
                        cmbMethod.method.setParams(new ArrayList<Param>());
                    }
                }
            }
        }
    }
    
    private void btnRefreshSeleccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshSeleccionActionPerformed
        this.solutionModified();
        evt.setSource(cmbSeleccion);
        this.reiniciarParametros(cmbSeleccion);
        this.reloadParameters(evt);
    }//GEN-LAST:event_btnRefreshSeleccionActionPerformed

    private void btnRefreshCruzamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshCruzamientoActionPerformed
        this.solutionModified();
        evt.setSource(cmbCruzamiento);
        this.reiniciarParametros(cmbCruzamiento);
        this.reloadParameters(evt);
    }//GEN-LAST:event_btnRefreshCruzamientoActionPerformed

    private void btnRefreshCromosomaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshCromosomaActionPerformed
        this.solutionModified();
        evt.setSource(cmbCromosoma);
        this.reiniciarParametros(cmbCromosoma);
        this.reloadParameters(evt);
    }//GEN-LAST:event_btnRefreshCromosomaActionPerformed

    private void btnRefreshMutacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshMutacionActionPerformed
        this.solutionModified();
        evt.setSource(cmbMutacion);
        this.reiniciarParametros(cmbMutacion);        
        this.reloadParameters(evt);
    }//GEN-LAST:event_btnRefreshMutacionActionPerformed
    
    private void btnRefreshParadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshParadaActionPerformed
        this.solutionModified();
        evt.setSource(cmbParada);
        this.reiniciarParametros(cmbParada);        
        this.reloadParameters(evt);
    }//GEN-LAST:event_btnRefreshParadaActionPerformed

    private void btnRefreshAptitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshAptitudActionPerformed
        this.solutionModified();
        evt.setSource(cmbAptitud);
        this.reiniciarParametros(cmbAptitud);                
        this.reloadParameters(evt);
    }//GEN-LAST:event_btnRefreshAptitudActionPerformed

    private void tblParadaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tblParadaFocusLost

        this.addRow((JTable) evt.getSource());
        // TODO add your handling code here:
    }//GEN-LAST:event_tblParadaFocusLost

    private void txtPoblacionInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPoblacionInicialFocusLost
        txtPoblacionInicial1.setText(txtPoblacionInicial.getText());
    }//GEN-LAST:event_txtPoblacionInicialFocusLost

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        this.CloseAll();
    }//GEN-LAST:event_formInternalFrameClosing

    private void txtNombreObligatorioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreObligatorioKeyPressed
        this.solutionModified();
    }//GEN-LAST:event_txtNombreObligatorioKeyPressed

    private void txtNombreObligatorioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreObligatorioKeyReleased
        this.solutionModified();
    }//GEN-LAST:event_txtNombreObligatorioKeyReleased

    private void txtNombreObligatorioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreObligatorioKeyTyped
        this.solutionModified();
    }//GEN-LAST:event_txtNombreObligatorioKeyTyped

    private void txtAutorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAutorKeyPressed
        this.solutionModified();
    }//GEN-LAST:event_txtAutorKeyPressed

    private void txtAutorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAutorKeyReleased
        this.solutionModified();
    }//GEN-LAST:event_txtAutorKeyReleased

    private void txtAutorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAutorKeyTyped
        this.solutionModified();
    }//GEN-LAST:event_txtAutorKeyTyped

    private void txtArchivoSolucionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtArchivoSolucionKeyPressed
        this.solutionModified();
    }//GEN-LAST:event_txtArchivoSolucionKeyPressed

    private void txtArchivoSolucionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtArchivoSolucionKeyReleased
        this.solutionModified();
    }//GEN-LAST:event_txtArchivoSolucionKeyReleased

    private void txtArchivoSolucionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtArchivoSolucionKeyTyped
        this.solutionModified();
    }//GEN-LAST:event_txtArchivoSolucionKeyTyped

    private void txtFechaCompletadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaCompletadoKeyPressed
        this.solutionModified();
    }//GEN-LAST:event_txtFechaCompletadoKeyPressed

    private void txtFechaCompletadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaCompletadoKeyReleased
        this.solutionModified();
    }//GEN-LAST:event_txtFechaCompletadoKeyReleased

    private void txtFechaCompletadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaCompletadoKeyTyped
        this.solutionModified();
    }//GEN-LAST:event_txtFechaCompletadoKeyTyped

    private void txtFechaPublicacionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaPublicacionKeyPressed
        this.solutionModified();
    }//GEN-LAST:event_txtFechaPublicacionKeyPressed

    private void txtFechaPublicacionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaPublicacionKeyReleased
        this.solutionModified();
    }//GEN-LAST:event_txtFechaPublicacionKeyReleased

    private void txtFechaPublicacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaPublicacionKeyTyped
        this.solutionModified();
    }//GEN-LAST:event_txtFechaPublicacionKeyTyped

    private void txtDescripcionSolucionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionSolucionKeyPressed
        this.solutionModified();
    }//GEN-LAST:event_txtDescripcionSolucionKeyPressed

    private void txtDescripcionSolucionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionSolucionKeyReleased
        this.solutionModified();
    }//GEN-LAST:event_txtDescripcionSolucionKeyReleased

    private void txtDescripcionSolucionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionSolucionKeyTyped
        this.solutionModified();
    }//GEN-LAST:event_txtDescripcionSolucionKeyTyped

    private void txtObservacionSolucionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtObservacionSolucionKeyPressed
        this.solutionModified();
    }//GEN-LAST:event_txtObservacionSolucionKeyPressed

    private void txtObservacionSolucionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtObservacionSolucionKeyReleased
        this.solutionModified();
    }//GEN-LAST:event_txtObservacionSolucionKeyReleased

    private void txtObservacionSolucionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtObservacionSolucionKeyTyped
        this.solutionModified();
    }//GEN-LAST:event_txtObservacionSolucionKeyTyped

    private void chkSoloLecturaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkSoloLecturaItemStateChanged
        this.solutionModified();
    }//GEN-LAST:event_chkSoloLecturaItemStateChanged

    private void txtPoblacionInicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPoblacionInicialKeyPressed
        this.solutionModified();
    }//GEN-LAST:event_txtPoblacionInicialKeyPressed

    private void txtPoblacionInicialKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPoblacionInicialKeyReleased
        this.solutionModified();
    }//GEN-LAST:event_txtPoblacionInicialKeyReleased

    private void txtPoblacionInicialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPoblacionInicialKeyTyped
        this.solutionModified();
    }//GEN-LAST:event_txtPoblacionInicialKeyTyped

    private void cmbMetodoResultadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbMetodoResultadoItemStateChanged
        this.solutionModified();
    }//GEN-LAST:event_cmbMetodoResultadoItemStateChanged

    private void cmbDatosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbDatosItemStateChanged
        this.solutionModified();
    }//GEN-LAST:event_cmbDatosItemStateChanged

    private void cmbCrecimientoPoblacionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbCrecimientoPoblacionItemStateChanged
        this.solutionModified();
    }//GEN-LAST:event_cmbCrecimientoPoblacionItemStateChanged

    private void cmbCromosomaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbCromosomaItemStateChanged
        this.solutionModified();
    }//GEN-LAST:event_cmbCromosomaItemStateChanged

    private void cmbAptitudItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbAptitudItemStateChanged
        this.solutionModified();
    }//GEN-LAST:event_cmbAptitudItemStateChanged

    private void cmbSeleccionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbSeleccionItemStateChanged
        this.solutionModified();
    }//GEN-LAST:event_cmbSeleccionItemStateChanged

    private void cmbCruzamientoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbCruzamientoItemStateChanged
        this.solutionModified();
    }//GEN-LAST:event_cmbCruzamientoItemStateChanged

    private void cmbMutacionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbMutacionItemStateChanged
        this.solutionModified();
    }//GEN-LAST:event_cmbMutacionItemStateChanged

    private void cmbParadaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbParadaItemStateChanged
        this.solutionModified();
    }//GEN-LAST:event_cmbParadaItemStateChanged

    
    private void reloadParameters(java.awt.event.ActionEvent evt){
        CombosListener cmb = new CombosListener(this);
        cmb.actionPerformed(evt);
    }
    
    private void solutionModified(){
        if (!this.isLoading()){
            this.modified = true;
        }
    }
    
    private void loadResults(String Path) {
        txtGanadores.setText("");
        if (!this.fh.FileFound(Path).equals(file_handler._fileFound)) {
            JOptionPane.showMessageDialog(this, Messages.strFileNotExists, "EGA", 1);
            txtGanadores.setText(Messages.strNotPosibleToRender);
            return;
        }

        fh.setPathFileToRead(Path);
        this.fh.OpenXMLReader();
        Result ResultLoaded = this.fh.ReadResults();
        if (this.fh.result.OperationSucceed()) {
            txtGanadores.setText(ResultLoaded.getResultContentString());
        }else{
            txtGanadores.setText(Messages.strNotPosibleToRender);
        }
    }

    private ArrayList<Integer[]> ReadPoints(String Path) {
        if (Path == null || Path.isEmpty())
            return new ArrayList<Integer[]>();
        
        fh.setPathFileToRead(Path);
        fh.OpenXMLReader();
        ArrayList<Integer[]> Points = this.fh.ReadPoints();
        if (this.fh.result.OperationSucceed()) {
            return Points;
        }else{
            return new ArrayList<Integer[]>();
        }
    }

    private ResourceInList getResourceFromList(JList list, int position) {
        for (ResourceInList rl : this.arrResourceInList) {
            if (rl.position == position && rl.list == list) {
                return rl;
            }
        }

        return new ResourceInList();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAyudaAptitud;
    private javax.swing.JButton btnAyudaCargaDatos;
    private javax.swing.JButton btnAyudaCromosoma;
    private javax.swing.JButton btnAyudaCruzamiento;
    private javax.swing.JButton btnAyudaMetodoResultado;
    private javax.swing.JButton btnAyudaMutacion;
    private javax.swing.JButton btnAyudaParada;
    private javax.swing.JButton btnAyudaSeleccion;
    private javax.swing.JButton btnCarpetaPublica;
    private javax.swing.JButton btnComenzar;
    private javax.swing.JButton btnEditarAptitud;
    private javax.swing.JButton btnEditarCargaDatos;
    private javax.swing.JButton btnEditarCromosoma;
    private javax.swing.JButton btnEditarCruzamiento;
    private javax.swing.JButton btnEditarMetodoResultado;
    private javax.swing.JButton btnEditarMutacion;
    private javax.swing.JButton btnEditarParada;
    private javax.swing.JButton btnEditarSeleccion;
    private javax.swing.JButton btnEliminarArchivo;
    private javax.swing.JButton btnExportarConfiguracion;
    private javax.swing.JButton btnExportarGeneral;
    private javax.swing.JButton btnExportarInforme;
    private javax.swing.JButton btnExportarResultados;
    private javax.swing.JButton btnGuardarConfiguracion;
    private javax.swing.JButton btnGuardarGeneral;
    private javax.swing.JButton btnLimpiarConfiguracion;
    private javax.swing.JButton btnLimpiarGeneral;
    private javax.swing.JButton btnNuevoAptitud;
    private javax.swing.JButton btnNuevoCargaDatos;
    private javax.swing.JButton btnNuevoCromosoma;
    private javax.swing.JButton btnNuevoCruzamiento;
    private javax.swing.JButton btnNuevoMetodoResultado;
    private javax.swing.JButton btnNuevoMutacion;
    private javax.swing.JButton btnNuevoParada;
    private javax.swing.JButton btnNuevoSeleccion;
    private javax.swing.JToggleButton btnPausa;
    private javax.swing.JButton btnProbarConfiguracion;
    private javax.swing.JButton btnPublicarConfiguracion;
    private javax.swing.JButton btnPublicarGeneral;
    private javax.swing.JButton btnPublicarInicio;
    private javax.swing.JButton btnPublicarResultados;
    private javax.swing.JButton btnRefreshAptitud;
    private javax.swing.JButton btnRefreshCargaDatos;
    private javax.swing.JButton btnRefreshCromosoma;
    private javax.swing.JButton btnRefreshCruzamiento;
    private javax.swing.JButton btnRefreshMetodoResultado;
    private javax.swing.JButton btnRefreshMutacion;
    private javax.swing.JButton btnRefreshParada;
    private javax.swing.JButton btnRefreshSeleccion;
    private javax.swing.JButton btnSalirConfiguracion;
    private javax.swing.JButton btnSalirGeneral;
    private javax.swing.JButton btnSalirInformes;
    private javax.swing.JButton btnSalirResultados;
    private javax.swing.JButton btnUbicacionArchivoSolucion;
    private javax.swing.JButton btnVerInformeInicio;
    private javax.swing.JButton btnVerInformeResultados;
    private javax.swing.JCheckBox chkSoloLectura;
    private javax.swing.JComboBox cmbAptitud;
    private javax.swing.JComboBox cmbCrecimientoPoblacion;
    private javax.swing.JComboBox cmbCromosoma;
    private javax.swing.JComboBox cmbCruzamiento;
    private javax.swing.JComboBox cmbDatos;
    private javax.swing.JComboBox cmbMetodoResultado;
    private javax.swing.JComboBox cmbMutacion;
    private javax.swing.JComboBox cmbParada;
    private javax.swing.JComboBox cmbSeleccion;
    private javax.swing.JInternalFrame frmGraficaFija;
    private javax.swing.JButton jButton4;
    private javax.swing.JEditorPane jEditorPane6;
    private javax.swing.JEditorPane jEditorPane8;
    private javax.swing.JFileChooser jFCSave;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblAptitudMaxima;
    private javax.swing.JLabel lblAptitudMedia;
    private javax.swing.JLabel lblAptitudMinima;
    private javax.swing.JLabel lblArchivoSolucion;
    private javax.swing.JLabel lblAutor;
    private javax.swing.JLabel lblAutor3;
    private javax.swing.JLabel lblCarpetaPublica;
    private javax.swing.JLabel lblCiclos;
    private javax.swing.JLabel lblDuracion;
    private javax.swing.JLabel lblFechaCompletado;
    private javax.swing.JLabel lblFechaCreacion;
    private javax.swing.JLabel lblFechaEjecucion;
    private javax.swing.JLabel lblFechaModificacion;
    private javax.swing.JLabel lblFechaPublicacion;
    private javax.swing.JLabel lblGanadores;
    private javax.swing.JLabel lblHoraInicio;
    private javax.swing.JLabel lblListaArchivos;
    private javax.swing.JLabel lblMutaciones;
    private javax.swing.JLabel lblNombreObligatorio;
    private javax.swing.JLabel lblPoblacionActual;
    private javax.swing.JLabel lblPoblacionActual1;
    private javax.swing.JLabel lblPoblacionInicial;
    private javax.swing.JLabel lblUbicacionArchivoSolucion;
    private javax.swing.JList lstArchivos;
    private javax.swing.JPanel panAptitud;
    private javax.swing.JPanel panConfiguracion;
    private javax.swing.JPanel panConfiguracion1;
    private javax.swing.JPanel panConfiguracionVisualizacion;
    private javax.swing.JPanel panCromosoma;
    private javax.swing.JPanel panCruzamiento;
    private javax.swing.JPanel panDatos;
    private javax.swing.JPanel panGeneralDescripcion;
    private javax.swing.JPanel panGeneralFecha;
    private javax.swing.JPanel panGeneralObligatorio;
    private javax.swing.JPanel panGeneralObservacion;
    private javax.swing.JPanel panMutacion;
    private javax.swing.JPanel panOperador;
    private javax.swing.JPanel panOtrasOpciones;
    private javax.swing.JPanel panParada;
    private javax.swing.JPanel panProceso;
    private javax.swing.JPanel panSeleccion;
    private javax.swing.JPanel panSolucionDescripcion6;
    private javax.swing.JPanel panSolucionDescripcion8;
    private javax.swing.JTable tblAptitud;
    private javax.swing.JTable tblCromosoma;
    private javax.swing.JTable tblCruzamiento;
    private javax.swing.JTable tblDatos;
    private javax.swing.JTable tblMutacion;
    private javax.swing.JTable tblParada;
    private javax.swing.JTable tblResultados;
    private javax.swing.JTable tblSeleccion;
    private javax.swing.JTextField txtAptitudMaxima;
    private javax.swing.JTextField txtAptitudMedia;
    private javax.swing.JTextField txtAptitudMinima;
    private javax.swing.JTextField txtArchivoSolucion;
    private javax.swing.JTextField txtAutor;
    private javax.swing.JTextField txtAutor3;
    private javax.swing.JTextField txtCarpetaPublica;
    private javax.swing.JTextField txtCiclos;
    private javax.swing.JEditorPane txtDescripcionSolucion;
    private javax.swing.JTextField txtDuracion;
    private javax.swing.JFormattedTextField txtFechaCompletado;
    private javax.swing.JFormattedTextField txtFechaCreacion;
    private javax.swing.JFormattedTextField txtFechaEjecucion;
    private javax.swing.JFormattedTextField txtFechaModificacion;
    private javax.swing.JFormattedTextField txtFechaPublicacion;
    private javax.swing.JTextArea txtGanadores;
    private javax.swing.JTextField txtHoraInicio;
    private javax.swing.JTextField txtMutaciones;
    private javax.swing.JTextField txtNombreObligatorio;
    private javax.swing.JEditorPane txtObservacionSolucion;
    private javax.swing.JTextField txtPoblacionActual;
    private javax.swing.JTextField txtPoblacionInicial;
    private javax.swing.JTextField txtPoblacionInicial1;
    private javax.swing.JTextField txtUbicacionArchivoSolucion;
    // End of variables declaration//GEN-END:variables

    private void exportarSolucion() {
        this.armarSolucion();

        if (this.solucionCreada.Puede(Acciones.Exportar)) {
            
            String path = this.getSelectedPath(paths.strSoluciones, true);
            if (path.length() > 0){
                String NewFolder = path + "\\" + this.solucionCreada.getStrName();
                if (!this.fh.FolderExists(NewFolder)){
                    this.fh.CreateFolder(NewFolder);
                    if (!this.fh.result.OperationSucceed()){
                        JOptionPane.showMessageDialog(this, Messages.strSolutionNotExported, "EGA", 1);
                        return;
                    }
                }


                path = NewFolder + "\\" + this.solucionCreada.getStrFile();


                this.exportMethods(this.solucionCreada.getArrMethods(), NewFolder);
                if (this.fh.result.OperationSucceed()) {
                    this.fh.SaveXML(this.solucionCreada, path);
                    JOptionPane.showMessageDialog(this, Messages.strSolutionSuccesfulyExported, "EGA", 1);
                } else {
                    JOptionPane.showMessageDialog(this, Messages.strSolutionNotExported, "EGA", 1);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, Messages.strMinimumFieldsNotCompletedToExport, "EGA", 1);
        }
    }

    private void publicarSolucion() {
        this.armarSolucion();

        if (this.solucionCreada.Puede(Acciones.Publicar)) {
            String NewFolder = this.solucionCreada.getStrServerFolder() + "\\" + this.solucionCreada.getStrName();
            
            if (!this.fh.FolderExists(NewFolder)){
                this.fh.CreateFolder(NewFolder);
                if (!this.fh.result.OperationSucceed()){
                    JOptionPane.showMessageDialog(this, Messages.strSolutionNotPublished, "EGA", 1);
                    return;
                }
            }

            Solution solutionToPublish = (Solution)this.solucionCreada.clone();
            
            String strPath = NewFolder + "\\" + solutionToPublish.getStrFile();
            if (this.txtFechaPublicacion.getText().isEmpty()) {
                this.txtFechaPublicacion.setText(functions.getDate());
            }

            this.exportMethods(solutionToPublish.getArrMethods(), NewFolder);
            if (this.fh.result.OperationSucceed()) {
                this.save(strPath, solutionToPublish);
                if (this.fh.result.OperationSucceed()) {
                    JOptionPane.showMessageDialog(this, Messages.strSolutionSuccesfulyPublished, "EGA", 1);
                } else {
                    JOptionPane.showMessageDialog(this, Messages.strSolutionNotPublished, "EGA", 1);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, Messages.strMinimumFieldsNotCompletedToPublish, "EGA", 1);
        }
    }

    
    
    private boolean guardarSolucion(){
        this.armarSolucion();
        if (this.solucionCreada.Puede(Acciones.Guardar)){
            
            String Path = solucionCreada.getStrFolder() + "\\" + solucionCreada.getStrFile();
            String XMLSolucion = Encriptador.Encriptar(GeneradorXML.GenerarXML(this.solucionCreada));
            
            this.ResetOperationStatus();
            this.fh.GuardarContenido(XMLSolucion, Path);       
            this.ActualizarBaseDeDatos(solucionCreada);
            
            if (this.fh.result.OperationSucceed()) {
                JOptionPane.showMessageDialog(this, Messages.strSolutionSuccesfulySaved, "EGA", 1);
            }else{
                JOptionPane.showMessageDialog(this, Messages.strSolutionNotSaved, "EGA", 1);
            }
            
            this.cambiosGuardados();
            return true;
        }
        
        return false;        
    }

    private void cambiosGuardados(){
        this.modified = false;
    } 
    
    
    private void save(String strPath, Solution solution) {
        this.ResetOperationStatus();
        boolean blnSave = false;

        if (this.fh.FileFound(strPath).equals(file_handler._fileFound)) {
            blnSave = (JOptionPane.showConfirmDialog(this, Messages.strFileAlreadyExists, "EGA", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) ? true : false;
        } else {
            blnSave = true;
            this.fh.setPathFileToWrite(solution.getStrFolder() + "\\" + solution.getStrFile());
            this.fh.CreateNewFile();
        }

        this.ResetOperationStatus();
        if (blnSave) {
            this.fh.SaveXML(solution, strPath);
        }
    }

    private void ActualizarBaseDeDatos(Solution solution) {
        this.ResetOperationStatus();

        ArrayList<Solution> SolutionsInDB = Solution.GetSolutionsInDB();
        ArrayList<Solution> SolucionesAInsertar = Solution.UpdateStoredSolutions(solution, SolutionsInDB);

        data_type_converter dtc = new data_type_converter();
        dtc.ToByteString(SolucionesAInsertar);
        String Texto = Encriptador.Encriptar(dtc.getStrText());

        if (dtc.result.OperationSucceed()){
            this.fh.GuardarEnBase(Texto, paths.strSolucionDB);

            if (this.fh.result.OperationSucceed()) {
                this.result.Status = OperationResult._success;
                this.path = solution.getStrFolder() + "\\" + solution.getStrFile();
            } else {
                this.RollBackFilesCopy(new String[]{solution.getStrFolder() + "\\" + solution.getStrFile()});
            }
        }
    }

    private void RollBackFilesCopy(String[] PathFiles) {
        this.ResetOperationStatus();
        for (String path : PathFiles) {
            this.fh.RemoveFile(path);
        }
    }

    private void ResetOperationStatus() {
        this.result.ResetStatus();
        this.fh.result.ResetStatus();
    }

    private String getSelectedPath(String strInitialPath, boolean blnDirectories) {
        if (intLoading == 0) {
            File file = new File(strInitialPath);
            this.jFCSave.setCurrentDirectory(file);

            if (blnDirectories) {
                this.jFCSave.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            } else {
                this.jFCSave.setFileSelectionMode(JFileChooser.FILES_ONLY);
            }

            return this.ChooseFile();
        }

        return "";
    }

    public boolean CloseAll() {
        int intSons = this._arrMySon.size();

        for (int a = 0; a < intSons; a++) {
            boolean closed = false;
            javax.swing.JInternalFrame frm = this._arrMySon.get(a);

            switch (frm.getClass().toString().split("class Formularios.")[1]) {
                case forms.Editor:
                    if (((frmEditor) frm).CloseAll()) {
                        closed = true;
                    }
                    break;
                case forms.DescripcionFuncion:
                    if (((frmDescripcionFuncion) frm).CloseAll()) {
                        closed = true;
                    }
                    break;
                case forms.Grafica:
                    if (((frmGrafica) frm).CloseAll()) {
                        closed = true;
                    }
                    break;
                case forms.Informe:
                    if (((frmInforme) frm).CloseAll()) {
                        closed = true;
                    }
                    break;
                case forms.InformeConfiguracion:
                    if (((frmInformeConfiguracion) frm).CloseAll()) {
                        closed = true;
                    }
                    break;
            }

            if (closed) {
                this._arrMySon.remove(frm);
                a--;
                intSons--;
            }

        }

        if (this._arrMySon.isEmpty() && canCloseMe()) {
            this.setVisible(false);
            this.dispose();
            return true;
        }

        return false;
    }

    public boolean isEditing(Method met) {
        int intSons = this._arrMySon.size();

        for (int a = 0; a < intSons; a++) {
            javax.swing.JInternalFrame frm = this._arrMySon.get(a);
            if (frm.getClass().toString().split("class Formularios.")[1].equals(forms.Editor)) {
                if (((frmEditor) frm).isEditing(met)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean canCloseMe() {
        if (!this.modified){ // No modification done
            return true;
        }

        int optionSelected = JOptionPane.showConfirmDialog(this, Messages.strClosingWithoutSaving, "EGA", JOptionPane.YES_NO_CANCEL_OPTION);
        switch (optionSelected) {
            case JOptionPane.YES_OPTION:
                if (this.guardarSolucion()){
                    return true;
                }else{
                    return false;
                }
            case JOptionPane.NO_OPTION:
                this.setVisible(false);
                return true;
            case JOptionPane.CANCEL_OPTION:
                return false;
            default:
                return true;
        }
    }

    public void CloseSon(javax.swing.JInternalFrame frm) {
        this._arrMySon.remove(frm);
    }

    private void addRow(JTable table) {
//        DefaultTableModel modelo = (DefaultTableModel) table.getModel();
//        modelo.addRow(ROW_VACIA);
//        DefaultTableModel modelo = (DefaultTableModel) table.getModel();
//        
//        int column = table.getSelectedColumn(); 
//        int row = table.getSelectedRow();
//        
//                
//        modelo.setValueAt(table.getValueAt(row, column), row, column);        
        int _numberRows = table.getRowCount();
        int _numberRowsUsed = 0;
        //Object[][] data = new Object[_numberRows + 1][2];
        Object[][] data = new Object[_numberRows][2];


        for (int a = 0; a < _numberRows; a++) {
            if ((table.getValueAt(a, 0) != null && !(table.getValueAt(a, 0).toString().isEmpty())) || table.getValueAt(a, 1) != null && !(table.getValueAt(a, 1).toString().isEmpty())) {
                _numberRowsUsed++;
                data[a][0] = table.getValueAt(a, 0) != null ? table.getValueAt(a, 0) : "";
                data[a][1] = table.getValueAt(a, 1) != null ? table.getValueAt(a, 1) : "";
            }
        }


        if (_numberRowsUsed == _numberRows) {
            table.setModel(new javax.swing.table.DefaultTableModel(data, this.strParamsTableHeader));
        }
    }

    public boolean IsFromFamily(Integer intID) {
        return intID == this._intID;
    }

    private void setFormObjects() {
        this.SetComboBoxes();
        this.SetTables();

        this.timesResultActioned.put(this.lstArchivos, 0);
    }

    private void startLoading() {
        this.intLoading = 1;
    }

    private void finishLoading() {
        this.intLoading = 0;
    }
    
    private boolean isLoading(){
        return this.intLoading == 1;
    }

    private void disableAll() {
        this.txtNombreObligatorio.setEnabled(false);
        this.txtAutor.setEnabled(false);
        this.txtArchivoSolucion.setEnabled(false);
        this.txtUbicacionArchivoSolucion.setEnabled(false);
        this.btnUbicacionArchivoSolucion.setEnabled(false);

        this.txtFechaEjecucion.setEnabled(false);
        this.txtFechaCreacion.setEnabled(false);
        this.txtFechaModificacion.setEnabled(false);
        this.txtFechaCompletado.setEnabled(false);
        this.txtFechaPublicacion.setEnabled(false);

        this.txtDescripcionSolucion.setEnabled(false);
        this.txtObservacionSolucion.setEnabled(false);

        this.chkSoloLectura.setEnabled(false);
        this.txtCarpetaPublica.setEnabled(false);
        this.btnCarpetaPublica.setEnabled(false);

        this.txtPoblacionInicial.setEnabled(false);
        this.cmbCrecimientoPoblacion.setEnabled(false);
        this.cmbMetodoResultado.setEnabled(false);

        for (comboBox combo : this.jComboBoxes) {
            combo.combo.setEnabled(false);
        }

        for (JTable table : this.jTables) {
            table.setEnabled(false);
        }
    }

    private void setInControls() {
        this.txtNombreObligatorio.setText(this.solution.getStrName());
        this.txtAutor.setText(this.solution.getStrAuthor());
        this.txtArchivoSolucion.setText(this.solution.getStrFile());
        this.txtUbicacionArchivoSolucion.setText(this.solution.getStrFolder());

        this.txtFechaEjecucion.setText(this.solution.getStrExecuted());
        this.txtFechaCreacion.setText(this.solution.getStrCreated());
        this.txtFechaModificacion.setText(this.solution.getStrModified());
        this.txtFechaCompletado.setText(this.solution.getStrCompleted());
        this.txtFechaPublicacion.setText(this.solution.getStrPublished());

        this.txtDescripcionSolucion.setText(this.solution.getStrDescription());
        this.txtObservacionSolucion.setText(this.solution.getStrObservation());

        this.chkSoloLectura.setSelected(this.solution.getBlnReadOnly());
        this.txtCarpetaPublica.setText(this.solution.getStrServerFolder());

        this.txtPoblacionInicial.setText(this.solution.getIntSize().toString());
        this.cmbCrecimientoPoblacion.setSelectedIndex(this.solution.ObtenerTipoCrecimientoIndice());

        if (!this.solution.getStrCompleted().isEmpty()) {
            this.enablePublishButton();
        }

        ArrayList<Method> NotAccesibleFiles = new ArrayList<Method>();

        ArrayList<Method> _arrMethod = this.solution.getArrMethods();
        for (Method _method : _arrMethod) {
            JComboBox _cmbToUse;
            JButton _btnToUse;
            JTable _tblToUse;
            String _TypeMethod = _method.getIndex().substring(0, 1);

            switch (_TypeMethod) {
                case "C":
                    _cmbToUse = this.cmbCromosoma;
                    _tblToUse = this.tblCromosoma;
                    _btnToUse = this.btnRefreshCromosoma;
                    break;
                case "A":
                    _cmbToUse = this.cmbAptitud;
                    _tblToUse = this.tblAptitud;
                    _btnToUse = this.btnRefreshAptitud;
                    break;
                case "S":
                    _cmbToUse = this.cmbSeleccion;
                    _tblToUse = this.tblSeleccion;
                    _btnToUse = this.btnRefreshSeleccion;
                    break;
                case "X":
                    _cmbToUse = this.cmbCruzamiento;
                    _tblToUse = this.tblCruzamiento;
                    _btnToUse = this.btnRefreshCruzamiento;
                    break;
                case "M":
                    _cmbToUse = this.cmbMutacion;
                    _tblToUse = this.tblMutacion;
                    _btnToUse = this.btnRefreshMutacion;
                    break;
                case "O":
                    _cmbToUse = this.cmbParada;
                    _tblToUse = this.tblParada;
                    _btnToUse = this.btnRefreshParada;
                    break;
                case "H":
                    _cmbToUse = this.cmbDatos;
                    _tblToUse = this.tblDatos;
                    _btnToUse = this.btnRefreshCargaDatos;
                    break;
                case "I":
                    _cmbToUse = this.cmbMetodoResultado;
                    _tblToUse = this.tblResultados;
                    _btnToUse = this.btnRefreshMetodoResultado;
                    break;
                default:
                    continue;
            }


            boolean found = false;
            boolean loadParameters = true;
            for (MethodInCombo _meth : this.arrMethodsInCombo) {
                if (_meth.combo == _cmbToUse && _meth.method.getPath().equals(_method.getPath())) {
                    found = true;
                    _meth.combo.setSelectedIndex(_meth.position);
                }
            }

            if (!found) {
                Method met = new Method(_method.getIndex().substring(1, 2), _method.getName(), _method.getDescription(), false, _method.getPath(), _method.getCreated(), _method.getModified(), _method.getAuthor());
                met.setFirstLetter(_method.getIndex().substring(0, 1));
                met.setParams(_method.getParams());

                if (this.fh.FileFound(_method.getPath()).equals(file_handler._fileFound)) {
                    int position = _cmbToUse.getItemCount();
                    this.arrMethodsInCombo.add(new MethodInCombo(met, _cmbToUse, position));
                    _cmbToUse.addItem(_method.getName() + Messages.strUserMethod);
                    _cmbToUse.setSelectedIndex(position);
                } else {
                    loadParameters = false;
                    NotAccesibleFiles.add(met);
                }
            }

            if (loadParameters) {
                Object[][] data = new Object[_method.getParams().size()][];
                int paramN = 0;
                for (Param param : _method.getParams()) {
                    Object[] oneParam = {param.getName(), param.getValue()};
                    data[paramN] = oneParam;
                    paramN++;
                }
                if (data.length > 0) {
                    _tblToUse.setModel(new javax.swing.table.DefaultTableModel(data, this.strParamsTableHeader));
                }else{
                    this.intLoading = 0;
                    _btnToUse.doClick();
                    this.intLoading = 1;
                }
            }
        }

        this.putDataInListView(this.solution.getResultEGAFiles(), lstArchivos);

        if (!NotAccesibleFiles.isEmpty()) {
            String MethodsWillNotOpen = "";
            int counter = 1;
            for (Method met : NotAccesibleFiles) {
                String type = met.getType().equals("AYUDANTE") ? "DATOS" : met.getType();
                
                MethodsWillNotOpen += "    " + counter + ". " + type + ": " + met.getName() + " - " + met.getPath() + System.getProperty("line.separator");
                counter++;
            }
            JOptionPane.showMessageDialog(this, Messages.strFollowingMethodsWillNotOpen + MethodsWillNotOpen, "EGA", 1);
        }

        if (this.solution.getBlnReadOnly()) {
            this.disableAll();
        }
    }

    private void putDataInListView(ArrayList<EGAFile> files, javax.swing.JList ListView) {
        this.arrResourceInList.clear();
        int totalFiles = files.size();
        DefaultListModel model = new DefaultListModel();
        
        if (totalFiles > 0) {
            for (int a = 0; a < totalFiles; a++) {
                model.addElement(files.get(a).GetPath());
                this.arrResourceInList.add(new ResourceInList(files.get(a), ListView, a));
            }

        }

        ListView.removeAll();
        try{
            ListView.setModel(model);
        }catch(Exception ex){
            this.setCursor(Cursor.getDefaultCursor()); 
        }
    }

    private void openExistingSolution(String strSolution) {
        fh.setPathFileToRead(strSolution);
        fh.OpenXMLReader();

        if (this.canOpenSolution()) {
            ArrayList<HashMap<String, String>> _strHmArrSolution = fh.getArrXMLSolutionHeader();
            ArrayList<HashMap<String, String>> _strHmArrSolutionSettings = fh.getArrXMLSolutionSettings();
            ArrayList<HashMap<String, String>> _strHmArrSolutionInitialPopulation = fh.getArrXMLSolutionInitialPopulation();
            ArrayList<Method> _metArrXMLSolution = fh.getArrXMLSolution();
            ArrayList<EGAFile> _fileResult = fh.getArrXMLResultFiles();

            boolean blnReadOnly = Integer.parseInt(_strHmArrSolutionSettings.get(0).get("readOnly")) != 0 ? true : false;

            if (this.blnImport) {
                _metArrXMLSolution = this.importMethods(_metArrXMLSolution);
            }

            this.solution = new Solution();
            this.solution.SetHeader(_strHmArrSolution.get(0).get("name"), _strHmArrSolution.get(1).get("author"), _strHmArrSolution.get(2).get("file"), _strHmArrSolution.get(3).get("folder"), _strHmArrSolution.get(4).get("dateCreated"), _strHmArrSolution.get(5).get("dateModified"), _strHmArrSolution.get(6).get("dateCompleted"), _strHmArrSolution.get(7).get("dateExecuted"), _strHmArrSolution.get(8).get("datePublished"), _strHmArrSolution.get(9).get("description"), _strHmArrSolution.get(10).get("observation"));
            this.solution.SetSettings(blnReadOnly, _strHmArrSolutionSettings.get(1).get("serverFolder"));
            this.solution.SetInitialPopulation(Integer.parseInt(_strHmArrSolutionInitialPopulation.get(0).get("size")), Integer.parseInt(_strHmArrSolutionInitialPopulation.get(1).get("increasingStyle")));
            this.solution.setArrMethods(_metArrXMLSolution);
            this.solution.setResultEGAFiles(_fileResult);

            if (this.blnImport) {
                //this.saveTheSolution(this.solution);
            }

            this.path = this.solution.getStrFolder() + "\\" + this.solution.getStrFile() + paths.strSolucionesExtension;
        }
    }

    private ArrayList<Method> importMethods(ArrayList<Method> arrMethods) {
        String strMethodsNotFound = "", strMethodsToImport = "", strMessage = "";
        ArrayList<Method> arrMethToImport = new ArrayList<Method>();

        for (Method meth : arrMethods) {
            meth.setFirstLetter(meth.getIndex().substring(0, 1));
            meth.setIndex(meth.getIndex().substring(1, 2));

            if (this.fh.FileFound(meth.getPath()).equals(file_handler._fileFound)) {
                if (!this.fh.FileIsInside(meth.getPath(), paths.strHome)) {
                    strMethodsToImport += (Messages.strMethodsToImportTemplate.replace("__MET__", meth.getName())).replace("__PAT__", meth.getPath());
                    arrMethToImport.add(meth);
                }
            } else {
                strMethodsNotFound += (Messages.strMethodsToImportTemplate.replace("__MET__", meth.getName())).replace("__PAT__", meth.getPath());
            }
        }

        if (!strMethodsNotFound.isEmpty()) {
            strMessage += Messages.strFollowingMethodsWillNotImport + strMethodsNotFound;
        }

        if (!strMethodsToImport.isEmpty()) {
            strMessage += Messages.strFollowingMethodsWillImport + strMethodsToImport;
            if (JOptionPane.showConfirmDialog(this, strMessage, "EGA", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                this.copyMethod(arrMethToImport);
            } else {
                this.blnImport = false;
            }
        } else {
            if (!strMessage.isEmpty())
                JOptionPane.showMessageDialog(this, Messages.strSolutionWillNotImport + strMessage, "EGA", JOptionPane.ERROR_MESSAGE);
            this.blnImport = false;
        }

        return arrMethods;
    }

    private void copyMethod(ArrayList<Method> arrMeth) {
        ArrayList<Method> arrMethodsToSave = new ArrayList<Method>();
        ArrayList<Method> arrMethodsNotToSave = new ArrayList<Method>();

        for (Method meth : arrMeth) {
            String[] strPaths = this.getDefaultFolderFromMethodType(meth.getType());
            this.setNullValues(meth);
            this.fh.CopyMethod(meth.getPath(), strPaths[0]);
            meth.setSelected(true);
            meth.setPath(this.fh.getPathFileToWrite());
            arrMethodsToSave.add(meth);
            this.arrMethods.add(meth);
        }

        if (!arrMethodsNotToSave.isEmpty()) {
            JOptionPane.showMessageDialog(this, Messages.strFollowingMethodsWillNotImportAnotherReason, "EGA", 1);
        }

        if (!arrMethodsToSave.isEmpty()) {
            this.appendToDB();
        }
    }

    private void exportMethods(ArrayList<Method> arrMeth, String strDestination) {
        ArrayList<Method> NewMethods = new ArrayList<Method>();
        for (Method meth : arrMeth) {
            if (this.fh.FileFound(meth.getPath()).equals(file_handler._fileFound)) {
                Method NewMethod = (Method)meth.clone();
                NewMethod.setPath(this.fh.CopyMethod(NewMethod.getPath(), strDestination));
                NewMethods.add(NewMethod);
            }
        }
        
        arrMeth.clear();
        arrMeth.addAll(NewMethods);
    }

    private void setNullValues(Method meth) {
        meth.setCreated(functions.getDate());
        meth.setModified(functions.getDate());
        meth.setAuthor("");
        meth.setDescription("");
    }

    private boolean appendToDB() {
        ArrayList<Method> metSelection = new ArrayList<>();
        ArrayList<Method> metMutation = new ArrayList<>();
        ArrayList<Method> metCrossing = new ArrayList<>();
        ArrayList<Method> metStop = new ArrayList<>();
        ArrayList<Method> metInform = new ArrayList<>();
        ArrayList<Method> metFunctionAptitude = new ArrayList<>();
        ArrayList<Method> metHelper = new ArrayList<>();
        ArrayList<Method> metChromosome = new ArrayList<>();

        ArrayList<Method> arrMethods = new ArrayList<Method>();
        arrMethods.addAll(this.arrMethods);
        //arrMethods.addAll(arrMethodsToSave);

        for (Method _method : arrMethods) {
            switch (_method.getFirstLetter()) {
                case "C":
                    metChromosome.add(_method);
                    break;
                case "S":
                    metSelection.add(_method);
                    break;
                case "M":
                    metMutation.add(_method);
                    break;
                case "X":
                    metCrossing.add(_method);
                    break;
                case "O":
                    metStop.add(_method);
                    break;
                case "I":
                    metInform.add(_method);
                    break;
                case "A":
                    metFunctionAptitude.add(_method);
                    break;
                case "H":
                    metHelper.add(_method);
                    break;
            }
        }
        this.storeMethods(metSelection, metMutation, metCrossing, metStop, metInform, metFunctionAptitude, metHelper, metChromosome);
        return true;
    }

    private void storeMethods(ArrayList<Method> metSelection, ArrayList<Method> metMutation, ArrayList<Method> metCrossing, ArrayList<Method> metStop, ArrayList<Method> metInform, ArrayList<Method> metAptitudeFunction, ArrayList<Method> metHelper, ArrayList<Method> metChromosome) {
        data_type_converter dtc = new data_type_converter();

        this.store(metSelection, paths.strSeleccionDB, dtc);
        this.store(metMutation, paths.strMutacionDB, dtc);
        this.store(metCrossing, paths.strCruzamientoDB, dtc);
        this.store(metStop, paths.strParoDB, dtc);
        this.store(metInform, paths.strInformeDB, dtc);
        this.store(metAptitudeFunction, paths.strAptitudDB, dtc);
        this.store(metHelper, paths.strAyudanteDB, dtc);
        this.store(metChromosome, paths.strCromosomaDB, dtc);
    }

    private void store(ArrayList<Method> met, String strPath, data_type_converter dtc) {
        if (!met.isEmpty()) {
            dtc.setArrMethods(met);
            dtc.fromMethodToByteString();
            this.fh.setByteText(dtc.getByteText());
            this.fh.setPathFileToWrite(strPath);
            this.fh.WriteBinary(dtc.getStrText());
        } else {
            this.fh.setPathFileToWrite(strPath);
            this.fh.CleanFile();
        }
    }

    private String[] getDefaultFolderFromMethodType(String strType) {
        String[] arrStrMethodFiles = new String[2];
        switch (strType.toUpperCase()) {
            case "FUNCIÓN APTITUD":
                arrStrMethodFiles[0] = paths.strAptitudMetodos;
                arrStrMethodFiles[1] = paths.strAptitudDB;
                break;
            case "CROMOSOMA":
                arrStrMethodFiles[0] = paths.strCromosomaMetodos;
                arrStrMethodFiles[1] = paths.strCromosomaDB;
                break;
            case "SELECCIÓN":
                arrStrMethodFiles[0] = paths.strSeleccionMetodos;
                arrStrMethodFiles[1] = paths.strSeleccionDB;
                break;
            case "MUTACIÓN":
                arrStrMethodFiles[0] = paths.strMutacionMetodos;
                arrStrMethodFiles[1] = paths.strMutacionDB;
                break;
            case "CRUZAMIENTO":
                arrStrMethodFiles[0] = paths.strCruzamientoMetodos;
                arrStrMethodFiles[1] = paths.strCruzamientoDB;
                break;
            case "PARO":
                arrStrMethodFiles[0] = paths.strParoMetodos;
                arrStrMethodFiles[1] = paths.strParoDB;
                break;
            case "INFORME":
                arrStrMethodFiles[0] = paths.strInformeMetodos;
                arrStrMethodFiles[1] = paths.strInformeDB;
                break;
            case "AYUDANTE":
                arrStrMethodFiles[0] = paths.strAyudanteMetodos;
                arrStrMethodFiles[1] = paths.strAyudanteDB;
                break;
        }

        return arrStrMethodFiles;
    }

    private boolean canOpenSolution() {
        return (fh.ReadHeader() && fh.ReadSettings() && fh.ReadConfiguration() && fh.ReadMethods() && fh.ReadResultFiles() && fh.ReadInformFiles());
    }

    private Method getSelectedMethodInCombo(JComboBox cmbMethod) {
        Method metReturn = new Method();
        int _intSelectedIndex = cmbMethod.getSelectedIndex();

        for (MethodInCombo cmbMethodInCombo : this.arrMethodsInCombo) {
            if (cmbMethodInCombo.combo == cmbMethod && _intSelectedIndex == cmbMethodInCombo.position) {
                metReturn = cmbMethodInCombo.method;
            }
        }

        return metReturn;
    }

    private void SetComboBoxes() {
        this.jComboBoxes.add(new comboBox(cmbAptitud, paths.strAptitudDB, "A", tblAptitud));
        this.jComboBoxes.add(new comboBox(cmbCromosoma, paths.strCromosomaDB, "C", tblCromosoma));
        this.jComboBoxes.add(new comboBox(cmbSeleccion, paths.strSeleccionDB, "S", tblSeleccion));
        this.jComboBoxes.add(new comboBox(cmbCruzamiento, paths.strCruzamientoDB, "X", tblCruzamiento));
        this.jComboBoxes.add(new comboBox(cmbMutacion, paths.strMutacionDB, "M", tblMutacion));
        this.jComboBoxes.add(new comboBox(cmbParada, paths.strParoDB, "O", tblParada));
        this.jComboBoxes.add(new comboBox(cmbDatos, paths.strAyudanteDB, "H", tblDatos));
        this.jComboBoxes.add(new comboBox(cmbMetodoResultado, paths.strInformeDB, "I", tblResultados));
    }

    private void SetTables() {
        this.jTables.add(tblDatos);
        this.jTables.add(tblCromosoma);
        this.jTables.add(tblAptitud);
        this.jTables.add(tblCruzamiento);
        this.jTables.add(tblSeleccion);
        this.jTables.add(tblMutacion);
        this.jTables.add(tblParada);
        this.jTables.add(tblResultados);
    }

    private void resetFormObjects() {
        this.resetGeneralTab();
        this.resetConfigurationTab();
    }

    private void resetConfigurationTab() {
        this.txtPoblacionInicial.setText("0");
        this.txtHoraInicio.setText("--:--");
        this.txtPoblacionActual.setText("0");
        this.txtMutaciones.setText("0");
        this.txtDuracion.setText("--:--");
        this.txtCiclos.setText("0");
        this.txtAptitudMinima.setText("0");
        this.txtAptitudMedia.setText("0");        
        this.txtAptitudMaxima.setText("0");        
        this.resetTables();
        this.resetCombos();
    }
    
    private void resetCombos(){
        for (comboBox combo : this.jComboBoxes){
            combo.combo.removeAllItems();
            combo.combo.addItem(Messages.strComboFirstOption);
        }
    }
    
    public void setPoblacionActual(int cantpobla) {


        this.txtPoblacionActual.setText(String.valueOf(cantpobla));
    }

    public void setMutaciones(int cantMuta) {

      this.txtMutaciones.setText(String.valueOf(cantMuta));

       
    }
    public void setAptitudMaxima(int aptitud) {
        this.txtAptitudMaxima.setText(String.valueOf(aptitud));

    }

    public void setAptitudMedia(int aptitud) {
        this.txtAptitudMedia.setText(String.valueOf(aptitud));
    }

    public void setAptitudMinima(int aptitud) {
        this.txtAptitudMinima.setText(String.valueOf(aptitud));
    }

    public void setCiclo(int nroCiclo) {
        this.txtCiclos.setText(String.valueOf(nroCiclo));
    }

    private void resetGeneralTab() {
        this.txtNombreObligatorio.setText("");
        this.txtAutor.setText("");
        this.txtArchivoSolucion.setText("");
        this.txtUbicacionArchivoSolucion.setText("");
        this.txtFechaCreacion.setText(functions.getDate());
        this.txtFechaModificacion.setText(functions.getDate());
        this.txtFechaPublicacion.setText(functions.getDate());
        this.txtFechaEjecucion.setText("");
        this.txtFechaCompletado.setText("");
        this.txtDescripcionSolucion.setText("");
        this.txtObservacionSolucion.setText("");
        this.chkSoloLectura.setSelected(false);
        this.txtCarpetaPublica.setText("");
    }

    private void resetTables() {
        for (JTable table : this.jTables) {
//              DefaultTableModel modelo = (DefaultTableModel) table.getModel();
//              modelo.getDataVector().clear();
//             
//              modelo.addRow(ROW_VACIA);
            table.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{{}}, this.strParamsTableHeader));
        }
    }

    private void loadMethodsFromDB() {
        this.arrMethods = new ArrayList<>();
        for (comboBox cmbCombo : this.jComboBoxes) {
            ArrayList<Method> MethodsInDB = Method.GetMethodsInDB(cmbCombo.strFileName, cmbCombo.strFirstLetter);

            for (Method met : MethodsInDB) {
                if (this.fh.FileFound(met.getPath()).equals(file_handler._fileFound)) {
                    this.arrMethods.add(met);
                }
            }
        }
    }

    private void fillComboBoxes() {
        this.arrMethodsInCombo = new ArrayList<MethodInCombo>();

        for (comboBox cmbCombo : this.jComboBoxes) {
            //cmbCombo.combo.removeAllItems();

            for (Method met : this.arrMethods) {
                if (this.fh.FileFound(met.getPath()).equals(file_handler._fileFound) && met.getFirstLetter().equals(cmbCombo.strFirstLetter)) {
                    this.arrMethodsInCombo.add(new MethodInCombo(met, cmbCombo.combo, cmbCombo.combo.getItemCount()));
                    cmbCombo.combo.addItem(met.getName());
                    if (met.getSelected()) {
                        cmbCombo.combo.setSelectedIndex(cmbCombo.combo.getItemCount() - 1);
                    }
                }
            }
        }
    }

    public String ChooseFile() {
        int returnVal = this.jFCSave.showOpenDialog(this);
        if (returnVal == 0) {
            File file = this.jFCSave.getSelectedFile();
            try {
                return file.getAbsolutePath();
            } catch (Exception ex) {
                System.out.println("problem accessing file" + file.getAbsolutePath());
                return "";
            }
        }
        return "";
    }

    private void armarSolucion() {
        if (!functions.isInteger(txtPoblacionInicial.getText())) {
            JOptionPane.showMessageDialog(this, Messages.strPopulationNotANumber, "EGA", 1);
            return;
        }

        this.solucionCreada = new Solution();
        ArrayList<Method> arrLocalMethods = new ArrayList<>();
        for (comboBox cmbCombo : this.jComboBoxes) {
            int indexSelected = cmbCombo.combo.getSelectedIndex();
            for (MethodInCombo cmbMethod : this.arrMethodsInCombo){
                if (cmbMethod.combo == cmbCombo.combo && indexSelected == cmbMethod.position) {
                    cmbMethod.method.clearParams();

                    int _totalParams = cmbCombo.table != null ? cmbCombo.table.getRowCount() : 0;
                    ArrayList<Param> arrParam = new ArrayList<Param>();
                    for (int a = 0; a < _totalParams; a++) {
                        if (cmbCombo.table.getValueAt(a, 0) != null && cmbCombo.table.getValueAt(a, 1) != null) {
                            String strName = cmbCombo.table.getValueAt(a, 0).toString().trim();
                            String strValue = cmbCombo.table.getValueAt(a, 1).toString().trim();
                            String strType = "String";

                            Param _param = new Param(strName.toString(), strValue.toString(), strType);
                            arrParam.add(_param);
                        }
                    }
                    cmbMethod.method.setParams(arrParam);
                    cmbMethod.method.SetTypeFromFirstLetter(cmbCombo.strFirstLetter);
                    arrLocalMethods.add(cmbMethod.method);

                }
            }
        }
        this.solucionCreada.setArrMethods(arrLocalMethods);
        this.solucionCreada.setIntSize(Integer.parseInt(txtPoblacionInicial.getText().trim()));
        this.solucionCreada.setIntIncreasingStyle(this.cmbCrecimientoPoblacion.getSelectedIndex());
        this.solucionCreada.setStrDescription(this.txtDescripcionSolucion.getText().trim());
        this.solucionCreada.setStrObservation(this.txtObservacionSolucion.getText().trim());
        this.solucionCreada.setStrAuthor(this.txtAutor.getText().trim());
        this.solucionCreada.setStrName(this.txtNombreObligatorio.getText().trim());
        this.solucionCreada.setStrCreated(this.txtFechaCreacion.getText().trim());
        this.solucionCreada.setStrModified(this.txtFechaModificacion.getText().trim());
        this.solucionCreada.setStrExecuted(this.txtFechaEjecucion.getText().trim());
        this.solucionCreada.setStrPublished(this.txtFechaPublicacion.getText().trim());
        this.solucionCreada.setStrCompleted(this.txtFechaCompletado.getText().trim());
        this.solucionCreada.setStrFile(this.txtArchivoSolucion.getText().trim() + paths.strSolucionesExtension);
        this.solucionCreada.setStrFolder(this.txtUbicacionArchivoSolucion.getText().trim());
        this.solucionCreada.setBlnReadOnly(chkSoloLectura.isSelected());
        this.solucionCreada.setStrServerFolder(this.txtCarpetaPublica.getText().trim());

        this.solucionCreada.setResultEGAFiles(this.getResourcesInList(lstArchivos));
    }

    private ArrayList<EGAFile> getResourcesInList(JList list) {
        ArrayList<EGAFile> resources = new ArrayList<EGAFile>();
        for (ResourceInList resource : this.arrResourceInList) {
            if (resource.list == list) {
                resources.add(resource.file);
            }
        }

        return resources;
    }

    private void editingAction(JComboBox combo) {
        if (combo.getItemCount() > 0 && combo.getSelectedIndex() > 0) {
            Method met = getSelectedMethodInCombo(combo);
            javax.swing.JInternalFrame frm = this.getWindowsEditing(met);
            if (frm != null) {
                this.setWindowsToFront(frm);
                return;
            }
            this._arrMySon.add(this.frmParent.AbrirVentana("frmEditor", this._intID, met, false));
        } else {
            JOptionPane.showMessageDialog(this, Messages.strElementNotSelected, "EGA", 1);
        }
    }

    private void setWindowsToFront(javax.swing.JInternalFrame frm) {
        frmParent.setWindowsToFront(frm);
    }

    public void pausarProceso() {
        if (this.procesoActual != null) {
            this.btnPausa.setText("Reanudar");
            this.procesoActual.pausate();
        }
    }

    public void reanudarProceso() {
        if (this.procesoActual != null) {
            this.btnPausa.setText("Pausar");
            this.procesoActual.reanudate();
        }
    }

    private javax.swing.JInternalFrame getWindowsEditing(Method met) {
        return frmParent.GetWindowsEditing(met);
    }

    public boolean isEditing(Solution sol) {
        if (this.path == null || this.path.isEmpty()) {
            return true;
        }

        String file = sol.getStrFolder() + "\\" + sol.getStrFile();
        return this.path.equals(file);
    }

    private void enablePublishButton() {
        this.btnPublicarConfiguracion.setEnabled(true);
        this.btnPublicarGeneral.setEnabled(true);
        this.btnPublicarInicio.setEnabled(true);
        this.btnPublicarResultados.setEnabled(true);
    }

    private void addCombosListenerToCombos() {

        CombosListener combosListener = new CombosListener(this);
        for (comboBox cmbComboBox : jComboBoxes) {
            cmbComboBox.combo.addActionListener(combosListener);
        }
    }
    

///////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////
    
    private void PrepararGrafica() {
        JComponent Barra = null;

        this.Grafica = new Grafica(this);
        this.Grafica.Titulo = "";//"G r á f i c a   d e   C o n v e r g e n c i a";
        this.Grafica.NombreEjeX = "C i c l o s";
        this.Grafica.NombreEjeY = "A p t i t u d";
        this.Grafica.Crear(this.Grafica.TipoGrafica);
        this.Grafica.AdaptarForm(frmGraficaFija, false, false, false);

        Barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) frmGraficaFija.getUI()).getNorthPane();
        Barra.setSize(0, 0);
        Barra.setPreferredSize(new Dimension(0, 0));
        //frmGraficaFija.repaint();
        this.Grafica.setSleep(this.Sleep); 
        this.requestFocus();
        btnComenzar.requestFocus();
        this.repaint();
        
    }

///////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////
    
    
    private void VerInforme (String PathInformeJRXML, String PathDataSource, Tipo tipoGrafica, int AptitudMinima[],  int AptitudMedia[],  int AptitudMaxima[])
    {
        String logo = "system/res/ReportLogo.jpg";
        Map param = new HashMap();
        Grafica graf = new Grafica(this);
        JasperReport jasperReport;
        JRXmlDataSource xmlDataSource;
        JasperPrint print;
        String msg= "";

        
        this.setCursor(new Cursor(Cursor.WAIT_CURSOR));

        
        try {
            
            msg = "<html>Se produjo un error compilando el informe:<p>" + PathInformeJRXML + "<p><p>El archivo no existe o está dañado.</html>";            
            jasperReport = JasperCompileManager.compileReport(PathInformeJRXML);


            msg ="<html>Se produjo un error de acceso a los datos el informe.<p>La base de datos no existe o está dañada.</html>";
            //PathDataSource ="system/plantillas/InformeEstandar1.xml";
            Document DBXML = JRXmlUtils.parse(JRLoader.getLocationInputStream(PathDataSource));
            param.put(JRXPathQueryExecuterFactory.PARAMETER_XML_DATA_DOCUMENT, DBXML);
           // xmlDataSource = new JRXmlDataSource("system/plantillas/InformeEstandar1.xml"/*PathDataSource*/, "/ega/informeEstandar1/reg");

            msg ="<html>Se produjo un error en el tratamiento de gráficas del informe.<p>Consulte al administrador.</html>";
            param.put("Grafica", graf.crearImagen(700, 250, tipoGrafica, "Ciclos", "Aptitud", AptitudMinima, AptitudMedia, AptitudMaxima));
            param.put("Logo", logo);//this.getClass().getResourceAsStream(logo));

            msg="<html>Se produjo un error cargando el informe.<p>Consulte al administrador.</html>";
            //print = JasperFillManager.fillReport(jasperReport, param, xmlDataSource);
            print = JasperFillManager. fillReport(jasperReport, param);
            // esta conversión es de mala calidad, no respeta el formato del detalle del informe.
            //JasperExportManager.exportReportToPdfFile(print, "solucion.pdf");

            JasperViewer jviewer = new JasperViewer(print, false);
            jviewer.setTitle("EGA - Informe de Solución");
            jviewer.setVisible(true);

            this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            
            
        } catch (Exception e) {  //JRException jRException
            this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            //System.out.println(jRException.getMessage());
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(this, msg, "EGA", JOptionPane.ERROR_MESSAGE);
            return;
        }
            
        
    }    // FIN verInforme()

///////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////
    
    private void ModificarTablas(){
        tblDatos.setDefaultRenderer(Object.class, new PersonalTableRenderer());
        tblResultados.setDefaultRenderer(Object.class, new PersonalTableRenderer());
        tblCromosoma.setDefaultRenderer(Object.class, new PersonalTableRenderer());
        tblAptitud.setDefaultRenderer(Object.class, new PersonalTableRenderer());
        tblSeleccion.setDefaultRenderer(Object.class, new PersonalTableRenderer());
        tblCruzamiento.setDefaultRenderer(Object.class, new PersonalTableRenderer());
        tblMutacion.setDefaultRenderer(Object.class, new PersonalTableRenderer());
        tblParada.setDefaultRenderer(Object.class, new PersonalTableRenderer());    
    }

///////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////
    
    
    public void mostrarMensaje(String mensaje) {
        
        JOptionPane.showMessageDialog(this, mensaje, "EGA", 1);
    
    }

    public void procesoEjecutando() {
        if (this.Grafica.esNueva() == false)
            this.PrepararGrafica();
        
        Date today = functions.getToday();
        this.resetProcessTextBox(this.solucionCreada, today);
        txtHoraInicio.setText(functions.getTime(today));
        txtDuracion.setText("00:00:00");
        this.timer.start();

        this.btnComenzar.setText(FINALIZAR);
        this.btnPausa.setEnabled(true);
    }

    public void procesoFinalizadoConError() {
                        this.timer.stop();
  
        this.btnComenzar.setText(COMENZAR);
        this.btnPausa.setSelected(false);
        this.btnPausa.setText(PAUSAR);
        this.btnPausa.setEnabled(false);
           this.btnVerInformeInicio.setText(GRABAR_RESULTADOS);
           this.btnVerInformeInicio.setEnabled(false);
       
    }

    

} // FIN CLASE frmSolucion
