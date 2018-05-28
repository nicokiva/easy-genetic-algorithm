/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Auxiliares;

import Methods.*;
import Solutions.Solution;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Nicolas
 */
public class data_type_converter {
    private ArrayList<ArrayList<String>> _strArrText;
    private String _strText;
    private byte[] _byteText;
    private ArrayList<Method> _arrMethods = new ArrayList<Method>();
    
    private String _strLineSeparator = "&";
    private String _strFieldSeparator = "\\|";
    private String _strFieldSeparatorSave = "|";
    
    public OperationResult result = new OperationResult();
    
    public data_type_converter(){}
    
    public data_type_converter(String strText){
        this._strText = strText;
    }
    
    public data_type_converter(ArrayList<ArrayList<String>> strText){
        this._strArrText = strText;
    }
    
    public data_type_converter(byte[] byteText){
        this._byteText = byteText;
    }
    
    /* BEGIN GETTERS AND SETTERS */
    public ArrayList<Method> getArrMethods(){
        return this._arrMethods;
    }
    
    public void setArrMethods(ArrayList<Method> arrMethods){
        this._arrMethods = arrMethods;
    }
    
    public byte[] getByteText(){
        return this._byteText;
    }
    
    public void setByteText(byte[] _byteText){
        this._byteText = _byteText;
    }
    
    public ArrayList<ArrayList<String>> getStrArrText(){
        return this._strArrText;
    }
    
    public void setStrArrText(ArrayList<ArrayList<String>> strArrText){
        this._strArrText = strArrText;
    }
    
    public String getStrText(){
        return this._strText;
    }
    
    public void setStrText(String strText){
        this._strText = strText;
    }
    /* END GETTERS AND SETTERS */
   
    
    public String ConvertToString(){
        this._strText = "";
        for (Method method : this._arrMethods){
            int inSystem = method.getInSystem() == true ? 1 : 0;
            this._strText += method.getIndex() + this._strFieldSeparatorSave + method.getName() + this._strFieldSeparatorSave + method.getAlias()
                + this._strFieldSeparatorSave + method.getDescription() + this._strFieldSeparatorSave + inSystem + this._strFieldSeparatorSave
                + method.getPath() + this._strFieldSeparatorSave + method.getCreated() + this._strFieldSeparatorSave + method.getModified() + this._strFieldSeparatorSave
                + method.getAuthor() + this._strLineSeparator;
        }
        return this._strText;
    }
    
    public void fromMethodToByteString(){
        this._strText = "";
        for (Method method : this._arrMethods){
            int inSystem = method.getInSystem() == true ? 1 : 0;
            this._strText += method.getIndex().trim() + this._strFieldSeparatorSave + method.getName().trim() + this._strFieldSeparatorSave + ""
                + this._strFieldSeparatorSave + method.getDescription().trim() + this._strFieldSeparatorSave + inSystem + this._strFieldSeparatorSave
                + method.getPath().trim() + this._strFieldSeparatorSave + method.getCreated().trim() + this._strFieldSeparatorSave + method.getModified().trim() + this._strFieldSeparatorSave
                + method.getAuthor().trim() + this._strLineSeparator;
        }

        this.fromStringToByteString();
    }
    
    public void ToByteString(ArrayList<Solution> Solutions){
        this._strText = "";
        
        for (Solution solution : Solutions){
            this._strText += solution.getStrName() + this._strFieldSeparatorSave
                + (solution.getStrFolder().trim() + "\\" + solution.getStrFile()) + this._strFieldSeparatorSave
                + solution.getStrCreated().trim() + this._strFieldSeparatorSave
                + solution.getStrModified().trim() + this._strFieldSeparatorSave
                + solution.getStrAuthor().trim() + this._strLineSeparator;
        }
        this.fromStringToByteString();
    }
    
    public void fromStringToByteString(){
        try {
            this._byteText = this._strText.getBytes("UTF-8");
            
            this.result.Status = OperationResult._success;
        } catch (UnsupportedEncodingException ex) {
            this.result.Status = OperationResult._failure;
            this.result.Message = ex.getMessage();
        }
    }

    public void fromByteToStringList(){
        this.fromByteToString();
        this.fromStringToStringList();
    }
    
    public ArrayList<ArrayList<String>> GenerarListaDeString(String Texto){
        this._strText = Texto;
        this.fromStringToStringList();
        return this._strArrText;
    }
    
    public void fromByteToString(){
        try {
            this._strText = new String(this._byteText, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(data_type_converter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void fromStringToStringList(){
        if (this._strText == null || this._strText.isEmpty()){
            this._strArrText = new ArrayList<ArrayList<String>>(0);
            return;
        }
        
        ArrayList<ArrayList<String>> strArrMethods = new ArrayList<ArrayList<String>>();
        String[] strMethods = this._strText.split(this._strLineSeparator);
        String[] strFields;
                
        try{
            for (int a = 0; a < strMethods.length; a++){
                if ((strMethods[a]).lastIndexOf(this._strFieldSeparatorSave) == (strMethods[a].length() - 1))
                    strMethods[a] = strMethods[a] + " |";

                strFields = strMethods[a].split(this._strFieldSeparator);
                ArrayList<String> strArrField = new ArrayList<String>();

                for (String strField : strFields){
                    strField = (strField != null && !strField.isEmpty()) ? strField : "";
                    strField = (strField != "\\") ? strField : "";
                    strArrField.add(strField);
                }

               if (strArrField.size() >= 5)
                    strArrMethods.add(strArrField);
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
        
        this._strArrText = strArrMethods;
    }
}
