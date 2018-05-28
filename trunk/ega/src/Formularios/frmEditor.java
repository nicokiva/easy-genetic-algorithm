/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;
import Presentacion.Auxiliares.data_type_converter;
import Presentacion.Auxiliares.functions;
import Presentacion.Auxiliares.file_handler;
import Methods.Method;
import comp.Compilador;
import configuration.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.codehaus.commons.compiler.CompileException;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.SwingConstants;

import Editor.NumberedEditorKit;
import Listeners.InternalFrameCloseListener;
import enums.Acciones;
/**
 *
 * @author Triton
 */
public class frmEditor extends javax.swing.JInternalFrame {
    private Integer _intID;
    private int intLoading = 1;
    private boolean _canSaveAs = true;
    private boolean _blnEdited = false;
    private boolean _blnPublishing = false;
    private Method _metOperator;
    private String _strFilePath;
    private String _strDBPath;
    private ArrayList<javax.swing.JInternalFrame> _arrMySon = new ArrayList<javax.swing.JInternalFrame>();

    javax.swing.JInternalFrame frmOpener;
    MDI frmParent;
    file_handler fh = new file_handler();
    Paths paths = new Paths();
    boolean Locally = true;
    
    /**
     * Creates new form frmEditor
     */
    public frmEditor() {
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
                
        this.startLoading();
        initComponents();
        CodigoUsuario.setContentType("text/html");
        CodigoUsuario.setEditorKit(new NumberedEditorKit());   
        CodigoUsuario.setCaretPosition(0);
        this.finishLoading();
        InternalFrameCloseListener closeListener = new InternalFrameCloseListener();
        this.addInternalFrameListener (closeListener.getInternalFrameCloseListener());
        
    }
    
    public frmEditor(MDI frmParent, int intID, Method metSelectedMethod, boolean blnCanSaveAs) {
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();

        this.startLoading();
        initComponents();
        CodigoUsuario.setContentType("text/html");
        CodigoUsuario.setEditorKit(new NumberedEditorKit());   
        this.setInitialConfiguration(frmParent, intID, metSelectedMethod, blnCanSaveAs);
        CodigoUsuario.setCaretPosition(0);
        this.finishLoading();
        InternalFrameCloseListener closeListener = new InternalFrameCloseListener();
        this.addInternalFrameListener (closeListener.getInternalFrameCloseListener());
        
        //tcr.setHorizontalAlignment(SwingConstants.RIGHT);
        //tblLinea.getColumnModel().getColumn(0).setCellRenderer(tcr);
    } 
    
    public boolean IsFromFamily(Integer intID){
        return intID == this._intID;
    }
    
    private void setInitialConfiguration(MDI frmParent, int intID, Method metSelectedMethod, boolean blnCanSaveAs){
        this._intID = intID;
        this._metOperator = metSelectedMethod;
        this._canSaveAs = blnCanSaveAs; // if FALSE => editing

        this.frmParent = frmParent;
        this.panEditor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, metSelectedMethod.getType().toUpperCase(), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 12)));
        this.txtNombre.setText(metSelectedMethod.getName());
        this.txtAutor.setText(metSelectedMethod.getAuthor());
        this.txtFechaCreacion.setText(functions.getDate(metSelectedMethod.getCreated()));
        this.txtFechaModificacion.setText(functions.getDate());
        this.pnlDescripcion.setText(metSelectedMethod.getDescription());

        this.setInitialPaths(metSelectedMethod);
        
        this.showMethodToEdit();
    }
    
    private void madeChanges(){
        this._blnEdited = true;
    }
        
    private void setInitialPaths(Method metSelectedMethod){
        switch(metSelectedMethod.getFirstLetter()){
            case "C":
                this._strFilePath = paths.strCromosomaMetodos;
                this._strDBPath = paths.strCromosomaDB;
                break;
            case "S":
                this._strFilePath = paths.strSeleccionMetodos;
                this._strDBPath = paths.strSeleccionDB;
                break;
            case "M":
                this._strFilePath = paths.strMutacionMetodos;
                this._strDBPath = paths.strMutacionDB;
                break;    
            case "X":
                this._strFilePath = paths.strCruzamientoMetodos;
                this._strDBPath = paths.strCruzamientoDB;
                break;
            case "O":
                this._strFilePath = paths.strParoMetodos;
                this._strDBPath = paths.strParoDB;
                break;
            case "I":
                this._strFilePath = paths.strInformeMetodos;
                this._strDBPath = paths.strInformeDB;
                break;
            case "H":
                this._strFilePath = paths.strAyudanteMetodos;
                this._strDBPath = paths.strAyudanteDB;
                break;
            case "A":
                this._strFilePath = paths.strAptitudMetodos;
                this._strDBPath = paths.strAptitudDB;
                break;
        }
    }
    
    private void showMethodToEdit(){
                
        if (this._metOperator.getPath() != null){
            fh.setPathFileToRead(this._metOperator.getPath());
            if (fh.Read())
                this.CodigoUsuario.setText(fh.getText());
        }
    }
    
    private void startLoading(){
        this.intLoading = 1;
    }
    
    private void finishLoading(){
        this.intLoading = 0;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fcSave = new javax.swing.JFileChooser();
        btnSave = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        CodigoUsuario = new javax.swing.JEditorPane();
        btnTestSyntax = new javax.swing.JButton();
        btnPublish = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtResultado = new javax.swing.JTextArea();
        btnAdjuntarArchivo = new javax.swing.JButton();
        panEditor = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblAutor = new javax.swing.JLabel();
        txtAutor = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        pnlDescripcion = new javax.swing.JTextPane();
        txtFechaCreacion = new javax.swing.JFormattedTextField();
        lblFechaCreacion = new javax.swing.JLabel();
        txtFechaModificacion = new javax.swing.JFormattedTextField();
        lblFechaModificacion = new javax.swing.JLabel();

        fcSave.setCurrentDirectory(new java.io.File("C:\\"));

            setClosable(true);
            setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
            setIconifiable(true);
            setTitle("EGA - Editor de Funciones                                                                                                                                                                                                                                                                       ");
            setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/system/res/ICON.png"))); // NOI18N
            setNextFocusableComponent(txtNombre);
            setPreferredSize(new java.awt.Dimension(1010, 680));
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

            btnSave.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
            btnSave.setText("Grabar");
            btnSave.setNextFocusableComponent(btnPublish);
            btnSave.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnSaveActionPerformed(evt);
                }
            });
            getContentPane().add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 616, 177, -1));

            CodigoUsuario.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
            CodigoUsuario.setToolTipText("");
            CodigoUsuario.setAutoscrolls(false);
            CodigoUsuario.setMargin(new java.awt.Insets(3, 18, 3, 3));
            CodigoUsuario.setNextFocusableComponent(btnTestSyntax);
            CodigoUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyPressed(java.awt.event.KeyEvent evt) {
                    CodigoUsuarioKeyPressed(evt);
                }
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    CodigoUsuarioKeyReleased(evt);
                }
                public void keyTyped(java.awt.event.KeyEvent evt) {
                    CodigoUsuarioKeyTyped(evt);
                }
            });
            jScrollPane1.setViewportView(CodigoUsuario);

            getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 978, 452));

            btnTestSyntax.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
            btnTestSyntax.setText("Probar Sintáxis");
            btnTestSyntax.setNextFocusableComponent(btnSave);
            btnTestSyntax.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnTestSyntaxActionPerformed(evt);
                }
            });
            getContentPane().add(btnTestSyntax, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 616, 176, -1));

            btnPublish.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
            btnPublish.setText("Publicar");
            btnPublish.setNextFocusableComponent(btnAdjuntarArchivo);
            btnPublish.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnPublishActionPerformed(evt);
                }
            });
            getContentPane().add(btnPublish, new org.netbeans.lib.awtextra.AbsoluteConstraints(407, 616, 176, -1));

            btnSalir.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
            btnSalir.setText("Salir");
            btnSalir.setNextFocusableComponent(txtNombre);
            btnSalir.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnSalirActionPerformed(evt);
                }
            });
            getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(814, 616, 176, -1));

            txtResultado.setEditable(false);
            txtResultado.setColumns(20);
            txtResultado.setRows(5);
            txtResultado.setText(" RESULTADO COMPILACION:");
            txtResultado.setPreferredSize(new java.awt.Dimension(188, 100));
            jScrollPane2.setViewportView(txtResultado);

            getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 566, 978, 44));

            btnAdjuntarArchivo.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
            btnAdjuntarArchivo.setText("Importar Código");
            btnAdjuntarArchivo.setNextFocusableComponent(btnSalir);
            btnAdjuntarArchivo.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnAdjuntarArchivoActionPerformed(evt);
                }
            });
            getContentPane().add(btnAdjuntarArchivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(612, 616, 178, -1));
            btnAdjuntarArchivo.getAccessibleContext().setAccessibleDescription("");

            panEditor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Función de APTITUD", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 12))); // NOI18N
            panEditor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            lblNombre.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
            lblNombre.setText("Nombre:");
            panEditor.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 34, 50, -1));

            txtNombre.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
            txtNombre.setText("Aptitud para Eventos");
            txtNombre.setFocusTraversalPolicyProvider(true);
            txtNombre.setNextFocusableComponent(txtAutor);
            txtNombre.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    txtNombreActionPerformed(evt);
                }
            });
            txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyPressed(java.awt.event.KeyEvent evt) {
                    txtNombreKeyPressed(evt);
                }
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    txtNombreKeyReleased(evt);
                }
                public void keyTyped(java.awt.event.KeyEvent evt) {
                    txtNombreKeyTyped(evt);
                }
            });
            panEditor.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 30, 148, 22));

            lblAutor.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
            lblAutor.setText("Autor:");
            panEditor.add(lblAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 62, 34, -1));

            txtAutor.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
            txtAutor.setText("Pablo Pytel");
            txtAutor.setNextFocusableComponent(pnlDescripcion);
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
            panEditor.add(txtAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 60, 148, 22));

            pnlDescripcion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
            pnlDescripcion.setText("Ingrese aquí una Descripción...");
            pnlDescripcion.setMargin(new java.awt.Insets(5, 5, 5, 5));
            pnlDescripcion.setNextFocusableComponent(CodigoUsuario);
            pnlDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyPressed(java.awt.event.KeyEvent evt) {
                    pnlDescripcionKeyPressed(evt);
                }
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    pnlDescripcionKeyReleased(evt);
                }
                public void keyTyped(java.awt.event.KeyEvent evt) {
                    pnlDescripcionKeyTyped(evt);
                }
            });
            jScrollPane3.setViewportView(pnlDescripcion);

            panEditor.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(414, 16, 558, 72));

            txtFechaCreacion.setEditable(false);
            txtFechaCreacion.setBackground(new java.awt.Color(255, 255, 255));
            txtFechaCreacion.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
            txtFechaCreacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
            txtFechaCreacion.setToolTipText("");
            txtFechaCreacion.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
            txtFechaCreacion.setEnabled(false);
            txtFechaCreacion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
            txtFechaCreacion.setMargin(new java.awt.Insets(2, 10, 2, 2));
            txtFechaCreacion.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyPressed(java.awt.event.KeyEvent evt) {
                    txtFechaCreacionKeyPressed(evt);
                }
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    txtFechaCreacionKeyReleased(evt);
                }
                public void keyTyped(java.awt.event.KeyEvent evt) {
                    txtFechaCreacionKeyTyped(evt);
                }
            });
            panEditor.add(txtFechaCreacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(302, 30, 95, -1));

            lblFechaCreacion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
            lblFechaCreacion.setText("Creado:");
            panEditor.add(lblFechaCreacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(236, 34, 46, -1));

            txtFechaModificacion.setEditable(false);
            txtFechaModificacion.setBackground(new java.awt.Color(255, 255, 255));
            txtFechaModificacion.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
            txtFechaModificacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
            txtFechaModificacion.setToolTipText("");
            txtFechaModificacion.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
            txtFechaModificacion.setEnabled(false);
            txtFechaModificacion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
            txtFechaModificacion.setMargin(new java.awt.Insets(2, 10, 2, 2));
            txtFechaModificacion.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyPressed(java.awt.event.KeyEvent evt) {
                    txtFechaModificacionKeyPressed(evt);
                }
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    txtFechaModificacionKeyReleased(evt);
                }
                public void keyTyped(java.awt.event.KeyEvent evt) {
                    txtFechaModificacionKeyTyped(evt);
                }
            });
            panEditor.add(txtFechaModificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(302, 60, 95, -1));

            lblFechaModificacion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
            lblFechaModificacion.setText("Modificado:");
            panEditor.add(lblFechaModificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(236, 62, 68, -1));

            getContentPane().add(panEditor, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 6, 984, 98));

            pack();
        }// </editor-fold>//GEN-END:initComponents

    
    
    private void btnPublishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPublishActionPerformed
        // TODO add your handling code here:
        Method methodEditing = this.createEditingMethod();
        
        if (!methodEditing.CompletedMinimumFieldsTo(Acciones.Publicar)){
            JOptionPane.showMessageDialog(this, Messages.strMethodNotPosibleToPublish, "EGA", 1);
            return;
        }   
        
        this._blnPublishing = true;
        this.Locally = false;
        this.Save(paths.strMain);
        this._blnPublishing = false;
        this.CloseMe();
    }//GEN-LAST:event_btnPublishActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        this.CloseMe();
    }//GEN-LAST:event_btnSalirActionPerformed

    public void CloseMe(){
        boolean canExit = false;
        if (!this._blnEdited){ // No modification done
            canExit = true;
        }else{
            int optionSelected = JOptionPane.showConfirmDialog(this, Messages.strClosingWithoutSaving, "EGA", JOptionPane.YES_NO_CANCEL_OPTION);
            switch(optionSelected){
                case JOptionPane.YES_OPTION:
                    this.save();
                case JOptionPane.NO_OPTION:
                    canExit = true;
                    break;
                case JOptionPane.CANCEL_OPTION:
                    canExit = false;
                    break;
            }
        }
        
        if (canExit){
            if (this.frmOpener != null){
                switch (this.frmOpener.getClass().toString().split("class Formularios.")[1]){
                    case forms.Recursos:
                        ((frmRecursos)this.frmOpener).CloseSon(this);
                        break;
                    case forms.Solucion:
                        break;
                }
            }

            this.setVisible(false);
            this.dispose();
        }
    }
    
    private void btnTestSyntaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTestSyntaxActionPerformed
        
        try {
           
            Compilador.pruebaCompilacion(CodigoUsuario.getText());
            txtResultado.setText(Messages.strCompileSuccessful);
        } catch (IOException ex) {
            Logger.getLogger(frmEditor.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } catch (CompileException ex) {
            txtResultado.setText(Messages.strCompileFailure + ex.getMessage());
            Logger.getLogger(frmEditor.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
    }//GEN-LAST:event_btnTestSyntaxActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        this.save();
    }//GEN-LAST:event_btnSaveActionPerformed

    
    private Method createEditingMethod(){
        return Method.BeingEdited(this.txtNombre.getText(), this.pnlDescripcion.getText(), this._metOperator.getFirstLetter(), this.txtFechaCreacion.getText(), this.txtFechaModificacion.getText(), this.CodigoUsuario.getText());
    }
    
    
    private boolean save(){
        Method methodEditing = this.createEditingMethod();
        if (!methodEditing.CompletedMinimumFieldsTo(Acciones.Guardar)){
            JOptionPane.showMessageDialog(this, Messages.strMethodNotPosibleToSave, "EGA", 1);
            return false;
        }    
            
        if (canSave()){
            this.Locally = true;
            if (this.Save(this._strFilePath)){
                this.frmParent.UpdateResourcesTables();
                this._blnEdited = false;
                return true;
            }
        }
        return false;
    }
    
    private boolean canSave(){
        return this._blnEdited == true;
    }
    
    private void CodigoUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CodigoUsuarioKeyPressed
        // TODO add your handling code here:
        this.madeChanges();
    }//GEN-LAST:event_CodigoUsuarioKeyPressed

    private void btnAdjuntarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdjuntarArchivoActionPerformed
        // TODO add your handling code here:
        
        String strPath = getPath(paths.strHome);
        this.fh.setPathFileToRead(strPath);
        if (this.fh.Read()){
            this.CodigoUsuario.setText(this.CodigoUsuario.getText() +  System.getProperty("line.separator") + this.fh.getText());
            this.madeChanges();
        }else{
            
        }
    }//GEN-LAST:event_btnAdjuntarArchivoActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAutorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAutorActionPerformed

    private void CodigoUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CodigoUsuarioKeyReleased
        // TODO add your handling code here:
        this.madeChanges();
    }//GEN-LAST:event_CodigoUsuarioKeyReleased

    private void CodigoUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CodigoUsuarioKeyTyped
        // TODO add your handling code here:
        this.madeChanges();
    }//GEN-LAST:event_CodigoUsuarioKeyTyped

    private void txtNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyPressed
        // TODO add your handling code here:
        this.madeChanges();
    }//GEN-LAST:event_txtNombreKeyPressed

    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
        // TODO add your handling code here:
        this.madeChanges();
    }//GEN-LAST:event_txtNombreKeyReleased

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        // TODO add your handling code here:
        this.madeChanges();
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtAutorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAutorKeyPressed
        // TODO add your handling code here:
        this.madeChanges();
    }//GEN-LAST:event_txtAutorKeyPressed

    private void txtAutorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAutorKeyReleased
        // TODO add your handling code here:
        this.madeChanges();
    }//GEN-LAST:event_txtAutorKeyReleased

    private void txtAutorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAutorKeyTyped
        // TODO add your handling code here:
        this.madeChanges();
    }//GEN-LAST:event_txtAutorKeyTyped

    private void pnlDescripcionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pnlDescripcionKeyPressed
        // TODO add your handling code here:
        this.madeChanges();
    }//GEN-LAST:event_pnlDescripcionKeyPressed

    private void pnlDescripcionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pnlDescripcionKeyReleased
        // TODO add your handling code here:
        this.madeChanges();
    }//GEN-LAST:event_pnlDescripcionKeyReleased

    private void pnlDescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pnlDescripcionKeyTyped
        // TODO add your handling code here:
        this.madeChanges();
    }//GEN-LAST:event_pnlDescripcionKeyTyped

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        this.CloseMe();
    }//GEN-LAST:event_formInternalFrameClosing

    private void txtFechaCreacionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaCreacionKeyPressed
        this.madeChanges();
    }//GEN-LAST:event_txtFechaCreacionKeyPressed

    private void txtFechaCreacionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaCreacionKeyReleased
        this.madeChanges();
    }//GEN-LAST:event_txtFechaCreacionKeyReleased

    private void txtFechaCreacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaCreacionKeyTyped
        this.madeChanges();
    }//GEN-LAST:event_txtFechaCreacionKeyTyped

    private void txtFechaModificacionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaModificacionKeyPressed
        this.madeChanges();
    }//GEN-LAST:event_txtFechaModificacionKeyPressed

    private void txtFechaModificacionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaModificacionKeyReleased
        this.madeChanges();
    }//GEN-LAST:event_txtFechaModificacionKeyReleased

    private void txtFechaModificacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaModificacionKeyTyped
        this.madeChanges();
    }//GEN-LAST:event_txtFechaModificacionKeyTyped

    private boolean Save(String strFilePath){
        if (intLoading == 0){
            String strPathFileToWrite = giveFilePath(strFilePath);
            if (strPathFileToWrite.isEmpty()){
                return false;
            }
            
            if (strPathFileToWrite.lastIndexOf(".") != -1){
                String FileExtension = strPathFileToWrite.substring(strPathFileToWrite.lastIndexOf("."));
                if (!FileExtension.equals(this.paths.strOperadoresExtension))
                    strPathFileToWrite += this.paths.strOperadoresExtension;
            }else{
                strPathFileToWrite += this.paths.strOperadoresExtension;
            }
            

            this.fh.setPathFileToWrite(strPathFileToWrite);
            this.fh.setText(CodigoUsuario.getText());
            if (!strPathFileToWrite.isEmpty()){
                if (this.fh.Write()){
                    if (!this.isPublishing())
                        this.StoreInDatabase(strPathFileToWrite);
                    this._blnEdited = false;

                    JOptionPane.showMessageDialog(this, Messages.strElementSaved, "EGA", 1);
                    return true;
                }else{
                    JOptionPane.showMessageDialog(this, Messages.strCouldNotSaved, "EGA", 1);
                }
            }
        }
        return false;
    }
    
    private boolean isPublishing(){
        return this._blnPublishing == true;
    }
    
    private String giveFilePath(String strInitialFilePath){
        if (!this._canSaveAs && !this._blnPublishing)
            return this._metOperator.getPath();
        
        return this.getPath(strInitialFilePath);
    }
    
    private String getPath(String strInitialFilePath){
        File file = new File(strInitialFilePath);
        fcSave.setCurrentDirectory(file);
        return ChooseFile();
    }
    
    public void StoreInDatabase(String strPathFileToWrite){
        data_type_converter dtc = new data_type_converter();
        ArrayList<Method> arrMethods = new ArrayList<Method>();

        fh.setPathFileToRead(this._strDBPath);
        if (fh.ReadBinary()){
            
            //Read DB for saving all the methods again.
            dtc.setByteText(fh.getByteText());
            dtc.fromByteToStringList();

            ArrayList<ArrayList<String>> strArrMethods = dtc.getStrArrText();
            for (ArrayList<String> strMethod : strArrMethods){
                Method _currentMethod = new Method(strMethod.get(0), strMethod.get(1), strMethod.get(3), Boolean.getBoolean(strMethod.get(4)), strMethod.get(5), strMethod.get(6), strMethod.get(6), strMethod.get(8));
                if (this._canSaveAs){
                    arrMethods.add(_currentMethod);
                }else{
                    if (!this._metOperator.getIndex().equals(_currentMethod.getIndex()))
                        arrMethods.add(_currentMethod);
                }
            
            }

            Integer intLastIndex = arrMethods.size() > 0 ? Integer.parseInt(arrMethods.get(arrMethods.size() - 1).getIndex()) : 0;
            this.setValuesFromMethod(intLastIndex + 1, strPathFileToWrite);
            
            arrMethods.add(this._metOperator);
            dtc.setArrMethods(arrMethods);

            dtc.fromMethodToByteString();
            this.fh.setByteText(dtc.getByteText());
            this.fh.setPathFileToWrite(this._strDBPath);    
            this.fh.WriteBinary(dtc.getStrText());
        }
    }
    
    private void setValuesFromMethod(Integer intIndex, String strPath){
        this._metOperator.setIndex(Integer.toString(intIndex));
        this._metOperator.setName(this.txtNombre.getText());
        this._metOperator.setDescription(this.pnlDescripcion.getText());
        this._metOperator.setAlias("");
        this._metOperator.setPath(strPath);
        this._metOperator.setCreated(this.txtFechaCreacion.getText());
        this._metOperator.setModified(this.txtFechaModificacion.getText());
        this._metOperator.setAuthor(this.txtAutor.getText());
    }
    
    public String ChooseFile(){
        int returnVal = fcSave.showOpenDialog(this);
        if (returnVal == 0) {
            File file = fcSave.getSelectedFile();
            try {
                return file.getAbsolutePath();
            } catch (Exception ex) {
                System.out.println("problem accessing file" + file.getAbsolutePath());
                return "";
            }
        }
        return "";
    }
    
    public boolean CloseAll(){
        // Myself
        if (this._arrMySon.size() == 0 && canCloseMe()){
            this.setVisible(false);
            this.dispose();
            return true;
        }
        
        return false;
    }
    
    private boolean canCloseMe(){
        if (!canSave()) // No modification done
            return true;
        
        int optionSelected = JOptionPane.showConfirmDialog(this, Messages.strClosingWithoutSaving, "EGA", JOptionPane.YES_NO_CANCEL_OPTION);
        switch(optionSelected){
            case JOptionPane.YES_OPTION:
                this.Locally = true;
                if (this.Save(this._strFilePath)){
                    this.frmParent.UpdateResourcesTables();
                    this.setVisible(false);
                }
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
    
    public boolean isEditing(Method met){
        return met.getPath().equals(this._metOperator.getPath());
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JEditorPane CodigoUsuario;
    private javax.swing.JButton btnAdjuntarArchivo;
    private javax.swing.JButton btnPublish;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnTestSyntax;
    private javax.swing.JFileChooser fcSave;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblAutor;
    private javax.swing.JLabel lblFechaCreacion;
    private javax.swing.JLabel lblFechaModificacion;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JPanel panEditor;
    private javax.swing.JTextPane pnlDescripcion;
    private javax.swing.JTextField txtAutor;
    private javax.swing.JFormattedTextField txtFechaCreacion;
    private javax.swing.JFormattedTextField txtFechaModificacion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextArea txtResultado;
    // End of variables declaration//GEN-END:variables
}
