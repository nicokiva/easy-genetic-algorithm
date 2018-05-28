/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Editor;
import java.awt.*;   
import javax.swing.*;   
import javax.swing.text.*;
/**
 *
 * @author Triton
 */
public class NumberedParagraphView extends ParagraphView{   
    public short NUMBERS_WIDTH=30;   
  
    public NumberedParagraphView(Element e)   
    {   
        super(e);   
        //super();   
        short top = 0;   
        short left = 0;   
        short bottom = 0;   
        short right = 0;   
        this.setInsets(top, left, bottom, right);   
    }   
  
    protected void setInsets(short top, short left, short bottom,short right)   
    {   
      super.setInsets(top, (short)(left+NUMBERS_WIDTH), bottom, right);   
    }   
  
    public void paintChild(Graphics g, Rectangle r, int n)   
    {   
        super.paintChild(g, r, n);   
        Graphics2D g2 = (Graphics2D)g;   
        int previousLineCount = getPreviousLineCount();   
        int numberX = r.x - getLeftInset();   
        int numberY = r.y + r.height - 5;   
        String str = Integer.toString(previousLineCount + n + 1) + ". ";   
        // draw the line number, align it to the right   
        g2.drawString(str, numberX - g2.getFontMetrics().stringWidth(str) + 25, numberY);   
        g2.setColor(Color.MAGENTA);   
        //draw a vertical line next to it   
        g2.drawLine(r.x-3, r.y, r.x-3, r.y + r.height);   
    }   
  
    public int getPreviousLineCount()   
    {   
        int lineCount = 0;   
        View parent = this.getParent();   
        int count = parent.getViewCount();   
        for (int i = 0; i < count; i++)   
        {   
            if (parent.getView(i) == this)   
            {   
                break;   
            }   
            else  
            {   
                lineCount += parent.getView(i).getViewCount();   
            }   
        }   
        return lineCount;   
    }   
}  

