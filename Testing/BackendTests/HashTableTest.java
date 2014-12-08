package BackendTests;

import LogicLayer.HashTable;
import LogicLayer.UserAccount;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Nishat rustagi Wrote and modified the following tests for 1. Insert
 * User Account 2. Reinserting User Accounts 3. Finding User Accounts 4.
 * Deleting User Accounts
 *
 *
 * @author Tahereh Masoumi Last Updated Nov. 30 2014
 */
public class HashTableTest
{

    @Test
    public void testInsertUserAccount()
    {
        ////System.out.println("insertUserAccount");
        HashTable testTable = new HashTable();

        String testString = "testUserName";

        //create and insert 10000 UserAccounts
        for (int i = 0; i < 1000; i++)
        {

            // creating 10000 test userAccounts each with different userName
            UserAccount testAccount = new UserAccount(testString + i);
            testAccount.setEmail("email" + i);

            //Adding the 10000 userAccounts to the HashTable
            UserAccount result = testTable.insertUserAccount(testString + i, "email" + i);

            //check to see if every field matches
            assertEquals(testAccount.getFirstName(), result.getFirstName());
            assertEquals(testAccount.getLastName(), result.getLastName());
            assertEquals(testAccount.getUserName(), result.getUserName());
            assertEquals(testAccount.getPassword(), result.getPassword());
            assertEquals(testAccount.getPhone(), result.getPhone());
            assertEquals(testAccount.getEmail(), result.getEmail());
            assertEquals(2, result.getNumOfBankAccounts());
        }
    }

    @Test
    public void testInsertUserAccount_reinsert()
    {
       // //System.out.println("insertUserAccount");
        HashTable testTable = new HashTable();
        String testString = "testUserName";

        //inserting 10000 user accounts into the hashtable
        for (int i = 0; i < 10000; i++)
        {
            testTable.insertUserAccount(testString + i, "email" + i);
        }

        //reinsert the accounts to check for duplicate accounts
        for (int i = 0; i < 10000; i++)
        {
            UserAccount result = testTable.insertUserAccount(testString + i, "email" + i);
            assertEquals(result, null);
        }
    }

    @Test
    public void testFindUserAccount()

    {
      //  //System.out.println("FindUserAccount");
        HashTable testTable = new HashTable();
        String testString = "testUserName";

        //inserting 10000 user accounts into the hashtable
        for (int i = 0; i < 10000; i++)
        {
            testTable.insertUserAccount(testString + i, "email" + i);
        }

        // Making sure duplicate inserts return null
        for (int i = 0; i < 10000; i++)
        {
            UserAccount check = testTable.insertUserAccount(testString + i, "email" + i);
            assertEquals(check, null);
        }

        //checking userName and password of the user accounts to see if found
        //accounts match
        for (int i = 0; i < 10000; i++)
        {
            UserAccount testAccount = new UserAccount(testString + i);
            UserAccount result = testTable.findUserAccount(testString + i);
            assertEquals(testAccount.getUserName(), result.getUserName());
        }

    }

    @Test
    public void testDeleteUserAccount()
    {

        ////System.out.println("RemovingUserAccount");
        HashTable testTable = new HashTable();
        String testString = "testUserName";

        //inserting 10000 user accounts into the hashtable
        for (int i = 0; i < 10000; i++)
        {
            testTable.insertUserAccount(testString + i, "email" + i);
        }

        // Making sure duplicate inserts return null
        for (int i = 0; i < 10000; i++)
        {
            UserAccount check = testTable.insertUserAccount(testString + i, "email" + i);
            assertEquals(check, null);
        }

        //deleting useraccounts and checking if the deletion happened correctly.
        for (int i = 0; i < 10000; i++)
        {
            assertTrue(testTable.deleteUserAccount(testString + i));
        }

    }

    @Test
    public void testFindUserAccountByEmail()

    {
       // //System.out.println("Find UserAccount by Email");
        HashTable testTable = new HashTable();
        String testString = "testUserName";

        //inserting 10000 user accounts into the hashtable
        for (int i = 0; i < 10000; i++)
        {
            testTable.insertUserAccount(testString + i, "email" + i);
        }

        // Making sure duplicate inserts return null
        for (int i = 0; i < 10000; i++)
        {
            UserAccount check = testTable.insertUserAccount(testString + i, "email" + i);
            assertEquals(check, null);
        }

        //checking userName and email of the user accounts to see if found
        //accounts match
        for (int i = 0; i < 10000; i++)
        {
            UserAccount testAccount = testTable.findUserAccount(testString + i);
            UserAccount result = testTable.findUserAccountEmail("email" + i);
            assertEquals(testAccount.getUserName(), result.getUserName());

        }

    }
}
