/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples.utils;
import examples.data.Departments;
import examples.data.DepartmentsKey;
import org.json.JSONArray;
import org.json.JSONObject;
import examples.data.Rule;
import examples.data.RuleKey;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import org.json.JSONException;

/**
 *
 * @author traig
 */
public class JsonParser {
    
    public static Rule jsonToRule(String jsonString) throws JSONException {
        Rule rule = new Rule();
        JSONObject obj = new JSONObject(jsonString);
        
        rule.setId(obj.getInt("id"));
        rule.setmInDate(obj.getInt(RuleKey.START_DATE));
        rule.setmOutDate(obj.getInt(RuleKey.END_DATE));
        System.out.println(obj.getString(RuleKey.START_TIME));
        rule.setmInTime(LocalTime.parse(obj.getString(RuleKey.START_TIME)));
        rule.setmOutTime(LocalTime.parse(obj.getString(RuleKey.END_TIME)));
        return rule;
        
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
