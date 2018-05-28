/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import Methods.Method;
import java.io.File;
import java.util.ArrayList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author Nicolas
 */
public class EGAFile {
    private String name = "";
    private String path = "";
    
    Element ParentElement;
    Document DocumentCreator;
    ArrayList<Element> Elements = new ArrayList<Element>();
    
    public OperationResult result = new OperationResult();
    
    public static EGAFile FromXML(String Name, String Path){
        return new EGAFile(Name, Path);
    }
    
    public static EGAFile Empty(){
        return new EGAFile();
    }
    
    public EGAFile(){}
    
    public EGAFile(String Name, String Path){
        this.name = Name;
        this.path = Path;
    }
    
    public String GetName(){
        return this.name;
    }
    
    public String GetPath(){
        return this.path;
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

    public static void GetFromXMLTree(ArrayList<EGAFile> arrFiles, Element ParentNode, Document doc){
        for (EGAFile file : arrFiles){
            file.DocumentCreator = doc;
            file.ParentElement = ParentNode;
            
            Element fileNode = file.createNodeWithOutText("file");
            fileNode.appendChild(file.createNodeWithText("path", file.path));
            file.ParentElement.appendChild(fileNode);
        }
    }
    
    public void Remove(){
        try{
            File file = new File(this.GetPath());
            file.delete();
            this.result.Status = OperationResult._success;
        }catch(Exception ex){
            this.result.Status = OperationResult._failure;
            this.result.Message = ex.getMessage();
        }
    }
}
