/****************************************************************************

                                                        Ryan Bridges
                                                        CSE 110, Fall 2014
                                          Last Updated: October 17, 2014

                                Team 42

File Name:      BankAccount.java
Description:    This is the super class for the different types of
                BankAccounts that the user can create. It contains basic
                information about the bank account. It also contains a next
                field which will hold the next BankAccount owned by the user.
 ****************************************************************************/
public class BankAccount
{
    protected double balance;
    protected String accountName;
    protected BankAccount next;
    protected String accountType;

    /**
     * This function will add to the account balance
     * @method addToBalance
     * @param  amount       this is the amount to add to the balance
     * @return              returns the new account balance
     */
    public double addToBalance(double amount)
    {
        this.balance += amount;
        return this.balance;
    }

    /**
     * This function will subtract from the account balance, but will not allow
     * the account balance to go below 0
     * @method subFromBalance
     * @param  amount         amount to subtrace from the balance
     * @return                returns the new account balance
     */
    public boolean subFromBalance(double amount)
    {
        if (this.balance - amount < 0)
        {
            System.out.print("This amount cannot be withdrawn ");
            System.out.println("because the new balance will be negative.");
            return false;
        }
        else
        {
            this.balance -= amount;
            return true;
        }
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


}
