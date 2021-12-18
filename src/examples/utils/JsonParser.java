/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples.utils;
import com.google.gson.Gson;
import examples.data.Departments;
import examples.data.DepartmentsKey;
import org.json.JSONArray;
import org.json.JSONObject;
import examples.data.Rule;
import examples.data.RuleKey;
import examples.data.User;
import examples.data.UserKey;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONException;

/**
 *how to convert json object to date in java
 * @author traig
 */
public class JsonParser {
    
    public static Rule jsonToRule(String jsonString) throws JSONException {
        Rule rule = new Rule();
        JSONObject obj = new JSONObject(jsonString);
        
        rule.setId(obj.getInt("id"));
        rule.setmInDate(obj.getInt(RuleKey.START_DATE));
        rule.setmOutDate(obj.getInt(RuleKey.END_DATE));
        rule.setmInTime(LocalTime.parse(obj.getString(RuleKey.START_TIME)));
        rule.setmOutTime(LocalTime.parse(obj.getString(RuleKey.END_TIME)));
        rule.setmFines(obj.getInt(RuleKey.FINES));
        return rule;
        
    }
    
    public static User jsonToUser(String jsonString) throws JSONException {
        
     
        User user= new User();
             //   User user= new Gson().fromJson(jsonString, User.class);;

        JSONObject obj = new JSONObject(jsonString);
        user.setId(obj.getString("id"));
        user.setFullname(obj.getString(UserKey.FULLNAME));
        user.setId_department(obj.getInt(UserKey.ID_DEPARTMENT));
      JSONArray jsonarray = obj.getJSONArray(UserKey.LATE_DATE);
        ArrayList<LocalDate> lateDate = new ArrayList<>();
      for (int i = 0; i < jsonarray.length(); i++) {
       // String late_date = jsonarray.getJSONObject(i).toString();
        Timestamp stamp = new Timestamp(jsonarray.getJSONObject(i).getLong("$date"));
        Date date = new Date(stamp.getTime());
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateFormatted = formatter.format(date);
        //new Date(late_date);
        //lateDate.add(LocalDate.parse(late_date));
        lateDate.add(LocalDate.parse(dateFormatted));
    }
      user.setLate_date(lateDate);
        System.out.println(user.getId());
        return user;
        
    }
    
    public static Departments jsonToDepartments(String jsonString) throws JSONException {
        
        Departments d = new Departments();
        JSONObject obj = new JSONObject(jsonString);
        d.setmId(obj.getInt("id"));
        d.setmName(obj.getString(DepartmentsKey.NAME));
        d.setmQuanlity(obj.getInt(DepartmentsKey.QUANLITY));
        System.out.println(d.getmName());
        return d;
        
    }
    
}
