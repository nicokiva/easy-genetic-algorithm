package implementacionEv3;

import cromosoma.FuncionDeAptitud;
import cromosoma.InterfaceCromosoma;
import proceso.Proceso;

public class FuncionDeAptitudImpl implements FuncionDeAptitud{
    
    private Proceso proceso;
    private PersonasHelper helper;
    private Caracteristica[] caracteristicas;
    private int[] capacidadMesas;
    private int cantidadMesasReales;



	
    public int evaluar(InterfaceCromosoma cromosoma) {
		// TODO Auto-generated method stub
		Persona[] genes = (Persona[]) ((CromosomaImp) cromosoma).getGenes();
		int sum=0;
//                helper=this.proceso.getHelper();
//		PersonasHelper helper = ((PersonasHelper) );
		int primerTipoDelaMesa=0;
		int primerTipoMesaSiguiente=0;
                int hasta;
                for (int i = 0; i < cantidadMesasReales; i++) {
                
                primerTipoMesaSiguiente=this.capacidadMesas[i]+primerTipoDelaMesa;
//                hasta=primerTipoMesaSiguiente-1;     
                for (int j = primerTipoDelaMesa; j < primerTipoMesaSiguiente; j++) {
			
			for(int k = j + 1; k < primerTipoMesaSiguiente; k++) {
                            
                          if(genes[j]!=null && genes[k]!=null )
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
        if(helper.isMesaConExcesos()){
            this.cantidadMesasReales=mesas.length-1;
            
        }else{    
          this.cantidadMesasReales=mesas.length;
        }
        
        this.capacidadMesas= new int[cantidadMesasReales];
       
        
        for (int i = 0; i < cantidadMesasReales; i++) {
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
                sum+= persona1.valorRelacion(persona2)+persona2.valorRelacion(persona1);

        
        return sum;
    }


	
	
}
