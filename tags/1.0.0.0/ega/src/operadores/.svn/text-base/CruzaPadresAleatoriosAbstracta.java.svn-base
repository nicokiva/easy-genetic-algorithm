package operadores;

import cromosoma.FabricaDeCromosomasInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import poblacion.Poblacion;
import cromosoma.InterfaceCromosoma;
import proceso.Proceso;

public abstract class CruzaPadresAleatoriosAbstracta implements CruzamientoInterface{



	
	protected Random procesoRandomizer;
       
        protected FabricaDeCromosomasInterface fabricaDeCromosomas;
        protected Proceso proceso;
	
        
        
	public void inicializate(Proceso proceso)
	{
		
		this.proceso=proceso;
		this.procesoRandomizer=proceso.getRandomizer();
                this.fabricaDeCromosomas=proceso.getFabricaDeCromosomas();

	}
	
	public Poblacion ejecutar(Poblacion poblacion) {
		// TODO Auto-generated method stub
		
		
		
	    Poblacion poblacionCruzada= new Poblacion();		
		List listaCromosomasEnPobla= poblacion.getListaDeCromosomas();
		Iterator it;
		List listaCromosomaHijos,listaCromosomaPadres = new ArrayList();
		int cant=0;
		int random;
		
		
		while(cant< this.proceso.getCantidadPoblacionInicial()) 
		{
			
			listaCromosomaPadres.clear();
			
			//Ver bien como funca el Random
			random = this.procesoRandomizer.nextInt(listaCromosomasEnPobla.size());
			listaCromosomaPadres.add(listaCromosomasEnPobla.get(random));
			random = this.procesoRandomizer.nextInt(listaCromosomasEnPobla.size());
			listaCromosomaPadres.add(listaCromosomasEnPobla.get(random));
			
			listaCromosomaHijos=cruzar(listaCromosomaPadres);
			it=listaCromosomaHijos.iterator();
			
			while(it.hasNext() && cant< this.proceso.getCantidadPoblacionInicial()) 
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
