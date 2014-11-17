/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Backend.TableWrapper;
import Backend.UserAccount;
import javax.swing.table.*;

/**
 *
 * @author rbridges
 */
public class TableModel extends AbstractTableModel
{

    private int colCount = 3;
    private UserAccount current;
    private TableWrapper wrapper;
    Class[] columns = new Class[]
    {
        String.class, String.class, Double.class
    };
    private String[] columnNames =
    {
        "Account Name", "Account Type",
        "Account Balance"
    };

    public TableModel(UserAccount curr)
    {
        this.current = curr;
        wrapper = new TableWrapper(this.current);
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
