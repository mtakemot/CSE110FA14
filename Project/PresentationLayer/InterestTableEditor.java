/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import javax.swing.DefaultCellEditor;
import javax.swing.JTextField;

/**
 *
 * @author Ryan
 */
public class InterestTableEditor extends DefaultCellEditor
{

    public InterestTableEditor(JTextField jtf)
    {
        super(jtf);
    }

    @Override
    public boolean stopCellEditing()
    {
        return true;
    }
}
