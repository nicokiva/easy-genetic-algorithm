
package implementaciones;

import cromosoma.InterfaceCromosoma;
import java.util.ArrayList;
import java.util.List;
import operadores.CruzaPadresAleatoriosAbstracta;

public class CruzaMascaraDoble extends CruzaPadresAleatoriosAbstracta{

        //<param>

        public String mascara1="101010101";
        public String mascara2="000010101";

        //</param>
        
        private int arrayMascara1[];
       private int arrayMascara2[];

        
        
        
        
	protected List cruzar(List listaCromosomaPadres) {

		
		InterfaceCromosoma hijo1 = this.fabricaDeCromosomas.crearCromosomaGenesVacios();
		InterfaceCromosoma hijo2 = this.fabricaDeCromosomas.crearCromosomaGenesVacios();
                int cantGenes = hijo2.getCantidadDeGenes();
                
		 for (int i = 0; i < this.arrayMascara1.length && i< cantGenes; i++) {
                                            
			hijo1.meterGenEn(i,(InterfaceCromosoma)listaCromosomaPadres.get(this.arrayMascara1[i]) ,i );
			hijo2.meterGenEn(i,(InterfaceCromosoma)listaCromosomaPadres.get(this.arrayMascara2[i]) ,i );
			
		}	
		
		List listaCromosomasHijos= new ArrayList();
		
		listaCromosomasHijos.add(hijo1);
		listaCromosomasHijos.add(hijo2);
		
		
		return listaCromosomasHijos;
	}	

        
    public void parametrizate() {
                
                this.arrayMascara1= new int[mascara1.trim().length()];
    
                for (int i = 0; i < this.arrayMascara1.length; i++) {
                     this.arrayMascara1[i]= this.mascara1.charAt(i)-'0';
                     
                     if(this.arrayMascara1[i]!=0 && this.arrayMascara1[i]!=1){
                         this.proceso.mensajeDeError("mascara 1 no es cero o uno", true, true, true);
                     }
                         
                }
                
                     this.arrayMascara2= new int[mascara2.trim().length()];
    
                for (int i = 0; i < this.arrayMascara2.length; i++) {
                     this.arrayMascara2[i]= this.mascara2.charAt(i)-'0';
                     
                     if(this.arrayMascara2[i]!=0 && this.arrayMascara2[i]!=1){
                         this.proceso.mensajeDeError("mascara 2 no es cero o 1", true, true, true);
                     }
                         
                }
    }
	



}
