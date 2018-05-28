package implementaciones;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import operadores.OperadorInterface;

import comp.ManejadorDeElementos;

import poblacion.Poblacion;
import solucion.Solucion;
import cromosoma.InterfaceCromosoma;

public class MutacionCambioDeEltos implements OperadorInterface{

	public String strMutationRate= "0.05";
	
	public double mutationRate; 
	
	public void inicializate()
	{
		this.mutationRate= Float.valueOf(this.strMutationRate);
	}
	
	public Poblacion ejecutar(Poblacion poblacion) {
		// TODO Auto-generated method stub
		
		List listaCromosomasEnPobla= poblacion.getListaDeCromosomas();
		int cantGenes=((InterfaceCromosoma) listaCromosomasEnPobla.get(0)).getCantidadDeGenes();
		double random;
		
		for(Object crom :listaCromosomasEnPobla)
		{
			for(int i = 0; i<cantGenes; ) 
			{
				random= Math.random();
				if(random<this.mutationRate)
				{
					((InterfaceCromosoma) crom).mutaGenEnPosicon(i);
				}	
			}	
		}
		
		
		return poblacion; 
		
	}

	public void inicializate(Solucion solucion) {
		// TODO Auto-generated method stub
		
	}
	
}
