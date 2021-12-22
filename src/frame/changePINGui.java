/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frame;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author traig
 */
public class changePINGui extends javax.swing.JFrame {

    static SmartCardWord card;
    /**
     * Creates new form changePINGui
     * @param card
     */
    public changePINGui(SmartCardWord card) {
        initComponents();
        initEvents();
        this.card = card;
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        change_btn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        check_box_2 = new javax.swing.JCheckBox();
        check_box_3 = new javax.swing.JCheckBox();
        check_box_1 = new javax.swing.JCheckBox();
        current_pass = new javax.swing.JPasswordField();
        new_pass = new javax.swing.JPasswordField();
        confirm_pass = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("PIN CŨ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("PIN MỚI");
        jLabel2.setToolTipText("");

        change_btn.setBackground(new java.awt.Color(255, 255, 255));
        change_btn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        change_btn.setForeground(new java.awt.Color(0, 153, 255));
        change_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Save-icon.png"))); // NOI18N
        change_btn.setText("ĐỔI");
        change_btn.setToolTipText("");
        change_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                change_btnActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("XÁC NHẬN PIN MỚI");
        jLabel4.setToolTipText("");

        check_box_2.setText("Hiện");

        check_box_3.setText("Hiện");

        check_box_1.setText("Hiện");
        check_box_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_box_1ActionPerformed(evt);
            }
        });

        new_pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                new_passActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(0, 153, 255));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ĐỔI MÃ PIN");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(168, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(168, 168, 168))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2))
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(confirm_pass, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                    .addComponent(new_pass)
                    .addComponent(current_pass))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(check_box_2)
                    .addComponent(check_box_3)
                    .addComponent(check_box_1))
                .addContainerGap(115, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(change_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(151, 151, 151))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(check_box_1)
                    .addComponent(current_pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(check_box_2)
                    .addComponent(new_pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(check_box_3)
                    .addComponent(confirm_pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(change_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void change_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_change_btnActionPerformed
        // TODO add your handling code here:
        
        if(!new_pass.getText().equals(confirm_pass.getText())) {
            JOptionPane.showMessageDialog(null, "MÃ PIN MỚI VÀ MÃ PIN XÁC NHẬN KHÔNG TRÙNG NHAU");
            System.out.println("mã mới:" + new_pass.getText());
            return;
        }
        
         MessageDigest md;
          try {
              md = MessageDigest.getInstance("MD5");
              md.update(toHex(current_pass.getText()));
               byte[] digest = md.digest();
               
               String result = card.Open(digest);
            if(result.equals("9000")){
                if(!current_pass.getText().equals(new_pass.getText())){
                      md.reset();
                md.update(toHex(new_pass.getText()));
                digest = md.digest();
                if(card.Open(digest, (byte)5).contains("9000")){
                 //new PINGui(card).setVisible(true);
                 JOptionPane.showMessageDialog(null, "ĐỔI MÃ PIN THÀNH CÔNG");
                 this.setVisible(false);
                }
              
            }else {
                     JOptionPane.showMessageDialog(null, "MÃ PIN MỚI KHÔNG ĐƯỢC GIỐNG MÃ PIN CŨ");
                }
            }
            else if(result.equals("6300")) {
                JOptionPane.showMessageDialog(null, "SAI MÃ PIN HIỆN TẠI");
            } 
          } catch (NoSuchAlgorithmException ex) {
          }
        
        
        
    }//GEN-LAST:event_change_btnActionPerformed

    private void check_box_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_box_1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_check_box_1ActionPerformed

    private void new_passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_new_passActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_new_passActionPerformed
    private void initEvents() {
        check_box_1.setText("");
        check_box_2.setText("");
        check_box_3.setText("");

        check_box_1.addItemListener((ItemEvent e) -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                current_pass.setEchoChar((char) 0);
            } else {
                current_pass.setEchoChar('*');
                
            }
        });
        
        check_box_2.addItemListener((ItemEvent e) -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                new_pass.setEchoChar((char) 0);
            } else {
                
                new_pass.setEchoChar('*');
                
            }
        });
        
        check_box_3.addItemListener((ItemEvent e) -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                confirm_pass.setEchoChar((char) 0);
            } else {
                confirm_pass.setEchoChar('*');
                
            }
        });
    }
    
    public byte[] toHex(String arg) {
 
        byte[] result = new byte[arg.length()];
        for(int i = 0 ; i<arg.length(); i++)
        result[i]= (byte) (arg.charAt(i) - 48);
        return result;
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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(changePINGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(changePINGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(changePINGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(changePINGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new changePINGui(card).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton change_btn;
    private javax.swing.JCheckBox check_box_1;
    private javax.swing.JCheckBox check_box_2;
    private javax.swing.JCheckBox check_box_3;
    private javax.swing.JPasswordField confirm_pass;
    private javax.swing.JPasswordField current_pass;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField new_pass;
    // End of variables declaration//GEN-END:variables

    
}
