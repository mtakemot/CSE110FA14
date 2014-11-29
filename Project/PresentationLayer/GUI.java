package PresentationLayer;

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
import LogicLayer.BankAccount;
import LogicLayer.HashTable;
import LogicLayer.UserAccount;
import FacadeLayer.UserAccountWrapper;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;

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
    // Format doubles in output so that they look like money
    public static final NumberFormat MoneyFormat = new DecimalFormat("$0.00");

    /**
     *
     */
    public Image my_image;
    //my_image = Toolkit.getDefaultToolkit().createImage("background-wallpapers-24.jpg");

    /*@Override
     public void paint(Graphics g)
     {
     // Draws the img to the BackgroundPanel.
     g.drawImage(img, 0, 0, null);
     }*/
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
            UserAccountWrapper wrapper = new UserAccountWrapper(currentUserAccount);
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
    private void initComponents()
    {
        java.awt.GridBagConstraints gridBagConstraints;

        MainPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        MainPanel.setBackground(new java.awt.Color(153, 102, 255));
        MainPanel.setMaximumSize(new java.awt.Dimension(800, 600));
        MainPanel.setName(""); // NOI18N
        MainPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        MainPanel.setLayout(new java.awt.CardLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(MainPanel, gridBagConstraints);

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
        //</editor-fold>
        //</editor-fold>
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
                currentUserAccount = MasterTable.insertUserAccount("qq", "email");
                currentUserAccount.setFirstName("first");
                currentUserAccount.setLastName("last");
                currentUserAccount.setPassword("qq");
                currentUserAccount.setPhone("0123456789");
                currentBankAccount = currentUserAccount.insertBankAccount(1100, "qq1", "Checking");
                currentBankAccount = currentUserAccount.insertBankAccount(2100, "qq2", "Savings");
                currentBankAccount = currentUserAccount.insertBankAccount(100, "qq3", "Checking");
                currentBankAccount = currentUserAccount.insertBankAccount(3100, "qq4", "Checking");

                currentUserAccount = MasterTable.insertUserAccount("ww", "email2");
                currentUserAccount.setFirstName("first2");
                currentUserAccount.setLastName("last2");
                currentUserAccount.setPassword("ww");
                currentUserAccount.setPhone("1234567890");
                currentBankAccount = currentUserAccount.insertBankAccount(1100, "ww1", "Checking");
                currentBankAccount = currentUserAccount.insertBankAccount(35, "ww2", "Savings");
                currentBankAccount = currentUserAccount.insertBankAccount(30, "ww3", "Checking");
                currentBankAccount = currentUserAccount.insertBankAccount(30, "ww4", "Checking");

                currentUserAccount = MasterTable.insertUserAccount("ee", "emai3");
                currentUserAccount.setFirstName("first2");
                currentUserAccount.setLastName("last2");
                currentUserAccount.setPassword("ee");
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

                mainGUI.setLogin(new LoginPanel(cardHolder, mainGUI));
                mainGUI.setAccList(new AccountsListPanel(cardHolder, mainGUI));
                mainGUI.setSettings(new Settings(cardHolder, mainGUI));
                mainGUI.setCreateAcc(new CreateAccountPanel(cardHolder, mainGUI));
                mainGUI.setDelete(new DeleteAccountPanel(cardHolder, mainGUI));
                mainGUI.setCreateBA(new CreateBankAccount(cardHolder, mainGUI));
                mainGUI.setTellerAP(new TellerAccountPage(cardHolder, mainGUI));
                mainGUI.setTellerMainMenu(new TellerMainMenu(cardHolder, mainGUI));
                mainGUI.setTDelete(new TellerDeleteAccountPanel(cardHolder, mainGUI));
                mainGUI.setPass(new PasswordFieldPanel(cardHolder, mainGUI));
                mainGUI.setPenIntPanel(new PenaltyInterestPanel(cardHolder, mainGUI));

                // This addes the LoginPanel and AccountsListPanel that we just
                // created to the MainPanel. It also assigns a name to each of
                // the panels so that we can reference them easily when we want
                // to show/hide them. For instance, if we were in some other class
                // that has access to MainPanel, we could use the following 2 lines
                // to show the AccList panel
                cardHolder.add(mainGUI.getLogin(), "Login");
                cardHolder.add(mainGUI.getAccList(), "AccList");
                cardHolder.add(mainGUI.getCreateAcc(), "CreateAcc");
                cardHolder.add(mainGUI.getSettings(), "Settings");
                cardHolder.add(mainGUI.getDelete(), "Delete");
                cardHolder.add(mainGUI.getTellerMainMenu(), "TellerMainMenu");
                cardHolder.add(mainGUI.getCreateBA(), "CreateBA");
                cardHolder.add(mainGUI.getTellerAP(), "TellerAP");
                cardHolder.add(mainGUI.getTDelete(), "TDelete");
                cardHolder.add(mainGUI.getTDelete(), "pass");
                cardHolder.add(mainGUI.getPenIntPanel(), "PenIntPanel");

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
    private LoginPanel Login;
    private AccountsListPanel AccList;
    private CreateAccountPanel CreateAcc;
    private Settings Settings;
    private TellerMainMenu TellerMainMenu;
    private CreateBankAccount CreateBA;
    private TellerAccountPage TellerAP;
    private DeleteAccountPanel Delete;
    private TellerDeleteAccountPanel TDelete;
    private PasswordFieldPanel pass;
    private PenaltyInterestPanel PenIntPanel;

    public PasswordFieldPanel getPass()
    {
        return pass;
    }

    public void setPass(PasswordFieldPanel pass)
    {
        this.pass = pass;
    }

    public PenaltyInterestPanel getPenIntPanel()
    {
        return PenIntPanel;
    }

    public void setPenIntPanel(PenaltyInterestPanel PenIntPanel)
    {
        this.PenIntPanel = PenIntPanel;
    }

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MainPanel;
    // End of variables declaration//GEN-END:variables

}
