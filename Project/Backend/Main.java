package Backend;


/**
 * **************************************************************************
 *
 * Ryan Bridges CSE 110, Fall 2014 Last Updated: October 19, 2014
 *
 * Team 42
 *
 * File Name: Main.java Description: This is a crude and simple file that will
 * test very basic functionality of our program. It is primitive because we
 * intend to create a user interface later, and so usability through the console
 * is not a high priority.
 * **************************************************************************
 */
import Backend.UserAccount;
import Backend.HashTable;
import java.util.*;
import java.io.*;

public class Main
{

    public static void main(String[] args)
    {

        HashTable theTable= new HashTable();
        Scanner input = new Scanner(System.in);
        String action1, action2, action, action3;
       /* String first= "";
        String last = "";*/
        
        while (true)
        {   
            action1=action2= action = action3= null;
            boolean temp = false;
            System.out.println("\n----------MAIN MENU--------------");
            System.out.println("Hello, what would you like to do?\n");
            System.out.println("    1. Create a new User Account.");
            System.out.println("    2. Login to an existing User Account.\n");
            System.out.print("Please select an action by inputting the number \n"
                              +"    of your choice followed by the ENTER button: ");
            action =action1= input.nextLine();
            if (action.equals("1"))
            {
                System.out.print("\nPlease enter a unique username: ");
                action2 = input.nextLine();
                System.out.print("\n\n             TEST                    \n\n");
                UserAccount newUser = theTable.insertUserAccount(action2);
                System.out.print("\n\n             TEST 1                   \n\n");
                while (newUser == null)
                {/*
                    System.out.println("Failure! The username that you have "
                                       + "chosen is already in use.");
                    System.out.print("Please enter a different user name: ");
                    newUser = theTable.insertUserAccount(input.nextLine());*/
                    
                    //editing to let user get back to menu
                   // action2= null;
                    System.out.print("\n\n             TEST    2                \n\n");
                    System.out.println("\nThe username that you have "
                                       + "chosen is already in use.\n");
                    System.out.print("    Please select 1 to try again. \n"
                                   + "    Please select 2 to reach the main menu: ");
                    action1 = input.nextLine();
                    temp = true;
                    //re-enter a user name
                    if(action1.equals("1"))
                    {
                            
                            System.out.print("\n\nPlease enter a different username: ");
                            
                            action3 = input.nextLine();
                            newUser = theTable.insertUserAccount(action3);
                    }
                    
                    //exit to menu
                    else 
                    {   
                        //invalid entry
                        if (!action1.equals("2"))
                        {
                            System.out.println ("\n    Invalid entry. Returning "
                                        + "to MAIN MENU");
                        }
                        
                            break;  //break out of useraccount while loop
                    }
                    
                    
                    
                    
                }
                if (temp){
                if (action1.equals("2"))
                    continue;
                
                    temp = false;
                }
                
                System.out.print("\nPlease enter a password for your new account: ");
                
                newUser.setPassword(input.nextLine());
                System.out.println("\n    Success! Your new User Account has been "
                                   + "created");
                
                
                // Ask user for other info like phone number/email if desired
            }
            else if (action.equals("2"))// this will prevent other entries besides "1" and "2"
            {
                action1=action2 = null;
                System.out.println("\nPlease enter your login credentials below.");
                System.out.print("\nUsername: ");
                action2=input.nextLine();
                UserAccount currUser = theTable.findUserAccount(action2);
                
                while (currUser == null)
                {
                    action1 = null;
                    System.out.println("\nThe username that you entered does not exist.\n");
                    System.out.print("    Please select 1 to try again. \n"
                                   + "    Please select 2 to reach the main menu: ");
                    action1=input.nextLine();
                    temp = true;
                    
                    if(action1.equals("1"))
                    {
                        action2 = null;
                        System.out.print("\nPlease enter a different username: ");
                        action2 = input.nextLine();
                        currUser = theTable.findUserAccount(action2);
                    }
                    //exit to menu
                    else 
                    {   
                        //invalid entry
                        if (!action1.equals("2"))
                        {
                            System.out.println ("\n    Invalid entry. Returning "
                                        + "to MAIN MENU");
                        }
                        
                        break;  //break out of useraccount while loop
                    }
                    
                    
                }
                
                if(temp){
                    if(action1.equals("2"))
                     {
                        continue;
                    }
                
                    temp = false;
                }
                
                action2 = null;
                System.out.print("\nPassword: ");
                
                //declare local boolean for better while loop logic
                action2 = input.nextLine();
                boolean result = currUser.validatePassword(action2);
                
                while (!result)
                {
                    action1=action2 = null;
                    System.out.println("\nThe password that you entered was invalid. ");
                    System.out.print("    Please select 1 to try again. \n"
                                   + "    Please select 2 to reach the main menu: ");
                    action1 = input.nextLine();
                    temp = true;
                    
                    if(action1.equals("1"))
                    {
                        System.out.print("\nPlease enter the password: ");
                        action2=input.nextLine();
                        result = currUser.validatePassword(action2);
                    }
                    //exit to menu
                    else 
                    {   
                        //invalid entry
                        if (!action1.equals("2"))
                        {
                            System.out.println ("\n    Invalid entry. Returning "
                                        + "to MAIN MENU");
                        }
                        
                            break;  //break out of useraccount while loop
                    }
                }
                if (temp){
                if(action1.equals("2"))
                {
                    continue;
                }
                temp = false;
                }
                //if it reaches here, the password was correct
                //action1=action2 = null;
               /* first +=currUser.getFirstName();
                last = currUser.getLastName();*/
                break;
                
            }
            // input other than "1 or 2"
            else
            {
               System.out.println ("\n    Invalid entry. Returning "
                                        + "to MAIN MENU");
            }
        }
        
        System.out.println("\n    Welcome back!\n"
                                    +"    Currently, any services other than the user account log in\n"
                                    +"    are still under development.\n"
                                  +"\n    We sincerely apologize for any inconveniences, and will \n"
                                    +"    provide updates momentarily. Thank you!\n\n");
    }
}
