package implementaciones;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import operadores.MutacionInterface;
import operadores.OperadorInterface;

import comp.ManejadorDeElementos;
import cromosoma.CromosomaAbstractoGenesObject;

import poblacion.Poblacion;
import solucion.Solucion;
import cromosoma.InterfaceCromosoma;
import formatoResultados.FormatoInformeInterface;
import java.util.LinkedList;

//por ahoa la interfaz no tiene nada . La iremos definiendo
public class InformeDePrueba implements FormatoInformeInterface {

    //Lo que ves en este ejemplo esta tomado de la mutacion para explicarte
    public String separadorDeGenes = " , ";

    //La idea de este metodo es que haga algo con los parametros q recibe por reflection
    //Ej:
    public void inicializate(Solucion solucion) {
    }

    public List ejecutar(List listaCromosomas) {

        Iterator it = listaCromosomas.iterator();
        List listaStrings = new LinkedList();

        while (it.hasNext()) {

            StringBuilder builderRegistro = new StringBuilder();

            CromosomaAbstractoGenesObject crom = (CromosomaAbstractoGenesObject) it.next();
            Object[] objetosGenes = crom.getGenes();
            int ultimoGen = objetosGenes.length - 1;

            for (int i = 0; i < objetosGenes.length; i++) {
                builderRegistro.append(objetosGenes[i].toString());

                if (i != ultimoGen) {
                    builderRegistro.append(this.separadorDeGenes);
                }
            }
            builderRegistro.append(" "+crom.evaluate());
            
          
            listaStrings.add(builderRegistro.toString())
        }


        return listaStrings;

    }
}
