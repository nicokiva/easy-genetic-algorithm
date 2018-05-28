
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implementacionEventos;

import elementos.ParoInterface;
import proceso.Proceso;


public class ParoPorCiclos implements ParoInterface {
    
    //<param>
    public String cantidadTotalDeCiclos="63";

    //</param>

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
//    
//    public void inicializate(Solucion sol){
//        this.cantidadTotalDeCiclosInt=Integer.valueOf(this.cantidadTotalDeCiclos).intValue();
//    }

    public void inicializate(Proceso proceso) {
    }

    public void parametrizate() {
        this.cantidadTotalDeCiclosInt=Integer.valueOf(this.cantidadTotalDeCiclos).intValue();
    }
        
    
}
