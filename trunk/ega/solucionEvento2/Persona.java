/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implementacionEv3;

import java.util.HashMap;

/**
 *
 * @author leop
 */
class Persona {
    private final int[] caracteristicas;
    private final String nombre;
    private final int posicionEnArrayPrincipal;
    private HashMap relaciones;

    public int getPosicionEnArrayPrincipal() {
        return posicionEnArrayPrincipal;
    }

    Persona(String nombrePersona, int[] codigoValorCaraceristica, int posicion) {
        this.nombre=nombrePersona;
        this.caracteristicas=codigoValorCaraceristica;
        this.posicionEnArrayPrincipal=posicion;
    }

  
    
    public int[] getCaracteristicas() {
        return caracteristicas;
    }

    public String getNombre() {
        return nombre;
    }


    public String toString() {
        return this.nombre;
    }

    public void agregarRelacion(Persona per2, Integer valueOf) {
        
        if(this.relaciones==null){
         this.relaciones= new HashMap();
        }
        this.relaciones.put(per2,valueOf);
    }

    public int valorRelacion(Persona persona2) {
        
        if(this.relaciones==null){
            return 0;
        }
        Integer valor = (Integer) this.relaciones.get(persona2);
        
        if(valor!=null){
         return valor.intValue();
        }
        
        return 0;
        
    }

 
    
    
}
