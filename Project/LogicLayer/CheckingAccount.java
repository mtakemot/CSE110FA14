package LogicLayer;

import static java.lang.Math.abs;
import org.joda.time.*;

/**
 * **************************************************************************
 *
 * Ryan Bridges CSE 110, Fall 2014 Last Updated: December 6, 2014
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

    // Default ctor
    public CheckingAccount()
    {
        super();
    }

    // Name ctor Sets ONLY the name of the account and the account type of this 
    // accnt to checking. 
    public CheckingAccount(String name)
    {
        super();
        this.accountName = name;
        this.accountType = "Checking";
    }

    /**
     * CheckingAccount Constructor
     *
     * @param bal Initial Balance for the new account
     * @param name name for the new account
     */
    public CheckingAccount(double bal, String name)
    {
        super();
        this.balance = bal;
        this.accountName = name;
        this.accountType = "Checking";
        // Add the account creation into the transaction
        this.transactions.add(new Transaction("Account Created", bal));
        // Set this month's daily totals
        DateTime currentTime = new DateTime();
        this.thisMonthsDailyTotals = bal * currentTime.getDayOfMonth();
    }

    /**
     * subFromBalance is overridden from BankAccount.java. Allows us to subtract
     * from a user's account. Also imposes daily withdraw limit of $10000
     *
     * @param amount amount to subtract
     * @return true/false
     */
    @Override
    public boolean subFromBalance(double amount)
    {
        // Check if this transaction will take us over the limit
        if ((this.balance - amount < 0) || (amount > 10000))
            return false;
        // Grab the current time
        DateTime currentDateTime = new DateTime();
        // Check if this withdraw is less than 24 hours from the last withdraw
        if (abs(Hours.hoursBetween(currentDateTime, lastWithdrawDateTime).getHours()) <= 24)
        {
            // Ensure that this withdraw will not put the user over their threshold
            if ((dayWithdrawAmount + amount) <= 10000)
            {
                // Perform withdraw and update threshold
                this.balance -= amount;
                dayWithdrawAmount += amount;
                this.getTransactions().add(new Transaction("Withdraw", amount));
                return true;
            }
        }
        else // If it has been more that 24 hours since the last withdraw
        {
            // Do the withdraw and update the lastWithdrawDateTime
            this.balance -= amount;
            lastWithdrawDateTime = currentDateTime;
            dayWithdrawAmount = amount;
            this.getTransactions().add(new Transaction("Withdraw", amount));
            return true;
        }
        return false;
    }

    /**
     * addToBalance is overridden from BankAccount.java. Allows us to add to a
     * user's account. Also imposes daily deposit limit of $10000
     *
     * @param amount amount to subtract
     * @return true/false
     */
    @Override
    public boolean addToBalance(double amount)
    {
        if (amount > 10000)
            return false;
        // Grab the current time
        DateTime currentDateTime = new DateTime();
        // Check if this deposit is less than 24 hours from the last deposit
        if (abs(Hours.hoursBetween(currentDateTime, lastDepositDateTime).getHours()) <= 24)
        {
            // Check if this deposit will put the user over their daily threshold
            if ((dayDepositAmount + amount) <= 10000)
            {
                // Update threshold and deposit the money
                this.balance += amount;
                dayDepositAmount += amount;
                this.getTransactions().add(new Transaction("Deposit", amount));
                return true;
            }
        }
        else // It has been more than 24 hrs since the last deposit
        {
            // Update threshold, lastDepositDateTime and deposit the money
            this.balance += amount;
            lastDepositDateTime = currentDateTime;
            dayDepositAmount = amount;
            this.getTransactions().add(new Transaction("Deposit", amount));
            return true;
        }
        return false;
    }
}
