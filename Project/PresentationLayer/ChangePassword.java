/*
 * Team 42
 * CSE 110, Fall 2014
 *  
 * Author(s):Zachary Preece-Scaringe
 * 
 * Summary:Panel which will be shown via popup when a user wants to change his
 * password. Panel will handle input, verification, and setting the new password.
 */

package PresentationLayer;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class ChangePassword extends javax.swing.JPanel
{

    /**
     * Creates new form ChangePassword
     */
    private JPanel MainPanel;
    private GUI mainGUI;
    private ImageIcon icon;

    public ChangePassword()
    {
        initComponents();
    }
    
    /**
     * Constructor
     * @param MainPanel the main Jpanel 
     * @param mainGUI main GUI.java generated object contains other panels. 
     */
    public ChangePassword(JPanel MainPanel, GUI mainGUI)
    {
        this.MainPanel = MainPanel;
        this.mainGUI = mainGUI;
        initComponents();
    }
    
    /**
     * parent's GetPanel() getter function. Returns a JPanel
     * @return JPanel
     */
    public javax.swing.JPanel GetPanel()
    {
        return this;
    }

    /**
     * sets password for the account.
     * @return true if successful, otherwise false
     */
    public boolean SetPassword()
    {
        //gets old and new passwords from its jpassword fields and sets the new
        //if old password matches, and new passwords are valid, and the same.
        
        //get the password as an array and convert it to a string
        char[] passwordArray = jCurrentPassword.getPassword();
        String current_password = new String(passwordArray);

        //check for matching password
        if (current_password.equals(GUI.currentUserAccount.getPassword()))
        {
            //store new passwords
            passwordArray = jNewPassword.getPassword();
            String new_password = new String(passwordArray);
            
            passwordArray = jReenterNewPassword.getPassword();
            String reenter_new_password = new String(passwordArray);
            
            if (new_password.equals(reenter_new_password))
            {
                //set password, if it is valid, reset password fields
                if (CreateAccountPanel.validatePassword(new_password) && (new_password.length() >= 6 && new_password.length() <= 20))
                {
                    //set password
                    GUI.currentUserAccount.setPassword(new_password);
                    
                    //success popup
                    JOptionPane.showMessageDialog(null, "Password succesfully changed!", "Bank 42", 1, GUI.icon);
                    
                    //reset password fields
                    jCurrentPassword.setText("passw");
                    jNewPassword.setText("passw");
                    jReenterNewPassword.setText("passw");
                    
                    //export data to database
                    GUI.dataout.exportDB(GUI.MasterTable);
                    return true;
                }
                else
                {
                    //if pass isnt valid, output error messages, reset pass fields
                    JOptionPane.showMessageDialog(null, "The password must have 6-20 characters, at least one uppercase letter and one lowercase letter", "Bank 42", 1, GUI.icon);
                    jCurrentPassword.setText("passw");
                    jNewPassword.setText("passw");
                    jReenterNewPassword.setText("passw");
                }
            }
            //error statements
            else
            {
                JOptionPane.showMessageDialog(null, "New passwords do not match, please try again.", "Bank 42", 1, GUI.icon);
                jCurrentPassword.setText("passw");
                jNewPassword.setText("passw");
                jReenterNewPassword.setText("passw");
            }

        }
        //mismatched password entry
        else
        {
            JOptionPane.showMessageDialog(null, "New passwords do not match, please try again.", "Bank 42", 1, GUI.icon);

        }
        return false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {
        java.awt.GridBagConstraints gridBagConstraints;

        CurrentPassword = new javax.swing.JLabel();
        jCurrentPassword = new javax.swing.JPasswordField();
        NewPassword = new javax.swing.JLabel();
        jNewPassword = new javax.swing.JPasswordField();
        ReenterNewPassword = new javax.swing.JLabel();
        jReenterNewPassword = new javax.swing.JPasswordField();

        setMaximumSize(new java.awt.Dimension(225, 100));
        setMinimumSize(new java.awt.Dimension(225, 100));
        setPreferredSize(new java.awt.Dimension(225, 100));
        setLayout(new java.awt.GridBagLayout());

        CurrentPassword.setText("Current Password:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(73, 9, 0, 0);
        add(CurrentPassword, gridBagConstraints);

        jCurrentPassword.setText("passw");
        jCurrentPassword.addFocusListener(new java.awt.event.FocusAdapter()
        {
            public void focusGained(java.awt.event.FocusEvent evt)
            {
                jCurrentPasswordFocusGained(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 56;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(70, 0, 0, 9);
        add(jCurrentPassword, gridBagConstraints);

        NewPassword.setText("New Password:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 9, 0, 0);
        add(NewPassword, gridBagConstraints);

        jNewPassword.setText("passw");
        jNewPassword.addFocusListener(new java.awt.event.FocusAdapter()
        {
            public void focusGained(java.awt.event.FocusEvent evt)
            {
                jNewPasswordFocusGained(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 56;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 9);
        add(jNewPassword, gridBagConstraints);

        ReenterNewPassword.setText("Re-enter New Password:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 9, 0, 0);
        add(ReenterNewPassword, gridBagConstraints);

        jReenterNewPassword.setText("passw");
        jReenterNewPassword.addFocusListener(new java.awt.event.FocusAdapter()
        {
            public void focusGained(java.awt.event.FocusEvent evt)
            {
                jReenterNewPasswordFocusGained(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 56;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 70, 9);
        add(jReenterNewPassword, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void jCurrentPasswordFocusGained(java.awt.event.FocusEvent evt)//GEN-FIRST:event_jCurrentPasswordFocusGained
    {//GEN-HEADEREND:event_jCurrentPasswordFocusGained
        jCurrentPassword.setText("");
    }//GEN-LAST:event_jCurrentPasswordFocusGained

    private void jNewPasswordFocusGained(java.awt.event.FocusEvent evt)//GEN-FIRST:event_jNewPasswordFocusGained
    {//GEN-HEADEREND:event_jNewPasswordFocusGained
        jNewPassword.setText("");
    }//GEN-LAST:event_jNewPasswordFocusGained

    private void jReenterNewPasswordFocusGained(java.awt.event.FocusEvent evt)//GEN-FIRST:event_jReenterNewPasswordFocusGained
    {//GEN-HEADEREND:event_jReenterNewPasswordFocusGained
        jReenterNewPassword.setText("");
    }//GEN-LAST:event_jReenterNewPasswordFocusGained

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CurrentPassword;
    private javax.swing.JLabel NewPassword;
    private javax.swing.JLabel ReenterNewPassword;
    private javax.swing.JPasswordField jCurrentPassword;
    private javax.swing.JPasswordField jNewPassword;
    private javax.swing.JPasswordField jReenterNewPassword;
    // End of variables declaration//GEN-END:variables
}
