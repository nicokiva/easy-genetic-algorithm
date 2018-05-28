package Presentacion.Auxiliares;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nicolas
 */

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Encriptador {
   public static final String DEFAULT_ENCODING = "UTF-8";
   public static final String KEY = "EGA";
   
   static BASE64Encoder enc = new BASE64Encoder();
   static BASE64Decoder dec = new BASE64Decoder();

   public static String Encriptar(String Texto){
       String txt = xorMessage(Texto, KEY);
       return base64encode(txt);
   }
   
   public static String Desencriptar(String Texto){
       String txt = base64decode(Texto);
       return xorMessage(txt, KEY);
   }
   

   private static String base64encode(String text){
      try {
         String rez = enc.encode( text.getBytes( DEFAULT_ENCODING ) );
         return rez;         
      }
      catch ( UnsupportedEncodingException e ) {
         return null;
      }
   }

   private static String base64decode(String text){
        try {
           return new String(dec.decodeBuffer(text), DEFAULT_ENCODING);
        }
        catch (IOException ex) {
          return null;
        }
    }

    private static String xorMessage(String message, String key){
        try {
            if (message == null || key == null ) return null;

            char[] keys = key.toCharArray();
            char[] mesg = message.toCharArray();

            int ml = mesg.length;
            int kl = keys.length;
            char[] newmsg = new char[ml];

            for (int i = 0; i < ml; i++){
               newmsg[i] = (char)(mesg[i]^keys[i%kl]);
            }
            mesg = null; 
            keys = null;
            return new String(newmsg);
       }catch ( Exception e ){
            return null;
       }  
    }

}