/**
 * /****************************************************************************
 *
 * Ryan Bridges CSE 110, Fall 2014 Last Updated: Michio Takemoto, November 8,
 * 2014
 *
 * Team 42
 *
 * File Name: Main.java Description: This is a crude and simple file that will
 * test very basic functionality of our program. It is primitive because we
 * intend to create a user interface later, and so usability through the console
 * is not a high priority.
 * **************************************************************************
 */
package Backend;

import java.util.*;
import java.io.*;

public class Main
{

    public static void main(String[] args)
    {

        HashTable MasterTable = null;
        Scanner input = new Scanner(System.in);
        String action;
        String action2;
        String action3;
        String adminStr = "admin";
        boolean login = false;
        ImportExport datain = new ImportExport();
        UserAccount admin;
        ImportExport dataout = new ImportExport();

        if ((MasterTable = datain.importDB(MasterTable)) != null)
        {
            admin = MasterTable.findUserAccount("admin");
            System.out.println("\n\n\nImported data successfully\n\n\n");

            //creating admin if it doesn't exist
            if (admin == null)
            {
                admin = MasterTable.insertUserAccount("admin");
                admin.allowAdmin();
                admin.setPassword("team42");
                System.out.println("test");
            }

            //if admin account exists, then make sure it has admin rights. 
            else
            {
                //admin = MasterTable.findUserAccount("admin");
                admin.setPassword("team42");
                admin.allowAdmin();
                if (admin.getAdmin())
                    System.out.println("test2");
                else
                    System.out.println("test3");

            }

        }
        else
        {
            MasterTable = new HashTable();
            System.out.println("\n\n\nCreating new database\n\n\n");
            admin = MasterTable.insertUserAccount("admin");
            admin.allowAdmin();
            admin.setPassword("team 42");
            System.out.println("test");

        }

        //MasterTable = datain.importDB(MasterTable);
        while (!login)
        {

            System.out.println("Please select an action by inputting the number "
                    + "next to your choice: ");
            System.out.println("1. Create a new User Account.");
            System.out.println("2. Login to an existing User Account.");
            action = input.nextLine();
            if (action.equals("1"))
            {
                System.out.print("Please enter a unique username: ");
                UserAccount newUser = MasterTable.insertUserAccount(input.nextLine());
                while (newUser == null)
                {
                    System.out.println("Failure! The username that you have "
                            + "chosen is already in use.");
                    System.out.print("Please enter a new one: ");
                    newUser = MasterTable.insertUserAccount(input.nextLine());
                }
                System.out.println("Success! Your new User Account has been "
                        + "created");
                System.out.print("Please enter a password for your new "
                        + "account: ");
                newUser.setPassword(input.nextLine());
                // Ask user for other info like phone number/email if desired
            }
            else if (action.equals("2"))
            {
                System.out.println("Please enter your login credentials.");
                System.out.print("Username: ");
                UserAccount currUser = MasterTable.findUserAccount(input.nextLine());
                while (currUser == null)
                {
                    System.out.println("The username that you entered does not exist.");
                    System.out.print("Please enter a valid username: ");
                    currUser = MasterTable.findUserAccount(input.nextLine());
                }
                System.out.println(" currentUser's name1: " + currUser.getUserName() + ".");
                // System.out.println("currUser PASS: " + currUser.getPassword() + "\n");
                System.out.print("Password: ");

                while (!(currUser.validatePassword(input.nextLine())))
                {
                    System.out.println("The password that you entered was invalid. ");
                    System.out.print("Please try again: ");
                }
                System.out.println(" currentUser's name2: " + currUser.getUserName() + ".");
                login = true;
                System.out.println("You are now logged in! Please select an option: ");
                while (login)
                {
                    /**
                     * ****DEBUG*************
                     */
                    //  System.out.println (" currentUser's name3: " + currUser.getUserName() +".");
                    //  if(adminStr.equals(currUser.getUserName())){
                    if (!currUser.getAdmin())
                    {
                        Scanner input2 = new Scanner(System.in);
                        System.out.println("1. Create a new Bank Account.");
                        System.out.println("2. Print accounts statement.");
                        System.out.println("3. Credit an Account. ");
                        System.out.println("4. Debit an Account.");
                        System.out.println("5. Logout.");
                        System.out.println("6. EXPORT.");
                        System.out.println("7. Transfer money to your accounts.");
                        action2 = input2.nextLine();

                        if (action2.equals("1"))
                        {
                            System.out.print("Bank Account Name:");
                            String name = input2.nextLine();
                            while (currUser.findBankAccount(name) != null)
                            {
                                System.out.print("Account name already exists, please enter a new name: ");
                                name = input2.nextLine();
                            }
                            System.out.println("Bank Account type:");
                            System.out.println("1. Checking ");
                            System.out.println("2. Savings ");
                            String type = input2.nextLine();
                            System.out.print("Balance (double): ");
                            double bal = input2.nextDouble();
                            if (type.equals("1"))
                            {
                                BankAccount newBA = currUser.insertBankAccount(bal, name, "Checking");
                                System.out.println("You have successfully created a bank account!\n ");
                            }
                            else if (type.equals("2"))
                            {
                                BankAccount newBA = currUser.insertBankAccount(bal, name, "Savings");
                                System.out.println("You have successfully created a bank account!\n ");
                            }

                        }

                        else if (action2.equals("2"))
                        {
                            currUser.printAllBankAccounts();
                        }
                        else if (action2.equals("3"))
                        {
                            if (currUser.getBankAccHead() != null)
                            {
                                System.out.print("Please Enter an accouont name to deposit to: ");
                                String accountName = input2.nextLine();
                                BankAccount bAcc = currUser.findBankAccount(accountName);
                                while (bAcc == null)
                                {
                                    System.out.print("Please Enter an existing account name: ");
                                    accountName = input2.nextLine();
                                    bAcc = currUser.findBankAccount(accountName);
                                }
                                System.out.print("Please enter a deposit amount(double): ");
                                bAcc.addToBalance(input2.nextDouble());
                                System.out.println("Deposit Successful! ");
                            }
                            else
                            {
                                System.out.print("Please open a Bank Account before attempting to deposit");
                            }
                        }

                        else if (action2.equals("4"))
                        {
                            if (currUser.getBankAccHead() != null)
                            {
                                System.out.print("Please Enter an account name to debit from: ");
                                String bName = input2.nextLine();
                                BankAccount found = currUser.findBankAccount(bName);
                                while (found == null)
                                {
                                    System.out.print("Please Enter an existing account name: ");
                                    bName = input2.nextLine();
                                    found = currUser.findBankAccount(bName);
                                }
                                System.out.print("Please enter a debit amount(double): ");
                                double amount = input2.nextDouble();
                                while (!found.subFromBalance(amount))
                                {
                                    System.out.println("Please Enter a valid amount: ");
                                    amount = input2.nextDouble();
                                }
                                System.out.println("Debit Successfyl! ");
                            }
                            else
                                System.out.println("Please open a Bank Account before attempting to withdraw");

                        }
                        else if (action2.equals("5"))
                        {
                            System.out.println("You are now logged out! \n");
                            dataout.exportDB(MasterTable);

                            login = false;
                        }

                        else if (action2.equals("6"))
                        {
                            if (dataout.exportDB(MasterTable))
                            {
                                System.out.println("\nExported file to local source file"
                                        + " Data.ser\n");

                            }
                            else
                            {
                                System.err.println("\n\nCould not export, ERROR\n\n");
                            }
                        }
                        if (action2.equals("7"))
                        {
                            if (currUser.getBankAccHead() != null)
                            {
                                String debit;
                                System.out.println("Enter the number next to the account you would like to transfer from: ");
                                int totalAccs = currUser.printBankAccountNames();
                                Scanner debitAcc = new Scanner(System.in);
                                debit = debitAcc.nextLine();
                                while (!(Integer.parseInt(debit) > 0) || !(Integer.parseInt(debit) < totalAccs))
                                {
                                    System.out.println("The account number that you entered was invalid.");
                                    System.out.println("Please enter a number between 1 and " + totalAccs);
                                    debit = debitAcc.nextLine();
                                }
                                BankAccount debitting = currUser.findNumberBankAccount(Integer.parseInt(debit));
                                /*while (debitting == null || debitting.getBalance() <= 0)
                                 {
                                 System.out.println("Please reenter a valid account with"
                                 + " a positive balance ");
                                 debitAcc = new Scanner(System.in);
                                 debit = debitAcc.nextLine();
                                 debitting = currUser.findBankAccount(debit);

                                 }*/
                                System.out.println("Enter the number next to the account you would like to transfer to: ");
                                totalAccs = currUser.printBankAccountNames();                             
                                Scanner creditAcc = new Scanner(System.in);
                                String credit = creditAcc.nextLine();
                                while (!(Integer.parseInt(credit) > 0) && !(Integer.parseInt(credit) < totalAccs))
                                {
                                    System.out.println("The account number that you entered was invalid.");
                                    System.out.println("Please enter a number between 1 and " + totalAccs);
                                    credit = creditAcc.nextLine();
                                }
                                BankAccount crediting = currUser.findNumberBankAccount(Integer.parseInt(credit));
                                /*while (crediting == null)
                                 {
                                 System.out.println("Please reenter a valid account with");
                                 creditAcc = new Scanner(System.in);
                                 credit = creditAcc.nextLine();
                                 crediting = currUser.findBankAccount(credit);
                                 }*/
                                System.out.println("Enter an amount to transfer: ");
                                Scanner transfer1 = new Scanner(System.in);
                                String transfering = transfer1.nextLine();
                                int transfer = Integer.parseInt(transfering);

                                while (transfer > debitting.getBalance())
                                {
                                    System.out.println("INSUFFICIENT FUNDS!");
                                    System.out.print("Enter an amount to transfer: ");
                                    transfer1 = new Scanner(System.in);
                                    transfering = transfer1.nextLine();
                                    transfer = Integer.parseInt(transfering);
                                }

                                if (debitting.subFromBalance(transfer))
                                {
                                    System.out.println("Account: " + currUser.findNumberBankAccount(Integer.parseInt(debit)).getAccountName() + " now has a balance of: "
                                            + debitting.getBalance());
                                    System.out.println("Account: " + currUser.findNumberBankAccount(Integer.parseInt(credit)).getAccountName() + " now has a balance of: "
                                            + crediting.addToBalance(transfer));
                                }
                                else
                                {
                                    System.out.println("ERROR IN WITHDRAWAL ");
                                }

                                dataout.exportDB(MasterTable);
                            }
                        }
                    }
                    // }//end if NOT ADMIN
                    // else if(!adminStr.equals(currUser.getUserName())){
                    else if (currUser.getAdmin())
                    {
                        while (login && currUser.getAdmin())
                        {
                            System.out.print("\n\nPlease enter the account index you wish to access: \n\n");
                            Scanner input3 = new Scanner(System.in);
                            System.out.println("1. Search for User Account");
                            System.out.println("2. Interest/Penalty");
                            System.out.println("3. Logout");
                            action3 = input3.nextLine();

                            if (action3.equals("1"))
                            {
                                MasterTable.adminPrintUser();

                                System.out.println("Enter User's Unique ID:");
                                String action4;

                                Scanner input4 = new Scanner(System.in);
                                action4 = input4.nextLine();
                                int index = Integer.parseInt(action4);
                                System.out.println("finding the info for UNIQUE id: " + index + " .");
                                UserAccount editUser = MasterTable.Table[index];
                                System.out.println("\nUser: " + editUser.getUserName() + "'s Bank Accounts: ");
                                editUser.printAllBankAccounts();
                                System.out.println("Enter \"exit\" to logout OR ");
                                System.out.println("Enter the account name you wish to edit: ");

                                Scanner input5 = new Scanner(System.in);
                                String action5 = input5.nextLine();
                                if (action5.equals("exit"))
                                {
                                    login = false;
                                    dataout.exportDB(MasterTable);
                                }

                                BankAccount currBA = editUser.findBankAccount(action5);
                                System.out.println("1. Credit Account");
                                System.out.println("2. Debit Account");
                                System.out.println("3. Delete Account");
                                System.out.println("4. Exit");
                                Scanner input6 = new Scanner(System.in);
                                String action6 = input5.nextLine();
                                index = 0;
                                index = Integer.parseInt(action6);

                                if (index == 1)
                                {
                                    System.out.println("The current balance is: " + currBA.getBalance());
                                    System.out.println("Enter the credit amount: ");
                                    Scanner input7 = new Scanner(System.in);
                                    String action7 = input7.nextLine();
                                    int credit = Integer.parseInt(action7);
                                    currBA.addToBalance(credit);
                                    System.out.println("New balance: " + currBA.getBalance());
                                }
                                else if (index == 2)
                                {
                                    System.out.println("The current balance is: " + currBA.getBalance());
                                    System.out.println("Enter the debit amount: ");
                                    Scanner input8 = new Scanner(System.in);
                                    String action8 = input8.nextLine();
                                    int credit = Integer.parseInt(action8);

                                    if (currBA.subFromBalance(credit))
                                    {
                                        System.out.println("New balance: " + currBA.getBalance());
                                    }

                                    else
                                    {

                                        dataout.exportDB(MasterTable);
                                    }
                                    login = false;
                                }
                                else if (index == 3)
                                {
                                    if (editUser.deleteBankAccount(currBA.getAccountName()))
                                    {
                                        System.out.println("Account deleted, returning to main screen");
                                        dataout.exportDB(MasterTable);
                                        login = false;
                                    }
                                    else
                                    {
                                        System.out.println("ERROR processing request, returning to main screen");
                                        dataout.exportDB(MasterTable);
                                        login = false;
                                    }

                                }
                                else if (index == 4)
                                {
                                    dataout.exportDB(MasterTable);
                                    login = false;
                                }
                            }
                            else if (action3.equals("2"))
                            {
                                System.out.println("Sorry, this option is not available yet");
                                dataout.exportDB(MasterTable);
                                login = false;
                            }
                            else if (action3.equals("3"))
                            {
                                dataout.exportDB(MasterTable);
                                login = false;
                            }

                        }
                    }

                }
            }

            dataout.exportDB(MasterTable);
        }
    }
}
