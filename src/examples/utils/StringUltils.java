/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples.utils;

/**
 *
 * @author traig
 */
public abstract class StringUltils {
    
    
    private StringUltils(){
        
    }
    
    public static String reducingString(String input) {
        
         String initials = "";
        for (String s : input.split(" ")) {
            initials+=s.charAt(0);
        }
        
        return initials;
    }
    
    public static String generateId(String prefix) {
        String result = prefix;
        
        int random = (int)(Math.random() * 1000 + 1);
        String median = Integer.toString(random);
       
        
        return result + median;
    }
}
