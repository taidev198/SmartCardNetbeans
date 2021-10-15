/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples.data;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 *
 * @author traig
 */
@Retention(RetentionPolicy.SOURCE)
public @interface RuleKey {
    String ID = "id";
    String START_TIME = "start_time";
    String END_TIME = "end_time";
    String START_DATE = "start_date";
    String END_DATE = "end_date";
    
}
