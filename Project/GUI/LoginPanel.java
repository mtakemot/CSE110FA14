package GUI;

/****************************************************************************

                                                        Michio Takemoto
                                                        CSE 110, Fall 2014
                                          Last Updated: November 3, 2014

                                Team 42

File Name:      LoginPanel.java
Description:    This class will define what our Login Page will look like and 
                how it will behave.
 ****************************************************************************/

import javax.swing.*;
import java.awt.*;

public class LoginPanel extends javax.swing.JPanel
{

    // VERY IMPORTANT !! YOU MUST MAKE SURE THAT YOU GIVE EACH NEW PANEL THAT 
    // YOU DECLARE A PRIVATE VARIABLE THAT WILL STORE THE MAIN PANEL FROM GUI 
    private JPanel MainPanel;
    
    public LoginPanel()
    {
        initComponents();
    }
    
    /* THIS CONSTRUCTOR IS EXTREMELY IMPORTANT. WRITE A CONSTRUCTOR LIKE THIS
    FOR ALL OTHER PANELS
    
    This constructor takes in MainPanel from GUI.java which gives us access to
    the main panel where all of our GUI elements will eventually be located. */
    public LoginPanel(JPanel MainPanel)
    {
        this.MainPanel = MainPanel;
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

        UsernameField = new javax.swing.JTextField();
        PasswordField = new javax.swing.JTextField();
        CreateAccButton = new javax.swing.JButton();
        LoginButton = new javax.swing.JButton();

        UsernameField.setText("Username");
        UsernameField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UsernameFieldMouseClicked(evt);
            }
        });
        UsernameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsernameFieldActionPerformed(evt);
            }
        });

        PasswordField.setText("Password");
        PasswordField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PasswordFieldMouseClicked(evt);
            }
        });
        PasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordFieldActionPerformed(evt);
            }
        });

        CreateAccButton.setText("Create Account");
        CreateAccButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CreateAccButtonMouseClicked(evt);
            }
        });
        CreateAccButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateAccButtonActionPerformed(evt);
            }
        });

        LoginButton.setText("Login");
        LoginButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LoginButtonMouseClicked(evt);
            }
        });
        LoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(317, 317, 317)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(CreateAccButton)
                        .addGap(18, 18, 18)
                        .addComponent(LoginButton))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(UsernameField)
                        .addComponent(PasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(340, 340, 340))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(354, Short.MAX_VALUE)
                .addComponent(UsernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CreateAccButton)
                    .addComponent(LoginButton))
                .addGap(86, 86, 86))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void UsernameFieldActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_UsernameFieldActionPerformed
    {//GEN-HEADEREND:event_UsernameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsernameFieldActionPerformed

    private void PasswordFieldActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_PasswordFieldActionPerformed
    {//GEN-HEADEREND:event_PasswordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordFieldActionPerformed
    
    // Creates an event for the LoginButton that will fire any time the button
    // is clicked. This is just an example to get you started.
    private void LoginButtonMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_LoginButtonMouseClicked
    {//GEN-HEADEREND:event_LoginButtonMouseClicked
        // This line grabs the layout from MainPanel from the GUI class so that
        // we can show a new panel on it
        CardLayout layout = (CardLayout) (MainPanel.getLayout());
        // This will show the next panel when the button is clicked. Notice 
        // the parameters here. MainPanel is passed in, which is the panel from 
        // GUI.java with the CardLayout that our next panel will appear on,
        //  and "AccList" is the name of the panel that will be shown. 
        // "AccList" matches up to the name that we gave the AccountsListPanel
        // in GUI.java. Giving our instance of AccountsListPanel in GUI.java
        // this name and adding that object to MainPanel has allowed us 
        // to access and show that panel from outside of the class as long
        //  as we pass in MainPanel
        layout.show(MainPanel, "AccList");
        // This is an example of how we will access our HashTable from our 
        // other tables. Since it is declared static in GUI.java, we have access
        // to it everywhere.
        GUI.MasterTable.findUserAccount(UsernameField.getText());
    }//GEN-LAST:event_LoginButtonMouseClicked
        
    private void UsernameFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UsernameFieldMouseClicked
        UsernameField.setText("");
    }//GEN-LAST:event_UsernameFieldMouseClicked

    private void PasswordFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PasswordFieldMouseClicked
        PasswordField.setText("");
    }//GEN-LAST:event_PasswordFieldMouseClicked

    private void CreateAccButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreateAccButtonMouseClicked
        
        //retrieve MainPanel to transfer it's layout to CreateAccountPanel
        CardLayout layout = (CardLayout) (MainPanel.getLayout());
        
         //send the layout of MainPanel to new display of JPanel "CreateAcc"
        layout.show(MainPanel, "CreateAcc");
        
    }//GEN-LAST:event_CreateAccButtonMouseClicked

    private void CreateAccButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateAccButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CreateAccButtonActionPerformed

    private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LoginButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CreateAccButton;
    private javax.swing.JButton LoginButton;
    private javax.swing.JTextField PasswordField;
    private javax.swing.JTextField UsernameField;
    // End of variables declaration//GEN-END:variables
    
}
