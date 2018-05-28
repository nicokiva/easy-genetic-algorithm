package poblacion;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

import solucion.Solucion;

import comp.ManejadorDeElementos;
import cromosoma.InterfaceCromosoma;


public class Poblacion{

	/**
	 * Tiene el tama
	 */
	private List<InterfaceCromosoma> listaDeCromosomas;
	private Solucion solucion;
	
	
//	public static int getCantidad() {
//		return cantidad;
//	}
//
//	public static void setCantidad(int cantidad) {
//		Poblacion.cantidad = cantidad;
//	}

	public List<InterfaceCromosoma> getListaDeCromosomas() {
		
//		ArrayList<InterfaceCromosoma> list = new ArrayList<InterfaceCromosoma>();
//		
//		list.addAll(this.listaDeCromosomas);
//		
//		return list;
		
		return this.listaDeCromosomas;
	}

	public void setListaDeCromosomas(List<InterfaceCromosoma> listaDeCromosomas) {
		this.listaDeCromosomas = listaDeCromosomas;
	}

	public void generarPoblacionInicial(int cantidad)
	{
		
		for(int i=0; i< cantidad; i++ )
		{
			InterfaceCromosoma cromo=this.solucion.newCromosoma();
			cromo.generate();
			this.listaDeCromosomas.add(cromo);
		}	
		
	}
	
	public Poblacion(Solucion sol)
	{
		this.solucion=sol;
		this.listaDeCromosomas= new ArrayList<InterfaceCromosoma>();
	}
	
	public Poblacion()
	{
		this.listaDeCromosomas= new ArrayList<InterfaceCromosoma>();
	}
	
	public void add(InterfaceCromosoma cromosoma) {
		this.listaDeCromosomas.add(cromosoma);
	}
	
//	public Poblacion poblacionOrdenada(Comparator comp)
//	{
//		
//		Poblacion poblacion = new Poblacion();
//		
//		
//	}
//	
//	
//	private void ordenar(Comparator comp)
//	{
//		Collections.sort(this.listaDeCromosomas, comp);
//	}
}
