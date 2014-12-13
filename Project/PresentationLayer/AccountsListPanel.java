package PresentationLayer;

/**
 * **************************************************************************
 *
 * Ryan Bridges CSE 110, Fall 2014 Last Updated: October 12, 2014
 *
 * Team 42
 *
 * File Name: AccountsListPanel.java Description: This class will define what
 * our Login Page will look like and how it will behave. THIS CLASS IS JUST A
 * PLACEHOLDER RIGHT NOW AND DOES NOT DO ANYTHING YET OTHER THAN DISPLAY A
 * MESSAGE TELLING US WHICH PANEL IT IS SUPPOSED TO BE.
 * **************************************************************************
 */
import FacadeLayer.UserAccountWrapper;
import java.awt.CardLayout;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import LogicLayer.UserAccount;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import org.joda.time.DateTime;

//for debug
//import java.io.*;
public class AccountsListPanel extends javax.swing.JPanel
{
    //Column # positions of Tables
    final static int NAMECOL = 0;
    final static int BALANCECOL = 2;
    // VERY IMPORTANT !! YOU MUST MAKE SURE THAT YOU GIVE EACH NEW PANEL THAT
    // YOU DECLARE A PRIVATE VARIABLE THAT WILL STORE THE MAIN PANEL FROM GUI
    private JPanel MainPanel;
    private GUI mainGUI;
    // Reference to the FacadeLayer so that we have access to the backend in
    // a format that we can use
    private UserAccountWrapper wrapper;
    private int total_accounts;
    private String[] accountlist;
    // Selection model for table
    private DefaultListSelectionModel SelectionModel;
    private ImageIcon icon;

    public AccountsListPanel()
    {
        initComponents();
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }

    /* THIS CONSTRUCTOR IS EXTREMELY IMPORTANT. WRITE A CONSTRUCTOR LIKE THIS
     FOR ALL OTHER PANELS

     This constructor takes in MainPanel from GUI.java which gives us access to
     the main panel where all of our GUI elements will eventually be located. */
    public AccountsListPanel(JPanel MainPanel, GUI mainGUI)
    {
        // Sets the background
        icon = new javax.swing.ImageIcon(getClass().getResource("/Assets/rsz_2icon.png"));
        // Grabs all information for the currentUserAccount so that it can be
        // put into the table
        wrapper = new UserAccountWrapper(GUI.currentUserAccount);
        total_accounts = wrapper.getTotalAccounts();
        accountlist = new String[total_accounts];
        for (int i = 0; i < total_accounts; i++)
        {
            accountlist[i] = wrapper.getAccountName(i);
        }
        this.MainPanel = MainPanel;
        this.mainGUI = mainGUI;
        initComponents();
    }

    // Allows us to update the table when data is changed
    public void setNewCellValue(double NewBalance, String accountName)
    {
        AccountsTable.setValueAt((Object) NewBalance,
                findRowPositionByName(accountName), BALANCECOL);
    }

    // Updates the label that displays the currentUserAccount
    public void updateUserLabel()
    {
        UserLabel.setText(GUI.currentUserAccount.getUserName());
    }

    // Updates all elements on the entire page
    public void update()
    {
        // Updates all JLabels across the program
        mainGUI.updateUserLabels();
        //System.out.println(AccountsTable.getSelectedRowCount());
        SelectionModel.clearSelection();
        // Redraws the AccountsTable
        AccountsTable.setModel(new AccountsTableModel(GUI.currentUserAccount));
        // Grabs the new info for the new account
        wrapper = new UserAccountWrapper(GUI.currentUserAccount);
        total_accounts = wrapper.getTotalAccounts();
        accountlist = new String[total_accounts];
        for (int i = 0; i < total_accounts; i++)
        {
            accountlist[i] = wrapper.getAccountName(i);
        }
        // Draws new combo boxes
        DefaultComboBoxModel model1 = new DefaultComboBoxModel(accountlist);
        DefaultComboBoxModel model0 = new DefaultComboBoxModel(accountlist);
        this.BankAccountsList1.setModel(model1);
        this.BankAccountsList.setModel(model0);
    }

    // Used to delete strings from the combo boxes.
    public void deletecomboboxes(String bankacc)
    {
        //wrapper contains backend information related to the table for 
        //current user
        wrapper = new UserAccountWrapper(GUI.currentUserAccount);
        //# of bankaccounts for this user
        total_accounts = wrapper.getTotalAccounts();
        //string array to hold account names
        accountlist = new String[total_accounts - 1];
        boolean accountfound = false;
        //Cycle through list of AccountNames in the wrapper until
        //the account to delete is found
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

        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        AccountsTable = new javax.swing.JTable();
        TransferFundsPanel = new javax.swing.JPanel()
        {
            protected void paintComponent(Graphics g)
            {
                g.setColor( getBackground() );
                g.fillRect(0, 0, getWidth(), getHeight());
                super.paintComponent(g);
            }
        };
        ToYourAccountLabel = new javax.swing.JLabel();
        TransferBetweenMyAccounts = new javax.swing.JButton();
        BankAccountsList1 = new javax.swing.JComboBox();
        EmailEntryField = new javax.swing.JTextField();
        TransferToAnotherUser = new javax.swing.JButton();
        Transferanotheruser = new javax.swing.JLabel();
        AmountToTransfer = new javax.swing.JLabel();
        AmountField = new javax.swing.JTextField();
        BankAccountToTransferFrom = new javax.swing.JLabel();
        BankAccountsList = new javax.swing.JComboBox();
        MyBankAccountTransfer = new javax.swing.JPanel();
        TransferToAnotherUserP = new javax.swing.JPanel();
        TransferFromandAmount = new javax.swing.JPanel()
        {
            protected void paintComponent(Graphics g)
            {
                g.setColor( getBackground() );
                g.fillRect(0, 0, getWidth(), getHeight());
                super.paintComponent(g);
            }

        };
        LabelForSize = new javax.swing.JLabel();
        DeleteAccountButton = new javax.swing.JButton();
        CreateBAButton = new javax.swing.JButton();
        FutureBalancetButton = new javax.swing.JButton();
        TransactionHistoryButton = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        UserLabel = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        option = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(800, 600));
        setLayout(new java.awt.GridBagLayout());

        jPanel3.setOpaque(false);
        java.awt.GridBagLayout jPanel3Layout = new java.awt.GridBagLayout();
        jPanel3Layout.columnWidths = new int[] {0, 8, 0};
        jPanel3Layout.rowHeights = new int[] {0, 8, 0, 8, 0, 8, 0};
        jPanel3.setLayout(jPanel3Layout);

        jScrollPane1.setBackground(new Color(255,255,255,190));
        jScrollPane1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(14, 118, 188), 1, true));
        jScrollPane1.setMaximumSize(new java.awt.Dimension(440, 390));
        jScrollPane1.setMinimumSize(new java.awt.Dimension(400, 300));
        jScrollPane1.setOpaque(false);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(440, 390));

        AccountsTable.setAutoCreateRowSorter(true);
        AccountsTable.setSelectionModel(SelectionModel = new DefaultListSelectionModel());
        SelectionModel.setSelectionMode(0);
        AccountsTable.setBackground(new Color(255,255,255));
        AccountsTable.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        AccountsTable.setForeground(new java.awt.Color(14, 118, 188));
        AccountsTable.setModel(new PresentationLayer.AccountsTableModel(PresentationLayer.GUI.currentUserAccount));
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        AccountsTable.setDefaultRenderer(String.class, centerRenderer);
        AccountsTable.setDefaultRenderer(Double.class, centerRenderer);
        AccountsTable.setColumnSelectionAllowed(false);
        AccountsTable.getTableHeader().setResizingAllowed(false);
        AccountsTable.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 12));
        AccountsTable.setGridColor(new java.awt.Color(255, 255, 255));
        AccountsTable.getTableHeader().setDefaultRenderer((new HeaderRenderer(AccountsTable)));
        AccountsTable.getTableHeader().setForeground(new Color(0,0,204));
        AccountsTable.setOpaque(false);
        AccountsTable.setSelectionBackground(new java.awt.Color(14, 118, 188));
        AccountsTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(AccountsTable);
        AccountsTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel3.add(jScrollPane1, gridBagConstraints);

        TransferFundsPanel.setBackground(new Color(255,255,255,150));
        TransferFundsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(14, 118, 188), 1, true), "Transfer Funds", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("DejaVu Sans", 1, 16), new Color(14,118,188))); // NOI18N
        TransferFundsPanel.setOpaque(false);
        TransferFundsPanel.setPreferredSize(new java.awt.Dimension(300, 160));
        java.awt.GridBagLayout TransferFundsPanelLayout = new java.awt.GridBagLayout();
        TransferFundsPanelLayout.columnWidths = new int[] {0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0};
        TransferFundsPanelLayout.rowHeights = new int[] {0, 15, 0, 15, 0, 15, 0, 15, 0, 15, 0, 15, 0, 15, 0, 15, 0, 15, 0, 15, 0, 15, 0, 15, 0};
        TransferFundsPanel.setLayout(TransferFundsPanelLayout);

        ToYourAccountLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ToYourAccountLabel.setForeground(new java.awt.Color(255, 255, 255));
        ToYourAccountLabel.setText("To Your One Of Bank Accounts");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        TransferFundsPanel.add(ToYourAccountLabel, gridBagConstraints);

        TransferBetweenMyAccounts.setBackground(new java.awt.Color(255, 255, 255));
        TransferBetweenMyAccounts.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        TransferBetweenMyAccounts.setForeground(new java.awt.Color(14, 118, 188));
        TransferBetweenMyAccounts.setText("Transfer");
        TransferBetweenMyAccounts.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                TransferBetweenMyAccountsActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 12;
        TransferFundsPanel.add(TransferBetweenMyAccounts, gridBagConstraints);

        BankAccountsList1.setForeground(new java.awt.Color(255, 255, 255));
        BankAccountsList1.setModel(new javax.swing.DefaultComboBoxModel(accountlist));
        BankAccountsList1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                BankAccountsList1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        TransferFundsPanel.add(BankAccountsList1, gridBagConstraints);

        EmailEntryField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        EmailEntryField.setText("Email Address");
        EmailEntryField.addFocusListener(new java.awt.event.FocusAdapter()
        {
            public void focusGained(java.awt.event.FocusEvent evt)
            {
                EmailEntryFieldFocusGained(evt);
            }
        });
        EmailEntryField.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                EmailEntryFieldActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        TransferFundsPanel.add(EmailEntryField, gridBagConstraints);

        TransferToAnotherUser.setBackground(new java.awt.Color(255, 255, 255));
        TransferToAnotherUser.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        TransferToAnotherUser.setForeground(new java.awt.Color(14, 118, 188));
        TransferToAnotherUser.setText("Transfer");
        TransferToAnotherUser.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                TransferToAnotherUserMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 20;
        TransferFundsPanel.add(TransferToAnotherUser, gridBagConstraints);

        Transferanotheruser.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Transferanotheruser.setForeground(new java.awt.Color(255, 255, 255));
        Transferanotheruser.setText("Transfer To Another User:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        TransferFundsPanel.add(Transferanotheruser, gridBagConstraints);

        AmountToTransfer.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        AmountToTransfer.setForeground(new java.awt.Color(14, 118, 188));
        AmountToTransfer.setText("Amount to Transfer: $");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        TransferFundsPanel.add(AmountToTransfer, gridBagConstraints);

        AmountField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        AmountField.setText("Amount");
        AmountField.setMinimumSize(new java.awt.Dimension(100, 21));
        AmountField.addFocusListener(new java.awt.event.FocusAdapter()
        {
            public void focusGained(java.awt.event.FocusEvent evt)
            {
                AmountFieldFocusGained(evt);
            }
        });
        AmountField.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                AmountFieldActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        TransferFundsPanel.add(AmountField, gridBagConstraints);

        BankAccountToTransferFrom.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        BankAccountToTransferFrom.setForeground(new java.awt.Color(14, 118, 188));
        BankAccountToTransferFrom.setText("Bank Account To Transfer From");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        TransferFundsPanel.add(BankAccountToTransferFrom, gridBagConstraints);

        BankAccountsList.setForeground(new Color(255,255,255,255));
        BankAccountsList.setModel(new javax.swing.DefaultComboBoxModel(accountlist));
        BankAccountsList.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                BankAccountsListActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        TransferFundsPanel.add(BankAccountsList, gridBagConstraints);

        MyBankAccountTransfer.setBackground(new java.awt.Color(14, 118, 188));
        MyBankAccountTransfer.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(14, 118, 188), 1, true));
        MyBankAccountTransfer.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.gridheight = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        TransferFundsPanel.add(MyBankAccountTransfer, gridBagConstraints);

        TransferToAnotherUserP.setBackground(new java.awt.Color(14, 118, 188));
        TransferToAnotherUserP.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(14, 118, 188), 1, true));
        TransferToAnotherUserP.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        TransferFundsPanel.add(TransferToAnotherUserP, gridBagConstraints);

        TransferFromandAmount.setBackground(new Color(255,255,255,190));
        TransferFromandAmount.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(14, 118, 188), 1, true));
        TransferFromandAmount.setForeground(new java.awt.Color(14, 118, 188));
        TransferFromandAmount.setOpaque(false);
        java.awt.GridBagLayout jPanel5Layout = new java.awt.GridBagLayout();
        jPanel5Layout.columnWidths = new int[] {0, 5, 0};
        jPanel5Layout.rowHeights = new int[] {0, 10, 0};
        TransferFromandAmount.setLayout(jPanel5Layout);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.gridheight = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        TransferFundsPanel.add(TransferFromandAmount, gridBagConstraints);

        LabelForSize.setText("Email Address    ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 20;
        TransferFundsPanel.add(LabelForSize, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        jPanel3.add(TransferFundsPanel, gridBagConstraints);

        DeleteAccountButton.setBackground(new java.awt.Color(255, 255, 255));
        DeleteAccountButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        DeleteAccountButton.setForeground(new java.awt.Color(14, 118, 188));
        DeleteAccountButton.setText("Delete Highlighted Account");
        DeleteAccountButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                DeleteAccountButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        jPanel3.add(DeleteAccountButton, gridBagConstraints);

        CreateBAButton.setBackground(new java.awt.Color(255, 255, 255));
        CreateBAButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        CreateBAButton.setForeground(new java.awt.Color(14, 118, 188));
        CreateBAButton.setText("Create New Bank Account");
        CreateBAButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                CreateBAButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel3.add(CreateBAButton, gridBagConstraints);

        FutureBalancetButton.setBackground(new java.awt.Color(255, 255, 255));
        FutureBalancetButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        FutureBalancetButton.setForeground(new java.awt.Color(14, 118, 188));
        FutureBalancetButton.setText("Calculate Future Balance");
        FutureBalancetButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                FutureBalancetButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel3.add(FutureBalancetButton, gridBagConstraints);

        TransactionHistoryButton.setBackground(new java.awt.Color(255, 255, 255));
        TransactionHistoryButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        TransactionHistoryButton.setForeground(new java.awt.Color(14, 118, 188));
        TransactionHistoryButton.setText("Transaction History");
        TransactionHistoryButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                TransactionHistoryButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        jPanel3.add(TransactionHistoryButton, gridBagConstraints);

        jPanel10.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPanel3.add(jPanel10, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(15, 0, 0, 0);
        add(jPanel3, gridBagConstraints);

        jPanel11.setOpaque(false);
        jPanel11.setLayout(new java.awt.GridBagLayout());

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(14, 118, 188), 1, true));
        java.awt.GridBagLayout jPanel8Layout = new java.awt.GridBagLayout();
        jPanel8Layout.columnWidths = new int[] {0, 10, 0, 10, 0};
        jPanel8Layout.rowHeights = new int[] {0};
        jPanel8.setLayout(jPanel8Layout);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setMinimumSize(new java.awt.Dimension(200, 115));
        java.awt.GridBagLayout jPanel6Layout = new java.awt.GridBagLayout();
        jPanel6Layout.columnWidths = new int[] {0, 12, 0};
        jPanel6Layout.rowHeights = new int[] {0, 7, 0, 7, 0};
        jPanel6.setLayout(jPanel6Layout);

        UserLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        UserLabel.setForeground(new java.awt.Color(14, 118, 188));
        UserLabel.setText("userlabel");
        UserLabel.setMaximumSize(new java.awt.Dimension(400, 15));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        jPanel6.add(UserLabel, gridBagConstraints);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        java.awt.GridBagLayout jPanel12Layout = new java.awt.GridBagLayout();
        jPanel12Layout.columnWidths = new int[] {0, 10, 0};
        jPanel12Layout.rowHeights = new int[] {0};
        jPanel12.setLayout(jPanel12Layout);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/rsz_settingscolor2.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jLabel4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                jLabel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                jLabel4MouseExited(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel12.add(jLabel4, gridBagConstraints);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/rsz_logout2noborder2.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jLabel5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                jLabel5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                jLabel5MouseExited(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel12.add(jLabel5, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel6.add(jPanel12, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel8.add(jPanel6, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel11.add(jPanel8, gridBagConstraints);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(14, 118, 188), 1, true));
        jPanel9.setLayout(new java.awt.GridBagLayout());

        jLabel2.setBackground(new java.awt.Color(255, 242, 0));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/rsz_2icon.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel9.add(jLabel2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel11.add(jPanel9, gridBagConstraints);

        option.setBackground(new Color(255,255,255,150));
        option.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        option.setForeground(new java.awt.Color(14, 118, 188));
        option.setText(" ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        jPanel11.add(option, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 0);
        add(jPanel11, gridBagConstraints);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 255));
        jLabel6.setText("Home");
        jLabel6.setText("<HTML><U>Home</U></HTML>");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 0);
        add(jLabel6, gridBagConstraints);

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/wallhaven-15760.png"))); // NOI18N
        Background.setAlignmentY(0.0F);
        Background.setMaximumSize(new java.awt.Dimension(800, 600));
        Background.setMinimumSize(new java.awt.Dimension(800, 600));
        Background.setOpaque(true);
        Background.setPreferredSize(new java.awt.Dimension(800, 600));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(Background, gridBagConstraints);
        Background.getAccessibleContext().setAccessibleDescription("");
    }// </editor-fold>//GEN-END:initComponents

    private void CreateBAButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_CreateBAButtonActionPerformed
    {//GEN-HEADEREND:event_CreateBAButtonActionPerformed
        JPanel createBApanel = mainGUI.getCreateBA().getCreateBankAccountPanel();
        // Display a popup which will allow the user to create a new bank account
        int choice = JOptionPane.showConfirmDialog(
                null,
                createBApanel,
                "Bank 42",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                GUI.icon
        );

        if (choice == 0)
        {
            mainGUI.getCreateBA().CreateAccount();
        }
    }//GEN-LAST:event_CreateBAButtonActionPerformed

    private void AmountFieldFocusGained(java.awt.event.FocusEvent evt)//GEN-FIRST:event_AmountFieldFocusGained
    {//GEN-HEADEREND:event_AmountFieldFocusGained
        if (AmountField.getText().equals("Amount"))
        {
            AmountField.setText("");
        }
    }//GEN-LAST:event_AmountFieldFocusGained

    private void AmountFieldActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_AmountFieldActionPerformed
    {//GEN-HEADEREND:event_AmountFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AmountFieldActionPerformed

    private void BankAccountsListActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_BankAccountsListActionPerformed
    {//GEN-HEADEREND:event_BankAccountsListActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BankAccountsListActionPerformed

    private void EmailEntryFieldFocusGained(java.awt.event.FocusEvent evt)//GEN-FIRST:event_EmailEntryFieldFocusGained
    {//GEN-HEADEREND:event_EmailEntryFieldFocusGained
        if (EmailEntryField.getText().equals("Email Address"))
        {
            EmailEntryField.setText("");
        }
    }//GEN-LAST:event_EmailEntryFieldFocusGained

    private void EmailEntryFieldActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_EmailEntryFieldActionPerformed
    {//GEN-HEADEREND:event_EmailEntryFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmailEntryFieldActionPerformed

    private void BankAccountsList1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_BankAccountsList1ActionPerformed
    {//GEN-HEADEREND:event_BankAccountsList1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BankAccountsList1ActionPerformed

    // Checks if a valid double was entered
    public static boolean isParsableDouble(String input)
    {
        boolean parsable = true;
        try
        {
            // parse the double and catch the exception if there is one
            Double.parseDouble(input);
        } catch (NumberFormatException e)
        {
            parsable = false;
        }
        return parsable;
    }

    // Checks if a valid int was entered
    public static boolean isParsableInt(String input)
    {
        boolean parsable = true;
        try
        {
            // parse the int and catch the exception if there is one
            Integer.parseInt(input);
        } catch (NumberFormatException e)
        {
            parsable = false;
        }
        return parsable;
    }

    // This function will return the row in the table that belongs to the passed
    // in accountName
    private int findRowPositionByName(String accountName)
    {
        int cRow = 0;
        int totalRows = AccountsTable.getRowCount();
        // loop through the table until the accountName is found
        while (!accountName.equals(AccountsTable.getValueAt(cRow, NAMECOL))
                || cRow == totalRows)
        {
            cRow++;
        }
        return cRow;
    }

    //This button is used to send money from one of the current user's 
    //bank accounts, to another user
    private void TransferToAnotherUserMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_TransferToAnotherUserMouseClicked
    {//GEN-HEADEREND:event_TransferToAnotherUserMouseClicked
        //amount to send
        double amount;
        //Amount set to int placed in textbox
        if (isParsableDouble(AmountField.getText()))
        {
            amount = Integer.parseInt(AmountField.getText());
        }
        //otherwise pop-up box asking for a valid amount
        else
        {
            JOptionPane.showMessageDialog(null, "Please enter a valid amount to transfer", "Bank 42", 1, icon);
            return;
        }
        //positive number check
        if (amount <= 0)
        {
            JOptionPane.showMessageDialog(null, "Please enter a valid amount to transfer", "Bank 42", 1, icon);
            return;
        }

        GUI.currentBankAccount = GUI.currentUserAccount.findBankAccount((String) BankAccountsList.getSelectedItem());
        //Enough available funds check
        if (amount > GUI.currentBankAccount.getBalance())
        {
            JOptionPane.showMessageDialog(null, "Insufficient funds"
                    + "\nYou have $" + GUI.currentBankAccount.getBalance() + " available"
                    + " in selected bank account", "Bank 42", 1, icon);
            return;
        }
        //email of other user, as entered in text box
        String email = EmailEntryField.getText();
        //find other userAccount by their email
        UserAccount founduser = GUI.MasterTable.findUserAccountEmail(email);
        
        if (founduser != null)
        {
            //checking if you entered your own email
            if (founduser == GUI.currentUserAccount)
            {
                JOptionPane.showMessageDialog(null, "You cannot send funds to yourself!", "Bank 42", 1, icon);
                return;
            }

            JPanel createBApanel = mainGUI.getCreateBA().getCreateBankAccountPanel();
            //confirmation check
            int choice = JOptionPane.showConfirmDialog(
                    null,
                    "Are you sure you want to send $" + amount + " from\nbank account:     " + GUI.currentBankAccount.getAccountName() + "\nto User Account: " + founduser.getUserName() + "\nwith Email:           " + email + "?",
                    "Bank 42",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    GUI.icon
            );
            //if confirmed send the cash
            if (choice == 0)
            {
                //remove funds from current user
                GUI.currentBankAccount.setBalance(GUI.currentBankAccount.getBalance() - amount);
                mainGUI.setAccountBalance(GUI.currentBankAccount.getAccountName(), GUI.currentBankAccount.getBalance());
                //document transaction in transaction history
                GUI.currentBankAccount.addTransaction("Sent funds to " + email, amount);
                //pull up user to send funds to
                String email2 = GUI.currentUserAccount.getEmail();
                GUI.currentBankAccount = founduser.getBankAccHead();
                //add funds
                GUI.currentBankAccount.setBalance(GUI.currentBankAccount.getBalance() + amount);
                //document in transaction history
                GUI.currentBankAccount.addTransaction("Received funds from " + email2, amount);
                mainGUI.setAccountBalance(GUI.currentBankAccount.getAccountName(), GUI.currentBankAccount.getBalance());
                //success pop-up
                JOptionPane.showMessageDialog(null, "Funds transfered successfully!", "Bank 42", 1, icon);

                /**
                 * 11/30**export upon successful change of data BEGIN*
                 */
                GUI.dataout.exportDB(GUI.MasterTable);

                /**
                 * ********************END*
                 */
            }
        }
        //account not found
        else
        {
            JOptionPane.showMessageDialog(null, "Error, user account not found", "Bank 42", 1, icon);
        }
    }//GEN-LAST:event_TransferToAnotherUserMouseClicked

    // Allows the user to delete the highlighted account when they press the button
    private void DeleteAccountButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_DeleteAccountButtonActionPerformed
    {//GEN-HEADEREND:event_DeleteAccountButtonActionPerformed
        // Make sure that the user has selected an account
        if (AccountsTable.getSelectedRowCount() > 0)
        {
            // Do not allow the user to delete their last account, forcing them to
            // always have at least one account open
            if (GUI.currentUserAccount.getNumOfBankAccounts() == 1)
            {
                JOptionPane.showMessageDialog(null, "You must have at least one bank account.\n"
                        + "You cannot delete this bank account without creating a new one first.", "Bank 42", 0);
                return;
            }

            String account_type;
            double amount_in_deleted_acc;
            String account_name;
            // The row with the account that the user wants to delete
            int row = AccountsTable.getSelectedRow();
            // Get the name of the bankAccount that the user wants to delete
            String bankacc = (String) AccountsTable.getValueAt(row, NAMECOL);
            // Set the currentBankAccount to the name of the bankAccount that
            // the user wants to delete so that we can call delete on it
            GUI.currentBankAccount = GUI.currentUserAccount.findBankAccount(bankacc);
            // Store the balance so that we can send it somewhere after deletion
            amount_in_deleted_acc = GUI.currentBankAccount.getBalance();
            account_type = GUI.currentBankAccount.getAccountType();
            account_name = GUI.currentBankAccount.getAccountName();

            // Edge case for deleting empty accounts
            if (amount_in_deleted_acc == 0)
            {
                // Show message for successful delete
                JOptionPane.showMessageDialog(null, bankacc + " has been deleted", "Bank 42", 1, icon);
                GUI.currentUserAccount.deleteBankAccount(bankacc);
                // Export database and update the table
                GUI.dataout.exportDB(GUI.MasterTable);
                this.update();
                return;
            }

            // Options that a user has for the funds after deleting the account
            Object[] options =
            {
                "To one of my other bank accounts",
                "Email me funds"
            };
            // Ask the user where they want to send the funds in that account
            int n = JOptionPane.showOptionDialog(null,
                    "You have $" + amount_in_deleted_acc + " in account " + account_name
                    + "\nWhere would you like the funds to go?",
                    "Bank 42",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    icon, //do not use a custom icon
                    options, //the titles of buttons
                    options[0]); //default button title

            // Remove the Bank Account's name from the comboboxes
            deletecomboboxes(bankacc);

            // Allow the user to select one of their own accounts to send the money
            // from the deleted account to
            if (n == 0)
            {
                String choice = (String) JOptionPane.showInputDialog(
                        null,
                        "Choose a bank account",
                        "Bank 42",
                        JOptionPane.PLAIN_MESSAGE,
                        icon,
                        accountlist,
                        null);

                if (null == choice)
                {
                    return;
                }
                // Delete the bank account
                GUI.currentUserAccount.deleteBankAccount(bankacc);
                GUI.currentBankAccount = GUI.currentUserAccount.findBankAccount(choice);
                // Add the balance of the deleted account to the account that the user
                // selected
                GUI.currentBankAccount.setBalance(GUI.currentBankAccount.getBalance() + amount_in_deleted_acc);
                // Create a transaction in the transaction history for this
                // bank account receiving funds
                GUI.currentBankAccount.addTransaction("Received funds from " + bankacc, amount_in_deleted_acc);
                // Update the view and the DB
                this.update();
                GUI.dataout.exportDB(GUI.MasterTable);
                // Success message
                JOptionPane.showMessageDialog(null, "Bank account " + bankacc
                        + " has been deleted" + "\nFunds have been transfered to " + choice, "Bank 42", 1, icon);
            }
            // send funds from deleted account to email
            else if (n == 1)
            {
                // delete the account and update the view/DB
                GUI.currentUserAccount.deleteBankAccount(bankacc);
                this.update();
                GUI.dataout.exportDB(GUI.MasterTable);
                // Success message
                JOptionPane.showMessageDialog(null, "Bank account " + bankacc
                        + " has been deleted" + "\nFunds have been emailed to you at:\n"
                        + GUI.currentUserAccount.getEmail(), "Bank 42", 1, icon);
            }
        }
        else // The user did not highlight an account. display error message
            JOptionPane.showMessageDialog(null, "Please select an account", "Bank 42", 1, icon);
    }//GEN-LAST:event_DeleteAccountButtonActionPerformed

    // Allows the user to calculate their future balance after a number of days
    // after interest/penalties
    private void FutureBalancetButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_FutureBalancetButtonActionPerformed
    {//GEN-HEADEREND:event_FutureBalancetButtonActionPerformed
        // Make sure the user has selected an account
        if (AccountsTable.getSelectedRowCount() > 0)
        {
            int amount;
            // Prompt the user to input the number of days
            Object amountstring = JOptionPane.showInputDialog(
                    null, "Please enter the time period, in days, that you would like to calculate interest over.", "Bank 42", 1, GUI.icon, null, null);
            if (amountstring != null)
            {
                // Check valid input
                if (isParsableInt(amountstring.toString()))
                    amount = Integer.parseInt(amountstring.toString());
                else
                {
                    JOptionPane.showMessageDialog(null, "You must enter a valid number of days.", "Bank 42", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (amount < 0)
                {
                    JOptionPane.showMessageDialog(null, "You must enter a valid number of days.", "ERROR", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                // grab the current date
                DateTime interestDate = new DateTime();
                // grab the account from the row that the user has selected
                int row = AccountsTable.getSelectedRow();
                String bankacc = (String) AccountsTable.getValueAt(row, NAMECOL);
                GUI.currentBankAccount = GUI.currentUserAccount.findBankAccount(bankacc);
                // calculate the interest and display it
                double calcInt = GUI.currentBankAccount.getInterestCustomer(interestDate.plusDays(amount));
                JOptionPane.showMessageDialog(null, "Success! The balance of account "
                        + GUI.currentBankAccount.getAccountName() + " after " + amount + " days will be " + GUI.MoneyFormat.format(calcInt), "Bank 42", 1, icon);
            }
        }
        else // The user did not select ac account
            JOptionPane.showMessageDialog(null, "Please select an account", "Bank 42", 1, icon);
    }//GEN-LAST:event_FutureBalancetButtonActionPerformed

    // This will take the user to the transaction hsitory page
    private void TransactionHistoryButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_TransactionHistoryButtonActionPerformed
    {//GEN-HEADEREND:event_TransactionHistoryButtonActionPerformed
        // Make sure that the user has selected an account
        if (AccountsTable.getSelectedRowCount() > 0)
        {
            // Find the account that the user selected
            int row = AccountsTable.getSelectedRow();
            String bankacc = (String) AccountsTable.getValueAt(row, NAMECOL);
            GUI.currentBankAccount = GUI.currentUserAccount.findBankAccount(bankacc);
            // Update the view, draw the transactionHistoryTable and take the
            // user to the TransactionHistory page
            CardLayout layout = (CardLayout) (MainPanel.getLayout());
            mainGUI.getTransPanel().update();
            AmountField.setText("Amount");
            EmailEntryField.setText("Email Address");
            layout.show(MainPanel, "TransPanel");

        }
        else // User did not select an account
            JOptionPane.showMessageDialog(null, "Please select an account", "Bank 42", 1, icon);
    }//GEN-LAST:event_TransactionHistoryButtonActionPerformed

    //Transfer money balances between a user's bank accounts (Action performed
    //allows the enter key to trigger this method, isntead of exclusively
    // mouse clicks.)
    private void TransferBetweenMyAccountsActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_TransferBetweenMyAccountsActionPerformed
    {//GEN-HEADEREND:event_TransferBetweenMyAccountsActionPerformed
        //Amount we're going to send
        double amount;
        //pull int amount from textbox
        if (isParsableDouble(AmountField.getText()))
        {
            amount = Double.parseDouble(AmountField.getText());
        }
        //if not a valid amount/int then error message
        else
        {
            JOptionPane.showMessageDialog(null, "Please enter a valid amount to transfer", "Bank 42", 1, GUI.icon);
            return;
        }
        //positive number check
        if (amount <= 0)
        {
            JOptionPane.showMessageDialog(null, "Please enter a valid amount to transfer", "Bank 42", 1, GUI.icon);
            return;
        }
        //pull up selected bank account
        GUI.currentBankAccount = GUI.currentUserAccount.findBankAccount((String) BankAccountsList.getSelectedItem());
        //check if enough available funds
        if (amount > GUI.currentBankAccount.getBalance())
        {
            AmountField.setText("Amount");
            JOptionPane.showMessageDialog(null, "Insufficient funds"
                    + "\nYou have $" + GUI.currentBankAccount.getBalance() + " available"
                    + " in selected bank account", "Bank 42", 1, GUI.icon);
        }
        //same bank account check
        else if (GUI.currentBankAccount == GUI.currentUserAccount.findBankAccount((String) BankAccountsList1.getSelectedItem()))
        {
            JOptionPane.showMessageDialog(null, "You cannot transfer funds to and from\nthe same bank account", "Bank 42", 1, icon);
        }
        //send the money!
        else
        {
            //remove funds from desired bank account
            GUI.currentBankAccount.setBalance(GUI.currentBankAccount.getBalance() - amount);
            //document in transaction history
            GUI.currentBankAccount.addTransaction("Sent funds to " + (String) BankAccountsList1.getSelectedItem(), amount);
            mainGUI.setAccountBalance(GUI.currentBankAccount.getAccountName(), GUI.currentBankAccount.getBalance());
            //account to send funds too
            GUI.currentBankAccount = GUI.currentUserAccount.findBankAccount((String) BankAccountsList1.getSelectedItem());
            //add funds to desired bank account
            GUI.currentBankAccount.setBalance(GUI.currentBankAccount.getBalance() + amount);
            //add funds
            mainGUI.setAccountBalance(GUI.currentBankAccount.getAccountName(), GUI.currentBankAccount.getBalance());
            //document transaction
            GUI.currentBankAccount.addTransaction("Received funds from " + (String) BankAccountsList.getSelectedItem(), amount);
            //success pop-up box
            JOptionPane.showMessageDialog(null, "Funds transfered successfully!", "Bank 42", 1, icon);
            //set data
            GUI.dataout.exportDB(GUI.MasterTable);
        }
    }//GEN-LAST:event_TransferBetweenMyAccountsActionPerformed
    //setting button text
    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jLabel4MouseEntered
    {//GEN-HEADEREND:event_jLabel4MouseEntered
        option.setText("  Settings");
    }//GEN-LAST:event_jLabel4MouseEntered
    //settings button clicked
    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jLabel4MouseClicked
    {//GEN-HEADEREND:event_jLabel4MouseClicked
        AmountField.setText("Amount");
        EmailEntryField.setText("Email Address");
        CardLayout layout = (CardLayout) (MainPanel.getLayout());
        layout.show(MainPanel, "Settings");
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel4MouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jLabel4MouseExited
    {//GEN-HEADEREND:event_jLabel4MouseExited
        option.setText(" ");
    }//GEN-LAST:event_jLabel4MouseExited
    //logout button text
    private void jLabel5MouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jLabel5MouseEntered
    {//GEN-HEADEREND:event_jLabel5MouseEntered
        option.setText("               Logout");
    }//GEN-LAST:event_jLabel5MouseEntered

    private void jLabel5MouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jLabel5MouseExited
    {//GEN-HEADEREND:event_jLabel5MouseExited
        option.setText(" ");
    }//GEN-LAST:event_jLabel5MouseExited
    //logout button clicked
    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jLabel5MouseClicked
    {//GEN-HEADEREND:event_jLabel5MouseClicked
        AmountField.setText("Amount");
        EmailEntryField.setText("Email Address");
        CardLayout layout = (CardLayout) (MainPanel.getLayout());
        layout.show(MainPanel, "Login");
    }//GEN-LAST:event_jLabel5MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable AccountsTable;
    private javax.swing.JTextField AmountField;
    private javax.swing.JLabel AmountToTransfer;
    private javax.swing.JLabel Background;
    private javax.swing.JLabel BankAccountToTransferFrom;
    private javax.swing.JComboBox BankAccountsList;
    private javax.swing.JComboBox BankAccountsList1;
    private javax.swing.JButton CreateBAButton;
    private javax.swing.JButton DeleteAccountButton;
    private javax.swing.JTextField EmailEntryField;
    private javax.swing.JButton FutureBalancetButton;
    private javax.swing.JLabel LabelForSize;
    private javax.swing.JPanel MyBankAccountTransfer;
    private javax.swing.JLabel ToYourAccountLabel;
    private javax.swing.JButton TransactionHistoryButton;
    private javax.swing.JButton TransferBetweenMyAccounts;
    private javax.swing.JPanel TransferFromandAmount;
    private javax.swing.JPanel TransferFundsPanel;
    private javax.swing.JButton TransferToAnotherUser;
    private javax.swing.JPanel TransferToAnotherUserP;
    private javax.swing.JLabel Transferanotheruser;
    private javax.swing.JLabel UserLabel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel option;
    // End of variables declaration//GEN-END:variables

}
