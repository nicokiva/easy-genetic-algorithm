package configuration;
/**
 *
 * @author Nicolas
 */
public class Paths {
    public String strHome = new java.io.File("").getAbsolutePath();
    
    public String strDBExtension = ".bin";
    public String strOperadoresExtension = ".java";
    public String strSolucionesExtension = ".xml";

    public String strResources = "res";
    public String strSystem = "system";
    
    public String strMain = "C:\\\\";
    
    public String strDB = this.strSystem + "\\db";
    public String strMetodos = this.strSystem + "\\metodos";
    public String strSoluciones = this.strSystem + "\\solutions";
    
    public String strSolucion = "solucion";
    public String strParo = "paro";
    public String strSeleccion = "seleccion";
    public String strCruzamiento = "cruzamiento";
    public String strMutacion = "mutacion";
    public String strCromosoma = "cromosoma";
    public String strInforme = "informe";
    public String strAptitud = "aptitud";
    public String strAyudante = "ayudante";
    
    public String strSolucionDB = this.strDB + "\\" + this.strSolucion + this.strDBExtension;
    public String strParoDB = this.strDB + "\\" + this.strParo + this.strDBExtension;
    public String strSeleccionDB = this.strDB + "\\" + this.strSeleccion + this.strDBExtension;
    public String strCruzamientoDB = this.strDB + "\\" + this.strCruzamiento + this.strDBExtension;
    public String strMutacionDB = this.strDB + "\\" + this.strMutacion + this.strDBExtension;
    public String strCromosomaDB = this.strDB + "\\" + this.strCromosoma + this.strDBExtension;
    public String strInformeDB = this.strDB + "\\" + this.strInforme + this.strDBExtension;
    public String strAptitudDB = this.strDB + "\\" + this.strAptitud +  this.strDBExtension;
    public String strAyudanteDB = this.strDB + "\\" + this.strAyudante +  this.strDBExtension;
    
    public String strParoMetodos = this.strMetodos + "\\" + this.strParo;
    public String strSeleccionMetodos = this.strMetodos + "\\" + this.strSeleccion;
    public String strCruzamientoMetodos = this.strMetodos + "\\" + this.strCruzamiento;
    public String strMutacionMetodos = this.strMetodos + "\\" + this.strMutacion;
    public String strCromosomaMetodos = this.strMetodos + "\\" + this.strCromosoma;
    public String strInformeMetodos = this.strMetodos + "\\" + this.strInforme;
    public String strAptitudMetodos = this.strMetodos + "\\" + this.strAptitud;
    public String strAyudanteMetodos = this.strAyudante + "\\" + this.strAptitud;
}