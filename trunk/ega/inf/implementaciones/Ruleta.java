package implementaciones;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import cromosoma.CromosomaAbstractoGenesObject;
import cromosoma.InterfaceCromosoma;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;
import java.util.TreeSet;

import operadores.SeleccionInterface;


import poblacion.Poblacion;
import proceso.Proceso;



public class Ruleta implements SeleccionInterface{

    private Random randomizer;

    public void inicializate(Proceso proceso) {
        this.randomizer=proceso.getRandomizer();
    }

    public void parametrizate() {
       
    
    }
        
    
        private class LimiteAcumuladoDeAptitudesCromosomas{
            private int limiteSuperior;
            private int limiteInferior;
            private List listaCromosomas= new LinkedList();

            private InterfaceCromosoma buscarCromosoma(int probabilidad) {
                Iterator it = listaCromosomas.iterator();
                int acum=limiteInferior;
               
                
                while(it.hasNext() ){
                    InterfaceCromosoma crom = (InterfaceCromosoma) it.next();
                    acum+=crom.evaluate();
                    
                    if(acum<probabilidad){
                        return crom;
                    }
                }
              
               return null; 
            }
        
        }
        


	public Poblacion ejecutar(Poblacion poblacion) {
		// TODO Auto-generated method stub
            List listaCromosomas= poblacion.getListaDeCromosomas();
//		imprimirCromo(poblacion);
            Poblacion poblaFinal= new Poblacion();    
               
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
            int contadorDeCromosomas = 1;
            
            List listaLimiteAcumuladoCromosomas= new LinkedList();        
            LimiteAcumuladoDeAptitudesCromosomas limiteAcum = new LimiteAcumuladoDeAptitudesCromosomas();
            int limiteInferior=0;
            listaLimiteAcumuladoCromosomas.add(limiteAcum);
            
            
            while(it.hasNext()){
               
               InterfaceCromosoma crom = (InterfaceCromosoma)it.next();
                                             
               if(contadorDeCromosomas==11){
//                    arrayLimiteConLista[posArray].limite=acumuladorDeAptitudes;
//                    posArray++;
                   limiteAcum.limiteSuperior=acumuladorDeAptitudes+limiteInferior;
                   limiteAcum.limiteInferior=limiteInferior; 
                   limiteAcum=new LimiteAcumuladoDeAptitudesCromosomas();
                   listaLimiteAcumuladoCromosomas.add(limiteAcum);
                   contadorDeCromosomas=1;
                   acumuladorDeAptitudes=0;
               }
               
               int valorAptitud=crom.evaluate();
               
               if(valorAptitud>0) {
                    acumuladorDeAptitudes+=valorAptitud;
//                    arrayLimiteConLista[posArray].listaCromosomas.add(crom);
                   limiteAcum.listaCromosomas.add(crom);
                   contadorDeCromosomas++; 
               }
            }                
            
            
            int cantidadBusquedas= listaCromosomas.size()/2;
            
            for (int i = 0; i < cantidadBusquedas; i++) {
              
                int probabilidad=this.randomizer.nextInt(acumuladorDeAptitudes);
                InterfaceCromosoma cromosoma;
                it=listaLimiteAcumuladoCromosomas.iterator();
                boolean continuar=true;

                while(it.hasNext() && continuar){
                    limiteAcum = (LimiteAcumuladoDeAptitudesCromosomas) it.next();

                    if(probabilidad<limiteAcum.limiteSuperior){
                        cromosoma=limiteAcum.buscarCromosoma(probabilidad);
                        poblaFinal.add(cromosoma);
                        continuar=false;
                    }
                }
                               
            }
    
            
         return poblaFinal;
            
            
	}







}
