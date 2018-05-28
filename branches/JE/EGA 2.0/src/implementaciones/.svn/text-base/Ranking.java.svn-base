package implementaciones;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import cromosoma.CromosomaAbstractoGenesObject;
import cromosoma.InterfaceCromosoma;

import operadores.SeleccionInterface;


import poblacion.Poblacion;
import solucion.Solucion;



public class Ranking implements SeleccionInterface{


	public Poblacion ejecutar(Poblacion poblacion) {
		// TODO Auto-generated method stub
		List list= poblacion.getListaDeCromosomas();
//		imprimirCromo(poblacion);
		
		Collections.sort(list, new ComparadorPorFDA());
		
//		imprimirCromo(poblacion);
		Iterator it = list.iterator();
		
		int cantAremover=list.size()/2;
		for (int i = 0; i < cantAremover; i++) 
		{
			it.next();
			it.remove();
			
		}	
		
		return poblacion; 
	}

	public void inicializate() {
		
	}

	public void inicializate(Solucion solucion) {
		
	}

	public String getCadena() {
		// TODO Auto-generated method stub
		return null;
	}
	private void imprimirCromo(Poblacion poblacion) {
		for(InterfaceCromosoma crom : poblacion.getListaDeCromosomas())
		{
			
			Object[] genes = ((CromosomaAbstractoGenesObject)crom).getGenes();
			for (int i = 0; i < (genes.length); i++) {
				
				System.out.print(" "+ genes[i] +" ");
			}
			System.out.print("FA: " + crom.evaluate());

			System.out.println();
			
		}
	}

}
