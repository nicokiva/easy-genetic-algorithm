/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

/**
 *
 * @author Nicolas
 */
public class functions {
    public static boolean isInteger(String input){
       try{
          Integer.parseInt(input);
          return true;
       }catch( Exception ex){
          return false;
       }
    }

}
