package implementacionEventos;

import elementos.FormatoInformeInterface;
import java.util.ArrayList;
import java.util.LinkedList;
import proceso.Proceso;
import java.util.Iterator;
import java.util.List;
import java.util.Collections;
import util.ComparadorPorFDA;




public class InformeEventos implements FormatoInformeInterface {
    private Mesa[] mesas;
    
    //<param>
    public String mostrarRepetidos="N";
  public String orden="Descendiente";
        public String cantidadMostrar="10";
    //</param>
    
    private int nombreMasLargo;
    private int largoCampo;
    private int cantDeColumnas;
    private boolean eliminarRepetidos=true;
    private Caracteristica[] caract;
	    private int faltantes;
    private boolean ascendente;
  
    public List ejecutar(List listaCromosomas) {

        Iterator it = listaCromosomas.iterator();
        List listaStrings = new LinkedList();
        int count=0;
        List cromosomasParaResultado=new ArrayList();
Collections.sort(listaCromosomas, new ComparadorPorFDA(this.ascendente));
		
        while (it.hasNext() && this.faltantes > count ) {


            CromosomaImp crom = (CromosomaImp) it.next();
           if(eliminarRepetidos && !cromosomasParaResultado.contains(crom)) {

             cromosomasParaResultado.add(crom);  
             Persona[] personas = (Persona[]) crom.getGenes();
           
           listaStrings.add("PROPUESTA DE SOLUCION Nº: "+ ++count+"  -  PUNTAJE: "+crom.evaluate());
           int primerTipoDeLaMesa=0,primerTipoMesaSig=0;
	 String relleno = "                    ";
	 String separador = "  "; // separo columnas con 2 espacios
	 String LineaMedia = "=============================================";
 	 String LineaCompleta = 
          "========================================================================================================";
           String sAux = null;
           int iLongitudCampo=0;

// EJEMPLO
//15             __7      __9        __3  __7      __7      __5    __4   __5    __4   __5    __4   __5
//==============================================   MESA 4   ==============================================
//NOMBRE           EDAD     RELIGION   POL  CLUB     MUSICA   IQ     FLIA  PAIS   IDMS  GASTR  ENOL  CULT
//========================================================================================================

	 // recorro todas las mesas
           for (int i = 0; i < this.mesas.length; i++) {
            
               listaStrings.add(LineaMedia + "   " + this.mesas[i].getNombre().toUpperCase() + "   " + LineaMedia); listaStrings.add("NOMBRE           EDAD     RELIGION   POL  CLUB     MUSICA   IQ     FLIA  PAIS   IDMS  GASTR  ENOL  CULT");
	    listaStrings.add(LineaCompleta);

               primerTipoMesaSig = primerTipoDeLaMesa + this.mesas[i].getCapacidad();

	     // recorro todas las personas de la mesa i
               for (int j = primerTipoDeLaMesa; j < primerTipoMesaSig ; j++) 
	     {
                   String str=personas[j].getNombre() + relleno;
	         str = str.substring(0, 15);
                   int[] caracteristicas = personas[j].getCaracteristicas();
                    
                   // recorro todas las carectaristicas de la persona j en la mesa i
                   for(int z=0; z<caracteristicas.length; z++)
	         {
        		   switch (z)
		   {
                            case 0:
		        iLongitudCampo = 7; // edad
	                  break;

                            case 1:
		        iLongitudCampo = 9; //
	                  break;
	
                            case 2:
		        iLongitudCampo = 3;
	                  break;

                            case 3:
		        iLongitudCampo = 7;
	                  break;

                            case 4:
		        iLongitudCampo = 7;
	                  break;

                            case 5:
		        iLongitudCampo = 5;
	                  break;

                            case 6:
		        iLongitudCampo = 4;
	                  break;

                            case 7:
		        iLongitudCampo = 5;
	                  break;

                            case 8:
		        iLongitudCampo = 4;
	                  break;

                            case 9:
		        iLongitudCampo = 5;
	                  break;

                            case 10:
		        iLongitudCampo = 4;
	                  break;

                            case 11:
		        iLongitudCampo = 5;
	                  break;
		  }

		   sAux = this.caract[z].obtenerNombreValor(caracteristicas[z]) + relleno;
		   sAux = sAux.substring(0, iLongitudCampo);
                       str+= separador + sAux;
                   }
                       
                   listaStrings.add(str);
               }
               
               listaStrings.add(" ");
               primerTipoDeLaMesa = primerTipoMesaSig;
          }
           
          listaStrings.add(" ");
        }
          
        }


        return listaStrings;

    }

    public void inicializate(Proceso proceso) {
      
      PersonasHelper helper= (PersonasHelper) proceso.getHelper();
      this.mesas = helper.getMesas();
	 this.caract=helper.getCaracteristicas();
      this.largoCampo=helper.getMaxNombre()+1;
      this.cantDeColumnas=  80/this.largoCampo;
	
	 this.faltantes= Integer.valueOf(this.cantidadMostrar).intValue();
      
      if(this.orden.startsWith("D"))
       this.ascendente=false;
      else
       this.ascendente=true;                                                        
    }

    public void parametrizate() {
        if(mostrarRepetidos.toUpperCase().startsWith("S")){
         eliminarRepetidos=false;    
        }
    }
}
