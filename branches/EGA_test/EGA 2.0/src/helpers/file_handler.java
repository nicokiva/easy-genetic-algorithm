package helpers;

import com.sun.org.apache.xerces.internal.impl.dv.dtd.NMTOKENDatatypeValidator;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import Methods.*;

//For XML parser
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;


/**
 *
 * @author Nicolas
 */

public class file_handler {
    Document _XMLdoc;
    private String _strPathFileToRead = "";
    private String _strPathFileToWrite = "";
    private String _strText = "";
    private byte[] _byteText;
    
    private int _intBytesToRead = 8;
    private int _intTotalBytesReaded = 0;
    private byte[] _byteReadedResult;
    private ArrayList<Object> _strArrXMLReaded;
    
    private ArrayList<HashMap<String, String>> _strArrXMLSolutionHeader;
    private ArrayList<HashMap<String, String>> _strArrXMLSolutionInitialPopulation;
    private ArrayList<HashMap<String, String>> _strArrXMLSolutionSettings;
    private ArrayList<Method> _metArrXMLSolution;
    
    /* BEGIN CONSTRUCTORS */
    public file_handler(){}
    
    public file_handler(String strPath){
        this._strPathFileToRead = strPath;
    }
    /* END CONSTRUCTORS */
    

    /* BEGIN GETTERS AND SETTERS */
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
    
    private String getNativeTagValue(String sTag, Element eElement) {
        if (eElement.getElementsByTagName(sTag).getLength() > 0 && eElement.getElementsByTagName(sTag).item(0).hasChildNodes()){
            NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
            Node nValue = (Node) nlList.item(0);
            return nValue.getNodeValue();
        }else{
            return "";
        }
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
    

    public boolean ReadMethods(){
        if (!this.canRead())
            return false;
                
        try {
            this._metArrXMLSolution = new ArrayList<Method>();
            this._metArrXMLSolution.clear();
            
            String[] strPartsNodesTitle = {"userDataLoadMethod", "chromosomeMethod", "aptitudeMethod", "selectionMethod", "crossingMethod", "mutationMethod", "stopMethod"/*, "inform"*/};
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

        try{
            FileInputStream fstream = new FileInputStream(this._strPathFileToRead); // Open the file
            DataInputStream in = new DataInputStream(fstream); // Get the object of DataInputStream
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            //Read File Line By Line
            while ((strLine = br.readLine()) != null){
              this._strText += strLine + "\n";
            }
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
        if (!this.createNewFile())
            return false;
        
        try{
            FileWriter fstream = new FileWriter(this._strPathFileToWrite); // Create file
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(this._strText);
            out.newLine();
            out.close(); //Close the output stream
            return true;
        }catch (Exception e){//Catch exception if any
            System.err.println("Error: " + e.getMessage());
            return false;
        }
    }

    private boolean createNewFile(){
        try{
            File file = new File(this._strPathFileToWrite);
            file.createNewFile();
            return true;
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return false;
        }
    }
    
    public boolean WriteBinary(){
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
}