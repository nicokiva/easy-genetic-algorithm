/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Renderer;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nicolas
 */
public class ResourcesTableModel extends DefaultTableModel{
    @Override
    public boolean isCellEditable (int row, int column)
    {
        switch (column){
            case 0:
            case 1:
            case 4:
                return false;
            default:
                return true;
        }
    }
}
