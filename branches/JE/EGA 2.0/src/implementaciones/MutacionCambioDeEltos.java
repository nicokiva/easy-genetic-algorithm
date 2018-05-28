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

import poblacion.Poblacion;
import solucion.Solucion;
import cromosoma.InterfaceCromosoma;

public class MutacionCambioDeEltos implements MutacionInterface{

	public String strMutationRate= "0.05";
	
	
	
	public double mutationRate; 
	
	protected Solucion solucion;
	
	protected Random solucionRandomizer;

	public void inicializate(Solucion solucion) {
		
		this.mutationRate= Float.valueOf(this.strMutationRate);
		this.solucion = solucion;
		this.solucionRandomizer = solucion.getRandomizer();
	}
	
	
	public Poblacion ejecutar(Poblacion poblacion) {
		// TODO Auto-generated method stub
		
		List listaCromosomasEnPobla= poblacion.getListaDeCromosomas();
		int cantGenes=((InterfaceCromosoma) listaCromosomasEnPobla.get(0)).getCantidadDeGenes();
		Iterator it = listaCromosomasEnPobla.iterator();
		
		while(it.hasNext())	{
			
			InterfaceCromosoma crom= (InterfaceCromosoma) it.next();
			
			for(int i = 0; i<cantGenes;i++ ) {
				if(this.solucionRandomizer.nextDouble()<this.mutationRate) {
					crom.mutaGenEnPosicion(i);
				}	
			}	
		}
		
		
		return poblacion; 
		
	}



	
}
