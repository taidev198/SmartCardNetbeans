/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples;

import java.time.LocalTime;

/**
 *
 * @author traig
 */
public interface OnGetRuleListener {
    
    void onGetRuleSuccess(LocalTime inTime, LocalTime outTime, int inDate, int outDate);
    
}
