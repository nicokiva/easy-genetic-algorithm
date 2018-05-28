package implementacionEv3;

import elementos.FormatoInformeInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.List;
import java.util.Collections;
import util.ComparadorPorFDA;

//por ahoa la interfaz no tiene nada . La iremos definiendo
public class InformeDePrueba1 implements FormatoInformeInterface {
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
        
        while (it.hasNext() && this.faltantes > count) {


            CromosomaImp crom = (CromosomaImp) it.next();
           if(eliminarRepetidos && !cromosomasParaResultado.contains(crom) ) {
           
             cromosomasParaResultado.add(crom);  
             Persona[] personas = (Persona[]) crom.getGenes();
           
           listaStrings.add("Solucion Propuesta "+ ++count+" Puntaje "+crom.evaluate());
           int primerTipoDeLaMesa=0,primerTipoMesaSig=0;
           for (int i = 0; i < this.mesas.length; i++) {
            
               listaStrings.add(this.mesas[i].getNombre());
               listaStrings.add(" ");

               primerTipoMesaSig=primerTipoDeLaMesa+this.mesas[i].getCapacidad();
               
             
               for (int j = primerTipoDeLaMesa; j < primerTipoMesaSig ; j++) {
                  
                   String str=personas[j].getNombre()+"     :";
                   int[] caracteristicas = personas[j].getCaracteristicas();
                    
                   for(int z=0;z<caracteristicas.length;z++){
                       str+=" "+this.caract[z].obtenerNombreValor(caracteristicas[z]);
                   
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
