/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author traig
 */
public class DateUtils {
    
    private DateUtils(){
        
    }
    
    //ex:DateUtils.parseDate("2014-02-14")
     public static Date parseDate(String date) {
     try {
         return new SimpleDateFormat("yyyy-MM-dd").parse(date);
     } catch (ParseException e) {
         return null;
     }
     
    }
     
     public static Date stringToDate(String input) {
        try {
            return  new SimpleDateFormat("yyyyMMdd").parse(input);
        } catch (ParseException ex) {
            Logger.getLogger(DateUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
         return null;
     }
    
     public static String dateToString(Date date) {
          DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
                return  dateFormat.format(date);  
     }
}
