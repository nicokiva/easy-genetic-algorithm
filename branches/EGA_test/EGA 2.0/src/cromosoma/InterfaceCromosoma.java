package cromosoma;

import operadores.OperadorInterface;
import solucion.Solucion;
import comp.ManejadorDeElementos;

public interface InterfaceCromosoma {
	
	
//	public Object[] getCromosoma();
	
	public int evaluate();
	
//	public int getLargo();
	
	public void setSolucion(Solucion solucion);
	
	public void mutaGenEnPosicion(int posicion);
	
	public void generate();

	public int getCantidadDeGenes();
	
	public void meterGenEn(int posicionGenEsteCromosoma,InterfaceCromosoma crom, int posicionGenOtroCromosoma);
	
//	public int aptitud();
		
	
}
