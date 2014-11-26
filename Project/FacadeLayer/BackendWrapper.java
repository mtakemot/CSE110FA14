package FacadeLayer;
import LogicLayer.BankAccount;
import LogicLayer.UserAccount;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rbridges
 */
public class BackendWrapper
{

    private int[] accountNumbers;
    private String[] accountNames;
    private String[] accountTypes;
    private double[] accountBalances;
    private int totalAccounts = 0;
    private UserAccount currentUA;
    private BankAccount currentBA;

    public BackendWrapper(UserAccount curr)
    {
        if (curr != null)
        {
            currentUA = curr;
            totalAccounts = currentUA.getNumOfBankAccounts();
            accountNumbers = new int[totalAccounts];
            accountNames = new String[totalAccounts];
            accountTypes = new String[totalAccounts];
            accountBalances = new double[totalAccounts];
            this.getAccountInfo();
        }
    }

    private void getAccountInfo()
    {
        if (currentUA.getBankAccHead() != null)
        {
            currentBA = currentUA.getBankAccHead();
            // Traverse the BankAccount linked list until the account is found
            // or we reach the end of the list
            for (int zod = 0; zod < totalAccounts; zod++)
            {
                accountNumbers[zod] = zod + 1;
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
    public int getAccountNumber(int index)
    {
        return accountNumbers[index];
    }

    public String getAccountName(int index)
    {
        return accountNames[index];
    }

    public String getAccountType(int index)
    {
        return accountTypes[index];
    }

    public double getAccountBalance(int index)
    {
        return accountBalances[index];
    }

    public int getTotalAccounts()
    {
        return totalAccounts;
    }

    public UserAccount getCurrentUA()
    {
        return currentUA;
    }

    public BankAccount getCurrentBA()
    {
        return currentBA;
    }

    public void setAccountBalance(double newBalance, int rowIndex)
    {
        this.accountBalances[rowIndex] = newBalance;
    }

    public void setAccountName(String newName, int rowIndex)
    {
        this.accountNames[rowIndex] = newName;
    }

    public void setAccountType(String newType, int rowIndex)
    {
        this.accountTypes[rowIndex] = newType;
    }

    public void setAccountNumber(int newNumber, int rowIndex)
    {
        this.accountNumbers[rowIndex] = newNumber;
    }

}
