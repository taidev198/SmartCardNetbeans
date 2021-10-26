/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples.data;

import examples.data.Constants;
import examples.utils.DataBaseUtils;
import java.time.LocalDate;
import java.time.LocalTime;
import org.bson.codecs.pojo.annotations.BsonProperty;

/**
 *
 * https://www.baeldung.com/java-8-date-time-intro
 * @author traig
 */
public class Checkin {
    
   private Rule mRule;
   private LocalDate dateNow;
   private LocalTime timeNow;
   private boolean isCheckin;
   private boolean isCheckout;
   
   public Checkin(Rule rule) {
       
       mRule = rule;
   }
   
   public String doCjheckin( LocalDate date, LocalTime time, User user, DataBaseUtils dbHelper) {
       
       isCheckin = user.isIsCheckin();
       isCheckout = user.isIsCheckout();
        dateNow = date;
       timeNow  = time;
       LocalTime startTime = mRule.getmInTime();
       LocalTime endTime = mRule.getmOutTime();
       int inDate = mRule.getmInDate();
       int outDate = mRule.getmOutDate();
        int dayOfWeekNow = date.getDayOfWeek().getValue();
       if(dayOfWeekNow >= inDate && dayOfWeekNow <= outDate) {
            if(time.isBefore(startTime)) {
                setIsCheckin(true);
                user.setIsCheckin(isCheckin);
               return Constants.ON_TIME;
            }
            if(time.isBefore(endTime)) {
              if(!isCheckin) {
                  setIsCheckin(true);
                  user.setIsCheckin(isCheckin);
                  return Constants.LATE_TIME;
              }else {
                  if(!isCheckout) {
                     return Constants.NOT_TIME_UP;
                  }
              }
            } else {
             if(!isCheckin) {
                 return Constants.DONT_WORK_TODAY;
             }else{
                 setIsCheckout(true);
                 user.setIsCheckout(isCheckout);
                 return Constants.STAY_HOME;
             }
         }
         }
       dbHelper.updateUser(user.getId(), user);
       return Constants.NOT_WORKING_DAY;
   }

    public boolean isIsCheckin() {
        return isCheckin;
    }

    public void setIsCheckin(boolean isCheckin) {
        this.isCheckin = isCheckin;
    }

    public boolean isIsCheckout() {
        return isCheckout;
    }

    public void setIsCheckout(boolean isCheckout) {
        this.isCheckout = isCheckout;
    }

    public Rule getmRule() {
        return mRule;
    }

    public void setmRule(Rule mRule) {
        this.mRule = mRule;
    }
    
    
    
}
