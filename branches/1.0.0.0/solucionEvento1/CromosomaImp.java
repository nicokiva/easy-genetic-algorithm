package implementacionEventos;



import cromosoma.CromosomaAbstractoGenesObject;

public class CromosomaImp extends CromosomaAbstractoGenesObject{

   //<param>

   //</param>	
	
//	protected  Persona[] genes;
        
 
        
	public void mutaGenEnPosicion(int posicion) {
		
		this.aptitudEvaluada=false;
		int random1 = this.proceso.getRandomizer().nextInt(genes.length);
		
		Object genAux = this.genes[posicion];
		this.genes[posicion] =this.genes[random1];
		this.genes[random1] =genAux;
	}





        public String toString(){
            String str= "";         
            
            for (int i = 0; i < (genes.length); i++) {

              str+= " " + genes[i] + " ";
            }
            str+=this.evaluate();
            return str;
                  
        }
        
     public boolean equals(Object anObject) {
        if (this == anObject) {
            return true;
        }
        if (anObject instanceof CromosomaImp) {
            CromosomaImp anotherCrom = (CromosomaImp) anObject;
            Object[] genesDelOtro = anotherCrom.getGenes();
            
            for (int i = 0; i < genesDelOtro.length; i++) {
                if(genesDelOtro[i]!=genes[i])
                    return false;
                
            }
            return true;
        }
        return false;
    }
    
   

}

package implementacionEventos;

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
        crom.setGenes((Object[]) new Persona[personas.length]);
        crom.setProceso(this.proceso);
        
        return crom;
    }

    public InterfaceCromosoma crearCromosomaGenesLLenadosAlAzar() {
        

		
        CromosomaImp crom = new CromosomaImp();
        
        crom.setProceso(this.proceso);
        crom.setGenes( (Object[]) personas.clone());
        
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

