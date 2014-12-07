package LogicLayer;

import org.joda.time.*;
import java.io.Serializable;

/**
 * **************************************************************************
 *
 * Ryan Bridges CSE 110, Fall 2014 Last Updated: December 6, 2014
 *
 * Team 42
 *
 * File Name: Transaction.java defines a Transaction object for BankAccounts.
 * This will allow us to display the Transaction History for each account. Each
 * Transaction has a type, a date, a time and an amount
 * **************************************************************************
 */
public class Transaction implements Comparable<Transaction>, Serializable
{

    // Type of transaction
    private String transType;
    // Amount of transaction
    private double transAmount;
    // Time that the transaction took place
    private LocalDateTime transTime;

    // Basic ctor
    public Transaction(String transType, double transAmount)
    {
        this.transType = transType;
        this.transAmount = transAmount;
        // Grabs the current time
        this.transTime = new LocalDateTime();
    }

    // Allows transactions to be sorted by date
    @Override
    public int compareTo(Transaction t)
    {
        return (t.getTransTime().compareTo(this.getTransTime()));
    }

    /////////////////////////////////////////
    // BELOW ARE JUST SETTERS AND GETTERS ///
    /////////////////////////////////////////
    public String getTransType()
    {
        return transType;
    }

    public void setTransType(String transType)
    {
        this.transType = transType;
    }

    public double getTransAmount()
    {
        return transAmount;
    }

    public void setTransAmount(double transAmount)
    {
        this.transAmount = transAmount;
    }

    public LocalDateTime getTransTime()
    {
        return transTime;
    }

    public void setTransTime(LocalDateTime transTime)
    {
        this.transTime = transTime;
    }
}
