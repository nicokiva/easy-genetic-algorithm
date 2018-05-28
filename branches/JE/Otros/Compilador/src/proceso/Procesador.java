package proceso;

import implementaciones.CromosomaImp;
import cromosoma.CromosomaAbstractoGenesObject;
import cromosoma.FuncionDeAptitud;
import cromosoma.InterfaceCromosoma;
import operadores.OperadorInterface;
import poblacion.Poblacion;
import solucion.Solucion;



public class Procesador {
	
	public static void main(String[] args) {
		Procesador procesa = new Procesador();
		procesa.ejecutar(new Solucion());
	}	
	
	public void ejecutar(Solucion solucion){
		
		Poblacion poblacion = new Poblacion(solucion);
		
		poblacion.generarPoblacionInicial(solucion.TAMAÑO_POBLACION);
		
		OperadorInterface opSeleccion= solucion.getOperadorSeleccion();
		
		opSeleccion.inicializate(solucion);
		
		OperadorInterface opCruza= solucion.getOperadorCruzamiento();
		
		opCruza.inicializate(solucion);
		
		OperadorInterface opMuta= solucion.getOperadorMutacion();
		
		opMuta.inicializate(solucion);
		
		FuncionDeAptitud fAp = solucion.getFuncionDeAptitud();
		
		fAp.inicializate(solucion);
		
		for (int i = 0; i < solucion.CANT_GENERACIONES; i++) {
			
			poblacion=opSeleccion.ejecutar(poblacion);
			
			System.out.println("Seleccion");
			imprimirCromo(poblacion);	
			
			poblacion = opCruza.ejecutar(poblacion);
			
			System.out.println("Cruza");
			imprimirCromo(poblacion);	
			
			poblacion = opMuta.ejecutar(poblacion);
			
			System.out.println("Muta");
			imprimirCromo(poblacion);
//			poblacion = opMuta.ejecutar(opCruza.ejecutar(opSeleccion.ejecutar(poblacion, solucion), solucion), solucion);
			
		}
		
		imprimirCromo(poblacion);	
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
