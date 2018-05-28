/*
 * Este documento es parte del proyecto 'Juntando L�neas': 
 * https://code.google.com/p/juntando-lineas/
 * 
 * Copyright (C) 2011 Antonio S�nchez - Todos los derechos reservados
 * 
 * 'Juntando L�neas' es software libre: Ud. puede redistribuirlo y/o modificarlo 
 * bajo los t�rminos de la Licencia P�blica General de GNU tal como est� publicada 
 * por la Fundaci�n para el Software Libre, ya sea la versi�n 3 de la Licencia, o 
 * (a su elecci�n) cualquier versi�n posterior.
 * 
 * 'Juntando L�neas' se distribuye con la esperanza de que sea �til, pero 
 * SIN GARANT�A ALGUNA; ni siquiera la garant�a impl�cita MERCANTIL o de 
 * APTITUD PARA UN PROP�SITO DETERMINADO. Consulte los detalles de la 
 * Licencia P�blica General GNU para obtener una informaci�n m�s detallada. 
 * 
 * Deber�a haber recibido una copia de la Licencia P�blica General GNU junto a 
 * 'Juntando L�neas'. En caso contrario, consulte <http://www.gnu.org/licenses/>.
 * 
 * @author Antonio S�nchez
 */

package comp;

import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import javax.tools.FileObject;
import javax.tools.ForwardingJavaFileManager;
import javax.tools.JavaFileObject;
import javax.tools.JavaFileObject.Kind;
import javax.tools.SimpleJavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.StandardLocation;

/**
 * JavaFileManager que administra c�digo fuente y bytecodes en memoria, adem�s
 * de en el sistema de archivos.
 * 
 * Para cargar las clases compiladas en memoria con esta instancia hacerlo 
 * a trav�s de 'getClassLoader(null)'.
 * 
 * Para pasar c�digo fuente en memoria hacerlo a trav�s de
 *  'JLJavaFileManager.crearFuenteEnMemoria'.
 * 
 * Para escribir bytecodes en sistema de archivos de debe cumplir en el FileManager subyacente:
 *    fileManager.getLocation(StandardLocation.CLASS_OUTPUT) != null;
 */
class JLJavaFileManager extends ForwardingJavaFileManager<StandardJavaFileManager> {
    //el cargador de clases en memoria
    JLClassLoader cargador; 
    
    //aqu� se ir�n guardando los bytecodes compilados asoci�ndolos al correspondiente nombre 
    //cualificado de la clase que representan
    Map<String, byte[]> bytecodesEnMemoria = new HashMap<String, byte[]>();

    JLJavaFileManager(StandardJavaFileManager fileManager) {
        this(fileManager, null);
    }

    /**
     * @param cargador el ClassLoader padre para el ClassLoader en memoria de esta instancia
     */
    JLJavaFileManager(StandardJavaFileManager fileManager, ClassLoader cargador) {
        super(fileManager);
        
        //utilizamos como ClassLoader padre aquel desde el cual se invoca el constructor        
        if (cargador == null)
            cargador = getClass().getClassLoader();
        
        this.cargador = new JLClassLoader(cargador);
    }

    /**
     * Crea un java fuente en memoria con el c�digo fuente suministrado para que pueda ser compilado.
     */
    static JavaFileObject crearFuenteEnMemoria(String nombreCualificado, CharSequence javaFuente) {
        return new FuenteEnMemoria(nombreCualificado, javaFuente);
    }

    /**
     * @return un JavaFileObject para escribir en memoria los bytecodes resultantes de la compilaci�n.
     */
    @Override
    public JavaFileObject getJavaFileForOutput(Location location, String qualifiedName,
            Kind kind, FileObject sibling) throws IOException {
    /* Para lograr la compilaci�n en memoria necesitamos la anulaci�n de este m�todo para 
     * que en lugar de escribir en un JavaFileObject que escribir� en el sistema de archivos 
     * (comportamiento por defecto) lo que haga sea devolver un JavaFileObject que lo que 
     * haga sea escribir los bytes en memoria de tal forma que en coordinaci�n con esta clase
     * sea posible la carga de esos bytecodes, lo cual en este caso se har� mediante un
     * ClassLoader espec�fico.
     */
        //seg�n lo especificado por esta clase esta es la condici�n para escribir en memoria
        if (fileManager.getLocation(StandardLocation.CLASS_OUTPUT) == null) {
            //devolvemos un JavaFileObject que sabe escribir bytes en memoria
            return new BytesEnMemoria(qualifiedName);
        } else {
            //en otro caso hacemos la implementaci�n por defecto, que escribe al sistema de 
            //archivos, y concretamente a la carpeta especificada por 
            return fileManager.getJavaFileForOutput(location, qualifiedName, kind, sibling);
        }
    }

    /**
     * @return el cargador de clases para las clases compiladas en memoria con esta instancia.
     */
    @Override
    public JLClassLoader getClassLoader(Location location) {
        return cargador;
    }

    /**
     * @return el FileManager subyacente.
     */
    StandardJavaFileManager getFileManager() {
        return fileManager;
    }

    /**
     * JavaFileObject para representar c�digo fuente en memoria
     */
    private static final class FuenteEnMemoria extends SimpleJavaFileObject {
        CharSequence codigoFuente;

        FuenteEnMemoria(String name, CharSequence code) {
            super(URI.create("memoria:///" + name.replace('.', '/') + Kind.SOURCE.extension), 
                    Kind.SOURCE);
            this.codigoFuente = code;
        }

        @Override
        public CharSequence getCharContent(boolean ignoreEncodingErrors) {
            return codigoFuente;
        }
    }

    /**
     * JavaFileObject que escribe los bytecodes compilados en memoria
     */
    private final class BytesEnMemoria extends SimpleJavaFileObject {
        String nombreCualificado;

        BytesEnMemoria(String name) {
            super(URI.create("memoria:///" + name.replace('.', '/') + Kind.CLASS.extension), 
                    Kind.CLASS);
            this.nombreCualificado = name;
        }

        @Override
        public OutputStream openOutputStream() {
            //guarda los bytes en el mapa 'bytecodesEnMemoria' 
            //tan pronto termine el compilador de escribir los bytes
            return new FilterOutputStream(new ByteArrayOutputStream()) {
                @Override
                public void close() throws IOException {
                    out.close();
                    ByteArrayOutputStream bos = (ByteArrayOutputStream) out;
                    bytecodesEnMemoria.put(nombreCualificado, bos.toByteArray());
                }
            };
        }
    }

    /**
     * Carga los bytes de las clases compiladas en memoria con esta instancia
     */
    private class JLClassLoader extends ClassLoader {

        JLClassLoader(ClassLoader padre) {
            super(padre);
        }

        @Override
        protected Class<?> findClass(final String nombreCualificado)
                throws ClassNotFoundException {
            //consumimos los bytes porque a partir de ahora estar�n cargados
            byte[] bytes = bytecodesEnMemoria.remove(nombreCualificado);
            
            if (bytes != null) 
                return defineClass(nombreCualificado, bytes, 0, bytes.length);

            //clase no encontrada ni aqu� ni el classloader padre
            throw new ClassNotFoundException(nombreCualificado);
        }
    }
}
