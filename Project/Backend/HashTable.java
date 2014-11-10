package Backend;


import Backend.BankAccount;
import java.io.Serializable;

/**
 * **************************************************************************
 *
 * Ryan Bridges CSE 110, Fall 2014 Last Updated: October 19, 2014
 *
 * Team 42
 *
 * File Name: HashTable.java Description: This file is contains the
 * implementation for the master Hash Table which will hold all user accounts.
 * Each bucket in the Hash Table will hold a linked list of UserAccounts.
 * **************************************************************************
 */
public class HashTable implements Serializable
{

    // Chose a prime number for the size of the table for more efficient hashing
    private final static int SIZE = 251;
    public int occ; // Total number of UserAccounts that the table is holding
    UserAccount[] Table; // The hash table

    // Constructor for the HashTable creates an array of size SIZE and
    // initializes every element in the array to null. Also initializes occ
    public HashTable()
    {
        this.occ = 0;
        Table = new UserAccount[SIZE];
        for (int zod = 0; zod < SIZE; zod++)
        {
            Table[zod] = null;
        }
    }

    /**
     * This function will insert a new UserAccount into the table
     *
     * @method insertUserAccount
     * @param userName The UserAccount to be inserted
     * @return Returns the inserted UserAccount if insertion was successful.
     * Returns null if UserAccount with the given userName is found.
     */
    public UserAccount insertUserAccount(String userName)
    {
        int index = hashCode(userName) % SIZE;
        // The bucket at index is not currently occupied, so we insert at
        // Table[index]
        if (Table[index] == null)
        {
            Table[index] = new UserAccount(userName);
            Table[index].setLocation(index);
            this.occ++;
            return Table[index];
        }
        else // The bucket at index is occupied, so we insert into the linked
            // list of UserAccounts that the bucket is holding
        {
            UserAccount current;
            current = Table[index];
            // Traverse the linked list to find the insertion point
            while (current.getNext() != null
                    && !((current.getUserName()).equals(userName)))
            {
                current = current.getNext();
            }
            // Will return false if the userName is already in use
            // Prompt the user to enter a different userName in main
            // and then call insert again if this happens.
            if (current.getUserName().equals(userName))
                return null;
            else // The end of the linked list was reached.
                // This means that the userName that was entered is not in use
                // so we insert here.
            {
                current.setNext(new UserAccount(userName));
                current.getNext().setLocation(index);
                this.occ++;
                return current.getNext();
            }
        }

    }

    // When a user attempts to log in, this function will be called to see
    // if the username that they entered exists. If it does, then the
    // UserAccount that is associated with that username will be returned and
    // the password will be verified.
    /**
     * Attempts to find a UserAccount in the HashTable.
     *
     * @method findUserAccount
     * @param userName The UserAccount to be found identified by the userName
     * @return Returns true if found. Returns false if not found
     */
    public UserAccount findUserAccount(String userName)
    {
        int index = hashCode(userName) % SIZE;
        // The bucket at index was empty so the UserAccount was not found
        if (Table[index] == null)
            return null;
        else // The bucket at index was not null, so we traverse the linked list
            // of UserAccounts inside the bucket and look for the UserAccount
        {
            UserAccount current = Table[index];
            // Traverse the linked list until the UserAccount is found or we
            // reach the end of the linked list
            while (current != null && !((current.getUserName()).equals(userName)))
            {
                current = current.getNext();
            }
            // We reached the end of the linked list and the UserAccount
            // was not found
            if (current == null)
                return null;
            else // The UserAccount was found
                return current;
        }
    }

    /**
     * This function will delete a UserAccount from the HashTable
     *
     * @method deleteUserAccount
     * @param userName The userName that corresponds to the UserAccount to be
     * deleted
     * @return Returns true if deletion was successful, false if not successful
     */
    public boolean deleteUserAccount(String userName)
    {
        int index = hashCode(userName);
        if (Table[index] != null)
        {
            // Keep track of the previous UserAccount in the list
            UserAccount prev = null;
            UserAccount current = Table[index];
            // Traverse the linked list inside of the bucket until the UserAccount
            // is found or we reach the end of the linked list
            while (current.getNext() != null
                    && !(current.getUserName().equals(userName)))
            {
                prev = current;
                current = current.getNext();
            }
            if (current.getUserName().equals(userName)) // The UserAccount was found
            {
                // The UserAccount is not the head of the linked list
                if (prev != null)
                    prev.setNext(current.getNext());
                else // Remove the head of the linked list inside of the bucket
                    Table[index] = current.getNext();
                return true;
            }
        }
        // The bucket at index was empty so the UserAccount was not found
        return false;
    }

    /**
     * This is an algorithm for determining the hashcode of a given userName. It
     * will add up the sum of the ASCII codes of each individual character in
     * the String that is passed in. Then it will bit shift the sum left 2. Then
     * it will XOR the bitshifted value with the original sum of the ACSII
     * values.
     *
     * @param userName The String to get the hashcode of
     * @method hashCode
     * @return returns the hashCode which will be % with the table size to find
     * the insertion point of the element.
     */
    public int hashCode(String userName)
    {
        int hashValue = 0;
        // Add up the ASCII codes
        for (int zod = 0; zod < userName.length(); zod++)
        {
            hashValue = userName.charAt(zod) + hashValue;
        }
        // Perform bitshift
        int shiftedHash = hashValue << 2;
        // XOR the bitshifted value with the original value
        return (shiftedHash ^ hashValue);
    }

    /**
     * This function will transfer funds between two BankAccounts
     * @method transferFunds
     * @param  sendFunds     This is the UserAccount which contains the
     *                       BankAccount that the funds will be sent from
     * @param  receiveFunds  This is the userName of the UserAccount which
     *                       contains the BankAccount that will receive funds
     * @param  fromAcc       This is the name of the BankAccount which will
     *                       have its balance subtracted from to send to another
     *                       account
     * @param  toAcc         This is the name of the BankAccount which will
     *                       have its balance added to and will receive funds
     * @param  amount        The amount of money to send
     * @return               Returns true if the transfer was successful.
     *                       Returns false if one of the accounts does not
     *                       exist or if subtracting funds from fromAcc would
     *                       result in a negative balance.
     */
    public boolean transferFunds(UserAccount sendFunds, String receiveFunds,
                                 String fromAcc, String toAcc, double amount)
    {
        // UserAccount which contains the BankAccount that will
        // be receiving funds
        UserAccount recUA;
        // BankAccount which will be recieving funds
        BankAccount recBA;
        // BankAccount which will be sending funds
        BankAccount sendBA;
        // Make sure that the sender's UserAccount exists.
        if (sendFunds != null)
        {
            // Find the UserAccount which contains the BankAccount that will
            // be receiving funds
            recUA = this.findUserAccount(receiveFunds);
            if (recUA != null) // Make sure the UserAccount exists
            {
                // Find the BankAccount to send funds to
                recBA = recUA.findBankAccount(toAcc);
                // The recieving UserAccount does not exits. Return false
                if (recBA != null)
                {
                    // Find the BankAccount that will be sending funds
                    sendBA = sendFunds.findBankAccount(fromAcc);
                    if (sendBA != null)
                    {
                        // Check if subtracting funds will result in a negative
                        // balance
                        if (sendBA.subFromBalance(amount))
                        {
                            // Add funds to the receiver's BankAccount
                            recBA.addToBalance(amount);
                            return true;
                        }
                    }
                }
            }
        }
        return false;

    }
}
