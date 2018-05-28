package implementaciones;

import java.util.Random;

import poblacion.Poblacion;
import cromosoma.CromosomaAbstractoGenesObject;
import cromosoma.FuncionDeAptitud;

public class CromosomaImp extends CromosomaAbstractoGenesObject{
	
	
	protected  String[] genes;
        
 
        
	public void mutaGenEnPosicion(int posicion) {
		
		this.aptitudEvaluada=false;
		int random1 = this.proceso.getRandomizer().nextInt(genes.length);
		
		String genAux = this.genes[posicion];
		this.genes[posicion] =this.genes[random1];
		this.genes[random1] =genAux;
	}

//	public void generate() {
//
//		PersonasHelper helper = (PersonasHelper) getSolucion().getHelper();
//		Random solucionRandomizer = getSolucion().getRandomizer();
//		
//		this.genes = helper.getPersonas();
//		int random1;
//		int random2;
//			
//		for (int i = 0; i < (this.genes.length/2); i++) {
//			
//			random1 = solucionRandomizer.nextInt(genes.length);
//			String genAux = this.genes[random1];
//			random2 = solucionRandomizer.nextInt(genes.length);
//			this.genes[random1]=this.genes[random2];
//			this.genes[random2]=genAux;
//		}
//		
////		System.out.println("generate de "+ this +": ");
////		for (int i = 0; i < (this.genes.length); i++) {
////			System.out.print(" "+ this.genes[i] +" ");
////		}
////		System.out.println();
//
//	}

	public String[] getGenes() {
		// TODO Auto-generated method stub
		return this.genes;
	}

        void setGenes(String[] arrayString) {
            genes=arrayString;
        }



}

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
	
    private Random procesoRandomizer;
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
			
            random1 = procesoRandomizer.nextInt(genes.length);
            String genAux = genes[random1];
            random2 = procesoRandomizer.nextInt(genes.length);
            genes[random1]=genes[random2];
            genes[random2]=genAux;
        }
                
         return crom;       
		
    }

    public void inicializate(Proceso proceso) {
         this.proceso=proceso;
         this.procesoRandomizer=proceso.getRandomizer();
    }

    public void parametrizate() {

    }



}

