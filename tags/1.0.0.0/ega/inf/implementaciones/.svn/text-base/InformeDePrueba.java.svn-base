package implementaciones;

import java.util.Iterator;
import java.util.List;
import cromosoma.CromosomaAbstractoGenesObject;
import elementos.FormatoInformeInterface;


import java.util.LinkedList;
import proceso.Proceso;

//por ahoa la interfaz no tiene nada . La iremos definiendo
public class InformeDePrueba implements FormatoInformeInterface {

    //Lo que ves en este ejemplo esta tomado de la mutacion para explicarte
    public String separadorDeGenes = " , ";


  

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
            
          
            listaStrings.add(builderRegistro.toString());
        }


        return listaStrings;

    }

    public void inicializate(Proceso proceso) {
    }

    public void parametrizate() {
    }
}
