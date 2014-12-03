package LogicLayer;

import org.joda.time.*;
import java.io.Serializable;

public class Transaction implements Comparable<Transaction>, Serializable
{

    // Type of transaction
    private String transType;
    // Amount of transaction
    private double transAmount;
    // Time that the transaction took place
    private LocalDateTime transTime;

    public Transaction(String transType, double transAmount)
    {
        this.transType = transType;
        this.transAmount = transAmount;
        this.transTime = new LocalDateTime();
    }

    @Override
    public int compareTo(Transaction t)
    {
        return (t.getTransTime().compareTo(this.getTransTime()));
    }

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
