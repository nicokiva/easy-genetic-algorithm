/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import java.util.ArrayList;

/**
 *
 * @author Nicolas
 */
public class data_type_converter {
    private ArrayList<String> _strArrText;
    private String _strText;
    private byte[] _byteText;
    
    public data_type_converter(){
        
    }
    
    public data_type_converter(String strText){
        this._strText = strText;
    }
    
    public data_type_converter(ArrayList<String> strText){
        this._strArrText = strText;
    }
    
    public data_type_converter(byte[] byteText){
        this._byteText = byteText;
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
        this._strText = "";        
        String cmdStr = this._byteText.toString();
        int to = 0;
        System.out.print(cmdStr);
        /*for(int i =0;i < cmdStr.length(); i+=8 ){
            if((i+8) > cmdStr.length())
                to = cmdStr.length();
            else
                to = (i+8);
            this._strText += new Character(cmdStr.substring(i,to));
        }*/
    }
    
}
