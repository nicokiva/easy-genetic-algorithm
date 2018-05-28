
package implementacionEventos;

import cromosoma.InterfaceCromosoma;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import operadores.MutacionInterface;
import poblacion.Poblacion;
import proceso.Proceso;

public class MutacionCambioDeEltos implements MutacionInterface{
        
        //<param>
            
        public String strMutationRate= "0.0005";
        //</param>

	
	public double mutationRate; 
	
	
	protected Random solucionRandomizer;
        
        private Proceso proceso;

        
	
	
	public Poblacion ejecutar(Poblacion poblacion) {
		// TODO Auto-generated method stub
		int cantidadDeCromosomasMutados=0;
		List listaCromosomasEnPobla= poblacion.getListaDeCromosomas();
		int cantGenes=((InterfaceCromosoma) listaCromosomasEnPobla.get(0)).getCantidadDeGenes();
		Iterator it = listaCromosomasEnPobla.iterator();
		 boolean muto;
		while(it.hasNext())	{
			
			InterfaceCromosoma crom= (InterfaceCromosoma) it.next();
			muto=false;
			for(int i = 0; i<cantGenes;i++ ) {
				if(this.solucionRandomizer.nextDouble()<this.mutationRate) {
				   //System.out.print("Se muta pos "+i+" de "+ crom);	
                                   crom.mutaGenEnPosicion(i);
                                    muto = true;
				}	
			}
                        
                        if(muto) {cantidadDeCromosomasMutados++;
                        //System.out.print(" Nuevo Crom "+ crom);
                        // System.out.println();
                         
                        }
		}
		this.proceso.setCantidadDeCromosomasMutados(cantidadDeCromosomasMutados);
		
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
