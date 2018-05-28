/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Auxiliares;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.JTextField;
/**
 *
 * @author Nicolas
 */
public class TimerManager {
    Timer timer;
    private Integer hour = 0;
    private Integer minute = 0;
    private Integer second = 0;
    public JTextField text;
    
    public TimerManager(JTextField text){
        this.text = text;
    }
    
    public void start(){
        this.timer = new Timer(1000, counterAction);
        this.timer.start();
    }
    
    public void reset(){
        this.hour = 0;
        this.minute = 0;
        this.second = 0;
    }
    
    public void pause(){
        this.timer.stop();
    }
    
    public void stop(){
        this.timer.stop();
        this.reset();
    }
    
    ActionListener counterAction = new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            if (second == 59){
                second = 0;
                if (minute == 59){
                    minute = 0;
                    if (hour == 23){
                        hour = 0;
                    }else{
                        hour++;
                    }
                }else{
                    minute++;
                }
            }else{
                second++;
            }
            
            
            String txtHour = hour < 10 ? "0" + hour.toString() : hour.toString();
            String txtMinute = minute < 10 ? "0" + minute.toString() : minute.toString();
            String txtSecond = second < 10 ? "0" + second.toString() : second.toString();
            text.setText(txtHour + ":" + txtMinute + ":" + txtSecond);
        }
    };
    
}
