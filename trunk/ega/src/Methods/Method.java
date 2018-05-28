/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Methods;

import Presentacion.Auxiliares.data_type_converter;
import Presentacion.Auxiliares.file_handler;
import comp.Compilador;
import configuration.*;
import cromosoma.FabricaDeCromosomasInterface;
import cromosoma.FuncionDeAptitud;
import cromosoma.InterfaceCromosoma;
import elementos.FormatoInformeInterface;
import elementos.HelperInterface;
import elementos.ParoInterface;
import enums.Acciones;
import enums.TiposDatos;
import enums.TiposMetodos;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import operadores.CruzamientoInterface;
import operadores.MutacionInterface;
import operadores.SeleccionInterface;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author Nicolas
 */
public class Method  implements Cloneable {   
    private Class  interfazParametrizable;
    private String _strName;
    private String _strIndex;
    private String _strDescription;
    private String _strAlias;
    private String _strPath;
    private boolean _boolInSystem;
    private String _strAuthor;
    private String _dateCreated;
    private String _dateModified;
    private String _strFirstLetter;
    private String _strType;
    private boolean _blnSelected = false;
    private String _strCode;
    private TiposMetodos _tipoMetodo;
    private List<Param> _arrParams = new ArrayList<>();
    
    Element ParentElement;
    Document DocumentCreator;
    ArrayList<Element> Elements = new ArrayList<Element>();
   
    private static String[] MandatoryAttributes = {"id", "name", "path"};
    private static String[] MandatoryParamAttributes = {"name", "value", "type"};
    
    public file_handler fh = new file_handler();
    private Set<Class> otrasInterfacesQueDebeImplementar;
    private int secuencia;

    public Set<Class> getOtrasInterfacesQueDebeImplementar() {
        return otrasInterfacesQueDebeImplementar;
    }



    
    
    /* BEGIN GETTERS AND SETTERS */
    public void SetearTipoMetodo(TiposMetodos TipoMetodo){
        this._tipoMetodo = TipoMetodo;
    }
    
    public TiposMetodos ObtenerTipoMetodo(){
        return this._tipoMetodo;
    }
    
    public boolean getSelected(){
        return this._blnSelected;
    }
    
    public void setSelected(boolean blnSelected){
        this._blnSelected = blnSelected;
    }
    
    public Class getInterfazParametrizable(){
        return this.interfazParametrizable;
    }
    public String getAuthor(){
        return this._strAuthor;
    }
    
    public void setAuthor(String strAuthor){
        this._strAuthor = strAuthor;
    }
    
    public String getFirstLetter(){
        return this._strFirstLetter;
    }
    
    public void setFirstLetter(String strFirstLetter){
        this._strFirstLetter = strFirstLetter;
        this.SetTypeFromFirstLetter();
    }
    
    public List<Param> getParams(){
        return this._arrParams;
    }
    
    public void setParams(List<Param> arrParams){
        this._arrParams = arrParams;
    }
    
    public boolean getInSystem(){
        return this._boolInSystem;
    }
    
    public void setInSystem(boolean boolInSystem){
        this._boolInSystem = boolInSystem;
    }
    
    public String getModified(){
        return this._dateModified;
    }
    
    public void setModified(String dateModified){
        this._dateModified = dateModified;
    }
    
    public String getCreated(){
        return this._dateCreated;
    }
    
    public void setCreated(String dateCreated){
        this._dateCreated = dateCreated;
    }
    
    /**
     * @return the _strCode
     */
    public String getStrCode() {
        return _strCode;
    }

    /**
     * @param strCode the _strCode to set
     */
    public void setStrCode(String strCode) {
        this._strCode = strCode;
    }
    
    public String getPath(){
        return this._strPath;
    }
    
    public void setPath(String strPath){
        this._strPath = strPath;
    }
    
    public String getAlias(){
        return this._strAlias;
    }
    
    public void setAlias(String strAlias){
        this._strAlias = strAlias;
    }
    
    public String getDescription(){
        return this._strDescription;
    }
    
    public void setDescription(String strDescription){
        this._strDescription = strDescription;
    }
    
    public String getType(){
        return this._strType;
    }
    
    public void setType(String strType){
        this._strType = strType;
        this.SetFirstLetterFromType();
    }
    
    public String getName(){
        return this._strName;
    }
    
    public void setName(String strName){
        this._strName = strName;
    }
    
    public String getIndex(){
        return this._strIndex;
    }
    
    public void setIndex(String strIndex){
        this._strIndex = strIndex;
    }    
    /* END GETTERS AND SETTERS */  
    
    @Override
    public Object clone() {
        try {
            return super.clone();
        }catch (CloneNotSupportedException e) {
            // This should never happen
            throw new InternalError(e.toString());
        }
    }
    
    /* BEGIN CONSTRUCTORS */
    public Method(){}
    
    public Method(String strFirstLetter){
        this._strFirstLetter = strFirstLetter;
        this.SetTypeFromFirstLetter();
    }
    
    public static Method FromDB(String strIndex, String strName, String strDescription, boolean boolInSystem, String strPath, String dateCreated, String dateModified, String strAuthor, String strFirstLetter){
        Method met = new Method(strIndex, strName, strDescription, boolInSystem, strPath, dateCreated, dateModified, strAuthor);
        met.setFirstLetter(strFirstLetter);
        return met;
    }
    
    public static Method BeingEdited (String strName, String strDescription, String strFirstLetter, String strCreated, String strModified, String strCode){
        return new Method(strName, strDescription, strFirstLetter, strCreated, strModified, strCode);
    }
    
    public Method(String strName, String strDescription, String strFirstLetter, String strCreated, String strModified, String strCode){
        this._strName = strName;
        this._strDescription = strDescription;
        this._strFirstLetter = strFirstLetter;
        this._dateCreated = strCreated;
        this._dateModified = strModified;
        this._strCode = strCode;
        this.SetTypeFromFirstLetter();
   }
    
    public Method(String strIndex, String strName, String strDescription, boolean boolInSystem, String strPath, String dateCreated, String dateModified, String strAuthor)
    {
        this (strIndex, strName, strDescription, "", boolInSystem, strPath, dateCreated, dateModified);
        this._strAuthor = strAuthor; 
    }
    
    public Method(String strIndex, String strName, String strDescription, String strAlias, boolean boolInSystem, String strPath, String dateCreated, String dateModified)
    {
        this (strIndex, strName, strDescription, strAlias, boolInSystem, strPath);
        this._dateCreated = dateCreated;
        this._dateModified = dateModified;
    }
    
    public Method(String strIndex, String strName, String strDescription, String strAlias, boolean boolInSystem, String strPath){
        this._strIndex = strIndex;
        this._strName = strName;
        this._strDescription = strDescription;
        this._strAlias = strAlias;
        this._boolInSystem = boolInSystem;
        this._strPath = strPath;
    }
    
    public Method(String strIndex, String strName, String strDescription, String strAlias, boolean boolInSystem, String strPath, String strFirstLetter){
        this (strIndex, strName, strDescription, strAlias, boolInSystem, strPath);
        this._strFirstLetter = strFirstLetter;
        this.SetTypeFromFirstLetter();
    }
    /* END CONSTRUCTORS */
    
    public void clearParams(){
        this._arrParams.clear();
    }
    
    public void SetFirstLetterFromType(){
        switch (this._strType.toUpperCase()){
            case "FUNCIÓN APTITUD":
                this._strFirstLetter = "A";
                break;
            case "CROMOSOMA":
                this._strFirstLetter = "C";
                break;
            case "SELECCIÓN":
                this._strFirstLetter = "S";
                break;
            case "MUTACIÓN":
                this._strFirstLetter = "M";
                break;    
            case "CRUZAMIENTO":
                this._strFirstLetter = "X";
                break;
            case "PARO":
                this._strFirstLetter = "O";
                break;
            case "INFORME":
                this._strFirstLetter = "I";
                break;
            case "AYUDANTE":
                this._strFirstLetter = "H";
                break;
        }
    }

    public void SetTypeFromFirstLetter(){
        SetTypeFromFirstLetter(this._strFirstLetter);
        
    }
    
        public void SetTypeFromFirstLetter(String str){
        switch (str.toUpperCase()){
            case "C":
                this._strType = "CROMOSOMA";
                this.interfazParametrizable=FabricaDeCromosomasInterface.class;
                this.secuencia=1;
                HashSet<Class> lista = new HashSet<Class>();
                lista.add(InterfaceCromosoma.class);
                this.otrasInterfacesQueDebeImplementar = lista;
                this._tipoMetodo = TiposMetodos.Cromosoma;
                break;
            case "S":
                this._strType = "SELECCIÓN";
                this.interfazParametrizable=SeleccionInterface.class;
                this.secuencia=3;
                this._tipoMetodo = TiposMetodos.Seleccion;
                break;
            case "M":
                this._strType = "MUTACIÓN";
                this.interfazParametrizable=MutacionInterface.class;
                this.secuencia=5;
                this._tipoMetodo = TiposMetodos.Mutacion;
                break;    
            case "X":
                this._strType = "CRUZAMIENTO";
                this.interfazParametrizable=CruzamientoInterface.class;
                this.secuencia=4;
                this._tipoMetodo = TiposMetodos.Cruzamiento;
                break;
            case "O":
                this._strType = "PARO";
                this.interfazParametrizable= ParoInterface.class;
                this.secuencia=6;
                this._tipoMetodo = TiposMetodos.Paro;
                break;
            case "I":
                this._strType = "INFORME";
                this.interfazParametrizable= FormatoInformeInterface.class;
                this.secuencia=7;
                this._tipoMetodo = TiposMetodos.InformeResultado;
                break;
            case "H":
                this._strType = "AYUDANTE";
                this.interfazParametrizable=HelperInterface.class;
                this.secuencia=0;
                this._tipoMetodo = TiposMetodos.CargaDatos;
                break;
            case "A":
                this._strType = "FUNCIÓN APTITUD";
                this.interfazParametrizable=FuncionDeAptitud.class;
                this.secuencia=2;
                this._tipoMetodo = TiposMetodos.FuncionAptitud;
                break;
        }
    }

    public int getSecuencia() {
        return secuencia;
    }
    
    private String getNodeParentNameByFirstLetter(){
        switch (this.getFirstLetter().toUpperCase()){
            case "C":
                return "chromosomeMethod";
            case "S":
                return "selectionMethod";
            case "M":
                return "mutationMethod" ;
            case "X":
                return "crossingMethod";
            case "O":
                return "stopMethod";
            case "I":
                return "resultMethod";
            case "H":
                return "userDataLoadMethod";
            case "A":
                return "aptitudeMethod";
            default:
                return "";
        }
    }

    public static void GetFromXMLTree(ArrayList<Method> arrMethods, Element ParentNode, Document doc){
        ArrayList<Element> XMLMethods = new ArrayList<Element>();
        for (Method met : arrMethods){
            met.Elements.clear();
            met.DocumentCreator = doc;

            met.createParentNode();
            met.createBody();
            
            for (Element element : met.Elements){
                met.ParentElement.appendChild(element);
            }
            
            ParentNode.appendChild(met.ParentElement);
        }
    }

    public String getAttribute(String Tag){
        switch (Tag){
            case "id":
                return this.getFirstLetter() + this.getIndex();
            case "name":
                return this.getName();
            case "path":
                return this.getPath();
            default:
                return "";
        }
    }
    
    private void createParentNode(){
        this.ParentElement = this.DocumentCreator.createElement(this.getNodeParentNameByFirstLetter());
    }
    
    private void createBody(){
        for (String Attribute : Method.MandatoryAttributes){
            this.Elements.add(this.createNodeWithText(Attribute, getAttribute(Attribute)));
        }
        
        this.createParamsNode();
    }
    
    private void createParamsNode(){
        if (!this.getParams().isEmpty()){
            for (Param param : this.getParams()){
                Element paramElement = this.createNodeWithOutText("param");
                for (String Attribute : MandatoryParamAttributes){
                    paramElement.appendChild(this.createNodeWithText(Attribute, param.getAttribute(Attribute)));
                }
                this.Elements.add(paramElement);
            }
        }
    }
    
    private Element createNodeWithText(String strTag, String strNodeText){
        if (this.DocumentCreator != null){
            Element nodeElement = this.DocumentCreator.createElement(strTag);
            nodeElement.appendChild(this.DocumentCreator.createTextNode(strNodeText));
            return nodeElement;
        }
        
        return null;
    }
    
    private Element createNodeWithOutText(String Tag){
        if (this.DocumentCreator != null){
            Element nodeElement = this.DocumentCreator.createElement(Tag);
            return nodeElement;
        }
        
        return null;
    }

    public static ArrayList<Method> GetMethodsInDB(String Path, String FirstLetter){
        ArrayList<Method> arrMethods = new ArrayList<Method>();
        file_handler fh = new file_handler();
        Paths paths = new Paths();
        data_type_converter dtc = new data_type_converter();
        
        fh.setPathFileToRead(Path);
        if (fh.ReadBinary()){
            dtc.setByteText(fh.getByteText());
            dtc.fromByteToStringList();

            ArrayList<ArrayList<String>> strArrMethods = dtc.getStrArrText();
            for (ArrayList<String> strMethod : strArrMethods){
                boolean inSystem = false;
                String strLocationFile = strMethod.get(5).toString();
                int length = paths.strHome.length();
                if (strLocationFile.length() > length && (strLocationFile.substring(0, length)).equals(paths.strHome)){
                    strLocationFile = strLocationFile.substring(length + 1);
                    inSystem = true;
                }

                arrMethods.add(Method.FromDB(strMethod.get(0), strMethod.get(1), strMethod.get(3), inSystem, strLocationFile, strMethod.get(6), strMethod.get(7), strMethod.get(8), FirstLetter));
            }
        }

        return arrMethods;
    }    

    public static String GetFileByFirstLetter(ArrayList<Method> methods, String FirstLetter){
        for (Method method : methods){
            if (method.getFirstLetter().equals(FirstLetter))
                return method.getPath().substring(method.getPath().lastIndexOf("\\") + 1);
        }
        
        return "";
    }
    
    public static boolean HasIncluded(ArrayList<Method> methods, String[] FirstLetters){
        int total = FirstLetters.length;
        for(Method met : methods){
            for (String letter : FirstLetters){
                if (met.getFirstLetter().equals(letter) && met.fh.FileFound(met.getPath()).equals(file_handler._fileFound))
                    total--;
            }
        }

        return total == 0;
    }
    
    
    
    public boolean CompletedMinimumFieldsTo (int Action){
        switch(Action){
            case Acciones.Guardar:
                return this.FieldsNeededToSave();
            case Acciones.Publicar:
                return this.FieldsNeededToPublish();
            
        }
        
        return false;
    }
    
    public boolean FieldsNeededToSave(){
        return (!this._strName.isEmpty() && !this._dateCreated.isEmpty() && !this._dateModified.isEmpty() && !this._strCode.isEmpty());
    }
    
    public boolean FieldsNeededToPublish(){
        return (!this._strName.isEmpty() && !this._dateCreated.isEmpty() && !this._dateModified.isEmpty() && !this._strCode.isEmpty() && this.compiled());
    }
    
    private boolean compiled(){
        try {   
            Compilador.pruebaCompilacion(this._strCode);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
    
    
    public ArrayList<HashMap<TiposDatos, String>> ObtenerParametros(){
        ArrayList<HashMap<TiposDatos, String>> Parametros = new ArrayList<HashMap<TiposDatos, String>>();
        
        for (Param Parametro : this._arrParams){
            HashMap<TiposDatos, String> Caracteristicas = new HashMap<TiposDatos, String>();
            Caracteristicas.put(TiposDatos.Nombre, Parametro.getName());
            Caracteristicas.put(TiposDatos.Valor, Parametro.getValue());
            Parametros.add(Caracteristicas);
        }
        
        return Parametros;
    }
}
