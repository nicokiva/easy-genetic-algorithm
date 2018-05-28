/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;


import Methods.Param;
import Presentacion.Auxiliares.MethodInCombo;
import Presentacion.Auxiliares.comboBox;
import Presentacion.Auxiliares.file_handler;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;

import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Triton
 */

public class CombosListener implements ActionListener
{
    private final frmSolucion frmsol;
    

    
    public CombosListener(frmSolucion frmsol){
        this.frmsol=frmsol;
    }
    private void mostrarParametros(ActionEvent evt) {
        // TODO add your handling code here:
        if (this.frmsol.getIntLoading() == 0) {
            JComboBox combo = (JComboBox) evt.getSource();
            for (comboBox cmbCombo : this.frmsol.jComboBoxes) {
                if (cmbCombo.combo == combo) {
                    int indexSelected = combo.getSelectedIndex();
                    for (MethodInCombo cmbMethod : this.frmsol.getArrMethodsInCombo()) {
                        if (cmbMethod.combo == combo && indexSelected == cmbMethod.position) {
                            
                            List<Param> listaParametros=cmbMethod.method.getParams();
                            if(listaParametros.isEmpty()){
                                    listaParametros = file_handler.traerParametros(cmbMethod.method.getPath());
                                    cmbMethod.method.setParams(listaParametros);
                            }
                            DefaultTableModel modelo = (DefaultTableModel) cmbCombo.table.getModel();
//                            int cantFilas = modelo.getRowCount();
//                            //                            modelo.getDataVector().clear();
//                            //                            modelo.getDataVector().removeAllElements();
//                            //                             cantFilas = modelo.getRowCount();
//                            //
//                            for(int i=0 ; i<cantFilas;i++ ){
//                                modelo.removeRow(i);
//                            }
                            modelo.getDataVector().clear();
                            
                            if (!listaParametros.isEmpty()) {
                                //                                Object[][] data = new Object[listaParametros.size()][];
                                //                                int paramN = 0;
                                for (Param param : listaParametros) {
//                                    Object[] oneParam = {param.getName(), param.getValue()};
//                                    data[paramN] = oneParam;
//                                    paramN++;
                                      String[] datos = {param.getName(), param.getValue()};
                                      modelo.addRow(datos);
                                    
                                }
                                
                                //                                cmbCombo.table.setModel(new javax.swing.table.DefaultTableModel(data, this.strParamsTableHeader));
                               
                            }
                            modelo.addRow(frmsol.ROW_VACIA);
                            return;
                        }
                    }
                }
            }
        }
    }
    
    public void actionPerformed (ActionEvent e)
    {
       mostrarParametros(e);
        
    } // FIN public void actionPerformed (ActionEvent e)
    
} // FIN CALSE LISTENER
