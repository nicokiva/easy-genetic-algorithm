
package implementaciones;

import cromosoma.InterfaceCromosoma;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import operadores.SeleccionInterface;
import poblacion.Poblacion;
import proceso.Proceso;

public class Ruleta implements SeleccionInterface {

    private Random randomizer;
    //<param>
    public String porcentaje="0.5";
    //</param>
    
    private float fraccion;
    
    public void inicializate(Proceso proceso) {
        this.randomizer = proceso.getRandomizer();
        try{ 
        
           this.fraccion=  Float.parseFloat(this.porcentaje);
       
       }catch(NumberFormatException ex){
           proceso.mensajeDeError("Error al parsear "+ex.getMessage(), true, false, false);
       }
    }

    public void parametrizate() {
 
    }

    private  class CromosomaElegible {
        private InterfaceCromosoma cromosoma;
        private boolean elegido;
        
        public CromosomaElegible(InterfaceCromosoma crom) {
            this.cromosoma=crom;
            this.elegido=false;
        }
    }



    private class LimiteAcumuladoDeAptitudesCromosomas {
        
        private int limiteSuperior;
        private int limiteInferior;
        private List listaCromosomas = new LinkedList();

        private CromosomaElegible buscarCromosoma(int probabilidad) {
            Iterator it = listaCromosomas.iterator();
            int acum = limiteInferior;


            while (it.hasNext()) {
                CromosomaElegible cromElegible = (CromosomaElegible) it.next();
                
                acum += cromElegible.cromosoma.evaluate();

                if (probabilidad <= acum) {
                    return cromElegible;
                }
                
            }

            return null;
        }
    }

    public Poblacion ejecutar(Poblacion poblacion) {
        // TODO Auto-generated method stub
        List listaCromosomas = poblacion.getListaDeCromosomas();
//		imprimirCromo(poblacion);
        Poblacion poblaFinal = new Poblacion();

//		imprimirCromo(poblacion);
        Iterator it = listaCromosomas.iterator();

//            int cantArray = list.size()/10;
//                
//            if(list.size()%10!=0){
//                 cantArray++;
//            }
//            
//            LimiteConLista arrayLimiteConLista[]= new LimiteConLista[cantArray];
//            
//            for (int i = 0; i < arrayLimiteConLista.length; i++) {
//                arrayLimiteConLista[i]=new LimiteConLista();
//                
//            }

        int posArray = 0;

        int acumuladorDeAptitudes = 0;
        int contadorDeCromosomas = 0;

        List listaLimiteAcumuladoCromosomas = new LinkedList();
        LimiteAcumuladoDeAptitudesCromosomas limiteAcum = new LimiteAcumuladoDeAptitudesCromosomas();
        int limiteSuperiorAnterior = 0;
        listaLimiteAcumuladoCromosomas.add(limiteAcum);
        int totalDeAptitudes=0;
        
        while (it.hasNext()) {

            InterfaceCromosoma crom = (InterfaceCromosoma) it.next();

            if (contadorDeCromosomas == 50) {
//                    arrayLimiteConLista[posArray].limite=acumuladorDeAptitudes;
//                    posArray++;
                limiteAcum.limiteSuperior = acumuladorDeAptitudes + limiteSuperiorAnterior;
                limiteAcum.limiteInferior = limiteSuperiorAnterior;
                limiteSuperiorAnterior=limiteAcum.limiteSuperior;
                limiteAcum = new LimiteAcumuladoDeAptitudesCromosomas();
                listaLimiteAcumuladoCromosomas.add(limiteAcum);
                contadorDeCromosomas = 0;
                acumuladorDeAptitudes = 0;
            }

     
            int valorAptitud = crom.evaluate();

            if (valorAptitud > 0) {
                acumuladorDeAptitudes += valorAptitud;
                //                    arrayLimiteConLista[posArray].listaCromosomas.add(crom);
                CromosomaElegible cromElegible = new CromosomaElegible(crom);
                limiteAcum.listaCromosomas.add(cromElegible);
                contadorDeCromosomas++;
                totalDeAptitudes+= valorAptitud;

            }
        }
        
        limiteAcum.limiteSuperior = acumuladorDeAptitudes + limiteSuperiorAnterior;
        limiteAcum.limiteInferior = limiteSuperiorAnterior;
        
        int cantidadBusquedas = (int) (listaCromosomas.size() * this.fraccion);

        for (int i = 0; i < cantidadBusquedas; i++) {
           

            int probabilidad = this.randomizer.nextInt(totalDeAptitudes)+1;
            CromosomaElegible cromosomaElegible;
            it = listaLimiteAcumuladoCromosomas.iterator();
            boolean continuar = true;

            while (it.hasNext() && continuar) {
                limiteAcum = (LimiteAcumuladoDeAptitudesCromosomas) it.next();

                if (probabilidad <= limiteAcum.limiteSuperior) {
                    cromosomaElegible = limiteAcum.buscarCromosoma(probabilidad);
                    
                    if(cromosomaElegible.elegido){
                         poblaFinal.add(cromosomaElegible.cromosoma.clone());
                    }else{
                       poblaFinal.add(cromosomaElegible.cromosoma);
                       cromosomaElegible.elegido=true;
                    }
                                                                
                    continuar = false;
                }
            }

        }

       
        return poblaFinal;


    }
    

}
