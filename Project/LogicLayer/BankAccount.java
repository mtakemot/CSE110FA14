package LogicLayer;

import java.io.Serializable;
import static java.lang.Math.abs;
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

    // The following 3 methods will be overridden in
    // SavingsAccount.java and CheckingAccount.java
    public boolean subFromBalance(double amount)
    {
        return false;
    }

    public boolean addToBalance(double amount)
    {
        return false;
    }

    /**
     * Call this function to calculate what the user's interest will be at a
     * certain date in the future.
     *
     * @param interestDate A DateTime object that represents the date that the
     * user wants to know his interest on.
     * @return the user's balance after a set amount of time
     */
    public double getInterest(DateTime interestDate)
    {
        DateTime startTime = new DateTime(DateTimeZone.forID("Etc/UTC"));
        double tempTotal = thisMonthsDailyTotals;
        double tempAvg;
        double balanceAfterInterest = balance;
        // Create a counter for the total number of months that interest has be
        // calculated for.
        int counter = abs(Months.monthsBetween(startTime.withDayOfMonth(1), interestDate.withDayOfMonth(1)).getMonths());
        for (int zod = 0; zod < counter; zod++)
        {
            // Calculates the month's total daily balance by multiplying the current balance by
            // the total number of days that are left in the month including the
            // current day
            tempTotal += balanceAfterInterest * (startTime.dayOfMonth().getMaximumValue() - startTime.getDayOfMonth() + 1);
            // Calculates the average daily balance by dividing the total by
            // the total number of days in the month
            tempAvg = ((tempTotal) / (startTime.dayOfMonth().getMaximumValue()));
            if (tempAvg < 100)
            {
                balanceAfterInterest -= HashTable.PENALTY_AMOUNT;
            }
            else if (tempAvg >= 3000)
            {
                if (this instanceof CheckingAccount)
                    balanceAfterInterest += (balanceAfterInterest * HashTable.CHECKING_RATE_OVER_3000);
                else
                    balanceAfterInterest += (balanceAfterInterest * HashTable.SAVINGS_RATE_OVER_3000);
            }
            else if (tempAvg >= 2000 && tempAvg < 3000)
            {
                if (this instanceof CheckingAccount)
                    balanceAfterInterest += (balanceAfterInterest * HashTable.CHECKING_RATE_2000_TO_3000);
                else
                    balanceAfterInterest += (balanceAfterInterest * HashTable.SAVINGS_RATE_2000_TO_3000);
            }
            else if (tempAvg >= 1000 && tempAvg < 2000)
            {
                if (this instanceof CheckingAccount)
                    balanceAfterInterest += (balanceAfterInterest * HashTable.CHECKING_RATE_1000_TO_2000);
                else
                    balanceAfterInterest += (balanceAfterInterest * HashTable.SAVINGS_RATE_1000_TO_2000);
            }
            tempTotal = 0;
            // Advances the month by 1
            DateTime newStartTime = startTime.withMonthOfYear((startTime.getMonthOfYear() + 1) % HashTable.MAX_MONTHS);
            // Sets the day to the first of the month
            newStartTime = newStartTime.withDayOfMonth(1);
            // Now start time is equal to the first of the next month
            startTime = newStartTime;
        }
        return balanceAfterInterest;
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

    public double getThisMonthsDailyTotals()
    {
        return thisMonthsDailyTotals;
    }

    public void setThisMonthsDailyTotals(double thisMonthsDailyTotals)
    {
        this.thisMonthsDailyTotals = thisMonthsDailyTotals;
    }

}
