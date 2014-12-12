/**
 * **************************************************************************
 *
 * Ryan Bridges CSE 110, Fall 2014 Last Updated: December 12, 2014
 *
 * Team 42
 *
 * File Name: HeaderRenderer.java Description: This file simply defines a custom
 * HeaderRenderer for our JTables which will allow the names of the columns to
 * be centered
 * **************************************************************************
 */
package PresentationLayer;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Ryan
 */
public class HeaderRenderer implements TableCellRenderer
{

    DefaultTableCellRenderer renderer;

    public HeaderRenderer(JTable table) // ctor
    {
        renderer = (DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer();
        // Set the alignment of the column names in the JTable to CENTER
        renderer.setHorizontalAlignment(JLabel.CENTER);
    }

    @Override // Does nothing, must be overridden for TableCellRenderer
    public Component getTableCellRendererComponent(
            JTable table, Object value, boolean isSelected,
            boolean hasFocus, int row, int col)
    {
        return renderer.getTableCellRendererComponent(
                table, value, isSelected, hasFocus, row, col);
    }
}
