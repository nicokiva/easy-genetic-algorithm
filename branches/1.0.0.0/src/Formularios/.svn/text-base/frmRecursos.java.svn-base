/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;
import Listeners.InternalFrameCloseListener;
import Methods.*;
import Renderer.*;
import Solutions.Solution;
import configuration.*;
import enums.OperatorType;
import helpers.*;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Triton
 */
public class frmRecursos extends javax.swing.JInternalFrame {
    private int intLoading = 1;
    private MethodsType _mtMethodsType = new MethodsType();
    private boolean deleted = false;
    private boolean modified = false;
    private Integer _intID;
    private ArrayList<javax.swing.JInternalFrame> _arrMySon = new ArrayList<javax.swing.JInternalFrame>();
    private String[] _strMethodHeader = {"ID", "TIPO", "NOMBRE", "DESCRIPCION", "RUTA", "CREADO", "MODIFICADO", "AUTOR", "ARCHIVO ENCONTRADO"};
    private String[] _strSolutionHeader = {"NOMBRE", "RUTA", "CREADO", "MODIFICADO", "AUTOR", "ARCHIVO ENCONTRADO"};
    
    public int OperatorTypeModifying = OperatorType.Solution;

    
    MDI frmParent;
    ArrayList<Method> arrMethods = new ArrayList<Method>();
    ArrayList<Method> arrMethNotSaved = new ArrayList<Method>();
    
    ArrayList<Solution> arrSolutions = new ArrayList<Solution>();
    
    Paths paths = new Paths();
    file_handler fh = new file_handler();
    Object[][] _objMethods;

    public frmRecursos() {
        this.startLoading();
        initComponents();
        this.FillResourcesTable();
        if (this.OperatorTypeModifying == OperatorType.Solution){
            this.enableOrDisableElements(false);
        }else{
            this.tblResources.setDefaultRenderer(Object.class, new ResourcesOperatorTableRenderer());
        }
        
        this.finishLoading();
        this.ajustarTabla();
        InternalFrameCloseListener closeListener = new InternalFrameCloseListener();
        this.addInternalFrameListener (closeListener.getInternalFrameCloseListener());
        
    }

    public frmRecursos(MDI frmParent, Integer intSolutionID, int intType) {
        this.startLoading();
        initComponents();
        this._intID = intSolutionID;
        this.frmParent = frmParent;
        this.OperatorTypeModifying = intType;
        
        if (this.OperatorTypeModifying == OperatorType.Solution){
            this.enableOrDisableElements(false);
            this.tblResources.setDefaultRenderer(Object.class, new ResourcesSolutionTableRenderer());
        }else{
            this.tblResources.setDefaultRenderer(Object.class, new ResourcesOperatorTableRenderer());
        }
        
        
        this.FillResourcesTable();
        this.finishLoading();
        this.ajustarTabla();
        InternalFrameCloseListener closeListener = new InternalFrameCloseListener();
        this.addInternalFrameListener (closeListener.getInternalFrameCloseListener());
        
    }
    
    private void enableOrDisableElements(boolean blnValue){
        //this.btnOpenResource.setEnabled(blnValue);
        this.btnSaveChanges.setEnabled(blnValue);
    }
    
    private void startLoading(){
        this.intLoading = 1;
    }
    
    private void finishLoading(){
        this.intLoading = 0;
    }
    
    public void ReloadResourcesTable(){
        this.FillResourcesTable();
    }
    
    private void FillResourcesTable(){      
        this.toFront();
        if (this.intLoading == 1 || JOptionPane.showConfirmDialog(this, Messages.strChangesToUpdateButNotSaved, "EGA", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            tblResources.removeAll();
            
            this.setResourcesInTable();
        }
    }
    
    private void loadSolutions(){
        ArrayList<Object[]> objSolutions = new ArrayList<>();
        ArrayList<Solution> SolutionsInDB = Solution.GetSolutionsInDB();

        for (Solution solution : SolutionsInDB){
            this.arrSolutions.add(solution);
            String Path = solution.getStrFolder() + "\\" + solution.getStrFile();
            Object[] objMethod = {solution.getStrName(), Path, solution.getStrCreated(), solution.getStrModified(), solution.getStrAuthor(), this.fh.FileFound(Path)};
            objSolutions.add(objMethod);   
        }
        
        this.completeGrid(objSolutions, this._strSolutionHeader);
    }
    
    private void loadMethods(){
        this.arrMethods.clear();
        ArrayList<Object[]> objMethods = new ArrayList<>();
        for (String[] strMethodType : this._mtMethodsType.arrMethodsType){
            ArrayList<Method> MethodsInDB = Method.GetMethodsInDB(strMethodType[1], strMethodType[3]);

            for (Method met : MethodsInDB){
                this.arrMethods.add(met);

                Object[] objMethod = {met.getIndex(), met.getType(), met.getName(), met.getDescription(), met.getPath(), met.getCreated(), met.getModified(), met.getAuthor(), this.fh.FileFound(met.getPath())};
                objMethods.add(objMethod);   
            }
        }

        this.completeGrid(objMethods, this._strMethodHeader);
    }
    
    private void completeGrid(ArrayList<Object[]> objMethods, String[] strHeader){
        int intTotalMethods = objMethods.size();
        this._objMethods = new Object[intTotalMethods][7];

        for (int intCounter = 0; intCounter < intTotalMethods; intCounter++){
            this._objMethods[intCounter] = objMethods.get(intCounter);
        }
        
        tblResources.setModel(new javax.swing.table.DefaultTableModel(this._objMethods, strHeader));
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jspResources = new javax.swing.JScrollPane();
        tblResources = new javax.swing.JTable();
        btnOpenResource = new javax.swing.JButton();
        btnSaveChanges = new javax.swing.JButton();
        btnDeleteResource = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setIconifiable(true);
        setTitle("EGA - Base de Recursos                                                                                                                                                                                                                                                       ");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/system/res/ICON.png"))); // NOI18N
        setMinimumSize(new java.awt.Dimension(107, 40));
        setNextFocusableComponent(tblResources);
        setPreferredSize(new java.awt.Dimension(976, 538));
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
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblResources.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tblResources.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "SELECCION", "Ranking", "Elige los N mayores.", "", "12/07/2012", "13/08/2012", "Pyte", null},
                {"2", "APTITUD", "Eventos", "Para eventos.", "", "15/09/2012", "15/09/2012", null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "CODIGO", "TIPO", "NOMBRE", "DESCRIPCION", "RUTA", "CREADO", "MODIFICADO", "AUTOR", "EXISTE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true, false, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblResources.setNextFocusableComponent(btnOpenResource);
        tblResources.getTableHeader().setReorderingAllowed(false);
        tblResources.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblResourcesKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblResourcesKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tblResourcesKeyTyped(evt);
            }
        });
        jspResources.setViewportView(tblResources);
        tblResources.getColumnModel().getColumn(0).setPreferredWidth(20);

        getContentPane().add(jspResources, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 947, 448));

        btnOpenResource.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnOpenResource.setText("Abrir Recurso");
        btnOpenResource.setNextFocusableComponent(btnSaveChanges);
        btnOpenResource.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenResourceActionPerformed(evt);
            }
        });
        getContentPane().add(btnOpenResource, new org.netbeans.lib.awtextra.AbsoluteConstraints(146, 470, 150, -1));

        btnSaveChanges.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnSaveChanges.setText("Guardar Cambios");
        btnSaveChanges.setNextFocusableComponent(btnDeleteResource);
        btnSaveChanges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveChangesActionPerformed(evt);
            }
        });
        getContentPane().add(btnSaveChanges, new org.netbeans.lib.awtextra.AbsoluteConstraints(314, 470, 150, -1));

        btnDeleteResource.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnDeleteResource.setText("Eliminar Recurso");
        btnDeleteResource.setNextFocusableComponent(btnExit);
        btnDeleteResource.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteResourceActionPerformed(evt);
            }
        });
        getContentPane().add(btnDeleteResource, new org.netbeans.lib.awtextra.AbsoluteConstraints(482, 470, 150, -1));

        btnExit.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnExit.setText("Salir");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        getContentPane().add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 470, 150, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private javax.swing.JInternalFrame getWindowsEditing(Method met){
        return frmParent.GetWindowsEditing(met);
    }
    
    private javax.swing.JInternalFrame getWindowsEditing(Solution sol){
        return frmParent.GetWindowsEditing(sol);
    }
    
    private void setWindowsToFront(javax.swing.JInternalFrame frm){
        frmParent.setWindowsToFront(frm);
    }
    
    public boolean isEditing(Method met){
        int intSons = this._arrMySon.size();
        
        for (int a = 0; a < intSons; a++){
            javax.swing.JInternalFrame frm = this._arrMySon.get(a);
            if (frm.getClass().toString().split("class Formularios.")[1].equals(forms.Editor)){
                if (((frmEditor)frm).isEditing(met)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private void btnDeleteResourceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteResourceActionPerformed
        // TODO add your handling code here:
        if (this.tblResources.getSelectedRow() < 0){
            JOptionPane.showMessageDialog(this, Messages.strElementNotSelected, "EGA", 1);
            return;
        }
        
        if (this.OperatorTypeModifying == OperatorType.Method)
            this.deleteMethod();
        else if (this.OperatorTypeModifying == OperatorType.Solution)
            this.deleteSolution();
        
    }//GEN-LAST:event_btnDeleteResourceActionPerformed

    private void deleteSolution(){
        Solution sol = this.getSelectedSolution();
        
        javax.swing.JInternalFrame frm = this.getWindowsEditing(sol);
        if (frm != null){
            JOptionPane.showMessageDialog(this, Messages.strCantDeleteForBeingUsed, "EGA", 1);
            return;
        }
        
        String strMessage = (Messages.strConfirmDelete.replace("__MET__", sol.getStrName())).replace("__CAT__", "Solución");
        
        if (JOptionPane.showConfirmDialog(this, strMessage, "EGA", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            ArrayList<Solution> SolutionsInDB = Solution.GetSolutionsInDB();
            
            int index = 0, indexToRemove = -1;
            for (Solution solution : SolutionsInDB){
                if (solution.getStrFolder().equals(sol.getStrFolder()) && solution.getStrFile().equals(sol.getStrFile())){
                    File _fileToDelete = new File(sol.getStrFolder() + "\\" + sol.getStrFile());
                    _fileToDelete.delete();
                    indexToRemove = index;                    
                }
                index++;
            }

            if (indexToRemove >= 0){
                SolutionsInDB.remove(indexToRemove);
                this.deleted = true;
                
                data_type_converter dtc = new data_type_converter();
                dtc.ToByteString(SolutionsInDB);
                this.fh.setByteText(dtc.getByteText());
                this.fh.setPathFileToWrite(paths.strSolucionDB);
                this.fh.WriteBinary(dtc.getStrText());

                if (this.fh.result.OperationSucceed())
                    JOptionPane.showMessageDialog(this, Messages.strElementDeleted, "EGA", 1);
                else
                    JOptionPane.showMessageDialog(this, Messages.strCantDeleted, "EGA", 1);
            }

            this.setResourcesInTable();
        }
    }
    
    private void deleteMethod(){
        Method met = this.getSelectedMethod();
       
        javax.swing.JInternalFrame frm = this.getWindowsEditing(met);
        if (frm != null){
            JOptionPane.showMessageDialog(this, Messages.strCantDeleteForBeingUsed, "EGA", 1);
            return;
        }
                
        String strMessage = (Messages.strConfirmDelete.replace("__MET__", met.getName())).replace("__CAT__", met.getType());
        if (JOptionPane.showConfirmDialog(this, strMessage, "EGA", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            int index = 0, indexToRemove = -1;
            for (Method _arrMeth : this.arrMethods){
                if (_arrMeth.getFirstLetter().equals(met.getFirstLetter()) && met.getPath().equals(_arrMeth.getPath())){// Integer.parseInt(_arrMeth.getIndex()) ==  Integer.parseInt(met.getIndex())){
                    File _fileToDelete = new File(met.getPath());
                    _fileToDelete.delete();
                    indexToRemove = index;
                }
                index++;
            }

            if (indexToRemove >= 0){
                this.arrMethods.remove(indexToRemove);
                this.deleted = true;
                if (this.storeInDB()) {
                    JOptionPane.showMessageDialog(this, Messages.strElementDeleted, "EGA", 1);
                }
            }

            this.setResourcesInTable();
        }
    }
    
    private void setResourcesInTable(){
        if (this.OperatorTypeModifying == OperatorType.Method)
            this.loadMethods();
        else if (this.OperatorTypeModifying == OperatorType.Solution)
            this.loadSolutions();
    }
    
    private void btnSaveChangesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveChangesActionPerformed
        // TODO add your handling code here:
        /*
        if (!this.modified){
            JOptionPane.showMessageDialog(this, Messages.strNotChangesDone, "EGA", 1);
            return;
        }
        */
        
        if (!this._arrMySon.isEmpty() && JOptionPane.showConfirmDialog(this, Messages.strIfBeingUsedWillNotBeSaved, "EGA", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION){
            return;
        }

        this.arrMethNotSaved.clear();
        this.save();
        if (this.storeInDB()) {
            JOptionPane.showMessageDialog(this, Messages.strChangesSaved, "EGA", 1);
        }

        if (!this.arrMethNotSaved.isEmpty()){
            String strEmpty = this.listMethodsNotSaved();
            JOptionPane.showMessageDialog(this, Messages.strMethodsNotSaved + strEmpty, "EGA", 1);
        }

        this.modified = false;
    }//GEN-LAST:event_btnSaveChangesActionPerformed

    private String listMethodsNotSaved(){
        String strMethods = "";
        
        for (Method met : this.arrMethNotSaved){
            strMethods += (Messages.strMethodsTemplateDisplay.replace("__MET__", met.getName())).replace("__CAT__", met.getType());
        }
        
        return strMethods;
    }
    
    private void save(){
        this.arrMethods.clear();
            
        int _totalRows = this.tblResources.getRowCount();
        for (int a = 0; a < _totalRows; a++){
            String strIndex = this.tblResources.getValueAt(a, 0) != null ? this.tblResources.getValueAt(a, 0).toString() : "0";
            String strType = this.tblResources.getValueAt(a, 1) != null ? this.tblResources.getValueAt(a, 1).toString() : "SELECCIÓN";
            String strName = this.tblResources.getValueAt(a, 2) != null ? this.tblResources.getValueAt(a, 2).toString() : "";
            String strDescription = this.tblResources.getValueAt(a, 3) != null ? this.tblResources.getValueAt(a, 3).toString() : "";
            String strPath = this.tblResources.getValueAt(a, 4) != null ? this.tblResources.getValueAt(a, 4).toString() : "";
            String dateCreated = this.tblResources.getValueAt(a, 5) != null ? this.tblResources.getValueAt(a, 5).toString() : "";
            String dateModified = this.tblResources.getValueAt(a, 6) != null ? this.tblResources.getValueAt(a, 6).toString() : "";
            String strAuthor = this.tblResources.getValueAt(a, 7) != null ? this.tblResources.getValueAt(a, 7).toString() : "";

            Method _met = new Method(strIndex, strName, strDescription, true, strPath, dateCreated, dateModified, strAuthor);
            _met.setType(strType);
            
            
            javax.swing.JInternalFrame frm = this.getWindowsEditing(_met);
            if (frm == null){
                this.arrMethods.add(_met);
            }else{
                this.arrMethNotSaved.add(_met);
            }
        }
    }
    
    private boolean storeInDB(){
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
        arrMethods.addAll(this.arrMethNotSaved);
        
        for (Method _method : arrMethods){
            switch(_method.getFirstLetter()){
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
    
    private void storeMethods(ArrayList<Method> metSelection, ArrayList<Method> metMutation, ArrayList<Method> metCrossing, ArrayList<Method> metStop, ArrayList<Method> metInform, ArrayList<Method> metAptitudeFunction, ArrayList<Method> metHelper, ArrayList<Method> metChromosome){
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
    
    private void store(ArrayList<Method> met, String strPath, data_type_converter dtc){
        if (!met.isEmpty()){
            dtc.setArrMethods(met);
            dtc.fromMethodToByteString();
            this.fh.setByteText(dtc.getByteText());
            this.fh.setPathFileToWrite(strPath);
            this.fh.WriteBinary(dtc.getStrText());
        }else{
            this.fh.setPathFileToWrite(strPath);
            this.fh.CleanFile();
        }
    }   
    
    private void tblResourcesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblResourcesKeyPressed
        // TODO add your handling code here:
        this.modified = true;
    }//GEN-LAST:event_tblResourcesKeyPressed

    private void tblResourcesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblResourcesKeyReleased
        // TODO add your handling code here:
        this.modified = true;
    }//GEN-LAST:event_tblResourcesKeyReleased

    private Method getSelectedMethod(){
        Integer _intIndex = Integer.parseInt(this.tblResources.getValueAt(this.tblResources.getSelectedRow(), 0).toString());
        String _strType = this.tblResources.getValueAt(this.tblResources.getSelectedRow(), 1).toString();
        String _strName = this.tblResources.getValueAt(this.tblResources.getSelectedRow(), 2).toString();
        String _strDescription = this.tblResources.getValueAt(this.tblResources.getSelectedRow(), 3).toString();
        String _strPath = this.tblResources.getValueAt(this.tblResources.getSelectedRow(), 4).toString();
        String _strCreated = this.tblResources.getValueAt(this.tblResources.getSelectedRow(), 5).toString();
        String _strModified = this.tblResources.getValueAt(this.tblResources.getSelectedRow(), 6).toString();
        String _strAuthor = this.tblResources.getValueAt(this.tblResources.getSelectedRow(), 7).toString();
        
        Method met = new Method(_intIndex.toString(), _strName, _strDescription, false, _strPath, _strCreated, _strModified, _strAuthor);
        met.setType(_strType);
        met.SetFirstLetterFromType();
        return met;
    }
    
    private Solution getSelectedSolution(){
        String _strName = this.tblResources.getValueAt(this.tblResources.getSelectedRow(), 0).toString();
        String _strPath = this.tblResources.getValueAt(this.tblResources.getSelectedRow(), 1).toString();
        String _strFile = _strPath.substring(_strPath.lastIndexOf("\\") + 1);
        _strPath = _strPath.substring(0, _strPath.lastIndexOf("\\"));
        String _strCreated = this.tblResources.getValueAt(this.tblResources.getSelectedRow(), 2).toString();
        String _strModified = this.tblResources.getValueAt(this.tblResources.getSelectedRow(), 3).toString();
        String _strAuthor = this.tblResources.getValueAt(this.tblResources.getSelectedRow(), 4).toString();
        
        return Solution.WithDBFields(_strName, _strPath, _strFile, _strCreated, _strModified, _strAuthor);
    }
    
    private void btnOpenResourceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenResourceActionPerformed
        // TODO add your handling code here:
        if (this.tblResources.getSelectedRow() < 0){
            JOptionPane.showMessageDialog(this, Messages.strElementNotSelected, "EGA", 1);
            return;
        }
        
        if (this.OperatorTypeModifying == OperatorType.Method){
            this.openMethod();
        }else if (this.OperatorTypeModifying == OperatorType.Solution){
            this.openSolution();
        }
    }//GEN-LAST:event_btnOpenResourceActionPerformed

    private void openSolution(){
        String Path = this.tblResources.getValueAt(this.tblResources.getSelectedRow(), 1).toString();
        if (!this.fh.FileFound(Path).equals(file_handler._fileFound)){
            JOptionPane.showMessageDialog(this, Messages.strOpeningSolutionNotFound, "EGA", 1);
            return;
        }
           
        this.frmParent.OpenSpecificSolution(Path, false);
    }
    
    private void openMethod(){
        Method met = this.getSelectedMethod();
        
        javax.swing.JInternalFrame frm = this.getWindowsEditing(met);
        if (frm != null){
            this.setWindowsToFront(frm);
            //JOptionPane.showMessageDialog(this, Messages.strCantModifyForBeingUsed, "EGA", 1);
            return;
        }

        boolean _blnOpenResource = false;
        if (this.fh.FileFound(met.getPath()).equals(file_handler._fileNotFound)){
            if (JOptionPane.showConfirmDialog(this, Messages.strOpeningFileNotFound, "EGA", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                _blnOpenResource = true;
            }
        }else{
            _blnOpenResource = true;
        }

        if (_blnOpenResource){
            javax.swing.JInternalFrame form = this.frmParent.AbrirVentana("frmEditor", this._intID, this.getSelectedMethod(), false);
            ((frmEditor)form).frmOpener = this;
            this._arrMySon.add(form);
        }
    }
    
    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        this.CloseAll();
    }//GEN-LAST:event_btnExitActionPerformed

    private void tblResourcesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblResourcesKeyTyped
        this.modified = true;        // TODO add your handling code here:
    }//GEN-LAST:event_tblResourcesKeyTyped

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        this.CloseAll(); 
    }//GEN-LAST:event_formInternalFrameClosing

    public void CloseSon(frmEditor frm){
        this._arrMySon.remove(frm);
    }
    
    public boolean CloseAll(){
        int intSons = this._arrMySon.size();

        for (int a = 0; a < intSons; a++){
            javax.swing.JInternalFrame frm = this._arrMySon.get(a);
            
            switch (frm.getClass().toString().split("class Formularios.")[1]){
                case forms.Editor:
                    if (((frmEditor)frm).CloseAll()){
                        this._arrMySon.remove(frm);
                        frm = null;
                        a--;
                        intSons--;
                    }
                    break;
            }
        }
        
        if (this._arrMySon.isEmpty() && canCloseMe()){
            this.setVisible(false);
            this.dispose();
            return true;
        }
        
        return false;
    }
    
    private boolean canCloseMe(){
        if (!this.modified) // No modification done
            return true;
        
        int optionSelected = JOptionPane.showConfirmDialog(this, Messages.strClosingWithoutSaving, "EGA", JOptionPane.YES_NO_CANCEL_OPTION);
        switch(optionSelected){
            case JOptionPane.YES_OPTION:
                this.save();
                if (this.storeInDB())
                    JOptionPane.showMessageDialog(this, Messages.strChangesSaved, "EGA", 1);
                return true;
            case JOptionPane.NO_OPTION:
                this.setVisible(false);
                return true;
            case JOptionPane.CANCEL_OPTION:
                return false;
            default:
                return true;
        }
    }
    
    private void ajustarTabla()
    {
        int anchoColumna = 10; 
        TableColumn columnaTabla; 
        TableColumnModel modeloColumna = tblResources.getColumnModel(); 
        
        for (int i = 0; i < tblResources.getColumnCount(); i++) 
        { 
            columnaTabla = modeloColumna.getColumn(i); 
            switch(i)
            { 
                case 0: anchoColumna = 30;  // CODIGO
                        break; 
                case 1: anchoColumna = 130; // TIPO
                        break; 
                case 2: anchoColumna = 150; // NOMBRE
                        break; 
                case 3: anchoColumna = 250; // DESCRIPCION
                        break; 
                case 4: anchoColumna = 130; // RUTA 
                        break; 
                case 5: anchoColumna = 75; // CREADO
                        break; 
                case 6: anchoColumna = 75; // MODIFICADO
                        break; 
                case 7: anchoColumna = 130; // AUTOR
                        break; 
                case 8: anchoColumna = 40; // EXISTE
                        break; 

            }                      
            columnaTabla.setPreferredWidth(anchoColumna);
        }
        
        if (tblResources.getRowCount() > 0)
            tblResources.changeSelection(0, 1, false, false);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeleteResource;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnOpenResource;
    private javax.swing.JButton btnSaveChanges;
    private javax.swing.JScrollPane jspResources;
    private javax.swing.JTable tblResources;
    // End of variables declaration//GEN-END:variables
}
