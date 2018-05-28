package helpers;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author Nicolas
 */

public class file_handler {
    private String _strPathFileToRead = "";
    private String _strPathFileToWrite = "";
    private String _strText = "";
    private byte[] _byteText;

    /* BEGIN CONSTRUCTORS */
    public file_handler(){}
    
    public file_handler(String strPath){
        this._strPathFileToRead = strPath;
    }
    /* END CONSTRUCTORS */
    

    /* BEGIN GETTERS AND SETTERS */   
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
    
    
    private boolean canRead(){
        if (this._strPathFileToRead.length() == 0)
            return false;

        File fileSelected = new File(this._strPathFileToRead);
        return fileSelected.exists();
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
        
        return this.Read();
        
        /*
        if (!this.canRead())
            return false;

        try{
            int bytesToRead = 8;
            int totalBytesRead = 0;
            File file = new File(this._strPathFileToRead);
            FileInputStream fstream = new FileInputStream(this._strPathFileToRead); // Open the file
            BufferedInputStream input = new BufferedInputStream(fstream);
          
            byte[] result = new byte[(int)file.length()];
            
            while(totalBytesRead < result.length){
                int bytesRead = input.read(result, totalBytesRead, bytesToRead);
                
                StringBuilder binary = new StringBuilder();
                for (byte b : result)
                {
                   int val = b;
                   for (int i = 0; i < 8; i++)
                   {
                      binary.append((val & 128) == 0 ? 0 : 1);
                      val <<= 1;
                   }
                }

                //return binary.toString();
                
                
                System.out.print(binary.toString() + " ");
                if (bytesRead > 0)
                  totalBytesRead = totalBytesRead + bytesRead;
            }

            this._byteText = result;
            input.close(); //Close the input stream
            return true;
        }catch (Exception e){
            System.err.println("Error: " + e.getMessage());
            return false;
        }*/
    }
    
    public boolean Write(){
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