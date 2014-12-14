/**
 * **************************************************************************
 *
 * Ryan Bridges CSE 110, Fall 2014 Last Updated: December 12, 2014
 *
 * Team 42
 *
 * File Name: AccountsTableModel.java Description: This class defines a custom
 * TableModel for our AccountsListTable so that it will show the data from our
 * backend. It also has various custom properties for selection, column names,
 * resizing, etc.
 * **************************************************************************
 */
package PresentationLayer;

import LogicLayer.UserAccount;
import FacadeLayer.UserAccountWrapper;
import javax.swing.table.*;

public class AccountsTableModel extends AbstractTableModel
{
    //Total Columns
    private int colCount = 3;
    private UserAccount current;
    //wrapper will be used to hold data from backend
    private UserAccountWrapper wrapper;
    //class for each type of information per column
    Class[] columns = new Class[]
    {
        String.class, String.class, Double.class
    };
    //columns names
    private String[] columnNames =
    {
        "Account Name", "Account Type",
        "Balance ($)"
    };
    //Constructor
    public AccountsTableModel(UserAccount curr)
    {
        this.current = curr;
        wrapper = new UserAccountWrapper(this.current);
        this.addTableModelListener(new TableListener());
    }
  
    // Sets the number of rows and cols in the table
    @Override
    public int getRowCount()
    {
        return current.getNumOfBankAccounts();
    }

    @Override
    public int getColumnCount()
    {
        return colCount;
    }

    // Function that is called any time we want to update the values in the table
    // Grabs data out of the facade to insert into the table 
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex)
    {
        switch (columnIndex)
        {
            case 2:
                wrapper.setAccountBalance((double) aValue, rowIndex);
                break;
            case 1:
                wrapper.setAccountType((String) aValue, rowIndex);
                break;
            case 0:
                wrapper.setAccountName((String) aValue, rowIndex);
                break;
            //case 0:
            //wrapper.setAccountNumber((int) aValue, rowIndex);
        }
        //Update Table display with actual value
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    // Sets the initial info to be displayed in the table
    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        Object returnMe = null;
        switch (columnIndex)
        {
            case 2:
                returnMe = wrapper.getAccountBalance(rowIndex);
                break;
            case 1:
                returnMe = wrapper.getAccountType(rowIndex);
                break;
            case 0:
                returnMe = wrapper.getAccountName(rowIndex);
                break;
            //case 0:
            // returnMe = wrapper.getAccountNumber(rowIndex);
        }
        return returnMe;
    }

    // Don't allow users to edit the cells
    @Override
    public boolean isCellEditable(int row, int col)
    {
        return false;
    }

    // Below set column names and classes
    @Override
    public String getColumnName(int index)
    {
        return columnNames[index];
    }

    @Override
    public Class getColumnClass(int columnIndex)
    {
        return columns[columnIndex];
    }
}
