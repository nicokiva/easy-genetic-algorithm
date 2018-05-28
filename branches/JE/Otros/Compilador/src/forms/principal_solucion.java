/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import configuration.*;
import ega.Method;
import helpers.*;
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author Nicolas
 */
public class principal_solucion extends javax.swing.JFrame {
    file_handler fh = new file_handler();
    Paths paths = new Paths();
    /**
     * Creates new form principal_solucion
     */
    public principal_solucion() {
        initComponents();
        this.FillComboBox();
    }

    private void FillComboBox(){
        fh.setPathFileToRead(paths.strSeleccionDB);
        if (fh.ReadBinary()){
            ArrayList<String> strListMethods;
            //String strText = "";
            //byte[] byteText = fh.getByteText();
            String[] strLines = fh.getText().split("\n");
            String[] strMethod;
            //data_type_converter dtc = new data_type_converter(fh.getText());
            //dtc.fromByteToStringList();
            //strListMethods = dtc.fromStringToList();
            cmbMetodosParo.removeAllItems();
            for (String strLine : strLines){
                strMethod = strLine.split("\\|");
//                Method met = new Method(strMethod[0], strMethod[1], strMethod[2], strMethod[3], strMethod[4], Boolean.getBoolean(strMethod[5]));
//                cmbMetodosParo.addItem("[S" + met.getIndex() + "] - " + met.getName());
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

        cmbMetodosParo = new javax.swing.JComboBox();
        crearNuevo = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        escribir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cmbMetodosParo.setName("cmbMetodosParo"); // NOI18N
        cmbMetodosParo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMetodosParoActionPerformed(evt);
            }
        });

        crearNuevo.setText("Nuevo");

        txtNombre.setName("txtNombre"); // NOI18N

        escribir.setText("Escribir");
        escribir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escribirActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtNombre)
                            .addComponent(cmbMetodosParo, 0, 269, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(crearNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                            .addComponent(escribir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbMetodosParo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(crearNuevo))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(escribir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbMetodosParoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMetodosParoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbMetodosParoActionPerformed

    private void escribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_escribirActionPerformed
        String strByteText;
        String strText = txtNombre.getText();
        
        data_type_converter dtc = new data_type_converter(strText + "[__FM__]");
        strByteText = dtc.fromStringToByteString();
        fh.setPathFileToWrite(paths.strParoDB);
        fh.setText(strByteText);
        fh.WriteBinary();
    }//GEN-LAST:event_escribirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(principal_solucion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(principal_solucion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(principal_solucion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(principal_solucion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new principal_solucion().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbMetodosParo;
    private javax.swing.JButton crearNuevo;
    private javax.swing.JButton escribir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}