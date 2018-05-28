package implementacionEventos;

import elementos.HelperInterface;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import proceso.Proceso;

public class PersonasHelper implements HelperInterface{
//	String[] personas = {"PePe","Paco","Ana","Maria","Pablo","Anaconda","Pepita","Anatomia"};
    private Proceso proceso;
    private Persona[] personas;
    private Caracteristica[] caracteristicas;
    private Mesa[] mesas;
    private int maxNombre;
    
    //<param>
    public String path= "inf/info.csv";
    //</param>
    
    
    public Persona[] getPersonas() {
        return personas;
    }

    public Caracteristica[] getCaracteristicas() {
        return caracteristicas;
    }

    public Mesa[] getMesas() {
        return mesas;
    }

	
//	private Random solucionRandomizer;

//	
//	public String getRandomPerson(){
//		 
//		 return personas[this.solucionRandomizer.nextInt(personas.length)];
//	}
//	
//	public String[] getPersonas(){
//		
//		 return (String[]) personas.clone();
//		 
//	}

	public int valorRelacion(String string, String string2) {
		// TODO Auto-generated method stub
		if(string.equals(string2))
			return -10;
			
		if (string.startsWith(string2.substring(0, 1)))
			return 10;
		
		return 0;
	}

   private  BloqueDeInfo comienzoDeBloque(List listaBloquesDeInfoFaltantes, String strLine) {
        int index;
        
        Iterator bloquesFaltantesIterator = listaBloquesDeInfoFaltantes.iterator();
        
        while(bloquesFaltantesIterator.hasNext()){
            
            BloqueDeInfo bloque= (BloqueDeInfo) bloquesFaltantesIterator.next();
            index = strLine.indexOf(bloque.titulo);
            
            if (index > -1) {
                bloquesFaltantesIterator.remove();
                return    bloque;

            }
        }
        return null;
    }

  



    
     
    

    
    
private void llenarBloquesDeInfo(List listaBloquesDeInfo, String path) {
        
        String strLine;
        List listaBloquesDeInfoFaltantes= new LinkedList();
        listaBloquesDeInfoFaltantes.addAll(listaBloquesDeInfo);
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            
            BloqueDeInfo bloqueInfoActual=null;
            
            while (bloqueInfoActual==null && ((strLine = br.readLine()) != null) ) {
                bloqueInfoActual = comienzoDeBloque(listaBloquesDeInfoFaltantes, strLine);
                
            }
            if(bloqueInfoActual==null){
//                this.proceso.mensaje
                  return;  
            }
            
            BloqueDeInfo bloqueNuevo;
            while (((strLine = br.readLine()) != null)) {
                
                bloqueNuevo=comienzoDeBloque(listaBloquesDeInfoFaltantes, strLine);
                if(bloqueNuevo==null){
                    String dato= strLine.trim();
                    if(!dato.isEmpty()){
                        
                        bloqueInfoActual.datos.add(dato);
                    }
                }else{
                    bloqueInfoActual=bloqueNuevo;
                    
                }
                       
             }
            
            br.close();
 
            
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void mesas(BloqueDeInfo bloqueMesas) throws NumberFormatException {
        int cantidadDeMesas = bloqueMesas.datos.size();
 
        Iterator pondMesasIt = bloqueMesas.datos.iterator();
        ArrayList mesas= new ArrayList();
//        this.mesas= new Mesa[cantidadDeMesas];
     
        
        while(pondMesasIt.hasNext()){
                
            String infoCarac =(String) pondMesasIt.next();
            String[] mesaCant=infoCarac.split(";");
            if( mesaCant.length!=0 ){
            
             if(mesaCant.length!=2 ){
               this.proceso.mensajeDeError("Se esperaba el sigo ; ", true, false, false); 
            }
       
        
                String nombreMesa=mesaCant[0].trim();
                
                mesas.add(new Mesa(nombreMesa,Integer.valueOf(mesaCant[1].trim()).intValue()));
//                this.mesas[posMesa++] = new Mesa(nombreMesa,Integer.valueOf(mesaCant[1].trim()).intValue());
                mayorNombreDeMesaOPersona(nombreMesa);
            }
        }
        
        this.mesas= new Mesa[mesas.size()];
        Iterator it = mesas.iterator();
           int posMesa=0;
        while(it.hasNext()){
            this.mesas[posMesa]= (Mesa) it.next() ;
            posMesa++;
        }
            
    }

    private int caracteristicas(BloqueDeInfo bloquePonderacionCaracteristicas) throws NumberFormatException {
        
        ArrayList caract= new ArrayList();
//        int cantidadDeCaract = bloquePonderacionCaracteristicas.datos.size();
        Iterator pondCaracIt = bloquePonderacionCaracteristicas.datos.iterator();
//        this.caracteristicas= new Caracteristica[cantidadDeCaract];
//        int posCarac=0;
        
        while(pondCaracIt.hasNext()){
                
            String infoCarac =(String) pondCaracIt.next();
            String[] caracPonderacion=infoCarac.split(";");
           
         if( caracPonderacion.length!=0 ){
            
            if(caracPonderacion.length!=3){
               this.proceso.mensajeDeError("Se esperaba el signo ; ", true, false, false); 
            }
            
            Boolean igualdad= null;
            String igualdadODesigualdad = caracPonderacion[2].trim();
            
            if(igualdadODesigualdad.length() > 0){
                char primerLetra=igualdadODesigualdad.charAt(0);

                if(primerLetra=='I' || primerLetra == 'i'){
                   igualdad = Boolean.TRUE;
               } else if(primerLetra=='D' ||primerLetra=='d'){
                   igualdad= Boolean.FALSE;
               }
                
            }else{
               igualdad = Boolean.FALSE;
            }
            
            if(igualdad == null){
                
               this.proceso.mensajeDeError("Mal ingresado la desigualdad o igualdad ", true, false, false); 
            }
            
            caract.add(new Caracteristica(caracPonderacion[0],Integer.valueOf(caracPonderacion[1].trim()).intValue(),igualdad));
//            this.caracteristicas[posCarac++] = new Caracteristica(caracPonderacion[0],Integer.valueOf(caracPonderacion[1].trim()).intValue(),igualdad);
            
          }
        }
        this.caracteristicas= new Caracteristica[caract.size()];
        Iterator it = caract.iterator();
        int posCarac=0;
        while(it.hasNext()){
            this.caracteristicas[posCarac]= (Caracteristica) it.next() ;
            posCarac++;
        }
        

        
        
        
        return this.caracteristicas.length;
    }

    private void personas(BloqueDeInfo bloquePersonas, int cantidadDeCaract) {
         int capacidadTotal=0;
         for (int i = 0; i < mesas.length; i++) {
            capacidadTotal+= mesas[i].getCapacidad();
            
        }
        
  
        
        Iterator infoPersonasIterator = bloquePersonas.datos.iterator();
//        this.personas = new Persona[bloquePersonas.datos.size()] ;
        int posicion=0;
        
       ArrayList listaPers= new ArrayList();
        
        while(infoPersonasIterator.hasNext()){
            String infoPer= (String) infoPersonasIterator.next();
            String[] nombreYAtributos=infoPer.split(";");
           if( nombreYAtributos.length!=0 ){
//            if(nombreAtributos.length!=2){
//    //         this.proceso.errorrrr
//               this.proceso.mensajeDeError("Se esperaba el sigo : ", true, false, false); 
//            }
            
//            String[] valorCaracteristica = nombreYAtributos[1];
           
            
            if(nombreYAtributos.length!=cantidadDeCaract+1){
    //         this.proceso.errorrrr
               this.proceso.mensajeDeError("Falta algun atributo o no fue escrita correctamente la persona", true, false, false); 
            }
            
            int[] codigoValorCaraceristica= new int[cantidadDeCaract];
            
            for (int i = 0; i < cantidadDeCaract; i++) {
                
                codigoValorCaraceristica[i]=this.caracteristicas[i].agregarValor(nombreYAtributos[i+1]);
            
            }
            String nombrePersona = nombreYAtributos[0].trim();
//            this.personas[posicion] = new Persona(nombrePersona,codigoValorCaraceristica,posicion); 
            
            listaPers.add( new Persona(nombrePersona,codigoValorCaraceristica,posicion));
            posicion++;
            mayorNombreDeMesaOPersona(nombrePersona);
            }
        }
         if(capacidadTotal!=listaPers.size()){
              this.proceso.mensajeDeError("Capacidad total mesas distinta a cantidad de personas", true, false, false); 
         }
         
        this.personas= new Persona[listaPers.size()];
        Iterator it = listaPers.iterator();
        int i=0;
        while(it.hasNext()){
            this.personas[i]= (Persona) it.next() ;
            i++;
        }
    }

    private void mayorNombreDeMesaOPersona(String nombre) {
        if(nombre.length()>this.maxNombre){
            this.maxNombre=nombre.length();
        }
    }

    public int getMaxNombre() {
        return maxNombre;
    }

 

    private  class BloqueDeInfo {
        private String titulo;
        
        private List datos;
        
        public BloqueDeInfo() {
            this.datos=new LinkedList();
        }

        private BloqueDeInfo(String titulo) {
            this.titulo=titulo;
            this.datos=new LinkedList();
        }

   
    }

    
    public void inicializate(Proceso proceso) {
        this.proceso=proceso;    
    
        List bloqueInfoList= new LinkedList();
    
        BloqueDeInfo bloqueMesas = new BloqueDeInfo("Mesas");
        BloqueDeInfo bloquePonderacionCaracteristicas = new BloqueDeInfo("Caracteristicas");
         BloqueDeInfo bloquePersonas = new BloqueDeInfo("Nombre");

    bloqueInfoList.add(bloqueMesas);
    bloqueInfoList.add(bloquePonderacionCaracteristicas);
    bloqueInfoList.add(bloquePersonas);
    llenarBloquesDeInfo(bloqueInfoList,this.path);
    
    mesas(bloqueMesas);
    int cantidadDeCaract = caracteristicas(bloquePonderacionCaracteristicas);
    personas(bloquePersonas, cantidadDeCaract);
    
    }

    public void parametrizate() {
    }

}


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implementacionEventos;

/**
 *
 * @author leop
 */
public class Persona {
    private final int[] caracteristicas;
    private final String nombre;
    private final int posicionEnArrayPrincipal;

    public int getPosicionEnArrayPrincipal() {
        return posicionEnArrayPrincipal;
    }

    Persona(String nombrePersona, int[] codigoValorCaraceristica, int posicion) {
        this.nombre=nombrePersona;
        this.caracteristicas=codigoValorCaraceristica;
        this.posicionEnArrayPrincipal=posicion;
    }

  
    
    public int[] getCaracteristicas() {
        return caracteristicas;
    }

    public String getNombre() {
        return nombre;
    }


    public String toString() {
        return this.nombre;
    }
    
    
}


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implementacionEventos;

/**
 *
 * @author leop
 */
public class Mesa {
    
    private final String nombre;

    public String getNombre() {
        return nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }
    private final int capacidad;

    public Mesa(String nombre, int intValue) {
        this.nombre=nombre;
        this.capacidad=intValue;
    }



 
    
}


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implementacionEventos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author leop
 */
public class Caracteristica  {
    
    
    private final String nombre;
    private final int valor;
    private final int igualdad;
    private final int desigualdad;
    private List setCaracteristicas;
    private static final String EMPTY="";

    public String getNombre() {
        return nombre;
    }

    public int getValor() {
        return valor;
    }

    public int getIgualdad() {
        return igualdad;
    }

    public int getDesigualdad() {
        return desigualdad;
    }


    public Caracteristica(String nombre, int intValue, Boolean igualdad) {
        this.nombre=nombre;
        this.valor=intValue;
        this.setCaracteristicas= new ArrayList();
        
        
        if(igualdad){
           this.igualdad=1;
           this.desigualdad=0;
         }else{
            this.igualdad=0;
           this.desigualdad=1;
        }
    }

    int agregarValor(String string) {
        
        
        String strTrim=string.trim();
        if(strTrim.equals(EMPTY)){
            return -1;
        }
            
        int index=this.setCaracteristicas.indexOf(strTrim);
        
        if(index>-1){
            return index;
        
        }else{
            this.setCaracteristicas.add(strTrim);
            //aca me jugue a que es asi
            return this.setCaracteristicas.size()-1;
        }
    }
	
   public String obtenerNombreValor(int i) {
        return (String) this.setCaracteristicas.get(i);
    }
    
}
