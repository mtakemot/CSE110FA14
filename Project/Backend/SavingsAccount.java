package Backend;

import java.util.Calendar;

/****************************************************************************

                                                        Ryan Bridges
                                                        CSE 110, Fall 2014
                                          Last Updated: October 19, 2014

                                Team 42

File Name:      SavingsAccount.java
Description:    This file extends BankAccount and will be the object that is
                created every time a user wants to create a new savings
                account. This type of BankAccount WILL gain interest and
                lose funds as a result of not having a high enough balance.
TODO:           Implement functions that will add interest or subtract funds
                based on the balance and the age of the account
 ****************************************************************************/
public class SavingsAccount extends BankAccount
{
    public SavingsAccount() { }
    public SavingsAccount(String name)
    {
        this.accountName = name;
        creationDate = Calendar.getInstance();
    }
    public SavingsAccount(double bal, String name)
    {
        this.balance = bal;
        this.accountName = name;
        this.accountType = "Saving";
    }
}
