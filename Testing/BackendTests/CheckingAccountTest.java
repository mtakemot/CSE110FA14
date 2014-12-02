package BackendTests;

import LogicLayer.BankAccount;
import LogicLayer.CheckingAccount;
import LogicLayer.SavingsAccount;
import LogicLayer.UserAccount;
import org.joda.time.DateTime;
import org.joda.time.DateTimeUtils;
import org.joda.time.DateTimeZone;
import static org.joda.time.Duration.millis;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Tahereh Masoumi This class tests the CheckingAccount class
 * functionality.
 *
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
        System.out.println("Balance reflects deposits");

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
        System.out.println("Daily depositing less than $10000 daily limit");
        instance.setBalance(0);
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
        System.out.println("Daily depositing equal to $10000 daily limit");
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
        System.out.println("Daily depositing more than $10000 daily limit");
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
        System.out.println("balance after 9000 deposit in one day");

        //changing current time to one day after actual time
        DateTimeUtils.setCurrentMillisOffset(100000000);

        boolean res4 = instance.addToBalance(5000);

        System.out.println("balance after 5000 deposit in next day");

        boolean exp4 = true;
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
        DateTimeUtils.setCurrentMillisOffset(200000000);
        System.out.println("depositing more than $10000 in several-days period ");
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
        System.out.println("Debit more than balance");
        boolean expResult1 = false;
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
        System.out.println("Debit less than $10000 daily limit");
        boolean expResult2 = true;
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
        System.out.println("Debit equal to $10000 daily limit");
        boolean expResult3 = true;
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
        System.out.println("Debit more than $10000 daily limit");
        boolean expResult4 = false;
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
        DateTimeUtils.setCurrentMillisOffset(0);

        instance.setBalance(20000);
        System.out.println("Debit more than $10000 in multiple days period ");
        instance.subFromBalance(5000);
        DateTimeUtils.setCurrentMillisOffset(100000000);

        boolean expResult5 = true;
        boolean result5 = instance.subFromBalance(6000);
        assertEquals(expResult5, result5);
    }

}
