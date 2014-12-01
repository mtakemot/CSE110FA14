/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import LogicLayer.UserAccount;
import FacadeLayer.UserAccountWrapper;
import javax.swing.table.*;

/**
 *
 * @author rbridges
 */
public class AccountsTableModel extends AbstractTableModel
{

    private  int colCount = 3;
    private UserAccount current;
    private UserAccountWrapper wrapper;
    Class[] columns = new Class[]
    {
       String.class, String.class, Double.class
    };
    private String[] columnNames =
    {
        "Account Name", "Account Type",
        "Balance"
    };

    public AccountsTableModel(UserAccount curr)
    {
        this.current = curr;
        wrapper = new UserAccountWrapper(this.current);
        this.addTableModelListener(new TableListener());
    }

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
        fireTableCellUpdated(rowIndex, columnIndex);
    }

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

    @Override
    public boolean isCellEditable(int row, int col)
    {
        return false;
    }

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
