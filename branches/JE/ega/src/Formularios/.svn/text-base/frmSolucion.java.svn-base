/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import Clase.Principal.EGA;
import configuration.Paths;
import Methods.*;
import Solutions.*;
import helpers.*;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JComboBox;
import javax.swing.JTable;

/**
 *
 * @author Triton
 */
public class frmSolucion extends javax.swing.JInternalFrame {
    String strTypeForm = forms.Solucion;
    MDI frmParent;
    Solution solution;
    file_handler fh = new file_handler();
    Paths paths = new Paths();
    ArrayList<Method> arrMethods;
    String[] strParamsTableHeader = {"NOMBRE", "VALOR"};
    int intLoading = 1;
    
   //Form objects
    ArrayList<comboBox> jComboBoxes = new ArrayList<comboBox>();
    ArrayList<JTable> jTables = new ArrayList<JTable>();
    
    /**
     * Creates new form frmSolucion
     */
    public frmSolucion(MDI frmParent) {
        this.startLoading();
        initComponents();
        this.frmParent = frmParent;
        this.setFormObjects();
        this.resetFormObjects();
        this.configurateCombo();
        this.finishLoading();
    }
    
    public frmSolucion(MDI frmParent, String strPathSolutionToOpen){
        this.startLoading();
        initComponents();
        this.frmParent = frmParent;
        this.setFormObjects();
        this.resetFormObjects();
        this.configurateCombo();
        this.OpenSolution(strPathSolutionToOpen);
        this.finishLoading();
    }
    
    private void setFormObjects(){
        this.SetComboBoxes();
        this.SetTables();
    }
    
    private void startLoading(){
        this.intLoading = 1;
    }
    
    private void finishLoading(){
        this.intLoading = 0;
    }
    
    private void configurateCombo(){
        this.FillComboBoxes();
    }
    
    private void OpenSolution(String strSolution){
        //fh.setPathFileToRead(paths.strSoluciones + "\\sol" + paths.strSolucionesExtension);
        this.OpenExistingSolution(strSolution);
    }
    
    private void OpenExistingSolution(String strSolution){
        fh.setPathFileToRead(strSolution);
        fh.OpenXMLReader();
        
        if (fh.ReadHeader() && fh.ReadConfiguration() && fh.ReadParts()){
            ArrayList<HashMap<String, String>> _strHmArrSolution = fh.getArrXMLSolutionHeader();
            ArrayList<HashMap<String, String>> _strArrXMLSolutionInitialPopulation = fh.getArrXMLSolutionInitialPopulation();
            ArrayList<Method> _metArrXMLSolution = fh.getArrXMLSolution();
            
            this.solution = new Solution(_strHmArrSolution.get(0).get("name"), _strHmArrSolution.get(1).get("author"), _strHmArrSolution.get(2).get("description"), _strHmArrSolution.get(3).get("created"), _strHmArrSolution.get(4).get("modified"));
            Population population = new Population(Integer.parseInt(_strArrXMLSolutionInitialPopulation.get(0).get("width")), _strArrXMLSolutionInitialPopulation.get(1).get("increasingStyle"));
            this.solution.setPopPopulationConfiguration(population);
            this.solution.setArrMethods(_metArrXMLSolution);
            //Acá hay que setear que el metodo que está seleccionado de la solución marque a aquel que que corresponde en el combo.
            this.FillSolutionGrid();
        }
    }
    
    
    private void FillSolutionGrid(){
        tblSolucionDescripcion.removeAll();
        tblSolucionDescripcion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"NOMBRE", this.solution.getStrName()},
                {"AUTOR", this.solution.getStrAuthor()},
                {"CREADO", this.solution.getStrCreated()},
                {"MODIFICADO", this.solution.getStrModified()},
                {"UBICACION", "C:\\"},
                {"DESCRIPCION", this.solution.getStrDescription()}
            }, new String [] {"  ", " "}
        ));
    }
    
    private void SetComboBoxes(){
        this.jComboBoxes.add(new comboBox(cmbAptitud, paths.strAptitudDB));
        this.jComboBoxes.add(new comboBox(cmbCromosoma, paths.strCromosomaDB));
        this.jComboBoxes.add(new comboBox(cmbSeleccion, paths.strSeleccionDB));
        this.jComboBoxes.add(new comboBox(cmbCruzamiento, paths.strCruzamientoDB));
        this.jComboBoxes.add(new comboBox(cmbMutacion, paths.strMutacionDB));
        this.jComboBoxes.add(new comboBox(cmbParada, paths.strParoDB));
        this.jComboBoxes.add(new comboBox(cmbDatos, paths.strAyudanteDB));
    }
    
    private void SetTables(){
        //this.jTables.add(tblSolucionDescripcion);
        this.jTables.add(tblDatos);
        this.jTables.add(tblCromosoma);
        this.jTables.add(tblAptitud);
        this.jTables.add(tblCruzamiento);
        this.jTables.add(tblSeleccion);
        this.jTables.add(tblMutacion);
        this.jTables.add(tblParada);
    }
    
    private void resetFormObjects(){
        this.resetTables();
    }
    
    private void resetTables(){
        for (JTable table : this.jTables)
            table.setModel(new javax.swing.table.DefaultTableModel(new Object [][] {{}}, this.strParamsTableHeader));
        
        tblSolucionDescripcion.setModel(
            new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    {"NOMBRE", ""},
                    {"AUTOR", ""},
                    {"CREADO", ""},
                    {"MODIFICADO", ""},
                    {"UBICACION", ""},
                    {"DESCRIPCION", ""}
                }, 
                new String [] {"", ""}
            )
        );
    }

    private void FillComboBoxes(){
        data_type_converter dtc = new data_type_converter();
        this.arrMethods = new ArrayList<Method>();

        for (comboBox cmbCombo : this.jComboBoxes){
            arrMethods.clear();
            cmbCombo.combo.removeAllItems();
            fh.setPathFileToRead(cmbCombo.strFileName);
            if (fh.ReadBinary()){
                dtc.setByteText(fh.getByteText());
                dtc.fromByteToStringList();

                ArrayList<ArrayList<String>> strArrMethods = dtc.getStrArrText();
                for (ArrayList<String> strMethod : strArrMethods){
                    Method met = new Method(
                        strMethod.get(0),
                        strMethod.get(1),
                        strMethod.get(2),
                        strMethod.get(3), 
                        Boolean.getBoolean(strMethod.get(4)), 
                        strMethod.get(5)
                    );
                    arrMethods.add(met);
                    //cmbCombo.combo.setSelectedItem(met.getIndex());
                   
                    cmbCombo.combo.addItem("[S" + met.getIndex() + "] - " + met.getName());
                }
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panSeleccion = new javax.swing.JPanel();
        cmbSeleccion = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSeleccion = new javax.swing.JTable();
        btnSeleccionEditar = new javax.swing.JButton();
        btnSeleccionNuevo = new javax.swing.JButton();
        btnSeleccionDescripcion = new javax.swing.JButton();
        panCruzamiento = new javax.swing.JPanel();
        cmbCruzamiento = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblCruzamiento = new javax.swing.JTable();
        btnCruzamientoEditar = new javax.swing.JButton();
        btnCruzamientoNuevo = new javax.swing.JButton();
        btnCruzamientoDescripcion = new javax.swing.JButton();
        panMutacion = new javax.swing.JPanel();
        cmbMutacion = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblMutacion = new javax.swing.JTable();
        btnMutacionEditar = new javax.swing.JButton();
        btnMutacionNuevo = new javax.swing.JButton();
        btnMutacionDescripcion = new javax.swing.JButton();
        panParada = new javax.swing.JPanel();
        cmbParada = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblParada = new javax.swing.JTable();
        btnParadaEditar = new javax.swing.JButton();
        btnParadaNuevo = new javax.swing.JButton();
        btnParadaDescricpion = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        cmbPoblacion = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        txtPoblacionInicial = new javax.swing.JTextField();
        panProceso = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtHoraInicio = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtDuracion = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtPoblacionActual = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtCiclos = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtMutaciones = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtAptitudMedia = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtAptitudMaxima = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtAptitudMinima = new javax.swing.JTextField();
        btnInforme = new javax.swing.JButton();
        btnGrafica = new javax.swing.JButton();
        btnParametros = new javax.swing.JButton();
        btnPausar = new javax.swing.JToggleButton();
        btnPublicar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnNueva = new javax.swing.JButton();
        btnExportar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        panSolucionDescripcion = new javax.swing.JPanel();
        jsSolutionDescription = new javax.swing.JScrollPane();
        tblSolucionDescripcion = new javax.swing.JTable();
        frmDescripcionFuncion = new javax.swing.JInternalFrame();
        panAptitud = new javax.swing.JPanel();
        cmbAptitud = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        btnAptitudEditar = new javax.swing.JButton();
        btnAptitudNuevo = new javax.swing.JButton();
        btnAptitudDescripcion = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblAptitud = new javax.swing.JTable();
        panCromosoma = new javax.swing.JPanel();
        cmbCromosoma = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        btnCromosomaEditar = new javax.swing.JButton();
        btnCromosomaNuevo = new javax.swing.JButton();
        btnCromosomaDescripcion = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblCromosoma = new javax.swing.JTable();
        panDatos = new javax.swing.JPanel();
        cmbDatos = new javax.swing.JComboBox();
        jLabel18 = new javax.swing.JLabel();
        btnDatosEditar = new javax.swing.JButton();
        btnDatosNuevo = new javax.swing.JButton();
        btnDatosDescripcion = new javax.swing.JButton();
        jScrollPane10 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("EGA - Solución.");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ICON.png"))); // NOI18N
        setMinimumSize(null);
        setNormalBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setPreferredSize(new java.awt.Dimension(1010, 650));
        setVisible(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Información General de la Solución", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 12), java.awt.Color.black)); // NOI18N
        jPanel1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panSeleccion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Método de Selección", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 12))); // NOI18N
        panSeleccion.setAlignmentX(0.0F);
        panSeleccion.setAlignmentY(0.0F);
        panSeleccion.setFont(new java.awt.Font("Script MT Bold", 0, 12)); // NOI18N
        panSeleccion.setPreferredSize(new java.awt.Dimension(229, 205));
        panSeleccion.setLayout(null);

        cmbSeleccion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        cmbSeleccion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ranking", "Torneo", "Ruleta", "Control s/n esperado" }));
        cmbSeleccion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbSeleccionItemStateChanged(evt);
            }
        });
        cmbSeleccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSeleccionActionPerformed(evt);
            }
        });
        panSeleccion.add(cmbSeleccion);
        cmbSeleccion.setBounds(16, 27, 197, 22);

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel2.setText("Ingrese el Valor de los Parámetros:");
        panSeleccion.add(jLabel2);
        jLabel2.setBounds(16, 58, 197, 16);

        tblSeleccion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"CANTIDAD", "10"}
            },
            new String [] {
                "NOMBRE", "VALOR"
            }
        ));
        tblSeleccion.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblSeleccion);
        tblSeleccion.getColumnModel().getColumn(0).setResizable(false);
        tblSeleccion.getColumnModel().getColumn(0).setPreferredWidth(170);
        tblSeleccion.getColumnModel().getColumn(0).setHeaderValue("NOMBRE");
        tblSeleccion.getColumnModel().getColumn(1).setResizable(false);
        tblSeleccion.getColumnModel().getColumn(1).setHeaderValue("VALOR");

        panSeleccion.add(jScrollPane2);
        jScrollPane2.setBounds(16, 78, 197, 106);

        btnSeleccionEditar.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnSeleccionEditar.setText("Editar");
        panSeleccion.add(btnSeleccionEditar);
        btnSeleccionEditar.setBounds(16, 190, 73, 25);

        btnSeleccionNuevo.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnSeleccionNuevo.setText("Nuevo");
        panSeleccion.add(btnSeleccionNuevo);
        btnSeleccionNuevo.setBounds(95, 190, 75, 25);

        btnSeleccionDescripcion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnSeleccionDescripcion.setText("?");
        btnSeleccionDescripcion.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnSeleccionDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionDescripcionActionPerformed(evt);
            }
        });
        panSeleccion.add(btnSeleccionDescripcion);
        btnSeleccionDescripcion.setBounds(176, 190, 37, 25);

        jPanel1.add(panSeleccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 16, 238, 239));

        panCruzamiento.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Método de Cruzamiento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 12))); // NOI18N
        panCruzamiento.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        panCruzamiento.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cmbCruzamiento.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        cmbCruzamiento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Máscara Multipunto", "Máscara Simple", "Azar", " " }));
        cmbCruzamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCruzamientoActionPerformed(evt);
            }
        });
        panCruzamiento.add(cmbCruzamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 27, 197, -1));

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel3.setText("Ingrese el Valor de los Parámetros:");
        panCruzamiento.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 58, 197, -1));

        tblCruzamiento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"CORTE 1", "3"},
                {"CORTE 2", "5"},
                {"CORTE 3", "7"},
                {"CORTE 4", "15"}
            },
            new String [] {
                "NOMBRE", "VALOR"
            }
        ));
        tblCruzamiento.setPreferredSize(new java.awt.Dimension(245, 16));
        tblCruzamiento.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tblCruzamiento);
        tblCruzamiento.getColumnModel().getColumn(0).setResizable(false);
        tblCruzamiento.getColumnModel().getColumn(0).setPreferredWidth(170);

        panCruzamiento.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 78, 200, 106));

        btnCruzamientoEditar.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnCruzamientoEditar.setText("Editar");
        panCruzamiento.add(btnCruzamientoEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 190, 76, -1));

        btnCruzamientoNuevo.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnCruzamientoNuevo.setText("Nuevo");
        panCruzamiento.add(btnCruzamientoNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 190, 75, -1));

        btnCruzamientoDescripcion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnCruzamientoDescripcion.setText("?");
        btnCruzamientoDescripcion.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnCruzamientoDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCruzamientoDescripcionActionPerformed(evt);
            }
        });
        panCruzamiento.add(btnCruzamientoDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(179, 190, 37, -1));

        jPanel1.add(panCruzamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 16, 230, 239));

        panMutacion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Método de Mutación", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 12))); // NOI18N
        panMutacion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        panMutacion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cmbMutacion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        cmbMutacion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Azar" }));
        panMutacion.add(cmbMutacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 27, 210, -1));

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel4.setText("Ingrese el Valor de los Parámetros:");
        panMutacion.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 58, 197, -1));

        tblMutacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"PROBABILIDAD", "0,02"}
            },
            new String [] {
                "NOMBRE", "VALOR"
            }
        ));
        tblMutacion.setPreferredSize(new java.awt.Dimension(248, 16));
        tblMutacion.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(tblMutacion);
        tblMutacion.getColumnModel().getColumn(0).setResizable(false);
        tblMutacion.getColumnModel().getColumn(0).setPreferredWidth(140);
        tblMutacion.getColumnModel().getColumn(1).setResizable(false);
        tblMutacion.getColumnModel().getColumn(1).setPreferredWidth(230);

        panMutacion.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 78, 210, 106));

        btnMutacionEditar.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnMutacionEditar.setText("Editar");
        panMutacion.add(btnMutacionEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 190, 82, -1));

        btnMutacionNuevo.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnMutacionNuevo.setText("Nuevo");
        panMutacion.add(btnMutacionNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 190, 75, -1));

        btnMutacionDescripcion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnMutacionDescripcion.setText("?");
        btnMutacionDescripcion.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnMutacionDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMutacionDescripcionActionPerformed(evt);
            }
        });
        panMutacion.add(btnMutacionDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, 37, -1));

        jPanel1.add(panMutacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(497, 16, 240, 240));

        panParada.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Método de Parada", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 12))); // NOI18N
        panParada.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        panParada.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cmbParada.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        cmbParada.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "por Tiempo", "por Ciclos", "por Valor de Aptitud", "por Tamaño de Población" }));
        panParada.add(cmbParada, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 27, 197, -1));

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel5.setText("Ingrese el Valor de los Parámetros:");
        panParada.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 58, 197, -1));

        tblParada.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"SEGUNDOS", "3600"}
            },
            new String [] {
                "NOMBRE", "VALOR"
            }
        ));
        tblParada.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(tblParada);
        tblParada.getColumnModel().getColumn(0).setResizable(false);
        tblParada.getColumnModel().getColumn(0).setPreferredWidth(170);

        panParada.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 78, 197, 106));

        btnParadaEditar.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnParadaEditar.setText("Editar");
        panParada.add(btnParadaEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 190, 78, -1));

        btnParadaNuevo.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnParadaNuevo.setText("Nuevo");
        panParada.add(btnParadaNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 75, -1));

        btnParadaDescricpion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnParadaDescricpion.setText("?");
        btnParadaDescricpion.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnParadaDescricpion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnParadaDescricpionActionPerformed(evt);
            }
        });
        panParada.add(btnParadaDescricpion, new org.netbeans.lib.awtextra.AbsoluteConstraints(181, 190, 37, -1));

        jPanel1.add(panParada, new org.netbeans.lib.awtextra.AbsoluteConstraints(741, 16, 230, 240));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 214, 982, 270));
        jPanel1.getAccessibleContext().setAccessibleName("");

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Configuración de la Población", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 12))); // NOI18N
        jPanel6.setAlignmentX(0.0F);
        jPanel6.setAlignmentY(0.0F);
        jPanel6.setLayout(null);

        cmbPoblacion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        cmbPoblacion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Población Fija", "Población Creciente", "Población Decreciente" }));
        cmbPoblacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPoblacionActionPerformed(evt);
            }
        });
        jPanel6.add(cmbPoblacion);
        cmbPoblacion.setBounds(16, 53, 221, 22);

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel6.setText("Tamaño Inicial:");
        jPanel6.add(jLabel6);
        jLabel6.setBounds(16, 30, 84, 16);

        txtPoblacionInicial.setText("500");
        txtPoblacionInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPoblacionInicialActionPerformed(evt);
            }
        });
        jPanel6.add(txtPoblacionInicial);
        txtPoblacionInicial.setBounds(107, 27, 130, 20);

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 117, 253, 91));

        panProceso.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Proceso", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 12), java.awt.Color.black)); // NOI18N
        panProceso.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        panProceso.setMaximumSize(new java.awt.Dimension(1000, 99));
        panProceso.setMinimumSize(new java.awt.Dimension(500, 99));
        panProceso.setPreferredSize(new java.awt.Dimension(960, 99));
        panProceso.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel7.setText("Hora Inicio:");
        panProceso.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 22, -1, -1));

        txtHoraInicio.setText("15:34");
        txtHoraInicio.setAlignmentX(1.5F);
        txtHoraInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHoraInicioActionPerformed(evt);
            }
        });
        panProceso.add(txtHoraInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 20, 60, -1));

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel8.setText("Duración:");
        panProceso.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 52, -1, -1));

        txtDuracion.setText("00:45:21");
        txtDuracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDuracionActionPerformed(evt);
            }
        });
        panProceso.add(txtDuracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 50, 60, -1));

        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel9.setText("Población:");
        panProceso.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 22, -1, -1));

        txtPoblacionActual.setText("500");
        txtPoblacionActual.setAlignmentX(1.5F);
        txtPoblacionActual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPoblacionActualActionPerformed(evt);
            }
        });
        panProceso.add(txtPoblacionActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 60, -1));

        jLabel10.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel10.setText("Ciclos:");
        panProceso.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, -1, -1));

        txtCiclos.setText("1346");
        txtCiclos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCiclosActionPerformed(evt);
            }
        });
        panProceso.add(txtCiclos, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 59, -1));

        jLabel11.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel11.setText("Mutaciones:");
        panProceso.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, -1, -1));

        txtMutaciones.setText("14");
        txtMutaciones.setAlignmentX(1.5F);
        txtMutaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMutacionesActionPerformed(evt);
            }
        });
        panProceso.add(txtMutaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, 60, -1));

        jLabel12.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel12.setText("Aptitud Media:");
        panProceso.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, -1, -1));

        txtAptitudMedia.setText("99");
        txtAptitudMedia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAptitudMediaActionPerformed(evt);
            }
        });
        panProceso.add(txtAptitudMedia, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, 59, -1));

        jLabel13.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel13.setText("Aptitud Máx:");
        panProceso.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, -1, -1));

        txtAptitudMaxima.setText("290");
        txtAptitudMaxima.setAlignmentX(1.5F);
        txtAptitudMaxima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAptitudMaximaActionPerformed(evt);
            }
        });
        panProceso.add(txtAptitudMaxima, new org.netbeans.lib.awtextra.AbsoluteConstraints(487, 20, 60, -1));

        jLabel14.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel14.setText("Aptitud Min:");
        panProceso.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, -1, -1));

        txtAptitudMinima.setText("20");
        txtAptitudMinima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAptitudMinimaActionPerformed(evt);
            }
        });
        panProceso.add(txtAptitudMinima, new org.netbeans.lib.awtextra.AbsoluteConstraints(487, 50, 59, -1));

        btnInforme.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnInforme.setText("Informe");
        btnInforme.setAlignmentY(0.0F);
        btnInforme.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnInforme.setMaximumSize(new java.awt.Dimension(80, 23));
        btnInforme.setMinimumSize(new java.awt.Dimension(50, 23));
        btnInforme.setPreferredSize(new java.awt.Dimension(71, 23));
        panProceso.add(btnInforme, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 20, 100, 49));

        btnGrafica.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnGrafica.setText("Gráfica");
        btnGrafica.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnGrafica.setMaximumSize(new java.awt.Dimension(90, 23));
        btnGrafica.setMinimumSize(new java.awt.Dimension(50, 23));
        btnGrafica.setPreferredSize(new java.awt.Dimension(79, 23));
        panProceso.add(btnGrafica, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 20, 100, 49));

        btnParametros.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnParametros.setText("Parámetros");
        btnParametros.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnParametros.setMaximumSize(new java.awt.Dimension(90, 23));
        btnParametros.setMinimumSize(new java.awt.Dimension(50, 23));
        btnParametros.setPreferredSize(new java.awt.Dimension(73, 23));
        panProceso.add(btnParametros, new org.netbeans.lib.awtextra.AbsoluteConstraints(765, 20, 100, 49));

        btnPausar.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnPausar.setText("Pausar");
        panProceso.add(btnPausar, new org.netbeans.lib.awtextra.AbsoluteConstraints(555, 20, 100, 49));

        getContentPane().add(panProceso, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 493, 982, 79));

        btnPublicar.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnPublicar.setText("Publicar");
        getContentPane().add(btnPublicar, new org.netbeans.lib.awtextra.AbsoluteConstraints(244, 578, 150, 23));

        btnGuardar.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnGuardar.setText("Guardar");
        getContentPane().add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 578, 150, 23));

        btnNueva.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnNueva.setText("Nueva");
        getContentPane().add(btnNueva, new org.netbeans.lib.awtextra.AbsoluteConstraints(412, 578, 150, 23));

        btnExportar.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnExportar.setText("Exportar");
        getContentPane().add(btnExportar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 578, 150, 23));

        btnSalir.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnSalir.setText("Salir");
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(748, 578, 150, 23));

        panSolucionDescripcion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Información General de la Solución", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 12), java.awt.Color.black)); // NOI18N
        panSolucionDescripcion.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        panSolucionDescripcion.setLayout(null);

        tblSolucionDescripcion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "  ", " "
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblSolucionDescripcion.getTableHeader().setReorderingAllowed(false);
        jsSolutionDescription.setViewportView(tblSolucionDescripcion);
        tblSolucionDescripcion.getColumnModel().getColumn(0).setResizable(false);
        tblSolucionDescripcion.getColumnModel().getColumn(0).setPreferredWidth(140);
        tblSolucionDescripcion.getColumnModel().getColumn(1).setResizable(false);
        tblSolucionDescripcion.getColumnModel().getColumn(1).setPreferredWidth(230);

        panSolucionDescripcion.add(jsSolutionDescription);
        jsSolutionDescription.setBounds(6, 16, 241, 77);

        frmDescripcionFuncion.setClosable(true);
        frmDescripcionFuncion.setIconifiable(true);
        frmDescripcionFuncion.setResizable(true);
        frmDescripcionFuncion.setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ICON.png"))); // NOI18N
        frmDescripcionFuncion.setVisible(true);
        frmDescripcionFuncion.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panSolucionDescripcion.add(frmDescripcionFuncion);
        frmDescripcionFuncion.setBounds(50, 40, 830, 430);

        getContentPane().add(panSolucionDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 253, 100));

        panAptitud.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Función de Aptitud", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 12))); // NOI18N
        panAptitud.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        panAptitud.setLayout(null);

        cmbAptitud.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        cmbAptitud.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Aptitud de Eventos", "Aptitud de Passwords", "Aptitud de Prueba", "Aptitud de RRHH" }));
        cmbAptitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbAptitudActionPerformed(evt);
            }
        });
        panAptitud.add(cmbAptitud);
        cmbAptitud.setBounds(16, 24, 210, 22);

        jLabel16.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel16.setText("Ingrese el Valor de los Parámetros:");
        panAptitud.add(jLabel16);
        jLabel16.setBounds(16, 50, 194, 16);

        btnAptitudEditar.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnAptitudEditar.setText("Editar");
        panAptitud.add(btnAptitudEditar);
        btnAptitudEditar.setBounds(16, 154, 81, 25);

        btnAptitudNuevo.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnAptitudNuevo.setText("Nuevo");
        panAptitud.add(btnAptitudNuevo);
        btnAptitudNuevo.setBounds(106, 154, 75, 25);

        btnAptitudDescripcion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnAptitudDescripcion.setText("?");
        btnAptitudDescripcion.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnAptitudDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAptitudDescripcionActionPerformed(evt);
            }
        });
        panAptitud.add(btnAptitudDescripcion);
        btnAptitudDescripcion.setBounds(188, 154, 37, 25);

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
        jScrollPane7.setViewportView(tblAptitud);
        tblAptitud.getColumnModel().getColumn(0).setResizable(false);
        tblAptitud.getColumnModel().getColumn(0).setPreferredWidth(140);
        tblAptitud.getColumnModel().getColumn(1).setResizable(false);
        tblAptitud.getColumnModel().getColumn(1).setPreferredWidth(230);

        panAptitud.add(jScrollPane7);
        jScrollPane7.setBounds(16, 70, 210, 78);

        getContentPane().add(panAptitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(755, 11, 237, 197));

        panCromosoma.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tipo de Cromosoma", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 12))); // NOI18N
        panCromosoma.setAlignmentX(0.0F);
        panCromosoma.setAlignmentY(0.0F);
        panCromosoma.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        panCromosoma.setLayout(null);

        cmbCromosoma.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        cmbCromosoma.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cromosoma Eventos", "Cromosoma Password", "Cromosoma de Prueba", "Cromosoma RRHH" }));
        cmbCromosoma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCromosomaActionPerformed(evt);
            }
        });
        panCromosoma.add(cmbCromosoma);
        cmbCromosoma.setBounds(16, 24, 210, 22);

        jLabel17.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel17.setText("Ingrese el Valor de los Parámetros:");
        panCromosoma.add(jLabel17);
        jLabel17.setBounds(16, 50, 194, 16);

        btnCromosomaEditar.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnCromosomaEditar.setText("Editar");
        panCromosoma.add(btnCromosomaEditar);
        btnCromosomaEditar.setBounds(16, 154, 81, 25);

        btnCromosomaNuevo.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnCromosomaNuevo.setText("Nuevo");
        panCromosoma.add(btnCromosomaNuevo);
        btnCromosomaNuevo.setBounds(106, 154, 75, 25);

        btnCromosomaDescripcion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnCromosomaDescripcion.setText("?");
        btnCromosomaDescripcion.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnCromosomaDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCromosomaDescripcionActionPerformed(evt);
            }
        });
        panCromosoma.add(btnCromosomaDescripcion);
        btnCromosomaDescripcion.setBounds(188, 154, 37, 25);

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
        jScrollPane8.setViewportView(tblCromosoma);
        tblCromosoma.getColumnModel().getColumn(0).setResizable(false);
        tblCromosoma.getColumnModel().getColumn(0).setPreferredWidth(140);
        tblCromosoma.getColumnModel().getColumn(1).setResizable(false);
        tblCromosoma.getColumnModel().getColumn(1).setPreferredWidth(230);

        panCromosoma.add(jScrollPane8);
        jScrollPane8.setBounds(16, 70, 210, 78);

        getContentPane().add(panCromosoma, new org.netbeans.lib.awtextra.AbsoluteConstraints(512, 11, 237, 197));

        panDatos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Método de Carga de Datos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 12))); // NOI18N
        panDatos.setAlignmentX(0.0F);
        panDatos.setAlignmentY(0.0F);
        panDatos.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        panDatos.setLayout(null);

        cmbDatos.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        cmbDatos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mis datos en SQL Server", "Mis datos en XML", "Mis datos en TXT", "Mis datos en Excel" }));
        cmbDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDatosActionPerformed(evt);
            }
        });
        panDatos.add(cmbDatos);
        cmbDatos.setBounds(16, 24, 210, 22);

        jLabel18.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel18.setText("Ingrese el Valor de los Parámetros:");
        panDatos.add(jLabel18);
        jLabel18.setBounds(16, 50, 194, 16);

        btnDatosEditar.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnDatosEditar.setText("Editar");
        panDatos.add(btnDatosEditar);
        btnDatosEditar.setBounds(16, 154, 81, 25);

        btnDatosNuevo.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnDatosNuevo.setText("Nuevo");
        panDatos.add(btnDatosNuevo);
        btnDatosNuevo.setBounds(106, 154, 75, 25);

        btnDatosDescripcion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnDatosDescripcion.setText("?");
        btnDatosDescripcion.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnDatosDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatosDescripcionActionPerformed(evt);
            }
        });
        panDatos.add(btnDatosDescripcion);
        btnDatosDescripcion.setBounds(188, 154, 37, 25);

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
        jScrollPane10.setViewportView(tblDatos);
        tblDatos.getColumnModel().getColumn(0).setResizable(false);
        tblDatos.getColumnModel().getColumn(0).setPreferredWidth(140);
        tblDatos.getColumnModel().getColumn(1).setResizable(false);
        tblDatos.getColumnModel().getColumn(1).setPreferredWidth(230);

        panDatos.add(jScrollPane10);
        jScrollPane10.setBounds(16, 70, 210, 78);

        getContentPane().add(panDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(269, 11, 237, 197));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void txtAptitudMaximaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAptitudMaximaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAptitudMaximaActionPerformed

    private void txtAptitudMinimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAptitudMinimaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAptitudMinimaActionPerformed

    private void cmbCruzamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCruzamientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCruzamientoActionPerformed

    private void cmbPoblacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPoblacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbPoblacionActionPerformed

    private void txtPoblacionInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPoblacionInicialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPoblacionInicialActionPerformed

    private void cmbAptitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAptitudActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbAptitudActionPerformed

    private void btnSeleccionDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionDescripcionActionPerformed
        this.frmParent.AbrirVentana("frmDescripcionFuncion");
    }//GEN-LAST:event_btnSeleccionDescripcionActionPerformed

    
    private void cmbSeleccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSeleccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbSeleccionActionPerformed

    private void cmbSeleccionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbSeleccionItemStateChanged
        // TODO add your handling code here:
        //System.out.println(cmbSelectionMethods.getS)
        if (this.intLoading == 0)
            System.out.println(cmbSeleccion.getSelectedItem());
    }//GEN-LAST:event_cmbSeleccionItemStateChanged

    private void cmbCromosomaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCromosomaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCromosomaActionPerformed

    private void cmbDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDatosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbDatosActionPerformed

    private void btnCruzamientoDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCruzamientoDescripcionActionPerformed
        
        this.frmParent.AbrirVentana("frmDescripcionFuncion");

    }//GEN-LAST:event_btnCruzamientoDescripcionActionPerformed

    private void btnDatosDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatosDescripcionActionPerformed
        
        this.frmParent.AbrirVentana("frmDescripcionFuncion");
        
    }//GEN-LAST:event_btnDatosDescripcionActionPerformed

    private void btnCromosomaDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCromosomaDescripcionActionPerformed
        
        this.frmParent.AbrirVentana("frmDescripcionFuncion");
        
    }//GEN-LAST:event_btnCromosomaDescripcionActionPerformed

    private void btnAptitudDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAptitudDescripcionActionPerformed

        this.frmParent.AbrirVentana("frmDescripcionFuncion");
        
    }//GEN-LAST:event_btnAptitudDescripcionActionPerformed

    private void btnMutacionDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMutacionDescripcionActionPerformed

        this.frmParent.AbrirVentana("frmDescripcionFuncion");
        
    }//GEN-LAST:event_btnMutacionDescripcionActionPerformed

    private void btnParadaDescricpionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnParadaDescricpionActionPerformed
        
        this.frmParent.AbrirVentana("frmDescripcionFuncion");
        
    }//GEN-LAST:event_btnParadaDescricpionActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAptitudDescripcion;
    private javax.swing.JButton btnAptitudEditar;
    private javax.swing.JButton btnAptitudNuevo;
    private javax.swing.JButton btnCromosomaDescripcion;
    private javax.swing.JButton btnCromosomaEditar;
    private javax.swing.JButton btnCromosomaNuevo;
    private javax.swing.JButton btnCruzamientoDescripcion;
    private javax.swing.JButton btnCruzamientoEditar;
    private javax.swing.JButton btnCruzamientoNuevo;
    private javax.swing.JButton btnDatosDescripcion;
    private javax.swing.JButton btnDatosEditar;
    private javax.swing.JButton btnDatosNuevo;
    private javax.swing.JButton btnExportar;
    private javax.swing.JButton btnGrafica;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnInforme;
    private javax.swing.JButton btnMutacionDescripcion;
    private javax.swing.JButton btnMutacionEditar;
    private javax.swing.JButton btnMutacionNuevo;
    private javax.swing.JButton btnNueva;
    private javax.swing.JButton btnParadaDescricpion;
    private javax.swing.JButton btnParadaEditar;
    private javax.swing.JButton btnParadaNuevo;
    private javax.swing.JButton btnParametros;
    private javax.swing.JToggleButton btnPausar;
    private javax.swing.JButton btnPublicar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSeleccionDescripcion;
    private javax.swing.JButton btnSeleccionEditar;
    private javax.swing.JButton btnSeleccionNuevo;
    private javax.swing.JComboBox cmbAptitud;
    private javax.swing.JComboBox cmbCromosoma;
    private javax.swing.JComboBox cmbCruzamiento;
    private javax.swing.JComboBox cmbDatos;
    private javax.swing.JComboBox cmbMutacion;
    private javax.swing.JComboBox cmbParada;
    private javax.swing.JComboBox cmbPoblacion;
    private javax.swing.JComboBox cmbSeleccion;
    private javax.swing.JInternalFrame frmDescripcionFuncion;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jsSolutionDescription;
    private javax.swing.JPanel panAptitud;
    private javax.swing.JPanel panCromosoma;
    private javax.swing.JPanel panCruzamiento;
    private javax.swing.JPanel panDatos;
    private javax.swing.JPanel panMutacion;
    private javax.swing.JPanel panParada;
    private javax.swing.JPanel panProceso;
    private javax.swing.JPanel panSeleccion;
    private javax.swing.JPanel panSolucionDescripcion;
    private javax.swing.JTable tblAptitud;
    private javax.swing.JTable tblCromosoma;
    private javax.swing.JTable tblCruzamiento;
    private javax.swing.JTable tblDatos;
    private javax.swing.JTable tblMutacion;
    private javax.swing.JTable tblParada;
    private javax.swing.JTable tblSeleccion;
    private javax.swing.JTable tblSolucionDescripcion;
    private javax.swing.JTextField txtAptitudMaxima;
    private javax.swing.JTextField txtAptitudMedia;
    private javax.swing.JTextField txtAptitudMinima;
    private javax.swing.JTextField txtCiclos;
    private javax.swing.JTextField txtDuracion;
    private javax.swing.JTextField txtHoraInicio;
    private javax.swing.JTextField txtMutaciones;
    private javax.swing.JTextField txtPoblacionActual;
    private javax.swing.JTextField txtPoblacionInicial;
    // End of variables declaration//GEN-END:variables
}
