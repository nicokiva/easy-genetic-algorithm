/*c
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cromosoma;

import elementos.ElementoParametrizable;



/**
 *
 * @author leop
 */
public interface FabricaDeCromosomasInterface extends ElementoParametrizable {
    
    /**Crea un cromosoma nuevo listo para meterle genes. 
     * Si se eligio implementar un array de genes . 
     * Se tiene que crear ese array de genes con el tamano apropiado.
     * Ejemplo, en el cruzamiento se generan cromosomas hijos con este metodo
     * a los cuales se les ejecuta el metodo meterGenEnPosicion para meter el gen del padre.
     * @return 
     */
    public InterfaceCromosoma crearCromosomaGenesVacios();
    
    
    /**
     * 
     * @return 
     */
    public InterfaceCromosoma crearCromosomaGenesLLenadosAlAzar();
    
}
