/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implementaciones;

import operadores.ParoInterface;
import solucion.Solucion;


public class ParoPorCiclos implements ParoInterface {
    
    public String cantidadTotalDeCiclos;
    private int cicloNro=0;       
    
    private int cantidadTotalDeCiclosInt;
   
    public ParoPorCiclos() {
        
    }
    
    public boolean continuar(){
       
        if(this.cicloNro<this.cantidadTotalDeCiclosInt){
            this.cicloNro++;
            return true; 
        }
        return false;
    }
    
    public void inicializate(Solucion sol){
        this.cantidadTotalDeCiclosInt=Integer.valueOf(this.cantidadTotalDeCiclos).intValue();
    }
}
