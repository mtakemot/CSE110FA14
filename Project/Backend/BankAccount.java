package Backend;

import java.io.Serializable;
import org.joda.time.*;

/**
 * **************************************************************************
 *
 * Ryan Bridges CSE 110, Fall 2014 Last Updated: October 17, 2014
 *
 * Team 42
 *
 * File Name: BankAccount.java Description: This is the super class for the
 * different types of BankAccounts that the user can create. It contains basic
 * information about the bank account. It also contains a next field which will
 * hold the next BankAccount owned by the user.
 * **************************************************************************
 */
public class BankAccount implements Serializable
{
    protected double balance;
    protected String accountName;
    protected BankAccount next;
    protected String accountType;
    protected int accountPosition;
    
    // A running total of the amount of money at the end of each day for the 
    // whole month
    protected double thisMonthsDailyTotals;
    // Total amount withdrawn in last 24 hrs
    protected double dayWithdrawAmount;
    // The last time a withdraw was made on the account
    protected DateTime lastWithdrawDateTime;
    // Total amount deposited in last 24 hrs
    protected double dayDepositAmount;
    // The last time a deposit was made on the account
    protected DateTime lastDepositDateTime;

    public BankAccount()
    {
        DateTime currentTime = new DateTime(DateTimeZone.forID("Etc/UTC"));
        this.lastDepositDateTime = currentTime;
        this.lastWithdrawDateTime = currentTime;

        this.thisMonthsDailyTotals = 0;

        this.dayWithdrawAmount = 0;
        this.dayDepositAmount = 0;
    }

    double calculateAverageBalance()
    {
        return 0;
    }
    
    // The following 2 methods will be overridden in 
    // SavingsAccount.java and CheckingAccount.java
    public boolean subFromBalance(double amount)
    {
        return false;
    }
    
    public boolean addToBalance(double amount)
    {
        return true;
    }

/////////////////////////////////////////
// BELOW ARE JUST SETTERS AND GETTERS ///
/////////////////////////////////////////
    public void setBalance(double balance)
    {
        this.balance = balance;
    }

    public void setAccountName(String accountName)
    {
        this.accountName = accountName;
    }

    public void setNext(BankAccount next)
    {
        this.next = next;
    }

    public void setAccountType(String accountType)
    {
        this.accountType = accountType;
    }

    public double getBalance()
    {
        return balance;
    }

    public String getAccountName()
    {
        return accountName;
    }

    public BankAccount getNext()
    {
        return next;
    }

    public String getAccountType()
    {
        return accountType;
    }

    public int getAccountPosition()
    {
        return accountPosition;
    }

    public void setAccountPosition(int accountPosition)
    {
        this.accountPosition = accountPosition;
    }

    public double getThisMonthsDailyTotals()
    {
        return thisMonthsDailyTotals;
    }

    public void setThisMonthsDailyTotals(double thisMonthsDailyTotals)
    {
        this.thisMonthsDailyTotals = thisMonthsDailyTotals;
    }
    
    
}
