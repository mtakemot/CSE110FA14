/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ryan
 */
public class InterestTableModel extends AbstractTableModel
{

    private String[] columnNames =
    {
        "Account Type", "Less than $1000", "$1000-$2000",
        "$2000-$3000"
    };

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
    public Object getValueAt(int i, int i1)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
