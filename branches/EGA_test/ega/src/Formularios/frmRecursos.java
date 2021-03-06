/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;
import helpers.*;
import Methods.*;
import java.util.ArrayList;
import java.util.Map;
import configuration.*;

/**
 *
 * @author Triton
 */
public class frmRecursos extends javax.swing.JInternalFrame {
    ArrayList<Method> arrMethods;
    Paths paths = new Paths();
    private MethodsType _mtMethodsType = new MethodsType();
    file_handler fh = new file_handler();
    Object[][] _objMethods; // = new Object[10][7];
    String[] _strColumns = {"CODIGO", "TIPO", "NOMBRE", "ALIAS", "DESCRIPCION", "RUTA", "CREADO", "MODIFICADO", "AUTOR"};
            
    /**
     * Creates new form frmRecursos
     */
    public frmRecursos() {
        initComponents();
        FillResourcesTable();
    }
    
    private void FillResourcesTable(){
        ArrayList<Object[]> objMethods = new ArrayList<Object[]>();
        
        data_type_converter dtc = new data_type_converter();
        tblResources.removeAll();
        //int counter = 0;
        for (String[] strMethodType : this._mtMethodsType.arrMethodsType){
            String strType = strMethodType[2];
            fh.setPathFileToRead(strMethodType[1]);
            if (fh.ReadBinary()){
                dtc.setByteText(fh.getByteText());
                dtc.fromByteToStringList();
               
                ArrayList<ArrayList<String>> strArrMethods = dtc.getStrArrText();
                for (ArrayList<String> strMethod : strArrMethods){
                    Object[] objMethod = {strMethod.get(0), strType, strMethod.get(1), strMethod.get(2), strMethod.get(3), strMethod.get(5), strMethod.get(6), strMethod.get(7)};
                    objMethods.add(objMethod);
                }
            }
        }
        
        int intTotalMethods = objMethods.size();
        this._objMethods = new Object[intTotalMethods - 1][7];

        for (int intCounter = 0; intCounter < intTotalMethods - 1; intCounter++){
            this._objMethods[intCounter] = objMethods.get(intCounter);
        }
        
        //Needs to remove null rows from object
        tblResources.setModel(new javax.swing.table.DefaultTableModel(this._objMethods, this._strColumns));
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
        jButton18 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("EGA - Base de Recursos");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ICON.png"))); // NOI18N

        tblResources.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "SELECCION", "Ranking", null, "Elige los N mayores.", "", "12/07/2012", "13/08/2012", "Pyte"},
                {"2", "APTITUD", "Eventos", null, "Para eventos.", "", "15/09/2012", "15/09/2012", null},
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
                "CODIGO", "TIPO", "NOMBRE", "ALIAS", "DESCRIPCION", "RUTA", "CREADO", "MODIFICADO", "AUTOR"
            }
        ));
        tblResources.getTableHeader().setReorderingAllowed(false);
        jspResources.setViewportView(tblResources);

        jButton18.setText("Abrir Recurso");

        jButton17.setText("Guardar Cambios");

        jButton19.setText("Eliminar Recurso");

        jButton21.setText("Salir");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(199, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jspResources)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jspResources, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton21;
    private javax.swing.JScrollPane jspResources;
    private javax.swing.JTable tblResources;
    // End of variables declaration//GEN-END:variables
}
