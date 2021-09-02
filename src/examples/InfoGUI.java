/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

/**
 * https://mkyong.com/java/java-date-and-calendar-examples/
 * https://www.codejava.net/java-se/swing/how-to-use-jdatepicker-to-display-calendar-component
 *https://viettuts.vn/java-swing/lop-jcombobox-trong-java-swing
 * @author traig
 */
public class InfoGUI extends javax.swing.JFrame {
    
    static Person person;
    private boolean cardready= false;
    static SmartCardWord smartCardWord;
private static final String basePath ="/images/fimage";
    File targetFile;
BufferedImage targetImg;
ImageIcon icon;
private static final int baseSize = 128;
    static SmartCardWord card;
    static boolean isEmpty;
    /**
     * Creates new form InitInfo
     */
    
    
    
    public InfoGUI(SmartCardWord card, boolean isEmpty) {
        initComponents();
        
        System.out.println(gender_combobox.getItemAt(gender_combobox.getSelectedIndex()));
        gender_combobox.setSelectedIndex(1);
        birthday.setDateFormatString("yyyy-MM-dd");
        birthday.setCalendar(new GregorianCalendar(2021,8,30));
        person = new Person();
        this.card = card;
        this.isEmpty = isEmpty;
//        if(!this.isEmpty) {
//            save_btn.setText("EDIT");
//            String id = new String(card.command(new byte[]{0x00}, Constants.INS_DECRYPT, Constants.ID), StandardCharsets.UTF_8);
//            String name = new String(card.command(new byte[]{0x00}, Constants.INS_DECRYPT, Constants.NAME), StandardCharsets.UTF_8);
//            String date = new String(card.command(new byte[]{0x00}, Constants.INS_DECRYPT, Constants.DATE), StandardCharsets.UTF_8);
//            String address = new String(card.command(new byte[]{0x00}, Constants.INS_DECRYPT, Constants.ADDRESS), StandardCharsets.UTF_8);
//                   text_id.setText(id.substring(0, id.length()-2));
//                   text_name.setText(name.substring(0, name.length()-2));
//                   text_date.setText(date.substring(0, date.length()-2));
//                   text_address.setText(address.substring(0, address.length()-2));
//                   this.isEmpty = !this.isEmpty;
//                         
//            getImage(person.getAvatar());
//                
//                          
//        
//        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        text_address = new javax.swing.JTextField();
        save_btn = new javax.swing.JButton();
        browser_img = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        avatar = new javax.swing.JLabel();
        text_id = new javax.swing.JTextField();
        text_name = new javax.swing.JTextField();
        birthday = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        text_address2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        gender_combobox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(236, 236, 255));

        jLabel5.setFont(new java.awt.Font("Stencil", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 0, 204));
        jLabel5.setText("NHAP THONG TIN CA NHAN");
        jLabel5.setToolTipText("");

        text_address.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        text_address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_addressActionPerformed(evt);
            }
        });

        save_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Save-icon.png"))); // NOI18N
        save_btn.setText("LUU THONG TIN");
        save_btn.setToolTipText("");
        save_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_btnActionPerformed(evt);
            }
        });

        browser_img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/open-file-icon-16.png"))); // NOI18N
        browser_img.setText("THEM ANH");
        browser_img.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browser_imgActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("ID");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("HO TEN");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("NGAY SINH");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("GIOI TINH");

        avatar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        text_id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        text_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        birthday.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                birthdayMouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("DIA CHI");

        text_address2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        text_address2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_address2ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("PHONG BAN");

        gender_combobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NAM", "NU" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(text_id)
                            .addComponent(text_name)
                            .addComponent(text_address)
                            .addComponent(birthday, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                            .addComponent(text_address2)
                            .addComponent(gender_combobox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(avatar, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 78, Short.MAX_VALUE))
                            .addComponent(browser_img, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(save_btn)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(135, 135, 135))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(avatar, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addComponent(browser_img)
                                .addGap(28, 28, 28))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(text_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addGap(46, 46, 46)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(text_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(59, 59, 59)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(birthday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(gender_combobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(43, 43, 43)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(text_address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addComponent(text_address2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(87, 87, 87)
                .addComponent(save_btn)
                .addGap(71, 71, 71))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void save_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_btnActionPerformed
        // TODO add your handling code here:
                 
         Date selectedValue =  birthday.getCalendar().getTime();
        System.out.println(selectedValue.getMonth());
        System.out.println("heloo");
//       if(isEmpty) {
//         card.command(new byte[] {0x01,0x01,0x01,0x01,0x01}, (byte)0x01);//set key 
//
//    //id
//        System.out.println(new String(card.command(card.command(text_id.getText().getBytes(), Constants.INS_ENCRYPT, Constants.ID), Constants.INS_DECRYPT, Constants.ID), StandardCharsets.UTF_8));
//    //id


//        System.out.println(new String(card.command(card.command(text_name.getText().getBytes(), Constants.INS_ENCRYPT, Constants.NAME), Constants.INS_DECRYPT, Constants.NAME), StandardCharsets.UTF_8));
//    //id
//        System.out.println(new String(card.command(card.command(text_date.getText().getBytes(), Constants.INS_ENCRYPT, Constants.DATE), Constants.INS_DECRYPT, Constants.DATE), StandardCharsets.UTF_8));
//    //id
        System.out.println(new String(card.command(card.command(text_address.getText().getBytes(), Constants.INS_ENCRYPT, Constants.ADDRESS), Constants.INS_DECRYPT, Constants.ADDRESS), StandardCharsets.UTF_8));
//    //id
System.out.println(text_address.getText());

                 //  String id = new String(card.command(new byte[]{0x00}, Constants.INS_DECRYPT, Constants.ADDRESS), StandardCharsets.UTF_8);

//     //   System.out.println(new String(card.command(card.command(text_id.getText().getBytes(), (byte)0x02), (byte)0x03), StandardCharsets.UTF_8));
//     InfoGUI.person = this.person;
//     new MainApp(card).setVisible(true);
//     this.setVisible(false);
     
 //      } 
    }//GEN-LAST:event_save_btnActionPerformed

    private void browser_imgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browser_imgActionPerformed
        // TODO add your handling code here:
        JFileChooser fc = new JFileChooser();
        int returnValue = fc.showOpenDialog(this);
        if(returnValue == JFileChooser.APPROVE_OPTION){
            File file = fc.getSelectedFile();
            String path = file.getAbsolutePath();
            BufferedImage bimage;
            try{
                bimage = ImageIO.read(file);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ImageIO.write(bimage, "jpg", baos);
                byte[] img = baos.toByteArray();
                ImageIcon icon= new ImageIcon(bimage.getScaledInstance(avatar.getWidth(), avatar.getHeight(), Image.SCALE_SMOOTH));
                icon.getImage();
                avatar.setIcon(icon);
                
                
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_browser_imgActionPerformed

    private void text_addressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_addressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_addressActionPerformed

    private void text_address2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_address2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_address2ActionPerformed

    private void birthdayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_birthdayMouseClicked
        // TODO add your handling code here:
         
        
    }//GEN-LAST:event_birthdayMouseClicked

   

private void setImage(byte [] img){
        if(img == null) return;
        byte[] cmd = {(byte) 0x00, (byte) 0x12, (byte) 0x01, (byte) 0x00};
        smartCardWord.sendAPDUtoApplet(cmd);
        int sendlen = img.length;
     //   System.out.println("ảnh gửi:" +img);
        byte[] cmnd = {(byte) 0x00, (byte) 0x12, (byte) 0x02, (byte) 0x00};
        int pointer = 0;
        byte[] temp = new byte[255];
        int datalen = 255;
        while(sendlen >0){
            System.arraycopy(img, pointer, temp, 0, datalen);
            smartCardWord.sendAPDUtoApplet(cmnd, temp);
            pointer += 255;
            sendlen -=255;
            if(sendlen <255){
                datalen = sendlen;
            }
        }
    }
    private void getImage(byte [] img){
        if(img == null) return;
        try {
        byte[] cmd = {(byte) 0x00, (byte) 0x13, (byte) 0x01, (byte) 0x00};
        smartCardWord.sendAPDUtoApplet(cmd);
        int sendlen = img.length;
        byte[] cmnd = {(byte) 0x00, (byte) 0x13, (byte) 0x02, (byte) 0x00};
        byte[] resimg= new byte[sendlen];
        int pointer=0;
        int datalen = 255;
        while(sendlen >0){
            smartCardWord.sendAPDUtoApplet(cmnd);
            byte[] temp = smartCardWord.responseAPDU.getData();
            System.arraycopy(temp, 0, resimg, pointer, datalen);
            pointer += 255;
            sendlen -= 255;
            if(sendlen<255){
                datalen = sendlen;
            }
        }
       // System.out.println("ảnh res:" +resimg);
        ByteArrayInputStream bais= new ByteArrayInputStream(resimg);
        BufferedImage b;
        b = ImageIO.read(bais);
        ImageIcon icon= new ImageIcon(b.getScaledInstance(avatar.getWidth(),avatar.getHeight(), Image.SCALE_SMOOTH));
        icon.getImage();
        avatar.setIcon(icon);
        } catch (IOException ex) {
            Logger.getLogger(InfoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * @param args the command line arguments
     */
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InfoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InfoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InfoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InfoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InfoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InfoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InfoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InfoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InfoGUI(card, isEmpty).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel avatar;
    private com.toedter.calendar.JDateChooser birthday;
    private javax.swing.JButton browser_img;
    private javax.swing.JComboBox<String> gender_combobox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton save_btn;
    private javax.swing.JTextField text_address;
    private javax.swing.JTextField text_address2;
    private javax.swing.JTextField text_id;
    private javax.swing.JTextField text_name;
    // End of variables declaration//GEN-END:variables
}
