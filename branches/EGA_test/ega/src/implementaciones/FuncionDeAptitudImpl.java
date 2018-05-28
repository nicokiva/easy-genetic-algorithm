package implementaciones;

import solucion.Solucion;
import cromosoma.FuncionDeAptitud;
import cromosoma.InterfaceCromosoma;

public class FuncionDeAptitudImpl implements FuncionDeAptitud{
	
	
	private Solucion solucion;


	public void inicializate(Solucion solucion) {
		
		this.solucion=solucion;
	}
	
	
	public int evaluar(InterfaceCromosoma cromosoma) {
		// TODO Auto-generated method stub
		String[] genes = ((CromosomaImp) cromosoma).getGenes();
		int sum=0;
		PersonasHelper helper = ((PersonasHelper) this.solucion.getHelper());
		
		for (int i = 0; i < genes.length; i++) {
			
			for(int j = i + 1; j < genes.length; j++) {
				
				sum+=helper.valorRelacion(genes[i],genes[j])/(j-i);
			
			}	
			
		}
		
		return sum;
	}


	
	
}
