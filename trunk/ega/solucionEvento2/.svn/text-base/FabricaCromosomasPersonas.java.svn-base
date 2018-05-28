package implementacionEv3;

import cromosoma.FabricaDeCromosomasInterface;
import cromosoma.InterfaceCromosoma;
import java.util.Random;
import proceso.Proceso;

/**
 *
 * @author leop
 */
public class FabricaCromosomasPersonas implements FabricaDeCromosomasInterface{
    
        
    
    Persona[]  personas;
    //PersonaCSV[]  personas;
    private Random procesoRandomizer;
    private Proceso proceso;
    

  
    
    
         
    public InterfaceCromosoma crearCromosomaGenesVacios() {
        CromosomaImp crom = new CromosomaImp();
        crom.setGenes(new Persona[personas.length]);
        crom.setProceso(this.proceso);
        
        return crom;
    }

    public InterfaceCromosoma crearCromosomaGenesLLenadosAlAzar() {
        

//		
//        CromosomaImp crom = new CromosomaImp();
//        
//        crom.setProceso(this.proceso);
//        crom.setGenes( personas.clone());
//        
//        Object[] genes =  crom.getGenes();
//	
//        int random1;
//	int random2;
//			
//        for (int i = 0; i < (personas.length/2); i++) {
//			
//            random1 = procesoRandomizer.nextInt(genes.length);
//            Object genAux = genes[random1];
//            random2 = procesoRandomizer.nextInt(genes.length);
//            genes[random1]=genes[random2];
//            genes[random2]=genAux;
//        }
        
              CromosomaImp crom = new CromosomaImp();
        
        crom.setProceso(this.proceso);
        crom.setGenes( personas.clone());
        
        Object[] genes =  crom.getGenes();
	
        int random1;
	int random2;
			
        for (int i = 0; i < (personas.length/2); i++) {
			
            random1 = procesoRandomizer.nextInt(genes.length);
            Object genAux = genes[random1];
            random2 = procesoRandomizer.nextInt(genes.length);
            genes[random1]=genes[random2];
            genes[random2]=genAux;
        }
                
         return crom;       
		
    }

    public void inicializate(Proceso proceso) {
         
         this.proceso = proceso;
         this.procesoRandomizer = proceso.getRandomizer();
         //PersonasHelperCSV helper = (PersonasHelperCSV) proceso.getHelper();
         PersonasHelper helper = (PersonasHelper) proceso.getHelper();
         this.personas = helper.getPersonas();
         
    }

    public void parametrizate() {

    }



}