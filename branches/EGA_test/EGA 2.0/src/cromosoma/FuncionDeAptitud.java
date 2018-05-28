package cromosoma;

import solucion.Solucion;

public interface FuncionDeAptitud {


	public int evaluar(InterfaceCromosoma cromosoma);
	
	public void inicializate(Solucion solucion);
		
}
