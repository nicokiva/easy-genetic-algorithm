/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Methods;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author Nicolas
 */
public class Param {
    private String _name = "";
    private String _value = "";
    private String _type = "";
    
    /* BEGIN GETTERS AND SETTERS */
    public void setName(String strName){
        this._name = strName;
    }
    
    public String getName(){
        return this._name;
    }
    
    public void setValue(String strValue){
        this._value = strValue;
    }
    
    public String getValue(){
        return this._value;
    }
    
    /**
     * @return the _type
     */
    public String getType() {
        return _type;
    }

    /**
     * @param type the _type to set
     */
    public void setType(String type) {
        this._type = type;
    }
    /* END GETTERS AND SETTERS */
    
    /* BEGIN CONSTRUCTORS */
    public Param(){}
    
    public Param(String strName, String strValue, String strType){
        this._name = strName;
        this._value = strValue;
        this._type = strType;
    }
    /* END CONSTRUCTORS */
    
    private void createNodeWithText(String strNodeText, String strTag, Element parentElement){
            Document _XMLdoc = this.createBuilder();
            if (_XMLdoc != null){
                Element nodeElement = _XMLdoc.createElement(strTag);
                nodeElement.appendChild(_XMLdoc.createTextNode(strNodeText));
                parentElement.appendChild(nodeElement);
            }
    }
    
    private void createNodeWithOutText(String strTag, Element parentElement){
        Document _XMLdoc = this.createBuilder();
        if (_XMLdoc != null){
            Element nodeElement = _XMLdoc.createElement(strTag);
            parentElement.appendChild(nodeElement);
        }
    }
    
    
    private Document createBuilder(){
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document _XMLdoc = docBuilder.newDocument();
            return _XMLdoc;
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Method.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public String getAttribute(String Tag){
        switch (Tag){
            case "value":
                return this.getValue();
            case "name":
                return this.getName();
            case "type":
                return this.getType();
            default:
                return "";
        }
    }
}
