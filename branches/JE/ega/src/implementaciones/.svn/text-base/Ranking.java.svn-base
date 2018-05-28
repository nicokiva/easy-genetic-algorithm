package implementaciones;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import operadores.OperadorInterface;


import poblacion.Poblacion;
import solucion.Solucion;



public class Ranking implements OperadorInterface{


	public Poblacion ejecutar(Poblacion poblacion) {
		// TODO Auto-generated method stub
		List list= poblacion.getListaDeCromosomas();
		
		Collections.sort(list, new ComparadorPorFDA());
		
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


}
