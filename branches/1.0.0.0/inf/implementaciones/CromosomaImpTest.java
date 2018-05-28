
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implementaciones;

import cromosoma.FabricaDeCromosomasInterface;
import cromosoma.InterfaceCromosoma;
import java.util.Random;
import poblacion.Poblacion;
import solucion.Solucion;

/**
 *
 * @author leop
 */
public class FabricaCromosomasPersonas implements FabricaDeCromosomasInterface{
    private Solucion solucion;
    
        
    
    String[] personas = {"PePe","Paco","Ana","Maria","Pablo","Anaconda","Pepita","Anatomia"};
	
    private Random solucionRandomizer;


    public void inicializate(Solucion solucion) {
		// TODO Auto-generated method stub
		this.solucionRandomizer = solucion.getRandomizer();

    }
    
    
         
    public InterfaceCromosoma crearCromosomaGenesVacios() {
        CromosomaImp crom = new CromosomaImp();
        crom.setGenes(new String[personas.length]);
        
        return crom;
    }

    public InterfaceCromosoma crearCromosomaGenesLLenadosAlAzar() {
        

		
        CromosomaImp crom = new CromosomaImp();
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

    public void parametrizate() {
    }


}


