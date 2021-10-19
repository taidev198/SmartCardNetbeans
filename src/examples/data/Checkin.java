/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples.data;

import examples.data.Constants;
import java.time.LocalDate;
import java.time.LocalTime;
import org.bson.codecs.pojo.annotations.BsonProperty;

/**
 *
 * https://www.baeldung.com/java-8-date-time-intro
 * @author traig
 */
public class Checkin {
    
    @BsonProperty("id") private int id ;
//    @BsonProperty("start_time") private LocalTime mInTime;
//    @BsonProperty("end_time") private LocalTime mOutTime;
    @BsonProperty("start_date") private int mInDate;
    @BsonProperty("end_date") private int mOutDate;
//    private boolean isCheckedIn;
//    private boolean isCheckedOut;

//    //set up
//    public Checkin(LocalTime inTime, LocalTime outTime, int inDate, int outDate) {
//        id = 1 ;
//        mInTime = inTime;
//        mOutTime = outTime;
//        mInDate = inDate;
//        mOutDate = outDate;
//    }
    
//    public String doCheckIn() {
//        
////        int dayOfWeekNow = LocalDate.now().getDayOfWeek().getValue();
////        LocalTime checkinTime = LocalTime.now();
////        
////         if(dayOfWeekNow >= mInDate && dayOfWeekNow <= mOutDate) {
////               setIsCheckedIn(true);
////            if(mOutTime.isBefore(checkinTime)) {
////               return Constants.STAY_HOME;
////                
////            }
////             
////            if(mInTime.isAfter(checkinTime)) {
////               return Constants.ON_TIME;
////            }else {
////                return Constants.LATE_TIME;
////            }
////         } else {
////           return Constants.NOT_WORKING_DAY;
////       }
//return "";
//        
//    }
    
//    public String checkOut(LocalTime outTime) {
//        
//        if(mInTime.isBefore(outTime)) {
//           return Constants.NOT_TIME_UP;
//        }else {
//            return Constants.TIME_UP;
//        }
//      
//    }

//    public LocalTime getmInTime() {
//        return mInTime;
//    }
//
//    public void setmInTime(LocalTime mInTime) {
//        this.mInTime = mInTime;
//    }
//
//    public LocalTime getmOutTime() {
//        return mOutTime;
//    }
//
//    public void setmOutTime(LocalTime mOutTime) {
//        this.mOutTime = mOutTime;
//    }

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

//    public boolean isIsCheckedIn() {
//        return isCheckedIn;
//    }
//
//    public void setIsCheckedIn(boolean isCheckedIn) {
//        this.isCheckedIn = isCheckedIn;
//    }
    
    public int getId() {
        return id;
    }

//    public boolean isIsCheckedOut() {
//        return isCheckedOut;
//    }
//
//    public void setIsCheckedOut(boolean isCheckedOut) {
//        this.isCheckedOut = isCheckedOut;
//    }
    
    
}
