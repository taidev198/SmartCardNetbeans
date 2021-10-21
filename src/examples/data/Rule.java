/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples.data;

import java.time.LocalTime;
import org.bson.codecs.pojo.annotations.BsonProperty;

/**
 *
 * @author traig
 */
public class Rule {
    
    @BsonProperty("id") private int id ;
    @BsonProperty("start_time") private LocalTime mInTime;
    @BsonProperty("end_time") private LocalTime mOutTime;
    @BsonProperty("start_date") private int mInDate;
    @BsonProperty("end_date") private int mOutDate;
    @BsonProperty("fines") private int mFines;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getmFines() {
        return mFines;
    }

    public void setmFines(int mFines) {
        this.mFines = mFines;
    }
    
    
    
}
