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
import java.awt.Color;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class PINGui extends javax.swing.JFrame {
    
    private String text = "";
    private boolean isConnected = false;
    private static SmartCardWord card;
    /** Creates new form Find */
    public PINGui(SmartCardWord cardWord) {
        initComponents();
        this.setResizable(false);
        card = cardWord;
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        text_input = new javax.swing.JTextPane();
        clear_btn = new javax.swing.JButton();
        btn_five = new javax.swing.JButton();
        btn_siz = new javax.swing.JButton();
        btn_seven = new javax.swing.JButton();
        btn_eight = new javax.swing.JButton();
        btn_nine = new javax.swing.JButton();
        btn_zero = new javax.swing.JButton();
        PIN = new javax.swing.JButton();
        btn_one = new javax.swing.JButton();
        btn_two = new javax.swing.JButton();
        btn_three = new javax.swing.JButton();
        btn_four = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Find");
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(236, 236, 255));

        jLabel1.setFont(new java.awt.Font("Stencil", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 153));
        jLabel1.setText("NHAP MA PIN");

        text_input.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jScrollPane2.setViewportView(text_input);

        clear_btn.setBackground(new java.awt.Color(255, 255, 255));
        clear_btn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        clear_btn.setForeground(new java.awt.Color(255, 102, 51));
        clear_btn.setText("XOA");
        clear_btn.setToolTipText("");
        clear_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear_btnActionPerformed(evt);
            }
        });

        btn_five.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_five.setText("5");
        btn_five.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_fiveActionPerformed(evt);
            }
        });

        btn_siz.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_siz.setText("6");
        btn_siz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sizActionPerformed(evt);
            }
        });

        btn_seven.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_seven.setText("7");
        btn_seven.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sevenActionPerformed(evt);
            }
        });

        btn_eight.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_eight.setText("8");
        btn_eight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eightActionPerformed(evt);
            }
        });

        btn_nine.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_nine.setText("9");
        btn_nine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nineActionPerformed(evt);
            }
        });

        btn_zero.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_zero.setText("0");
        btn_zero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_zeroActionPerformed(evt);
            }
        });

        PIN.setBackground(new java.awt.Color(255, 255, 255));
        PIN.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        PIN.setForeground(new java.awt.Color(153, 0, 153));
        PIN.setText("OK");
        PIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PINActionPerformed(evt);
            }
        });

        btn_one.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_one.setText("1");
        btn_one.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_oneActionPerformed(evt);
            }
        });

        btn_two.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_two.setText("2");
        btn_two.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_twoActionPerformed(evt);
            }
        });

        btn_three.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_three.setText("3");
        btn_three.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_threeActionPerformed(evt);
            }
        });

        btn_four.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_four.setText("4");
        btn_four.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_fourActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(clear_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 90, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_seven)
                            .addComponent(btn_four)
                            .addComponent(btn_one))
                        .addGap(57, 57, 57)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_five)
                            .addComponent(btn_eight)
                            .addComponent(btn_two)))
                    .addComponent(btn_zero, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_three))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_siz, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_nine, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(PIN, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(81, 81, 81))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(clear_btn)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_one)
                    .addComponent(btn_two)
                    .addComponent(btn_three))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_four)
                    .addComponent(btn_five)
                    .addComponent(btn_siz))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_seven)
                    .addComponent(btn_eight)
                    .addComponent(btn_nine))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_zero)
                    .addComponent(PIN))
                .addContainerGap(96, Short.MAX_VALUE))
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

    private void PINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PINActionPerformed
        // TODO add your handling code here:
        
        
        MessageDigest md;
          try {
              md = MessageDigest.getInstance("MD5");
              md.update(toHex(text));
               byte[] digest = md.digest();
               String result = card.Open(digest);
        if(result.equals("9000")){
                JOptionPane.showMessageDialog(null, "THANH CONG");
                this.setVisible(false);
                new MainApp(card).setVisible(true);
            }
            else if(result.equals("6300")) {
                JOptionPane.showMessageDialog(null, "THU LAI");
                
            } 
          } catch (NoSuchAlgorithmException ex) {
              Logger.getLogger(WelcomeGUI.class.getName()).log(Level.SEVERE, null, ex);
          }
        
      
    }//GEN-LAST:event_PINActionPerformed

    public  byte[] toHex(String arg) {
 
        byte[] result = new byte[arg.length()];
        for(int i = 0 ; i<arg.length(); i++)
        result[i]= (byte) (arg.charAt(i) - 48);
        return result;
}
    
    public  byte[] hexStringToByteArray(String s) {
    int len = s.length();
    byte[] data = new byte[len / 2];
    for (int i = 0; i < len-1; i += 2) {
        data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                             + Character.digit(s.charAt(i+1), 16));
    }
    return data;
} 
    
    private void btn_eightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eightActionPerformed
        // TODO add your handling code here:
         text += (btn_eight.getText());
        text_input.setText(text);
    }//GEN-LAST:event_btn_eightActionPerformed

    private void btn_fiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_fiveActionPerformed
        // TODO add your handling code here:
        text +=(btn_five.getText());
        text_input.setText(text);
    }//GEN-LAST:event_btn_fiveActionPerformed

    private void btn_sizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sizActionPerformed
        // TODO add your handling code here:
         text +=(btn_siz.getText());
        text_input.setText(text);
    }//GEN-LAST:event_btn_sizActionPerformed

    private void btn_twoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_twoActionPerformed
        // TODO add your handling code here:
         text +=(btn_two.getText());
        text_input.setText(text);
    }//GEN-LAST:event_btn_twoActionPerformed

    private void btn_threeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_threeActionPerformed
        // TODO add your handling code here:
         text +=(btn_three.getText());
        text_input.setText(text);
    }//GEN-LAST:event_btn_threeActionPerformed

    private void btn_oneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_oneActionPerformed
        // TODO add your handling code here:
        text +=(btn_one.getText());
        text_input.setText(text);
    }//GEN-LAST:event_btn_oneActionPerformed

    private void btn_fourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_fourActionPerformed
        // TODO add your handling code here:
         text +=(btn_four.getText());
        text_input.setText(text);
    }//GEN-LAST:event_btn_fourActionPerformed

    private void btn_sevenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sevenActionPerformed
        // TODO add your handling code here:
          text +=(btn_seven.getText());
        text_input.setText(text);
    }//GEN-LAST:event_btn_sevenActionPerformed

    private void btn_nineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nineActionPerformed
        // TODO add your handling code here:
         text +=(btn_nine.getText());
        text_input.setText(text);
    }//GEN-LAST:event_btn_nineActionPerformed

    private void btn_zeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_zeroActionPerformed
        // TODO add your handling code here:
         text +=(btn_zero.getText());
        text_input.setText(text);
    }//GEN-LAST:event_btn_zeroActionPerformed

    private void clear_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear_btnActionPerformed
        // TODO add your handling code here:
        text = "";
        text_input.setText("");
    }//GEN-LAST:event_clear_btnActionPerformed
    
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
            java.util.logging.Logger.getLogger(PINGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PINGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PINGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PINGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PINGui(card).setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton PIN;
    private javax.swing.JButton btn_eight;
    private javax.swing.JButton btn_five;
    private javax.swing.JButton btn_four;
    private javax.swing.JButton btn_nine;
    private javax.swing.JButton btn_one;
    private javax.swing.JButton btn_seven;
    private javax.swing.JButton btn_siz;
    private javax.swing.JButton btn_three;
    private javax.swing.JButton btn_two;
    private javax.swing.JButton btn_zero;
    private javax.swing.JButton clear_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextPane text_input;
    // End of variables declaration//GEN-END:variables
    
}
