/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples.utils;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author traig
 */
public class ImageUltils {
    
    private static ImageUltils instance;
    
    private ImageUltils() {
       
    }
    
    public static ImageUltils getInstance() {
         if(instance == null)
            instance = new ImageUltils();
        return instance;
    }
    
    public BufferedImage byteToBufferImage(byte[] in) throws IOException {
        
        InputStream is = new ByteArrayInputStream(in);
        BufferedImage out =  ImageIO.read(is);  
        return out;
        
    }
    
    public ImageIcon bufferImageToII(BufferedImage in, JLabel avatar) {
        
        ImageIcon icon= new ImageIcon(in.getScaledInstance(avatar.getWidth(), avatar.getHeight(), Image.SCALE_SMOOTH));
        return icon;
    }
    
}
