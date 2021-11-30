/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples.listener;

import examples.data.User;

/**
 *
 * @author traig
 */
    public interface OnGetUserListener{
        
        void onGetUserSuccess(User user);
        
    }
  