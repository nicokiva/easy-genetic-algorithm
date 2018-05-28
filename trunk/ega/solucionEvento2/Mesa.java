/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implementacionEv3;

/**
 *
 * @author leop
 */
class Mesa {
    
    private final String nombre;


    public String getNombre() {
        return nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }
    private final int capacidad;

    public Mesa(String nombre, int intValue) {
        this.nombre=nombre;
        this.capacidad=intValue;
    }



 
    
}
