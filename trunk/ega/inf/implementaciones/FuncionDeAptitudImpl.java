package implementaciones;

import cromosoma.FuncionDeAptitud;
import cromosoma.InterfaceCromosoma;
import elementos.HelperInterface;
import proceso.Proceso;

public class FuncionDeAptitudImpl implements FuncionDeAptitud{
    
    private Proceso proceso;
    private PersonasHelper helper;
	



	
	
	public int evaluar(InterfaceCromosoma cromosoma) {
		// TODO Auto-generated method stub
		String[] genes = ((CromosomaImp) cromosoma).getGenes();
		int sum=0;
//                helper=this.proceso.getHelper();
//		PersonasHelper helper = ((PersonasHelper) );
		
		for (int i = 0; i < genes.length; i++) {
			
			for(int j = i + 1; j < genes.length; j++) {
				
				sum+=this.helper.valorRelacion(genes[i],genes[j])/(j-i);
			
			}	
			
		}
		
		return sum;
	}

    public void inicializate(Proceso proceso) {
        this.proceso=proceso;
        this.helper= (PersonasHelper) proceso.getHelper();
    }

    public void parametrizate() {
    
    }


	
	
}
