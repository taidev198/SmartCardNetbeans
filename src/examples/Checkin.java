/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples;

import examples.data.Constants;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * https://www.baeldung.com/java-8-date-time-intro
 * @author traig
 */
public class Checkin {
    
    private int id;
    private LocalTime mInTime;
    private LocalTime mOutTime;
    private int mInDate;
    private int mOutDate;
    private boolean isCheckedIn;

    //set up
    public Checkin(LocalTime inTime, LocalTime outTime, int inDate, int outDate) {
        id = 1 ;
        mInTime = inTime;
        mOutTime = outTime;
        mInDate = inDate;
        mOutDate = outDate;
    }
    
    public String checkIn() {
        
        int dayOfWeekNow = LocalDate.now().getDayOfWeek().getValue();
        LocalTime checkinTime = LocalTime.now();
        
         if(dayOfWeekNow >= mInDate && dayOfWeekNow <= mOutDate) {
               setIsCheckedIn(true);
            if(mOutTime.isBefore(checkinTime)) {
               return Constants.STAY_HOME;
                
            }
             
            if(mInTime.isAfter(checkinTime)) {
               return Constants.ON_TIME;
            }else {
                return Constants.LATE_TIME;
            }
         } else {
           return Constants.NOT_WORKING_DAY;
       }
        
    }
    
    public String checkOut(LocalTime outTime) {
        
        if(mInTime.isBefore(outTime)) {
           return Constants.NOT_TIME_UP;
        }else {
            return Constants.TIME_UP;
        }
      
    }

    public LocalTime getmInTime() {
        return mInTime;
    }

    public void setmInTime(LocalTime mInTime) {
        this.mInTime = mInTime;
    }

    public LocalTime getmOutTime() {
        return mOutTime;
    }

    public void setmOutTime(LocalTime mOutTime) {
        this.mOutTime = mOutTime;
    }

    public int getmInDate() {
        return mInDate;
    }

    public void setmInDate(int mInDate) {
        this.mInDate = mInDate;
    }

    public int getmOutDate() {
        return mOutDate;
    }

    public void setmOutDate(int mOutDate) {
        this.mOutDate = mOutDate;
    }

    public boolean isIsCheckedIn() {
        return isCheckedIn;
    }

    public void setIsCheckedIn(boolean isCheckedIn) {
        this.isCheckedIn = isCheckedIn;
    }
    
    public int getId() {
        return id;
    }
    
    
}
