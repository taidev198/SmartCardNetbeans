/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples.data;

import org.bson.codecs.pojo.annotations.BsonProperty;

/**
 *
 * @author traig
 */
public class CheckinStatus {
    
    @BsonProperty("id") private int id ;
    @BsonProperty("user_id") private int mUserId;
    @BsonProperty("isCheckin") private boolean isCheckin ;
    @BsonProperty("isCheckout") private boolean isCheckout ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getmUserId() {
        return mUserId;
    }

    public void setmUserId(int mUserId) {
        this.mUserId = mUserId;
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
    
    
    
}
