package Backend;

import org.joda.time.*;

/**
 * **************************************************************************
 *
 * Ryan Bridges CSE 110, Fall 2014 Last Updated: October 19, 2014
 *
 * Team 42
 *
 * File Name: CheckingAccount.java Description: This file extends BankAccount
 * and will be the object that is created every time a user wants to create a
 * new checking account. This type of BankAccount WILL NOT gain interest or lose
 * funds as a result of not having a high enough balance.
 * **************************************************************************
 */
public class CheckingAccount extends BankAccount
{

    public CheckingAccount()
    {
    }

    public CheckingAccount(String name)
    {
        this.accountName = name;
        dayWithdrawAmount = 0;
    }

    public CheckingAccount(double bal, String name)
    {
        this.balance = bal;
        this.accountName = name;
        this.accountType = "Checking";
        dayWithdrawAmount = 0;
    }

    @Override
    public boolean subFromBalance(double amount)
    {
        if ((this.balance - amount < 0) || (amount > 10000))
        {
            return false;
        }
        // Grab the current time in UTC
        DateTime currentDateTime = new DateTime(DateTimeZone.forID("Etc/UTC"));
        // Check if this withdraw is less than 24 hours from the last withdraw
        if (Hours.hoursBetween(currentDateTime, lastWithdrawDateTime).getHours() <= 24)
        {
            // Ensure that this withdraw will not put the user over their threshold
            if ((dayWithdrawAmount + amount) <= 10000)
            {
                // Perform withdraw and update threshold
                this.balance -= amount;
                dayWithdrawAmount += amount;
                return true;
            }
        }
        else // If it has been more that 24 hours since the last withdraw
        {
            // Do the withdraw and update the lastWithdrawDateTime
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
        if (amount > 10000)
        {
            return false;
        }
        // Grab the current time in UTC
        DateTime currentDateTime = new DateTime(DateTimeZone.forID("Etc/UTC"));
        // Check if this deposit is less than 24 hours from the last deposit
        if (Hours.hoursBetween(currentDateTime, lastDepositDateTime).getHours() <= 24)
        {
            // Check if this deposit will put the user over their daily threshold
            if ((dayDepositAmount + amount) <= 10000)
            {
                // Update threshold and deposit the money
                this.balance += amount;
                dayDepositAmount += amount;
                return true;
            }
        }
        else // It has been more than 24 hrs since the last deposit
        {
            // Update threshold, lastDepositDateTime and deposit the money
            this.balance += amount;
            lastDepositDateTime = currentDateTime;
            dayDepositAmount = amount;
            return true;
        }
        return false;
    }
}
