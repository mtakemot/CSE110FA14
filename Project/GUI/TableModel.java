/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Backend.UserAccount;
import FacadeLayer.BackendWrapper;
import javax.swing.table.*;

/**
 *
 * @author rbridges
 */
public class TableModel extends AbstractTableModel
{

    private int colCount = 4;
    private UserAccount current;
    private BackendWrapper wrapper;
    Class[] columns = new Class[]
    {
        Integer.class, String.class, String.class, Double.class
    };
    private String[] columnNames =
    {
        "#", "Account Name", "Account Type",
        "Account Balance"
    };

    public TableModel(UserAccount curr)
    {
        this.current = curr;
        wrapper = new BackendWrapper(this.current);
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
            case 3:
                wrapper.setAccountBalance((double) aValue, rowIndex);
                break;
            case 2:
                wrapper.setAccountType((String) aValue, rowIndex);
                break;
            case 1:
                wrapper.setAccountName((String) aValue, rowIndex);
                break;
            case 0:
                wrapper.setAccountNumber((int) aValue, rowIndex);
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        Object returnMe = null;
        switch (columnIndex)
        {
            case 3:
                returnMe = wrapper.getAccountBalance(rowIndex);
                break;
            case 2:
                returnMe = wrapper.getAccountType(rowIndex);
                break;
            case 1:
                returnMe = wrapper.getAccountName(rowIndex);
                break;
            case 0:
                returnMe = wrapper.getAccountNumber(rowIndex);
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
