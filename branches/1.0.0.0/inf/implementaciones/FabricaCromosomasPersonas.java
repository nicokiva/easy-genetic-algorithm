/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implementaciones;

import cromosoma.FabricaDeCromosomasInterface;
import cromosoma.InterfaceCromosoma;
import java.util.Random;
import poblacion.Poblacion;
import proceso.Proceso;

/**
 *
 * @author leop
 */
public class FabricaCromosomasPersonas implements FabricaDeCromosomasInterface{
    
        
    
    String[] personas = {"PePe","Paco","Ana","Maria","Pablo","Anaconda","Pepita","Anatomia"};
	
    private Random solucionRandomizer;
    private Proceso proceso;


  
    
    
         
    public InterfaceCromosoma crearCromosomaGenesVacios() {
        CromosomaImp crom = new CromosomaImp();
        crom.setGenes(new String[personas.length]);
        crom.setProceso(this.proceso);
        
        return crom;
    }

    public InterfaceCromosoma crearCromosomaGenesLLenadosAlAzar() {
        

		
        CromosomaImp crom = new CromosomaImp();
        
        crom.setProceso(this.proceso);
        crom.setGenes((String[]) personas.clone());
        
        String[] genes = crom.getGenes();
	
        int random1;
	int random2;
			
        for (int i = 0; i < (genes.length/2); i++) {
			
            random1 = solucionRandomizer.nextInt(genes.length);
            String genAux = genes[random1];
            random2 = solucionRandomizer.nextInt(genes.length);
            genes[random1]=genes[random2];
            genes[random2]=genAux;
        }
                
         return crom;       
		
    }

    public void inicializate(Proceso proceso) {
         this.proceso=proceso;
    }

    public void parametrizate() {

    }



}
