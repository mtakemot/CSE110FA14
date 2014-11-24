/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Zack
 */
public class DeleteAccountPanel extends javax.swing.JPanel
{

    private JPanel MainPanel;
    private GUI mainGUI;

    public DeleteAccountPanel(JPanel MainPanel, GUI mainGUI)
    {
        this.MainPanel = MainPanel;
        this.mainGUI = mainGUI;
        initComponents();
    }

    /**
     * Creates new form DeleteAccountPanel
     */
    public DeleteAccountPanel()
    {
        initComponents();
    }
    
    public void updateUserLabel()
    {
        BAUserNameLabel.setText(GUI.currentUserAccount.getUserName());
    }
    
    private void DeleteAcc()
    {
        if (!(AccNameField.getText().equals(GUI.currentUserAccount.getUserName())))
        {
            JOptionPane.showMessageDialog(null, "Incorrect User Account name!", "Error!",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            char[] passwordArray = jPasswordField.getPassword();
            String password = new String(passwordArray);
            if (!(GUI.currentUserAccount.validatePassword(password)))
            {
                JOptionPane.showMessageDialog(null, "Incorrect Password!", "Error!",
                        JOptionPane.INFORMATION_MESSAGE);
            }
            else
            {
                boolean deleted = GUI.MasterTable.deleteUserAccount(GUI.currentUserAccount.getUserName());
                GUI.currentBankAccount = null;
                GUI.currentUserAccount = null;
                CardLayout layout = (CardLayout) (MainPanel.getLayout());
                layout.show(MainPanel, "Login");
                GUI.dataout.exportDB(GUI.MasterTable);
                System.out.println("MSG AccountsListPanel.java: exported DB n == 0");
                
                
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BankNamePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        SettingsButton = new javax.swing.JButton();
        BAUserNameLabel = new javax.swing.JLabel();
        LogoutButtton = new javax.swing.JButton();
        usernameLabel = new javax.swing.JLabel();
        AccNameField = new javax.swing.JTextField();
        ExitButton = new javax.swing.JButton();
        BackButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        jPasswordField = new javax.swing.JPasswordField();

        BankNamePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("             Bank 42");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout BankNamePanelLayout = new javax.swing.GroupLayout(BankNamePanel);
        BankNamePanel.setLayout(BankNamePanelLayout);
        BankNamePanelLayout.setHorizontalGroup(
            BankNamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BankNamePanelLayout.createSequentialGroup()
                .addContainerGap(157, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(136, 136, 136))
        );
        BankNamePanelLayout.setVerticalGroup(
            BankNamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        SettingsButton.setText("Settings");
        SettingsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SettingsButtonMouseClicked(evt);
            }
        });

        BAUserNameLabel.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        BAUserNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BAUserNameLabel.setText(GUI.currentBankAccount.getAccountName());

        LogoutButtton.setText("Logout");
        LogoutButtton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogoutButttonMouseClicked(evt);
            }
        });

        usernameLabel.setFont(new java.awt.Font("DejaVu Sans", 1, 24)); // NOI18N
        usernameLabel.setText("Are you sure you want to delete your account?");

        AccNameField.setText("Account Name");
        AccNameField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                AccNameFieldFocusGained(evt);
            }
        });

        ExitButton.setText("Exit");
        ExitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExitButtonMouseClicked(evt);
            }
        });

        BackButton.setText("Back");
        BackButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackButtonMouseClicked(evt);
            }
        });

        DeleteButton.setText("Delete");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });

        jPasswordField.setText("password");
        jPasswordField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPasswordFieldFocusGained(evt);
            }
        });
        jPasswordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordFieldKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(SettingsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BankNamePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LogoutButtton, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(155, 155, 155)
                .addComponent(DeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(usernameLabel)
                        .addGap(101, 101, 101))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPasswordField)
                            .addComponent(AccNameField, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE))
                        .addGap(167, 167, 167))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(BAUserNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(323, 323, 323))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(BankNamePanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LogoutButtton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SettingsButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(BAUserNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(usernameLabel)
                .addGap(48, 48, 48)
                .addComponent(AccNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void SettingsButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SettingsButtonMouseClicked
        CardLayout layout = (CardLayout) (MainPanel.getLayout());
        layout.show(MainPanel, "Settings");
    }//GEN-LAST:event_SettingsButtonMouseClicked

    private void LogoutButttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutButttonMouseClicked
        GUI.currentBankAccount = null;
        GUI.currentUserAccount = null;
        CardLayout layout = (CardLayout) (MainPanel.getLayout());
        layout.show(MainPanel, "Login");
    }//GEN-LAST:event_LogoutButttonMouseClicked

    private void ExitButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitButtonMouseClicked
        System.exit(0);
    }//GEN-LAST:event_ExitButtonMouseClicked

    private void BackButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackButtonMouseClicked
        CardLayout layout = (CardLayout) (MainPanel.getLayout());
        layout.show(MainPanel, "Settings");
    }//GEN-LAST:event_BackButtonMouseClicked

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        DeleteAcc();
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void AccNameFieldFocusGained(java.awt.event.FocusEvent evt)//GEN-FIRST:event_AccNameFieldFocusGained
    {//GEN-HEADEREND:event_AccNameFieldFocusGained
        AccNameField.setText("");
    }//GEN-LAST:event_AccNameFieldFocusGained

    private void jPasswordFieldFocusGained(java.awt.event.FocusEvent evt)//GEN-FIRST:event_jPasswordFieldFocusGained
    {//GEN-HEADEREND:event_jPasswordFieldFocusGained
        jPasswordField.setText("");
    }//GEN-LAST:event_jPasswordFieldFocusGained

    private void jPasswordFieldKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_jPasswordFieldKeyPressed
    {//GEN-HEADEREND:event_jPasswordFieldKeyPressed
        int key = evt.getKeyCode();
        if (key == java.awt.event.KeyEvent.VK_ENTER)
        {
            DeleteAcc();
        }
    }//GEN-LAST:event_jPasswordFieldKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AccNameField;
    private javax.swing.JLabel BAUserNameLabel;
    private javax.swing.JButton BackButton;
    private javax.swing.JPanel BankNamePanel;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JButton ExitButton;
    private javax.swing.JButton LogoutButtton;
    private javax.swing.JButton SettingsButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
