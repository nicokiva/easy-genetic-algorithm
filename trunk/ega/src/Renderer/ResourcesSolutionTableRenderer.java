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
 * @author Nicolas
 */
public class ResourcesSolutionTableRenderer extends DefaultTableCellRenderer {
    @Override 
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) 
    { 
        Component cell = super.getTableCellRendererComponent (table, value, isSelected, hasFocus, row, column); 
        cell.setForeground(Color.LIGHT_GRAY.darker());
        this.setHorizontalAlignment(SwingConstants.CENTER);
        
        
        if (isSelected)
        {
            cell.setBackground(Color.YELLOW);
        }
        else 
        {
            cell.setBackground(Color.WHITE);
        }
        
        return cell;
    }
}
