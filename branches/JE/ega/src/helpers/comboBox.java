/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import javax.swing.JComboBox;

/**
 *
 * @author Nicolas
 */
public class comboBox {
    public JComboBox combo;
    public String strFileName;
    
    public comboBox(JComboBox combo, String strFileName){
        this.strFileName = strFileName;
        this.combo = combo;
    }
}
