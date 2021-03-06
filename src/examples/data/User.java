/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples.data;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import org.bson.codecs.pojo.annotations.BsonProperty;

/**
 *
 * @author traig
 */
public class User {
    
    @BsonProperty("address") String address;
    @BsonProperty("avatar") byte[] avatar;
    @BsonProperty("birth") Date birth;
    @BsonProperty("fullname") String fullname;
    @BsonProperty("gender") int gender;
    @BsonProperty("id") String id;
    @BsonProperty("id_department") int id_department;
    @BsonProperty("isCheckin") private boolean isCheckin ;
    @BsonProperty("isCheckout") private boolean isCheckout ;
    @BsonProperty("late_date") List<LocalDate> late_date;
    @BsonProperty("password") String password;
    @BsonProperty("pub_key") byte[] pub_key;
    @BsonProperty("checkin_date") LocalDate checkinDate;
    @BsonProperty("list_checkin_date") List<LocalDate> list_checkin_date;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId_department() {
        return id_department;
    }

    public void setId_department(int id_department) {
        this.id_department = id_department;
    }

    public List<LocalDate> getLate_date() {
        return late_date;
    }

    public void setLate_date(List<LocalDate> late_date) {
        this.late_date = late_date;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte[] getPub_key() {
        return pub_key;
    }

    public void setPub_key(byte[] pub_key) {
        this.pub_key = pub_key;
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
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

    public LocalDate getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(LocalDate checkinDate) {
        this.checkinDate = checkinDate;
    }

    public List<LocalDate> getList_checkin_date() {
        return list_checkin_date;
    }

    public void setList_checkin_date(List<LocalDate> list_checkin_date) {
        this.list_checkin_date = list_checkin_date;
    }

   
    
}
