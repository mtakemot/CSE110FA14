/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

/**
 *
 * @author jdelapla
 */
public class TableListener implements TableModelListener
{

    @Override
    public void tableChanged(TableModelEvent e)
    {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        int row = e.getLastRow();
        int column = e.getColumn();

        System.out.println("Row " + row);
        System.out.println("Column " + column);
    }

}
