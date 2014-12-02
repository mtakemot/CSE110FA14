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
import LogicLayer.BankAccount;
import LogicLayer.HashTable;
import LogicLayer.UserAccount;
import DataLayer.*;
import FacadeLayer.UserAccountWrapper;
import LogicLayer.Transaction;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import org.joda.time.DateTime;
import java.util.Timer;
import java.util.TimerTask;
//import org.joda.time.DateTimeZone;
import org.joda.time.*;
//import static java.lang.Math.abs

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

    public static final int BALANCECOL = 2;
    // Format doubles in output so that they look like money
    public static final NumberFormat MoneyFormat = new DecimalFormat("$0.00");

    //declare import/export variables used for database read/write
    public static ImportExport datain = new ImportExport();
    public static ImportExport dataout = new ImportExport();

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

    /**
     * 11/30**call import/export and initialize empty databases with this
     * function*
     */
    public static void initDB()
    {

        MasterTable = datain.importDB(MasterTable);

        if (MasterTable != null)
        {
            //import worked, copy temp to Master
            //MasterTable = tempTable;
            System.out.println("MSG GUI.java: Imported existing data");
        }
        else
        {
            //didn't work, MasterTable will start as a blank HashTable obj
            System.out.println("MSG GUI.java: empty table, creating new DB");
            MasterTable = new HashTable();
        }

        //Puts some initial values in the table to prevent null pointer
        // exceptions
        currentUserAccount = MasterTable.insertUserAccount("Customer_A", "Customer_A_Email");
        if (currentUserAccount != null)
        {
            currentUserAccount.setFirstName("first");
            currentUserAccount.setLastName("last");
            currentUserAccount.setPassword("foobar");
            currentUserAccount.setPhone("0123456789");
            currentBankAccount = currentUserAccount.insertBankAccount(1000, "Checking_1A", "Checking");
            currentBankAccount = currentUserAccount.insertBankAccount(2100, "Savings_1A", "Savings");
            currentBankAccount = currentUserAccount.insertBankAccount(100, "Checking_2A", "Checking");
            currentBankAccount = currentUserAccount.insertBankAccount(3100, "Checking_3A", "Checking");
        }

        currentUserAccount = MasterTable.insertUserAccount("Customer_B", "Customer_B_Email");
        if (currentUserAccount != null)
        {
            currentUserAccount.setFirstName("first");
            currentUserAccount.setLastName("last");
            currentUserAccount.setPassword("foobar");
            currentUserAccount.setPhone("0123456789");
            currentBankAccount = currentUserAccount.insertBankAccount(1100, "Checking_1B", "Checking");
            currentBankAccount = currentUserAccount.insertBankAccount(2100, "Savings_1B", "Savings");
            currentBankAccount = currentUserAccount.insertBankAccount(100, "Checking_2B", "Checking");
            currentBankAccount = currentUserAccount.insertBankAccount(3100, "Checking_3B", "Checking");
        }
        currentUserAccount = MasterTable.insertUserAccount("qq", "email");
        if (currentUserAccount != null)
        {
            currentUserAccount.setFirstName("first");
            currentUserAccount.setLastName("last");
            currentUserAccount.setPassword("qq");
            currentUserAccount.setPhone("0123456789");
            currentBankAccount = currentUserAccount.insertBankAccount(1100, "qq1", "Checking");
            currentBankAccount = currentUserAccount.insertBankAccount(2100, "qq2", "Savings");
            currentBankAccount = currentUserAccount.insertBankAccount(100, "qq3", "Checking");
            currentBankAccount = currentUserAccount.insertBankAccount(3100, "qq4", "Checking");
        }

        currentUserAccount = MasterTable.insertUserAccount("ww", "email2");
        if (currentUserAccount != null)
        {
            currentUserAccount.setFirstName("first2");
            currentUserAccount.setLastName("last2");
            currentUserAccount.setPassword("ww");
            currentUserAccount.setPhone("1234567890");
            currentBankAccount = currentUserAccount.insertBankAccount(1100, "ww1", "Checking");
            currentBankAccount = currentUserAccount.insertBankAccount(35, "ww2", "Savings");
            currentBankAccount = currentUserAccount.insertBankAccount(30, "ww3", "Checking");
            currentBankAccount = currentUserAccount.insertBankAccount(30, "ww4", "Checking");
        }

        currentUserAccount = MasterTable.insertUserAccount("ee", "emai3");
        if (currentUserAccount != null)
        {
            currentUserAccount.setFirstName("first2");
            currentUserAccount.setLastName("last2");
            currentUserAccount.setPassword("ee");
            currentUserAccount.setPhone("1234567890");
            currentBankAccount = currentUserAccount.insertBankAccount(50, "ee1", "Checking");
            currentBankAccount = currentUserAccount.insertBankAccount(35, "ee2", "Savings");
            currentBankAccount = currentUserAccount.insertBankAccount(30, "ee3", "Checking");
            currentBankAccount = currentUserAccount.insertBankAccount(30, "ee4", "Checking");
        }

        //if these items exists in our DB alread, currentUser will be NULL.
        //initializing in case it's NULL
        if (currentUserAccount == null)
        {
            currentUserAccount = MasterTable.findUserAccount("ee");
            currentBankAccount = currentUserAccount.findBankAccount("ee1");
        }

        if (dataout.exportDB(MasterTable))
        {
            System.out.println("MSG GUI.JAVA: updated DB, proceed to set up TimerTask\n");
        }
        else
            System.err.println("MSG GUI.JAVA: EXPORT DB FAILED in initDB()");
    }

    /**
     * 11/30**method for setting up TimerTask to run in background*
     */
    public static void initTask()
    {
        Timer timer = new Timer();

        //begin setup for balanceTask thread
        TimerTask updateBalance = new balanceTask();
        int balanceInterval = (23 * 60 * 60 + 59 * 60 + 60) * 1000;
        System.out.println("balanceInterval: " + balanceInterval);
        TimerTask updateInterest = new interestTask();
        int interestInterval = (23 * 60 * 60 + 59 * 60 + 60) * 1000; //multiply with current # day in month
        System.out.println("interestInterval: " + balanceInterval);

        //get the DateTime for the
        DateTime last = MasterTable.getLastInterestDateTime();
        System.out.println("init Last: " + last);
        int lastMonth = last.getMonthOfYear();

        DateTime now = new DateTime(DateTimeZone.forID("Etc/UTC"));
        System.out.println("init now: " + now);
        int nowMonth = now.getMonthOfYear();
        Seconds s = Seconds.secondsBetween(last, now);
        int sPassed = s.getSeconds();
        System.out.println("Seconds passed: " + sPassed);
        int taskdelay = sPassed;
        int hourDiff = sPassed / (60 * 60);
        sPassed = sPassed - hourDiff * 3600;
        int minDiff = sPassed / 60;
        sPassed = sPassed - minDiff * 60;
        int secDiff = sPassed;

        ///    timer.scheduleAtFixedRate(updateBalance, taskdelay, balanceInterval);
        DateTime temp = last.withSecondOfMinute(last.plusSeconds(secDiff).getSecondOfMinute());
        temp = temp.withMinuteOfHour(temp.plusMinutes(minDiff).getMinuteOfHour());
        temp = temp.withHourOfDay(temp.plusHours(hourDiff).getHourOfDay());
        MasterTable.setLastInterestDateTime(temp);
        System.out.println("temp is: " + temp);
        last = MasterTable.getLastInterestDateTime();
        System.out.println("new last should be same as now: " + last);
        //NOW we got rid of the smaller time variables we do not need to monitor
        //HOWEVER, if adding the increments did increase day/time run the tasks

        //month difference
        int monthDiff = nowMonth - lastMonth;

        int daysInMonth = last.dayOfMonth().getMaximumValue();
        for (int i = 0; i < monthDiff; i++)
        {

        }

        timer.scheduleAtFixedRate(updateBalance, taskdelay, balanceInterval);
        timer.scheduleAtFixedRate(updateInterest, taskdelay, interestInterval);

        /*
         int minDiff = abs(Minutes.minutesBetween(last, now).getMinutes());
         int secDiff = abs(Seconds.secondsBetween(last, now).getSeconds());*/
        //  System.out.println()
        //now that the updateBalance x dPassed is done, delay until the next day
        //and schedule task from that delay for every hour
            /*long delaySec = (hourDiff*60*60+ minDiff*60+secDiff+1)*1000;
         long balanceInterval = (23*60*60+59*60+60)*1000; //balance runs full day intervals
         System.out.println(" balanceInterval: " + balanceInterval);
         long interestInterval = numDaysInMonth * balanceInterval;
         System.out.println("interestInterval: " + interestInterval);

         timer.scheduleAtFixedRate(updateBalance, delaySec, balanceInterval);
         timer.scheduleAtFixedRate(updateInterest, delaySec, interestInterval);*/
        System.out.println("TaskTimer scheduled by main. Now initializing GUI");

        /* ***********************************************************************/
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
        getAccList().updateUserLabel();
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

                final GUI mainGUI = new GUI();

                /**
                 * ****initialize interestTask.java GUI object with mainGUI to
                 * use table change*
                 */
                initDB();

                //update daily total BEFORE interest.
                initTask();
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
                mainGUI.setTransPanel(new TransactionHistoryPanel(cardHolder, mainGUI));
                mainGUI.setDolphinsPanel(new DolphinsPanel(cardHolder, mainGUI));

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
                cardHolder.add(mainGUI.getTellerAP(), "TellerAP");
                cardHolder.add(mainGUI.getTDelete(), "TDelete");
                cardHolder.add(mainGUI.getPenIntPanel(), "PenIntPanel");
                cardHolder.add(mainGUI.getTransPanel(), "TransPanel");
                cardHolder.add(mainGUI.getDolphinsPanel(), "DolphinsPanel");

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
    private TransactionHistoryPanel TransPanel;
    private DolphinsPanel DolphinsPanel;

    public DolphinsPanel getDolphinsPanel()
    {
        return DolphinsPanel;
    }

    public void setDolphinsPanel(DolphinsPanel DolphinsPanel)
    {
        this.DolphinsPanel = DolphinsPanel;
    }

    public TransactionHistoryPanel getTransPanel()
    {
        return TransPanel;
    }

    public void setTransPanel(TransactionHistoryPanel TransPanel)
    {
        this.TransPanel = TransPanel;
    }

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
