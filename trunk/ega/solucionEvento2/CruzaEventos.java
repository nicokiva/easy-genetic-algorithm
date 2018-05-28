package implementacionEventos;

import cromosoma.InterfaceCromosoma;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import operadores.CruzaPadresAleatoriosAbstracta;
import proceso.Proceso;
import util.ComparadorPorFDA;


public class CruzaEventos extends CruzaPadresAleatoriosAbstracta{
        
     
        
    //<param>

    //</param>
        
        
	
        public void inicializate(Proceso proceso)
	{
		super.inicializate(proceso);
	}
        
        
	protected List cruzar(List listaCromosomaPadres) {
//return listaCromosomaPadres;
		InterfaceCromosoma crom1 = this.fabricaDeCromosomas.crearCromosomaGenesLLenadosAlAzar();
		InterfaceCromosoma crom2 = this.fabricaDeCromosomas.crearCromosomaGenesLLenadosAlAzar();
		

		
		List listaCromosomas= new ArrayList();
		
                listaCromosomas.addAll(listaCromosomaPadres);
		listaCromosomas.add(crom1);
		listaCromosomas.add(crom2);
		
                Collections.sort(listaCromosomas, new ComparadorPorFDA());
                
                List listaCromosomasHijos= new ArrayList();
                
                InterfaceCromosoma cromHijo1 = (InterfaceCromosoma) listaCromosomas.get(listaCromosomas.size()-1);
                InterfaceCromosoma cromHijo2 = (InterfaceCromosoma) listaCromosomas.get(listaCromosomas.size()-2);
                
                if(listaCromosomaPadres.contains(cromHijo1)){
                InterfaceCromosoma crom = cromHijo1.clone();
                     listaCromosomasHijos.add(crom);

                }else{
                     listaCromosomasHijos.add(cromHijo1);
                }
                
                if(listaCromosomaPadres.contains(cromHijo2)){
                     
                     InterfaceCromosoma crom = cromHijo2.clone();
                     listaCromosomasHijos.add(cromHijo2.clone());

                }else{
                     
                    listaCromosomasHijos.add(cromHijo2);
                }
    
                
		return listaCromosomasHijos;
	}

	
	


    public void parametrizate() {

    }


}
