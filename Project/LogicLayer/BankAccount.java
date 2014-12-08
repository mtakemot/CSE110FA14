package LogicLayer;

import java.io.Serializable;
import static java.lang.Math.abs;
import java.text.SimpleDateFormat;
import java.util.*;
import org.joda.time.*;
import org.joda.time.format.*;

/**
 * **************************************************************************
 *
 * Ryan Bridges CSE 110, Fall 2014 Last Updated: December 1, 2014
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

    //BankAccount class members
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
    // Allows us to format dates so they look nice for the user
    public static DateTimeFormatter dtf = DateTimeFormat.forPattern("MM/dd/yyyy");
    // Allows us to format time so they look nice for the user
    public static DateTimeFormatter timeFormatter = DateTimeFormat.forPattern("HH:mm:ss a");
    // Ordered set to hold all of this Bank Account's transactions.
    // Will be sorrted by date.
    protected List<Transaction> transactions;

    /**
     * BankAccount class constructor. It instantiates the member fields for each
     * new BankAccount objects created.
     */
    public BankAccount()
    {
        DateTime currentTime = new DateTime();
        this.lastDepositDateTime = currentTime;
        this.lastWithdrawDateTime = currentTime;

        this.dayWithdrawAmount = 0;
        this.dayDepositAmount = 0;

        transactions = new ArrayList<Transaction>();
    }

    /**
     * The following 2 methods are the super class methods that will
     * respectively add or subtract a double amount from the bank account's
     * current balance. They will be overridden SavingsAccount.java and
     * CheckingAccount.java
     */
    public boolean subFromBalance(double amount)
    {
        return false;
    }

    public boolean addToBalance(double amount)
    {
        return false;
    }

    // The below 2 methods will be called when interest or penalties are
    // applied to any bank account so that an accurate transaction will appear
    // in the transaction history
    public void addInterest(double amount)
    {
        //updating balance
        this.balance += amount;
        this.getTransactions().add(new Transaction("Add Interest", amount));
    }

    public void subPenalty(double amount)
    {
        //updating balance
        this.balance -= amount;
        this.getTransactions().add(new Transaction("Penalty", amount));
    }

    /**
     * Call this function to calculate what the user's interest will be at a
     * certain date in the future.
     *
     * @param interestDate A DateTime object that represents the date that the
     * user wants to know his interest on.
     * @return the user's balance after a set amount of time
     */
    public double getInterestCustomer(DateTime interestDate)
    {
        DateTime startTime = new DateTime();
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
                balanceAfterInterest -= HashTable.PENALTY_AMOUNT; //update balance after deducting penalty
            }
            else if (tempAvg >= 3000)
            {
                //update balance after adding cheking interest
                if (this instanceof CheckingAccount)
                    balanceAfterInterest += (balanceAfterInterest * HashTable.CHECKING_RATE_OVER_3000);
                //update balance after adding savings interest
                else
                    balanceAfterInterest += (balanceAfterInterest * HashTable.SAVINGS_RATE_OVER_3000);
            }
            else if (tempAvg >= 2000 && tempAvg < 3000)
            {
                //update balance after adding cheking interest
                if (this instanceof CheckingAccount)
                    balanceAfterInterest += (balanceAfterInterest * HashTable.CHECKING_RATE_2000_TO_3000);
                //update balance after adding savings interest
                else
                    balanceAfterInterest += (balanceAfterInterest * HashTable.SAVINGS_RATE_2000_TO_3000);
            }
            else if (tempAvg >= 1000 && tempAvg < 2000)
            {
                //update balance after adding cheking interest
                if (this instanceof CheckingAccount)
                    balanceAfterInterest += (balanceAfterInterest * HashTable.CHECKING_RATE_1000_TO_2000);
                //update balance after adding savings interest
                else
                    balanceAfterInterest += (balanceAfterInterest * HashTable.SAVINGS_RATE_1000_TO_2000);
            }
            tempTotal = 0;
            // Advances the month by 1
            DateTime newStartTime = startTime.withMonthOfYear((startTime.plusMonths(1).getMonthOfYear()));
            // Sets the day to the first of the month
            newStartTime = newStartTime.withDayOfMonth(1);
            // Now start time is equal to the first of the next month
            startTime = newStartTime;
        }
        return balanceAfterInterest;
    }

    public void addTransaction(String transType, double transAmount)
    {
        this.transactions.add(new Transaction(transType, transAmount));
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

    public List<Transaction> getTransactions()
    {
        return transactions;
    }

}
