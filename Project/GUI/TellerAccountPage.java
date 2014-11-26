/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import FacadeLayer.BackendWrapper;
import static GUI.AccountsListPanel.BALANCECOL;
import static GUI.AccountsListPanel.NAMECOL;

/**
 *
 * @author Zack
 */
public class TellerAccountPage extends javax.swing.JPanel
{

    private JPanel MainPanel;
    private GUI mainGUI;
    private BackendWrapper wrapper;
    private int total_accounts;
    private String[] accountlist;

    /**
     * Creates new form TellerAccountPage
     */
    public TellerAccountPage()
    {
        initComponents();
    }

    public TellerAccountPage(JPanel MainPanel, GUI mainGUI)
    {
        this.MainPanel = MainPanel;
        this.mainGUI = mainGUI;
        initComponents();
    }

    private int findRowPositionByName(String accountName)
    {
        int cRow = 0;
        int totalRows = AccountsTable.getRowCount();
        while (!accountName.equals(AccountsTable.getValueAt(cRow, NAMECOL))
                || cRow == totalRows)
        {
            cRow++;
        }
        return cRow;
    }

    public void setNewCellValue(double NewBalance, String accountName)
    {
        AccountsTable.setValueAt((Object) NewBalance,
                findRowPositionByName(accountName), BALANCECOL);
    }

    public void update()
    {
        AccountsTable.setModel(new TableModel(GUI.currentUserAccount));
        CurrentUserAccountLabel.setText(GUI.currentUserAccount.getUserName());
        mainGUI.updateUserLabels();
    }

    public void deletecomboboxes(String bankacc)
    {
        wrapper = new BackendWrapper(GUI.currentUserAccount);
        total_accounts = wrapper.getTotalAccounts();
        accountlist = new String[total_accounts - 1];
        boolean accountfound = false;
        for (int i = 0; i < total_accounts; i++)
        {
            if (accountfound == false)
            {
                if (wrapper.getAccountName(i).compareTo(bankacc) != 0)
                {
                    accountlist[i] = wrapper.getAccountName(i);
                }
                else
                    accountfound = true;
            }

            else
            {
                accountlist[i - 1] = wrapper.getAccountName(i);
            }
        }
    }

    public void updateUserLabel()
    {
        //CurrentUserAccountLabel.setText(GUI.currentUserAccount.getUserName());
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

        SettingsButton = new javax.swing.JButton();
        BankNamePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        CurrentUserAccountLabel = new javax.swing.JLabel();
        LogoutButtton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        AccountsTable = new javax.swing.JTable();
        DepositButton = new javax.swing.JButton();
        WithdrawButton = new javax.swing.JButton();
        DeleteUserAccountButton = new javax.swing.JButton();
        DeleteAccountButton = new javax.swing.JButton();

        SettingsButton.setText("Settings");
        SettingsButton.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                SettingsButtonMouseClicked(evt);
            }
        });

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

        CurrentUserAccountLabel.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        CurrentUserAccountLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CurrentUserAccountLabel.setText(GUI.currentBankAccount.getAccountName());

        LogoutButtton.setText("Logout");
        LogoutButtton.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                LogoutButttonMouseClicked(evt);
            }
        });

        AccountsTable.setSelectionModel(new ForcedListSelectionModel());
        AccountsTable.setAutoCreateRowSorter(true);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        AccountsTable.setDefaultRenderer(String.class, centerRenderer);
        AccountsTable.setDefaultRenderer(Double.class, centerRenderer);
        AccountsTable.setModel(new TableModel(GUI.currentUserAccount));
        AccountsTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(AccountsTable);

        DepositButton.setText("Deposit");
        DepositButton.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                DepositButtonMouseClicked(evt);
            }
        });

        WithdrawButton.setText("Withdraw");
        WithdrawButton.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                WithdrawButtonMouseClicked(evt);
            }
        });

        DeleteUserAccountButton.setText("Delete User Account");
        DeleteUserAccountButton.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                DeleteUserAccountButtonMouseClicked(evt);
            }
        });

        DeleteAccountButton.setText("Delete Highlighted Account");
        DeleteAccountButton.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                DeleteAccountButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(SettingsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BankNamePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(LogoutButtton, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(DepositButton))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(DeleteUserAccountButton))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(320, 320, 320)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CurrentUserAccountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(WithdrawButton)
                                .addGap(18, 18, 18)
                                .addComponent(DeleteAccountButton)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(BankNamePanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LogoutButtton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SettingsButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(CurrentUserAccountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DepositButton)
                    .addComponent(WithdrawButton)
                    .addComponent(DeleteAccountButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DeleteUserAccountButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    public static boolean isParsable(String input)
    {
        boolean parsable = true;
        try
        {
            Double.parseDouble(input);
        } catch (NumberFormatException e)
        {
            parsable = false;
        }
        return parsable;
    }

    private void DepositButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DepositButtonMouseClicked
        double amount;
        String amountstring = JOptionPane.showInputDialog(
                null, "Amount To Deposit: ");

        if (isParsable(amountstring))
        {
            amount = Double.parseDouble(amountstring);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please Enter a Valid number");
            return;
        }

        if (amount < 0)
        {
            JOptionPane.showMessageDialog(null, "Please Enter a Valid number");
            return;
        }

        //first, retrieve the row index of selection        
        int row = AccountsTable.getSelectedRow();
        String user = (String) AccountsTable.getValueAt(row, 1);
        System.out.print("\nTESTING retrieve selected row index: ");
        System.out.print(row);
        //next, retrieve the user account for the selection ( row , column0) = (x,y)
        System.out.print("\n Value at index: " + row + ", 0 is: " + user + "\n");

        //setting the current bank account
        GUI.currentBankAccount = GUI.currentUserAccount.findBankAccount(user);

        if (GUI.currentBankAccount == null)
        {
            JOptionPane.showMessageDialog(null, "Error! Bank Account Does Not Match");
            return;
        }
        // need to check if addToBalance returns true or false here
        if (GUI.currentBankAccount.addToBalance(amount))
        {
            setNewCellValue(GUI.currentBankAccount.getBalance(), GUI.currentBankAccount.getAccountName());
            System.out.println("\n GUI.currentBankAcc Name:  " + GUI.currentBankAccount.getAccountName() + "\n");

            JOptionPane.showMessageDialog(null, "$" + amount + " was deposited into "
                    + GUI.currentBankAccount.getAccountName());
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Error! You have either reached your daily limit, \n"
                    + "or are attempting to deposit too much.");
        }
    }//GEN-LAST:event_DepositButtonMouseClicked

    private void WithdrawButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_WithdrawButtonMouseClicked
        double amount;
        String amountstring = JOptionPane.showInputDialog(
                null, "Amount To Withdraw: ");

        if (isParsable(amountstring))
        {
            amount = Double.parseDouble(amountstring);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please Enter a Valid number");
            return;
        }

        if (amount < 0)
        {
            JOptionPane.showMessageDialog(null, "Please Enter a Valid number");
            return;
        }

        //first, retrieve the row index of selection        
        int row = AccountsTable.getSelectedRow();
        String user = (String) AccountsTable.getValueAt(row, 1);
        System.out.print("\nTESTING retrieve selected row index: ");
        System.out.print(row);
        //next, retrieve the user account for the selection ( row , column0) = (x,y)
        System.out.print("\n Value at index: " + row + ", 0 is: " + user + "\n");

        //setting the current bank account
        GUI.currentBankAccount = GUI.currentUserAccount.findBankAccount(user);

        if (GUI.currentBankAccount == null)
        {
            JOptionPane.showMessageDialog(null, "Error Bank Account Does Not Match");
            return;
        }

        if (amount > GUI.currentBankAccount.getBalance())
        {

            JOptionPane.showMessageDialog(null, "Insufficient Funds"
                    + "\nThere is $" + GUI.currentBankAccount.getBalance() + " available"
                    + " in selected Bank Account");
            return;
        }

        if (GUI.currentBankAccount.subFromBalance(amount))
        {
            setNewCellValue(GUI.currentBankAccount.getBalance(), GUI.currentBankAccount.getAccountName());
            JOptionPane.showMessageDialog(null, "$" + amount + " was withdrawn from "
                    + GUI.currentBankAccount.getAccountName());
        }

        else
        {
            JOptionPane.showMessageDialog(null, "Error! You have either reached your daily limit, \n"
                    + "or are attempting to withdraw too much.");
        }

        System.out.print("\n GUI.currentBankAcc Name:  " + GUI.currentBankAccount.getAccountName() + "\n");
        //GUI.currentBankAccount.addToBalance(amount        

    }//GEN-LAST:event_WithdrawButtonMouseClicked

    private void DeleteUserAccountButtonMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_DeleteUserAccountButtonMouseClicked
    {//GEN-HEADEREND:event_DeleteUserAccountButtonMouseClicked
        int n = JOptionPane.showConfirmDialog(
                null,
                "Are you sure you would like to delete this User Account?",
                "Bank 42",
                JOptionPane.YES_NO_OPTION);
        if (n == 0)
        {
            GUI.MasterTable.deleteUserAccount(GUI.currentUserAccount.getUserName());
            GUI.currentBankAccount = null;
            GUI.currentUserAccount = null;
            JOptionPane.showMessageDialog(null, "User Account Deleted");
            CardLayout layout = (CardLayout) (MainPanel.getLayout());
            layout.show(MainPanel, "TellerMainMenu");
        }
    }//GEN-LAST:event_DeleteUserAccountButtonMouseClicked

    private void DeleteAccountButtonMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_DeleteAccountButtonMouseClicked
    {//GEN-HEADEREND:event_DeleteAccountButtonMouseClicked
        if (AccountsTable.getSelectedRowCount() > 0)
        {
            if (GUI.currentUserAccount.getNumOfBankAccounts() == 1)
            {
                JOptionPane.showMessageDialog(null, "ERROR! You must have at least one bank account.\n"
                        + "You cannot delete this Bank Account without creating a new one first.");
                return;
            }

            String account_type;
            double amount_in_deleted_acc;
            String account_name;
            int row = AccountsTable.getSelectedRow();
            String bankacc = (String) AccountsTable.getValueAt(row, 1);

            GUI.currentBankAccount = GUI.currentUserAccount.findBankAccount(bankacc);
            amount_in_deleted_acc = GUI.currentBankAccount.getBalance();
            account_type = GUI.currentBankAccount.getAccountType();
            account_name = GUI.currentBankAccount.getAccountName();

            if (amount_in_deleted_acc == 0)
            {
                JOptionPane.showMessageDialog(null, bankacc + " has been Deleted");
                GUI.currentUserAccount.deleteBankAccount(bankacc);
                this.update();
                return;
            }

            Object[] options =
            {
                "To another Bank Account",
                "Email Funds"
            };
            int n = JOptionPane.showOptionDialog(null,
                    "You have $" + amount_in_deleted_acc + " in account " + account_name
                    + "\nWhere would you like the funds to go?",
                    "Where to Transfer Funds",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null, //do not use a custom icon
                    options, //the titles of buttons
                    options[0]); //default button title

            deletecomboboxes(bankacc);

            if (n == 0)
            {
                String choice = (String) JOptionPane.showInputDialog(
                        null,
                        "Choose a Bank Account",
                        "",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        accountlist,
                        null);

                if (null == choice)
                {
                    return;
                }

                GUI.currentUserAccount.deleteBankAccount(bankacc);

                GUI.currentBankAccount = GUI.currentUserAccount.findBankAccount(choice);
                GUI.currentBankAccount.addToBalance(amount_in_deleted_acc);
                this.update();

                JOptionPane.showMessageDialog(null, "Bank Account " + bankacc
                        + " has been Deleted" + "\nFunds have been transfered to " + choice);
            }

            else if (n == 1)
            {
                GUI.currentUserAccount.deleteBankAccount(bankacc);
                this.update();

                JOptionPane.showMessageDialog(null, "Bank Account " + bankacc
                        + " has been Deleted" + "\nFunds have been emailed to " + GUI.currentUserAccount.getEmail());
            }
        }
        else
            JOptionPane.showMessageDialog(null, "Please Select an Account");
    }//GEN-LAST:event_DeleteAccountButtonMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable AccountsTable;
    private javax.swing.JPanel BankNamePanel;
    private javax.swing.JLabel CurrentUserAccountLabel;
    private javax.swing.JButton DeleteAccountButton;
    private javax.swing.JButton DeleteUserAccountButton;
    private javax.swing.JButton DepositButton;
    private javax.swing.JButton LogoutButtton;
    private javax.swing.JButton SettingsButton;
    private javax.swing.JButton WithdrawButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
