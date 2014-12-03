package LogicLayer;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import java.io.Serializable;

public class Transaction implements Comparable<Transaction>, Serializable
{

    // Type of transaction
    private String transType;
    // Amount of transaction
    private double transAmount;
    // Time that the transaction took place
    private DateTime transTime;

    public Transaction(String transType, double transAmount)
    {
        this.transType = transType;
        this.transAmount = transAmount;
        this.transTime = new DateTime();
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

    public DateTime getTransTime()
    {
        return transTime;
    }

    public void setTransTime(DateTime transTime)
    {
        this.transTime = transTime;
    }
}
