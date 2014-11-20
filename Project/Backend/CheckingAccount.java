package Backend;

/****************************************************************************

                                                        Ryan Bridges
                                                        CSE 110, Fall 2014
                                          Last Updated: October 19, 2014

                                Team 42

File Name:      CheckingAccount.java
Description:    This file extends BankAccount and will be the object that is
                created every time a user wants to create a new checking
                account. This type of BankAccount WILL NOT gain interest or
                lose funds as a result of not having a high enough balance.
 ****************************************************************************/
public class CheckingAccount extends BankAccount
{
    public CheckingAccount() { }
    public CheckingAccount(String name)
    {
        this.accountName = name;
    }
    public CheckingAccount(double bal, String name)
    {
        this.balance = bal;
        this.accountName = name;
        this.accountType = "Checking";
    }
}
