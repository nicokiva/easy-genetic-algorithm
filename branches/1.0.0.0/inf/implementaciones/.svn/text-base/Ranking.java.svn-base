package implementaciones;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import operadores.SeleccionInterface;
import poblacion.Poblacion;
import proceso.Proceso;



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

    public void inicializate(Proceso proceso) {
    }

    public void parametrizate() {
    }





}
package implementaciones;

import java.util.Comparator;

import cromosoma.InterfaceCromosoma;


public class ComparadorPorFDA implements Comparator {
	
	private int orden=1;
	
	public ComparadorPorFDA(boolean ascendente)
	{
		if(!ascendente)
			this.orden=-1;
	}
	
	public ComparadorPorFDA()
	{
		
	}
	
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		return  (((InterfaceCromosoma) o1).evaluate() - ((InterfaceCromosoma) o2).evaluate())*orden;
	}

}