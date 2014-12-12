/**
 * **************************************************************************
 *
 * Ryan Bridges CSE 110, Fall 2014 Last Updated: December 12, 2014
 *
 * Team 42
 *
 * File Name: TransactionTableModel.java Description: Custom TableModel for the
 * transaction history table. Allows us to customize the data in the table and
 * how the table is displayed
 * **************************************************************************
 */
package PresentationLayer;

import LogicLayer.BankAccount;
import LogicLayer.Transaction;
import java.util.*;
import javax.swing.table.AbstractTableModel;

public class TransactionTableModel extends AbstractTableModel
{

    // User's list of Transactions that will be inserted into the table
    private List<Transaction> transactions;
    private static final int colCount = 4;

    // Names of table columns
    private String[] columnNames =
    {
        "Date", "Time", "Description", "Transaction Amount"
    };

    // ctor
    public TransactionTableModel(BankAccount current)
    {
        // Get the Transactions from the BankAccount and sort them
        transactions = current.getTransactions();
        Collections.sort(transactions);
    }

    // Set row and column count
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

    // Tells the table what values to put in each column
    // Col 0 = Date of transaction
    // Col 1 = Time of transaction
    // Col 2 = A message specifying what the transaction was for
    // Col 3 = Amount of the transaction
    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        Object returnMe = null;
        switch (columnIndex)
        {
            case 0:
                returnMe = BankAccount.dtf.print(transactions.get(rowIndex).getTransTime());
                break;
            case 1:
                returnMe = BankAccount.timeFormatter.print(transactions.get(rowIndex).getTransTime());
                break;
            case 2:
                returnMe = transactions.get(rowIndex).getTransType();
                break;
            case 3:
                returnMe = ("$" + transactions.get(rowIndex).getTransAmount());
                break;
        }
        return returnMe;
    }

    // Do not allow cells to be editted
    @Override
    public boolean isCellEditable(int row, int col)
    {
        return false;
    }

    // Set column name and class
    @Override
    public String getColumnName(int index)
    {
        return columnNames[index];
    }

    @Override
    public Class getColumnClass(int columnIndex)
    {
        return String.class;
    }
}
