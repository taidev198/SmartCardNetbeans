/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.smartcardio.*;
import javax.swing.JOptionPane;

/**
 *
 * @author traig
 */
public class SmartCardWord {
    
    
    public static final byte[] AID_APPLET = {(byte)0x01, (byte)0x02, (byte)0x03,(byte)0x04,(byte)0x05, (byte) 0x00};
    private Card card;
    private TerminalFactory factory;
    private CardChannel channel;
    private CardTerminal terminal;
    private List<CardTerminal> terminals;
    ResponseAPDU responseAPDU;
    
    public SmartCardWord() {
    }
    
    public static void main(String[] args) {
        
    }
    
    public  boolean connectCard() {
       
        try {
            factory = TerminalFactory.getDefault();
            terminals = factory.terminals().list();
            terminal = terminals.get(0);
            card = terminal.connect("T=1");
            channel = card.getBasicChannel();
            System.out.println(channel);
            if(channel == null){
                System.out.println("true");
                return false;
            }
            responseAPDU = channel.transmit(new CommandAPDU(0x00, (byte)0xA4, (byte)0x04,0x00,AID_APPLET ));
            String check = Integer.toHexString(responseAPDU.getSW());
            if(check.equals("9000")){
                return true;
            }
            else if(check.equals("6d00")) {
                JOptionPane.showMessageDialog(null, "the bi vo hieu hoa");
                return true;
            } else return false;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return false;
    }
    
    public boolean disconnect() {
        try{
            card.disconnect(false);
            return true;
           
        }catch(Exception e){
            System.out.println("Loi :"  + e);
        }
        return false;
    }
    
    public String Open(byte[] input) {
        try {
            responseAPDU = channel.transmit(new CommandAPDU(0x00, (byte)0x20, (byte)0x00,0x00,input ));
        } catch (CardException ex) {
            Logger.getLogger(SmartCardWord.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Integer.toHexString(responseAPDU.getSW());
    }
    
    public String Open(byte[] input, byte ins) {
        try {
            responseAPDU = channel.transmit(new CommandAPDU(0x00, ins, (byte)0x00,0x00,input ));
        } catch (CardException ex) {
            Logger.getLogger(SmartCardWord.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Integer.toHexString(responseAPDU.getSW());
    }
    
    public void sendAPDUtoApplet(byte[] cmnds,byte[] data){
        try {
            responseAPDU = channel.transmit(new CommandAPDU(cmnds[0], cmnds[1], cmnds[2], cmnds[3], data));
        } catch (CardException e) {
            e.printStackTrace();
        }
    }
    public void sendAPDUtoApplet(byte[] cmnds){
        try {
            responseAPDU = channel.transmit(new CommandAPDU(cmnds[0], cmnds[1], cmnds[2], cmnds[3]));
        } catch (CardException e) {
            e.printStackTrace();
        }
    }
    
    public String encriptAndDecript(byte[] input) {
        try {
            responseAPDU = channel.transmit(new CommandAPDU(0x00, (byte)0x60, (byte)0x00,0x00,input ));
        } catch (CardException ex) {
            Logger.getLogger(SmartCardWord.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Arrays.toString((responseAPDU.getBytes()));
    }
    public byte[] command(byte[] input, byte ins) {
        try {
            responseAPDU = channel.transmit(new CommandAPDU(0x00, ins, (byte)0x00,0x00,input ));
        } catch (CardException ex) {
            Logger.getLogger(SmartCardWord.class.getName()).log(Level.SEVERE, null, ex);
        }
        return responseAPDU.getBytes();
    }
    
    public byte[] command(byte[] input, byte ins, byte p1) {
        try {
            responseAPDU = channel.transmit(new CommandAPDU(0x00, ins, p1,0x00,input ));
        } catch (CardException ex) {
            Logger.getLogger(SmartCardWord.class.getName()).log(Level.SEVERE, null, ex);
        }
        return responseAPDU.getBytes();
    }
    
}
