package comp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import cromosoma.FuncionDeAptitud;

public class Run {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
// http://www.coderanch.com/t/278034/Streams/java/Reading-serialized-objects-file-readObject
//http://www.chuidiang.com/java/ficheros/ObjetosFichero.php en esta pag la forma de leer 
		// es fruta supone que readObjetc devuelve null y asi te das cuenta cuando no hay mas pero
		//segun la otra pagina no hay forma de darse cuenta, hay  trucos como grabar cantidad de objetos
		//o la coleccion
		
		try {
			
			String str = "1";
			
			boolean bol= Boolean.parseBoolean(str);
			
			if(str.equals("1"))
				bol=true;
		
		
			
			ObjectOutputStream salida=new ObjectOutputStream(new FileOutputStream("C:/comp/objetos.obj"));
			
			Elemento elto1 = new Elemento();
			elto1.setCodigo("1");
			elto1.setDescripcion("esta es la descripcion del objeto 1");
			elto1.setNombre("Objeto 1");
			
			Elemento elto2 = new Elemento();
			elto2.setCodigo("2");
			elto2.setDescripcion("esta es la descripcion del objeto 2");
			elto2.setNombre("Objeto 2");
			
			List lista = new ArrayList();
			lista.add(elto1);
			lista.add(elto2);
			salida.writeObject(lista);
			
			salida.close();
			
			ObjectInputStream entrada=new ObjectInputStream(new FileInputStream("C:/comp/objetos.obj"));

			List lista2= (List) entrada.readObject();
			
			for (Object obj :lista2)
			{
			Elemento elto = (Elemento) obj;
				
			System.out.println(elto.getDescripcion());
			System.out.println(elto.getNombre());
			System.out.println(elto.getCodigo());
			}
			
//			Elemento elto4 = (Elemento) entrada.readObject();
//			
//			System.out.println(elto4.getDescripcion());
//			System.out.println(elto4.getNombre());
//			System.out.println(elto4.getCodigo());
				
//			Elemento elto5 = (Elemento) entrada.readObject();
//			
//			System.out.println(elto5.getDescripcion());
//			System.out.println(elto5.getNombre());
//			System.out.println(elto5.getCodigo());
			
			entrada.close();
//			oos.writeObject("tal");
		
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		Compilador comp = new Compilador();
//		
//		FuncionDeAptitud objeto = null;
////Ahoradaffasafaffa
////ahora el reves desde tortoi
//		//Comiteo desde el Tortoise para cagar que aparezca conflicto en el SVN del eclipse
////Pruebo comitear desde el SVN del eclise para hacer quilombo con Tortoise
////		comp.compilar("C:/comp/NuestroObjeto.java","comp.NuestroObjeto");
//		comp.compilar("C:/comp/Fa.java","comp.Fa");
//		Class c1 = comp.getCompiledClass("comp.Fa");
//				
//              parametro = clase.getField("parametro");
//		try {
//        	objeto = (FuncionDeAptitud) c1.newInstance();
//			        
//        } catch (InstantiationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//        objeto.funcionAptitud();
		
	}

}
