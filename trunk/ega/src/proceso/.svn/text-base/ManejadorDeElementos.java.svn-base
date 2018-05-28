/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proceso;

import Methods.Method;
import Methods.Param;
import Solutions.Solution;
import comp.Compilador;
import elementos.ElementoParametrizable;
import Presentacion.Auxiliares.file_handler;
import Presentacion.Auxiliares.functions;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.codehaus.commons.compiler.CompileException;

/**
 *
 * @author leop
 */
class ManejadorDeElementos {
        
        private final Proceso proceso;
    
     	private final static String nombrePaquete="implementacion";
        
        private int numeroPaquete=0;
                
    
	
	


	private Compilador compilador;

	private Map<Class, Class> mapaInterfazClaseImplementacion;

        
        private Map<Class, ElementoParametrizable> mapaInterfazElementoInstanciado= new HashMap<>();
        


        public ManejadorDeElementos(Proceso aThis) {
            this.proceso=aThis;
            this.compilador=new Compilador();
        }



 
	
        
        public boolean usa(Solution  configSolution) {
		
		this.compilador= new Compilador();
		
		this.mapaInterfazClaseImplementacion= new HashMap<Class, Class>();
                
                 
                ArrayList<Method> listaMetodos = configSolution.getArrMethods();
                Set<Class> setInterfaces= new HashSet<>();
                
                List<String> paths= new ArrayList<>();
                
                for(Method metodo : listaMetodos){
                    Class interfaz = metodo.getInterfazParametrizable();     
                    
                        
                        setInterfaces.add(interfaz);
                        paths.add(metodo.getPath());
                        Set<Class> otrasInterfaces = metodo.getOtrasInterfacesQueDebeImplementar();
                        if(otrasInterfaces!=null){   
                            
                            for(Class clase : otrasInterfaces){
                                 setInterfaces.add(interfaz);
                            }
                        }       
                    
                }
                 
                String nombre= nombrePaquete + String.valueOf(numeroPaquete++);
                
		List<Class> listaClases;
                 StringBuilder strBuild=null;
                try {
                 strBuild = Compilador.armarUnidadDeCompilacion(paths,nombre );
                  listaClases = this.compilador.compilar(strBuild.toString());

                } catch (FileNotFoundException ex) {
                        this.proceso.mensajeDeError("No se encontro un path"+ex.getMessage(), true, true, true);
                        this.proceso.mensajeDeError("Stack trace "+functions.armarStackTrace(ex), true, true, true);
                                return false;
                } catch (IOException ex) {
                         this.proceso.mensajeDeError("Message :"+ex.getMessage(), true, true, true);
                         this.proceso.mensajeDeError("Stack trace "+functions.armarStackTrace(ex), true, true, true);

                                return false;
                } catch (CompileException ex) {
                    String ruta="system/erroresCompilacion/"+nombre+".txt";
                    strBuild.append(ex.getMessage());
                    file_handler filehand = new file_handler();
                    filehand.setPathFileToWrite(ruta);
                    filehand.setText(strBuild.toString());
                    filehand.Write();
                    StringBuilder strBuildMsg= new StringBuilder();
                    strBuildMsg.append(ex.getMessage());
                    strBuildMsg.append('\r');
                    strBuildMsg.append('\n');
                    strBuildMsg.append("Look at: "+ruta);
                    this.proceso.mensajeDeError(strBuildMsg.toString(), true, true, true);
                    return false;

                }
                
                
//                try {
//                    listaClases = this.compilador.compilar(paths, nombre);
//                } catch (FileNotFoundException ex) {
//                                this.proceso.mensajeDeError("No se encontro un path"+ex.getMessage(), true, true, true);
//                                return false;
//                } catch (IOException ex) {
//                                this.proceso.mensajeDeError(ex.getMessage(), true, true, true);
//                                return false;
//                } catch (CompileException ex) {
//                                this.proceso.mensajeDeError(ex.getMessage(), true, true, true);
//                                return false;
//                }
		
               List<Class> listaImplementacionesFaltantes = agregarClasesQueImplementan(
               this.mapaInterfazClaseImplementacion, setInterfaces, listaClases);
                

		if(!listaImplementacionesFaltantes.isEmpty()){
			this.proceso.mensajeDeError("Faltan implementar", true, true, true);
                        return false;
		}
		
//                ArrayList<ElementoParametrizable> objetosInstanciados = new ArrayList<>(8);
                ElementoParametrizable[] arrayEltoParametriza= new ElementoParametrizable[8];
                for(Method metodo : listaMetodos){
                     Class interfaz = metodo.getInterfazParametrizable();     
                    
                        ElementoParametrizable eltoParametrizable = instanciarObjetoQueImplementa(interfaz);
                        
                        if(!meterConReflection(metodo.getParams(),eltoParametrizable)){
                            return false;
                        }
                        
                        
                        arrayEltoParametriza[metodo.getSecuencia()]=eltoParametrizable;
//                        objetosInstanciados.add(metodo.getSecuencia(), eltoParametrizable);
                        this.mapaInterfazElementoInstanciado.put(interfaz, eltoParametrizable);
                    
                     
                }
                
                this.proceso.llenarElementos();
                
//                for(ElementoParametrizable eltoParametrizable : objetosInstanciados){
                  for( int i = 0; i<arrayEltoParametriza.length;i++) {
                    try{
                        
                        if(arrayEltoParametriza[i]!=null){
                        arrayEltoParametriza[i].inicializate(this.proceso); 
                        }
                    } catch (Exception ex) {
                
                        this.proceso.mensajeDeError("Mesagge: "+ex.getMessage(),true,false,false); 
                        this.proceso.mensajeDeError("Stack trace "+functions.armarStackTrace(ex), true, true, true);
                        this.proceso.vaciarElementos();
                        return false;
                    }  
                    
                     
                }
                
                  for( int i = 0; i<arrayEltoParametriza.length;i++) {
                    
                    try{
                                    if(arrayEltoParametriza[i]!=null){
                        arrayEltoParametriza[i].parametrizate();  
                        }
                                       
                    } catch (Exception ex) {
                
                        this.proceso.mensajeDeError("Mesagge: "+ex.getMessage(),true,false,false); 
                        this.proceso.mensajeDeError("Stack trace "+functions.armarStackTrace(ex), true, true, true);
                        this.proceso.vaciarElementos();
                        return false;
                    }      
                    
                     
                } 
                
                
                return true;
	}
        
        
//	public void armate(List<String> paths, Set<Class> setInterfaces) {
//		
//		this.compilador= new Compilador();
//		
//		this.mapaInterfazClaseImplementacion= new HashMap<Class, Class>();
//		
//		List<Class> listaImplementacionesFaltantes = this.compilador.compilarYllenarMapaConImplementaciones(paths, "solucionHarcodeada", this.mapaInterfazClaseImplementacion
//				, setInterfaces);
//		
//		//TODO ERROR
//		if(!listaImplementacionesFaltantes.isEmpty()){
//			System.out.println("Faltan implementar");
//			return;
//		}
//		
//	}	
	
	public void armateParaPruebas(Map<Class, Class> mapa) {
		
		this.compilador= new Compilador();
		
		this.mapaInterfazClaseImplementacion= mapa;
		
	
		
	}	
	

                       
 
	private ElementoParametrizable instanciarObjetoQueImplementa(Class name) {
		// TODO Auto-generated method stub
		ElementoParametrizable eltoParametrizable=null;
		
		try {
			
			 eltoParametrizable = (ElementoParametrizable) this.mapaInterfazClaseImplementacion.get(name).newInstance();
                          
                         
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return eltoParametrizable;
	}



    private boolean meterConReflection(List<Param> params, Object obj) {
         
        for(Param parametro:params){
                         
            try {
                Field fld = obj.getClass().getField(parametro.getName());
                fld.set(obj, parametro.getValue().trim());
           
            } catch (Exception ex) {
                
                this.proceso.mensajeDeError(ex.getMessage(),true,false,false); 
                return false;
            }
        }
        return true;
        
         
           
          
    }
    
    
        public List<Class> agregarClasesQueImplementan(
            Map<Class, Class> mapaInterfazClaseImplementacion,
            Set<Class> setInterfaces, List<Class> listaClases) {
        //		Set<Class> setInterfaces = new HashSet<Class>();

        //		setInterfaces.add(Inter7.class);
        //		setInterfaces.add(NoInteresa.class);

        //Clase interna al metodo
        class ClaseMasHija {

            private Class claseActual;
            private int nivelEnJeraquiaClaseActual = -1;

            public void add(Class clase2) {
                if (this.claseActual == null) {
                    this.claseActual = clase2;
                } else {
                    if (this.nivelEnJeraquiaClaseActual == -1) {

                        this.nivelEnJeraquiaClaseActual = calcularNivelEnJeraquia(this.claseActual);
                    }
                    int nivelNuevaClase = calcularNivelEnJeraquia(clase2);

                    if (nivelNuevaClase > this.nivelEnJeraquiaClaseActual) {
                        this.claseActual = clase2;
                        this.nivelEnJeraquiaClaseActual = nivelNuevaClase;

                    }
                }

            }

            private int calcularNivelEnJeraquia(Class claseActual2) {
                // TODO Auto-generated method stub
                int distanciaAObject = 0;

                while (claseActual2 != null) {
                    ++distanciaAObject;
                    claseActual2 = claseActual2.getSuperclass();
                }

                return distanciaAObject;
            }
        }

        Map<Class, ClaseMasHija> mapaImplementacionClases = new HashMap<Class, ClaseMasHija>();


        for (Class clase : listaClases) {

            Class interfaceAlaQuePertenece = null;
            Class clasePadre = clase;

            while (clasePadre != null && interfaceAlaQuePertenece == null) {

                interfaceAlaQuePertenece = buscarInterface(clasePadre, setInterfaces);
                clasePadre = clasePadre.getSuperclass();
            }

            if (interfaceAlaQuePertenece != null) {

                ClaseMasHija clasePosible = mapaImplementacionClases.get(interfaceAlaQuePertenece);

                if (clasePosible == null) {

                    clasePosible = new ClaseMasHija();
                    clasePosible.add(clase);
                    mapaImplementacionClases.put(interfaceAlaQuePertenece, clasePosible);
                } else {
                    clasePosible.add(clase);
                }
            }
        }

        //		Map<Class, Class> mapaInterfazClaseImplementacion= new HashMap<Class,Class>();
        List<Class> listaInterfasSinClaseImplementada = new LinkedList<Class>();

        for (Class interfaz : setInterfaces) {
            ClaseMasHija claseMasHija = mapaImplementacionClases.get(interfaz);
            if (claseMasHija == null) {
                listaInterfasSinClaseImplementada.add(interfaz);
            } else {
                mapaInterfazClaseImplementacion.put(interfaz, claseMasHija.claseActual);
            }
        }
        return listaInterfasSinClaseImplementada;
    }
    
        
        private Class buscarInterface(Class clase, Set<Class> listaInterfaces) {
        // TODO Auto-generated method stub

        if (listaInterfaces.contains(clase)) {
            return clase;
        }

        Class[] interfaces = clase.getInterfaces();
        Class claseAdevolver;

        for (int i = 0; i < interfaces.length; i++) {

            claseAdevolver = buscarInterface(interfaces[i], listaInterfaces);

            if (claseAdevolver != null) {
                return claseAdevolver;
            }
        }

        return null;
    }    

    ElementoParametrizable getElementoInstanciadoSegunSuInterfaz(Class aClass) {
        return this.mapaInterfazElementoInstanciado.get(aClass);
    }
    
}
