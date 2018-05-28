/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Auxiliares;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Nicolas
 */
public class functions {
    public static boolean isInteger(String input){
       try{
          Integer.parseInt(input);
          return true;
       }catch(Exception ex){
          return false;
       }
    }

    public static String getDate(String date){
        if (date != null && !date.isEmpty())
            return date;
        return functions.getDate();
    }
    
    public static String getDate(){
        Date today = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd / MM / yy");
        return formatter.format(today);
    }
    
    public static Date getHour(){
        return new Date();
    }
    
    public static String getTime(){
        Date today = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        return formatter.format(today);        
    }

    public static String getTime(Date date){
        if (date == null)
            return functions.getTime();
        
        SimpleDateFormat formatter = new SimpleDateFormat("H:mm:ss");
        return formatter.format(date);        
    }
    
    
    public static Date getToday(){
        return new Date();
    }
    
    private static String getDateToFileName(){
        Date today = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yy");
        return formatter.format(today);
    }
    
    public static String GetRandomNameForResults(String solutionName){
        long lng = Math.round(Math.random()*1000000000);
        return solutionName + functions.getDateToFileName() + "-" + Integer.toString((int)lng);
    }
    
     public static String armarStackTrace(Exception e){
       StringBuilder strB= new StringBuilder();
        StackTraceElement[] stack = e.getStackTrace();
         for (int i = 0; i < stack.length; i++) {
             strB.append(stack[i]);
               strB.append('\r');
                strB.append('\n');


         }
         return strB.toString();
    }
}
