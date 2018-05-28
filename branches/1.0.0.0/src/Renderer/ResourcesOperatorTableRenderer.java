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
public class ResourcesOperatorTableRenderer extends DefaultTableCellRenderer {
    @Override 
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) 
    { 
        Component cell = super.getTableCellRendererComponent (table, value, isSelected, hasFocus, row, column); 

        
        //ListSelectionModel sm = table.getSelectionModel();
        //sm.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        //table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        //se centran los valores 

        switch (column){
            case 0: // CODIGO
                cell.setForeground(Color.LIGHT_GRAY.darker());
                this.setHorizontalAlignment(SwingConstants.CENTER);
                break;
                
            case 1: // TIPO
                cell.setForeground(Color.LIGHT_GRAY.darker());
                this.setHorizontalAlignment(SwingConstants.LEFT);
                break;
                
            case 2: // NOMBRE
                cell.setForeground(Color.BLACK);
                this.setHorizontalAlignment(SwingConstants.LEFT);
                break;

            case 3: // DESCRIPCION
                cell.setForeground(Color.BLACK);
                this.setHorizontalAlignment(SwingConstants.LEFT);
                break;
                
            case 4: // RUTA
                cell.setForeground(Color.LIGHT_GRAY.darker());
                this.setHorizontalAlignment(SwingConstants.LEFT);
                break;
                
            case 5: // CREADO
                cell.setForeground(Color.LIGHT_GRAY.darker());
                this.setHorizontalAlignment(SwingConstants.CENTER);
                break;
                
            case 6: // MODIFICADO
                cell.setForeground(Color.LIGHT_GRAY.darker());
                this.setHorizontalAlignment(SwingConstants.CENTER);
                break;
                
            case 7: // AUTOR
                cell.setForeground(Color.BLACK);
                this.setHorizontalAlignment(SwingConstants.CENTER);
                break;
                
            case 8: // EXISTE
                cell.setForeground(Color.LIGHT_GRAY.darker());
                this.setHorizontalAlignment(SwingConstants.CENTER);
                break;
        }

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
