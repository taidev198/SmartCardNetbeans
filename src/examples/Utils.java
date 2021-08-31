/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author traig
 */
public class Utils {
    
    public static byte[] objectToBytes(Object o)  {
        
        
      ByteArrayOutputStream bos = new ByteArrayOutputStream();
      ObjectOutputStream oos;
        try {
            oos = new ObjectOutputStream(bos); 
            oos.writeObject(o);
             oos.flush();
        } catch (IOException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    return bos.toByteArray();
    }
    
    public static Object bytesToObject(byte[] bytes) {
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
    ObjectInput in = null;
      Object o = null;
        try {
            in = new ObjectInputStream(bis);
             o  = in.readObject(); 

        }finally {
        try {
          if (in != null) {
            in.close();
          } }
        catch (IOException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        return o;
    }}
}
