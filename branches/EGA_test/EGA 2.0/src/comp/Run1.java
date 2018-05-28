//package comp;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Map;
//import java.util.Map.Entry;
//import java.util.Set;
//
//import cromosoma.CromosomaAbstractoGenesObject;
//import cromosoma.FuncionDeAptitud;
//import cromosoma.Inter6;
//import cromosoma.Inter7;
//import cromosoma.NoInteresa;
//import implementaciones.ComparadorPorFDA;
//import implementaciones.CromosomaImp;
//import implementaciones.CruzaMultiPunto;
//import java.lang.reflect.Field;
//
//import comp.Run1.ClasePosible;
//
//import operadores.CruzaPadresAleatoriosAbstracta;
//import operadores.OperadorInterface;
//
//public class Run1 {
//	/**
//	 * @param args
//	 */
//	
//	class ClasePosible{
//		private Class claseActual;
//		private int nivelEnJeraquiaClaseActual=-1;
//		
//		public void add(Class clase2) {
//			if (this.claseActual==null)
//				this.claseActual=clase2;
//			else {
//				if(this.nivelEnJeraquiaClaseActual==-1){
//					
//					this.nivelEnJeraquiaClaseActual=calcularNivelEnJeraquia(this.claseActual);
//					
//				}
////				int nivel=
////				this.claseActual= esMasHija(clase2);
//				
//			}
//
//		}
//
//		public int calcularNivelEnJeraquia(Class claseActual2) {
//			// TODO Auto-generated method stub
//			int distanciaAObject=0;
//			
//			while(claseActual2!=null) {
//				++distanciaAObject;
//				claseActual2=claseActual2.getSuperclass();
//			}	
//			
//			return distanciaAObject;
//		}
//		
//	}	
//	public static void main(String[] args) {
//		
//		Compilador comp = new Compilador();
//	
//		Map<Class, Class> mapaInterfazClaseImplementacion
//		= new HashMap<Class, Class>();
//		Set<Class> setInterfaces= new HashSet<Class>();
//		
//		List<Class> listaClases = new ArrayList<Class>();
//		
//		listaClases.add(CromosomaAbstractoGenesObject.class);
//		listaClases.add(CromosomaImp.class);
//		listaClases.add(ComparadorPorFDA.class);
//		listaClases.add(ComparadorPorFDA.class);
//		listaClases.add(CruzaMultiPunto.class);
//		listaClases.add(CruzaPadresAleatoriosAbstracta.class);
//
//		setInterfaces.add(Inter6.class);
//		setInterfaces.add(OperadorInterface.class);
//		setInterfaces.add(NoInteresa.class);
//		
//		List<Class> lista = comp.agregarClasesQueImplementan(
//				mapaInterfazClaseImplementacion, setInterfaces, listaClases);
//		
//		
////        try {
////                         
////            Class cls = Class.forName("implementaciones.CruzaMultiPunto");
////            Field fld = cls.getField("param_cantidadDePuntos");
////            CruzaMultiPunto f2obj = new CruzaMultiPunto();
////            
////            fld.set(f2obj, "4");
////            System.out.println(f2obj.param_cantidadDePuntos);
////         }
////         catch (Throwable e) {
////            System.err.println(e);
////         }
////            
////            
////		Compilador comp = new Compilador();
////		
//////		FuncionDeAptitud objeto = null;
////                OperadorInterface operador = null;
////
////		comp.compilar("C:/comp/CruzaMultiPunto.java");
//		
////		Class c1 = comp.getCompiledClass("implementaciones.solucion1.CruzaMultiPunto");
//				
//              
////		try {
////        	 operador = (OperadorInterface) c1.newInstance();
////        	 Field fld = c1.getField("param_cantidadDePuntos");
////             fld.set(operador, "11");
////           System.out.println(operador.getCadena());
////                
////                } catch (InstantiationException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		} catch (IllegalAccessException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		} catch (SecurityException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		} catch (NoSuchFieldException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////	
//		
//	}
//
//	private static Class buscarInterface(Class clase, Set<Class> listaInterfaces) {
//		// TODO Auto-generated method stub
//		
//		if(listaInterfaces.contains(clase))
//			return clase;
//			
//		Class[] interfaces = clase.getInterfaces();
//		Class claseAdevolver;
//		
//		for (int i = 0; i < interfaces.length; i++) {
//			
//			claseAdevolver=buscarInterface(interfaces[i], listaInterfaces);
//			
//			if (claseAdevolver!=null)
//				return claseAdevolver; 
//		}
//		
//		return null;
//	}
//
//
//}
