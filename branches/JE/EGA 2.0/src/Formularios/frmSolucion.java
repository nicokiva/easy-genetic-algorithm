/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Formularios;

import Clase.Principal.EGA;
import Grafica.Grafica;
import Methods.*;
import Solutions.*;
import configuration.Messages;
import configuration.Paths;
import helpers.*;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import proceso.Procesador;
import solucion.Solucion;



/**
 *
 * @author Triton
 */
public class frmSolucion extends javax.swing.JInternalFrame {
    private Integer _intID;
    private int intLoading = 1;
    private boolean _blnExecuting = false;
    private boolean _blnPaused = false;
        
    String strTypeForm = forms.Solucion;
    MDI frmParent;
    Solution solution;
    Solution solutionToUse;
    
    file_handler fh = new file_handler();
    Paths paths = new Paths();
    ArrayList<Method> arrMethods;
    ArrayList<MethodInCombo> arrMethodsInCombo;
    String[] strParamsTableHeader = {"NOMBRE", "VALOR"};
    
    //Form objects
    ArrayList<comboBox> jComboBoxes = new ArrayList<>();
    ArrayList<JTable> jTables = new ArrayList<>();
    private Solucion solucionActual;
    private Procesador procesadorActual;
    
    /**
     * Creates new form frmSolucion
     */
    
    public frmSolucion(MDI frmParent, Integer intSolutionID) {
        this.startLoading();
        this.ConfigurateForm(frmParent, intSolutionID);
        this.finishLoading();
    }
    
    public frmSolucion(MDI frmParent, Integer intSolutionID, String strPathSolutionToOpen){
        this.startLoading();
        this.ConfigurateForm(frmParent, intSolutionID);
        this.OpenSolution(strPathSolutionToOpen);
        this.finishLoading();
    }
    
    private void ConfigurateForm(MDI frmParent, Integer intSolutionID){
        initComponents();
        this._intID = intSolutionID;
        this.frmParent = frmParent;
        this.setFormObjects();
        this.resetFormObjects();
        this.configurateCombo();
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
        this.OpenExistingSolution(strSolution);
        this.SetInControls(strSolution);
    }
    
    public void SetInControls(String strSolution){
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
        this.cmbCrecimientoPoblacion.setSelectedIndex(this.solution.getIntIncreasingStyle());
        
        ArrayList<Method> _arrMethod = this.solution.getArrMethods();
        for (Method _method : _arrMethod){
            JComboBox _cmbToUse;
            JTable _tblToUse;
            String _TypeMethod = _method.getIndex().substring(0, 1);

            switch(_TypeMethod){
                case "C":
                    _cmbToUse = this.cmbCromosoma;
                    _tblToUse = this.tblCromosoma;
                break;
                case "A":
                    _cmbToUse = this.cmbAptitud;
                    _tblToUse = this.tblAptitud;
                break;
                case "S":
                    _cmbToUse = this.cmbSeleccion;
                    _tblToUse = this.tblSeleccion;
                break; 
                case "X":
                    _cmbToUse = this.cmbCruzamiento;
                    _tblToUse = this.tblCruzamiento;
                break;    
                case "M":
                    _cmbToUse = this.cmbMutacion;
                    _tblToUse = this.tblMutacion;
                break;
                case "O":
                    _cmbToUse = this.cmbParada;
                    _tblToUse = this.tblParada;
                break;                   
                case "H":
                    _cmbToUse = this.cmbDatos;
                    _tblToUse = this.tblDatos;
                break;
                case "I":
                default:
                    continue;
            }
            
            
            boolean found = false;
            for (MethodInCombo _meth : this.arrMethodsInCombo){
                if (_meth.combo == _cmbToUse && _meth.method.getPath().equals(_method.getPath())){    
                    found = true;
                    _meth.combo.setSelectedIndex(_meth.position);
                }
            }
            
            if (!found){
                Method met = new Method();
                met.setPath(_method.getPath());
                int position = _cmbToUse.getItemCount();
                this.arrMethodsInCombo.add(new MethodInCombo(met, _cmbToUse, position));
                _cmbToUse.addItem(_method.getName());
                _cmbToUse.setSelectedIndex(position);
            }

            Object[][] data = new Object[_method.getParams().size()][];
            int paramN = 0;
            for(Param param : _method.getParams()){
                Object[] oneParam = {param.getName(), param.getValue()};
                data[paramN] = oneParam;
                paramN++;
            }
            if (data.length > 0)
                _tblToUse.setModel(new javax.swing.table.DefaultTableModel(data, this.strParamsTableHeader));
        }
    }
   
    private void OpenExistingSolution(String strSolution){
        fh.setPathFileToRead(strSolution);
        fh.OpenXMLReader();

        if (this.canOpenSolution()){
            ArrayList<HashMap<String, String>> _strHmArrSolution = fh.getArrXMLSolutionHeader();
            ArrayList<HashMap<String, String>> _strHmArrSolutionSettings = fh.getArrXMLSolutionSettings();
            ArrayList<HashMap<String, String>> _strHmArrSolutionInitialPopulation = fh.getArrXMLSolutionInitialPopulation();
            ArrayList<Method> _metArrXMLSolution = fh.getArrXMLSolution();
            boolean blnReadOnly = Integer.parseInt(_strHmArrSolutionSettings.get(0).get("readOnly")) != 0 ? true : false;
            
            this.solution = new Solution();
            this.solution.SetHeader(_strHmArrSolution.get(0).get("name"), _strHmArrSolution.get(1).get("author"), _strHmArrSolution.get(2).get("file"), _strHmArrSolution.get(3).get("folder"), _strHmArrSolution.get(4).get("dateCreated"), _strHmArrSolution.get(5).get("dateModified"), _strHmArrSolution.get(6).get("dateCompleted"), _strHmArrSolution.get(7).get("dateExecuted"), _strHmArrSolution.get(8).get("datePublished"), _strHmArrSolution.get(9).get("description"), _strHmArrSolution.get(10).get("observation"));
            this.solution.SetSettings(blnReadOnly, _strHmArrSolutionSettings.get(1).get("serverFolder"));
            this.solution.SetInitialPopulation(Integer.parseInt(_strHmArrSolutionInitialPopulation.get(0).get("size")), _strHmArrSolutionInitialPopulation.get(1).get("increasingStyle"));
            this.solution.setArrMethods(_metArrXMLSolution);
        }
    }
    
    private boolean canOpenSolution(){
        return (fh.ReadHeader() && fh.ReadSettings() && fh.ReadConfiguration() && fh.ReadMethods());
    }
    
    private Method getSelectedMethodInCombo(JComboBox cmbMethod){
        Method metReturn = new Method();
        int _intSelectedIndex = cmbMethod.getSelectedIndex();
        
        for (MethodInCombo cmbMethodInCombo : this.arrMethodsInCombo){
            if (cmbMethodInCombo.combo == cmbMethod && _intSelectedIndex == cmbMethodInCombo.position){
                metReturn = cmbMethodInCombo.method;
            }
        }

        return metReturn;
    }
    
    private void SetComboBoxes(){
        this.jComboBoxes.add(new comboBox(cmbAptitud, paths.strAptitudDB, "A", tblAptitud));
        this.jComboBoxes.add(new comboBox(cmbCromosoma, paths.strCromosomaDB, "C", tblCromosoma));
        this.jComboBoxes.add(new comboBox(cmbSeleccion, paths.strSeleccionDB, "S", tblSeleccion));
        this.jComboBoxes.add(new comboBox(cmbCruzamiento, paths.strCruzamientoDB, "X", tblCruzamiento));
        this.jComboBoxes.add(new comboBox(cmbMutacion, paths.strMutacionDB, "M", tblMutacion));
        this.jComboBoxes.add(new comboBox(cmbParada, paths.strParoDB, "O", tblParada));
        this.jComboBoxes.add(new comboBox(cmbDatos, paths.strAyudanteDB, "H", tblDatos));
    }
    
    private void SetTables(){
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
    }

    private void FillComboBoxes(){
        data_type_converter dtc = new data_type_converter();
        this.arrMethods = new ArrayList<>();
        this.arrMethodsInCombo = new ArrayList<>();

        for (comboBox cmbCombo : this.jComboBoxes){
            cmbCombo.combo.removeAllItems();
            fh.setPathFileToRead(cmbCombo.strFileName);
            if (fh.ReadBinary()){
                dtc.setByteText(fh.getByteText());
                dtc.fromByteToStringList();

                ArrayList<ArrayList<String>> strArrMethods = dtc.getStrArrText();
                for (ArrayList<String> strMethod : strArrMethods){
                    File _file = new File((strMethod.get(5)).toString());
                    if (_file.exists()){
                        Method met = new Method(strMethod.get(0), strMethod.get(1), strMethod.get(2), strMethod.get(3), Boolean.getBoolean(strMethod.get(4)), strMethod.get(5), cmbCombo.strFirstLetter);
                        this.arrMethodsInCombo.add(new MethodInCombo(met, cmbCombo.combo, cmbCombo.combo.getItemCount()));
                        this.arrMethods.add(met);
                        
                        cmbCombo.combo.addItem(met.getName());
                    }
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

        jFCSave = new javax.swing.JFileChooser();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        panGeneralObligatorio = new javax.swing.JPanel();
        txtNombreObligatorio = new javax.swing.JTextField();
        lblUbicacionArchivoSolucion = new javax.swing.JLabel();
        txtUbicacionArchivoSolucion = new javax.swing.JTextField();
        lblNombreObligatorio = new javax.swing.JLabel();
        btnArchivoSolucion = new javax.swing.JButton();
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
        panAptitud = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        btnEditarAptitud = new javax.swing.JButton();
        btnAyudaAptitud = new javax.swing.JButton();
        btnNuevoAptitud = new javax.swing.JButton();
        cmbAptitud = new javax.swing.JComboBox();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblAptitud = new javax.swing.JTable();
        panOperador = new javax.swing.JPanel();
        panSeleccion = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnEditarSeleccion = new javax.swing.JButton();
        btnNuevoSeleccion = new javax.swing.JButton();
        btnAyudaSeleccion = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblSeleccion = new javax.swing.JTable();
        cmbSeleccion = new javax.swing.JComboBox();
        panCruzamiento = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblCruzamiento = new javax.swing.JTable();
        btnEditarCruzamiento = new javax.swing.JButton();
        btnNuevoCruzamiento = new javax.swing.JButton();
        btnAyudaCruzamiento = new javax.swing.JButton();
        cmbCruzamiento = new javax.swing.JComboBox();
        panMutacion = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblMutacion = new javax.swing.JTable();
        btnEditarMutacion = new javax.swing.JButton();
        btnNuevoMutacion = new javax.swing.JButton();
        btnAyudaMutacion = new javax.swing.JButton();
        cmbMutacion = new javax.swing.JComboBox();
        panParada = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblParada = new javax.swing.JTable();
        btnEditarParada = new javax.swing.JButton();
        btnNuevoParada = new javax.swing.JButton();
        btnAyudaParada = new javax.swing.JButton();
        cmbParada = new javax.swing.JComboBox();
        panDatos = new javax.swing.JPanel();
        cmbDatos = new javax.swing.JComboBox();
        jLabel19 = new javax.swing.JLabel();
        btnEditarCargaDatos = new javax.swing.JButton();
        btnAyudaCargaDatos = new javax.swing.JButton();
        btnNuevoCargaDatos = new javax.swing.JButton();
        jScrollPane11 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        panCromosoma = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        btnEditarCromosoma = new javax.swing.JButton();
        btnAyudaCromosoma = new javax.swing.JButton();
        btnNuevoCromosoma = new javax.swing.JButton();
        cmbCromosoma = new javax.swing.JComboBox();
        jScrollPane10 = new javax.swing.JScrollPane();
        tblCromosoma = new javax.swing.JTable();
        panProceso = new javax.swing.JPanel();
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
        btnInforme = new javax.swing.JButton();
        btnGrafica = new javax.swing.JButton();
        btnReparametrizar = new javax.swing.JButton();
        btnTrigger = new javax.swing.JToggleButton();
        panConfiguracionVisualizacion = new javax.swing.JPanel();
        btnEditarInforme = new javax.swing.JButton();
        btnEditarMetodoResultados = new javax.swing.JButton();
        btnSalirConfiguracion = new javax.swing.JButton();
        btnExportarConfiguracion = new javax.swing.JButton();
        btnPublicarConfiguracion = new javax.swing.JButton();
        btnGuardarConfiguracion = new javax.swing.JButton();
        btnLimpiarConfiguracion = new javax.swing.JButton();
        panConfiguracion = new javax.swing.JPanel();
        cmbCrecimientoPoblacion = new javax.swing.JComboBox();
        lblPoblacionInicial = new javax.swing.JLabel();
        txtPoblacionInicial = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jspResources = new javax.swing.JScrollPane();
        tblGanadores = new javax.swing.JTable();
        jScrollPane12 = new javax.swing.JScrollPane();
        lstArchivos = new javax.swing.JList();
        lblGanadores = new javax.swing.JLabel();
        lblListaArchivos = new javax.swing.JLabel();
        btnSalirResultados = new javax.swing.JButton();
        btnExportarResultados = new javax.swing.JButton();
        btnPublicarResultados = new javax.swing.JButton();
        btnGuardarResultados = new javax.swing.JButton();
        btnRefrescar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("EGA - Solución");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ICON.png"))); // NOI18N
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(1010, 670));
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }
        setVisible(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N

        jPanel1.setPreferredSize(new java.awt.Dimension(1010, 650));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panGeneralObligatorio.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Obligatorios de la Solución", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 12), java.awt.Color.black)); // NOI18N
        panGeneralObligatorio.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        panGeneralObligatorio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNombreObligatorio.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtNombreObligatorio.setText("Distribución de personas.");
        txtNombreObligatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreObligatorioActionPerformed(evt);
            }
        });
        panGeneralObligatorio.add(txtNombreObligatorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 30, 188, 22));

        lblUbicacionArchivoSolucion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblUbicacionArchivoSolucion.setText("Ubicación:");
        panGeneralObligatorio.add(lblUbicacionArchivoSolucion, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 94, 60, -1));

        txtUbicacionArchivoSolucion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtUbicacionArchivoSolucion.setText("C:\\Usuarios\\Triton\\Escritorio\\EGA\\Pruebas");
        txtUbicacionArchivoSolucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUbicacionArchivoSolucionActionPerformed(evt);
            }
        });
        panGeneralObligatorio.add(txtUbicacionArchivoSolucion, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 90, 358, 22));

        lblNombreObligatorio.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblNombreObligatorio.setText("Nombre:");
        panGeneralObligatorio.add(lblNombreObligatorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 34, 50, -1));

        btnArchivoSolucion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnArchivoSolucion.setText("...");
        panGeneralObligatorio.add(btnArchivoSolucion, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 60, 30, 21));

        txtArchivoSolucion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtArchivoSolucion.setText("OrganizaciónEventos.sl");
        txtArchivoSolucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtArchivoSolucionActionPerformed(evt);
            }
        });
        panGeneralObligatorio.add(txtArchivoSolucion, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 60, 358, 22));

        lblArchivoSolucion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblArchivoSolucion.setText("Archivo:");
        panGeneralObligatorio.add(lblArchivoSolucion, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 64, 50, -1));

        btnUbicacionArchivoSolucion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnUbicacionArchivoSolucion.setText("...");
        panGeneralObligatorio.add(btnUbicacionArchivoSolucion, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 90, 30, 21));

        lblAutor.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblAutor.setText("Autor:");
        panGeneralObligatorio.add(lblAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(278, 34, 34, -1));

        txtAutor.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtAutor.setText("Pablo Pytel");
        txtAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAutorActionPerformed(evt);
            }
        });
        panGeneralObligatorio.add(txtAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(312, 30, 156, 22));

        jPanel1.add(panGeneralObligatorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 490, 140));

        panGeneralFecha.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Información de Fechas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 12), java.awt.Color.black)); // NOI18N
        panGeneralFecha.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        panGeneralFecha.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFechaCreacion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblFechaCreacion.setText("Fecha de Creación:");
        panGeneralFecha.add(lblFechaCreacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 30, 110, -1));

        txtFechaCreacion.setEditable(false);
        try {
            txtFechaCreacion.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("## / ## / ####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtFechaCreacion.setText("27 / 05 / 2012");
        txtFechaCreacion.setToolTipText("");
        txtFechaCreacion.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtFechaCreacion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtFechaCreacion.setMargin(new java.awt.Insets(2, 10, 2, 2));
        panGeneralFecha.add(txtFechaCreacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 30, 95, -1));

        lblFechaModificacion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblFechaModificacion.setText("Fecha de Modificación:");
        panGeneralFecha.add(lblFechaModificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 60, 130, -1));

        txtFechaModificacion.setEditable(false);
        try {
            txtFechaModificacion.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("## / ## / ####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtFechaModificacion.setText("08 / 09 / 2012");
        txtFechaModificacion.setToolTipText("");
        txtFechaModificacion.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtFechaModificacion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtFechaModificacion.setMargin(new java.awt.Insets(2, 10, 2, 2));
        panGeneralFecha.add(txtFechaModificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 60, 95, -1));

        lblFechaCompletado.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblFechaCompletado.setText("Fecha de Completado:");
        panGeneralFecha.add(lblFechaCompletado, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 90, 130, -1));

        try {
            txtFechaCompletado.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("## / ## / ####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtFechaCompletado.setText("29 / 05 / 2012");
        txtFechaCompletado.setToolTipText("");
        txtFechaCompletado.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtFechaCompletado.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtFechaCompletado.setMargin(new java.awt.Insets(2, 10, 2, 2));
        panGeneralFecha.add(txtFechaCompletado, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 90, 95, -1));

        lblFechaEjecucion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblFechaEjecucion.setText("Fecha de Ejecución:");
        panGeneralFecha.add(lblFechaEjecucion, new org.netbeans.lib.awtextra.AbsoluteConstraints(253, 30, 120, -1));

        txtFechaEjecucion.setEditable(false);
        try {
            txtFechaEjecucion.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("## / ## / ####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtFechaEjecucion.setText("08 / 09 / 2012");
        txtFechaEjecucion.setToolTipText("");
        txtFechaEjecucion.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtFechaEjecucion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtFechaEjecucion.setMargin(new java.awt.Insets(2, 10, 2, 2));
        panGeneralFecha.add(txtFechaEjecucion, new org.netbeans.lib.awtextra.AbsoluteConstraints(375, 30, 95, -1));

        lblFechaPublicacion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblFechaPublicacion.setText("Fecha de Publicación:");
        panGeneralFecha.add(lblFechaPublicacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(253, 60, 130, -1));

        try {
            txtFechaPublicacion.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("## / ## / ####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtFechaPublicacion.setToolTipText("");
        txtFechaPublicacion.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtFechaPublicacion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtFechaPublicacion.setMargin(new java.awt.Insets(2, 10, 2, 2));
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
        txtObservacionSolucion.setPreferredSize(new java.awt.Dimension(120, 90));
        jScrollPane2.setViewportView(txtObservacionSolucion);

        panGeneralObservacion.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 946, 112));

        jPanel1.add(panGeneralObservacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 980, 160));

        panGeneralDescripcion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Descripción de la Solución", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 12), java.awt.Color.black)); // NOI18N
        panGeneralDescripcion.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        panGeneralDescripcion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtDescripcionSolucion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtDescripcionSolucion.setText("Esta solución está pensada para eventos de entre 70 y 100 personas. En las pruebas con otras cantidades superiores o inferiores, no se logra la misma \nconvergencia, lo cual obliga a una reparemtrización y esto es cambiar la solución por otra.  \n\nEs recomendable usar probabilidades de mutación por debajo del 1% y paremetrizar el cruzamiento multipunto de manera uniforme.  \n");
        txtDescripcionSolucion.setMargin(new java.awt.Insets(5, 10, 5, 10));
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
        txtCarpetaPublica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCarpetaPublicaActionPerformed(evt);
            }
        });
        panOtrasOpciones.add(txtCarpetaPublica, new org.netbeans.lib.awtextra.AbsoluteConstraints(446, 26, 304, 22));

        btnCarpetaPublica.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnCarpetaPublica.setText("...");
        panOtrasOpciones.add(btnCarpetaPublica, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 26, 30, 21));

        jPanel1.add(panOtrasOpciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, 980, 60));

        btnGuardarGeneral.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnGuardarGeneral.setText("Guardar");
        jPanel1.add(btnGuardarGeneral, new org.netbeans.lib.awtextra.AbsoluteConstraints(244, 578, 148, 23));

        btnPublicarGeneral.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnPublicarGeneral.setText("Publicar");
        jPanel1.add(btnPublicarGeneral, new org.netbeans.lib.awtextra.AbsoluteConstraints(412, 578, 148, 23));

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
        jPanel1.add(btnExportarGeneral, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 578, 148, 23));

        btnSalirGeneral.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnSalirGeneral.setText("Salir");
        jPanel1.add(btnSalirGeneral, new org.netbeans.lib.awtextra.AbsoluteConstraints(746, 578, 148, 23));

        jTabbedPane1.addTab("General", jPanel1);
        jPanel1.getAccessibleContext().setAccessibleName("");

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panAptitud.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Función de Aptitud", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 12))); // NOI18N
        panAptitud.setAlignmentX(0.0F);
        panAptitud.setAlignmentY(0.0F);
        panAptitud.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel18.setText("Ingrese el Valor de los Parámetros:");
        panAptitud.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 50, -1, -1));

        btnEditarAptitud.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnEditarAptitud.setText("Editar");
        btnEditarAptitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarAptitudActionPerformed(evt);
            }
        });
        panAptitud.add(btnEditarAptitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 156, 81, -1));

        btnAyudaAptitud.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnAyudaAptitud.setText("?");
        btnAyudaAptitud.setMargin(new java.awt.Insets(2, 1, 2, 1));
        btnAyudaAptitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAyudaAptitudActionPerformed(evt);
            }
        });
        panAptitud.add(btnAyudaAptitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 156, 37, -1));

        btnNuevoAptitud.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnNuevoAptitud.setText("Nuevo");
        btnNuevoAptitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoAptitudActionPerformed(evt);
            }
        });
        panAptitud.add(btnNuevoAptitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 156, 75, -1));

        cmbAptitud.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        cmbAptitud.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Aptitud de Eventos", "Aptitud de Passwords", "Aptitud de Prueba", "Aptitud de RRHH" }));
        cmbAptitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbAptitudActionPerformed(evt);
            }
        });
        panAptitud.add(cmbAptitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 24, 210, -1));

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
        tblAptitud.getColumnModel().getColumn(1).setPreferredWidth(15);

        panAptitud.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 70, 208, 80));

        jPanel2.add(panAptitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(755, 11, 237, 197));

        panOperador.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Operadores", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 12))); // NOI18N
        panOperador.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panSeleccion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Método de Selección", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 12))); // NOI18N
        panSeleccion.setAlignmentX(0.0F);
        panSeleccion.setAlignmentY(0.0F);
        panSeleccion.setFont(new java.awt.Font("Script MT Bold", 0, 12)); // NOI18N
        panSeleccion.setPreferredSize(new java.awt.Dimension(229, 205));
        panSeleccion.setLayout(null);

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel2.setText("Ingrese el Valor de los Parámetros:");
        panSeleccion.add(jLabel2);
        jLabel2.setBounds(16, 58, 197, 16);

        btnEditarSeleccion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnEditarSeleccion.setText("Editar");
        btnEditarSeleccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarSeleccionActionPerformed(evt);
            }
        });
        panSeleccion.add(btnEditarSeleccion);
        btnEditarSeleccion.setBounds(16, 200, 81, 25);

        btnNuevoSeleccion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnNuevoSeleccion.setText("Nuevo");
        btnNuevoSeleccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoSeleccionActionPerformed(evt);
            }
        });
        panSeleccion.add(btnNuevoSeleccion);
        btnNuevoSeleccion.setBounds(106, 200, 75, 25);

        btnAyudaSeleccion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnAyudaSeleccion.setText("?");
        btnAyudaSeleccion.setMargin(new java.awt.Insets(2, 1, 2, 1));
        btnAyudaSeleccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAyudaSeleccionActionPerformed(evt);
            }
        });
        panSeleccion.add(btnAyudaSeleccion);
        btnAyudaSeleccion.setBounds(188, 200, 37, 24);

        tblSeleccion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"CANTIDAD", "10"}
            },
            new String [] {
                "NOMBRE", "VALOR"
            }
        ));
        tblSeleccion.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tblSeleccion);
        tblSeleccion.getColumnModel().getColumn(1).setPreferredWidth(15);

        panSeleccion.add(jScrollPane3);
        jScrollPane3.setBounds(16, 78, 208, 114);

        cmbSeleccion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        cmbSeleccion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Elija un método...", "Ranking", "Torneo", "Ruleta", "Control s/n esperado" }));
        cmbSeleccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSeleccionActionPerformed(evt);
            }
        });
        panSeleccion.add(cmbSeleccion);
        cmbSeleccion.setBounds(16, 27, 208, 22);

        panOperador.add(panSeleccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 16, 238, 239));

        panCruzamiento.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Método de Cruzamiento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 12))); // NOI18N
        panCruzamiento.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        panCruzamiento.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel3.setText("Ingrese el Valor de los Parámetros:");
        panCruzamiento.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 58, 197, -1));

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
        jScrollPane4.setViewportView(tblCruzamiento);
        tblCruzamiento.getColumnModel().getColumn(1).setPreferredWidth(15);

        panCruzamiento.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 78, 200, 114));

        btnEditarCruzamiento.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnEditarCruzamiento.setText("Editar");
        btnEditarCruzamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarCruzamientoActionPerformed(evt);
            }
        });
        panCruzamiento.add(btnEditarCruzamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 200, 81, -1));

        btnNuevoCruzamiento.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnNuevoCruzamiento.setText("Nuevo");
        btnNuevoCruzamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoCruzamientoActionPerformed(evt);
            }
        });
        panCruzamiento.add(btnNuevoCruzamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 200, 75, -1));

        btnAyudaCruzamiento.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnAyudaCruzamiento.setText("?");
        btnAyudaCruzamiento.setMargin(new java.awt.Insets(2, 1, 2, 1));
        btnAyudaCruzamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAyudaCruzamientoActionPerformed(evt);
            }
        });
        panCruzamiento.add(btnAyudaCruzamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(184, 200, 37, -1));

        cmbCruzamiento.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        cmbCruzamiento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Elija un método...", "Máscara Multipunto", "Máscara Simple", " " }));
        cmbCruzamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCruzamientoActionPerformed(evt);
            }
        });
        panCruzamiento.add(cmbCruzamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 27, 200, -1));

        panOperador.add(panCruzamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 16, 230, 239));

        panMutacion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Método de Mutación", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 12))); // NOI18N
        panMutacion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        panMutacion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jScrollPane5.setViewportView(tblMutacion);
        tblMutacion.getColumnModel().getColumn(1).setPreferredWidth(15);

        panMutacion.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 78, 210, 114));

        btnEditarMutacion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnEditarMutacion.setText("Editar");
        btnEditarMutacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarMutacionActionPerformed(evt);
            }
        });
        panMutacion.add(btnEditarMutacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 200, 81, -1));

        btnNuevoMutacion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnNuevoMutacion.setText("Nuevo");
        btnNuevoMutacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoMutacionActionPerformed(evt);
            }
        });
        panMutacion.add(btnNuevoMutacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 200, 75, -1));

        btnAyudaMutacion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnAyudaMutacion.setText("?");
        btnAyudaMutacion.setMargin(new java.awt.Insets(2, 1, 2, 1));
        btnAyudaMutacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAyudaMutacionActionPerformed(evt);
            }
        });
        panMutacion.add(btnAyudaMutacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 200, 37, -1));

        cmbMutacion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        cmbMutacion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Elija un método...", "Azar" }));
        cmbMutacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMutacionActionPerformed(evt);
            }
        });
        panMutacion.add(cmbMutacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 24, 210, -1));

        panOperador.add(panMutacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(497, 16, 240, 240));

        panParada.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Método de Parada", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 12))); // NOI18N
        panParada.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        panParada.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jScrollPane9.setViewportView(tblParada);
        tblParada.getColumnModel().getColumn(1).setPreferredWidth(15);

        panParada.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 78, 197, 112));

        btnEditarParada.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnEditarParada.setText("Editar");
        btnEditarParada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarParadaActionPerformed(evt);
            }
        });
        panParada.add(btnEditarParada, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 200, 81, -1));

        btnNuevoParada.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnNuevoParada.setText("Nuevo");
        btnNuevoParada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoParadaActionPerformed(evt);
            }
        });
        panParada.add(btnNuevoParada, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, 75, -1));

        btnAyudaParada.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnAyudaParada.setText("?");
        btnAyudaParada.setMargin(new java.awt.Insets(2, 1, 2, 1));
        btnAyudaParada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAyudaParadaActionPerformed(evt);
            }
        });
        panParada.add(btnAyudaParada, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 200, 37, -1));

        cmbParada.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        cmbParada.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Elija un método...", "por Tiempo", "por Ciclos", "por Valor de Aptitud", "por Tamaño de Población" }));
        cmbParada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbParadaActionPerformed(evt);
            }
        });
        panParada.add(cmbParada, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 24, 198, -1));

        panOperador.add(panParada, new org.netbeans.lib.awtextra.AbsoluteConstraints(741, 16, 230, 240));

        jPanel2.add(panOperador, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 214, 982, 270));

        panDatos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Método de Carga de Datos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 12))); // NOI18N
        panDatos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cmbDatos.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        cmbDatos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mis datos en SQL Server", "Mis datos en XML", "Mis datos en TXT", "Mis datos en Excel" }));
        cmbDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDatosActionPerformed(evt);
            }
        });
        panDatos.add(cmbDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 24, 210, -1));

        jLabel19.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel19.setText("Ingrese el Valor de los Parámetros:");
        panDatos.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 50, -1, -1));

        btnEditarCargaDatos.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnEditarCargaDatos.setText("Editar");
        btnEditarCargaDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarCargaDatosActionPerformed(evt);
            }
        });
        panDatos.add(btnEditarCargaDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 156, 81, -1));

        btnAyudaCargaDatos.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnAyudaCargaDatos.setText("?");
        btnAyudaCargaDatos.setMargin(new java.awt.Insets(2, 1, 2, 1));
        btnAyudaCargaDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAyudaCargaDatosActionPerformed(evt);
            }
        });
        panDatos.add(btnAyudaCargaDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 156, 37, -1));

        btnNuevoCargaDatos.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnNuevoCargaDatos.setText("Nuevo");
        btnNuevoCargaDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoCargaDatosActionPerformed(evt);
            }
        });
        panDatos.add(btnNuevoCargaDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 156, 75, -1));

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
        jScrollPane11.setViewportView(tblDatos);

        panDatos.add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 70, 210, 80));

        jPanel2.add(panDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(269, 11, 237, 197));

        panCromosoma.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tipo de Cromosoma", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 12))); // NOI18N
        panCromosoma.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel20.setText("Ingrese el Valor de los Parámetros:");
        panCromosoma.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 50, -1, -1));

        btnEditarCromosoma.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnEditarCromosoma.setText("Editar");
        btnEditarCromosoma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarCromosomaActionPerformed(evt);
            }
        });
        panCromosoma.add(btnEditarCromosoma, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 156, 81, -1));

        btnAyudaCromosoma.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnAyudaCromosoma.setText("?");
        btnAyudaCromosoma.setMargin(new java.awt.Insets(2, 1, 2, 1));
        btnAyudaCromosoma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAyudaCromosomaActionPerformed(evt);
            }
        });
        panCromosoma.add(btnAyudaCromosoma, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 156, 37, -1));

        btnNuevoCromosoma.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnNuevoCromosoma.setText("Nuevo");
        btnNuevoCromosoma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoCromosomaActionPerformed(evt);
            }
        });
        panCromosoma.add(btnNuevoCromosoma, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 156, 75, -1));

        cmbCromosoma.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        cmbCromosoma.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cromosoma Eventos", "Cromosoma Password", "Cromosoma de Prueba", "Cromosoma RRHH" }));
        cmbCromosoma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCromosomaActionPerformed(evt);
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
        jScrollPane10.setViewportView(tblCromosoma);
        tblCromosoma.getColumnModel().getColumn(1).setPreferredWidth(15);

        panCromosoma.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 70, 208, 80));

        jPanel2.add(panCromosoma, new org.netbeans.lib.awtextra.AbsoluteConstraints(512, 12, 237, 197));

        panProceso.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Proceso", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 12), java.awt.Color.black)); // NOI18N
        panProceso.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        panProceso.setMaximumSize(new java.awt.Dimension(1000, 99));
        panProceso.setMinimumSize(new java.awt.Dimension(500, 99));
        panProceso.setPreferredSize(new java.awt.Dimension(960, 99));
        panProceso.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblHoraInicio.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblHoraInicio.setText("Hora Inicio:");
        panProceso.add(lblHoraInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 22, -1, -1));

        txtHoraInicio.setText("15:34");
        txtHoraInicio.setAlignmentX(1.5F);
        txtHoraInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHoraInicioActionPerformed(evt);
            }
        });
        panProceso.add(txtHoraInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 20, 60, -1));

        lblDuracion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblDuracion.setText("Duración:");
        panProceso.add(lblDuracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 52, -1, -1));

        txtDuracion.setText("00:45:21");
        txtDuracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDuracionActionPerformed(evt);
            }
        });
        panProceso.add(txtDuracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 50, 60, -1));

        lblPoblacionActual.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblPoblacionActual.setText("Población:");
        panProceso.add(lblPoblacionActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 22, -1, -1));

        txtPoblacionActual.setText("500");
        txtPoblacionActual.setAlignmentX(1.5F);
        txtPoblacionActual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPoblacionActualActionPerformed(evt);
            }
        });
        panProceso.add(txtPoblacionActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 60, -1));

        lblCiclos.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblCiclos.setText("Ciclos:");
        panProceso.add(lblCiclos, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, -1, -1));

        txtCiclos.setText("1346");
        txtCiclos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCiclosActionPerformed(evt);
            }
        });
        panProceso.add(txtCiclos, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 59, -1));

        lblMutaciones.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblMutaciones.setText("Mutaciones:");
        panProceso.add(lblMutaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, -1, -1));

        txtMutaciones.setText("14");
        txtMutaciones.setAlignmentX(1.5F);
        txtMutaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMutacionesActionPerformed(evt);
            }
        });
        panProceso.add(txtMutaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, 60, -1));

        lblAptitudMedia.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblAptitudMedia.setText("Aptitud Media:");
        panProceso.add(lblAptitudMedia, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, -1, -1));

        txtAptitudMedia.setText("99");
        txtAptitudMedia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAptitudMediaActionPerformed(evt);
            }
        });
        panProceso.add(txtAptitudMedia, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, 59, -1));

        lblAptitudMaxima.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblAptitudMaxima.setText("Aptitud Máx:");
        panProceso.add(lblAptitudMaxima, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, -1, -1));

        txtAptitudMaxima.setText("290");
        txtAptitudMaxima.setAlignmentX(1.5F);
        txtAptitudMaxima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAptitudMaximaActionPerformed(evt);
            }
        });
        panProceso.add(txtAptitudMaxima, new org.netbeans.lib.awtextra.AbsoluteConstraints(487, 20, 60, -1));

        lblAptitudMinima.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblAptitudMinima.setText("Aptitud Min:");
        panProceso.add(lblAptitudMinima, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, -1, -1));

        txtAptitudMinima.setText("20");
        txtAptitudMinima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAptitudMinimaActionPerformed(evt);
            }
        });
        panProceso.add(txtAptitudMinima, new org.netbeans.lib.awtextra.AbsoluteConstraints(487, 50, 59, -1));

        btnInforme.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnInforme.setText("Ver Informe");
        btnInforme.setAlignmentY(0.0F);
        btnInforme.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnInforme.setMaximumSize(new java.awt.Dimension(80, 23));
        btnInforme.setMinimumSize(new java.awt.Dimension(50, 23));
        btnInforme.setPreferredSize(new java.awt.Dimension(71, 23));
        panProceso.add(btnInforme, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 20, 100, 49));

        btnGrafica.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnGrafica.setText("Ver Gráfica");
        btnGrafica.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnGrafica.setMaximumSize(new java.awt.Dimension(90, 23));
        btnGrafica.setMinimumSize(new java.awt.Dimension(50, 23));
        btnGrafica.setPreferredSize(new java.awt.Dimension(79, 23));
        btnGrafica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGraficaActionPerformed(evt);
            }
        });
        panProceso.add(btnGrafica, new org.netbeans.lib.awtextra.AbsoluteConstraints(765, 20, 100, 49));

        btnReparametrizar.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnReparametrizar.setText("Reparametrizar");
        btnReparametrizar.setActionCommand("Parámetros\\n de repara");
        btnReparametrizar.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnReparametrizar.setMaximumSize(new java.awt.Dimension(90, 23));
        btnReparametrizar.setMinimumSize(new java.awt.Dimension(50, 23));
        btnReparametrizar.setPreferredSize(new java.awt.Dimension(73, 23));
        panProceso.add(btnReparametrizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 20, 100, 49));

        btnTrigger.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnTrigger.setText("Comenzar");
        btnTrigger.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTriggerActionPerformed(evt);
            }
        });
        panProceso.add(btnTrigger, new org.netbeans.lib.awtextra.AbsoluteConstraints(555, 20, 100, 49));

        jPanel2.add(panProceso, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 493, 982, 79));

        panConfiguracionVisualizacion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Opciones de Visualización", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 12))); // NOI18N
        panConfiguracionVisualizacion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEditarInforme.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnEditarInforme.setText("Editar Informe");
        panConfiguracionVisualizacion.add(btnEditarInforme, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 24, 210, 26));

        btnEditarMetodoResultados.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnEditarMetodoResultados.setText("Editar Método de Resultados");
        panConfiguracionVisualizacion.add(btnEditarMetodoResultados, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 55, 210, 26));

        jPanel2.add(panConfiguracionVisualizacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 109, 253, 98));

        btnSalirConfiguracion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnSalirConfiguracion.setText("Salir");
        jPanel2.add(btnSalirConfiguracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(746, 578, 148, 23));

        btnExportarConfiguracion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnExportarConfiguracion.setText("Exportar");
        jPanel2.add(btnExportarConfiguracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 578, 148, 23));

        btnPublicarConfiguracion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnPublicarConfiguracion.setText("Publicar");
        jPanel2.add(btnPublicarConfiguracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(412, 578, 148, 23));

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
        jPanel2.add(btnLimpiarConfiguracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 578, 148, 23));

        panConfiguracion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Configuración de la Población", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 12))); // NOI18N
        panConfiguracion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cmbCrecimientoPoblacion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        cmbCrecimientoPoblacion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Población Fija", "Población Creciente", "Población Decreciente" }));
        cmbCrecimientoPoblacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCrecimientoPoblacionActionPerformed(evt);
            }
        });
        panConfiguracion.add(cmbCrecimientoPoblacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 53, 221, -1));

        lblPoblacionInicial.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblPoblacionInicial.setText("Tamaño Inicial:");
        panConfiguracion.add(lblPoblacionInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 30, -1, -1));

        txtPoblacionInicial.setText("500");
        txtPoblacionInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPoblacionInicialActionPerformed(evt);
            }
        });
        panConfiguracion.add(txtPoblacionInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 27, 130, -1));

        jPanel2.add(panConfiguracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 253, 91));

        jTabbedPane1.addTab("Configuración", jPanel2);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblGanadores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"OPCIONES", "MESA 1", "MESA 2", "MESA 3", "MESA 4", "MESA 5", "MESA 6"},
                {"1", "Pese", "Beto", "Anabella", "Pedro", "Leo", "Lore"},
                {"Aptitud=420", "Jose", "Pablo", "Josefina", "Manuel", "Roberto", "Clau"},
                {null, "Ricardo", "Marta", "Cleo", "Guillermo", "Julian", null},
                {null, "Andrea", "Adrian", "Lucrecia", "Nico", null, null},
                {null, null, null, null, null, null, null},
                {"2", "Beto", "Ricardo", "Anabella", "Cleo", "Leo", "Roberto"},
                {"Aptitud=396", "Pablo", "Andrea", "Josefina", "Lucrecia", "Clau", "Julian"},
                {null, "Jose", "Marta", "Guillermo", "Pedro", null, "Lore"},
                {null, "Pepe", "Adrian", "Nico", "Manuel", null, null},
                {null, null, null, null, null, null, null},
                {"3", "Beto", "Leo", "Josefina", "Julian", "Marta", "Lore"},
                {"Aptitud=390", "Ricardo", "Roberto", "Lucrecia", "Jose", "Guillermo", "Pepe"},
                {null, "Anabella", "Pablo", "Clau", null, "Pedro", "Adrian"},
                {null, "Cleo", "Andrea", null, null, null, "Nico"},
                {null, null, null, null, null, null, "Manuel"},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "", "", "", "", "", "", ""
            }
        ));
        tblGanadores.getTableHeader().setReorderingAllowed(false);
        jspResources.setViewportView(tblGanadores);

        jPanel3.add(jspResources, new org.netbeans.lib.awtextra.AbsoluteConstraints(222, 30, 764, 532));

        lstArchivos.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lstArchivos.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "C:\\EGA\\Resultados\\2012.07.01.res", "C:\\EGA\\Resultados\\2012.07.21.res", "C:\\EGA\\Resultados\\2012.08.04.res", "C:\\Users\\Pytel\\Desktop\\EGA\\Resultados\\2012.09.05.res" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        lstArchivos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstArchivos.setVisibleRowCount(20);
        jScrollPane12.setViewportView(lstArchivos);

        jPanel3.add(jScrollPane12, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 30, 210, 532));

        lblGanadores.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblGanadores.setText("Cromosomas Ganadores del Archivo Elegido:");
        jPanel3.add(lblGanadores, new org.netbeans.lib.awtextra.AbsoluteConstraints(222, 10, 352, -1));

        lblListaArchivos.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblListaArchivos.setText("Elija un Archivo de Resultados:");
        jPanel3.add(lblListaArchivos, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 10, 182, -1));

        btnSalirResultados.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnSalirResultados.setText("Salir");
        jPanel3.add(btnSalirResultados, new org.netbeans.lib.awtextra.AbsoluteConstraints(746, 578, 148, 23));

        btnExportarResultados.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnExportarResultados.setText("Exportar");
        jPanel3.add(btnExportarResultados, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 578, 148, 23));

        btnPublicarResultados.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnPublicarResultados.setText("Publicar");
        jPanel3.add(btnPublicarResultados, new org.netbeans.lib.awtextra.AbsoluteConstraints(412, 578, 148, 23));

        btnGuardarResultados.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnGuardarResultados.setText("Guardar");
        jPanel3.add(btnGuardarResultados, new org.netbeans.lib.awtextra.AbsoluteConstraints(244, 578, 148, 23));

        btnRefrescar.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnRefrescar.setText("Ver Gráfica");
        jPanel3.add(btnRefrescar, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 578, 148, 23));

        jTabbedPane1.addTab("Resultados", jPanel3);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 640));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreObligatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreObligatorioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreObligatorioActionPerformed

    private void txtUbicacionArchivoSolucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUbicacionArchivoSolucionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUbicacionArchivoSolucionActionPerformed

    private void txtArchivoSolucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtArchivoSolucionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtArchivoSolucionActionPerformed

    private void chkSoloLecturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkSoloLecturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkSoloLecturaActionPerformed

    private void cmbDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDatosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbDatosActionPerformed

    private void cmbCromosomaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCromosomaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCromosomaActionPerformed

    private void cmbAptitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAptitudActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbAptitudActionPerformed

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

    private void cmbSeleccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSeleccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbSeleccionActionPerformed

    private void cmbCruzamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCruzamientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCruzamientoActionPerformed

    private void cmbMutacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMutacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbMutacionActionPerformed

    private void cmbParadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbParadaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbParadaActionPerformed

    private void txtAutor3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAutor3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAutor3ActionPerformed

    private void txtCarpetaPublicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCarpetaPublicaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCarpetaPublicaActionPerformed

    private void cmbCrecimientoPoblacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCrecimientoPoblacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCrecimientoPoblacionActionPerformed

    private void txtPoblacionInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPoblacionInicialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPoblacionInicialActionPerformed

    private void btnAyudaCargaDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAyudaCargaDatosActionPerformed
        if (this.cmbDatos.getItemCount() > 0  && this.cmbDatos.getSelectedIndex() >= 0)
            this.frmParent.AbrirVentana("frmDescripcionFuncion", this._intID, getSelectedMethodInCombo(this.cmbDatos), false); 
        else
            JOptionPane.showMessageDialog(this, Messages.strElementNotSelected, "EGA", 1);        
    }//GEN-LAST:event_btnAyudaCargaDatosActionPerformed

    private void btnAyudaCromosomaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAyudaCromosomaActionPerformed
        if (this.cmbCromosoma.getItemCount() > 0  && this.cmbCromosoma.getSelectedIndex() >= 0)
            this.frmParent.AbrirVentana("frmDescripcionFuncion", this._intID, getSelectedMethodInCombo(this.cmbCromosoma), false); 
        else
            JOptionPane.showMessageDialog(this, Messages.strElementNotSelected, "EGA", 1);
    }//GEN-LAST:event_btnAyudaCromosomaActionPerformed

    private void btnAyudaAptitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAyudaAptitudActionPerformed
        if (this.cmbAptitud.getItemCount() > 0  && this.cmbAptitud.getSelectedIndex() >= 0)
            this.frmParent.AbrirVentana("frmDescripcionFuncion", this._intID, getSelectedMethodInCombo(this.cmbAptitud), false); 
        else
            JOptionPane.showMessageDialog(this, Messages.strElementNotSelected, "EGA", 1);
    }//GEN-LAST:event_btnAyudaAptitudActionPerformed

    private void btnAyudaSeleccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAyudaSeleccionActionPerformed
        if (this.cmbSeleccion.getItemCount() > 0  && this.cmbSeleccion.getSelectedIndex() >= 0)
            this.frmParent.AbrirVentana("frmDescripcionFuncion", this._intID, getSelectedMethodInCombo(this.cmbSeleccion), false); 
        else
            JOptionPane.showMessageDialog(this, Messages.strElementNotSelected, "EGA", 1);
    }//GEN-LAST:event_btnAyudaSeleccionActionPerformed

    private void btnAyudaCruzamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAyudaCruzamientoActionPerformed
        if (this.cmbCruzamiento.getItemCount() > 0  && this.cmbCruzamiento.getSelectedIndex() >= 0)
            this.frmParent.AbrirVentana("frmDescripcionFuncion", this._intID, getSelectedMethodInCombo(this.cmbCruzamiento), false); 
        else
            JOptionPane.showMessageDialog(this, Messages.strElementNotSelected, "EGA", 1);
    }//GEN-LAST:event_btnAyudaCruzamientoActionPerformed

    private void btnAyudaMutacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAyudaMutacionActionPerformed
        if (this.cmbMutacion.getItemCount() > 0  && this.cmbMutacion.getSelectedIndex() >= 0)
            this.frmParent.AbrirVentana("frmDescripcionFuncion", this._intID, getSelectedMethodInCombo(this.cmbMutacion), false); 
        else
            JOptionPane.showMessageDialog(this, Messages.strElementNotSelected, "EGA", 1);
    }//GEN-LAST:event_btnAyudaMutacionActionPerformed

    private void btnAyudaParadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAyudaParadaActionPerformed
        if (this.cmbParada.getItemCount() > 0  && this.cmbParada.getSelectedIndex() >= 0)
            this.frmParent.AbrirVentana("frmDescripcionFuncion", this._intID, getSelectedMethodInCombo(this.cmbParada), false); 
        else
            JOptionPane.showMessageDialog(this, Messages.strElementNotSelected, "EGA", 1);
    }//GEN-LAST:event_btnAyudaParadaActionPerformed

    private void btnEditarCargaDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarCargaDatosActionPerformed
        if (this.cmbDatos.getItemCount() > 0  && this.cmbDatos.getSelectedIndex() >= 0)
            this.frmParent.AbrirVentana("frmEditor", this._intID, getSelectedMethodInCombo(this.cmbDatos), false); 
        else
            JOptionPane.showMessageDialog(this, Messages.strElementNotSelected, "EGA", 1);
    }//GEN-LAST:event_btnEditarCargaDatosActionPerformed

    private void btnGraficaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGraficaActionPerformed
        EGA.ControlGlobal.Grafica  = new Grafica();
        EGA.ControlGlobal.Grafica.Titulo = "G r á f i c a   d e   C o n v e r g e n c i a";
        EGA.ControlGlobal.Grafica.NombreEjeX = "C i c l o s";
        EGA.ControlGlobal.Grafica.NombreEjeY = "A p t i t u d";

        EGA.ControlGlobal.Grafica.MostrarPunto(50, 80, 90);
        EGA.ControlGlobal.Grafica.MostrarPunto(30, 100, 120);
        EGA.ControlGlobal.Grafica.MostrarPunto(40, 160, 400);
        EGA.ControlGlobal.Grafica.MostrarPunto(470,500, 510);
        EGA.ControlGlobal.Grafica.MostrarPunto(100, 160, 270);
        EGA.ControlGlobal.Grafica.MostrarPunto(300, 460, 600);
        EGA.ControlGlobal.Grafica.MostrarPunto(300, 400, 500);
        EGA.ControlGlobal.Grafica.MostrarPunto(310, 400, 520);
        EGA.ControlGlobal.Grafica.MostrarPunto(250, 330, 550);
        EGA.ControlGlobal.Grafica.MostrarPunto(330, 470, 590);
        
        EGA.ControlGlobal.frmMDI.AbrirVentana("frmGrafica");

    }//GEN-LAST:event_btnGraficaActionPerformed

    private void btnLimpiarGeneralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarGeneralActionPerformed
        // TODO add your handling code here: 
       this.txtDescripcionSolucion.setText("");
        this.txtObservacionSolucion.setText("");
    }//GEN-LAST:event_btnLimpiarGeneralActionPerformed

    private void btnEditarCromosomaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarCromosomaActionPerformed
        if (this.cmbCromosoma.getItemCount() > 0 && this.cmbCromosoma.getSelectedIndex() >= 0)
            this.frmParent.AbrirVentana("frmEditor", this._intID, getSelectedMethodInCombo(this.cmbCromosoma), false); 
    }//GEN-LAST:event_btnEditarCromosomaActionPerformed

    private void btnEditarAptitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarAptitudActionPerformed
        if (this.cmbAptitud.getItemCount() > 0  && this.cmbAptitud.getSelectedIndex() >= 0)
            this.frmParent.AbrirVentana("frmEditor", this._intID, getSelectedMethodInCombo(this.cmbAptitud), false); 
    }//GEN-LAST:event_btnEditarAptitudActionPerformed

    private void btnEditarSeleccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarSeleccionActionPerformed
        if (this.cmbSeleccion.getItemCount() > 0  && this.cmbSeleccion.getSelectedIndex() >= 0)
            this.frmParent.AbrirVentana("frmEditor", this._intID, getSelectedMethodInCombo(this.cmbSeleccion), false); 
    }//GEN-LAST:event_btnEditarSeleccionActionPerformed

    private void btnEditarCruzamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarCruzamientoActionPerformed
        if (this.cmbCruzamiento.getItemCount() > 0  && this.cmbCruzamiento.getSelectedIndex() >= 0)
            this.frmParent.AbrirVentana("frmEditor", this._intID, getSelectedMethodInCombo(this.cmbCruzamiento), false); 
    }//GEN-LAST:event_btnEditarCruzamientoActionPerformed

    private void btnEditarParadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarParadaActionPerformed
        if (this.cmbParada.getItemCount() > 0  && this.cmbParada.getSelectedIndex() >= 0)
            this.frmParent.AbrirVentana("frmEditor", this._intID, getSelectedMethodInCombo(this.cmbParada), false); 
    }//GEN-LAST:event_btnEditarParadaActionPerformed

	private void txtAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAutorActionPerformed
        // TODO add your handling code here:
	}//GEN-LAST:event_txtAutorActionPerformed

    public void StartExecution(){
        this._blnExecuting = true;
        this._blnPaused = false;
    }
    
    public void StopExecution(){
        this._blnExecuting = false;
        this._blnPaused = false;
    }
    
    public void PauseExcution(){
        this._blnExecuting = false;
        this._blnPaused = true;
    }
    
    public boolean isInStatus(String strStatus){
        switch(strStatus.toUpperCase()){
            case "EXECUTING":
                return this._blnExecuting == true && this._blnPaused == false;
            case "STOPPED":
                return this._blnExecuting == false && this._blnPaused == false;
            case "PAUSED":
                return this._blnExecuting == false && this._blnPaused == true;
        }
        return false;
    }
  
        
    private void btnTriggerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTriggerActionPerformed
        if (this.isInStatus("EXECUTING")){
            this.PauseExcution();
            this.btnTrigger.setText("Reanudar");
        }else if (this.isInStatus("PAUSED")){
            this.StartExecution();
            this.btnTrigger.setText("Pausar");
            //this.btnTrigger.setText("Comenzar");
        }else if (this.isInStatus("STOPPED")){
            this.StartExecution();
            this.btnTrigger.setText("Pausar");
            this.createSolutionObjectToEvaluate();
            this.solucionActual= new Solucion();
            this.solucionActual.armate(this.solutionToUse);
            this.procesadorActual= new Procesador();
            this.procesadorActual.ejecutar(this.solucionActual);
            /*if (this.solutionToUse.CanExecute()){
                
            }*/
        }
    }//GEN-LAST:event_btnTriggerActionPerformed

    private void createSolutionObjectToEvaluate(){
        if (!functions.isInteger(txtPoblacionInicial.getText())){
            JOptionPane.showMessageDialog(this, Messages.strPopulationNotANumber, "EGA", 1);
            return;
        }
        
        this.solutionToUse = new Solution();
        ArrayList<Method> arrLocalMethods = new ArrayList<>();
        for (comboBox cmbCombo : this.jComboBoxes){
            int indexSelected = cmbCombo.combo.getSelectedIndex();
            for (MethodInCombo cmbMethod : this.arrMethodsInCombo){
                if (cmbMethod.combo == cmbCombo.combo && indexSelected == cmbMethod.position){
                    cmbMethod.method.clearParams();
                    
                    int _totalParams = cmbCombo.table.getRowCount();
                    ArrayList<Param> arrParam = new ArrayList<Param>();
                    for (int a = 0; a < _totalParams; a++){
                        Object qSeraesto1 = cmbCombo.table.getValueAt(a, 0);
                        Object qSeraesto2 = cmbCombo.table.getValueAt(a, 1);
                        if(qSeraesto1!=null && qSeraesto2!=null){
                        Param _param = new Param(qSeraesto1.toString(), qSeraesto2.toString(), "String");
                        arrParam.add(_param);
                        }
                    }
                    cmbMethod.method.setParams(arrParam);
                    cmbMethod.method.SetTypeFromFirstLetter(cmbCombo.strFirstLetter);
                    arrLocalMethods.add(cmbMethod.method);
                    
                }
            }    
        }
        this.solutionToUse.setArrMethods(arrLocalMethods);
        this.solutionToUse.setIntSize(Integer.parseInt(txtPoblacionInicial.getText()));
        this.solutionToUse.setIntIncreasingStyle(this.cmbCrecimientoPoblacion.getSelectedIndex());
    }
    
    private void btnEditarMutacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarMutacionActionPerformed
        if (this.cmbMutacion.getItemCount() > 0  && this.cmbMutacion.getSelectedIndex() >= 0)
            this.frmParent.AbrirVentana("frmEditor", this._intID, getSelectedMethodInCombo(this.cmbMutacion), false); 
    }//GEN-LAST:event_btnEditarMutacionActionPerformed

    private void btnNuevoCargaDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoCargaDatosActionPerformed
        // TODO add your handling code here:
        this.frmParent.AbrirVentana("frmEditor", this._intID, new Method("H"), false);
    }//GEN-LAST:event_btnNuevoCargaDatosActionPerformed

    private void btnNuevoCromosomaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoCromosomaActionPerformed
        // TODO add your handling code here:
        this.frmParent.AbrirVentana("frmEditor", this._intID, new Method("C"), false);
    }//GEN-LAST:event_btnNuevoCromosomaActionPerformed

    private void btnNuevoMutacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoMutacionActionPerformed
        // TODO add your handling code here:
        this.frmParent.AbrirVentana("frmEditor", this._intID, new Method("M"), false);
    }//GEN-LAST:event_btnNuevoMutacionActionPerformed

    private void btnNuevoAptitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoAptitudActionPerformed
        // TODO add your handling code here:
        this.frmParent.AbrirVentana("frmEditor", this._intID, new Method("A"), false);
    }//GEN-LAST:event_btnNuevoAptitudActionPerformed

    private void btnNuevoSeleccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoSeleccionActionPerformed
        // TODO add your handling code here:
        this.frmParent.AbrirVentana("frmEditor", this._intID, new Method("S"), false);
    }//GEN-LAST:event_btnNuevoSeleccionActionPerformed

    private void btnNuevoCruzamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoCruzamientoActionPerformed
        // TODO add your handling code here:
        this.frmParent.AbrirVentana("frmEditor", this._intID, new Method("X"), false);
    }//GEN-LAST:event_btnNuevoCruzamientoActionPerformed

    private void btnNuevoParadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoParadaActionPerformed
        // TODO add your handling code here:
        this.frmParent.AbrirVentana("frmEditor", this._intID, new Method("O"), false);
    }//GEN-LAST:event_btnNuevoParadaActionPerformed

    private void btnGuardarConfiguracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarConfiguracionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarConfiguracionActionPerformed
	
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnArchivoSolucion;
    private javax.swing.JButton btnAyudaAptitud;
    private javax.swing.JButton btnAyudaCargaDatos;
    private javax.swing.JButton btnAyudaCromosoma;
    private javax.swing.JButton btnAyudaCruzamiento;
    private javax.swing.JButton btnAyudaMutacion;
    private javax.swing.JButton btnAyudaParada;
    private javax.swing.JButton btnAyudaSeleccion;
    private javax.swing.JButton btnCarpetaPublica;
    private javax.swing.JButton btnEditarAptitud;
    private javax.swing.JButton btnEditarCargaDatos;
    private javax.swing.JButton btnEditarCromosoma;
    private javax.swing.JButton btnEditarCruzamiento;
    private javax.swing.JButton btnEditarInforme;
    private javax.swing.JButton btnEditarMetodoResultados;
    private javax.swing.JButton btnEditarMutacion;
    private javax.swing.JButton btnEditarParada;
    private javax.swing.JButton btnEditarSeleccion;
    private javax.swing.JButton btnExportarConfiguracion;
    private javax.swing.JButton btnExportarGeneral;
    private javax.swing.JButton btnExportarResultados;
    private javax.swing.JButton btnGrafica;
    private javax.swing.JButton btnGuardarConfiguracion;
    private javax.swing.JButton btnGuardarGeneral;
    private javax.swing.JButton btnGuardarResultados;
    private javax.swing.JButton btnInforme;
    private javax.swing.JButton btnLimpiarConfiguracion;
    private javax.swing.JButton btnLimpiarGeneral;
    private javax.swing.JButton btnNuevoAptitud;
    private javax.swing.JButton btnNuevoCargaDatos;
    private javax.swing.JButton btnNuevoCromosoma;
    private javax.swing.JButton btnNuevoCruzamiento;
    private javax.swing.JButton btnNuevoMutacion;
    private javax.swing.JButton btnNuevoParada;
    private javax.swing.JButton btnNuevoSeleccion;
    private javax.swing.JButton btnPublicarConfiguracion;
    private javax.swing.JButton btnPublicarGeneral;
    private javax.swing.JButton btnPublicarResultados;
    private javax.swing.JButton btnRefrescar;
    private javax.swing.JButton btnReparametrizar;
    private javax.swing.JButton btnSalirConfiguracion;
    private javax.swing.JButton btnSalirGeneral;
    private javax.swing.JButton btnSalirResultados;
    private javax.swing.JToggleButton btnTrigger;
    private javax.swing.JButton btnUbicacionArchivoSolucion;
    private javax.swing.JCheckBox chkSoloLectura;
    private javax.swing.JComboBox cmbAptitud;
    private javax.swing.JComboBox cmbCrecimientoPoblacion;
    private javax.swing.JComboBox cmbCromosoma;
    private javax.swing.JComboBox cmbCruzamiento;
    private javax.swing.JComboBox cmbDatos;
    private javax.swing.JComboBox cmbMutacion;
    private javax.swing.JComboBox cmbParada;
    private javax.swing.JComboBox cmbSeleccion;
    private javax.swing.JButton jButton4;
    private javax.swing.JEditorPane jEditorPane6;
    private javax.swing.JEditorPane jEditorPane8;
    private javax.swing.JFileChooser jFCSave;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JScrollPane jspResources;
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
    private javax.swing.JLabel lblPoblacionInicial;
    private javax.swing.JLabel lblUbicacionArchivoSolucion;
    private javax.swing.JList lstArchivos;
    private javax.swing.JPanel panAptitud;
    private javax.swing.JPanel panConfiguracion;
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
    private javax.swing.JTable tblGanadores;
    private javax.swing.JTable tblMutacion;
    private javax.swing.JTable tblParada;
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
    private javax.swing.JTextField txtHoraInicio;
    private javax.swing.JTextField txtMutaciones;
    private javax.swing.JTextField txtNombreObligatorio;
    private javax.swing.JEditorPane txtObservacionSolucion;
    private javax.swing.JTextField txtPoblacionActual;
    private javax.swing.JTextField txtPoblacionInicial;
    private javax.swing.JTextField txtUbicacionArchivoSolucion;
    // End of variables declaration//GEN-END:variables
}
