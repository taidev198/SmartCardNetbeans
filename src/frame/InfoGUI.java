/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frame;

import examples.listener.OnGetUserListener;
import examples.data.Constants;
import examples.data.Departments;
import examples.database.DataBaseUtils;
import examples.data.User;
import examples.utils.DateUtils;
import examples.utils.ImageUltils;
import examples.utils.StringUltils;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * https://mkyong.com/java/java-date-and-calendar-examples/
 * https://www.codejava.net/java-se/swing/how-to-use-jdatepicker-to-display-calendar-component
 *https://viettuts.vn/java-swing/lop-jcombobox-trong-java-swing
 * @author traig
 */
public class InfoGUI extends javax.swing.JFrame implements OnGetUserListener{
    
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
    private static OnGetUserListener mListener;
    private byte[] imgBytes;
    private static ArrayList<Departments> departmentses;
    private static User mUser;
    /**
     * Creates new form InitInfo
     */
    
    private DataBaseUtils dbHelper;
    
    public InfoGUI(SmartCardWord card, User user, ArrayList<Departments> d, boolean isEmpty, OnGetUserListener listener) {
        initComponents();
        mUser = user;
        departmentses = d;
        mListener = listener;
        gender_combobox.setSelectedIndex(1);
        birthday.setDateFormatString("yyyy-MM-dd");
        birthday.setCalendar(new GregorianCalendar(2021,8,30));
        person = new Person();
        this.card = card;
        this.isEmpty = isEmpty;
        dbHelper = DataBaseUtils.getInstance();
        dbHelper.getCol("users");        
        for(int i = 0; i< departmentses.size(); i++)
            id_department_cb.addItem(departmentses.get(i).getmName());
        showId(false);
        if(!this.isEmpty) {
            title_text.setText("CHỈNH SỬA THÔNG TIN CÁ NHÂN");
            save_btn.setText("EDIT");
            System.out.println("name:" +new String(card.command(new byte[]{0x00}, Constants.INS_DECRYPT, Constants.NAME), StandardCharsets.UTF_8));
            String id = new String(card.command(new byte[]{0x00}, Constants.INS_DECRYPT, Constants.ID), StandardCharsets.UTF_8).replaceAll("[^a-zA-Z0-9]", "");  
            String name = (new String(card.command(new byte[]{0x00}, Constants.INS_DECRYPT, Constants.NAME), StandardCharsets.UTF_8));
            name = user.getFullname();
            String date = new String(card.command(new byte[]{0x00}, Constants.INS_DECRYPT, Constants.DATE), StandardCharsets.UTF_8).replaceAll("[^a-zA-Z0-9,-]", ""); 
            String address = (new String(card.command(new byte[]{0x00}, Constants.INS_DECRYPT, Constants.ADDRESS), StandardCharsets.UTF_8));
            address = user.getAddress();
            String gender = new String(card.command(new byte[]{0x00}, Constants.INS_DECRYPT, Constants.GENDER), StandardCharsets.UTF_8).replaceAll("[^a-zA-Z0-9]", "");
            String id_department = new String(card.command(new byte[]{0x00}, Constants.INS_DECRYPT, Constants.ID_DEPARTMENT), StandardCharsets.UTF_8).replaceAll("[^a-zA-Z0-9]", "");
                   text_name.setText(name);
                   birthday.setDate(DateUtils.stringToDate(date));
                   text_address.setText(address);
                   gender_combobox.setSelectedIndex(Integer.valueOf(gender));
                   id_department_cb.setSelectedIndex(Integer.valueOf(id_department));
                   showId(true);
                   id_text.setText(id);
            getImage(person.getAvatar());
            ImageUltils iU = ImageUltils.getInstance();
            try {
                avatar.setIcon(iU.bufferImageToII(iU.byteToBufferImage(mUser.getAvatar()), avatar));
            } catch (IOException ex) {
                Logger.getLogger(InfoGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    
    private void showId(boolean flag) {
        id_lb.setVisible(flag);
        id_text.setVisible(flag);   
    }
    
    private boolean validateInfo() {
        
        if(text_name.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "CHƯA ĐIỀN HỌ TÊN", "THÔNG BÁO", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        if(text_address.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "CHƯA ĐIỀN ĐỊA CHỈ", "THÔNG BÁO", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        if(avatar == null) {
            JOptionPane.showMessageDialog(this, "CHƯA CHỌN ẢNH ĐẠI DIỆN", "THÔNG BÁO", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        return true;
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
        text_address = new javax.swing.JTextField();
        save_btn = new javax.swing.JButton();
        browser_img = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        avatar = new javax.swing.JLabel();
        text_name = new javax.swing.JTextField();
        birthday = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        gender_combobox = new javax.swing.JComboBox<>();
        id_department_cb = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        title_text = new javax.swing.JLabel();
        id_lb = new javax.swing.JLabel();
        id_text = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        text_address.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        text_address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_addressActionPerformed(evt);
            }
        });

        save_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Save-icon.png"))); // NOI18N
        save_btn.setText("LƯU");
        save_btn.setToolTipText("");
        save_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_btnActionPerformed(evt);
            }
        });

        browser_img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/open-file-icon-16.png"))); // NOI18N
        browser_img.setText("THÊM ẢNH");
        browser_img.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browser_imgActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("HỌ TÊN");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("NGÀY SINH");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("GIỚI TÍNH");

        avatar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        text_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        text_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_nameActionPerformed(evt);
            }
        });

        birthday.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                birthdayMouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("ĐỊA CHỈ");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("PHÒNG BAN");

        gender_combobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NAM", "NU" }));

        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("*.jpg");

        jPanel2.setBackground(new java.awt.Color(0, 153, 255));

        title_text.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        title_text.setForeground(new java.awt.Color(255, 255, 255));
        title_text.setText("NHẬP THÔNG TIN CÁ NHÂN");
        title_text.setToolTipText("");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addComponent(title_text)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title_text, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        id_lb.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        id_lb.setText("MÃ THẺ");

        id_text.setEditable(false);
        id_text.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(id_lb))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(id_text)
                    .addComponent(id_department_cb, 0, 164, Short.MAX_VALUE)
                    .addComponent(text_name)
                    .addComponent(text_address)
                    .addComponent(birthday, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                    .addComponent(gender_combobox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(72, 72, 72)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(avatar, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(browser_img, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 33, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(159, 159, 159))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(save_btn)
                                .addGap(271, 271, 271))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(avatar, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(browser_img)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addGap(82, 82, 82))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(id_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(id_lb))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(text_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(37, 37, 37)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(birthday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGap(46, 46, 46)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(gender_combobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(43, 43, 43)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(text_address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(54, 54, 54))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(id_department_cb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(88, 88, 88)
                .addComponent(save_btn)
                .addGap(85, 85, 85))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void save_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_btnActionPerformed
        // TODO add your handling code here:
        String id;
        User user = new User();
        if(isEmpty) {
         id  = StringUltils.generateId(StringUltils.reducingString(id_department_cb.getSelectedItem().toString()));
         user.setAvatar(imgBytes);
          user.setPub_key(card.pubkeyRsa());
        }
        else {
            id = mUser.getId();
            user.setAvatar(mUser.getAvatar());
            user.setPub_key(mUser.getPub_key());
        }
        String name = text_name.getText().trim();
        String address = text_address.getText().trim();
        System.out.println(name.getBytes().length);
        System.out.println(address.getBytes().length + " length");
//        if(id.length() == 0) {
//            JOptionPane.showMessageDialog(null, "VUI LÒNG NHẬP IḌ");
//            return;
//        }else if (!id.equals("[A-Z0-9]")) {
//            JOptionPane.showMessageDialog(null, "VUI LÒNG NHẬP LẠI IḌ");
//            return;
//        }
//        
//         if(name.length() == 0) {
//            JOptionPane.showMessageDialog(null, "VUI LÒNG NHẬP TÊN");
//            return;
//        }else if (!name.equals("[A-Z0-9 ]")) {
//            JOptionPane.showMessageDialog(null, "VUI LÒNG NHẬP LẠI TÊN");
//            return;
//        }
//         
//          if(address.length() == 0) {
//            JOptionPane.showMessageDialog(null, "VUI LÒNG NHẬP ĐỊA CHỈ");
//            return;
//        }else if (!address.equals("[a-z0-9 ]")) {
//            JOptionPane.showMessageDialog(null, "VUI LÒNG NHẬP LẠI ĐỊA CHỈ");
//            return;
//        }
//         
//          if(avatar.getIcon() == null) {
//              JOptionPane.showMessageDialog(null, "VUI LÒNG NHẬP CHỌN ẢNH");
//            return;
//          }
//          
        Date selectedValue =  birthday.getCalendar().getTime();
        System.out.println(DateUtils.dateToString(selectedValue));  
        
        user.setId(id);
        user.setFullname(name);
        user.setGender(gender_combobox.getSelectedIndex());
        user.setId_department(id_department_cb.getSelectedIndex());
        user.setAddress(address);
        user.setLate_date(new ArrayList<>());
        user.setPassword("12345");
        user.setBirth(selectedValue);
        user.setIsCheckin(false);
        user.setIsCheckout(false);
        user.setCheckinDate(LocalDate.now());
        System.out.println(new String(card.command(card.command(id.getBytes(), Constants.INS_ENCRYPT, Constants.ID), Constants.INS_DECRYPT, Constants.ID), StandardCharsets.UTF_8));
        System.out.println(new String(card.command(card.command(name.trim().getBytes(), Constants.INS_ENCRYPT, Constants.NAME), Constants.INS_DECRYPT, Constants.NAME), StandardCharsets.UTF_8));
        System.out.println(new String(card.command(card.command(DateUtils.dateToString(birthday.getCalendar().getTime()).getBytes(), Constants.INS_ENCRYPT, Constants.DATE), Constants.INS_DECRYPT, Constants.DATE), StandardCharsets.UTF_8));
        System.out.println(new String(card.command(card.command(address.getBytes(), Constants.INS_ENCRYPT, Constants.ADDRESS), Constants.INS_DECRYPT, Constants.ADDRESS), StandardCharsets.UTF_8));
        System.out.println(new String(card.command(card.command(String.valueOf(gender_combobox.getSelectedIndex()).getBytes(), Constants.INS_ENCRYPT, Constants.GENDER), Constants.INS_DECRYPT, Constants.GENDER), StandardCharsets.UTF_8));
        System.out.println(new String(card.command(card.command(String.valueOf(id_department_cb.getSelectedIndex()).getBytes(), Constants.INS_ENCRYPT, Constants.ID_DEPARTMENT), Constants.INS_DECRYPT, Constants.ID_DEPARTMENT), StandardCharsets.UTF_8));

     if(isEmpty)
          dbHelper.insert(user);
     else {
         dbHelper.updateUser(user.getId(), user);
     }
      mListener.onGetUserSuccess(user);
      this.setVisible(false);
      //  System.out.println(text_id.getText().trim());
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
                imgBytes = img;
                System.out.println(img.length);
                ImageIcon icon= new ImageIcon(bimage.getScaledInstance(avatar.getWidth(), avatar.getHeight(), Image.SCALE_SMOOTH));
                icon.getImage();
                avatar.setIcon(icon);
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_browser_imgActionPerformed

    private BufferedImage byteToBufferImage(byte[] in) throws IOException {
        
        InputStream is = new ByteArrayInputStream(in);
        BufferedImage out =  ImageIO.read(is);  
        return out;
        
    }
    
    private ImageIcon bufferImageToII(BufferedImage in) {
        
        ImageIcon icon= new ImageIcon(in.getScaledInstance(avatar.getWidth(), avatar.getHeight(), Image.SCALE_SMOOTH));
        return icon;
    }
    
    private void text_addressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_addressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_addressActionPerformed

    private void birthdayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_birthdayMouseClicked
        // TODO add your handling code here:
         
        
    }//GEN-LAST:event_birthdayMouseClicked

    private void text_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_nameActionPerformed

   

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
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
        java.awt.EventQueue.invokeLater(() -> {
            new InfoGUI(card, mUser, departmentses, isEmpty, mListener).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel avatar;
    private com.toedter.calendar.JDateChooser birthday;
    private javax.swing.JButton browser_img;
    private javax.swing.JComboBox<String> gender_combobox;
    private javax.swing.JComboBox<String> id_department_cb;
    private javax.swing.JLabel id_lb;
    private javax.swing.JTextField id_text;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton save_btn;
    private javax.swing.JTextField text_address;
    private javax.swing.JTextField text_name;
    private javax.swing.JLabel title_text;
    // End of variables declaration//GEN-END:variables

    public void setCallback(OnGetUserListener listener) {
        
        mListener = listener;
    }
    
    @Override
    public void onGetUserSuccess(User user) {
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }
}
