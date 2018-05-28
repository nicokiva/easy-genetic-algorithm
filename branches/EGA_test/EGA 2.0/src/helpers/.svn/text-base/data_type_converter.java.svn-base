/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import java.util.ArrayList;
import Methods.*;

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
    
    public void setStrArrText(ArrayList<String> strArrText){
        this._strArrText = _strArrText;
    }
    
    public String getStrText(){
        return this._strText;
    }
    
    public void setStrText(String strText){
        this._strText = strText;
    }
    /* END GETTERS AND SETTERS */
    
    public String fromMethodToByteString(){
        this._strText = "";
        for (Method method : this._arrMethods){
            int inSystem = method.getInSystem() == true ? 1 : 0;
            this._strText += method.getIndex() + this._strFieldSeparatorSave + method.getName() + this._strFieldSeparatorSave + method.getAlias()
                + this._strFieldSeparatorSave + method.getDescription() + this._strFieldSeparatorSave + inSystem + this._strFieldSeparatorSave
                + method.getPath() + this._strFieldSeparatorSave + method.getCreated() + this._strFieldSeparatorSave + method.getModified() + this._strFieldSeparatorSave
                + method.getAuthor() + this._strLineSeparator;
        }
        
       // this.setStrText(this._strText.replaceAll("\\", "")); // Not replacing this value

        return this.fromStringToByteString();
    }
    
    public String fromStringToByteString(){
        this._byteText = this._strText.getBytes();

        StringBuilder binary = new StringBuilder();
        for (byte b : this._byteText)
        {
           int val = b;
           for (int i = 0; i < 8; i++)
           {
              binary.append((val & 128) == 0 ? 0 : 1);
              val <<= 1;
           }
        }

        return binary.toString();
    }

    public void fromByteToStringList(){
        this.fromByteToString();
        this.fromStringToStringList();
    }
    
    public void fromByteToString(){
        if ((this._byteText == null) || (this._byteText.length == 0)){
            //this._byteText = new byte[0];
            this._strText = null;
            return;
        }
        
        int totalBytes = this._byteText.length, a = 0;
        byte[] tempBytes = new byte[8];
        int tempCounter = 0;
        String strText = "";
                
        for (a = 0; a < totalBytes - 1; a++){
            tempBytes[tempCounter] = this._byteText[a];
            tempCounter++;
            
            if ((tempCounter == 8)){
                tempCounter = 0;
                strText += (new Character((char)Integer.parseInt(new String(tempBytes, 0, tempBytes.length), 2))).toString();
            }

        }
       
        if (tempCounter > 0 && tempCounter < 7){
            for (; tempCounter < 8; tempCounter++)
                tempBytes[tempCounter] = 0;
            
            strText += (new Character((char)Integer.parseInt(new String(tempBytes, 0, tempBytes.length), 2))).toString();
        }
        this._strText = strText;
    }

    public void fromStringToStringList(){
        if (this._strText == null){
            this._strArrText = new ArrayList<ArrayList<String>>(0);
            return;
        }
        
        ArrayList<ArrayList<String>> strArrMethods = new ArrayList<ArrayList<String>>();
        String[] strMethods = this._strText.split(this._strLineSeparator);
        String[] strFields;
                
        try{
        for (int a = 0; a < strMethods.length; a++){
             strFields = strMethods[a].split(this._strFieldSeparator);
             
             ArrayList<String> strArrField = new ArrayList<String>();
             
             for (String strField : strFields){
                 strArrField.add(strField);
             }
             
             strArrMethods.add(strArrField);
        }
        }catch(Exception ex){
            System.out.println(ex);
        }
        
        this._strArrText = strArrMethods;
    }
}
