/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples;

import examples.data.Checkin;
import java.time.LocalTime;

/**
 *
 * @author traig
 */
public interface OnGetRuleListener {
    
    void onGetRuleSuccess(Checkin checkin);
    
}
