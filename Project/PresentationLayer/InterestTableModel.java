/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FacadeLayer.HashTableWrapper;
import LogicLayer.HashTable;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ryan
 */
public class InterestTableModel extends AbstractTableModel
{

    private String[] columnNames =
    {
        "Account Type", "$1000-$2000",
        "$2000-$3000", "More than $3000"
    };

    private String[] rowNames =
    {
        "Savings", "Checking"
    };

    Class[] columns = new Class[]
    {
        String.class, double.class, double.class, double.class
    };

    private HashTable hashTable;
    private HashTableWrapper wrapper;

    public InterestTableModel(HashTable hashTable)
    {
        this.hashTable = hashTable;
        wrapper = new HashTableWrapper(this.hashTable);
        //this.addTableModelListener(new TableListener());
    }

    @Override
    public int getRowCount()
    {
        return 2;
    }

    @Override
    public int getColumnCount()
    {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        if (columnIndex == 0)
            return rowNames[rowIndex];
        else
            return wrapper.getTableValue(rowIndex, columnIndex - 1);
    }

    @Override
    public void setValueAt(Object val, int rowIndex, int columnIndex)
    {
        if (val instanceof Number && ((Number) val).doubleValue() >= 0)
        {
            super.setValueAt(val, rowIndex, columnIndex);
        }
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

    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
        if (columnIndex == 0)
            return false;
        return true;
    }
}
