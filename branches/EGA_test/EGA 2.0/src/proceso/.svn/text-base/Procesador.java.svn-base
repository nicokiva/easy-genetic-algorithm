package proceso;

import implementaciones.ParoPorCiclos;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import implementaciones.ComparadorPorFDA;
import implementaciones.CromosomaImp;
import implementaciones.CruzaMultiPunto;
import implementaciones.FuncionDeAptitudImpl;
import implementaciones.MutacionCambioDeEltos;
import implementaciones.PersonasHelper;
import implementaciones.Ranking;
import cromosoma.CromosomaAbstractoGenesObject;
import cromosoma.FuncionDeAptitud;
import cromosoma.InterfaceCromosoma;
import operadores.CruzaPadresAleatoriosAbstracta;
import operadores.CruzamientoInterface;
import operadores.HelperInterface;
import operadores.MutacionInterface;
import operadores.OperadorInterface;
import operadores.ParoInterface;
import operadores.SeleccionInterface;
import poblacion.Poblacion;
import solucion.Solucion;



public class Procesador {
	
	public static void main(String[] args) {
		Procesador procesa = new Procesador();
		
		Solucion sol = new Solucion();
//		Set<Class> setInterfaces= new HashSet<Class>();
//
//		setInterfaces.add(InterfaceCromosoma.class);
//		setInterfaces.add(SeleccionInterface.class);
//		setInterfaces.add(MutacionInterface.class);
//		setInterfaces.add(CruzamientoInterface.class);
//		setInterfaces.add(HelperInterface.class);
//		setInterfaces.add(FuncionDeAptitud.class);
//		
//		List<String> paths = new ArrayList<String>();
//		
//		String path="E:/SPLDSDK/DEV01/eclipseWorkspace/EGA/implementaciones/";
//		paths.add(path + "CromosomaImp.java");
//		paths.add(path + "FuncionDeAptitudImpl.java");
//		paths.add(path + "MutacionCambioDeEltos.java");
//		paths.add(path + "PersonasHelper.java");
//		paths.add(path + "Ranking.java");
//		paths.add(path + "ComparadorPorFDA.java");
//		paths.add(path + "CruzaMultiPunto.java");
//	
//		sol.armate(paths, setInterfaces);
		

		
		Map<Class, Class> mapa= new HashMap<Class, Class>();
		
		mapa.put(InterfaceCromosoma.class,CromosomaImp.class);
		mapa.put(SeleccionInterface.class,Ranking.class);
		mapa.put(MutacionInterface.class,MutacionCambioDeEltos.class);
		mapa.put(CruzamientoInterface.class,CruzaMultiPunto.class);
		mapa.put(HelperInterface.class,PersonasHelper.class);
		mapa.put(FuncionDeAptitud.class,FuncionDeAptitudImpl.class);
		sol.armateParaPruebas(mapa);
		
		procesa.ejecutar(sol);
		int num=0;
		
		Random generator = new Random();
		while(num!=9)
			num=generator.nextInt(10);
		System.out.print(num);
	}	
	
	public void ejecutar(Solucion solucion){
		
		Poblacion poblacion = new Poblacion(solucion);
		
		poblacion.generarPoblacionInicial(solucion.TAMANO_POBLACION);
		
		OperadorInterface opSeleccion= solucion.getOperadorSeleccion();
		
		opSeleccion.inicializate(solucion);
		
		OperadorInterface opCruza= solucion.getOperadorCruzamiento();
		
		opCruza.inicializate(solucion);
		
		OperadorInterface opMuta= solucion.getOperadorMutacion();
		
		opMuta.inicializate(solucion);
		
		FuncionDeAptitud fAp = solucion.getFuncionDeAptitud();
		
		fAp.inicializate(solucion);
		
                ParoInterface paro = solucion.getMetodoParo();
//                ParoInterface paro = new ParoPorCiclos();
		
                paro.inicializate(solucion);
                
                while ( paro.continuar()) {
			
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
		
		System.out.println("Final");
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
