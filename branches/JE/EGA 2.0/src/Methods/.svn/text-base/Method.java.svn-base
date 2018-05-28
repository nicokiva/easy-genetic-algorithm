/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Methods;

import cromosoma.FuncionDeAptitud;
import cromosoma.InterfaceCromosoma;
import java.util.ArrayList;
import operadores.CruzamientoInterface;
import operadores.HelperInterface;
import operadores.MutacionInterface;
import operadores.ParoInterface;
import operadores.SeleccionInterface;

/**
 *
 * @author Nicolas
 */
public class Method {
    private Class  interfaz;
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
    private ArrayList<Param> _arrParams = new ArrayList<>();
    
    /* BEGIN GETTERS AND SETTERS */
    
    public Class getInterfaz(){
        return this.interfaz;
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
    }
    
    public ArrayList<Param> getParams(){
        return this._arrParams;
    }
    
    public void setParams(ArrayList<Param> arrParams){
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
    
    /* BEGIN CONSTRUCTORS */
    public Method(){}
    
    public Method(String strFirstLetter){
        this._strFirstLetter = strFirstLetter;
        this.SetTypeFromFirstLetter();
    }
    
    public Method(String strIndex, String strName, String strDescription, String strAlias, boolean boolInSystem, String strPath, String dateCreated, String dateModified, String strAuthor)
    {
        this (strIndex, strName, strDescription, strAlias, boolInSystem, strPath, dateCreated, dateModified);
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
                this.interfaz=InterfaceCromosoma.class;
                break;
            case "S":
                this._strType = "SELECCIÓN";
                this.interfaz=SeleccionInterface.class;
                break;
            case "M":
                this._strType = "MUTACIÓN";
                this.interfaz=MutacionInterface.class;
                break;    
            case "X":
                this._strType = "CRUZAMIENTO";
                this.interfaz=CruzamientoInterface.class;
                break;
            case "O":
                this._strType = "PARO";
                this.interfaz= ParoInterface.class;
                break;
            case "I":
                this._strType = "INFORME";
                break;
            case "H":
                this._strType = "AYUDANTE";
                this.interfaz=HelperInterface.class;
                break;
            case "A":
                this._strType = "FUNCIÓN APTITUD";
                this.interfaz=FuncionDeAptitud.class;
                break;
        }
    }
}
