/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import FacadeLayer.UserAccountWrapper;
import static PresentationLayer.AccountsListPanel.BALANCECOL;
import static PresentationLayer.AccountsListPanel.NAMECOL;

/**
 *
 * @author Zack
 */
public class TellerAccountPage extends javax.swing.JPanel
{

    private JPanel MainPanel;
    private GUI mainGUI;
    private UserAccountWrapper wrapper;
    private int total_accounts;
    private String[] accountlist;
    private DefaultListSelectionModel SelectionModel;

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

        AccountsTable.setModel(new AccountsTableModel(GUI.currentUserAccount));
        SelectionModel.clearSelection();
        CurrentUserAccountLabel.setText(GUI.currentUserAccount.getUserName() + "'s Bank Accounts");
        mainGUI.updateUserLabels();
    }

    public void deletecomboboxes(String bankacc)
    {
        wrapper = new UserAccountWrapper(GUI.currentUserAccount);
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
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        Holder = new javax.swing.JPanel();
        MainComponentsPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        AccountsTable = new javax.swing.JTable();
        CurrentUserAccountLabel = new javax.swing.JLabel();
        DepositButton = new javax.swing.JButton();
        WithdrawButton = new javax.swing.JButton();
        DeleteUserAccountButton = new javax.swing.JButton();
        DeleteAccountButton = new javax.swing.JButton();
        BackButton = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        setLayout(new java.awt.GridBagLayout());

        Holder.setLayout(new java.awt.GridBagLayout());

        MainComponentsPanel.setLayout(new java.awt.GridBagLayout());

        jScrollPane1.setPreferredSize(new java.awt.Dimension(454, 300));

        AccountsTable.setSelectionModel(SelectionModel = new DefaultListSelectionModel());
        SelectionModel.setSelectionMode(0);
        AccountsTable.setAutoCreateRowSorter(true);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        AccountsTable.setDefaultRenderer(String.class, centerRenderer);
        AccountsTable.setDefaultRenderer(Double.class, centerRenderer);
        AccountsTable.setBackground(new Color (255,255,255,150));
        AccountsTable.setModel(new PresentationLayer.AccountsTableModel(PresentationLayer.GUI.currentUserAccount));
        AccountsTable.getTableHeader().setResizingAllowed(false);
        AccountsTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(AccountsTable);
        AccountsTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        MainComponentsPanel.add(jScrollPane1, gridBagConstraints);

        CurrentUserAccountLabel.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        CurrentUserAccountLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CurrentUserAccountLabel.setText(GUI.currentUserAccount.getUserName() + "'s Bank Accounts");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 100, 0);
        MainComponentsPanel.add(CurrentUserAccountLabel, gridBagConstraints);

        DepositButton.setBackground(new Color (255,255,255,150));
        DepositButton.setText("Deposit");
        DepositButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DepositButtonMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        MainComponentsPanel.add(DepositButton, gridBagConstraints);

        WithdrawButton.setBackground(new Color (255,255,255,150));
        WithdrawButton.setText("Withdraw");
        WithdrawButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                WithdrawButtonMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 201, 10, 0);
        MainComponentsPanel.add(WithdrawButton, gridBagConstraints);

        DeleteUserAccountButton.setBackground(new Color (255,255,255,150));
        DeleteUserAccountButton.setText("Delete This User Account");
        DeleteUserAccountButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeleteUserAccountButtonMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        MainComponentsPanel.add(DeleteUserAccountButton, gridBagConstraints);

        DeleteAccountButton.setBackground(new Color (255,255,255,150));
        DeleteAccountButton.setText("Delete Highlighted Bank Account");
        DeleteAccountButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeleteAccountButtonMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        MainComponentsPanel.add(DeleteAccountButton, gridBagConstraints);

        BackButton.setBackground(new Color (255,255,255,150));
        BackButton.setText("Back");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        MainComponentsPanel.add(BackButton, gridBagConstraints);

        Holder.add(MainComponentsPanel, new java.awt.GridBagConstraints());

        add(Holder, new java.awt.GridBagConstraints());
    }// </editor-fold>//GEN-END:initComponents

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
        if (amountstring == null)
            return;
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
        String user = (String) AccountsTable.getValueAt(row, 0);
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
        if (amountstring == null)
            return;
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
        String user = (String) AccountsTable.getValueAt(row, 0);
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
            String bankacc = (String) AccountsTable.getValueAt(row, 0);

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

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_BackButtonActionPerformed
    {//GEN-HEADEREND:event_BackButtonActionPerformed
        CardLayout layout = (CardLayout) (MainPanel.getLayout());
        layout.show(MainPanel, "TellerMainMenu");
    }//GEN-LAST:event_BackButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable AccountsTable;
    private javax.swing.JButton BackButton;
    private javax.swing.JLabel CurrentUserAccountLabel;
    private javax.swing.JButton DeleteAccountButton;
    private javax.swing.JButton DeleteUserAccountButton;
    private javax.swing.JButton DepositButton;
    private javax.swing.JPanel Holder;
    private javax.swing.JPanel MainComponentsPanel;
    private javax.swing.JButton WithdrawButton;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
