/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frame;

import static examples.data.Constants.CLA;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.smartcardio.*;
import javax.swing.JOptionPane;
import java.security.spec.X509EncodedKeySpec;


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
    
    // byte lay tu applet
   byte[] moduBytes;
   byte[] expoBytes;
   
   // dung de sinh pubkeyRSA
   BigInteger exponent;
   BigInteger modulus;
   
   
   PublicKey pub; // khai bao khoa : có thể gọi trực tiếp truyền vào lúc verify
   PublicKey pubKey;// khai báo để lưu vào file

   byte[] data_random;// random mảng byte truyền xuống để ký, sinh thẳng byte[] ngẫu nhiên đỡ convert
   byte[] signal;// chữ ký được gửi lên
   
   //sinh mảng byte ngẫu nhiên
   
   public static byte[] randomData(int lenbyte) {
        byte[] b = new byte[lenbyte];
        new Random().nextBytes(b);
        return b;
    };
    
    
    public SmartCardWord() {
    }
    
    public static void main(String[] args) {
        
    }
    
    public  boolean connectCard() {
       
        try {
            factory = TerminalFactory.getDefault();
            terminals = factory.terminals().list();
            terminal = terminals.get(1);
            card = terminal.connect("T=0");
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
    public ResponseAPDU sendAPDU(int cla, int ins, int p1, int p2, byte[] data) throws  CardException
       {
        if(channel == null){
           // throw new CardException(RequestResponse.SW_UNKNOWN);
        }
               
        return channel.transmit(new CommandAPDU(
        cla, ins, p1, p2, data));
    }
    
    public byte[] pubkeyRsa(){
       try {
           // lấy modu từ applet
            ResponseAPDU getmodu = sendAPDU(0x00, 0x10, 0x01, 0x01, null);
             moduBytes = getmodu.getData();
             modulus = new BigInteger(1, moduBytes);
             System.out.println("get modu "+ modulus);
             
        } catch (Exception e) {
            e.printStackTrace();
        }
       
       try {
           // lấy expo từ applet
            ResponseAPDU getex = sendAPDU(CLA, 0X11, 0X01, 0X01, null);
            expoBytes = getex.getData();
            exponent = new BigInteger(1, expoBytes);
            System.out.println("get expo "+ exponent);
        } catch (Exception e) {
            e.printStackTrace();
        }
       
       try {
        // sinh khoá pubRSA
        RSAPublicKeySpec spec = new RSAPublicKeySpec(modulus, exponent);
        KeyFactory factory = KeyFactory.getInstance("RSA");
        pub = factory.generatePublic(spec);
        } catch (Exception e) {
            e.printStackTrace();
        }
       return pub.getEncoded();
       // lưu vào file
//       FileOutputStream fos = null;
//        try {
//            File publicKeyFile = createKeyFile(new File("publicKey.rsa"));
//            fos = new FileOutputStream(publicKeyFile);
//            fos.write(pub.getEncoded());
//            fos.close();
//        } catch (FileNotFoundException ex) {
//        } catch (IOException ex) {
//        } finally {
//            try {
//                fos.close();
//            } catch (IOException ex) {
//            }
//        }
//       // có thể gọi thẳng thằng này để verify
//       return pub;
   }
   
   //check tạo file lưu pubRSA
    private static File createKeyFile(File file) throws IOException {
        if (!file.exists()) {
            file.createNewFile();
        } else {
            file.delete();
            file.createNewFile();
        }
        return file;
    }
   
    //xác thực Verify
   public  boolean VerifyRsa(byte [] b){
        try {  
            // sinh khoá lại khi đọc từ file
            X509EncodedKeySpec spec = new X509EncodedKeySpec(b);
            KeyFactory factory = KeyFactory.getInstance("RSA");
            pubKey = factory.generatePublic(spec);
        } catch (NoSuchAlgorithmException ex) {
        } catch (InvalidKeySpecException ex) {
        } finally {
           
        }
       
       data_random = randomData(20);
       System.out.println("ram dom byte "+Arrays.toString(data_random));
       boolean isCorrect = false;
       try {
           // truyền thằng random byte[] xuống và lấy chữ ký lên
           ResponseAPDU sendverify = sendAPDU(CLA, 0X12, 0X12, 0X12, data_random);
                signal = sendverify.getData();
                System.out.println("dau vao "+Arrays.toString(data_random));
                System.out.println("chu ky "+Arrays.toString(signal));
                
                Signature publicSignature = Signature.getInstance("SHA1withRSA");
                // pubRSA lấy từ file, có thể lấy thẳng thằng pubRSA ở trên cũng đc
                publicSignature.initVerify(pubKey);
                
                // đầu vào để xác thực, cái thằng byte[] đầu mà sinh ngẫu nhiên
                publicSignature.update(data_random);
                
                // verify truyền thằng chữ ký vào
                isCorrect = publicSignature.verify(signal);
                System.out.println("verify is " + isCorrect);
       } catch (Exception e) {
           e.printStackTrace();
       }
       System.out.println("true or false "+isCorrect);
       if(isCorrect == true){
           return true;
       }else
           return false;
   }
    
}
