/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples;

/**
 *
 * @author traig
 */
public class Constants {
    
    public final static  byte ID = (byte)0x01;
    public final static  byte NAME = (byte)0x02;	
    public final static  byte DATE = (byte)0x03;
    public final static  byte ADDRESS = (byte)0x04;
    private final static byte INS_SETIMG = (byte) 0x12;
    private final static byte INS_GETIMG = (byte) 0x13;
    public final  static  byte INS_SET_KEY = (byte)0x01;
    public final static  byte INS_ENCRYPT = (byte)0x02;
    public final static  byte INS_DECRYPT = (byte)0x03;
    public final static byte VERIFY = (byte)0x06;
    public final static byte CLA = (byte) 0xA0;
    
}
