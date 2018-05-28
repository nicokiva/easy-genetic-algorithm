package operadores;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import poblacion.Poblacion;
import solucion.Solucion;
import cromosoma.InterfaceCromosoma;

public abstract class CruzaPadresAleatoriosAbstracta implements CruzamientoInterface{

	public String param_cantidadDePuntos="1"; 
	
	protected int cantidadDePuntos;

	protected Solucion solucion; 
	
	protected Random solucionRandomizer;
	
	public void inicializate(Solucion solucion)
	{
		this.cantidadDePuntos=Integer.valueOf(param_cantidadDePuntos).intValue();
		this.solucion=solucion;
		this.solucionRandomizer=solucion.getRandomizer();
	}
	
	public Poblacion ejecutar(Poblacion poblacion) {
		// TODO Auto-generated method stub
		
		
		
	    Poblacion poblacionCruzada= new Poblacion();		
		List listaCromosomasEnPobla= poblacion.getListaDeCromosomas();
		Iterator it;
		List listaCromosomaHijos,listaCromosomaPadres = new ArrayList();
		int cant=0;
		int random;
		
		
		while(cant< this.solucion.TAMANO_POBLACION) 
		{
			
			listaCromosomaPadres.clear();
			
			//Ver bien como funca el Random
			random = this.solucionRandomizer.nextInt(listaCromosomasEnPobla.size());
			listaCromosomaPadres.add(listaCromosomasEnPobla.get(random));
			random = this.solucionRandomizer.nextInt(listaCromosomasEnPobla.size());
			listaCromosomaPadres.add(listaCromosomasEnPobla.get(random));
			
			listaCromosomaHijos=cruzar(listaCromosomaPadres);
			it=listaCromosomaHijos.iterator();
			
			while(it.hasNext() && cant< this.solucion.TAMANO_POBLACION) 
			{
				poblacionCruzada.add((InterfaceCromosoma) it.next());
				cant++;
			}
		}	
		
		return poblacionCruzada; 
		
	}
	
	/**
	 * FIJARTE DE CAMBIAR ESTE METODO PARA Q SEA MAS PERFORMANTE CON LA IDEA DE ABAJO DE LOS ARRAY O UNA LISTA PROPIA.
	 * @param listaCromosomaPadres
	 * @return
	 */
	protected abstract List cruzar(List listaCromosomaPadres);


}
