package LogicLayer;

import java.io.Serializable;

/**
 * **************************************************************************
 *
 * Ryan Bridges CSE 110, Fall 2014 Last Updated: October 19, 2014
 *
 * Team 42
 *
 * File Name: UserAccount.java Description: This file contains the
 * implementation for the object that will go inside of each bucket inside of
 * the master Hash Table which is defined in HashTable.java. Each UserAccount
 * will hold basic information about the user, and must have a unique userName.
 * Each UserAccount will also contain a linked list of BankAccounts which will
 * be either checking or savings. TODO: Implement a deleteBankAccount function
 * **************************************************************************
 */
public class UserAccount implements Serializable
{

    private boolean admin = false;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String email; // User's email address
    private String phone; // User's phone number
    // Will store the index where the UserAccount is stored in the HashTable
    private int location;
    // Each bucket in the Hash Table will store a linked list of
    // UserAccounts. Theis is a link to the next item in the
    //  linked list in the bucket that contains this item.
    private UserAccount next;
    // This will hold the first bank account (either checking or savings)
    // that the user owns. Each BankAccount object will have a next field which
    // will point to the user's next account.
    public BankAccount BankAccHead;
    // Keeps track of how many BankAccounts the UserAccount has. Important for
    // the table on AccountsListPage
    private int numOfBankAccounts;

    // Default constructor
    public UserAccount()
    {
    }

    // Constructor initializes basic member variables
    public UserAccount(String first, String last, String user, String pass,
            String email, String phone, int loc)
    {
        this.admin = false;
        this.firstName = first;
        this.lastName = last;
        this.userName = user;
        this.password = pass;
        this.email = email;
        this.phone = phone;
        this.location = loc;
        this.next = null;
        this.BankAccHead = null;
        numOfBankAccounts = 0;
    }

    // This constructor is for usage with the find/insert/delete functions.
    // The user will pass in a userName that they wish to operate on. Then a new
    // UserAccount can be created from the userName that the user passes in.
    public UserAccount(String name)
    {
        this.userName = name;
        numOfBankAccounts = 0;
    }

    // This will make sure that the password that the user enters when they
    // log in is correct
    public boolean validatePassword(String pass)
    {
        //System.out.println("PASS ERROR");
        return (this.password.equals(pass));
    }

    /**
     * This function will create a new bank account for the user of type
     * checking or savings depending on the user's preference. It will insert
     * the bank account into the linked list of BankAccounts inside of the
     * UserAccount
     *
     * @method insertBankAccount
     * @param bal Balance of the account
     * @param name name of the account
     * @param type type of account, either checking or savings
     * @return Returns the BankAccount that was inserted or null if a
     * BankAccount with the same name already exists under this user
     */
    public BankAccount insertBankAccount(double bal, String name, String type)
    {
        // If the head of the linked list that hold BankAccount is null, then
        // we insert the new BankAccount at the head.
        if (BankAccHead == null)
        {
            // Create a CheckingAccount
            if (type.equals("Checking"))
            {
                BankAccHead = new CheckingAccount(bal, name);
                numOfBankAccounts++;
                BankAccHead.setAccountPosition(0);
                return BankAccHead;
            }
            // Create a SavingsAccount
            else
            {
                BankAccHead = new SavingsAccount(bal, name);
                numOfBankAccounts++;
                BankAccHead.setAccountPosition(0);
                return BankAccHead;
            }
        }
        else // The head of the linked list was not null
        {
            int rowIndex = 0;
            BankAccount current;
            current = this.BankAccHead;
            // Traverse the linked list until we find a BankAccount with the
            // same name or we get to the end of the list
            while (current.getNext() != null
                    && !(current.getAccountName().equals(name)))
            {
                rowIndex++;
                current = current.getNext();
            }
            if (current.getAccountName().equals(name))
            {
                // A BankAccount with that name already exists
                // Prompt the user to enter a unique name
                return null;
            }
            else // We reached the end of the list, now we insert
            {
                if (type.equals("Checking")) // Create a CheckingAccount
                {
                    current.setNext(new CheckingAccount(bal, name));
                    numOfBankAccounts++;
                    current.getNext().setAccountPosition(numOfBankAccounts - 1);
                    return current.getNext();
                }
                else // Create a SavingsAccount
                {
                    current.setNext(new SavingsAccount(bal, name));
                    numOfBankAccounts++;
                    current.getNext().setAccountPosition(numOfBankAccounts - 1);
                    return current.getNext();
                }
            }
        }
    }

    /**
     * This function will act as a bank account lookup. The user can enter the
     * name of the bank account they wish to access, and it will be returned.
     * Once it is returned we can get the balance, name and other info.
     *
     * @method findBankAccount
     * @param name The name of the account
     * @return Returns the bank account if it is found. Returns null if not
     * found
     */
    public BankAccount findBankAccount(String name)
    {
        if (this.BankAccHead == null) // The user does not have any BankAccounts
        {
            return null;
        }
        else
        {
            BankAccount current = this.BankAccHead;
            // Traverse the BankAccount linked list until the account is found
            // or we reach the end of the list
            while (current != null && !(current.getAccountName().equals(name)))
            {
                current = current.getNext();
            }
            if (current == null) // The end of the list was reached
                return null;
            else // The item was found
                return current;
        }
    }

    /**
     * This function will allow us to pass in a number and return the
     * BankAccount that is at that position in our linked list of BankAccounts
     *
     * @param num the position of the BankAccount we are looking for
     * @return the BankAccount if it is found. null otherwise
     */
    public BankAccount findBankAccountNumber(int num)
    {
        if (this.BankAccHead == null) // The user does not have any BankAccounts
        {
            return null;
        }
        else
        {
            BankAccount current = this.BankAccHead;
            // Traverse the BankAccount linked list until the account is found
            // or we reach the end of the list
            for (int zod = 0; zod < (num - 1); zod++)
            {
                current = current.getNext();
            }
            if (current == null) // The end of the list was reached
                return null;
            else // The item was found
                return current;
        }
    }

    public boolean deleteBankAccount(String name)
    {
        if (BankAccHead != null)
        {
            // Keep track of the previous UserAccount in the list
            BankAccount prev = null;
            BankAccount current = BankAccHead;
            // Traverse the linked list inside of the bucket until the UserAccount
            // is found or we reach the end of the linked list
            while (current.getNext() != null
                    && !(current.getAccountName().equals(name)))
            {
                prev = current;
                current = current.getNext();
            }
            if (current.getAccountName().equals(name)) // The UserAccount was found
            {
                numOfBankAccounts--;
                // The UserAccount is not the head of the linked list
                if (prev != null)
                {
                    prev.setNext(current.getNext());
                    setBankAccountNumbers(current.getNext());
                    current = null;
                }
                else // Remove the head of the linked list inside of the bucket
                {
                    BankAccHead = BankAccHead.getNext();
                    setBankAccountNumbers(current.getNext());
                    current = null;
                }
                return true;
            }
        }
        // The bucket at index was empty so the UserAccount was not found
        return false;
    }

    public void setBankAccountNumbers(BankAccount current)
    {
        if (current != null) // The user does not have any BankAccounts
        {
            for (int zod = ((current.getAccountPosition()) - 1); zod < (numOfBankAccounts); zod++)
            {
                current.setAccountPosition(zod);
                current = current.getNext();
            }
        }
    }

    /**
     * Prints information about all BankAccounts that the user owns
     *
     * @method printAllBankAccounts
     */
    public void printAllBankAccounts()
    {
        if (BankAccHead != null)
        {
            BankAccount current = this.BankAccHead;
            System.out.println("Bank Account Statement");
            System.out.println("======================");
            while (current != null)
            {
                System.out.println("Account Name: " + current.getAccountName());
                System.out.println("Account Type: " + current.getAccountType());
                System.out.println("Account Balance: " + current.getBalance());
                System.out.println("======================");
                current = current.next;
            }
        }
        else
            System.out.println("You have no bank accounts. ");
    }

    public int printBankAccountNames()
    {
        if (BankAccHead != null)
        {
            BankAccount current = this.BankAccHead;
            for (int zod = 0; zod < numOfBankAccounts; zod++)
            {
                System.out.println((current.getAccountPosition() + 1) + ". " + current.getAccountName());
                current = current.next;
            }
            return numOfBankAccounts;
        }
        System.out.println("You have no bank accounts. ");
        return 0;
    }

    /**
     * Checks if two UserAccounts are equal by comparing the userName field
     *
     * @method equals
     * @param item This is the UserAccount that we want to compare
     * @return Returns true if they are equal, false if not
     */
    boolean equals(UserAccount item)
    {
        return (item.getUserName().equals(this.getUserName()));
    }

    /////////////////////////////////////////
    // BELOW ARE JUST SETTERS AND GETTERS ///
    /////////////////////////////////////////
    /**
     * 11_15 testing admin account*
     */
    public void allowAdmin()
    {

        this.admin = true;
    }

    public boolean getAdmin()
    {
        return admin;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public void setPassword(String password)
    {

        this.password = password;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public void setNext(UserAccount next)
    {
        this.next = next;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getUserName()
    {
        return userName;
    }

    public String getPassword()
    {
        return password;
    }

    public String getEmail()
    {
        return email;
    }

    public String getPhone()
    {
        return phone;
    }

    public UserAccount getNext()
    {
        return next;
    }

    public int getLocation()
    {
        return location;
    }

    public void setLocation(int location)
    {
        this.location = location;
    }

    public void setBankAccHead(BankAccount BankAccHead)
    {
        this.BankAccHead = BankAccHead;
    }

    public BankAccount getBankAccHead()
    {
        return BankAccHead;
    }

    public int getNumOfBankAccounts()
    {
        return numOfBankAccounts;
    }

}
