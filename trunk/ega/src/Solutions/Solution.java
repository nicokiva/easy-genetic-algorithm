/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Solutions;

import Methods.*;
import Presentacion.Vinculadores.TiposCrecimientoxTextoxIndice;
import comp.Compilador;
import configuration.Paths;
import enums.*;
import Presentacion.Auxiliares.EGAFile;
import Presentacion.Auxiliares.Encriptador;
import Presentacion.Auxiliares.OperationResult;
import Presentacion.Auxiliares.data_type_converter;
import Presentacion.Auxiliares.file_handler;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author Nicolas
 */
public class Solution implements Cloneable {

    @Override
    public Object clone() {
        try {
            return super.clone();
        }catch (CloneNotSupportedException e) {
            // This should never happen
            throw new InternalError(e.toString());
        }
    }
    
    private Document DocumentCreator;
    
    private file_handler fh = new file_handler();
   
    private Compilador compilador;
    private Map<Class, Class> mapaInterfazClaseImplementacion;
    private Result ExecutionResults;
    public OperationResult result = new OperationResult();
    Paths paths = new Paths();
    
    /* HEADER */
    private String _strName = "";
    private String _strAuthor = "";
    private String _strFile = "";
    private String _strFolder = "";
    private String _strCreated;
    private String _strModified;
    private String _strCompleted;
    private String _strExecuted;
    private String _strPublished;
    private String _strDescription = "";
    private String _strObservation = "";
    
    /* SETTINGS */
    private boolean _blnReadOnly = false;
    private String _strServerFolder = "";
    
    /* INITIAL POPULATION */
    private Integer _intSize = 0;
    private int _intIncreasingStyle = 0;
    private TiposCrecimiento _tipoCrecimiento;
    
    private ArrayList<Method> _arrMethods;
    private ArrayList<EGAFile> _arrResultFiles;

    private boolean _succesfullyExecuted = false;
    
    /* BEGIN GETTERS AND SETTERS */
    /**
     * @return the result
     */
    
    
    
    public void ExecutionCompleted(){
        this._succesfullyExecuted = true;
    }
    
    public Result getExecutionResults() {
        return this.ExecutionResults;
    }
    /**
     * @param result the result to set
     */
    public void setExecutionResults(Result ExecutionResults) {
        this.ExecutionResults = ExecutionResults;
    }
    
    public void setResultEGAFiles(ArrayList<EGAFile> arrResultFiles){
        this._arrResultFiles = arrResultFiles;
    }
    
    public ArrayList<EGAFile> getResultEGAFiles(){
        return this._arrResultFiles;
    }
    /**
     * @return the _strSize
     */
    public Integer getIntSize() {
        return _intSize;
    }

    /**
     * @param strSize the _strSize to set
     */
    public void setIntSize(Integer intSize) {
        this._intSize = intSize;
    }

    /**
     * @return the _strIncreasingStyle
     */
    public int getIntIncreasingStyle() {
        return _intIncreasingStyle;
    }

    /**
     * @param strIncreasingStyle the _strIncreasingStyle to set
     */
    public void setIntIncreasingStyle(int intIncreasingStyle) {
        this._intIncreasingStyle = intIncreasingStyle;
    }
    
    /**
     * @return the _blnReadOnly
     */
    public boolean getBlnReadOnly() {
        return _blnReadOnly;
    }

    /**
     * @param strReadOnly the _blnReadOnly to set
     */
    public void setBlnReadOnly(boolean blnReadOnly) {
        this._blnReadOnly = blnReadOnly;
    }

    /**
     * @return the _strServerFolder
     */
    public String getStrServerFolder() {
        return _strServerFolder;
    }

    /**
     * @param strServerFolder the _strServerFolder to set
     */
    public void setStrServerFolder(String strServerFolder) {
        this._strServerFolder = strServerFolder;
    }
    
    public void setArrMethods(ArrayList<Method> arrMethods){
        this._arrMethods = arrMethods;
    }
    
    public ArrayList<Method> getArrMethods(){
        return this._arrMethods;
    }
    
    public void setStrCreated(String strCreated){
        this._strCreated = strCreated;
    }
    
    public String getStrCreated(){
        return this._strCreated;
    }
    
    public void setStrModified(String strModified){
        this._strModified = strModified;
    }
    
    public String getStrModified(){
        return this._strModified;
    }
    
    public void setStrName(String strName){
        this._strName = strName;
    }
    
    public String getStrName(){
        return this._strName;
    }
    
    public void setStrAuthor(String strAuthor){
        this._strAuthor = strAuthor;
    }
    
    public String getStrAuthor(){
        return this._strAuthor;
    }
    
    public void setStrDescription(String strDescription){
        this._strDescription = strDescription;
    }
    
    public String getStrDescription(){
        return this._strDescription;
    }
     /**
     * @return the _strFile
     */
    public String getStrFile() {
        return _strFile;
    }

    /**
     * @param strFile the _strFile to set
     */
    public void setStrFile(String strFile) {
        this._strFile = strFile;
    }

    /**
     * @return the _strFolder
     */
    public String getStrFolder() {
        return _strFolder;
    }

    /**
     * @param strFolder the _strFolder to set
     */
    public void setStrFolder(String strFolder) {
        this._strFolder = strFolder;
    }

    /**
     * @return the _strCompleted
     */
    public String getStrCompleted() {
        return _strCompleted;
    }

    /**
     * @param strCompleted the _strCompleted to set
     */
    public void setStrCompleted(String strCompleted) {
        this._strCompleted = strCompleted;
    }

    /**
     * @return the _strExecuted
     */
    public String getStrExecuted() {
        return _strExecuted;
    }

    /**
     * @param strExecuted the _strExecuted to set
     */
    public void setStrExecuted(String strExecuted) {
        this._strExecuted = strExecuted;
    }

    /**
     * @return the _strPublished
     */
    public String getStrPublished() {
        return _strPublished;
    }

    /**
     * @param strPublished the _strPublished to set
     */
    public void setStrPublished(String strPublished) {
        this._strPublished = strPublished;
    }

    /**
     * @return the _strObservation
     */
    public String getStrObservation() {
        return _strObservation;
    }

    /**
     * @param strObservation the _strObservation to set
     */
    public void setStrObservation(String strObservation) {
        this._strObservation = strObservation;
    }
    
    public int EsSoloLectura(){
        if (this._blnReadOnly == true)
            return 1;
                    
        return 0;
    }
    
    /* END GETTERS AND SETTERS */
    
    public Solution(){}
    
    public Solution(String strName, String strAuthor, String strDescription){
        this._strName = strName;
        this._strAuthor = strAuthor;
        this._strDescription = strDescription;
    }
    
    public Solution (String Name, String Folder, String File, String Created, String Modified, String Author){
        this._strName = Name.trim();
        this._strFile = File.trim();
        this._strFolder = Folder.trim();
        this._strCreated = Created.trim();
        this._strModified = Modified.trim();
        this._strAuthor = Author.trim();
    }
        
    public Solution(String strName, String strAuthor, String strDescription, String strDateCreated, String strDateModified){
        this._strName = strName;
        this._strAuthor = strAuthor;
        this._strDescription = strDescription;
        this._strCreated = strDateCreated;
        this._strModified = strDateModified;
    }
    
    public void SetHeader(String strName, String strAuthor, String strFile, String strFolder, String strCreated, String strModified, String strCompleted, String strExecuted, String strPublished, String strDescription, String strObservation){
        this._strName = strName;
        this._strAuthor = strAuthor;
        this._strFile = strFile.substring(strFile.length() - 4).equals(".xml") ? strFile.substring(0, strFile.length() - 4) : strFile;
        this._strFolder = strFolder;
        this._strCreated = strCreated;
        this._strModified = strModified;
        this._strCompleted = strCompleted;
        this._strExecuted = strExecuted;
        this._strPublished = strPublished;
        this._strDescription = strDescription;
        this._strObservation = strObservation;
    }

    public void SetSettings(boolean blnReadOnly, String strServerFolder){
        this._blnReadOnly = blnReadOnly;
        this._strServerFolder = strServerFolder;
    }

    public void SetInitialPopulation(Integer intSize, Integer IncreasingStyle){
        this._intSize = intSize;
        this._tipoCrecimiento = TiposCrecimientoxTextoxIndice.ObtenerTipoCrecimiento(IncreasingStyle);
    }
    
    public String ObtenerTipoCrecimientoTexto(Integer TipoCrecimiento){
        return TiposCrecimientoxTextoxIndice.ObtenerTexto(TipoCrecimiento);
    }
    
    public Integer ObtenerTipoCrecimientoIndice(){
        return TiposCrecimientoxTextoxIndice.ObtenerIndice(this._tipoCrecimiento);
    }
    
    public HashMap<TiposDatos, Object> ObtenerDescripcionDeMetodo(TiposMetodos TipoMetodo){
        ArrayList<HashMap<TiposDatos, String>> Parametros = new ArrayList<HashMap<TiposDatos, String>>();
        
        Method Metodo = this.ObtenerMetodo(TipoMetodo);
        if (Metodo == null)
            return null;
        
        HashMap<TiposDatos, Object> Caracteristicas = new HashMap<TiposDatos, Object>();
        Caracteristicas.put(TiposDatos.Nombre, this.ObtenerDatoDeMetodo(TipoMetodo, TiposDatos.Nombre));
        Caracteristicas.put(TiposDatos.Ubicacion, this.ObtenerDatoDeMetodo(TipoMetodo, TiposDatos.Ubicacion));
        
        
        Parametros.addAll(Metodo.ObtenerParametros());
        Caracteristicas.put(TiposDatos.Parametro, Parametros);
        return Caracteristicas;
    }
    
    public String ObtenerDatoDeMetodo(TiposMetodos TipoMetodo, TiposDatos DatoBuscado){
        Method Metodo = this.ObtenerMetodo(TipoMetodo);
        if (Metodo == null)
            return "";

        switch(DatoBuscado){
            case Nombre: return Metodo.getName();
            case Id: return Metodo.getFirstLetter() + Metodo.getIndex();
            case Ubicacion: return Metodo.getPath();
            default: return Metodo.getName();
        }
    }
    
    private Method ObtenerMetodo(TiposMetodos TipoMetodo){
        for (Method Metodo : this._arrMethods){
            if (Metodo.ObtenerTipoMetodo() == TipoMetodo)
                return Metodo;
        }
        
        return null;
    }
    
    public boolean Puede(int Accion){
        switch(Accion){
            case Acciones.Guardar:
                return this.CamposRequeridosParaGuardar();
            case Acciones.Exportar:
                return this.CamposRequeridosParaExportar();
            case Acciones.Publicar:
                return this.CamposRequeridosParaPublicar();
            case Acciones.Ejecutar:
                return this.CamposRequeridosParaEjecutar();
        }
        
        return false;
    }
    
    public boolean CamposRequeridosParaEjecutar(){
        String[] MinimumFirstLetterMethods = {"C", "S", "M", "X", "O", "A"};
        return (this._intSize > 0 && Method.HasIncluded(this._arrMethods, MinimumFirstLetterMethods));
    }
    
    public boolean CamposRequeridosParaExportar(){
        return (!this._strAuthor.isEmpty() && !this._strCreated.isEmpty() && !this._strModified.isEmpty() && !this.fileEmpty() && !this._strName.isEmpty());
    }
    
    public boolean CamposRequeridosParaGuardar(){
        return (!this.fileEmpty() &&  !this._strFolder.isEmpty());
    }
    
    private boolean fileEmpty(){
        return (this._strFile.isEmpty() || this._strFile.trim().equals(paths.strSolucionesExtension));
    }
    
    public boolean CamposRequeridosParaPublicar(){
        return (!this._strAuthor.isEmpty() && 
                !this._strCreated.isEmpty() && 
                !this._strModified.isEmpty() && 
                !this.fileEmpty() && 
                !this._strServerFolder.isEmpty() && 
                !this._strName.isEmpty());
    }
    
//    public void armate(List<String> paths, Set<Class> setInterfaces) {
//        this.compilador= new Compilador();
//        this.mapaInterfazClaseImplementacion= new HashMap<Class, Class>();
//        List<Class> listaImplementacionesFaltantes = this.compilador.compilarYllenarMapaConImplementaciones(paths, "solucionHarcodeada", this.mapaInterfazClaseImplementacion, setInterfaces);
//
//        //TODO ERROR
//        if(!listaImplementacionesFaltantes.isEmpty()){
//            System.out.println("Faltan implementar");
//            return;
//        }
//    }
//    
//     public InterfaceCromosoma newCromosoma() {
//        // TODO Auto-generated method stub
//        // this.mapaInterfazClaseImplementacion.get(InterfaceCromosoma.class);
//        InterfaceCromosoma crom = ((InterfaceCromosoma) instanciarObjetoQueImplementa(InterfaceCromosoma.class));
//        crom.setSolucion(this);
//        return crom;
//    }
//     
//    public FuncionDeAptitud getFuncionDeAptitud() {
//        // TODO Auto-generated method stub
//        if(this.funcionAp == null){
//            this.funcionAp = (FuncionDeAptitud) instanciarObjetoQueImplementa(FuncionDeAptitud.class);
//        }
//        return this.funcionAp;
//    }
//
//    private Object instanciarObjetoQueImplementa(Class name) {
//        // TODO Auto-generated method stub
//        Object ob = null;
//        try {
//            ob = this.mapaInterfazClaseImplementacion.get(name).newInstance();
//        } catch (InstantiationException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//        } catch (IllegalAccessException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//        }
//
//        return ob;
//    }
//
//    public OperadorInterface getHelper() {
//        // TODO Auto-generated method stub
//        if(this.helper==null){
//            this.helper = (HelperInterface) instanciarObjetoQueImplementa(HelperInterface.class);
//        }
//        return this.helper;
//
//    }
//
//    public OperadorInterface getOperadorSeleccion() {
//        // TODO Auto-generated method stub
//        if(this.operadorSelec == null){
//                this.operadorSelec = (SeleccionInterface) instanciarObjetoQueImplementa(SeleccionInterface.class);
//        }
//        return this.operadorSelec;
//    }
//
//    public OperadorInterface getOperadorCruzamiento() {
//            if(this.operadorCruza == null){
//                this.operadorCruza = (CruzamientoInterface) instanciarObjetoQueImplementa(CruzamientoInterface.class);
//            }
//        return this.operadorCruza;
//    }
//
//    public OperadorInterface getOperadorMutacion() {
//        if(this.operadorMuta == null){
//            this.operadorMuta = (MutacionInterface) instanciarObjetoQueImplementa(MutacionInterface.class);
//        }
//        return this.operadorMuta;
//    }
    
    private boolean haveNecesaryMethods(){
        String[] arrStrNecesaryLetters = {"C", "A", "S", "X", "M", "O"};
        int total = arrStrNecesaryLetters.length;
        
        for(Method method : this._arrMethods){
            for (int a = 0; a < arrStrNecesaryLetters.length; a++){
                if (method.getFirstLetter().equals(arrStrNecesaryLetters[a])){
                    arrStrNecesaryLetters[a] = "";
                    total--;
                }
            }
        }
        
        return (total == 0);
    }
    
    public boolean CanExecute(){
        return this.haveNecesaryMethods();
    }
    
    public static Solution WithDBFields(String Name, String Folder, String File, String Created, String Modified, String Author){
        return new Solution (Name, Folder, File, Created, Modified, Author);
    }
    
    public static ArrayList<Solution> GetSolutionsInDB(){
        file_handler fh = new file_handler();
        Paths paths = new Paths();
        data_type_converter dtc = new data_type_converter();
        ArrayList<Solution> arrSolutions = new ArrayList<Solution>();

        String Texto = Encriptador.Desencriptar(fh.Leer(paths.strSolucionDB));
        ArrayList<ArrayList<String>> solutions = dtc.GenerarListaDeString(Texto);
//        fh.setPathFileToRead(paths.strSolucionDB);
//        if (fh.ReadBinary()){
//        dtc.setByteText(Texto);
//        dtc.fromByteToStringList();
//        }
        
        //ArrayList<ArrayList<String>> solutions = dtc.getStrArrText();
        if (solutions.size() > 0){
            for (ArrayList<String> solution : solutions){
                String Folder = (solution.get(1).substring(0,solution.get(1).lastIndexOf("\\")));
                String File  = (solution.get(1).substring(solution.get(1).lastIndexOf("\\") + 1));
                
                Solution LoadedSolution = Solution.WithDBFields(solution.get(0), Folder, File, solution.get(2), solution.get(3), solution.get(4));
                arrSolutions.add(LoadedSolution);
            }
        }
        return arrSolutions;
    }
    
    public static ArrayList<Solution> UpdateStoredSolutions(Solution CurrentSolution, ArrayList<Solution> SolutionsInDB){
        ArrayList<Solution> SolucionesAlmacenadas = new ArrayList<Solution>();
        SolucionesAlmacenadas.addAll(SolutionsInDB);
        
        for (Solution solution : SolucionesAlmacenadas){
            if (Solution.AreTheSameSolution(solution, CurrentSolution)){
                SolucionesAlmacenadas.remove(solution);
                break;
            }
            
            if (SolucionesAlmacenadas.isEmpty())
                break;
        }
        
        SolucionesAlmacenadas.add(CurrentSolution);
        
        return SolucionesAlmacenadas;
    }
    
    public static boolean AreTheSameSolution(Solution CurrentSolution, Solution SolutionToAdd){
        return (CurrentSolution.getStrFolder().equals(SolutionToAdd.getStrFolder()) && CurrentSolution.getStrFile().equals(SolutionToAdd.getStrFile()));
    }
    
    public void SaveResult(String Path){
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

           // root elements
            this.DocumentCreator = null;
            this.DocumentCreator = docBuilder.newDocument();
            Element rootElement = this.DocumentCreator.createElement("ega");
            this.DocumentCreator.appendChild(rootElement);

            this.createNodeWithOutText("informeEstandar1", rootElement);
            Element informNode = (Element)rootElement.getElementsByTagName("informeEstandar1").item(0);
            
            this.createNodeWithText(this.getStrName(), "titulo", informNode);
            this.createNodeWithText("Solución Genética", "subTitulo", informNode);
            this.createNodeWithText(this.getStrAuthor(), "autor", informNode);
            this.createNodeWithText(this.getStrDescription(), "descripcion", informNode);
            
            this.createNodeWithText(Method.GetFileByFirstLetter(this._arrMethods, "H"), "datos", informNode);
            this.createNodeWithText(Method.GetFileByFirstLetter(this._arrMethods, "C"), "cromosoma", informNode);
            this.createNodeWithText(Method.GetFileByFirstLetter(this._arrMethods, "A"), "aptitud", informNode);
            this.createNodeWithText(Method.GetFileByFirstLetter(this._arrMethods, "S"), "seleccion", informNode);
            this.createNodeWithText(Method.GetFileByFirstLetter(this._arrMethods, "X"), "cruzamiento", informNode);
            this.createNodeWithText(Method.GetFileByFirstLetter(this._arrMethods, "M"), "mutacion", informNode);
            this.createNodeWithText(Method.GetFileByFirstLetter(this._arrMethods, "O"), "parada", informNode);

            Iterator it = this.getExecutionResults().getResultContent().iterator();
            while(it.hasNext()) {
                String str= (String) it.next();
                this.createNodeWithText(str, "reg",informNode);
            }
            
            this.createNodeWithText(this.getExecutionResults().getTimeLasted(), "duracion", informNode);
            this.createNodeWithText(this.getExecutionResults().getCicles().toString(), "ciclos", informNode);
            this.createNodeWithText(this.getExecutionResults().getTotalPopulation().toString(), "poblacion", informNode);
            this.createNodeWithText(this.getExecutionResults().getTotalMutations().toString(), "mutaciones", informNode);
            this.createNodeWithText(this.getExecutionResults().getMaxAttitude().toString(), "aptitudMinima", informNode);
            this.createNodeWithText(this.getExecutionResults().getMinAttitude().toString(), "aptitudMaxima", informNode);
            
            this.createNodeWithOutText("grafica", rootElement);
            Element graphicsNode = (Element)rootElement.getElementsByTagName("grafica").item(0);
            this.createNodeWithText(this.getExecutionResults().getMinPoints(), "minima", graphicsNode);
            this.createNodeWithText(this.getExecutionResults().getMedPoints(), "media", graphicsNode);
            this.createNodeWithText(this.getExecutionResults().getMaxPoints(), "maxima", graphicsNode);

            // Write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(this.DocumentCreator);

            StreamResult result = new StreamResult(new File(Path));
            
            String strPath = result.getSystemId();
            if (strPath.substring(0, 6).equals("file:/"))
                result.setSystemId(strPath.substring(6));
            transformer.transform(source, result);

            this.result.Status = OperationResult._success;
        } catch (ParserConfigurationException | TransformerException pce) {
            this.result.Status = OperationResult._failure;
            this.result.Message = pce.getMessage();
        }
    }
    
    private void createNodeWithText(String strNodeText, String strTag, Element parentElement){
        Element nodeElement = this.DocumentCreator.createElement(strTag);
        nodeElement.appendChild(this.DocumentCreator.createTextNode(strNodeText));
        parentElement.appendChild(nodeElement);
    }
    
    private void createNodeWithOutText(String strTag, Element parentElement){
        Element nodeElement = this.DocumentCreator.createElement(strTag);
        parentElement.appendChild(nodeElement);
    }

    /**
     * @return the _tipoCrecimiento
     */
    public TiposCrecimiento getTipoCrecimiento() {
        return _tipoCrecimiento;
    }

    /**
     * @param tipoCrecimiento the _tipoCrecimiento to set
     */
    public void setTipoCrecimiento(TiposCrecimiento tipoCrecimiento) {
        this._tipoCrecimiento = tipoCrecimiento;
    }
}
