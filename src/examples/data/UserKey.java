/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples.data;

/**
 *
 * @author traig
 */
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)

public @interface UserKey {
     String ID = "id";
    String FULLNAME = "fullname";
    String BIRTH = "birth";
    String ADDRESS = "address";
    String ID_DEPARTMENT = "id_department";
    String LATE_DATE = "late_date";
    String FINES = "fines";
    String PASSWORD = "password";
    String GENDER = "gender";
   String IS_CHECKIN = "isCheckin";
    String IS_CHECKOUT = "isCheckout";
}
