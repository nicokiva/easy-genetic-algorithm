package comp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

import comp.SimpleCompiler;

import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import operadores.CruzaPadresAleatoriosAbstracta;

import org.codehaus.commons.compiler.CompileException;
import org.codehaus.janino.util.ClassFile;

import cromosoma.Inter7;
import cromosoma.NoInteresa;

import solucion.Solucion;





public class Compilador {

	
	private static SimpleCompiler compiler = new SimpleCompiler();
    
	private static StringBuilder unidadDeCompilacion = new StringBuilder(5012);

	private  Pattern patternImports= Pattern.compile("(import)(\\s+)((\\w|\\.)+)(\\s*)(;)");
	
	private final Pattern patternPackage= Pattern.compile("(package)(\\s+)((\\w|\\.)+)(\\s*)(;)");

	
	public List<Class> compilar(String unidadDeCompilacion ) {
		
		try {
           
			return compiler.cook(new StringReader(unidadDeCompilacion));

        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
		return null;
		
	}
	
	public List<Class> compilarYllenarMapaConImplementaciones(List<String> paths, String nombreSolucion, 
			Map<Class, Class> mapaInterfazClaseImplementacion, Set<Class> setInterfaces) {
		

		
		List<Class> listaClases = compilar(paths, nombreSolucion);
		
		//TODO
		if(listaClases==null){
			System.out.println("NO HAY CLASES");
			return null;
		}
		 
		
		List<Class> listaInterfasSinClaseImplementada = agregarClasesQueImplementan(
				mapaInterfazClaseImplementacion, setInterfaces, listaClases);
		
		return listaInterfasSinClaseImplementada;
		
	}

	public List<Class> agregarClasesQueImplementan(
			Map<Class, Class> mapaInterfazClaseImplementacion,
			Set<Class> setInterfaces, List<Class> listaClases) {
		//		Set<Class> setInterfaces = new HashSet<Class>();
				
		//		setInterfaces.add(Inter7.class);
		//		setInterfaces.add(NoInteresa.class);
				
				//Clase interna al metodo
				class ClaseMasHija{
					private Class claseActual;
					private int nivelEnJeraquiaClaseActual=-1;
					
					public void add(Class clase2) {
						if (this.claseActual==null)
							this.claseActual=clase2;
						else {
							if(this.nivelEnJeraquiaClaseActual==-1){
								
								this.nivelEnJeraquiaClaseActual=calcularNivelEnJeraquia(this.claseActual);
							}
							int nivelNuevaClase=calcularNivelEnJeraquia(clase2);
							
							if(nivelNuevaClase> this.nivelEnJeraquiaClaseActual){
								this.claseActual=clase2;
								this.nivelEnJeraquiaClaseActual=nivelNuevaClase;
								
							}
						}
		
					}
		
					private int calcularNivelEnJeraquia(Class claseActual2) {
						// TODO Auto-generated method stub
						int distanciaAObject=0;
						
						while(claseActual2!=null) {
							++distanciaAObject;
							claseActual2=claseActual2.getSuperclass();
						}	
						
						return distanciaAObject;
					}
					
				}	
				
				Map<Class, ClaseMasHija> mapaImplementacionClases= new HashMap<Class,ClaseMasHija>();
				
				
				for(Class clase : listaClases) {
					
					Class interfaceAlaQuePertenece=null;
					Class clasePadre = clase;
					
					while(clasePadre!=null && interfaceAlaQuePertenece==null) {
						
						interfaceAlaQuePertenece=buscarInterface(clasePadre,setInterfaces);
						clasePadre = clasePadre.getSuperclass();
					}
					
					if(interfaceAlaQuePertenece!=null) {
						
						ClaseMasHija clasePosible = mapaImplementacionClases.get(interfaceAlaQuePertenece);
						
						if(clasePosible==null) {
							
							clasePosible= new ClaseMasHija();
							clasePosible.add(clase);
							mapaImplementacionClases.put(interfaceAlaQuePertenece, clasePosible);
						}
						else {
							clasePosible.add(clase);
						}
					}
				}
				
		//		Map<Class, Class> mapaInterfazClaseImplementacion= new HashMap<Class,Class>();
				List<Class> listaInterfasSinClaseImplementada= new LinkedList<Class>();
				
				for(Class interfaz:setInterfaces){
					ClaseMasHija claseMasHija = mapaImplementacionClases.get(interfaz);
					if(claseMasHija==null){
						listaInterfasSinClaseImplementada.add(interfaz);
					}
					else {
						mapaInterfazClaseImplementacion.put(interfaz, claseMasHija.claseActual);
					}
				}
		return listaInterfasSinClaseImplementada;
	}

	private List<Class> compilar(List<String> paths, String nombreSolucion) {
		
		StringBuilder strBuildPaqueteEImports = armarUnidadDeCompilacion(paths,
				nombreSolucion);
		
		List<Class> listaClases = this.compilar(strBuildPaqueteEImports.toString());
		
		return listaClases;
	}

	private StringBuilder armarUnidadDeCompilacion(List<String> paths,
			String nombreSolucion) {
		
		StringBuilder strBuildSinComentaSinImports= new StringBuilder(5012);
		for(String path:paths)
		{
			javaSourceSinComentarios(path,strBuildSinComentaSinImports);
		}
		
		//Se eliminan los package que existan
		Matcher matcherPackage = this.patternPackage.matcher(strBuildSinComentaSinImports);
//		matcherPackage.replaceAll(" ");
		
		while (matcherPackage.find()) {
			int start=matcherPackage.start();
			int end = matcherPackage.end();
			String str = matcherPackage.group();
			StringBuilder blanco=new StringBuilder(str.length());
			for (int i = 0; i < str.length(); i++) {
				blanco.append(" ");
			}
			strBuildSinComentaSinImports.replace(start, end, blanco.toString());
		} 
		
		
		//Se pone el nuevo y unico package y se tranladan los imports
//		Pattern patternImports= Pattern.compile("(import)(\\s+)((\\w|\\.)+)(\\s*)(;)");
		Matcher matcherImports = this.patternImports.matcher(strBuildSinComentaSinImports);
//		Set<String> setImports = new HashSet<String>();
		
		StringBuilder strBuildPaqueteEImports=new StringBuilder();
		strBuildPaqueteEImports.append("package implementaciones2.");
		strBuildPaqueteEImports.append(nombreSolucion);
		strBuildPaqueteEImports.append(";");
		strBuildPaqueteEImports.append('\r');
		strBuildPaqueteEImports.append('\n');
		
//		strBuildSinComentaSinImports.
		while (matcherImports.find()) {
//			setImports.add(matcher.group());
			int start=matcherImports.start();
			int end = matcherImports.end();
			String str = matcherImports.group();
			strBuildPaqueteEImports.append(str);
			strBuildPaqueteEImports.append('\r');
			strBuildPaqueteEImports.append('\n');
			StringBuilder blanco=new StringBuilder(str.length());
			for (int i = 0; i < str.length(); i++) {
				blanco.append(" ");
			}
			strBuildSinComentaSinImports.replace(start, end, blanco.toString());
		} 
//		matcherImports.reset();
//		matcherImports.replaceAll(" ");
		strBuildPaqueteEImports.append(strBuildSinComentaSinImports);
		return strBuildPaqueteEImports;
	}
	
	
	private  void javaSourceSinComentarios(String javaSource,StringBuilder strBuild) {
			
			String strLine;

			try {
				BufferedReader br = new BufferedReader(new FileReader(javaSource));
				int index;
				while ((strLine = br.readLine()) != null){
					
					index =strLine.indexOf("/*"); 
					
					if(index>-1)
					{
						for (int i = 0; i < index; i++) {
							strBuild.append(strLine.charAt(i));
						}
						boolean continuar=true;
						while (((strLine = br.readLine()) != null) && continuar){
							index =strLine.indexOf("*/"); 
								
								if(index>-1) {
									continuar = false;
									if(index+2<strLine.length())
									{
										for (int i=index+2; i < strLine.length(); i++) {
										strBuild.append(strLine.charAt(i));
										}
									}
								}	
						}
						
					}else {

						if((index=strLine.indexOf("//"))!=-1){
							
							for (int i = 0; i < index; i++) {
								strBuild.append(strLine.charAt(i));
							}
						}
						else
							strBuild.append(strLine);
					}
					strBuild.append('\r');
					strBuild.append('\n');
					
				}
				
			
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	public Class getCompiledClass(String nombreClase){
		
		Class clase= null;
		try {
			clase= compiler.getClassLoader().loadClass(nombreClase);
		
		} catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
		}
		
		return clase;
	}
        
        public static void pruebaCompilacion(String texto) throws IOException, CompileException{
                
        	ClassFile[] classFiles =compiler.compileToClassFiles(new StringReader(texto));
        	
        	
        	for (int i = 0; i < classFiles.length; ++i) {
                ClassFile cf = classFiles[i];
                if(cf.getClass().getSuperclass().equals(CruzaPadresAleatoriosAbstracta.class))
                	System.out.println("hit");
            }
        }
        
    	private static Class buscarInterface(Class clase, Set<Class> listaInterfaces) {
    		// TODO Auto-generated method stub
    		
    		if(listaInterfaces.contains(clase))
    			return clase;
    			
    		Class[] interfaces = clase.getInterfaces();
    		Class claseAdevolver;
    		
    		for (int i = 0; i < interfaces.length; i++) {
    			
    			claseAdevolver=buscarInterface(interfaces[i], listaInterfaces);
    			
    			if (claseAdevolver!=null)
    				return claseAdevolver; 
    		}
    		
    		return null;
    	}
    	
}


//String result = null;
//FileInputStream file;
//try {
//	file = new FileInputStream (javaSource);
////	Scanner scan = new Scanner(file);
////	scan.useDelimiter(";");
////	while(scan.hasNext())
////		System.out.print(scan.next()+" ");
////	int i;
////	while ((i= file.read())!='\n')
////		System.out.print((char)i);
//	
//	byte[] b = new byte[file.available()];
//	file.read(b);
//	file.close ();
//	result = new String (b);
//	
//} catch (FileNotFoundException e1) {
//	// TODO Auto-generated catch block
//	e1.printStackTrace();
//} catch (IOException e) {
//	// TODO Auto-generated catch block
//	e.printStackTrace();
//}

//Pattern pattern = Pattern.compile("(import)(\\s+)(.+)");
//String strSincomente = result.replaceAll("(/\\*)((.)|(\\t)|(\\r)|(\\n))*(\\*/)", "");
//String strSincomente = result.replaceAll("(//)(.*)", "");
//Pattern pattern = Pattern.compile("(public)(\\s+)(class)");
