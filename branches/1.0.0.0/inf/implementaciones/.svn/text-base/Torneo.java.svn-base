package implementaciones;

import java.util.List;

import cromosoma.CromosomaAbstractoGenesObject;
import cromosoma.InterfaceCromosoma;
import java.util.Random;

import operadores.SeleccionInterface;


import poblacion.Poblacion;
import proceso.Proceso;

public class Torneo implements SeleccionInterface {

    private Random randomizer;

    public Poblacion ejecutar(Poblacion poblacion) {
        // TODO Auto-generated method stub
        List listaCromosomas = poblacion.getListaDeCromosomas();
//		imprimirCromo(poblacion);
        Poblacion poblaFinal = new Poblacion();
        //		imprimirCromo(poblacion);
        int cantidadParalaNuevaPobla = listaCromosomas.size() / 2;

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
        this.randomizer = proceso.getRandomizer();
    }

    public void parametrizate() {

    }
}
