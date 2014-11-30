package LogicLayer;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

public class Transaction
{

    private String transType;

    private double transAmount;

    private DateTime transTime;

    public Transaction(String transType, double transAmount)
    {
        transType = this.transType;
        transAmount = this.transAmount;
        transTime = new DateTime(DateTimeZone.forID("Etc/UTC"));
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
