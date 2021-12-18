/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples.utils;

import examples.data.User;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
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
            return  new SimpleDateFormat("yyyy-MM-dd").parse(input);
        } catch (ParseException ex) {
            Logger.getLogger(DateUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
         return null;
     }
    
     public static String dateToString(Date date) {
          DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
                return  dateFormat.format(date);  
     }
     
     public static ArrayList<Date> printDatesInMonth(int year, int month, String format) {
         
         ArrayList<Date> datesOfMonth = new ArrayList<>();
    SimpleDateFormat fmt = new SimpleDateFormat(format);
    Calendar cal = Calendar.getInstance();
    cal.clear();
    cal.set(year, month - 1, 1);
    int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
    for (int i = 0; i < daysInMonth; i++) {
        datesOfMonth.add(cal.getTime());
        cal.add(Calendar.DAY_OF_MONTH, 1);
    }
    
    return datesOfMonth;
}
     
     public static int getNumberLateDate(int month, int year, User user) {
         
         int num = 0;
         List<LocalDate> lateDate = user.getLate_date();
         num = lateDate.stream().filter(lateDate1 -> (lateDate1.getMonthValue() ==  month && lateDate1.getYear() == year)).map(_item -> 1).reduce(num, Integer::sum);
         return num;
     }
}
