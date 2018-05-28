package implementaciones;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import operadores.CruzaPadresAleatoriosAbstracta;



import cromosoma.InterfaceCromosoma;

public class CruzaMascaraComplementaria extends CruzaPadresAleatoriosAbstracta{

        //<param>

        public String param_mascara="101010101";
        
        //</param>
        private int mascara[];
        
        
        
        
	protected List cruzar(List listaCromosomaPadres) {

		
		InterfaceCromosoma hijo1 = this.fabricaDeCromosomas.crearCromosomaGenesVacios();
		InterfaceCromosoma hijo2 = this.fabricaDeCromosomas.crearCromosomaGenesVacios();
	
		 for (int i = 0; i < this.mascara.length; i++) {
                                            
			hijo1.meterGenEn(i,(InterfaceCromosoma)listaCromosomaPadres.get(this.mascara[i]) ,i );
			hijo2.meterGenEn(i,(InterfaceCromosoma)listaCromosomaPadres.get(1 - this.mascara[i]) ,i );
			
		}	
		
		List listaCromosomasHijos= new ArrayList();
		
		listaCromosomasHijos.add(hijo1);
		listaCromosomasHijos.add(hijo2);
		
		
		return listaCromosomasHijos;
	}	

        
    public void parametrizate() {
                
                this.mascara= new int[param_mascara.length()];
    
                for (int i = 0; i < this.mascara.length; i++) {
                     this.mascara[i]= this.param_mascara.charAt(i)-'0';
                     
                     if(this.mascara[i]!=0 || this.mascara[i]!=1){
                         System.err.println("ERROR EN MASCARA");
                     }
                         
                }
    }
	



}
