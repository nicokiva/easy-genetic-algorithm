package solucion;

import Methods.Method;
import Methods.Param;
import Solutions.Solution;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import comp.Compilador;

import operadores.CruzamientoInterface;
import operadores.HelperInterface;
import operadores.MutacionInterface;
import operadores.OperadorInterface;
import operadores.SeleccionInterface;
import implementaciones.CromosomaImp;
import implementaciones.CruzaMultiPunto;
import implementaciones.FuncionDeAptitudImpl;
import implementaciones.MutacionCambioDeEltos;
import implementaciones.PersonasHelper;
import implementaciones.Ranking;
import cromosoma.FuncionDeAptitud;
import cromosoma.InterfaceCromosoma;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import operadores.ParoInterface;

public class Solucion {
	
	
        private Solution configuSolution;
    
	public static final int CANT_GENERACIONES = 100;

	public int TAMANO_POBLACION= 100;
	
	private FuncionDeAptitud funcionAp= null;

	private OperadorInterface helper= null;

	private OperadorInterface operadorMuta=  null;

	private OperadorInterface operadorCruza= null;

	private OperadorInterface operadorSelec= null;

	private Compilador compilador;

	private Map<Class, Class> mapaInterfazClaseImplementacion;

	private Random randomizer = new Random();
        
        private Map<Class, Object> mapaInterfazObjetoMetodo= new HashMap<>();
        
        private ParoInterface metodoParo;
	
        
        public void armate(Solution  configSolution) {
		
		this.compilador= new Compilador();
		
		this.mapaInterfazClaseImplementacion= new HashMap<Class, Class>();
                
                 
                ArrayList<Method> listaMetodos = configSolution.getArrMethods();
                Set<Class> setInterfaces= new HashSet<>();
                List<String> paths= new ArrayList<>();
                
                for(Method metodo : listaMetodos){
                    Class interfaz = metodo.getInterfaz();     
                    
                    if(interfaz!=null){
                        
                        setInterfaces.add(interfaz);
                        paths.add(metodo.getPath());
                    }
                }
                 
                
		List<Class> listaImplementacionesFaltantes = this.compilador.compilarYllenarMapaConImplementaciones(paths, "solucionHarcodeada", this.mapaInterfazClaseImplementacion
				, setInterfaces);
		
		//TODO ERROR
		if(!listaImplementacionesFaltantes.isEmpty()){
			System.out.println("Faltan implementar");
			return;
		}
		
                for(Method metodo : listaMetodos){
                     Class interfaz = metodo.getInterfaz();     
                    
                    if(interfaz!=null){
                        Object obj = instanciarObjetoQueImplementa(interfaz);
                        meterConReflection(metodo.getParams(),obj);
                        this.mapaInterfazObjetoMetodo.put(interfaz,obj);
                    }
                     
                }
                
                this.TAMANO_POBLACION=configSolution.getIntSize();
	}
        
        
	public void armate(List<String> paths, Set<Class> setInterfaces) {
		
		this.compilador= new Compilador();
		
		this.mapaInterfazClaseImplementacion= new HashMap<Class, Class>();
		
		List<Class> listaImplementacionesFaltantes = this.compilador.compilarYllenarMapaConImplementaciones(paths, "solucionHarcodeada", this.mapaInterfazClaseImplementacion
				, setInterfaces);
		
		//TODO ERROR
		if(!listaImplementacionesFaltantes.isEmpty()){
			System.out.println("Faltan implementar");
			return;
		}
		
	}	
	
	public void armateParaPruebas(Map<Class, Class> mapa) {
		
		this.compilador= new Compilador();
		
		this.mapaInterfazClaseImplementacion= mapa;
		
	
		
	}	
	
	public InterfaceCromosoma newCromosoma() {
		// TODO Auto-generated method stub
//		this.mapaInterfazClaseImplementacion.get(InterfaceCromosoma.class);
		
    	        InterfaceCromosoma crom = ((InterfaceCromosoma) instanciarObjetoQueImplementa(InterfaceCromosoma.class));

		crom.setSolucion(this);
		
		return crom;
	}

	public FuncionDeAptitud getFuncionDeAptitud() {
		// TODO Auto-generated method stub
		
		
		if(this.funcionAp==null){
			this.funcionAp= (FuncionDeAptitud) this.mapaInterfazObjetoMetodo.get(FuncionDeAptitud.class);
		}
		return this.funcionAp;
	}
                       
 
	private Object instanciarObjetoQueImplementa(Class name) {
		// TODO Auto-generated method stub
		Object ob=null;
		
		try {
			
			 ob = this.mapaInterfazClaseImplementacion.get(name).newInstance();
                          
                         
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ob;
	}

	public OperadorInterface getHelper() {
		// TODO Auto-generated method stub
		
		if(this.helper==null){
			
			this.helper= (HelperInterface)  this.mapaInterfazObjetoMetodo.get(HelperInterface.class);
			
		}

		return this.helper;
		
	}

	public OperadorInterface getOperadorSeleccion() {
		// TODO Auto-generated method stub
		
		if(this.operadorSelec==null){
			
			this.operadorSelec= (SeleccionInterface)  this.mapaInterfazObjetoMetodo.get(SeleccionInterface.class);
			
		}
		
		return this.operadorSelec;
		
		
	}

	public OperadorInterface getOperadorCruzamiento() {
		
		if(this.operadorCruza==null){
			
			this.operadorCruza= (CruzamientoInterface)  this.mapaInterfazObjetoMetodo.get(CruzamientoInterface.class);
			
		}
		
		return this.operadorCruza;
		
	}

	public OperadorInterface getOperadorMutacion() {
		
		
		if(this.operadorMuta==null){
			
			this.operadorMuta= (MutacionInterface)  this.mapaInterfazObjetoMetodo.get(MutacionInterface.class);
			
		}
		
		return this.operadorMuta;
		
	}
        
       public ParoInterface getMetodoParo() {
		
		
		if(this.metodoParo==null){
			
			this.metodoParo = (ParoInterface)  this.mapaInterfazObjetoMetodo.get(ParoInterface.class);
			
		}
		
		return this.metodoParo;
		
	}

	public Random getRandomizer() {
		return randomizer;
	}

	public void setRandomizer(Random randomizer) {
		this.randomizer = randomizer;
	}

    private void meterConReflection(ArrayList<Param> params, Object obj) {
         
        for(Param parametro:params){
                         
            try {
                Field fld = obj.getClass().getField(parametro.getName());
                fld.set(obj, parametro.getValue().trim());
           
            } catch (NoSuchFieldException ex) {
                Logger.getLogger(Solucion.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            } catch (SecurityException ex) {
                Logger.getLogger(Solucion.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(Solucion.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Solucion.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
        }
         
           
          
    }
}
