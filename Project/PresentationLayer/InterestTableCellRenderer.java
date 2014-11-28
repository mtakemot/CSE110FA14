/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import java.awt.Component;
import java.text.DecimalFormat;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Ryan
 */
public class InterestTableCellRenderer extends DefaultTableCellRenderer
{

    private static final DecimalFormat formatter = new DecimalFormat(".##%");

    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column)
    {
        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus,
                row, column);
        value = formatter.format((Number) value);
        return component;
    }
}
