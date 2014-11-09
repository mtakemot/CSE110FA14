/* TODO:      **please update todo's here if you are working on this file
 *  -11/8 (Michio Takemoto):
    runtime database will sync (IMPORT) to previously created 
 *  database by importing from a Data.ser file that will
 *  be placed in your CSE110FA14 folder (where the README
 *  file that Ryan wrote is found. After user information is edited, AND while 
 *  the user is still logged in, There is an option for the USER to export changes
 *  which will export the runtime database to Data.ser
 **1) What I want to do is, test efficiency of exporting database after every
 *  data change (NOT when data is viewed, but ACTUALLY change like user being created
 *  bank account created, $ transferred, account deleted, etc
 **2) See if we can import/export Data.ser to github.com for potentially centralizing
 *  data base with other clients
 ***a) In such case, build algorithm to insert time stamps into the Data.ser
 ***b) Compare time stamps before committing to see if you need to repull, merge
 *     changes, then commit
 **3) Test flexibility of serialization for .exe file. If we just put a .exe file on
 *    random cpu and run it, will the Data.ser be inside the .exe, in a temporary
 *    windows folder, or will the program not work properly due to Data.ser not 
 *    working right in .exe form
 *
 */
package Backend;

import java.io.*;

/**
 *
 * @author Michio Takemoto 
 * ****Data.ser currently has one user: mike with password: 123
 * user account mike has 1 savings account and 1 checking account.
 */
public class ImportExport {
    
    public ImportExport (){}
    
    
    /** IMPORTING From "Data.ser" in the working directory of the source code
     * MUST return HasTable to update the existing table with the information 
     * from the database. 
     * @param MasterTable
     * @return 
     */
    public HashTable importDB (HashTable MasterTable){
                
        try{
            FileInputStream fileIn = new FileInputStream("Data.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            MasterTable = (HashTable) in.readObject();
            in.close();

            fileIn.close();
            
            /*******DEBUG to see if the import/export user # matches*****/
            System.out.println("\n\nTable has " + MasterTable.occ + 
                    " users\n");

        }catch(IOException i){  //error for bad or non existing input file
          
            System.err.println("Previous database doesn't exist. "
                    + "Creating a new database");
           
        }catch(ClassNotFoundException c){   
            /*error for possible error in the non existence of
             *methods being invoked*/
            System.err.println("There are no previous records, "
                    + "please enter first entry");
            
            }
        
        return MasterTable;
        
    }
    
    /* We do NOT need to return a Hashtable, because once exporting will NOT
     * change the runtime hashtable you have, but WILL change the Hashtable 
     * being saved to file. 
     * So basically, it will record any changes, and all we need to know if
     * if the export worked correctly or not (TRUE/FALSE)
    */
    public boolean exportDB(HashTable MasterTable){
     
         /***DEBUG****/
        System.out.println("\n\nTable has " +  MasterTable.occ + 
                " User accounts exported \n");
         boolean result = false;
         try{
         
             FileOutputStream fileOut = new FileOutputStream("Data.ser");

             ObjectOutputStream out = new ObjectOutputStream(fileOut);
             out.writeObject(MasterTable);
             out.close();
             fileOut.close();
             result = true;
            }catch (IOException i){
                //error for bad or non existing output file
                System.err.println("\n\n\nEXPORT FAILED!\n\n");
                
            }
         
            return result;
        }
    }

