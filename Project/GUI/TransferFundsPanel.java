/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.*;
import javax.swing.*;
import Backend.*;

/**
 *
 * @author Zack
 */
public class TransferFundsPanel extends javax.swing.JPanel {
    
    private JPanel MainPanel;
    TableWrapper wrapper = new TableWrapper(GUI.currentUserAccount);
    int total_accounts = wrapper.getTotalAccounts();
    String[] accountlist = new String[total_accounts];
    
    public TransferFundsPanel(JPanel MainPanel)
    {
        this.MainPanel = MainPanel;
        
        for(int i=0; i < total_accounts; i++)
        {
            accountlist[i]=wrapper.getAccountName(i);
        }
        initComponents();
    }
    
    /**
     * Creates new form TransferFundsPanel
     */
    public TransferFundsPanel() {
        initComponents();
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
        BATypeLabel = new javax.swing.JLabel();
        BAAmountLabel = new javax.swing.JLabel();
        ExitButton = new javax.swing.JButton();
        BackButton = new javax.swing.JButton();
        TransferButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        BankAccountsList0 = new javax.swing.JComboBox();
        EmailEntryField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        AmountField = new javax.swing.JTextField();
        BankAccountsList1 = new javax.swing.JComboBox();
        TransferButton1 = new javax.swing.JButton();

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

        BAUserNameLabel.setText(GUI.currentBankAccount.getAccountName());

        LogoutButtton.setText("Logout");
        LogoutButtton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogoutButttonMouseClicked(evt);
            }
        });

        BATypeLabel.setText(GUI.currentBankAccount.getAccountType());

        BAAmountLabel.setText(String.valueOf(GUI.currentBankAccount.getBalance()));

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

        TransferButton.setText("Transfer");
        TransferButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TransferButtonMouseClicked(evt);
            }
        });

        jLabel2.setText("Amount to Tranfser");

        jLabel3.setText("Transfer One Of Your Bank Accounts");

        jLabel4.setText("Or Transfer To Another User");

        BankAccountsList0.setModel(new javax.swing.DefaultComboBoxModel(accountlist));
        BankAccountsList0.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                BankAccountsList0FocusGained(evt);
            }
        });
        BankAccountsList0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BankAccountsList0ActionPerformed(evt);
            }
        });

        EmailEntryField.setText("Email Address");
        EmailEntryField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                EmailEntryFieldFocusGained(evt);
            }
        });
        EmailEntryField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailEntryFieldActionPerformed(evt);
            }
        });

        jLabel5.setText("Bank Account To Transfer From");

        AmountField.setText("Amount");
        AmountField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                AmountFieldFocusGained(evt);
            }
        });
        AmountField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AmountFieldActionPerformed(evt);
            }
        });

        BankAccountsList1.setModel(new javax.swing.DefaultComboBoxModel(accountlist));
        BankAccountsList1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BankAccountsList1ActionPerformed(evt);
            }
        });

        TransferButton1.setText("Transfer");
        TransferButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TransferButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(BATypeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(218, 218, 218)
                .addComponent(BAUserNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BAAmountLabel)
                .addGap(36, 36, 36))
            .addGroup(layout.createSequentialGroup()
                .addComponent(SettingsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BankNamePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LogoutButtton, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 108, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addGap(37, 37, 37)))
                                    .addComponent(jLabel4))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(AmountField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(EmailEntryField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(TransferButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(BankAccountsList0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(285, 285, 285))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(BankAccountsList1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(88, 88, 88)
                                            .addComponent(TransferButton, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(BankNamePanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LogoutButtton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SettingsButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BATypeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BAUserNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BAAmountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BankAccountsList0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(AmountField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TransferButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BankAccountsList1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(EmailEntryField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TransferButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(132, 132, 132)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        EmailEntryField.setText("Email Address");
        AmountField.setText("Amount");
        CardLayout layout = (CardLayout) (MainPanel.getLayout());
        layout.show(MainPanel, "AccList");
    }//GEN-LAST:event_BackButtonMouseClicked

    private void TransferButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TransferButtonMouseClicked
        double amount = Integer.parseInt(AmountField.getText());
        
        GUI.currentBankAccount = GUI.currentUserAccount.findBankAccount((String)BankAccountsList0.getSelectedItem());
        if(amount > GUI.currentBankAccount.getBalance())
        {
            AmountField.setText("");
            JOptionPane.showMessageDialog(null, "Insufficient Funds"
                    + "\nYou have " + GUI.currentBankAccount.getBalance()+ "$ available"
                    + " in selected Bank Account");
        }
        else
        {    
            GUI.currentBankAccount.subFromBalance(amount);
            GUI.currentBankAccount = GUI.currentUserAccount.findBankAccount((String)BankAccountsList1.getSelectedItem());
            GUI.currentBankAccount.addToBalance(amount);
            JOptionPane.showMessageDialog(null, "Funds Transfered Successfully!");
            //GUI.MasterTable.findUserAccount();
            // test
        }
    }//GEN-LAST:event_TransferButtonMouseClicked

    private void EmailEntryFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_EmailEntryFieldFocusGained
        EmailEntryField.setText("");
    }//GEN-LAST:event_EmailEntryFieldFocusGained

    private void BankAccountsList0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BankAccountsList0ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BankAccountsList0ActionPerformed

    private void EmailEntryFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailEntryFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmailEntryFieldActionPerformed

    private void AmountFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_AmountFieldFocusGained
        AmountField.setText("");
    }//GEN-LAST:event_AmountFieldFocusGained

    private void AmountFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AmountFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AmountFieldActionPerformed

    private void BankAccountsList1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BankAccountsList1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BankAccountsList1ActionPerformed

    private void TransferButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TransferButton1MouseClicked
        double amount = Integer.parseInt(AmountField.getText());
        String email = EmailEntryField.getText();
        UserAccount founduser;
        if(email!=null)
        {
            founduser = GUI.MasterTable.findUserAccountEmail(email);
        }
        else
        {
            //JOptionPane.showMessageDialog(null, "Please Enter A Valid");
            
        }
            
        GUI.currentBankAccount = GUI.currentUserAccount.findBankAccount((String)BankAccountsList0.getSelectedItem());
        
        if(amount > GUI.currentBankAccount.getBalance())
        {
            AmountField.setText("");
            JOptionPane.showMessageDialog(null, "Insufficient Funds"
                    + "\nYou have " + GUI.currentBankAccount.getBalance()+ "$ available"
                    + " in selected Bank Account");
        }
        else if(founduser!=null)
        {    
            GUI.currentBankAccount.subFromBalance(amount);
            GUI.currentBankAccount = founduser.getBankAccHead();
            GUI.currentBankAccount.addToBalance(amount);
            JOptionPane.showMessageDialog(null, "Funds Transfered Successfully!");
            //GUI.MasterTable.findUserAccount();
            // test
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Error, User Account Not Found");
        }
    }//GEN-LAST:event_TransferButton1MouseClicked

    private void BankAccountsList0FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BankAccountsList0FocusGained
        /*TableWrapper mywrapper = new TableWrapper(GUI.currentUserAccount);
        total_accounts = mywrapper.getTotalAccounts();
        accountlist = new String[total_accounts];
        for(int i=0; i < total_accounts; i++)
        {
            accountlist[i]=mywrapper.getAccountName(i);
        }
        initComponents();*/
    }//GEN-LAST:event_BankAccountsList0FocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AmountField;
    private javax.swing.JLabel BAAmountLabel;
    private javax.swing.JLabel BATypeLabel;
    private javax.swing.JLabel BAUserNameLabel;
    private javax.swing.JButton BackButton;
    private javax.swing.JComboBox BankAccountsList0;
    private javax.swing.JComboBox BankAccountsList1;
    private javax.swing.JPanel BankNamePanel;
    private javax.swing.JTextField EmailEntryField;
    private javax.swing.JButton ExitButton;
    private javax.swing.JButton LogoutButtton;
    private javax.swing.JButton SettingsButton;
    private javax.swing.JButton TransferButton;
    private javax.swing.JButton TransferButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
