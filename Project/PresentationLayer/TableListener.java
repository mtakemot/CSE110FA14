package PresentationLayer;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

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
