package GUI;

/**
 * **************************************************************************
 *
 * Ryan Bridges CSE 110, Fall 2014 Last Updated: October 30, 2014
 *
 * Team 42
 *
 * File Name: GUI.java Description: This will be the main controller class for
 * our entire GUI. Panels/buttons/textboxes etc that we want in our GUI can be
 * declared outside of this class then we can create objects of those classes
 * inside of this class to show those elements. The key is, we MUST pass
 * MainPanel in to the constructor of everything that we create outside of this
 * class. This class will declare a MainPanel which will have a CardLayout. This
 * MainPanel will hold all of our other panels, and we will be able to show and
 * hide them at will. Our HashTable will also be accessible to all of our UI
 * regardless of where they are defined because of the static definition near
 * the top of this class. To run the program and see the GUI, run this file,
 * GUI.java.
 * **************************************************************************
 */
/*
 import Backend.UserAccount;
 import Backend.HashTable;
 import Backend.BankAccount;*/
//11/8 michio takemoto seeing if just backend.* is fine 
//need to add backend.ImportExport if not
import Backend.BankAccount;
import Backend.HashTable;
import Backend.UserAccount;
import FacadeLayer.BackendWrapper;
import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class GUI extends javax.swing.JFrame
{

    static int counter = 0;

    // Static HashTable allows us to access the table in any element of our GUI
    public static HashTable MasterTable = new HashTable();
    // Static UserAccount allows us to store a UserAccount after a user logs in
    // so that we can manipulate it in other panels of our GUI
    public static UserAccount currentUserAccount;
    // Static BankAccount allows us to store a UserAccount after a user selects
    // it so that we can manipulate it in other panels of our GUI
    public static BankAccount currentBankAccount;
    //keyword to change the AccList table
    public static final String ACCTABLE = "account table";
    //keyword to change the TellerAP table
    public static final String TELTABLE = "teller table";

    public static final int BALANCECOL = 3;

    public GUI()
    {
        initComponents();
    }

    // This is a getter function for the JPanel that is created when this 
    // component is initiialized. If you open "Generated Code" below you can 
    // see where MainPanel is declared. This one JPanel is where we will show/hide
    // all of our other UI elements. This should also be passed into the 
    // constructor of any new panel that we make so that each panel as access to
    // it
    public JPanel getMainPanel()
    {
        return MainPanel;
    }

    public void updateUserLabels()
    {
        getDelete().updateUserLabel();
        getSettings().updateUserLabel();
        getTellerAP().updateUserLabel();
        getTDelete().updateUserLabel();
        getCreateBA().updateUserLabel();
    }

    public void setAccountBalance(String BankAccountName, double NewBalance)
    {
        if (currentUserAccount != null)
        {
            BackendWrapper wrapper = new BackendWrapper(currentUserAccount);
            this.currentBankAccount = currentUserAccount.findBankAccount(BankAccountName);
            //find the row of the given account
            int row = 0;

            while (!(BankAccountName.equals(wrapper.getAccountName(row))
                    || counter == currentUserAccount.getNumOfBankAccounts()))
            {
                row++;
            }
            //now change the table model and call fireTableDataChanged.     
            firePropertyChange(ACCTABLE, false, true);
        }
    }

    /**
     * EXPAND THIS FUNCTION TO SEE HOW MainPanel IS INITIALIZED. ALL OF OUR
     * OTHER PANELS/PAGES WILL BE PLACED ON MainPanel WHICH IS DELCARED HERE
     *
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));

        MainPanel.setBackground(new java.awt.Color(0, 153, 204));
        MainPanel.setMaximumSize(new java.awt.Dimension(800, 600));
        MainPanel.setName(""); // NOI18N
        MainPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        MainPanel.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(MainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 856, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(MainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[])
    {

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            // Allows us to "run" our program. Will manage all of our GUI elements
            // on the canvas
            @Override
            public void run()
            {
                /**
                 * *******testing import export*********
                 */
                /*ImportExport datain = new ImportExport();
                 ImportExport dataout = new ImportExport();

                 MasterTable = datain.importDB(MasterTable);
                 System.out.println("GUI.java imported table has: " + MasterTable.occ + " users\n"); 
                 // This creates the MainPanel that is referenced above. All of 
                 // our other panels will go on top of this one and be shown or 
                 // hidden depending on the state of our program*/
                final GUI mainGUI = new GUI();

                //Puts some initial values in the table to prevent null pointer 
                // exceptions
                currentUserAccount = MasterTable.insertUserAccount("qq");
                currentUserAccount.setFirstName("first");
                currentUserAccount.setLastName("last");
                currentUserAccount.setPassword("qq");
                currentUserAccount.setEmail("email");
                currentUserAccount.setPhone("0123456789");
                currentBankAccount = currentUserAccount.insertBankAccount(20, "qq1", "Checking");
                currentBankAccount = currentUserAccount.insertBankAccount(25, "qq2", "Savings");
                currentBankAccount = currentUserAccount.insertBankAccount(30, "qq3", "Checking");
                currentBankAccount = currentUserAccount.insertBankAccount(30, "qq4", "Checking");

                currentUserAccount = MasterTable.insertUserAccount("ww");
                currentUserAccount.setFirstName("first2");
                currentUserAccount.setLastName("last2");
                currentUserAccount.setPassword("ww");
                currentUserAccount.setEmail("email2");
                currentUserAccount.setPhone("1234567890");
                currentBankAccount = currentUserAccount.insertBankAccount(50, "ww1", "Checking");
                currentBankAccount = currentUserAccount.insertBankAccount(35, "ww2", "Savings");
                currentBankAccount = currentUserAccount.insertBankAccount(30, "ww3", "Checking");
                currentBankAccount = currentUserAccount.insertBankAccount(30, "ww4", "Checking");

                currentUserAccount = MasterTable.insertUserAccount("ee");
                currentUserAccount.setFirstName("first2");
                currentUserAccount.setLastName("last2");
                currentUserAccount.setPassword("ee");
                currentUserAccount.setEmail("email3");
                currentUserAccount.setPhone("1234567890");
                currentBankAccount = currentUserAccount.insertBankAccount(50, "ee1", "Checking");
                currentBankAccount = currentUserAccount.insertBankAccount(35, "ee2", "Savings");
                currentBankAccount = currentUserAccount.insertBankAccount(30, "ee3", "Checking");
                currentBankAccount = currentUserAccount.insertBankAccount(30, "ee4", "Checking");

                //test
                for (int i = 0; i < 10000; i++)
                {
                    currentUserAccount.insertBankAccount(i, ("acc" + i), "Checking");
                }

                // This grabs the MainPanel and stores it in a variable so that
                // we have easy access to it
                JPanel cardHolder = mainGUI.getMainPanel();
                // This creates a new LoginPanel and passes in the MainPanel. 

                //LoginPanel Login = new LoginPanel(cardHolder);
                mainGUI.setLogin(new LoginPanel(cardHolder, mainGUI));
                mainGUI.setAccList(new AccountsListPanel(cardHolder, mainGUI));
                mainGUI.setSettings(new Settings(cardHolder, mainGUI));
                mainGUI.setCreateAcc(new CreateAccountPanel(cardHolder, mainGUI));
                mainGUI.setDelete(new DeleteAccountPanel(cardHolder, mainGUI));
                mainGUI.setCreateBA(new CreateBankAccount(cardHolder, mainGUI));
                mainGUI.setTellerAP(new TellerAccountPage(cardHolder, mainGUI));
                mainGUI.setTransfer(new TransferFundsPanel(cardHolder, mainGUI));
                mainGUI.setTellerMainMenu(new TellerMainMenu(cardHolder, mainGUI));
                mainGUI.setTDelete(new TellerDeleteAccountPanel(cardHolder, mainGUI));

                // This creates a new AccList Panel and passes in the MainPanel
                //AccountsListPanel AccList = new AccountsListPanel(cardHolder, mainGUI);
                // This creates a new Settings Panel and passes in the MainPanel
                //Settings Settings = new Settings(cardHolder);
                mainGUI.setTransfer(new TransferFundsPanel(cardHolder, mainGUI));
                // Creates a new CreateAccountPanel and passes in the Main Panel
                //CreateAccountPanel CreateAcc = new CreateAccountPanel(cardHolder);
                //MainMenuPanel mainMenu = new MainMenuPanel(cardHolder);

                //TransferFundsPanel Transfer = new TransferFundsPanel(cardHolder);
                //WithdrawPanel Withdraw = new WithdrawPanel(cardHolder);
                //DepositPanel Deposit = new DepositPanel(cardHolder);
                //DeleteAccountPanel Delete = new DeleteAccountPanel(cardHolder);
                //TellerMainMenu TellerMainMenu = new TellerMainMenu(cardHolder);
                //CreateBankAccount createBA = new CreateBankAccount(cardHolder);
                //TellerAccountPage TellerAP = new TellerAccountPage(cardHolder);
                // This addes the LoginPanel and AccountsListPanel that we just
                // created to the MainPanel. It also assigns a name to each of
                // the panels so that we can reference them easily when we want 
                // to show/hide them. For instance, if we were in some other class
                // that has access to MainPanel, we could use the following 2 lines
                // to show the AccList panel
                // CardLayout layout = (CardLayout) (MainPanel.getLayout());
                // layout.show(MainPanel, "AccList");
                cardHolder.add(mainGUI.getLogin(), "Login");
                cardHolder.add(mainGUI.getAccList(), "AccList");
                cardHolder.add(mainGUI.getCreateAcc(), "CreateAcc");
                cardHolder.add(mainGUI.getSettings(), "Settings");
                cardHolder.add(mainGUI.getTransfer(), "Transfer");
                //cardHolder.add(Withdraw, "Withdraw");
                //cardHolder.add(Deposit, "Deposit" );
                cardHolder.add(mainGUI.getDelete(), "Delete");
                cardHolder.add(mainGUI.getTellerMainMenu(), "TellerMainMenu");
                cardHolder.add(mainGUI.getCreateBA(), "CreateBA");
                cardHolder.add(mainGUI.getTellerAP(), "TellerAP");
                cardHolder.add(mainGUI.getTDelete(), "TDelete");

                // These two lines show the MainPanel. Without these 2 lines 
                // the GUI would not show up at all. Just leave them alone.
                mainGUI.pack();
                mainGUI.setVisible(true);

                mainGUI.setResizable(false);

                mainGUI.addPropertyChangeListener(ACCTABLE,
                        new PropertyChangeListener()
                        {

                            @Override
                            public void propertyChange(PropertyChangeEvent PcEvt)
                            {
                                mainGUI.getAccList().setNewCellValue(currentBankAccount.getBalance(),
                                        currentBankAccount.getAccountName());
                                return;
                            }
                        });
                mainGUI.addPropertyChangeListener(TELTABLE,
                        new PropertyChangeListener()
                        {

                            @Override
                            public void propertyChange(PropertyChangeEvent PcE)
                            {
                                mainGUI.getTellerAP().setNewCellValue(currentBankAccount.getBalance(),
                                        currentBankAccount.getAccountName());
                            }
                        });
                /*if (dataout.exportDB(MasterTable))
                 {
                 System.err.println("\nExported file to local source file"
                 + " Data.ser\n"
                 + "\n\nFrom run() in GUI.java");

                 }

                 else
                 {
                 System.err.println("\n\nCould not export, ERROR\n\n");

                 }

                 System.out.println("\nrun() has ran: " + counter + " times\n");*/
            }
        });
    }
    private TransferFundsPanel Transfer;
    private LoginPanel Login;
    private AccountsListPanel AccList;
    private CreateAccountPanel CreateAcc;
    private Settings Settings;
    private TellerMainMenu TellerMainMenu;
    private CreateBankAccount CreateBA;
    private TellerAccountPage TellerAP;
    private DeleteAccountPanel Delete;
    private TellerDeleteAccountPanel TDelete;

    public TellerDeleteAccountPanel getTDelete()
    {
        return TDelete;
    }

    public void setTDelete(TellerDeleteAccountPanel TDelete)
    {
        this.TDelete = TDelete;
    }

    public DeleteAccountPanel getDelete()
    {
        return Delete;
    }

    public void setDelete(DeleteAccountPanel Delete)
    {
        this.Delete = Delete;
    }

    public LoginPanel getLogin()
    {
        return Login;
    }

    public void setLogin(LoginPanel Login)
    {
        this.Login = Login;
    }

    public AccountsListPanel getAccList()
    {
        return AccList;
    }

    public void setAccList(AccountsListPanel AccList)
    {
        this.AccList = AccList;
    }

    public CreateAccountPanel getCreateAcc()
    {
        return CreateAcc;
    }

    public void setCreateAcc(CreateAccountPanel CreateAcc)
    {
        this.CreateAcc = CreateAcc;
    }

    public Settings getSettings()
    {
        return Settings;
    }

    public void setSettings(Settings Settings)
    {
        this.Settings = Settings;
    }

    public TellerMainMenu getTellerMainMenu()
    {
        return TellerMainMenu;
    }

    public void setTellerMainMenu(TellerMainMenu TellerMainMenu)
    {
        this.TellerMainMenu = TellerMainMenu;
    }

    public CreateBankAccount getCreateBA()
    {
        return CreateBA;
    }

    public void setCreateBA(CreateBankAccount CreateBA)
    {
        this.CreateBA = CreateBA;
    }

    public TellerAccountPage getTellerAP()
    {
        return TellerAP;
    }

    public void setTellerAP(TellerAccountPage TellerAP)
    {
        this.TellerAP = TellerAP;
    }

    public TransferFundsPanel getTransfer()
    {
        return Transfer;
    }

    public void setTransfer(TransferFundsPanel Transfer)
    {
        this.Transfer = Transfer;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MainPanel;
    // End of variables declaration//GEN-END:variables
}
