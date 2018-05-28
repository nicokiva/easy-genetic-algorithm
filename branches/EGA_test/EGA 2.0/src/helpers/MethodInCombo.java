/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import Methods.*;
import javax.swing.JComboBox;

/**
 *
 * @author Nicolas
 */
public class MethodInCombo {
    public Method method;
    public JComboBox combo;
    public int position;
    
    public MethodInCombo(Method method, JComboBox combo, int position){
        this.method = method;
        this.combo = combo;
        this.position = position;
    }
}
