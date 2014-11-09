/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

import java.io.Serializable;
import java.util.*;
import java.io.*;

/**
 *
 * @author Michio
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
        boolean result = false;
        
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
                i.printStackTrace();
                System.err.println("\n\n\nEXPORT FAILED!\n\n");
                result = false;
            }
         
            return result;
        }
    }

