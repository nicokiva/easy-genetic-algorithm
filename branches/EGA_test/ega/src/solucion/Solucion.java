package solucion;

import operadores.OperadorInterface;
import implementaciones.CromosomaImp;
import implementaciones.CruzaMultiPunto;
import implementaciones.FuncionDeAptitudImpl;
import implementaciones.MutacionCambioDeEltos;
import implementaciones.PersonasHelper;
import implementaciones.Ranking;
import cromosoma.FuncionDeAptitud;
import cromosoma.InterfaceCromosoma;

public class Solucion {
	
	
	public static final int CANT_GENERACIONES = 20;

	public int TAMANIO_POBLACION= 10;
	
	private FuncionDeAptitud funcionAp= new FuncionDeAptitudImpl();

	private Object helper= new PersonasHelper();

	private OperadorInterface operadorMuta=  new MutacionCambioDeEltos();

	private OperadorInterface operadorCruza= new CruzaMultiPunto();

	private OperadorInterface operadorSelec= new Ranking();

	public InterfaceCromosoma newCromosoma() {
		// TODO Auto-generated method stub
		InterfaceCromosoma crom = new CromosomaImp();
		crom.setSolucion(this);
		
		return crom;
	}

	public FuncionDeAptitud getFuncionDeAptitud() {
		// TODO Auto-generated method stub
		return this.funcionAp;
	}

	public Object getHelper() {
		// TODO Auto-generated method stub
		return this.helper;
	}

	public OperadorInterface getOperadorSeleccion() {
		// TODO Auto-generated method stub
		return this.operadorSelec;
	}

	public OperadorInterface getOperadorCruzamiento() {
		// TODO Auto-generated method stub
		return this.operadorCruza;
	}

	public OperadorInterface getOperadorMutacion() {
		// TODO Auto-generated method stub
		return this.operadorMuta;
	}
}
