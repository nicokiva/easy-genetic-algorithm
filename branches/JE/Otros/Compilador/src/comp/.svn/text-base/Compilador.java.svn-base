package comp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;

import org.codehaus.janino.SimpleCompiler;





public class Compilador {

	
	private SimpleCompiler compiler;

	public void compilar(String javaSource,String nombreClase ) {
		
		String result = null;
		FileInputStream file;
		try {
			file = new FileInputStream (javaSource);
			byte[] b = new byte[file.available()];
			file.read(b);
			file.close ();
			result = new String (b);
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
            compiler = new SimpleCompiler();
            compiler.cook(new StringReader(result));
            

//            NuestroObjeto objeto = (NuestroObjeto) cl.newInstance();

        } catch (Exception e) {
            System.err.println(e.getMessage());
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
}
