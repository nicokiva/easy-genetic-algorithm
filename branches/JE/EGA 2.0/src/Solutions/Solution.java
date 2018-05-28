/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Solutions;

import Methods.*;
import comp.Compilador;
import cromosoma.FuncionDeAptitud;
import cromosoma.InterfaceCromosoma;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import operadores.*;

/**
 *
 * @author Nicolas
 */
public class Solution {
    private HelperInterface helper = null;
    private OperadorInterface operadorMuta =  null;
    private OperadorInterface operadorCruza = null;
    private OperadorInterface operadorSelec = null;
    private FuncionDeAptitud funcionAp = null;
   
    private Compilador compilador;
    private Map<Class, Class> mapaInterfazClaseImplementacion;
    
    
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
    
    private Population _popPopulationConfiguration; //DEPRECATED
    private ArrayList<Method> _arrMethods;

  
    
    /* BEGIN GETTERS AND SETTERS */
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
    
    public void setPopPopulationConfiguration(Population popPopulationConfiguration){
        this._popPopulationConfiguration = popPopulationConfiguration;
    }
    
    public Population getPopPopulationConfiguration(){
        return this._popPopulationConfiguration;
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
    
    /* END GETTERS AND SETTERS */
    
    public Solution(){}
    
    public Solution(String strName, String strAuthor, String strDescription){
        this._strName = strName;
        this._strAuthor = strAuthor;
        this._strDescription = strDescription;
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
        this._strFile = strFile;
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

    public void SetInitialPopulation(Integer intSize, String strIncreasingStyle){
        this._intSize = intSize;
        this._intIncreasingStyle = this.setIncreasingStyle(strIncreasingStyle);
    }

    private int setIncreasingStyle(String strIncreasingStyle){
        switch (strIncreasingStyle.toLowerCase()){
            case "fixed":
                return 0;
            case "up":
                return 1; 
            case "down":
                return 2;
        }
        return 0;
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
}
