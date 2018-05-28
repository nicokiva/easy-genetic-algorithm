/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Editor;
import javax.swing.table.TableModel;   
import javax.swing.text.Element;   
import javax.swing.text.View;   
import javax.swing.text.ViewFactory;   
import javax.swing.text.AbstractDocument;   
import javax.swing.text.LabelView;   
import javax.swing.text.BoxView;   
import javax.swing.text.StyleConstants;   
import javax.swing.text.ComponentView;   
import javax.swing.text.IconView; 
/**
 *
 * @author Triton
 */
public class NumberedViewFactory implements ViewFactory{   
    public View create(Element elem){   
      String kind = elem.getName();   
      if (kind != null)   
          if (kind.equals(AbstractDocument.ContentElementName))   
          {   
              return new LabelView(elem);   
          }   
          else if (kind.equals(AbstractDocument.ParagraphElementName))   
          {   
  
              return new NumberedParagraphView(elem);   
          }   
          else if (kind.equals(AbstractDocument.SectionElementName))   
          {   
              return new BoxView(elem, View.Y_AXIS);   
          }   
          else if (kind.equals(StyleConstants.ComponentElementName))   
          {   
              return new ComponentView(elem);   
          }   
          else if (kind.equals(StyleConstants.IconElementName))   
          {   
              return new IconView(elem);   
          }   
      // default to text display   
      return new LabelView(elem);   
    }   
}  