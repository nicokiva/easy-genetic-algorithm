package implementacionEventos;

import cromosoma.FuncionDeAptitud;
import cromosoma.InterfaceCromosoma;
import elementos.HelperInterface;

public class FuncionDeAptitudImpl implements FuncionDeAptitud{
    
   //<param>

    //</param>
    private Proceso proceso;
    private PersonasHelper helper;
    private Caracteristica[] caracteristicas;
    private int[] capacidadMesas;



	
	
	public int evaluar(InterfaceCromosoma cromosoma) {
		// TODO Auto-generated method stub
		Persona[] genes = (Persona[]) ((CromosomaImp) cromosoma).getGenes();
		int sum=0;
//                helper=this.proceso.getHelper();
//		PersonasHelper helper = ((PersonasHelper) );
		int primerTipoDelaMesa=0;
		int primerTipoMesaSiguiente=0;
                int hasta;
                for (int i = 0; i < this.capacidadMesas.length; i++) {
                
                primerTipoMesaSiguiente=this.capacidadMesas[i]+primerTipoDelaMesa;
//                hasta=primerTipoMesaSiguiente-1;     
                for (int j = primerTipoDelaMesa; j < primerTipoMesaSiguiente; j++) {
			
			for(int k = j + 1; k < primerTipoMesaSiguiente; k++) {
                            
                         
                            sum+=this.valorRelacion(genes[j],genes[k])/(k-j);
			
                       }	
			
		 
                }    
                           primerTipoDelaMesa=primerTipoMesaSiguiente;

                }

		return sum;
	}

    public void inicializate(Proceso proceso) {
       
        this.proceso=proceso;
        PersonasHelper helper= (PersonasHelper) proceso.getHelper();
        this.caracteristicas=helper.getCaracteristicas();
        Mesa[] mesas = helper.getMesas();
        this.capacidadMesas= new int[mesas.length];
        
        for (int i = 0; i < mesas.length; i++) {
            this.capacidadMesas[i]= mesas[i].getCapacidad();
            
        }
    }

    public void parametrizate() {
    
    }

    private int valorRelacion(Persona persona1, Persona persona2) {
           
        int[] carac1 = persona1.getCaracteristicas();
        int[] carac2 = persona2.getCaracteristicas();
        int sum=0;
        for (int i = 0; i < this.caracteristicas.length; i++) {
          if(carac1[i]!=-1 && carac2[i]!=-1){
              if(carac1[i]==carac2[i]){
                  sum+=this.caracteristicas[i].getIgualdad()*this.caracteristicas[i].getValor();
              }else{
                 sum+=this.caracteristicas[i].getDesigualdad()*this.caracteristicas[i].getValor();
 
              }
              
          }
            
        }
        return sum;
    }


	
	
}
