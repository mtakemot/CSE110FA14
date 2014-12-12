package FacadeLayer;

//to access user account and it's bank account list
//to store for use by Table's on our GUI.
import LogicLayer.BankAccount;
import LogicLayer.UserAccount;

/* this is the wrapper used by our table to collect information
 *  on the accounts that we need to display on our Tables.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author rbridges
 */
public class UserAccountWrapper
{

    //private int[] accountNumbers;
    private String[] accountNames;  //collection of account names
    private String[] accountTypes;  //collection of acc types
    private double[] accountBalances;   //collection of acc bal
    private int totalAccounts = 0;  //incrementer to set table size later
    private UserAccount currentUA;  //current working User account
    private BankAccount currentBA;  //current User's bacnk account

    /**
     * UserAccountWrapper takes in the current working user account as a param.
     * This method then retrieves the necessary information of the user account
     * and it's related bank accounts by delegating to the getAccountInfo getter
     * method defined below.
     *
     * @param curr current user account that the wrapper is going to 
     * retrieve information from.
     */
    public UserAccountWrapper(UserAccount curr)
    {
        if (curr != null)
        {
            currentUA = curr;
            totalAccounts = currentUA.getNumOfBankAccounts();
            //accountNumbers = new int[totalAccounts];
            accountNames = new String[totalAccounts];
            accountTypes = new String[totalAccounts];
            accountBalances = new double[totalAccounts];
            this.getAccountInfo();
        }
    }

    /**
     * getAccountInfo() is called by UserAccountWrapper to get names, types,
     * balances as it iterates through the current user's bank accounts. All
     * retrieved information is stored in the respective arrays declared as
     * members of this class (UserAccountWrapper).
     */
    private void getAccountInfo()
    {
        if (currentUA.getBankAccHead() != null)
        {
            currentBA = currentUA.getBankAccHead();
            // Traverse the BankAccount linked list until the account is found
            // or we reach the end of the list
            for (int zod = 0; zod < totalAccounts; zod++)
            {
                //accountNumbers[zod] = zod + 1;
                accountNames[zod] = currentBA.getAccountName();
                accountTypes[zod] = currentBA.getAccountType();
                accountBalances[zod] = currentBA.getBalance();
                currentBA = currentBA.getNext();
            }
        }
    }

    /////////////////////////////////////////
    // BELOW ARE JUST SETTERS AND GETTERS ///
    /////////////////////////////////////////
    //returns a String representing the bank account name. stored at index
    public String getAccountName(int index)
    {
        return accountNames[index];
    }

    //returns a String representing the bank account type. stored at index
    public String getAccountType(int index)
    {
        return accountTypes[index];
    }

    //returns a double  representing the bank account balance. stored at index
    public double getAccountBalance(int index)
    {
        return accountBalances[index];
    }

    //returns an int representing the number of bank accounts in the particular
    //user account
    public int getTotalAccounts()
    {
        return totalAccounts;
    }

    //returns the current working user account
    public UserAccount getCurrentUA()
    {
        return currentUA;
    }

    //returns the current working bank account
    public BankAccount getCurrentBA()
    {
        return currentBA;
    }

    /**
     * sets the balance for the current bank account.
     *
     * @param newBalance double representing the new balance
     * @param rowIndex int representing the index of the bank account that will
     * have the balance replaced.
     */
    public void setAccountBalance(double newBalance, int rowIndex)
    {
        this.accountBalances[rowIndex] = newBalance;
    }

    /**
     * sets the account name (changes) for the current bank account
     *
     * @param newName String representing the account's new name
     * @param rowIndex int representing the index of the bank account that will
     * be changed
     */
    public void setAccountName(String newName, int rowIndex)
    {
        this.accountNames[rowIndex] = newName;
    }

    /**
     * changes the account type of the bank account
     *
     * @param newType String stating the accoun ttype
     * @param rowIndex int representing the index of the bank account that will
     * be changed
     */
    public void setAccountType(String newType, int rowIndex)
    {
        this.accountTypes[rowIndex] = newType;
    }

    /*public void setAccountNumber(int newNumber, int rowIndex)
     {
     this.accountNumbers[rowIndex] = newNumber;
     }*/
}
