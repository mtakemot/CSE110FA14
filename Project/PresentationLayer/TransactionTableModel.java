/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import LogicLayer.BankAccount;
import LogicLayer.Transaction;
import java.awt.List;
import java.util.ArrayList;
import java.util.TreeSet;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ryan
 */
public class TransactionTableModel extends AbstractTableModel
{

    private Transaction[] transactions;
    private BankAccount current;
    private static final int colCount = 3;

    private String[] columnNames =
    {
        "Date", "Type", "Transaction"
    };

    public TransactionTableModel(BankAccount current)
    {
        this.current = current;
        transactions = current.getTransactions().toArray(new Transaction[current.getTransactions().size()]);
    }

    @Override
    public int getRowCount()
    {
        return transactions.length;
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
                returnMe = BankAccount.dtf.print(transactions[rowIndex].getTransTime());
            case 1:
                returnMe = transactions[rowIndex].getTransType();
            case 2:
                returnMe = transactions[rowIndex].getTransAmount();
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

}
