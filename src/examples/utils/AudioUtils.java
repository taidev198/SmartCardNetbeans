/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples.utils;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author nguyenthanhtai
 */
public class AudioUtils {
    private AudioUtils instance;
    
    private AudioUtils(){}
    
    public AudioUtils getInstance() {
        if(instance == null) {
            instance = new AudioUtils();
        }
        return instance;
        
    }
    
    public void playSound(String input) {
        try {
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(getClass().getResource(input).getPath()).getAbsoluteFile());
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
        } catch(Exception ex) {
        System.out.println("Error with playing sound.");
        ex.printStackTrace();
        }
    }
    
}
