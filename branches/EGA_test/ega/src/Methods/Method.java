/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Methods;

import java.util.Date;
import java.util.ArrayList;

/**
 *
 * @author Nicolas
 */
public class Method {
    private String _strName;
    private int _intType;
    private String _strIndex;
    private String _strDescription;
    private String _strAlias;
    private String _strPath;
    private boolean _boolInSystem;
    private String _dateCreated;
    private String _dateModified;
    private ArrayList<Param> _arrParams = new ArrayList<Param>();
    
    /* BEGIN GETTERS AND SETTERS */
    public ArrayList<Param> getParams(){
        return this._arrParams;
    }
    
    public void setParams(ArrayList<Param> arrParams){
        this._arrParams = arrParams;
    }
    
    public int getType(){
        return this._intType;
    }
    
    public void setType(int intType){
        this._intType = intType;
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
    
    public Method(int intType){
        this._intType = intType;
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
    
    /* END CONSTRUCTORS */

}
