/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Auxiliares;

/**
 *
 * @author Nicolas
 */
public class OperationResult {
    public static int _failure = -1;
    public static int _nothingDone = 0;
    public static int _success = 1;
    
    public int Status;
    public String Message;
    
    public OperationResult(){
        this.Status = 0;
        this.Message = "";
    }
    
    public boolean OperationSucceed(){
        return this.Status == OperationResult._success;
    }
    public void ResetStatus(){
        this.Status = OperationResult._nothingDone;
        this.Message = "";
    }
}
