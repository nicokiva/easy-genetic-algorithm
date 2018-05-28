
package implementaciones;

import cromosoma.InterfaceCromosoma;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import operadores.CruzaPadresAleatoriosAbstracta;
import proceso.Proceso;

public class CruzaMultiPunto extends CruzaPadresAleatoriosAbstracta{
        
        //<param>
            public String param_cantidadDePuntos="1"; 
	//</param>
        
	private int cantidadDePuntos;
        
        
        
	
        public void inicializate(Proceso proceso)
	{
		super.inicializate(proceso);
		this.cantidadDePuntos=Integer.valueOf(param_cantidadDePuntos).intValue();
	}
        
        
	protected List cruzar(List listaCromosomaPadres) {

		InterfaceCromosoma hijo1 = this.fabricaDeCromosomas.crearCromosomaGenesVacios();
		InterfaceCromosoma hijo2 = this.fabricaDeCromosomas.crearCromosomaGenesVacios();
		
		int cantGenesCromosoma=((InterfaceCromosoma) listaCromosomaPadres.get(0)).getCantidadDeGenes();
		Set puntosDeCorte= new TreeSet();

                int contadorPuntos=0;
		
		while(contadorPuntos<this.cantidadDePuntos)
		{
			int puntoDeCorte = this.procesoRandomizer.nextInt(cantGenesCromosoma)+1;
			puntosDeCorte.add(Integer.valueOf(puntoDeCorte));
			contadorPuntos++;
		}
//		puntosDeCorte.add(Integer.valueOf(cantGenesCromosoma));
		
		int pos0=0,pos1=1;
		
		for (int i=0 ; i < cantGenesCromosoma ; i++ )
		{
			
			if(puntosDeCorte.contains(new Integer(i)))
			{	
				int aux;
				aux=pos0;
				pos0=pos1;
				pos1=aux;
			}
			
			hijo1.meterGenEn(i,(InterfaceCromosoma)listaCromosomaPadres.get(pos0) ,i );
			hijo2.meterGenEn(i,(InterfaceCromosoma)listaCromosomaPadres.get(pos1) ,i );
			
		}	
		
		List listaCromosomasHijos= new ArrayList();
		
		listaCromosomasHijos.add(hijo1);
		listaCromosomasHijos.add(hijo2);
		
		
		return listaCromosomasHijos;
	}

	
	

    public void parametrizate() {

    }


}
