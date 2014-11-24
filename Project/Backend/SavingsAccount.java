package Backend;

import org.joda.time.*;

/**
 * **************************************************************************
 *
 * Ryan Bridges CSE 110, Fall 2014 Last Updated: October 19, 2014
 *
 * Team 42
 *
 * File Name: SavingsAccount.java Description: This file extends BankAccount and
 * will be the object that is created every time a user wants to create a new
 * savings account. This type of BankAccount WILL gain interest and lose funds
 * as a result of not having a high enough balance. TODO: Implement functions
 * that will add interest or subtract funds based on the balance and the age of
 * the account
 * **************************************************************************
 */
public class SavingsAccount extends BankAccount
{

    public SavingsAccount()
    {
        super();
    }

    public SavingsAccount(String name)
    {
        super();
        this.accountName = name;
    }

    public SavingsAccount(double bal, String name)
    {
        this.balance = bal;
        this.accountName = name;
        this.accountType = "Saving";
    }

@Override
    public boolean subFromBalance(double amount)
    {
        if ((this.balance - amount < 0) || (amount > 5000))
        {
            return false;
        }
        // Grab the current time in UTC
        DateTime currentDateTime = new DateTime(DateTimeZone.forID("Etc/UTC"));
        // Check if this withdraw is less than 24 hours from the last withdraw
        if (Hours.hoursBetween(currentDateTime, lastWithdrawDateTime).getHours() <= 24)
        {
            if ((dayWithdrawAmount + amount) <= 5000)
            {
                this.balance -= amount;             
                dayWithdrawAmount += amount;
                return true;
            }
        }
        else if (Hours.hoursBetween(currentDateTime, lastWithdrawDateTime).getHours() > 24)
        {
            this.balance -= amount;
            lastWithdrawDateTime = currentDateTime;
            dayWithdrawAmount = amount;
            return true;
        }
        return false;
    }
    
    @Override
    public boolean addToBalance(double amount)
    {
        if (amount > 5000)
        {
            return false;
        }
        // Grab the current time in UTC
        DateTime currentDateTime = new DateTime(DateTimeZone.forID("Etc/UTC"));
        // Check if this deposit is less than 24 hours from the last deposit
        if (Hours.hoursBetween(currentDateTime, lastDepositDateTime).getHours() <= 24)
        {
            if ((dayDepositAmount + amount) <= 5000)
            {
                this.balance += amount;
                dayDepositAmount += amount;
                return true;
            }
        }
        else if (Hours.hoursBetween(currentDateTime, lastDepositDateTime).getHours() > 24)
        {
            this.balance += amount;
            lastDepositDateTime = currentDateTime;
            dayDepositAmount = amount;
            return true;
        }
        return false;
    }
}
