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
public class Constants {
    
    public final static  byte ID = (byte)0x01;
    public final static  byte NAME = (byte)0x02;	
    public final static  byte DATE = (byte)0x03;
    public final static  byte ADDRESS = (byte)0x04;
    public final static  byte GENDER = (byte)0x06;
    public final static  byte ID_DEPARTMENT = (byte)0x07;
    private final static byte INS_SETIMG = (byte) 0x12;
    private final static byte INS_GETIMG = (byte) 0x13;
    public final  static  byte INS_SET_KEY = (byte)0x01;
    public final static  byte INS_ENCRYPT = (byte)0x02;
    public final static  byte INS_DECRYPT = (byte)0x03;
    public final static  byte INS_VER = (byte)0x03;
    public final static byte VERIFY = (byte)0x06;
    public final static byte CLA = (byte) 0xA0;
    
    public final static String LATE_TIME = "YOU ARE LATE";
    public final static String ON_TIME = "YOU ARE ON TIME";
    public final static String NOT_WORKING_DAY = "OPPS TODAY IS NOT WORKING DAY";
    
    public final static String NOT_TIME_UP = "OH NOW IS WORKING TIME";
    public final static String TIME_UP = "SEE YOU TOMORROW";
    public final static String STAY_HOME = "OPPS NOW IS NOT TIME WORKING";
    
    
    public final static String NOTIFICATION = "NOTIF";
    
}
