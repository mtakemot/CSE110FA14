package BackendTests;

import LogicLayer.CheckingAccount;
import org.joda.time.DateTimeUtils;
import org.junit.*;
import static org.junit.Assert.*;


/**
 * **************************************************************************
 *
 * Tahereh Masoumi CSE 110, Fall 2014 Last Updated: Nov 30, 2014
 * 
 * Team 42
 *
 * File Name: checkingAccountTest.java Description: This class tests the
 * functionality of checkingAccount class which is also similar to savingAccount
 * class.
 * **************************************************************************
 */

public class CheckingAccountTest
{

    CheckingAccount instance;       //A User Account to manipulate for testing

    @Before
    public void setUp()
    {

        //Initialization of a user account available to use in tests
        instance = new CheckingAccount();
    }

    @After
    public void tearDown()
    {
    }

    /**
     * ===Test 1 of addToBalance method, of class CheckingAccount=== general
     * tests for depositing amount to a checking account, tests if balance
     * reflects deposits correctly
     */
    @Test
    public void testAddToBalance_General()
    {
        instance.setBalance(0);
        
        /*tests if the correct amount are added to the instance of checking
        account  
        */
        for (int i = 1; i < 10; i++)
        {
            double expResult = instance.getBalance() + (i * 10);
            instance.addToBalance(i * 10);
            double result = instance.getBalance();
            assertEquals(expResult, result, .001);
        }
    }

    /**
     * ===Test 2 of addToBalance method, of class CheckingAccount=== testing
     * depositing amounts < 10000 limit
     */
    @Test
    public void testAddToBalance_DepositlessThanDailyLimit()
    {
        instance.setBalance(0);
        //adds $5000 to the instance checkingAccount
        boolean res1 = instance.addToBalance(5000);
        boolean exp1 = true;
        assertEquals(exp1, res1);
    }

    /**
     * ===Test 3 of addToBalance method, of class CheckingAccount=== testing
     * edge case: $10000 balance
     */
    @Test
    public void testAddToBalance_DepositEqualToDailyLimit()
    {
        boolean res2 = instance.addToBalance(10000);
        boolean exp2 = true;
        assertEquals(exp2, res2);
    }

    /**
     * ===Test 4 of addToBalance method, of class CheckingAccount=== testing
     * depositing more than $10000 in a day
     */
    @Test
    public void testAddToBalance_DepositMoreThanDailyLimit()
    {  
        //tries to add $15000 to the account which is more than daily limit
        boolean res3 = instance.addToBalance(15000);
        boolean exp3 = false;
        assertEquals(exp3, res3);
    }

    /**
     * ===Test 4 of addToBalance method, of class CheckingAccount=== testing
     * depositing more than $10000 in a 2-day period
     */
    @Test
    public void testAddToBalance_DepositMoreThanLimit2DaysPeriod()
    {
        DateTimeUtils.setCurrentMillisOffset(0);

        instance.addToBalance(9000);

        //changing current time to one day after actual time
        DateTimeUtils.setCurrentMillisOffset(100000000);

        boolean res4 = instance.addToBalance(5000);
        boolean exp4 = true;
        //tests if the daily account limit has been reset in each day
        assertEquals(exp4, res4);
    }

    /**
     * ===Test 5 of addToBalance method, of class CheckingAccount=== testing
     * depositing more than $10000 in a period more than 2 days
     */
    @Test
    public void testAddToBalance_DepositMoreThanLimitSeveralDaysPeriod()
    {
        instance.addToBalance(6000);
        //changes the time to 1 month after deposit time
        DateTimeUtils.setCurrentMillisOffset(200000000);
        boolean res5 = instance.addToBalance(5000);
        boolean exp5 = true;
        assertEquals(exp5, res5);

    }

    /**
     * ===Test 1 of subFromeBalance method, of class CheckingAccount=== tests
     * the withdraw of an amount more than balance
     */
    @Test
    public void testSubFromBalance_DebitmMoreThanBalance()
    {
        instance.setBalance(0);
        boolean expResult1 = false;
        //tries to withdraw more than balance
        boolean result1 = instance.subFromBalance(200);
        assertEquals(expResult1, result1);
    }

    /**
     * ===Test 2 of subFromeBalance method, of class CheckingAccount=== tests
     * the withdraw of an amount less than daily limit
     */
    @Test
    public void testSubFromBalance_DebitLessThanDailyLimit()
    {
        instance.setBalance(20000);
        boolean expResult2 = true;
        //withdraws below daily limit
        boolean result2 = instance.subFromBalance(5000);
        assertEquals(expResult2, result2);
    }

    /**
     * ===Test 3 of subFromeBalance method, of class CheckingAccount=== tests
     * the withdraw of an amount equal to daily limit
     */
    @Test
    public void testSubFromBalance_debitEqualToDailyLimit()
    {
        instance.setBalance(20000);
        boolean expResult3 = true;
        //withdraws equal to daily limit
        boolean result3 = instance.subFromBalance(10000);
        assertEquals(expResult3, result3);
    }

    /**
     * ===Test 4 of subFromeBalance method, of class CheckingAccount=== tests
     * the withdraw of an amount more than daily limit
     */
    @Test
    public void testSubFromBalance_debitMoreThanDailyLimit()
    {
        boolean expResult4 = false;
        //tries to withdraw more than daily limit
        boolean result4 = instance.subFromBalance(5000);
        assertEquals(expResult4, result4);
    }

    /**
     * ===Test 5 of subFromeBalance method, of class CheckingAccount=== tests
     * the withdraw of an amount more than daily limit in multiple days period
     */
    @Test
    public void testSubFromBalance_debitMoreThanLimitInMultipleDays()
    {
        //return the time to the actual time
        DateTimeUtils.setCurrentMillisOffset(0);

        instance.setBalance(20000);
        instance.subFromBalance(5000);
        //changes the time to one day afer deposit time
        DateTimeUtils.setCurrentMillisOffset(100000000);

        boolean expResult5 = true;
        boolean result5 = instance.subFromBalance(6000);
        assertEquals(expResult5, result5);
    }

}
