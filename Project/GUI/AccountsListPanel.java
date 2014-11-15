package GUI;

/**
 * **************************************************************************
 *
 * Ryan Bridges CSE 110, Fall 2014 Last Updated: October 30, 2014
 *
 * Team 42
 *
 * File Name: AccountsListPanel.java Description: This class will define what
 * our Login Page will look like and how it will behave. THIS CLASS IS JUST A
 * PLACEHOLDER RIGHT NOW AND DOES NOT DO ANYTHING YET OTHER THAN DISPLAY A
 * MESSAGE TELLING US WHICH PANEL IT IS SUPPOSED TO BE.
 * **************************************************************************
 */
import javax.swing.*;
import java.awt.*;

//for debug
//import java.io.*;
public class AccountsListPanel extends javax.swing.JPanel
{

    // VERY IMPORTANT !! YOU MUST MAKE SURE THAT YOU GIVE EACH NEW PANEL THAT 
    // YOU DECLARE A PRIVATE VARIABLE THAT WILL STORE THE MAIN PANEL FROM GUI 
    private JPanel MainPanel;

    public AccountsListPanel()
    {
        initComponents();
    }

    /* THIS CONSTRUCTOR IS EXTREMELY IMPORTANT. WRITE A CONSTRUCTOR LIKE THIS
     FOR ALL OTHER PANELS
    
     This constructor takes in MainPanel from GUI.java which gives us access to
     the main panel where all of our GUI elements will eventually be located. */
    public AccountsListPanel(JPanel MainPanel)
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

        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        Settings = new javax.swing.JButton();
        Logout = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        AccountsTable = new javax.swing.JTable();
        GoToAcc = new javax.swing.JButton();
        TransferFundsButton = new javax.swing.JButton();
        DeleteAccountButton = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setOpaque(false);

        jLabel5.setFont(new java.awt.Font("DejaVu Sans", 1, 24)); // NOI18N
        jLabel5.setText("Bank 42");

        Settings.setText("Settings");
        Settings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SettingsMouseClicked(evt);
            }
        });

        Logout.setText("Logout");
        Logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogoutMouseClicked(evt);
            }
        });

        AccountsTable.setAutoCreateRowSorter(true);
        AccountsTable.setModel(new TableModel(GUI.currentUserAccount));
        AccountsTable.setColumnSelectionAllowed(false);
        AccountsTable.getTableHeader().setResizingAllowed(false);
        AccountsTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(AccountsTable);
        AccountsTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        GoToAcc.setText("Go to Account");
        GoToAcc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GoToAccMouseClicked(evt);
            }
        });
        GoToAcc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GoToAccActionPerformed(evt);
            }
        });

        TransferFundsButton.setText("Transfer Funds");
        TransferFundsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TransferFundsButtonMouseClicked(evt);
            }
        });

        DeleteAccountButton.setText("Delete Highlighted Account");
        DeleteAccountButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeleteAccountButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Settings)
                                .addGap(203, 203, 203)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 223, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(Logout))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(275, 275, 275)
                                .addComponent(GoToAcc))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(103, 103, 103)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addComponent(TransferFundsButton)
                .addGap(88, 88, 88)
                .addComponent(DeleteAccountButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Settings)
                    .addComponent(Logout))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TransferFundsButton)
                    .addComponent(DeleteAccountButton))
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(GoToAcc)
                .addContainerGap(240, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void LogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutMouseClicked
        //retrieve MainPanel to transfer it's layout to AccountListPanel
        CardLayout layout = (CardLayout) (MainPanel.getLayout());

        //send the layout of MainPanel to new display of JPanel "Login"
        layout.show(MainPanel, "Login");
    }//GEN-LAST:event_LogoutMouseClicked

    private void SettingsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SettingsMouseClicked
        CardLayout layout = (CardLayout) (MainPanel.getLayout());

        layout.show(MainPanel, "Settings");
    }//GEN-LAST:event_SettingsMouseClicked

    private void GoToAccMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GoToAccMouseClicked
              
        if (AccountsTable.getSelectedRowCount() > 0)
        {
            //first, retrieve the row index of selection        
            int row = AccountsTable.getSelectedRow();
            String user = (String) AccountsTable.getValueAt(row, 0);
            System.out.print("\nTESTING retrieve selected row index: ");
            System.out.print(row);
            //next, retrieve the user account for the selection ( row , column0) = (x,y)
            System.out.print("\n Value at index: " + row + ", 0 is: " + user + "\n");

            //setting the current bank account
            GUI.currentBankAccount = GUI.currentUserAccount.findBankAccount(user);

            System.out.print("\n GUI.currentBankAcc Name:  " + GUI.currentBankAccount.getAccountName() + "\n");

            CardLayout layout = (CardLayout) (MainPanel.getLayout());
            layout.show(MainPanel, "MainMenu");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please select an account to access!", "Error", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_GoToAccMouseClicked

    private void GoToAccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GoToAccActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GoToAccActionPerformed

    private void TransferFundsButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TransferFundsButtonMouseClicked
        CardLayout layout = (CardLayout) (MainPanel.getLayout());
        layout.show(MainPanel,"Transfer");
        
    }//GEN-LAST:event_TransferFundsButtonMouseClicked

    private void DeleteAccountButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteAccountButtonMouseClicked
        int row = AccountsTable.getSelectedRow();
        String user = (String) AccountsTable.getValueAt(row, 0);
        GUI.currentBankAccount = GUI.currentUserAccount.findBankAccount(user);
        //GUI.currentBankAccount.
    }//GEN-LAST:event_DeleteAccountButtonMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable AccountsTable;
    private javax.swing.JButton DeleteAccountButton;
    private javax.swing.JButton GoToAcc;
    private javax.swing.JButton Logout;
    private javax.swing.JButton Settings;
    private javax.swing.JButton TransferFundsButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
