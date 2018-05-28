package implementaciones;

import cromosoma.InterfaceCromosoma;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import operadores.MutacionInterface;
import poblacion.Poblacion;
import proceso.Proceso;

public class MutacionCambioDeEltos implements MutacionInterface{
        
        //<param>
            
            public String strMutationRate= "0.05";
	
         //</param>

	
	public double mutationRate; 
	
	
	protected Random solucionRandomizer;
        
        private Proceso proceso;


	
	
	public Poblacion ejecutar(Poblacion poblacion) {
		// TODO Auto-generated method stub
		
		List listaCromosomasEnPobla= poblacion.getListaDeCromosomas();
		int cantGenes=((InterfaceCromosoma) listaCromosomasEnPobla.get(0)).getCantidadDeGenes();
		Iterator it = listaCromosomasEnPobla.iterator();
		
		while(it.hasNext())	{
			
			InterfaceCromosoma crom= (InterfaceCromosoma) it.next();
			
			for(int i = 0; i<cantGenes;i++ ) {
				if(this.solucionRandomizer.nextDouble()<this.mutationRate) {
					crom.mutaGenEnPosicion(i);
				}	
			}	
		}
		
		
		return poblacion; 
		
	}

    public void inicializate(Proceso proceso) {
      
	this.proceso = proceso;
	this.solucionRandomizer = proceso.getRandomizer();
    }

    public void parametrizate() {
       try{ 
        
           this.mutationRate=  Float.parseFloat(strMutationRate);
       
       }catch(NumberFormatException ex){
           proceso.mensajeDeError("Error al parsear "+ex.getMessage(), true, false, false);
       }
//         this.mutationRate= Float.valueOf(this.strMutationRate);
    }



	
}
