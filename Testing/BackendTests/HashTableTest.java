package BackendTests;

import LogicLayer.HashTable;
import LogicLayer.UserAccount;
import org.junit.*;
import static org.junit.Assert.*;

/** @author Nishat rustagi
 * Wrote and modified the following tests for 
 * 1. Insert User Account
 * 2. Reinserting User Accounts
 * 3. Finding User Accounts
 * 4. Deleting User Accounts
 * 
 *  @author Tahereh Masoumi Last Updated Nov. 30 2014
 *  Wrote the test for finding out the user account by email. 
 */



public class HashTableTest
{
    /** The following is a test for checking if the insertion 
     * of user account works successfully. 
     * We create and insert 1000 user accounts,each with different userNames, and then add them
     * to the hashtable. Finally we check if all the data fields - first name, last name, user name,
     * password, phone, email and number of bank accounts - match. And thus 
     * affirming that our method worked successfully. 
     */
    @Test
    public void testInsertUserAccount()
    {
        System.out.println("insertUserAccount");
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

    /** The following is a test for making sure there are no duplicate inserts.
     * We do this by first inserting 10000 user accounts in to the hashtable and then 
     * try reinserting them again at the same index values. 
     */
    @Test
    public void testInsertUserAccount_reinsert()
    {
        System.out.println("insertUserAccount");
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

    /** The following is a test for checking if findUserAccount works successfully. 
     * First we want to make sure that 
     * there is no duplicate inserts. We then check if the username and the password match. 
     * by using the findUserAccount function to make sure 
     * the retrieval happened successfully. 
     */
    @Test
    public void testFindUserAccount()

    {
        System.out.println("FindUserAccount");
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

    /** The following test is for checking if the deletion operation
     * for the bank account works fine. First we want to make sure that 
     * there is no duplicate inserts. And then use the deleteUserAccount function to make sure 
     * deletion happened successfully. 
     */
    @Test
    public void testDeleteUserAccount()
    {

        System.out.println("RemovingUserAccount");
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

        //deleting useraccounts and checking if the deletion happened successfully.
        for (int i = 0; i < 10000; i++)
        {
            assertTrue(testTable.deleteUserAccount(testString + i));
        }

    }

    /** The following is a test for checking if we can find the user account with the given email. 
     * First we want to make sure that 
     * there is no duplicate inserts. We then check if the username and the email match,
     * by using the findUserAccountEmail function to make sure 
     * the retrieval happened successfully. 
     */
    @Test
    public void testFindUserAccountByEmail()

    {
        System.out.println("Find UserAccount by Email");
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
