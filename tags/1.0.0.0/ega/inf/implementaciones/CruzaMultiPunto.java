package implementaciones;

import cromosoma.FabricaDeCromosomasInterface;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import operadores.CruzaPadresAleatoriosAbstracta;



import cromosoma.InterfaceCromosoma;
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
//		puntosDeCorte.add(Integer.valueOf(0));
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

	
	
//	private List cruzar(List listaCromosomaPadres) {
//
//		// TODO Auto-generated method stub
//		Cromosoma papa = (Cromosoma) listaCromosomaPadres.get(0);
//		Cromosoma mama = (Cromosoma) listaCromosomaPadres.get(1);
//		Cromosoma hijo1 = ManejadorDeElementos.newCromosoma();
//		Cromosoma hijo2 = ManejadorDeElementos.newCromosoma();
//		
//		int cantGenesCromosoma=papa.cantidadGenes();
//		//array con los puntos de corte
//		int[] puntosDeCorte= new int[this.cantidadDePuntos+2];
//		int puntoDeCorte;
//		int cantidadEltos;
//		
//		puntosDeCorte[0]=0;
//		for ( int i = 1 ; i < puntosDeCorte.length ; i++ ) 
//		{
//			puntosDeCorte[i]=puntosDeCorte.length;
//		}
//		for ( int i = 0 ; i < puntosDeCorte.length ; i++ ) 
//		{
//			int posicionAinsertar=0;
//			puntoDeCorte = ((int) Math.random() * (cantGenesCromosoma-1))+1;
//			
//			while(puntoDeCorte>puntosDeCorte[posicionAinsertar])
//				posicionAinsertar++;
//			
//			if(puntosDeCorte[posicionAinsertar]!=puntoDeCorte)
//			{
//				for ( int j = puntosDeCorte.length ; j > posicionAinsertar ; j-- ) 
//				{
//					puntosDeCorte[j]=puntosDeCorte[j-1];
//				}	
//				puntosDeCorte[posicionAinsertar]= puntoDeCorte;
//				
//				cantidadEltos++;
//			}	
//		}
//		
//		Set puntosDeCorte= new TreeSet();
//		puntosDeCorte.add(Integer.valueOf(0));
//		int contadorPuntos=0;
//		
//		while(contadorPuntos<this.cantidadDePuntos)
//		{
//			int puntoDeCorte = ((int) Math.random() * (cantGenesCromosoma-1))+1;
//			puntosDeCorte.add(Integer.valueOf(puntoDeCorte));
//			contadorPuntos++;
//		}
//		puntosDeCorte.add(Integer.valueOf(cantGenesCromosoma));
//		
//		int pos0=0,pos1=1;
//		
//		for (int i=0 ; i < cantGenesCromosoma ; i++ )
//		{
//			
//			if(puntosDeCorte.contains(new Integer(i)))
//			{	
//				int aux;
//				aux=pos0;
//				pos0=pos1;
//				pos1=aux;
//			}
//			
//			hijo1.meterGenEn(i,(Cromosoma)listaCromosomaPadres.get(pos0) ,i );
//			hijo2.meterGenEn(i,(Cromosoma)listaCromosomaPadres.get(pos1) ,i );
//			
//		}	
//		
//		List listaCromosomasHijos= new ArrayList();
//		
//		listaCromosomasHijos.add(hijo1);
//		listaCromosomasHijos.add(hijo2);
//		
//		
//		return listaCromosomasHijos;
//	}

    public void parametrizate() {
	  //      throw new UnsupportedOperationException("Not supported yet.");
    }


}
