/*
 * Esta clase se encarga de generar el XML correspondiente a la solución dada.
 * 
 */
package Presentacion.Auxiliares;
import Solutions.Solution;
import enums.OrdenXMLTag;
import enums.TiposDatos;
import enums.TiposMetodos;
import enums.XMLTag;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class GeneradorXML {
    public static final String XMLCaracterInicial = "<";
    public static final String XMLCaracterFinal = ">";
    public static final String XMLCaracterClausura = "/";
    public static final XMLTags Tags = new XMLTags();

    public static String XML = "";
    

    public static String GenerarXML(Solution solution){
        GeneradorXML.ReiniciarXML();
        GeneradorXML.XML += GeneradorXML.Generar(solution);
        return GeneradorXML.XML;
    }
    
    private static void ReiniciarXML(){
        GeneradorXML.XML = "";
    }
    
    private static boolean EsClausura(OrdenXMLTag OrdenTag){
        return OrdenTag == OrdenXMLTag.Clausura;
    }
    
    private static String Generar(Solution solution){
        String XMLTemporal = GeneradorXML.GenerarTag(XMLTag.Cabecera, OrdenXMLTag.Apertura);
        XMLTemporal += GeneradorXML.GenerarTag(XMLTag.Raiz, OrdenXMLTag.Apertura);
        XMLTemporal +=  GeneradorXML.GenerarTag(XMLTag.Opciones, OrdenXMLTag.Apertura);
        XMLTemporal +=      GeneradorXML.GenerarTag(XMLTag.SoloLectura, OrdenXMLTag.Apertura) + solution.EsSoloLectura() + GeneradorXML.GenerarTag(XMLTag.SoloLectura, OrdenXMLTag.Clausura);
        XMLTemporal +=      GeneradorXML.GenerarTag(XMLTag.Servidor, OrdenXMLTag.Apertura) + solution.getStrServerFolder() + GeneradorXML.GenerarTag(XMLTag.Servidor, OrdenXMLTag.Clausura);
        XMLTemporal +=  GeneradorXML.GenerarTag(XMLTag.Opciones, OrdenXMLTag.Clausura);
        
        XMLTemporal +=  GeneradorXML.GenerarTag(XMLTag.Elementos, OrdenXMLTag.Apertura);
        XMLTemporal +=      GeneradorXML.GenerarTag(XMLTag.General, OrdenXMLTag.Apertura);
        XMLTemporal +=          GeneradorXML.GenerarTag(XMLTag.SolucionNombre, OrdenXMLTag.Apertura) + solution.getStrName() + GeneradorXML.GenerarTag(XMLTag.SolucionNombre, OrdenXMLTag.Clausura);
        XMLTemporal +=          GeneradorXML.GenerarTag(XMLTag.SolucionAutor, OrdenXMLTag.Apertura) + solution.getStrAuthor() + GeneradorXML.GenerarTag(XMLTag.SolucionAutor, OrdenXMLTag.Clausura);
        XMLTemporal +=          GeneradorXML.GenerarTag(XMLTag.SolucionArchivo, OrdenXMLTag.Apertura) + solution.getStrFile() + GeneradorXML.GenerarTag(XMLTag.SolucionArchivo, OrdenXMLTag.Clausura);
        XMLTemporal +=          GeneradorXML.GenerarTag(XMLTag.SolucionCarpeta, OrdenXMLTag.Apertura) + solution.getStrFolder() + GeneradorXML.GenerarTag(XMLTag.SolucionCarpeta, OrdenXMLTag.Clausura);
        XMLTemporal +=          GeneradorXML.GenerarTag(XMLTag.SolucionFechaCreado, OrdenXMLTag.Apertura) + solution.getStrCreated() + GeneradorXML.GenerarTag(XMLTag.SolucionFechaCreado, OrdenXMLTag.Clausura);
        XMLTemporal +=          GeneradorXML.GenerarTag(XMLTag.SolucionFechaModificado, OrdenXMLTag.Apertura) + solution.getStrModified() + GeneradorXML.GenerarTag(XMLTag.SolucionFechaModificado, OrdenXMLTag.Clausura);
        XMLTemporal +=          GeneradorXML.GenerarTag(XMLTag.SolucionFechaCompletado, OrdenXMLTag.Apertura) + solution.getStrCompleted() + GeneradorXML.GenerarTag(XMLTag.SolucionFechaCompletado, OrdenXMLTag.Clausura);
        XMLTemporal +=          GeneradorXML.GenerarTag(XMLTag.SolucionFechaEjecutado, OrdenXMLTag.Apertura) + solution.getStrExecuted() + GeneradorXML.GenerarTag(XMLTag.SolucionFechaEjecutado, OrdenXMLTag.Clausura);
        XMLTemporal +=          GeneradorXML.GenerarTag(XMLTag.SolucionFechaPublicado, OrdenXMLTag.Apertura) + solution.getStrPublished() + GeneradorXML.GenerarTag(XMLTag.SolucionFechaPublicado, OrdenXMLTag.Clausura);
        XMLTemporal +=          GeneradorXML.GenerarTag(XMLTag.SolucionDescripcion, OrdenXMLTag.Apertura) + solution.getStrDescription() + GeneradorXML.GenerarTag(XMLTag.SolucionDescripcion, OrdenXMLTag.Clausura);
        XMLTemporal +=          GeneradorXML.GenerarTag(XMLTag.SolucionObservacion, OrdenXMLTag.Apertura) + solution.getStrObservation() + GeneradorXML.GenerarTag(XMLTag.SolucionObservacion, OrdenXMLTag.Clausura);
        XMLTemporal +=      GeneradorXML.GenerarTag(XMLTag.General, OrdenXMLTag.Clausura);
        XMLTemporal +=      GeneradorXML.GenerarTag(XMLTag.Configuracion, OrdenXMLTag.Apertura);
        XMLTemporal +=          GeneradorXML.GenerarTag(XMLTag.PoblacionInicial, OrdenXMLTag.Apertura);
        XMLTemporal +=              GeneradorXML.GenerarTag(XMLTag.PoblacionInicialTamanio, OrdenXMLTag.Apertura) + solution.getIntSize() + GeneradorXML.GenerarTag(XMLTag.PoblacionInicialTamanio, OrdenXMLTag.Clausura);
        XMLTemporal +=              GeneradorXML.GenerarTag(XMLTag.PoblacionInicialTipoCrecimiento, OrdenXMLTag.Apertura) + solution.ObtenerTipoCrecimientoIndice() + GeneradorXML.GenerarTag(XMLTag.PoblacionInicialTipoCrecimiento, OrdenXMLTag.Clausura);
        XMLTemporal +=          GeneradorXML.GenerarTag(XMLTag.PoblacionInicial, OrdenXMLTag.Clausura);
        
        //Métodos
        XMLTemporal +=          GeneradorXML.GenerarTag(XMLTag.MetodoCargaDatos, OrdenXMLTag.Apertura);
        XMLTemporal +=              GeneradorXML.GenerarTagsMetodos(solution.ObtenerDescripcionDeMetodo(TiposMetodos.CargaDatos));
        XMLTemporal +=          GeneradorXML.GenerarTag(XMLTag.MetodoCargaDatos, OrdenXMLTag.Clausura);
        XMLTemporal +=          GeneradorXML.GenerarTag(XMLTag.MetodoSeleccion, OrdenXMLTag.Apertura);
        XMLTemporal +=              GeneradorXML.GenerarTagsMetodos(solution.ObtenerDescripcionDeMetodo(TiposMetodos.Seleccion));
        XMLTemporal +=          GeneradorXML.GenerarTag(XMLTag.MetodoSeleccion, OrdenXMLTag.Clausura);
        XMLTemporal +=          GeneradorXML.GenerarTag(XMLTag.MetodoMutacion, OrdenXMLTag.Apertura);
        XMLTemporal +=              GeneradorXML.GenerarTagsMetodos(solution.ObtenerDescripcionDeMetodo(TiposMetodos.Mutacion));
        XMLTemporal +=          GeneradorXML.GenerarTag(XMLTag.MetodoMutacion, OrdenXMLTag.Clausura);
        XMLTemporal +=          GeneradorXML.GenerarTag(XMLTag.MetodoFuncionAptitud, OrdenXMLTag.Apertura);
        XMLTemporal +=              GeneradorXML.GenerarTagsMetodos(solution.ObtenerDescripcionDeMetodo(TiposMetodos.FuncionAptitud));
        XMLTemporal +=          GeneradorXML.GenerarTag(XMLTag.MetodoFuncionAptitud, OrdenXMLTag.Clausura);
        XMLTemporal +=          GeneradorXML.GenerarTag(XMLTag.MetodoCruzamiento, OrdenXMLTag.Apertura);
        XMLTemporal +=              GeneradorXML.GenerarTagsMetodos(solution.ObtenerDescripcionDeMetodo(TiposMetodos.Cruzamiento));
        XMLTemporal +=          GeneradorXML.GenerarTag(XMLTag.MetodoCruzamiento, OrdenXMLTag.Clausura);
        XMLTemporal +=          GeneradorXML.GenerarTag(XMLTag.MetodoCromosoma, OrdenXMLTag.Apertura);
        XMLTemporal +=              GeneradorXML.GenerarTagsMetodos(solution.ObtenerDescripcionDeMetodo(TiposMetodos.Cromosoma));
        XMLTemporal +=          GeneradorXML.GenerarTag(XMLTag.MetodoCromosoma, OrdenXMLTag.Clausura);
        XMLTemporal +=          GeneradorXML.GenerarTag(XMLTag.MetodoInformeResultados, OrdenXMLTag.Apertura);
        XMLTemporal +=              GeneradorXML.GenerarTagsMetodos(solution.ObtenerDescripcionDeMetodo(TiposMetodos.InformeResultado));
        XMLTemporal +=          GeneradorXML.GenerarTag(XMLTag.MetodoInformeResultados, OrdenXMLTag.Clausura);
        XMLTemporal +=          GeneradorXML.GenerarTag(XMLTag.MetodoParo, OrdenXMLTag.Apertura);
        XMLTemporal +=              GeneradorXML.GenerarTagsMetodos(solution.ObtenerDescripcionDeMetodo(TiposMetodos.Paro));
        XMLTemporal +=          GeneradorXML.GenerarTag(XMLTag.MetodoParo, OrdenXMLTag.Clausura);
        
        XMLTemporal +=          GeneradorXML.GenerarTag(XMLTag.ArchivosResultados, OrdenXMLTag.Apertura);
        XMLTemporal +=              GeneradorXML.GenerarTagsResultados(solution);
        XMLTemporal +=          GeneradorXML.GenerarTag(XMLTag.ArchivosResultados, OrdenXMLTag.Clausura);        
        
        XMLTemporal +=      GeneradorXML.GenerarTag(XMLTag.Configuracion, OrdenXMLTag.Clausura);
        XMLTemporal +=  GeneradorXML.GenerarTag(XMLTag.Elementos, OrdenXMLTag.Clausura);
        XMLTemporal += GeneradorXML.GenerarTag(XMLTag.Raiz, OrdenXMLTag.Clausura);
        
        return XMLTemporal;
    }
    
    public static String GenerarTagsMetodos(HashMap<TiposDatos, Object> Metodo){
        String XMLTemporal = "";
        if (Metodo == null)
            return XMLTemporal;
        
        Iterator<Map.Entry<TiposDatos, Object>> entries = Metodo.entrySet().iterator();
        while (entries.hasNext()){
            Map.Entry<TiposDatos, Object> entry = entries.next();
            if (entry.getValue() instanceof String){
                XMLTemporal += GeneradorXML.GenerarTag(GeneradorXML.ObtenerTag(entry.getKey()), OrdenXMLTag.Apertura) + entry.getValue() + GeneradorXML.GenerarTag(GeneradorXML.ObtenerTag(entry.getKey()), OrdenXMLTag.Clausura);
            }else{
                //ArrayList
                ArrayList<HashMap<TiposDatos, Object>> Parametros = (ArrayList<HashMap<TiposDatos, Object>>)entry.getValue();
                for (HashMap<TiposDatos, Object> Parametro : Parametros){
                    XMLTemporal += GeneradorXML.GenerarTag(XMLTag.Parametro, OrdenXMLTag.Apertura);
                    XMLTemporal += GeneradorXML.GenerarTagsMetodos(Parametro);
                    XMLTemporal += GeneradorXML.GenerarTag(XMLTag.Parametro, OrdenXMLTag.Clausura);
                }
            }
        }
        return XMLTemporal;
    }
    
    public static String GenerarTagsResultados(Solution Solucion){
        String XMLTemporal = "";
        if (Solucion == null)
            return XMLTemporal;
        
        
        for (EGAFile File : Solucion.getResultEGAFiles()){
            XMLTemporal += GeneradorXML.GenerarTag(XMLTag.ArchivoResultado, OrdenXMLTag.Apertura);
            if (File.GetName() != null && !File.GetName().isEmpty())
                XMLTemporal += GeneradorXML.GenerarTag(XMLTag.ArchivoResultadoNombre, OrdenXMLTag.Apertura) + File.GetName() + GeneradorXML.GenerarTag(XMLTag.ArchivoResultadoNombre, OrdenXMLTag.Clausura);
            XMLTemporal += GeneradorXML.GenerarTag(XMLTag.ArchivoResultadoUbicacion, OrdenXMLTag.Apertura) + File.GetPath() + GeneradorXML.GenerarTag(XMLTag.ArchivoResultadoUbicacion, OrdenXMLTag.Clausura);
            XMLTemporal += GeneradorXML.GenerarTag(XMLTag.ArchivoResultado, OrdenXMLTag.Clausura);
        }
        return XMLTemporal;
    }
    
    

    private static XMLTag ObtenerTag(TiposDatos Key){
        switch(Key){
            case Nombre: return XMLTag.MetodoNombre;
            case Ubicacion: return XMLTag.MetodoUbicacion;
            case Valor: return XMLTag.ParametroValor;
            default: return null;
        }
    }
    
    private static String GenerarTag(XMLTag TipoTag, OrdenXMLTag OrdenTag){
        String Tag = "";
        
        Iterator<Map.Entry<XMLTag, String>> entries = Tags.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<XMLTag, String> entry = entries.next();
            if (entry.getKey() == TipoTag){
                Tag = GeneradorXML.XMLCaracterInicial;
                Tag += EsClausura(OrdenTag) ? GeneradorXML.XMLCaracterClausura : "";
                Tag += entry.getValue(); 
                Tag += GeneradorXML.XMLCaracterFinal;
            }
        }
        return Tag;
    }
    
}
