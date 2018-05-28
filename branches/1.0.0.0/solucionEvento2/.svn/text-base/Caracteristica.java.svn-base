/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implementacionEv3;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author leop
 */
class Caracteristica  {
    
    
    private final String nombre;
    private final int valor;
    private final int igualdad;
    private final int desigualdad;
    private List setCaracteristicas;
    private static final String EMPTY="";

    public String getNombre() {
        return nombre;
    }

    public int getValor() {
        return valor;
    }

    public int getIgualdad() {
        return igualdad;
    }

    public int getDesigualdad() {
        return desigualdad;
    }


    public Caracteristica(String nombre, int intValue, Boolean igualdad) {
        this.nombre=nombre;
        this.valor=intValue;
        this.setCaracteristicas= new ArrayList();
        
        
        if(igualdad){
           this.igualdad=1;
           this.desigualdad=0;
         }else{
            this.igualdad=0;
           this.desigualdad=1;
        }
    }

    int agregarValor(String string) {
        
        
        String strTrim=string.trim();
        if(strTrim.equals(EMPTY)){
            return -1;
        }
            
        int index=this.setCaracteristicas.indexOf(strTrim);
        
        if(index>-1){
            return index;
        
        }else{
            this.setCaracteristicas.add(strTrim);
            //aca me jugue a que es asi
            return this.setCaracteristicas.size()-1;
        }
    }

    public String obtenerNombreValor(int i) {
        return (String) this.setCaracteristicas.get(i);
    }
    
}
