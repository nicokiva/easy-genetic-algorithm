//package solucion;
//
//import Methods.Method;
//import Methods.Param;
//import Solutions.Solution;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Random;
//import java.util.Set;
//
//import comp.Compilador;
//import cromosoma.FabricaDeCromosomasInterface;
//
//import operadores.CruzamientoInterface;
//import operadores.MutacionInterface;
//import operadores.OperadorInterface;
//import operadores.SeleccionInterface;
//import cromosoma.FuncionDeAptitud;
//import cromosoma.InterfaceCromosoma;
//import formatoResultados.FormatoInformeInterface;
//import java.lang.reflect.Field;
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.LinkedList;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//public class Solucion {
//	
//	private final static String nombrePaquete="implementacion";
//        
//        private int numeroPaquete=0;
//                
//        private Solution configuSolution;
//    
//	public static final int CANT_GENERACIONES = 100;
//
//	public int TAMANO_POBLACION= 100;
//	
//	private FuncionDeAptitud funcionAp= null;
//
//	private OperadorInterface helper= null;
//
//	private OperadorInterface operadorMuta=  null;
//
//	private OperadorInterface operadorCruza= null;
//
//	private OperadorInterface operadorSelec= null;
//
//	private Compilador compilador;
//
//	private Map<Class, Class> mapaInterfazClaseImplementacion;
//
//	private Random randomizer = new Random();
//        
//        private Map<Class, Object> mapaInterfazObjetoMetodo= new HashMap<>();
//        
//        private ParoInterface metodoParo;
//    private FormatoInformeInterface formatoResultados;
//    private FabricaDeCromosomasInterface fabricaCromosomas;
//	
//        
//        public void armate(Solution  configSolution) {
//		
//		this.compilador= new Compilador();
//		
//		this.mapaInterfazClaseImplementacion= new HashMap<Class, Class>();
//                
//                 
//                ArrayList<Method> listaMetodos = configSolution.getArrMethods();
//                Set<Class> setInterfaces= new HashSet<>();
//                
//                List<String> paths= new ArrayList<>();
//                
//                for(Method metodo : listaMetodos){
//                    Class interfaz = metodo.getInterfazParametrizable();     
//                    
//                        
//                        setInterfaces.add(interfaz);
//                        paths.add(metodo.getPath());
//                        Set<Class> otrasInterfaces = metodo.getOtrasInterfacesQueDebeImplementar();
//                        if(otrasInterfaces!=null){   
//                            
//                            for(Class clase : otrasInterfaces){
//                                 setInterfaces.add(interfaz);
//                            }
//                        }       
//                    
//                }
//                 
//                String nombre= nombrePaquete + String.valueOf(numeroPaquete++);
//                
//		List<Class> listaClases = this.compilador.compilar(paths, nombre);
//		
//                  List<Class> listaImplementacionesFaltantes = agregarClasesQueImplementan(
//               this.mapaInterfazClaseImplementacion, setInterfaces, listaClases);
//                
//                  for(Class clase:listaClases)
//                System.out.println("Clases Compiladas"+clase);
//		//TODO ERROR
//		if(!listaImplementacionesFaltantes.isEmpty()){
//			System.out.println("Faltan implementar"+listaImplementacionesFaltantes.get(0));
//			return;
//		}
//		
//                for(Method metodo : listaMetodos){
//                     Class interfaz = metodo.getInterfazParametrizable();     
//                    
//                        Object obj = instanciarObjetoQueImplementa(interfaz);
//                        meterConReflection(metodo.getParams(),obj);
//                        
//                        this.mapaInterfazObjetoMetodo.put(interfaz,obj);
//                    
//                     
//                }
//                
//                this.TAMANO_POBLACION = configSolution.getIntSize();
//	}
//        
//        
////	public void armate(List<String> paths, Set<Class> setInterfaces) {
////		
////		this.compilador= new Compilador();
////		
////		this.mapaInterfazClaseImplementacion= new HashMap<Class, Class>();
////		
////		List<Class> listaImplementacionesFaltantes = this.compilador.compilarYllenarMapaConImplementaciones(paths, "solucionHarcodeada", this.mapaInterfazClaseImplementacion
////				, setInterfaces);
////		
////		//TODO ERROR
////		if(!listaImplementacionesFaltantes.isEmpty()){
////			System.out.println("Faltan implementar");
////			return;
////		}
////		
////	}	
//	
//	public void armateParaPruebas(Map<Class, Class> mapa) {
//		
//		this.compilador= new Compilador();
//		
//		this.mapaInterfazClaseImplementacion= mapa;
//		
//	
//		
//	}	
//	
//
//                       
// 
//	private Object instanciarObjetoQueImplementa(Class name) {
//		// TODO Auto-generated method stub
//		Object ob=null;
//		
//		try {
//			
//			 ob = this.mapaInterfazClaseImplementacion.get(name).newInstance();
//                          
//                         
//		} catch (InstantiationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return ob;
//	}
//
//
//
//    private void meterConReflection(List<Param> params, Object obj) {
//         
//        for(Param parametro:params){
//                         
//            try {
//                Field fld = obj.getClass().getField(parametro.getName());
//                fld.set(obj, parametro.getValue().trim());
//           
//            } catch (NoSuchFieldException ex) {
//                Logger.getLogger(Solucion.class.getName()).log(Level.SEVERE, null, ex);
//                ex.printStackTrace();
//            } catch (SecurityException ex) {
//                Logger.getLogger(Solucion.class.getName()).log(Level.SEVERE, null, ex);
//                ex.printStackTrace();
//            } catch (IllegalArgumentException ex) {
//                Logger.getLogger(Solucion.class.getName()).log(Level.SEVERE, null, ex);
//                ex.printStackTrace();
//            } catch (IllegalAccessException ex) {
//                Logger.getLogger(Solucion.class.getName()).log(Level.SEVERE, null, ex);
//                ex.printStackTrace();
//            }
//        }
//        
//        
//         
//           
//          
//    }
//    
//    
//        public List<Class> agregarClasesQueImplementan(
//            Map<Class, Class> mapaInterfazClaseImplementacion,
//            Set<Class> setInterfaces, List<Class> listaClases) {
//        //		Set<Class> setInterfaces = new HashSet<Class>();
//
//        //		setInterfaces.add(Inter7.class);
//        //		setInterfaces.add(NoInteresa.class);
//
//        //Clase interna al metodo
//        class ClaseMasHija {
//
//            private Class claseActual;
//            private int nivelEnJeraquiaClaseActual = -1;
//
//            public void add(Class clase2) {
//                if (this.claseActual == null) {
//                    this.claseActual = clase2;
//                } else {
//                    if (this.nivelEnJeraquiaClaseActual == -1) {
//
//                        this.nivelEnJeraquiaClaseActual = calcularNivelEnJeraquia(this.claseActual);
//                    }
//                    int nivelNuevaClase = calcularNivelEnJeraquia(clase2);
//
//                    if (nivelNuevaClase > this.nivelEnJeraquiaClaseActual) {
//                        this.claseActual = clase2;
//                        this.nivelEnJeraquiaClaseActual = nivelNuevaClase;
//
//                    }
//                }
//
//            }
//
//            private int calcularNivelEnJeraquia(Class claseActual2) {
//                // TODO Auto-generated method stub
//                int distanciaAObject = 0;
//
//                while (claseActual2 != null) {
//                    ++distanciaAObject;
//                    claseActual2 = claseActual2.getSuperclass();
//                }
//
//                return distanciaAObject;
//            }
//        }
//
//        Map<Class, ClaseMasHija> mapaImplementacionClases = new HashMap<Class, ClaseMasHija>();
//
//
//        for (Class clase : listaClases) {
//
//            Class interfaceAlaQuePertenece = null;
//            Class clasePadre = clase;
//
//            while (clasePadre != null && interfaceAlaQuePertenece == null) {
//
//                interfaceAlaQuePertenece = buscarInterface(clasePadre, setInterfaces);
//                clasePadre = clasePadre.getSuperclass();
//            }
//
//            if (interfaceAlaQuePertenece != null) {
//
//                ClaseMasHija clasePosible = mapaImplementacionClases.get(interfaceAlaQuePertenece);
//
//                if (clasePosible == null) {
//
//                    clasePosible = new ClaseMasHija();
//                    clasePosible.add(clase);
//                    mapaImplementacionClases.put(interfaceAlaQuePertenece, clasePosible);
//                } else {
//                    clasePosible.add(clase);
//                }
//            }
//        }
//
//        //		Map<Class, Class> mapaInterfazClaseImplementacion= new HashMap<Class,Class>();
//        List<Class> listaInterfasSinClaseImplementada = new LinkedList<Class>();
//
//        for (Class interfaz : setInterfaces) {
//            ClaseMasHija claseMasHija = mapaImplementacionClases.get(interfaz);
//            if (claseMasHija == null) {
//                listaInterfasSinClaseImplementada.add(interfaz);
//            } else {
//                mapaInterfazClaseImplementacion.put(interfaz, claseMasHija.claseActual);
//            }
//        }
//        return listaInterfasSinClaseImplementada;
//    }
//    
//        
//        private Class buscarInterface(Class clase, Set<Class> listaInterfaces) {
//        // TODO Auto-generated method stub
//
//        if (listaInterfaces.contains(clase)) {
//            return clase;
//        }
//
//        Class[] interfaces = clase.getInterfaces();
//        Class claseAdevolver;
//
//        for (int i = 0; i < interfaces.length; i++) {
//
//            claseAdevolver = buscarInterface(interfaces[i], listaInterfaces);
//
//            if (claseAdevolver != null) {
//                return claseAdevolver;
//            }
//        }
//
//        return null;
//    }    
//}
