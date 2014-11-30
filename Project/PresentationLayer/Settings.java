package PresentationLayer;

import javax.swing.*;
import java.awt.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author asharda
 */
public class Settings extends javax.swing.JPanel
{

    /**
     * Creates new form Settings
     */
    private JPanel MainPanel;
    private GUI mainGUI;

    public Settings()
    {
        initComponents();
    }

    public Settings(JPanel MainPanel, GUI mainGUI)
    {
        this.MainPanel = MainPanel;
        this.mainGUI = mainGUI;
                        
        initComponents();
    }

    public void updateUserLabel()
    {
        BAUserNameLabel.setText("User " + GUI.currentUserAccount.getUserName());        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        LogoutButtton = new javax.swing.JButton();
        BackButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        FirstName = new javax.swing.JLabel();
        LastName = new javax.swing.JLabel();
        Username = new javax.swing.JLabel();
        Email = new javax.swing.JLabel();
        PhoneNumber = new javax.swing.JLabel();
        UserLastName = new javax.swing.JLabel();
        UserFirstName = new javax.swing.JLabel();
        UserUsername = new javax.swing.JLabel();
        UserEmail = new javax.swing.JLabel();
        UserPhoneNumber = new javax.swing.JLabel();
        EditLastName = new javax.swing.JButton();
        EditFirstName = new javax.swing.JButton();
        EditUsername = new javax.swing.JButton();
        EditEmail = new javax.swing.JButton();
        EditPhoneNumber = new javax.swing.JButton();
        Password = new javax.swing.JLabel();
        UserPassword = new javax.swing.JLabel();
        DeleteAccountButton = new javax.swing.JButton();
        BAUserNameLabel = new javax.swing.JLabel();
        EditPassword = new javax.swing.JButton();
        errorMessage = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(800, 600));
        setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("DejaVu Sans", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Bank 42");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        add(jLabel1, gridBagConstraints);

        LogoutButtton.setText("Logout");
        LogoutButtton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogoutButttonMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 10);
        add(LogoutButtton, gridBagConstraints);

        BackButton.setText("Back");
        BackButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackButtonMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 0);
        add(BackButton, gridBagConstraints);

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jPanel1.setName(""); // NOI18N
        jPanel1.setOpaque(false);
        java.awt.GridBagLayout jPanel1Layout = new java.awt.GridBagLayout();
        jPanel1Layout.columnWidths = new int[] {0, 30, 0, 30, 0, 30, 0};
        jPanel1Layout.rowHeights = new int[] {0, 9, 0, 9, 0, 9, 0, 9, 0, 9, 0, 9, 0, 9, 0, 9, 0, 9, 0};
        jPanel1.setLayout(jPanel1Layout);

        FirstName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        FirstName.setText("First Name");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel1.add(FirstName, gridBagConstraints);

        LastName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        LastName.setText("Last Name");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel1.add(LastName, gridBagConstraints);

        Username.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Username.setText("Username");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel1.add(Username, gridBagConstraints);

        Email.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Email.setText("Email");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel1.add(Email, gridBagConstraints);

        PhoneNumber.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        PhoneNumber.setText("Phone Number");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel1.add(PhoneNumber, gridBagConstraints);

        UserLastName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        UserLastName.setText("jLabel2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel1.add(UserLastName, gridBagConstraints);

        UserFirstName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        UserFirstName.setText("jLabel3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel1.add(UserFirstName, gridBagConstraints);

        UserUsername.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        UserUsername.setText("jLabel4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel1.add(UserUsername, gridBagConstraints);

        UserEmail.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        UserEmail.setText("jLabel5");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel1.add(UserEmail, gridBagConstraints);

        UserPhoneNumber.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        UserPhoneNumber.setText("jLabel6");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel1.add(UserPhoneNumber, gridBagConstraints);

        EditLastName.setText("Edit");
        EditLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditLastNameActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 4;
        jPanel1.add(EditLastName, gridBagConstraints);

        EditFirstName.setText("Edit");
        EditFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditFirstNameActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 6;
        jPanel1.add(EditFirstName, gridBagConstraints);

        EditUsername.setText("Edit");
        EditUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditUsernameActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 8;
        jPanel1.add(EditUsername, gridBagConstraints);

        EditEmail.setText("Edit");
        EditEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditEmailActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 10;
        jPanel1.add(EditEmail, gridBagConstraints);

        EditPhoneNumber.setText("Edit");
        EditPhoneNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditPhoneNumberActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 12;
        jPanel1.add(EditPhoneNumber, gridBagConstraints);

        Password.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Password.setText("Password");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel1.add(Password, gridBagConstraints);

        UserPassword.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        UserPassword.setText("*****");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel1.add(UserPassword, gridBagConstraints);

        DeleteAccountButton.setText("Delete Main Account");
        DeleteAccountButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeleteAccountButtonMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 18;
        jPanel1.add(DeleteAccountButton, gridBagConstraints);

        BAUserNameLabel.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        BAUserNameLabel.setText("User" + PresentationLayer.GUI.currentBankAccount.getAccountName());
        jPanel1.add(BAUserNameLabel, new java.awt.GridBagConstraints());

        EditPassword.setText("Edit");
        EditPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditPasswordActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 14;
        jPanel1.add(EditPassword, gridBagConstraints);

        errorMessage.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        errorMessage.setForeground(new java.awt.Color(255, 102, 102));
        errorMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        errorMessage.setText("Please click on the Edit button to change info.");
        errorMessage.setPreferredSize(new java.awt.Dimension(304, 15));
        errorMessage.setRequestFocusEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel1.add(errorMessage, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel2.add(jPanel1, gridBagConstraints);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/rsz_1big_42_robot.jpg"))); // NOI18N
        jLabel2.setMaximumSize(new java.awt.Dimension(683, 384));
        jLabel2.setMinimumSize(new java.awt.Dimension(683, 384));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel2.add(jLabel2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        add(jPanel2, gridBagConstraints);

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Background2.jpg"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(Background, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    public void update()
    {
        UserLastName.setText(GUI.currentUserAccount.getLastName());
        UserFirstName.setText(GUI.currentUserAccount.getFirstName());
        UserUsername.setText(GUI.currentUserAccount.getUserName());
        UserEmail.setText(GUI.currentUserAccount.getEmail());
        UserPhoneNumber.setText(GUI.currentUserAccount.getPhone());
    }

    private void BackButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackButtonMouseClicked
        CardLayout layout = (CardLayout) (MainPanel.getLayout());
        layout.show(MainPanel, "AccList");
    }//GEN-LAST:event_BackButtonMouseClicked

    private void LogoutButttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutButttonMouseClicked
        GUI.currentBankAccount = null;
        GUI.currentUserAccount = null;
        CardLayout layout = (CardLayout) (MainPanel.getLayout());
        layout.show(MainPanel, "Login");
    }//GEN-LAST:event_LogoutButttonMouseClicked

    private void DeleteAccountButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteAccountButtonMouseClicked

        JPanel passpanel = mainGUI.getPass().GetPanel();
        int choice = JOptionPane.showConfirmDialog(
                null,
                passpanel,
                "Bank 42",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );

        if (choice == 0)
        {
            String password = mainGUI.getPass().GetPassword();
            if (!(GUI.currentUserAccount.validatePassword(password)))
            {
                JOptionPane.showMessageDialog(null, "Incorrect Password!", "Error!",
                        JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            int choice2 = JOptionPane.showConfirmDialog(
                    null,
                    "Are You Sure You Want To Delete Your Account?",
                    "Bank 42",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.PLAIN_MESSAGE
            );

            if (choice2 == 0)
            {
                String passwrd = mainGUI.getPass().GetPassword();
                if (!(GUI.currentUserAccount.validatePassword(passwrd)))
                {
                    JOptionPane.showMessageDialog(null, "Incorrect Password!", "Error!",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    GUI.MasterTable.deleteUserAccount(GUI.currentUserAccount.getUserName());
                    GUI.currentBankAccount = null;
                    GUI.currentUserAccount = null;
                    CardLayout layout = (CardLayout) (MainPanel.getLayout());
                    layout.show(MainPanel, "Login");
                }
            }
        }

    }//GEN-LAST:event_DeleteAccountButtonMouseClicked

    private void EditLastNameActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_EditLastNameActionPerformed
    {//GEN-HEADEREND:event_EditLastNameActionPerformed
        String response = JOptionPane.showInputDialog(null, "Enter Your New Last Name:", "Bank 42", 1);

        if (response == null)
            return;

        response = response.trim();
        if ((response.length() > 0) && CreateAccountPanel.validateLastName(response))
        {
            GUI.currentUserAccount.setLastName(response);
            update();
        }
        else
        {
            errorMessage.setText("Your last name was entered incorrectly.");
        }
    }//GEN-LAST:event_EditLastNameActionPerformed

    private void EditFirstNameActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_EditFirstNameActionPerformed
    {//GEN-HEADEREND:event_EditFirstNameActionPerformed
        String response = JOptionPane.showInputDialog("Enter Your New First:");

        if (response == null)
            return;

        response = response.trim();

        if ((response.length() > 0) && CreateAccountPanel.validateFirstName(response))
        {
            GUI.currentUserAccount.setFirstName(response);
            update();
        }
        else
        {
            errorMessage.setText("Your first name was entered incorrectly.");
        }
    }//GEN-LAST:event_EditFirstNameActionPerformed

    private void EditUsernameActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_EditUsernameActionPerformed
    {//GEN-HEADEREND:event_EditUsernameActionPerformed
        String response = JOptionPane.showInputDialog("Enter Your New Username:");

        if (response == null)
            return;

        response = response.trim();
        if ((response.length() > 0) && (CreateAccountPanel.validate(response)))
        {
            GUI.currentUserAccount.setUserName(response);
            update();
        }
        else
        {
            errorMessage.setText("Your username was entered incorrectly");
        }
    }//GEN-LAST:event_EditUsernameActionPerformed

    private void EditEmailActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_EditEmailActionPerformed
    {//GEN-HEADEREND:event_EditEmailActionPerformed
        String response = JOptionPane.showInputDialog("Enter Your New Email:");

        if (response == null)
            return;

        response = response.trim();
        if ((response.length() > 0) && (CreateAccountPanel.isValidEmailAddress(response)))
        {
            GUI.currentUserAccount.setEmail(response);
            update();
        }
        else
        {
            errorMessage.setText("Your email was entered incorrectly.");
        }
    }//GEN-LAST:event_EditEmailActionPerformed

    private void EditPhoneNumberActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_EditPhoneNumberActionPerformed
    {//GEN-HEADEREND:event_EditPhoneNumberActionPerformed
        String response = JOptionPane.showInputDialog("Enter Your New Phone Number:");

        if (response == null)
            return;

        response = response.trim();
        if ((response.length() > 0) && (CreateAccountPanel.validatePhoneNumber(response)))
        {
            GUI.currentUserAccount.setPhone(response);
            update();
        }
        else
        {
            errorMessage.setText("Your phone number was entered incorrectly.");
        }
    }//GEN-LAST:event_EditPhoneNumberActionPerformed

    private void EditPasswordActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_EditPasswordActionPerformed
    {//GEN-HEADEREND:event_EditPasswordActionPerformed
        String response = JOptionPane.showInputDialog("Enter Your New Password:");

        if (response == null)
            return;

        response = response.trim();
        if ((response.length() > 0) && (CreateAccountPanel.validatePassword(response)))
        {
            GUI.currentUserAccount.setPassword(response);
            update();
        }
        else
        {
            errorMessage.setText("Your password was entered incorrectly.");
        }
    }//GEN-LAST:event_EditPasswordActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BAUserNameLabel;
    private javax.swing.JButton BackButton;
    private javax.swing.JLabel Background;
    private javax.swing.JButton DeleteAccountButton;
    private javax.swing.JButton EditEmail;
    private javax.swing.JButton EditFirstName;
    private javax.swing.JButton EditLastName;
    private javax.swing.JButton EditPassword;
    private javax.swing.JButton EditPhoneNumber;
    private javax.swing.JButton EditUsername;
    private javax.swing.JLabel Email;
    private javax.swing.JLabel FirstName;
    private javax.swing.JLabel LastName;
    private javax.swing.JButton LogoutButtton;
    private javax.swing.JLabel Password;
    private javax.swing.JLabel PhoneNumber;
    private javax.swing.JLabel UserEmail;
    private javax.swing.JLabel UserFirstName;
    private javax.swing.JLabel UserLastName;
    private javax.swing.JLabel UserPassword;
    private javax.swing.JLabel UserPhoneNumber;
    private javax.swing.JLabel UserUsername;
    private javax.swing.JLabel Username;
    private javax.swing.JLabel errorMessage;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
