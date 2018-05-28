/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Renderer;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Triton
 */
public class PersonalTableRenderer extends DefaultTableCellRenderer
{

    @Override 
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) 
    { 
        Component cell = super.getTableCellRendererComponent (table, value, isSelected, hasFocus, row, column); 

        //se centran los valores 
        if (column == 0)
        { 
            //cell.setBackground(Color.DARK_GRAY.brighter()); 
            cell.setForeground(Color.LIGHT_GRAY.darker());
            this.setHorizontalAlignment(SwingConstants.LEFT); 
        } 
        else 
        { 
            cell.setBackground(Color.WHITE); 
            cell.setForeground(Color.BLACK);
            this.setHorizontalAlignment(SwingConstants.CENTER); 
        } 
        
        
        return cell;
    }

}
    /*
        //valores especificos del programa 
        int cantidad = Integer.parseInt(table.getValueAt(row, 4).toString()); 
        int stockMin = Integer.parseInt(table.getValueAt(row, 5).toString()); 
        int stockMax = Integer.parseInt(table.getValueAt(row, 6).toString()); 
        //si cumplen x condicion se pintan 
        if (cantidad < stockMin)
        { 
            cell.setBackground(Color.RED); 
            cell.setForeground(Color.WHITE); 
        } 
        if (cantidad > stockMax){ 
            cell.setBackground(Color.YELLOW); 
            cell.setForeground(Color.BLACK); 
        } 
        //si no cumplen esa condicion pongo las celdas en color blanco 
        if ((cantidad >= stockMin) && (cantidad <= stockMax))
        { 
            cell.setBackground(Color.WHITE); 
            cell.setForeground(Color.BLACK); 
        } 
       */

    



