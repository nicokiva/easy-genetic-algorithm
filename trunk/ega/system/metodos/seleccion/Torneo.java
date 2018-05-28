
package implementaciones;

import cromosoma.InterfaceCromosoma;
import java.util.List;
import java.util.Random;
import operadores.SeleccionInterface;
import poblacion.Poblacion;
import proceso.Proceso;

public class Torneo implements SeleccionInterface {

    private Random randomizer;
    //<param>
    public String porcentaje="0.5";
    //</param>
    
    private float fraccion;
    private Proceso proceso;

    public Poblacion ejecutar(Poblacion poblacion) {

        List listaCromosomas = poblacion.getListaDeCromosomas();

        Poblacion poblaFinal = new Poblacion();

        int cantidadParalaNuevaPobla = (int) (listaCromosomas.size() * this.fraccion);

        for (int i = 0; i < cantidadParalaNuevaPobla; i++) {

            int posicionluchador1 = this.randomizer.nextInt(listaCromosomas.size());
            int posicionluchador2 = this.randomizer.nextInt(listaCromosomas.size());

            InterfaceCromosoma cromosomaLuchador1 = (InterfaceCromosoma) listaCromosomas.get(posicionluchador1);
            InterfaceCromosoma cromosomaLuchador2 = (InterfaceCromosoma) listaCromosomas.get(posicionluchador2);

            if (cromosomaLuchador1.evaluate() > cromosomaLuchador2.evaluate()) {
                poblaFinal.add(cromosomaLuchador1);
            } else {
                poblaFinal.add(cromosomaLuchador2);
            }

        }

        return poblaFinal;


    }


    public void inicializate(Proceso proceso) {
        this.proceso=proceso;
        this.randomizer = proceso.getRandomizer();
    }

    public void parametrizate() {
       try{ 
        
           this.fraccion=  Float.parseFloat(this.porcentaje);
       
       }catch(NumberFormatException ex){
           this.proceso.mensajeDeError("Error al parsear "+ex.getMessage(), true, false, false);
       }
    }
}
