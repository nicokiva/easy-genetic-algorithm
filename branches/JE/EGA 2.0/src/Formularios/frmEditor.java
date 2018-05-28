/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;
import Methods.Method;
import comp.Compilador;
import configuration.*;
import helpers.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.codehaus.commons.compiler.CompileException;

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
    
    MDI frmParent;
    file_handler fh = new file_handler();
    Paths paths = new Paths();
    boolean Locally = true;
    
    /**
     * Creates new form frmEditor
     */
    public frmEditor() {
        this.startLoading();
        initComponents();
        this.finishLoading();
    }
    
    public frmEditor(MDI frmParent, int intID, Method metSelectedMethod, boolean blnCanSaveAs) {
        this.startLoading();
        initComponents();
        this.setInitialConfiguration(frmParent, intID, metSelectedMethod, blnCanSaveAs);
        this.finishLoading();
    }
    
    private void setInitialConfiguration(MDI frmParent, int intID, Method metSelectedMethod, boolean blnCanSaveAs){
        this._intID = intID;
        this._metOperator = metSelectedMethod;
        this._canSaveAs = blnCanSaveAs; // if FALSE => editing

        this.frmParent = frmParent;
        String strTitle = (metSelectedMethod.getName() != null && !metSelectedMethod.getName().isEmpty()) ? metSelectedMethod.getName().toUpperCase() : metSelectedMethod.getType().toUpperCase();
        this.lblTipoFuncion.setText(strTitle);
        this.setInitialPaths(metSelectedMethod);
        
        this.showMethodToEdit();
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
            this.CodigoUsuario.setText("");
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
        bntAbrir = new javax.swing.JButton();
        btnAdjuntarArchivo = new javax.swing.JButton();
        panEditor = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblAutor = new javax.swing.JLabel();
        txtAutor = new javax.swing.JTextField();
        lblTipoFuncion = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        pnlDescripcion = new javax.swing.JTextPane();
        txtFechaCreacion = new javax.swing.JFormattedTextField();
        lblFechaCreacion = new javax.swing.JLabel();
        txtFechaModificacion = new javax.swing.JFormattedTextField();
        lblFechaModificacion = new javax.swing.JLabel();

        fcSave.setCurrentDirectory(new java.io.File("C:\\"));

            setClosable(true);
            setIconifiable(true);
            setTitle("EGA - Editor de Funciones");
            setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ICON.png"))); // NOI18N

            btnSave.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
            btnSave.setText("Grabar");
            btnSave.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnSaveActionPerformed(evt);
                }
            });

            CodigoUsuario.setText("//  ESTA ES UNA PLANTILLA PARA METODOS DE SELEECION QUE LE OFRECE EGA\n//  LOS DATOS A COMPLETAR SON :\n// 1. Nombre de la Clase\n// 2. etc\n\n\npublic class MetodoSeleccionEventos \n{\n       // este método de selección funciona mejor que los estandares para el caso de eventos..\n      // tiene la particulairdad de que bla bla bla .....\n\n     public int iRetorno;\n     private int iMAX;\n     private string sCadena\n\n     initComponents();\n\n\n    public int metodoA (int param1, int param2, object cromosomas)\n   {\t\t\n\tobject Seleccionados;\n\n\t// seguir desarrollando....\n\n          \treturn Seleccionados\n   }\n\n\n    private object metodoB (object cromosomas)\n   {\t\t\n\tstring Cadena\n\t// acá bla bla bnla blaa....\n\t// seguir desarrollando....\n\n          \treturn Cadena\n   }\n\n} // FIN DE CLASE\n\n");
            CodigoUsuario.setToolTipText("");
            CodigoUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyPressed(java.awt.event.KeyEvent evt) {
                    CodigoUsuarioKeyPressed(evt);
                }
            });
            jScrollPane1.setViewportView(CodigoUsuario);

            btnTestSyntax.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
            btnTestSyntax.setText("Probar Sintáxis");
            btnTestSyntax.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnTestSyntaxActionPerformed(evt);
                }
            });

            btnPublish.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
            btnPublish.setText("Publicar");
            btnPublish.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnPublishActionPerformed(evt);
                }
            });

            btnSalir.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
            btnSalir.setText("Salir");
            btnSalir.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnSalirActionPerformed(evt);
                }
            });

            txtResultado.setEditable(false);
            txtResultado.setColumns(20);
            txtResultado.setRows(5);
            txtResultado.setText(" RESULTADO COMPILACION:");
            jScrollPane2.setViewportView(txtResultado);

            bntAbrir.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
            bntAbrir.setText("Abrir");
            bntAbrir.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    bntAbrirActionPerformed(evt);
                }
            });

            btnAdjuntarArchivo.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
            btnAdjuntarArchivo.setText("Adjuntar Archivo");
            btnAdjuntarArchivo.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnAdjuntarArchivoActionPerformed(evt);
                }
            });

            panEditor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Función de APTITUD", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 12))); // NOI18N
            panEditor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            lblNombre.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
            lblNombre.setText("Nombre:");
            panEditor.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 34, 50, -1));

            txtNombre.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
            txtNombre.setText("Aptitud para Eventos");
            txtNombre.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    txtNombreActionPerformed(evt);
                }
            });
            panEditor.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 30, 148, 22));

            lblAutor.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
            lblAutor.setText("Autor:");
            panEditor.add(lblAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 62, 34, -1));

            txtAutor.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
            txtAutor.setText("Pablo Pytel");
            txtAutor.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    txtAutorActionPerformed(evt);
                }
            });
            panEditor.add(txtAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 60, 148, 22));

            lblTipoFuncion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
            lblTipoFuncion.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
            lblTipoFuncion.setText("Cromosoma");
            lblTipoFuncion.setToolTipText("");
            panEditor.add(lblTipoFuncion, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 10, 20, 16));

            pnlDescripcion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
            pnlDescripcion.setText("Ingrese aquí una Descripción...");
            pnlDescripcion.setMargin(new java.awt.Insets(5, 5, 5, 5));
            jScrollPane3.setViewportView(pnlDescripcion);

            panEditor.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(414, 16, 548, 72));

            txtFechaCreacion.setEditable(false);
            try {
                txtFechaCreacion.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("## / ## / ####")));
            } catch (java.text.ParseException ex) {
                ex.printStackTrace();
            }
            txtFechaCreacion.setText("22 / 09 / 2012");
            txtFechaCreacion.setToolTipText("");
            txtFechaCreacion.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
            txtFechaCreacion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
            txtFechaCreacion.setMargin(new java.awt.Insets(2, 10, 2, 2));
            panEditor.add(txtFechaCreacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(302, 30, 95, -1));

            lblFechaCreacion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
            lblFechaCreacion.setText("Creado:");
            panEditor.add(lblFechaCreacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(236, 34, 46, -1));

            txtFechaModificacion.setEditable(false);
            try {
                txtFechaModificacion.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("## / ## / ####")));
            } catch (java.text.ParseException ex) {
                ex.printStackTrace();
            }
            txtFechaModificacion.setText("22 / 09 / 2012");
            txtFechaModificacion.setToolTipText("");
            txtFechaModificacion.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
            txtFechaModificacion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
            txtFechaModificacion.setMargin(new java.awt.Insets(2, 10, 2, 2));
            panEditor.add(txtFechaModificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(302, 60, 95, -1));

            lblFechaModificacion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
            lblFechaModificacion.setText("Modificado:");
            panEditor.add(lblFechaModificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(236, 62, 68, -1));

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 974, Short.MAX_VALUE)
                        .addComponent(jScrollPane2)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(bntAbrir, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                            .addGap(18, 18, 18)
                            .addComponent(btnTestSyntax, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                            .addGap(18, 18, 18)
                            .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                            .addGap(18, 18, 18)
                            .addComponent(btnPublish, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                            .addGap(18, 18, 18)
                            .addComponent(btnAdjuntarArchivo, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                            .addGap(18, 18, 18)
                            .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))
                        .addComponent(panEditor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap())
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panEditor, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(btnTestSyntax)
                        .addComponent(btnSave)
                        .addComponent(btnPublish)
                        .addComponent(btnSalir)
                        .addComponent(bntAbrir)
                        .addComponent(btnAdjuntarArchivo))
                    .addGap(6, 6, 6))
            );

            pack();
        }// </editor-fold>//GEN-END:initComponents

    private void btnPublishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPublishActionPerformed
        // TODO add your handling code here:
        this._blnPublishing = true;
        this.Locally = false;
        this.Save(paths.strMain);
        this._blnPublishing = false;
    }//GEN-LAST:event_btnPublishActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnTestSyntaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTestSyntaxActionPerformed
        
        try {
           
            Compilador.pruebaCompilacion(CodigoUsuario.getText());
        
        } catch (IOException ex) {
            Logger.getLogger(frmEditor.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } catch (CompileException ex) {
            txtResultado.setText("Errores: \n" + ex.getMessage());
            Logger.getLogger(frmEditor.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        txtResultado.setText("RESULTADO COMPILACION:\n\nCompilación correcta.. \n");
    }//GEN-LAST:event_btnTestSyntaxActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        if (canSave()){
            this.Locally = true;
            if (this.Save(this._strFilePath)){
                this.setVisible(false);
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private boolean canSave(){
        return this._blnEdited == true;
    }
    
    private void bntAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntAbrirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bntAbrirActionPerformed

    private void CodigoUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CodigoUsuarioKeyPressed
        // TODO add your handling code here:
        this._blnEdited = true;
    }//GEN-LAST:event_CodigoUsuarioKeyPressed

    private void btnAdjuntarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdjuntarArchivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdjuntarArchivoActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAutorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAutorActionPerformed

    private boolean Save(String strFilePath){
        if (intLoading == 0){
            String strPathFileToWrite = giveFilePath(strFilePath);
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
        
        File file = new File(strInitialFilePath);
        fcSave.setCurrentDirectory(file);
        return ChooseFile();
    }
    
    public void StoreInDatabase(String strPathFileToWrite){
        data_type_converter dtc = new data_type_converter();
        ArrayList<Method> arrMethods = new ArrayList<Method>();

        fh.setPathFileToRead(this._strDBPath);
        if (fh.ReadBinary()){
            dtc.setByteText(fh.getByteText());
            dtc.fromByteToStringList();

            ArrayList<ArrayList<String>> strArrMethods = dtc.getStrArrText();
            if (this._canSaveAs){
                for (ArrayList<String> strMethod : strArrMethods)
                    arrMethods.add(new Method(strMethod.get(0), strMethod.get(1), strMethod.get(2), strMethod.get(3), Boolean.getBoolean(strMethod.get(4)), strMethod.get(5), strMethod.get(6), strMethod.get(7), strMethod.get(8)));
            }else{
                for (ArrayList<String> strMethod : strArrMethods)
                if (!this._metOperator.getIndex().equals(strMethod.get(0)))
                    arrMethods.add(new Method(strMethod.get(0), strMethod.get(1), strMethod.get(2), strMethod.get(3), Boolean.getBoolean(strMethod.get(4)), strMethod.get(5), strMethod.get(6), strMethod.get(7), strMethod.get(8)));
            }
            
            
            Integer intLastIndex = arrMethods.size() > 0 ? Integer.parseInt(arrMethods.get(arrMethods.size() - 1).getIndex()) : 0;
            
            this._metOperator.setIndex(Integer.toString(intLastIndex + 1));
            this._metOperator.setName("Method Name");
            this._metOperator.setDescription("Description");
            this._metOperator.setAlias("Alias");
            this._metOperator.setPath(strPathFileToWrite);
            this._metOperator.setCreated("CREATED");
            this._metOperator.setModified("MODIFIED");
            this._metOperator.setAuthor("AUTHOR");
            
            arrMethods.add(this._metOperator);
            dtc.setArrMethods(arrMethods);
            
            this.fh.setText(dtc.fromMethodToByteString());
            this.fh.setPathFileToWrite(this._strDBPath);    
            this.fh.WriteBinary();
        }
    }
    
    public String ChooseFile(){
        int returnVal = fcSave.showOpenDialog(this);
        if (returnVal == 0) {
            File file = fcSave.getSelectedFile();
            try {
                return file.getAbsolutePath();
                //jTextField1.read( new FileReader( file.getAbsolutePath() ), null );
            } catch (Exception ex) {
                System.out.println("problem accessing file" + file.getAbsolutePath());
                return "";
            }
        }
        return "";
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JEditorPane CodigoUsuario;
    private javax.swing.JButton bntAbrir;
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
    private javax.swing.JLabel lblTipoFuncion;
    private javax.swing.JPanel panEditor;
    private javax.swing.JTextPane pnlDescripcion;
    private javax.swing.JTextField txtAutor;
    private javax.swing.JFormattedTextField txtFechaCreacion;
    private javax.swing.JFormattedTextField txtFechaModificacion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextArea txtResultado;
    // End of variables declaration//GEN-END:variables
}
