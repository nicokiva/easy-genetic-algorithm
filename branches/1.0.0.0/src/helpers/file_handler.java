package helpers;

import Methods.*;
import Solutions.Result;
import Solutions.Solution;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
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
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


/**
 *
 * @author Nicolas
 */

public class file_handler {
    public static final String _fileFound = "Sí";
    public static final String _fileNotFound = "No";
    
    Document _XMLdoc;
    private String _strPathFileToRead = "";
    private String _strPathFileToWrite = "";
    private String _strText = "";
    private byte[] _byteText;
    
    private int _intBytesToRead = 1;
    private int _intTotalBytesReaded = 0;
    private byte[] _byteReadedResult;
    private ArrayList<Object> _strArrXMLReaded;
    
    private ArrayList<HashMap<String, String>> _strArrXMLSolutionHeader;
    private ArrayList<HashMap<String, String>> _strArrXMLSolutionInitialPopulation;
    private ArrayList<HashMap<String, String>> _strArrXMLSolutionSettings;
    private ArrayList<Method> _metArrXMLSolution;
    private ArrayList<EGAFile> _EGAArrXMLResultFiles;
    private ArrayList<EGAFile> _EGAArrXMLInformFiles;
    private ArrayList<EGAFile> _EGAArrXMLTempFiles;
    
    public OperationResult result = new OperationResult();
    
    /* BEGIN CONSTRUCTORS */
    public file_handler(){}
    
    public file_handler(String strPath){
        this._strPathFileToRead = strPath;
    }
    /* END CONSTRUCTORS */
    

    /* BEGIN GETTERS AND SETTERS */
    public ArrayList<EGAFile> getArrXMLResultFiles(){
        return this._EGAArrXMLResultFiles;
    }
    
    public void setArrXMLResultFiles(ArrayList<EGAFile> EGAArrXMLResultFiles){
        this._EGAArrXMLResultFiles = EGAArrXMLResultFiles;
    }

    public ArrayList<EGAFile> getArrXMLInformFiles(){
        return this._EGAArrXMLInformFiles;
    }
    
    public void setArrXMLInformFiles(ArrayList<EGAFile> EGAArrXMLInformFiles){
        this._EGAArrXMLInformFiles = EGAArrXMLInformFiles;
    }
    
    public ArrayList<HashMap<String, String>> getArrXMLSolutionSettings(){
        return this._strArrXMLSolutionSettings;
    }
    
    public void setArrXMLSolutionSettings(ArrayList<HashMap<String, String>> strArrXMLSolutionSettings){
        this._strArrXMLSolutionSettings = strArrXMLSolutionSettings;
    }
    
    public ArrayList<Method> getArrXMLSolution(){
        return this._metArrXMLSolution;
    }
    
    public void setArrXMLSolution(ArrayList<Method> metArrXMLSolution){
        this._metArrXMLSolution = metArrXMLSolution;
    }
    
    public ArrayList<HashMap<String, String>> getArrXMLSolutionInitialPopulation(){
        return this._strArrXMLSolutionInitialPopulation;
    }
    
    public void setArrXMLSolutionInitialPopulation(ArrayList<HashMap<String, String>> strArrXMLSolutionInitialPopulation){
        this._strArrXMLSolutionInitialPopulation = strArrXMLSolutionInitialPopulation;
    }
    
    public ArrayList<HashMap<String, String>> getArrXMLSolutionHeader(){
        return this._strArrXMLSolutionHeader;
    }
    
    public void setArrXMLSolutionHeader(ArrayList<HashMap<String, String>> strArrXMLSolutionHeader){
        this._strArrXMLSolutionHeader = strArrXMLSolutionHeader;
    }       
            
    public ArrayList<Object> getArrXMLReaded(){
        return this._strArrXMLReaded;
    }
    
    public void setArrXMLReaded(ArrayList<Object> strArrXMLReaded){
        this._strArrXMLReaded = strArrXMLReaded;
    }
    
    public byte[] getByteText(){
        return this._byteText;
    }
    
    public void setByteText(byte[] byteText){
        this._byteText = byteText;
    }
    

    public String getText(){
        return this._strText;
    }
    
    public void setText(String strText){
        this._strText = strText;
    }
    
    
    public String getPathFileToRead(){
        return this._strPathFileToRead;
    }
    
    public void setPathFileToRead(String strPath){
        this._strPathFileToRead = strPath;
    }

    
    public String getPathFileToWrite(){
        return this._strPathFileToWrite;
    }
    
    public void setPathFileToWrite(String strPath){
        this._strPathFileToWrite = strPath;
    }
    /* END GETTERS AND SETTERS */
    
    private void resetVars(){
        this._intTotalBytesReaded = 0;
        this._byteReadedResult = null;
    }
    
    private boolean canRead(){
        if (this._strPathFileToRead.length() == 0)
            return false;

        File fileSelected = new File(this._strPathFileToRead);
        return fileSelected.exists();
    }
    
    public void OpenXMLReader(){
        try {
            File fXmlFile = new File(this._strPathFileToRead);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            this._XMLdoc = dBuilder.parse(fXmlFile);
            this._XMLdoc.getDocumentElement().normalize();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean ReadHeader(){
        if (!this.canRead())
            return false;
        
        String[] strHeaderNodesTitle = {"name", "author", "file", "folder", "dateCreated", "dateModified", "dateCompleted", "dateExecuted", "datePublished", "description", "observation"};
        String parentNode = "general";
        
        try{
            this._strArrXMLSolutionHeader = this.ReadPartFromXML(parentNode, strHeaderNodesTitle);
        }catch(Exception e){
            return false;
        }
        
        return true;
    }
    
    public boolean ReadSettings(){
        if (!this.canRead())
            return false;

        String[] strHeaderNodesTitle = {"readOnly", "serverFolder"};
        String parentNode = "settings";
        
        try{
            this._strArrXMLSolutionSettings = this.ReadPartFromXML(parentNode, strHeaderNodesTitle);
        }catch(Exception e){
            return false;
        }

        return true;
    }
    
    public boolean ReadConfiguration(){
        if (!this.canRead())
            return false;

        String[] strHeaderNodesTitle = {"size", "increasingStyle"};
        String parentNode = "initialPopulation";
        
        try{
            this._strArrXMLSolutionInitialPopulation = this.ReadPartFromXML(parentNode, strHeaderNodesTitle);
        }catch(Exception e){
            return false;
        }

        return true;
    }
    
    public ArrayList<HashMap<String, String>> ReadPartFromXML(String parentNode, String[] strHeaderNodesTitle){
        ArrayList<HashMap<String, String>> _strArrXMLSolutionTemp = new ArrayList<HashMap<String, String>>();

        try {
            Node generalNode = this._XMLdoc.getElementsByTagName(parentNode).item(0);
            for (String strHeaderNodeTitle : strHeaderNodesTitle){
                HashMap<String, String> hsValue = new HashMap<String, String>();
                hsValue.put(strHeaderNodeTitle, getNativeTagValue(strHeaderNodeTitle, (Element)generalNode));
                _strArrXMLSolutionTemp.add(hsValue);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return _strArrXMLSolutionTemp;
    }    
    
    public boolean ReadInformFiles(){
        this._EGAArrXMLInformFiles = new ArrayList<EGAFile>();
        
        String parentNode = "reports";    
        this._EGAArrXMLInformFiles = this.ReadFiles(parentNode);     
        return true;
    }
    
    public boolean ReadResultFiles(){
        this._EGAArrXMLResultFiles = new ArrayList<EGAFile>();
        
        String parentNode = "resultFiles";
        this._EGAArrXMLResultFiles = this.ReadFiles(parentNode);
        return true;
    }
    
    public ArrayList<EGAFile> ReadFiles(String parentNode){
        if (!this.canRead())
            return new ArrayList<EGAFile>();
        
        this._EGAArrXMLTempFiles = new ArrayList<EGAFile>();
        String[] strResultNodesTitle = {"name", "path"};
        String[] fileNodes = {"file"};
        
        if (this._XMLdoc.getElementsByTagName(parentNode).getLength() == 0)
            return new ArrayList<EGAFile>();
        
        ArrayList<EGAFile> files = new ArrayList<EGAFile>();
        
        Node hResultNode = this._XMLdoc.getElementsByTagName(parentNode).item(0);
        for (String fileNode : fileNodes){
            NodeList NLFiles = ((Element)hResultNode).getElementsByTagName(fileNode);
            int totalFiles = NLFiles.getLength();
            
            for (int a = 0; a < totalFiles; a++){
                String Name = getNativeTagValue(strResultNodesTitle[0], ((Element)NLFiles.item(a)));
                String Path = getNativeTagValue(strResultNodesTitle[1], ((Element)NLFiles.item(a)));
                
                files.add(EGAFile.FromXML(Name, Path));
            }
        }
        
        return files;
    }

    public boolean ReadMethods(){
        if (!this.canRead())
            return false;
                
        try {
            this._metArrXMLSolution = new ArrayList<Method>();
            this._metArrXMLSolution.clear();
            
            String[] strPartsNodesTitle = {"userDataLoadMethod", "chromosomeMethod", "aptitudeMethod", "selectionMethod", "crossingMethod", "mutationMethod", "stopMethod", "resultMethod"};
            String parentNode = "configuration";
            
            if (this._XMLdoc.getElementsByTagName(parentNode).getLength() == 0)
                return true;

            Node hpartsNode = this._XMLdoc.getElementsByTagName(parentNode).item(0); //parts
            for (String strPartsNodeTitle : strPartsNodesTitle){                

                if (((Element)hpartsNode).getElementsByTagName(strPartsNodeTitle).getLength() > 0){
                    Method method = new Method();
                    ArrayList<Param> arrParams = new ArrayList<>();
                    Node methodNode = ((Element)hpartsNode).getElementsByTagName(strPartsNodeTitle).item(0); //the method node

                    method.setIndex(getNativeTagValue("id", (Element) methodNode));
                    method.setName(getNativeTagValue("name", (Element) methodNode));
                    method.setPath(getNativeTagValue("path", (Element) methodNode));
                    NodeList nlParams = ((Element)methodNode).getElementsByTagName("param");
                    for(int a = 0; a < nlParams.getLength(); a++){
                        Node nodeParam = nlParams.item(a);
                        Param param = new Param(getNativeTagValue("name", (Element) nodeParam), getNativeTagValue("value", (Element) nodeParam), getNativeTagValue("type", (Element) nodeParam));
                        arrParams.add(param);
                    }
                    method.setParams(arrParams);
                    this._metArrXMLSolution.add(method);
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    
    
    
    
    
    
    
    
    
    
    
    public boolean Read(){
        if (!this.canRead())
            return false;

        this._strText = "";
        try{
            FileInputStream fstream = new FileInputStream(this._strPathFileToRead); // Open the file
            DataInputStream in = new DataInputStream(fstream); // Get the object of DataInputStream
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            while ((strLine = br.readLine()) != null)
                this._strText += strLine + "\n";
            in.close(); //Close the input stream
            return true;
        }catch (Exception e){
            System.err.println("Error: " + e.getMessage());
            return false;
        }
    }
    
    public boolean ReadBinary(){
        if (!this.canRead())
            return false;

        this.resetVars();
        int bytesRead;
        
        try{
            File file = new File(this._strPathFileToRead);
            FileInputStream fstream = new FileInputStream(this._strPathFileToRead); // Open the file
            BufferedInputStream input = new BufferedInputStream(fstream);
                 
            this._byteReadedResult = new byte[(int)file.length()];
            
            while(this._intTotalBytesReaded < this._byteReadedResult.length - 1){
                   
                bytesRead = input.read(this._byteReadedResult, this._intTotalBytesReaded, this._intBytesToRead);

                if (bytesRead > 0)
                  this._intTotalBytesReaded = this._intTotalBytesReaded + bytesRead;
            }        	
            
            
            this._byteText = this._byteReadedResult;
            
            input.close(); //Close the input stream
            return true;
        }catch (Exception e){
            System.err.println("Error: " + e.getMessage());
            return false;
        }
    }
    
    public boolean Write(){
        if (!this.CreateNewFile())
            return false;
        
        try{
            FileWriter fstream = new FileWriter(this._strPathFileToWrite); // Create file
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(this._strText);
            out.close(); //Close the output stream
            return true;
        }catch (Exception e){//Catch exception if any
            System.err.println("Error: " + e.getMessage());
            return false;
        }
    }

    public boolean CreateNewFile(){
        try{
            File file = new File(this._strPathFileToWrite);
            file.createNewFile();
            this.result.Status = OperationResult._success;
            return true;
        }catch(Exception ex){
            this.result.Status = OperationResult._failure;
            this.result.Message = ex.getMessage();
            return false;
        }
    }
    
    public void WriteBinary(String strText){
        try{
            FileOutputStream fOut = new FileOutputStream(this._strPathFileToWrite);
            fOut.write(strText.getBytes());
            fOut.close();
            this.result.Status = OperationResult._success;
        }catch (Exception e){
            this.result.Status = OperationResult._failure;
            this.result.Message = e.getMessage();
        }
    }
    
    public void CleanFile(){
        this._strText = "";
        this.Write();
    }
 
    
    public String FileFound(String strPath){
        File _file = new File(strPath);
        return _file.exists() ? file_handler._fileFound : file_handler._fileNotFound;
    }
    
    public boolean FileIsInside(String strFilePath, String strDirectory){
        File file = new File(strFilePath);
        String strAbsolutePath = file.getAbsolutePath();
        return strAbsolutePath.contains(strDirectory);
    }
    
    public String CopyMethod(String strPath, String strDestination){
        if (this.FileFound(strPath).equals(file_handler._fileNotFound))
            return "";

        String[] strPathParts = strPath.split("\\\\");
        String strFileName = strPathParts[strPathParts.length - 1];
        int position = strFileName.lastIndexOf(".");
        
        long lng = Math.round(Math.random()*1000000000);
        
        strDestination += "\\" + strFileName.substring(0, position) + Integer.toString((int)lng) + "." + strFileName.substring(position + 1);
        
        this.setPathFileToRead(strPath);
        if (this.Read()){
            this.setPathFileToWrite(strDestination);
            this.CreateNewFile();
            this.Write();
            return strDestination;
        }
        
        return "";
    }
    
    public void ResetOperationStatus(){
        this.result.ResetStatus();
    }
    
    public void SaveXML(Solution solSolutionToSave, String PathFile){        
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

           // root elements
            this._XMLdoc = null;
            this._XMLdoc = docBuilder.newDocument();
            Element rootElement = this._XMLdoc.createElement("ega");
            this._XMLdoc.appendChild(rootElement);

           //Settings tab
            this.createNodeWithOutText("settings", rootElement);
            Element settingsNode = (Element)rootElement.getElementsByTagName("settings").item(0);
            String blnReadOnly = solSolutionToSave.getBlnReadOnly() ? "1" : "0";

            this.createNodeWithText("", "isPackage", settingsNode);
            this.createNodeWithText(blnReadOnly, "readOnly", settingsNode);
            this.createNodeWithText(solSolutionToSave.getStrServerFolder(), "serverFolder", settingsNode);

            this.createNodeWithOutText("dataElements", rootElement);

            Element dataElementsNode = (Element)rootElement.getElementsByTagName("dataElements").item(0);
            this.createNodeWithOutText("general", dataElementsNode);

            Element generalNode = (Element)rootElement.getElementsByTagName("general").item(0);
            this.createNodeWithText(solSolutionToSave.getStrName(), "name", generalNode);
            this.createNodeWithText(solSolutionToSave.getStrAuthor(), "author", generalNode);
            this.createNodeWithText(solSolutionToSave.getStrFile(), "file", generalNode);
            this.createNodeWithText(solSolutionToSave.getStrFolder(), "folder", generalNode);
            this.createNodeWithText(solSolutionToSave.getStrCreated(), "dateCreated", generalNode);
            this.createNodeWithText(solSolutionToSave.getStrModified(), "dateModified", generalNode);
            this.createNodeWithText(solSolutionToSave.getStrCompleted(), "dateCompleted", generalNode);
            this.createNodeWithText(solSolutionToSave.getStrExecuted(), "dateExecuted", generalNode);
            this.createNodeWithText(solSolutionToSave.getStrPublished(), "datePublished", generalNode);
            this.createNodeWithText(solSolutionToSave.getStrDescription(), "description", generalNode);
            this.createNodeWithText(solSolutionToSave.getStrObservation(), "observation", generalNode);

            
            this.createNodeWithOutText("configuration", dataElementsNode);
            Element configurationNode = (Element)rootElement.getElementsByTagName("configuration").item(0);
            this.createNodeWithOutText("initialPopulation", configurationNode);
            Element initialPopulationNode = (Element)rootElement.getElementsByTagName("initialPopulation").item(0);
            
            this.createNodeWithText(solSolutionToSave.getIntSize().toString(), "size", initialPopulationNode);
            this.createNodeWithText(Population.getTypeNameFromID(solSolutionToSave.getIntIncreasingStyle()), "increasingStyle", initialPopulationNode);

            Method.GetFromXMLTree(solSolutionToSave.getArrMethods(), configurationNode, this._XMLdoc);
            
            this.createNodeWithOutText("resultFiles", dataElementsNode);
            Element resultFilesElement = (Element)rootElement.getElementsByTagName("resultFiles").item(0);
            EGAFile.GetFromXMLTree(solSolutionToSave.getResultEGAFiles(), resultFilesElement, this._XMLdoc);
            
            // Write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(this._XMLdoc);

            StreamResult result = new StreamResult(new File(PathFile));
            transformer.transform(source, result);

            this.result.Status = OperationResult._success;
        } catch (ParserConfigurationException | TransformerException pce) {
            this.result.Status = OperationResult._failure;
            this.result.Message = pce.getMessage();
        }
    }
    
    private void createNodeWithText(String strNodeText, String strTag, Element parentElement){
        Element nodeElement = this._XMLdoc.createElement(strTag);
        nodeElement.appendChild(this._XMLdoc.createTextNode(strNodeText));
        parentElement.appendChild(nodeElement);
    }
    
    private void createNodeWithOutText(String strTag, Element parentElement){
        Element nodeElement = this._XMLdoc.createElement(strTag);
        parentElement.appendChild(nodeElement);
    }
    
    private String getNativeTagValue(String sTag, Element eElement) {
        if (eElement.getElementsByTagName(sTag).getLength() > 0 && eElement.getElementsByTagName(sTag).item(0).hasChildNodes()){
            NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
            Node nValue = (Node) nlList.item(0);
            return nValue.getNodeValue();
        }else{
            return "";
        }
    }
    
    public void RemoveFile(String Path){
        if (this.FileFound(Path).equals(file_handler._fileFound)){
            File file = new File(Path);
            try{
                file.delete();
                this.result.Status = OperationResult._success;
            }catch(SecurityException ex){
                this.result.Status = OperationResult._failure;
                this.result.Message = ex.getMessage();
            }
        }
    }
    
    public String CopyTheFile(String strPath, String strDestination){
        if (this.FileFound(strPath).equals(file_handler._fileNotFound))
            return "";
        
        this.setPathFileToRead(strPath);
        if (this.Read()){
            this.setPathFileToWrite(strDestination);
            this.CreateNewFile();
            this.Write();
            return strDestination;
        }
        
        return "";
    }
    
    public void CreateFolder(String Path){
        boolean success = (new File(Path)).mkdirs();
        if (!success)
            this.result.Status = OperationResult._failure;
        else
            this.result.Status = OperationResult._success;
    }
    
    public boolean FolderExists(String Path){
        return (new File(Path)).isDirectory();
    }
    
    public Result ReadResults(){
        Result result = Result.Empty();
        if (!this.canRead())
            return result;
        
        String strResultsTag = "reg";
        String strMainTag = "informeEstandar1";
        String strParentTag = "ega";
        
        String SolutionResults = "";
        
        try{            
            
            Node MainNode = this._XMLdoc.getElementsByTagName(strParentTag).item(0);
            NodeList ResultsNodes = ((Element)MainNode).getElementsByTagName(strMainTag);
            Node ResultsNode = ResultsNodes.item(0);
            
            result.setTimeLasted(getNativeTagValue("duracion", (Element)ResultsNode));
            result.setCicles(Integer.parseInt(getNativeTagValue("ciclos", (Element)ResultsNode)));
            result.setTotalPopulation(Integer.parseInt(getNativeTagValue("poblacion", (Element)ResultsNode)));
            result.setTotalMutations(Integer.parseInt(getNativeTagValue("mutaciones", (Element)ResultsNode)));
            result.setMaxAttitude(Integer.parseInt(getNativeTagValue("aptitudMaxima", (Element)ResultsNode)));
            result.setMinAttitude(Integer.parseInt(getNativeTagValue("aptitudMinima", (Element)ResultsNode)));

            NodeList TextResultsNodes = ((Element)MainNode).getElementsByTagName(strResultsTag);

            
            for (int a = 0; a < TextResultsNodes.getLength(); a++){
                Node nValue = TextResultsNodes.item(a).getChildNodes().item(0);
                SolutionResults += nValue.getNodeValue() + System.getProperty("line.separator");
            }

            result.setResultContentString(SolutionResults);
            result.setMinPoints(getNativeTagValue("minima", (Element)ResultsNode));
            result.setMedPoints(getNativeTagValue("media", (Element)ResultsNode));
            result.setMaxPoints(getNativeTagValue("maxima", (Element)ResultsNode));
            
            result.GenerateIntegerArrayPoints();
            this.result.Status = OperationResult._success;
        }catch(Exception e){
            this.result.Status = OperationResult._failure;
            this.result.Message = e.getMessage();
        }finally{
            return result;
        }
    }  
   
    public static List<Param> traerParametros(String path) {


        StringBuilder strBuild = traerParteParametros(path);
        int index = 0;
        List<Param> listaParametros = new LinkedList<Param>();

        int posicion = 0;
        index = strBuild.indexOf("String", posicion);
        char letra;
        StringBuilder parametro, valor;
        while (index != -1) {

            boolean esParametro = true;
            parametro = new StringBuilder();
            valor = new StringBuilder();
            int countComillas=0;
            for (posicion = index + 6; posicion < strBuild.length() && countComillas < 2 && (letra = strBuild.charAt(posicion)) != ';' ; posicion++) {
                    
                    if (letra == '=') {
                        esParametro = false;
                    } else {
                        if (esParametro) {
                            if (letra != ' ') {
                                parametro.append(letra);
                            }
                        } else {
                            
                           if(letra=='"'){ 
                             countComillas++;
                           }else {
                             valor.append(letra);
                           }
                        }
                    }
                
            }
            listaParametros.add(new Param(parametro.toString(), valor.toString(), ""));
            index = strBuild.indexOf("String", posicion);
        }

        return listaParametros;
    }

    private static StringBuilder traerParteParametros(String path) {
        String strLine;
        StringBuilder strBuild = new StringBuilder();

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            int index;
            boolean tagInicioNoEncontrado = true;
            boolean tagCierreNoEncontrado = true;
            while (((strLine = br.readLine()) != null) && tagCierreNoEncontrado) {

                index = strLine.indexOf("//<param>");

                if (index > -1) {
//                                for (int i = index + 8 ; i < strLine.length(); i++) {
//                                        strBuild.append(strLine.charAt(i));
//                                }
                    tagInicioNoEncontrado = false;
                    while (((strLine = br.readLine()) != null) && tagCierreNoEncontrado) {

                        index = strLine.indexOf("//</param>");

                        if (index == -1) {
                            strBuild.append(strLine);

                        } else {

                            tagCierreNoEncontrado = false;

                            for (int i = 0; i < index; i++) {
                                strBuild.append(strLine.charAt(i));
                            }

                        }


                    }
                }
            }
            br.close();
            //si se encontro el tag de inicio pero no el de cierre
            if (!tagInicioNoEncontrado && tagCierreNoEncontrado) {
                System.err.println("No encontro </param>");
                System.exit(-1);
            }
            
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return strBuild;
    }


     public ArrayList<Integer[]> ReadPoints(){
        if (!this.canRead())
            return new ArrayList<Integer[]>();
        
        String GraphicTag = "grafica";
        String[] PointsTag = {"minima", "media", "maxima"};
        
        ArrayList<Integer[]> Points = new ArrayList<Integer[]>();
        
        
        try{
            Node ParentNode = this._XMLdoc.getElementsByTagName(GraphicTag).item(0);
            for (String tag : PointsTag){
                String strPoints = this.getNativeTagValue(tag, (Element)ParentNode);
                String[] strPointsArray = strPoints.split(",");
                
                Integer[] intPoints = new Integer[strPointsArray.length];
                for (int a = 0; a < strPointsArray.length; a++){
                    intPoints[a] = (Integer)Integer.parseInt(strPointsArray[a].trim());
                }
                
                Points.add(intPoints);
            }


            this.result.Status = OperationResult._success;
        }catch(Exception e){
            this.result.Status = OperationResult._failure;
            this.result.Message = e.getMessage();
        }finally{
            return Points;
        }
    }  
    
}