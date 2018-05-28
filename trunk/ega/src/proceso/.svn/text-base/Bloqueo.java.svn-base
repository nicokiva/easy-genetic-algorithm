/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proceso;

/**
 *
 * @author leop
 */
class Bloqueo {
    
   
    public synchronized void espera() throws InterruptedException{
        wait();
    }
    public synchronized void liberate() throws InterruptedException{
        notify();
    }
}
