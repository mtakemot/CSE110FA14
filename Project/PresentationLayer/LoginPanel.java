package PresentationLayer;

/**
 * **************************************************************************
 *
 * Michio Takemoto CSE 110, Fall 2014 Last Updated: November 3, 2014
 *
 * Team 42
 *
 * File Name: LoginPanel.java Description: This class will define what our Login
 * Page will look like and how it will behave.
 * **************************************************************************
 */
import javax.swing.*;
import java.awt.*;
import java.awt.font.TextAttribute;
import java.io.File;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Timer;
import java.util.TimerTask;

public class LoginPanel extends javax.swing.JPanel
{

    // VERY IMPORTANT !! YOU MUST MAKE SURE THAT YOU GIVE EACH NEW PANEL THAT
    // YOU DECLARE A PRIVATE VARIABLE THAT WILL STORE THE MAIN PANEL FROM GUI
    private JPanel MainPanel;
    private GUI mainGUI;
    private static final String USERNAME_PATTERN = "^[a-z0-9_-]{1,15}$";
    private static int numberOfAttempts;
    private static int numberOfLoginAttempts;
    private static int interval;
    private static Timer timer;
    private ImageIcon icon;
    private Font thefont;

    public LoginPanel()
    {
        initComponents();
    }

    /* THIS CONSTRUCTOR IS EXTREMELY IMPORTANT. WRITE A CONSTRUCTOR LIKE THIS
     FOR ALL OTHER PANELS

     This constructor takes in MainPanel from GUI.java which gives us access to
     the main panel where all of our GUI elements will eventually be located. */
    public LoginPanel(JPanel MainPanel, GUI mainGUI)
    {
        icon = new javax.swing.ImageIcon(getClass().getResource("/Assets/rsz_2icon.png"));
        this.mainGUI = mainGUI;
        this.MainPanel = MainPanel;
        initComponents();
    }

    /*@Override
     protected void paintComponent(Graphics g)
     {
     super.paintComponent(g);
     if (image != null)
     g.drawImage(image, 0,0,this.getWidth(),this.getHeight(),this);
     }*/
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

        jPanel1 = new javax.swing.JPanel();
        LoginButton = new javax.swing.JButton();
        CreateAccButton = new javax.swing.JButton();
        jPasswordField = new javax.swing.JPasswordField();
        UsernameField = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        UsernameLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        PasswordLabel = new javax.swing.JLabel();
        noAccess = new javax.swing.JLabel();
        ForgotPassword = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();

        setToolTipText(null);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        setLayout(new java.awt.GridBagLayout());

        jPanel1.setBackground(new Color(255,255,255,150));
        jPanel1.setMinimumSize(new java.awt.Dimension(375, 185));
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(375, 185));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        LoginButton.setBackground(new java.awt.Color(255, 255, 255));
        LoginButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        LoginButton.setForeground(new java.awt.Color(14, 118, 188));
        LoginButton.setText("Login");
        LoginButton.setMaximumSize(new java.awt.Dimension(130, 25));
        LoginButton.setMinimumSize(new java.awt.Dimension(130, 25));
        LoginButton.setPreferredSize(new java.awt.Dimension(130, 25));
        LoginButton.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                LoginButtonMouseClicked(evt);
            }
        });
        LoginButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                LoginButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        jPanel1.add(LoginButton, gridBagConstraints);

        CreateAccButton.setBackground(new java.awt.Color(255, 255, 255));
        CreateAccButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        CreateAccButton.setForeground(new java.awt.Color(14, 118, 188));
        CreateAccButton.setText("Create Account");
        CreateAccButton.setMaximumSize(new java.awt.Dimension(130, 25));
        CreateAccButton.setMinimumSize(new java.awt.Dimension(130, 25));
        CreateAccButton.setPreferredSize(new java.awt.Dimension(130, 25));
        CreateAccButton.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                CreateAccButtonMouseClicked(evt);
            }
        });
        CreateAccButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                CreateAccButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        jPanel1.add(CreateAccButton, gridBagConstraints);

        jPasswordField.setBackground(new Color(255,255,255,150));
        jPasswordField.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 3, 0, 0));
        jPasswordField.setMinimumSize(new java.awt.Dimension(275, 25));
        jPasswordField.setPreferredSize(new java.awt.Dimension(275, 25));
        jPasswordField.addFocusListener(new java.awt.event.FocusAdapter()
        {
            public void focusGained(java.awt.event.FocusEvent evt)
            {
                jPasswordFieldFocusGained(evt);
            }
        });
        jPasswordField.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jPasswordFieldActionPerformed(evt);
            }
        });
        jPasswordField.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                jPasswordFieldKeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        jPanel1.add(jPasswordField, gridBagConstraints);

        UsernameField.setBackground(new Color(255,255,255,150));
        UsernameField.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 3, 0, 0));
        UsernameField.setDisabledTextColor(new Color(255,255,255,150));
        UsernameField.setMinimumSize(new java.awt.Dimension(275, 25));
        UsernameField.setPreferredSize(new java.awt.Dimension(275, 25));
        UsernameField.addFocusListener(new java.awt.event.FocusAdapter()
        {
            public void focusGained(java.awt.event.FocusEvent evt)
            {
                UsernameFieldFocusGained(evt);
            }
        });
        UsernameField.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                UsernameFieldActionPerformed(evt);
            }
        });
        UsernameField.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                UsernameFieldKeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 15;
        jPanel1.add(UsernameField, gridBagConstraints);

        jPanel2.setBackground(new java.awt.Color(250, 250, 250));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setMinimumSize(new java.awt.Dimension(90, 20));
        jPanel2.setPreferredSize(new java.awt.Dimension(90, 20));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        UsernameLabel.setBackground(new Color ( 255,255,255,150));
        UsernameLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        UsernameLabel.setForeground(new java.awt.Color(14, 118, 188));
        UsernameLabel.setText("Username:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel2.add(UsernameLabel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        jPanel1.add(jPanel2, gridBagConstraints);

        jPanel3.setBackground(new java.awt.Color(250, 250, 250));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setMinimumSize(new java.awt.Dimension(90, 20));
        jPanel3.setPreferredSize(new java.awt.Dimension(90, 20));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        PasswordLabel.setBackground(new Color(255,255,255,200));
        PasswordLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        PasswordLabel.setForeground(new java.awt.Color(14, 118, 188));
        PasswordLabel.setText("Password:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel3.add(PasswordLabel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 5);
        jPanel1.add(jPanel3, gridBagConstraints);

        noAccess.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        noAccess.setForeground(new java.awt.Color(255, 0, 0));
        noAccess.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        jPanel1.add(noAccess, gridBagConstraints);

        ForgotPassword.setForeground(new java.awt.Color(14, 118, 188));
        ForgotPassword.setText("Forgot Password?");
        ForgotPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ForgotPassword.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                ForgotPasswordMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                ForgotPasswordMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                ForgotPasswordMouseExited(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        jPanel1.add(ForgotPassword, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(300, 0, 0, 0);
        add(jPanel1, gridBagConstraints);

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/rsz_142galaxy Cropped.png"))); // NOI18N
        Background.setToolTipText(null);
        Background.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Background.setFocusable(false);
        Background.setInheritsPopupMenu(false);
        Background.setRequestFocusEnabled(false);
        Background.setVerifyInputWhenFocusTarget(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(Background, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void Login()
    {
        String username = UsernameField.getText();
        char[] passwordarray = jPasswordField.getPassword();
        String password = new String(passwordarray);

        
        if ((username.equals("teller")) && (password.equals("teller")))
        {
            CardLayout layout = (CardLayout) (MainPanel.getLayout());
            layout.show(MainPanel, "TellerMainMenu");
            UsernameField.setText(null);
            jPasswordField.setText(null);
            return;
        }

        GUI.currentUserAccount = GUI.MasterTable.findUserAccount(UsernameField.getText());

        numberOfLoginAttempts++;
        if (GUI.currentUserAccount == null)
        {   
            if (numberOfLoginAttempts == 3)
            {
                JOptionPane.showMessageDialog(this, "You've exceeded the number of attempts. Please try again later.", "Bank 42", 1, icon);
                exceededAttempts();
                return;
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Account Not found!", "Bank 42",
                    JOptionPane.INFORMATION_MESSAGE, icon);
            }
        }
        else
        {          
            if (password.compareTo(GUI.currentUserAccount.getPassword()) == 0)
            {
                mainGUI.getAccList().update();
                mainGUI.getSettings().update();
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
                UsernameField.setText(null);
                jPasswordField.setText(null);
                layout.show(MainPanel, "AccList");
                
                 noAccess.setText(" ");
                 noAccess.setVisible(false);
                 numberOfAttempts = 0;
                 numberOfLoginAttempts = 0;
            }
            else
            {
                if (numberOfLoginAttempts == 3)
                {
                    JOptionPane.showMessageDialog(this, "You've exceeded the number of attempts. Please try again later.", "Bank 42", 1, icon);
                    exceededAttempts();
                    return;
                }
                
                //call error thing here
                JOptionPane.showMessageDialog(null, "Invalid Username Password Combination", "Bank 42", 1, icon);
            }
            //move the following code in here, for demoing and when we're done testing.
        }
    }

    // Creates an event for the LoginButton that will fire any time the button
    // is clicked. This is just an example to get you started.
    private void LoginButtonMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_LoginButtonMouseClicked
    {//GEN-HEADEREND:event_LoginButtonMouseClicked
        Login();
    }//GEN-LAST:event_LoginButtonMouseClicked

    private void CreateAccButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreateAccButtonMouseClicked

        UsernameField.setText(null);
        jPasswordField.setText(null);
        //retrieve MainPanel to transfer it's layout to CreateAccountPanel
        CardLayout layout = (CardLayout) (MainPanel.getLayout());

        //send the layout of MainPanel to new display of JPanel "CreateAcc"
        layout.show(MainPanel, "CreateAcc");

    }//GEN-LAST:event_CreateAccButtonMouseClicked

    private void UsernameFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_UsernameFieldFocusGained
        UsernameField.setText("");
    }//GEN-LAST:event_UsernameFieldFocusGained

    private void UsernameFieldKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_UsernameFieldKeyPressed
    {//GEN-HEADEREND:event_UsernameFieldKeyPressed
        int key = evt.getKeyCode();
        if (key == java.awt.event.KeyEvent.VK_ENTER)
        {
            Login();
        }
    }//GEN-LAST:event_UsernameFieldKeyPressed

    private void jPasswordFieldKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_jPasswordFieldKeyPressed
    {//GEN-HEADEREND:event_jPasswordFieldKeyPressed
        int key = evt.getKeyCode();
        if (key == java.awt.event.KeyEvent.VK_ENTER)
        {
            Login();
        }
    }//GEN-LAST:event_jPasswordFieldKeyPressed

    private void jPasswordFieldFocusGained(java.awt.event.FocusEvent evt)//GEN-FIRST:event_jPasswordFieldFocusGained
    {//GEN-HEADEREND:event_jPasswordFieldFocusGained
        jPasswordField.setText("");
    }//GEN-LAST:event_jPasswordFieldFocusGained

    private void UsernameFieldActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_UsernameFieldActionPerformed
    {//GEN-HEADEREND:event_UsernameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsernameFieldActionPerformed

    private void jPasswordFieldActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jPasswordFieldActionPerformed
    {//GEN-HEADEREND:event_jPasswordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordFieldActionPerformed

    private void exceededAttempts()
    {
        int delay = 1000;
        int period = 1000;
        timer = new Timer();
        interval = 5;

        timer.scheduleAtFixedRate(new TimerTask()
        {

            public void run()
            {
                noAccess.setVisible(true);
                noAccess.setText("Time Remaining: " + Integer.toString(setInterval() + 1));
            }
        }, delay, period);

    }

    private int setInterval()
    {
        if (interval == 0)
        {
            noAccess.setText(" ");
            noAccess.setVisible(false);
            numberOfAttempts = 0;
            numberOfLoginAttempts = 0;
            timer.cancel();
            ForgotPassword.setEnabled(true);
        }
        return --interval;
    }

    private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LoginButtonActionPerformed

    private void ForgotPasswordMouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_ForgotPasswordMouseEntered
    {//GEN-HEADEREND:event_ForgotPasswordMouseEntered
        thefont = ForgotPassword.getFont();
        Font font = ForgotPassword.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        ForgotPassword.setFont(font.deriveFont(attributes));
    }//GEN-LAST:event_ForgotPasswordMouseEntered

    private void ForgotPasswordMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_ForgotPasswordMouseExited
    {//GEN-HEADEREND:event_ForgotPasswordMouseExited
        ForgotPassword.setFont(thefont);
    }//GEN-LAST:event_ForgotPasswordMouseExited

    private void ForgotPasswordMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_ForgotPasswordMouseClicked
    {//GEN-HEADEREND:event_ForgotPasswordMouseClicked
  
        numberOfAttempts++;
        
        if (numberOfAttempts == 4)
        {
            JOptionPane.showMessageDialog(this, "You've exceeded the number of attempts. Please try again later.", "Bank 42", 1, icon);
            ForgotPassword.setEnabled(false);
            exceededAttempts();
        }
        
        String response = JOptionPane.showInputDialog(null, "Enter your email (Attempt " + numberOfAttempts + " of 3): ", "Bank 42", 1);

        if (response == null)
            return;

        response = response.trim();
        if ((response.length() > 0) && CreateAccountPanel.isValidEmailAddress(response))
        {
            if (response.equals(GUI.currentUserAccount.getEmail()))
            {
                String newPassword = JOptionPane.showInputDialog(null, "Enter your new password: ", "Bank 42", 1);

                if (newPassword == null)
                    return;

                newPassword = newPassword.trim();
                if ((newPassword.length() > 0) && CreateAccountPanel.validatePassword(newPassword))
                {
                    GUI.currentUserAccount.setPassword(newPassword);
                    GUI.dataout.exportDB(GUI.MasterTable);
                }
            }

        }
        else
        {
            boolean exceededAttempt = false;
            
            if (numberOfAttempts == 3)
            {
                JOptionPane.showMessageDialog(this, "You've exceeded the number of attempts. Please try again later.", "Bank 42", 1, icon);
                ForgotPassword.setEnabled(false);
                exceededAttempt = true;
                exceededAttempts();
            }
            
            if(exceededAttempt == false)
            {
              JOptionPane.showMessageDialog(this, "Incorrect email, please try again.", "Bank 42", 1, icon);            
              return;
            }
        }
    }//GEN-LAST:event_ForgotPasswordMouseClicked

    private void CreateAccButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateAccButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CreateAccButtonActionPerformed

    public boolean validate(final String username)
    {

        Pattern pattern = Pattern.compile(USERNAME_PATTERN);
        Matcher matcher = pattern.matcher(username);

        if (matcher.matches() == false)
            JOptionPane.showMessageDialog(null, "Your username contains illegal characters!", "Error!",
                    JOptionPane.INFORMATION_MESSAGE);
        return matcher.matches();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JButton CreateAccButton;
    private javax.swing.JLabel ForgotPassword;
    private javax.swing.JButton LoginButton;
    private javax.swing.JLabel PasswordLabel;
    private javax.swing.JTextField UsernameField;
    private javax.swing.JLabel UsernameLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JLabel noAccess;
    // End of variables declaration//GEN-END:variables

}
