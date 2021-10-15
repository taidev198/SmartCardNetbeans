/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package examples;

import static examples.InfoGUI.card;
import examples.data.Constants;
import examples.data.User;
import examples.utils.DataBaseUtils;
import examples.utils.DateUtils;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.YearMonth;
import java.time.temporal.WeekFields;
import java.util.Arrays;
import java.util.Locale;
import javax.smartcardio.Card;
import javax.swing.AbstractListModel;
import javax.swing.JOptionPane;


public class MainApp extends javax.swing.JFrame implements OnGetUserListener, OnGetRuleListener, OnGetPinStatusListener{
    
    private static SmartCardWord card;
     private boolean isConnected = false;
     private User mUser;
    private Checkin mCheckIn;
    private DataBaseUtils dbHelper = DataBaseUtils.getInstance();

    /** Creates new form Antenna */
    public MainApp() {
        initComponents();
        
        card = new SmartCardWord();
        initData();
        calendarPanel.setLayout(new java.awt.BorderLayout());
        calendarPanel.add(new CalendarPanel());
        calendarPanel.revalidate();
        calendarPanel.repaint();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        checkinBtn = new javax.swing.JButton();
        changePinBtn = new javax.swing.JButton();
        connect_btn = new javax.swing.JButton();
        delete_btn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        text_id = new javax.swing.JLabel();
        text_name = new javax.swing.JLabel();
        text_birth = new javax.swing.JLabel();
        text_gender = new javax.swing.JLabel();
        text_address = new javax.swing.JLabel();
        text_department = new javax.swing.JLabel();
        calendarPanel = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Antenna");

        jPanel1.setBackground(new java.awt.Color(236, 236, 255));

        jLabel1.setFont(new java.awt.Font("Stencil", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 153));
        jLabel1.setText("TRANG CHU THE CHAM CONG");

        jPanel2.setBackground(new java.awt.Color(153, 205, 212));

        jButton1.setBackground(new java.awt.Color(235, 235, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("KHỞI TẠO THÔNG TIN THẺ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(236, 236, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("SỬA THÔNG TIN THẺ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        checkinBtn.setBackground(new java.awt.Color(236, 236, 255));
        checkinBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        checkinBtn.setText("ĐIỂM DANH");
        checkinBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkinBtnActionPerformed(evt);
            }
        });

        changePinBtn.setBackground(new java.awt.Color(236, 236, 255));
        changePinBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        changePinBtn.setText("ĐỔI MÃ PIN");
        changePinBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePinBtnActionPerformed(evt);
            }
        });

        connect_btn.setBackground(new java.awt.Color(0, 255, 51));
        connect_btn.setText("CONNECT");
        connect_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connect_btnActionPerformed(evt);
            }
        });

        delete_btn.setBackground(new java.awt.Color(236, 236, 255));
        delete_btn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        delete_btn.setText("XOA THE");
        delete_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(connect_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(checkinBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(changePinBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(delete_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(connect_btn)
                .addGap(36, 36, 36)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(changePinBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(checkinBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(delete_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(96, Short.MAX_VALUE))
        );

        jLabel2.setText("AVATAR");

        jLabel3.setText("ID");

        jLabel4.setText("FULLNAME");

        jLabel5.setText("BRITH");

        jLabel6.setText("GENDER");

        jLabel7.setText("ADDRESS");

        jLabel8.setText("DEPARTMENT");

        jPanel4.setBackground(new java.awt.Color(121, 200, 232));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.lightGray, null, null));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel9.setText("THÔNG TIN CHỦ THẺ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        text_id.setText("N/A");

        text_name.setText("N/A");

        text_birth.setText("N/A");

        text_gender.setText("N/A");

        text_address.setText("N/A");

        text_department.setText("N/A");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(0, 503, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addContainerGap(522, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text_id, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text_name)
                    .addComponent(text_birth)
                    .addComponent(text_gender)
                    .addComponent(text_address)
                    .addComponent(text_department))
                .addGap(187, 187, 187))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(text_id))
                .addGap(44, 44, 44)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(text_name))
                .addGap(44, 44, 44)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(text_birth))
                .addGap(44, 44, 44)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(text_gender))
                .addGap(39, 39, 39)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(text_address))
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(text_department))
                .addGap(3, 3, 3))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(96, 96, 96))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout calendarPanelLayout = new javax.swing.GroupLayout(calendarPanel);
        calendarPanel.setLayout(calendarPanelLayout);
        calendarPanelLayout.setHorizontalGroup(
            calendarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 358, Short.MAX_VALUE)
        );
        calendarPanelLayout.setVerticalGroup(
            calendarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 332, Short.MAX_VALUE)
        );

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel10.setText("THONG KE");

        jButton4.setBackground(new java.awt.Color(236, 236, 255));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setText("CÀI ĐẶT LUẬT");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(calendarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addComponent(jLabel10)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(30, 30, 30))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(calendarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(isConnected) {
              InfoGUI infoGUI = new InfoGUI(card, true, this);
     //   infoGUI.setCallback(this);
        infoGUI.setVisible(true);
        
       // this.setVisible(false);
        }
      
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if(isConnected) {
           new InfoGUI(card, false, this).setVisible(true);

        }
//        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void checkinBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkinBtnActionPerformed
        // TODO add your handling code here:
       PINGui pin =  new PINGui(card, this);
       pin.setVisible(true);
       if(pin.getStatus()) {
           System.out.println("done");
            if(isConnected) {
                if(card.VerifyRsa(mUser.getPub_key())) {
                    System.out.println("done");
                }
                
             if(!mCheckIn.isIsCheckedIn()) {
            String s = mCheckIn.checkIn();
            System.out.println(s);
        }
       }  
        }
       
       
    }//GEN-LAST:event_checkinBtnActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
         new RuleFrame(this, dbHelper.getRule()).setVisible(true);
       
    }//GEN-LAST:event_jButton4ActionPerformed

    private void changePinBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changePinBtnActionPerformed
        // TODO add your handling code here:
        if(isConnected) {
            new changePINGui(card).setVisible(true);

        }
        //this.setVisible(false);
    }//GEN-LAST:event_changePinBtnActionPerformed

    private void connect_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connect_btnActionPerformed
        // TODO add your handling code here:
        
          if(!isConnected) {
            if(card.connectCard()) {
                isConnected = true;
                JOptionPane.showMessageDialog(this, "ket noi thanh cong");
                connect_btn.setText("DISCONNECT");
                initData();               
            }else{
                JOptionPane.showMessageDialog(this, "chua ket noi applet");
                isConnected = false;
                
            }
        }else {
            if(card.disconnect()){
                isConnected = false;
                connect_btn.setText("CONNECT");
            }
        }
        
    }//GEN-LAST:event_connect_btnActionPerformed

    private void delete_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_btnActionPerformed
        // TODO add your handling code here:
        if(isConnected) {
        JOptionPane.showMessageDialog(this, "XOA THE THANH CONG");
        
        //XOA THONG TIN TREN THE
         // id
        System.out.println(new String(card.command(card.command(" ".getBytes(), Constants.INS_ENCRYPT, Constants.ID), Constants.INS_DECRYPT, Constants.ID), StandardCharsets.UTF_8));
    //id
        System.out.println(new String(card.command(card.command(" ".getBytes(), Constants.INS_ENCRYPT, Constants.NAME), Constants.INS_DECRYPT, Constants.NAME), StandardCharsets.UTF_8));
    //id
        System.out.println(new String(card.command(card.command(" ".getBytes(), Constants.INS_ENCRYPT, Constants.DATE), Constants.INS_DECRYPT, Constants.DATE), StandardCharsets.UTF_8));
    //id
        System.out.println(new String(card.command(card.command(" ".getBytes(), Constants.INS_ENCRYPT, Constants.ADDRESS), Constants.INS_DECRYPT, Constants.ADDRESS), StandardCharsets.UTF_8));
    //id
    
        System.out.println(new String(card.command(card.command(" ".getBytes(), Constants.INS_ENCRYPT, Constants.GENDER), Constants.INS_DECRYPT, Constants.GENDER), StandardCharsets.UTF_8));

        System.out.println(new String(card.command(card.command(" ".getBytes(), Constants.INS_ENCRYPT, Constants.ID_DEPARTMENT), Constants.INS_DECRYPT, Constants.ID_DEPARTMENT), StandardCharsets.UTF_8));

        //xoa thong tin tren db
        dbHelper.getCol("users"); 
        dbHelper.deleteUser(text_id.getText());
        System.out.println(text_id.getText());
        text_id.setText("N/A");
            text_name.setText("N/A");
            text_address.setText("N/A");
            System.out.println("N/A");
            text_birth.setText("N/A");
            text_gender.setText("N/A");
            text_department.setText("N/A");      
        }
        
      
    }//GEN-LAST:event_delete_btnActionPerformed

    @Override
    public void onGetUserSuccess(User user) {
        mUser = user;
        text_id.setText(user.getId());
        text_name.setText(user.getFullname());
        text_address.setText(user.getAddress());
        text_birth.setText(DateUtils.dateToString(user.getBirth()));
        text_gender.setText(String.valueOf(user.getGender()));
        text_department.setText(String.valueOf(user.getId_department()));
    }

    private void initData() {
        dbHelper.setRuleCol("rule");
        if(isConnected) {
            String id = new String(card.command(new byte[]{0x00}, Constants.INS_DECRYPT, Constants.ID), StandardCharsets.UTF_8).replaceAll("[^a-zA-Z0-9]", "");  
            String name = new String(card.command(new byte[]{0x00}, Constants.INS_DECRYPT, Constants.NAME), StandardCharsets.UTF_8).replaceAll("[^a-zA-Z0-9 ]", "");  
            String date = new String(card.command(new byte[]{0x00}, Constants.INS_DECRYPT, Constants.DATE), StandardCharsets.UTF_8).replaceAll("[^a-zA-Z0-9,-]", "");  
            String address = new String(card.command(new byte[]{0x00}, Constants.INS_DECRYPT, Constants.ADDRESS), StandardCharsets.UTF_8).replaceAll("[^a-zA-Z0-9, -]", ""); 
            String gender = new String(card.command(new byte[]{0x00}, Constants.INS_DECRYPT, Constants.GENDER), StandardCharsets.UTF_8).replaceAll("[^a-zA-Z0-9]", ""); 
            String id_department = new String(card.command(new byte[]{0x00}, Constants.INS_DECRYPT, Constants.ID_DEPARTMENT), StandardCharsets.UTF_8).replaceAll("[^a-zA-Z0-9]", ""); 
        if(!id.equals("p3")) {
            text_id.setText(id);
            text_name.setText(name);
            text_address.setText(address);
            System.out.println(date);
            text_birth.setText(date);
            text_gender.setText(gender);
            text_department.setText(id_department);
        }
        }

    }

    @Override
    public void onGetRuleSuccess(Checkin checkin) {
        mCheckIn = checkin;
        dbHelper.addRule(mCheckIn);
    }

    @Override
    public void onGetPinStatusSuccessful() {

        if(mUser == null) {
             dbHelper.getCol("users"); 
           mUser = dbHelper.findUser(text_id.getText());
            System.out.println(mUser.getPub_key());
        }
       
        if(card.VerifyRsa(mUser.getPub_key())) {
            System.out.println("done");
        }

    }
    
    
    class CalendarViewListModel extends AbstractListModel< LocalDate> {
  public static final int ROW_COUNT = 6;
  private final LocalDate startDate;
  private final WeekFields weekFields = WeekFields.of(Locale.getDefault());
  protected CalendarViewListModel(LocalDate date) {
    super();
    LocalDate firstDayOfMonth = YearMonth.from(date).atDay(1);
    int dowv = firstDayOfMonth.get(weekFields.dayOfWeek()) - 1;
    startDate = firstDayOfMonth.minusDays(dowv);
  }
  @Override public int getSize() {
    return DayOfWeek.values().length * ROW_COUNT;
  }
  @Override public LocalDate getElementAt(int index) {
    return startDate.plusDays(index);
  }
}
      
    public byte[] hexStringToByteHexArr(String s) {
        byte[] result = new byte[s.length()];
        
      //Converting string to character array
      char ch[] = s.toCharArray();
      for(int i = 0; i < ch.length; i++) {
         result[i] = (byte) (Integer.parseInt(Integer.toHexString(ch[i]),16) );
       
      }
      return result;
    }
   
     //convert byte to hex
    public String atrToHex(byte[] arr) {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i< arr.length; i++)
            result.append(String.format("%02x", arr[i]));
        return result.toString();
    }
    
    public static byte[] hexStringToByteArray(String s) {
    int len = s.length();
    byte[] data = new byte[len / 2];
    for (int i = 0; i < len; i += 2) {
        data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                             + Character.digit(s.charAt(i+1), 16));
    }
    return data;
}
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            javax.swing.UIManager.LookAndFeelInfo[] installedLookAndFeels=javax.swing.UIManager.getInstalledLookAndFeels();
            for (int idx=0; idx<installedLookAndFeels.length; idx++)
                if ("Nimbus".equals(installedLookAndFeels[idx].getName())) {
                    javax.swing.UIManager.setLookAndFeel(installedLookAndFeels[idx].getClassName());
                    break;
                }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainApp().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel calendarPanel;
    private javax.swing.JButton changePinBtn;
    private javax.swing.JButton checkinBtn;
    private javax.swing.JButton connect_btn;
    private javax.swing.JButton delete_btn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel text_address;
    private javax.swing.JLabel text_birth;
    private javax.swing.JLabel text_department;
    private javax.swing.JLabel text_gender;
    private javax.swing.JLabel text_id;
    private javax.swing.JLabel text_name;
    // End of variables declaration//GEN-END:variables
    
}
