/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Backend.TableWrapper;
import Backend.UserAccount;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author rbridges
 */
public class TableModel extends AbstractTableModel {

    private int colCount = 3;
    private UserAccount current;
    private TableWrapper wrapper;
    private String[] columnNames = {"Account Name", "Account Type",
        "Account Balance"};

    public TableModel(UserAccount curr) {
        this.current = curr;
        wrapper = new TableWrapper(this.current);
    }

    @Override
    public int getRowCount() {
        return current.getNumOfBankAccounts();
    }

    @Override
    public int getColumnCount() {
        return colCount;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object returnMe = null;
        switch (columnIndex) {
            case 3:
                returnMe = wrapper.getAccountBalance(rowIndex);
            case 2:
                returnMe = wrapper.getAccountType(rowIndex);
            case 1:
                returnMe = wrapper.getAccountName(rowIndex);
        }
        return returnMe;
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return false;
    }

    @Override
    public String getColumnName(int index) {
        return columnNames[index];
    }
}
