package util;

import cromosoma.InterfaceCromosoma;
import java.util.Comparator;


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
