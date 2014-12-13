package BackendTests;

import LogicLayer.BankAccount;
import LogicLayer.CheckingAccount;
import LogicLayer.SavingsAccount;
import LogicLayer.UserAccount;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * **************************************************************************
 *
 *  Zachary Preece-Scaringe CSE 110, Fall 2014 Last Updated: Nov 3, 2014
 * 
 * Team 42
 *
 * File Name: UserAccountTest.java Description: This file is contains tests for 
 * UserAccount class functions including insertBankAccount, findBankAccount,
 * and validatePassword.
 * **************************************************************************
 */
public class UserAccountTest
{

    UserAccount instance;       //A User Account to manipulate for testing

    @Before
    public void setUp()
    {

        //Initialization of a user account available to use in tests
        instance = new UserAccount();
    }

    @After
    public void tearDown()
    {
    }

    /**
     * ===Test of validatePassword method, of class UserAccount=== tests the
     * validation of an empty password
     */
    @Test
    public void testValidatePassword_empty()
    {
        String pass = "";
        instance = new UserAccount("first", "last", "user", "", "email", "phone", 1);
        boolean expResult = true;
        boolean result = instance.validatePassword(pass);
        assertEquals(expResult, result);
    }

    /**
     * ===Test 2 of validatePassword method, of class UserAccount=== tests the
     * validation of a long password including all numbers and letters
     */
    @Test
    public void testValidatePassword_long()
    {
        String pass = "0123456789abcdefghijklmnopqrstuvwxyz";
        instance = new UserAccount("first", "last", "user",
                "0123456789abcdefghijklmnopqrstuvwxyz", "email", "phone", 1);
        boolean expResult = true;
        boolean result = instance.validatePassword(pass);
        assertEquals(expResult, result);
    }

    /**
     * ===Test of insertBankAccount method, of class UserAccount=== Tests
     * inserting 100 Checking accounts
     */
    @Test
    public void testInsertBankAccount_Checking()
    {

        String name = "c_test1";
        String type = "Checking";

        //create and insert 10000 checking accounts
        for (int i = 0; i < 10000; i++)
        {

            BankAccount expResult = new CheckingAccount(i, name + i);
            BankAccount result = instance.insertBankAccount(i, name + i, type);

            //check to see if every field matches
            assertEquals(expResult.getAccountName(), result.getAccountName());
            assertEquals(expResult.getBalance(), result.getBalance(), 0);
            assertEquals(expResult.getNext(), result.getNext());
            assertEquals(expResult.getAccountType(), result.getAccountType());
        }
    }

    /**
     * ===Test of insertBankAccount method, of class UserAccount=== Tests
     * inserting 100 Savings accounts.
     */
    @Test
    public void testInsertBankAccount_Savings()
    {

        String name = "s_test";
        String type = "Savings";

        for (int i = 0; i < 10000; i++)
        {

            BankAccount expResult = new SavingsAccount(i, name + i);
            BankAccount result = instance.insertBankAccount(i, name + i, type);

            assertEquals(expResult.getAccountName(), result.getAccountName());
            assertEquals(expResult.getBalance(), result.getBalance(), 0);
            assertEquals(expResult.getNext(), result.getNext());
            assertEquals(expResult.getAccountType(), result.getAccountType());
        }
    }

    /**
     * ===Test of insertBankAccount method, of class UserAccount=== Tests
     * reinsertion of 100 Savings accounts.
     */
    @Test
    public void testInsertBankAccount_Savings_reinsert()
    {

        String name = "s_test";
        String type = "Savings";

        //insert 100 Savings accounts
        for (int i = 0; i < 10000; i++)
        {
            instance.insertBankAccount(i, name + i, type);
        }

        //reinsert the accounts
        for (int i = 0; i < 10000; i++)
        {
            BankAccount result = instance.insertBankAccount(i, name + i, type);
            assertEquals(result, null);
        }
    }

    /**
     * ===Test of insertBankAccount method, of class UserAccount=== Tests
     * reinsertion of 100 Checking accounts.
     */
    @Test
    public void testInsertBankAccount_Checking_reinsert()
    {

        String name = "c_test";
        String type = "Checking";

        //insert 100 Checking accounts
        for (int i = 0; i < 10000; i++)
        {
            instance.insertBankAccount(i, name + i, type);
        }

        //reinsert the accounts
        for (int i = 0; i < 10000; i++)
        {
            BankAccount result = instance.insertBankAccount(i, name + i, type);
            assertEquals(result, null);
        }
    }

    /**
     * ===Test of findBankAccount method, of class UserAccount=== tests
     * accurately finding 100 Checking accounts and 100 Savings accounts
     */
    @Test
    public void testFindBankAccount()
    {
        String name = "find_test";
        String name2 = "duplicates_test";

        // Make sure duplicate inserts return null
        instance.insertBankAccount(0, name2, "Checking");
        for (int i = 0; i < 10000; i++)
        {
            BankAccount expResult = null;
            BankAccount result = instance.insertBankAccount(0, name2, "Checking");
            assertEquals(expResult, result);
        }

        // add 10000 bank accounts and 10000 checking accounts
        // The number in "name + number + i" on the second line of this loop
        // has to be the same as the upper bound for i.
        // Before, I had the upper bound for i at 10000 while 'number' on the
        // second line was 100. That wouldn't work because then only 100 savings
        // accounts were being inserted instead of 10000.
        for (int i = 0; i < 10000; i++)
        {
            instance.insertBankAccount(i, name + i, "Checking");
            instance.insertBankAccount(i, name + 10000 + i, "Savings");
        }

        //check name and balance fields for checking accounts to see if found
        //accounts match
        for (int i = 0; i < 10000; i++)
        {
            BankAccount expResult = new CheckingAccount(i, name + i);
            BankAccount result = instance.findBankAccount(name + i);
            assertEquals(expResult.getAccountName(), result.getAccountName());
            assertEquals(expResult.getBalance(), result.getBalance(), 0);
        }

        //check name and balance fields of savings accounts to see if found
        //accounts match
        for (int i = 0; i < 10000; i++)
        {
            BankAccount expResult2 = new SavingsAccount(i, name + 10000 + i);
            BankAccount result2 = instance.findBankAccount(name + 10000 + i);
            assertEquals(expResult2.getAccountName(), result2.getAccountName());
            assertEquals(expResult2.getBalance(), result2.getBalance(), 0);
        }
    }
}
