package LogicLayer;

import static java.lang.Math.abs;
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

    // Default ctor
    public SavingsAccount()
    {
        super();
    }

    // Name ctor
    public SavingsAccount(String name)
    {
        super();
        this.accountType = "Savings";
        this.accountName = name;
    }

    /**
     * SavingsAccount Constructor
     *
     * @param bal Initial Balance for the new account
     * @param name name for the new account
     */
    public SavingsAccount(double bal, String name)
    {
        super();
        this.balance = bal;
        this.accountName = name;
        this.accountType = "Savings";
        // Add the account creation to the Transaction History
        this.transactions.add(new Transaction("Account Created", bal));
        DateTime currentTime = new DateTime();
        // Set the daily totals according to the current date
        this.thisMonthsDailyTotals = bal * currentTime.getDayOfMonth();
    }

    /**
     * subFromBalance is overridden from BankAccount.java. Allows us to subtract
     * from a user's account. Also imposes daily withdraw limit of $5000
     *
     * @param amount amount to subtract
     * @return whether or not the withdraw was successful
     */
    @Override
    public boolean subFromBalance(double amount)
    {
        if ((this.balance - amount < 0) || (amount > 5000))
        {
            return false;
        }
        // Grab the current time
        DateTime currentDateTime = new DateTime();
        // Check if this withdraw is less than 24 hours from the last withdraw
        if (abs(Hours.hoursBetween(currentDateTime, lastWithdrawDateTime).getHours()) <= 24)
        {
            // Ensure that this withdraw will not put the user over their threshold
            if ((dayWithdrawAmount + amount) <= 5000)
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
     * user's account. Also imposes daily deposit limit of $5000
     *
     * @param amount amount to subtract
     * @return whether or not the deposit was successful
     */
    @Override
    public boolean addToBalance(double amount)
    {
        if (amount > 5000)
            return false;

        // Grab the current time
        DateTime currentDateTime = new DateTime();
        // Check if this deposit is less than 24 hours from the last deposit
        if (abs(Hours.hoursBetween(currentDateTime, lastDepositDateTime).getHours()) <= 24)
        {
            // Check if this deposit will put the user over their daily threshold
            if ((dayDepositAmount + amount) <= 5000)
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
            
            //record this into transaction history
            this.getTransactions().add(new Transaction("Deposit", amount));
            return true;
        }
        return false;
    }
}
