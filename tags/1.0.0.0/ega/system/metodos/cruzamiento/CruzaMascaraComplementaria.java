
package implementaciones;

import cromosoma.InterfaceCromosoma;
import java.util.ArrayList;
import java.util.List;
import operadores.CruzaPadresAleatoriosAbstracta;

public class CruzaMascaraComplementaria extends CruzaPadresAleatoriosAbstracta{

        //<param>

        public String mascara="101010101";
        
        //</param>
        
        private int arrayMascara[];
        
        
        
        
	protected List cruzar(List listaCromosomaPadres) {

		
		InterfaceCromosoma hijo1 = this.fabricaDeCromosomas.crearCromosomaGenesVacios();
		InterfaceCromosoma hijo2 = this.fabricaDeCromosomas.crearCromosomaGenesVacios();
                int cantGenes = hijo2.getCantidadDeGenes();
                
		 for (int i = 0; i < this.arrayMascara.length && i< cantGenes; i++) {
                                            
			hijo1.meterGenEn(i,(InterfaceCromosoma)listaCromosomaPadres.get(this.arrayMascara[i]) ,i );
			hijo2.meterGenEn(i,(InterfaceCromosoma)listaCromosomaPadres.get(1 - this.arrayMascara[i]) ,i );
			
		}	
		
		List listaCromosomasHijos= new ArrayList();
		
		listaCromosomasHijos.add(hijo1);
		listaCromosomasHijos.add(hijo2);
		
		
		return listaCromosomasHijos;
	}	

        
    public void parametrizate() {
                
                this.arrayMascara= new int[mascara.trim().length()];
    
                for (int i = 0; i < this.arrayMascara.length; i++) {
                     this.arrayMascara[i]= this.mascara.charAt(i)-'0';
                     
                     if(this.arrayMascara[i]!=0 && this.arrayMascara[i]!=1){
                         this.proceso.mensajeDeError("mascara no tiene un cero o uno", true, true, true);
                     }
                         
                }
    }
	



}
