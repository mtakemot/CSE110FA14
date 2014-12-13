package PresentationLayer;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

/**
 * **************************************************************************
 *
 * James Delaplane CSE 110, Fall 2014 Last Updated: November 24th, 2014
 *
 * Team 42
 *
 * File Name: TableListener
 * Used to display debug messages when the table listener is used
 * to update the table.
 * **************************************************************************
 */


public class TableListener implements TableModelListener
{

    @Override
    public void tableChanged(TableModelEvent e)
    {
        //Debugging to occur when table is updated
        int row = e.getLastRow();
        int column = e.getColumn();
        /*
        Have commented out all print statements since debugging is currently
        done.
        */
        /*//System.out.println("Row " + row);
         //System.out.println("Column " + column);*/
    }

}
