/**
 * **************************************************************************
 *
 * Ryan Bridges CSE 110, Fall 2014 Last Updated: October 19, 2014
 * Tahereh Masoumi , Last Updated: November 3, 2014
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

public class Main {

    public static void main(String[] args) {
        HashTable MasterTable = new HashTable();
        Scanner input = new Scanner(System.in);
        String action;
        String action2;
        boolean login = false;
        while (!login) {
            System.out.println("Please select an action by inputting the number "
                    + "next to your choice: ");
            System.out.println("1. Create a new User Account.");
            System.out.println("2. Login to an existing User Account.");
            action = input.nextLine();
            if (action.equals("1")) {
                System.out.print("Please enter a unique username: ");
                UserAccount newUser = MasterTable.insertUserAccount(input.nextLine());
                while (newUser == null) {
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
            } else {
                System.out.println("Please enter your login credentials.");
                System.out.print("Username: ");
                UserAccount currUser = MasterTable.findUserAccount(input.nextLine());
                while (currUser == null) {
                    System.out.println("The username that you entered does not exist.");
                    System.out.print("Please enter a valid username: ");
                    currUser = MasterTable.findUserAccount(input.nextLine());
                }
                System.out.print("Password: ");
                while (!(currUser.validatePassword(input.nextLine()))) {
                    System.out.println("The password that you entered was invalid. ");
                    System.out.print("Please try again: ");
                }
                login = true;
                System.out.println("You are now logged in! Please select an option: ");
                while (login) {
                    Scanner input2 = new Scanner(System.in);
                    System.out.println("1. Create a new Bank Account.");
                    System.out.println("2. Print all accounts.");
                    System.out.println("3. Credit Account. ");
                    System.out.println("4. Debit Account.");
                    System.out.println("5. Logout.");
                    action2 = input2.nextLine();
                    
                    if (action2.equals("1")) {
                        System.out.print("Bank Account Name:");
                        String name = input2.nextLine();
                        while (currUser.findBankAccount(name) != null) {
                            System.out.print("Account name already exists, please enter a new name: ");
                            name = input2.nextLine();
                        }
                        System.out.println("Bank Account type:");
                        System.out.println("1. Checking ");
                        System.out.println("2. Savings ");
                        String type = input2.nextLine();
                        System.out.print("Balance (double): ");
                        double bal = input2.nextDouble();
                        if (type.equals("1")) {
                            BankAccount newBA = currUser.insertBankAccount(bal, name, "Checking");
                            System.out.println("You have successfully created a bank account!\n ");
                        } else if (type.equals("2")) {
                            BankAccount newBA = currUser.insertBankAccount(bal, name, "Savings");
                            System.out.println("You have successfully created a bank account!\n ");
                        }

                    }

                    else if (action2.equals("2")) {
                        currUser.printAllBankAccounts();
                    }
                    else if (action2.equals("3")) {
                        System.out.print("Please Enter an accouont name to deposit to: ");
                        String accountName = input2.nextLine();
                        BankAccount bAcc = currUser.findBankAccount(accountName);
                        while (bAcc == null) {
                            System.out.print("Please Enter an existing account name: ");
                            accountName = input2.nextLine();
                            bAcc = currUser.findBankAccount(accountName);
                        }
                        System.out.print("Please enter a deposit amount(double): ");
                        bAcc.addToBalance(input2.nextDouble());
                        System.out.println("Deposit Successful! ");
                    }

                    else if (action2.equals("4")) {
                        System.out.print("Please Enter an account name to debit from: ");
                        String bName = input2.nextLine();
                        BankAccount found = currUser.findBankAccount(bName);
                        while (found == null) {
                            System.out.print("Please Enter an existing account name: ");
                            bName = input2.nextLine();
                            found = currUser.findBankAccount(bName);
                        }
                        System.out.print("Please enter a debit amount(double): ");
                        double amount = input2.nextDouble();
                        while (!found.subFromBalance(amount)) {
                            System.out.println("Please Enter a valid amount: ");
                            amount = input2.nextDouble();
                        }
                        System.out.println("Debit Successfyl! ");

                    }
                    else if (action2.equals("5")) {
                        System.out.println("You are now logged out! \n");
                        login = false;
                    }
                }
            }

        }
    }
}
