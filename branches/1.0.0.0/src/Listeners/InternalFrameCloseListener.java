/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Listeners;

import javax.swing.event.InternalFrameEvent;

/**
 *
 * @author Triton
 */

public class InternalFrameCloseListener 
{
    
    public javax.swing.event.InternalFrameListener getInternalFrameCloseListener()
    {
        javax.swing.event.InternalFrameListener listener;
        
        listener = new javax.swing.event.InternalFrameListener() 
        {
            @Override
            public void internalFrameClosing(InternalFrameEvent arg0) {}			
            @Override 
            public void internalFrameOpened(InternalFrameEvent arg0) {}
            @Override 
            public void internalFrameIconified(InternalFrameEvent arg0) {}
            @Override 
            public void internalFrameDeiconified(InternalFrameEvent arg0) {}
            @Override 
            public void internalFrameDeactivated(InternalFrameEvent arg0) {}
            @Override 
            public void internalFrameClosed(InternalFrameEvent arg0){}
            @Override 
            public void internalFrameActivated(InternalFrameEvent arg0){}
        };
        
        return listener;
   }
}
