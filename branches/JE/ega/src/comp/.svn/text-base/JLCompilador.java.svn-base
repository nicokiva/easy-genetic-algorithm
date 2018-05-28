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

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.StandardLocation;
import javax.tools.ToolProvider;

/**
 * Fachada de Java Compiler API para compilar en memoria y en sistema de archivos.
 * 
 * Por defecto compila en memoria. Para compilar al sistema de archivos hay que 
 * establecer un directorio destino no nulo con el m�todo 'setClassOutputLocation'.
 * 
 * Cada uno de los m�todos de compilaci�n devuelve el resultado de la compilaci�n,
 * si ha sido exitoso o no. En caso negativo se pueden recoger los diagn�sticos 
 * de la �ltima compilaci�n con el m�todo 'getDiagn�sticos'. Los diagn�sticos ser�n 
 * siempre actualizados despu�s de cada compilaci�n, no persisten entre llamadas
 * a compilar.
 * 
 * Se pueden establecer opciones de compilaci�n con el m�todo 'setOpciones' antes
 * de la compilaci�n. Si no se restablecen para cada compilaci�n las opciones 
 * establecidas persisten entre compilaciones.
 * 
 * Mediante 'getCargadorMemoria' se obtiene el ClassLoader de las clases compiladas
 * en memoria con esta instancia. Este cargador va acumulando o recordando todas las
 * clases compiladas a lo largo de todas las compilaciones que se hayan realizado con esta 
 * instancia.
 * 
 * Para cargar clases compiladas en el sistema de archivos lo recomendable es obtener
 * un URLClassLoader con el destino especificado con 'setClassOutputLocation', y obtenerlo
 * despu�s de cada compilaci�n. Por ejemplo:
 * 
 *   File destino = new File("build/classes");
 *   JLCompilador comp = new JLCompilador();
 *   
 *   comp.setClassOutputLocation(destino);
 *   comp.compilar(...);
 * 
 *   ClassLoader cargador = new URLClassLoader(new URL[] {destino.toURI().toURL()})
 *   cargador.loadClass(...);
 */
public class JLCompilador {
    private JavaCompiler compilador;
    private JLJavaFileManager fileManager;
    private List<String> opciones;
    private DiagnosticCollector<JavaFileObject> diagnosticos;

    /**
     * Compilador que tomar� como ClassLoader padre aquel con el que se invoca este constructor.
     */    
    public JLCompilador() {
        this(null);
    }

    /**
     * Compilador que utilizar� el ClassLoader dado
     * 
     * @param cargadorPadre cargador padre para compilaci�n en memoria; si es null se utiliza
     *   el ClassLoader desde el que se invoca este constructor.
     */        
    public JLCompilador(ClassLoader cargadorPadre) {
        //obtenemos el compilador con el que trabajar� esta instancia
        compilador = ToolProvider.getSystemJavaCompiler();

        //nos basaremos en el fileManager est�ndar del compilador con los valores por defecto
        StandardJavaFileManager sfm = compilador.getStandardFileManager(null, null, null); 

        //creamos nuestro JavaFileManager con funcionalidad espec�fica
        fileManager = new JLJavaFileManager(sfm, cargadorPadre);
    }

    /**
     * @return un cargador de clases que sabe cargar las clases compiladas
     */
    public ClassLoader getCargadorMemoria() {
        return fileManager.getClassLoader(null);
    }

    /**
     * Establece la ruta del sistema de archivos donde se crear�n los .class. 
     * Esto indica, siempre que sea distinto a null, que la compilaci�n NO es
     * en memoria. 
     * 
     * @param ruta
     * @throws IOException 
     */
    public void setClassOutputLocation(File ruta) throws IOException {
        fileManager.getFileManager().setLocation(StandardLocation.CLASS_OUTPUT, Arrays.asList(ruta));
    }

    /**
     * @param opciones las opciones de compilacion 
     */
    public void setOpciones(String... opciones) {
        this.opciones = Arrays.asList(opciones);
    }

    /**
     * Compila c�digo existente en ficheros del del sistema de archivos.
     * 
     * @param ficherosJava los fuentes del sistema de archivos
     * @return si la compilaci�n ha sido o no exitosa.
     */
    public boolean compilar(File... ficherosJava) {
        //construimos los JavaFileObject con el m�tod   o utililidad del StandardJavaFileManager subyacente
        Iterable<? extends JavaFileObject> s = fileManager.getFileManager().getJavaFileObjects(ficherosJava);
        return compilar(s);
    }

    /**
     * Compila el c�digo fuente correspondiente al nombre de clase dado. 
     * 
     * Para la correcta compilaci�n y posterior carga es indispensable que coincida
     * el nombre cualificado dado con el nombre de la clase del c�digo fuente si esta
     * es public.
     * 
     * @param nombreCualificado el nombre completo de la clase
     * @param c�digoFuente el c�digo a compilar
     * @return si la compilaci�n ha sido o no exitosa.
     */
    public boolean compilar(String nombreCualificado, CharSequence codigoFuente) {
        //creamos el correspondiente JavaFileObject para el c�digo fuente dado
        JavaFileObject fuente = JLJavaFileManager.crearFuenteEnMemoria(nombreCualificado, codigoFuente);
        
        return compilar(Arrays.asList(fuente));
    }

    /**
     * Compila un conjunto de fuentes de una vez
     * 
     * @param clasesFuente mapa con los fuentes a compilar y sus respectivos nombres completos
     * @return si la compilaci�n ha sido o no exitosa.
     */
    public boolean compilar(Map<String, CharSequence> clasesFuente) {
        List<JavaFileObject> fuentes = new ArrayList<JavaFileObject>(clasesFuente.size());

        for (Entry<String, CharSequence> par : clasesFuente.entrySet()) {
            //creamos el correspondiente JavaFileObject para el c�digo fuente dado
            JavaFileObject fuente = JLJavaFileManager.crearFuenteEnMemoria(par.getKey(), par.getValue());

            fuentes.add(fuente);
        }

        return compilar(fuentes);
    }
    
    /**
     * Crea y ejecuta la tarea de compilaci�n con todos los componente existentes.
     * 
     * @param udsComp unidades para compilar
     * @return si la compilaci�n ha sido o no exitosa.
     */
    private boolean compilar(Iterable<? extends JavaFileObject> udsComp) {
        diagnosticos = new DiagnosticCollector<JavaFileObject>();

        CompilationTask tarea = compilador.getTask(null, fileManager, diagnosticos, opciones, null, udsComp);

        return tarea.call();
    }

    /**
     * @return los diagn�sticos de la �ltima compilaci�n realizada.
     */
    public DiagnosticCollector<JavaFileObject> getDiagnosticos() {
        return diagnosticos;
    }

//    /**
//     * Liberar recursos y dejar en un estado de reci�n creado.
//     */
//    public void reiniciar() {
//        ClassLoader cargadorPadre = fileManager.getClassLoader(null).getParent();
//        StandardJavaFileManager sfm = compilador.getStandardFileManager(null, null, null); 
//
//        //liberamos recursos y cerramos filemanager
//        try {
//            fileManager.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }    
//
//        //creamos un nuevo fileManager limpio
//        fileManager = new JLJavaFileManager(sfm, cargadorPadre);
//    }
    
    @Override
    public void finalize() {
        //liberamos recursos y cerramos filemanager
        try {
            fileManager.close();
        } catch (IOException e) {
        }    
    }
}
