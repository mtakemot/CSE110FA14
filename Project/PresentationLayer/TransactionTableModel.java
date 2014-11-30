/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import LogicLayer.BankAccount;
import LogicLayer.Transaction;
import java.util.*;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ryan
 */
public class TransactionTableModel extends AbstractTableModel
{

    private List<Transaction> transactions;
    private static final int colCount = 3;

    Class[] columns = new Class[]
    {
        String.class, String.class, Double.class
    };

    private String[] columnNames =
    {
        "Date", "Type", "Transaction Amount"
    };

    public TransactionTableModel(BankAccount current)
    {
        transactions = current.getTransactions();
        Collections.sort(transactions);
    }

    @Override
    public int getRowCount()
    {
        return transactions.size();
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
            case 0:
                returnMe = BankAccount.dtf.print(transactions.get(rowIndex).getTransTime());
            case 1:
                returnMe = transactions.get(rowIndex).getTransType();
            case 2:
                returnMe = transactions.get(rowIndex).getTransAmount();
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
