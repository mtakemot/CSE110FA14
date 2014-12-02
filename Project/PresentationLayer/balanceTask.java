/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import java.util.TimerTask;

/**
 *
 * @author Michio
 */
public class balanceTask extends TimerTask
{
    // private int = 0
   /* private GUI mainGUI;

     public void setGUI(GUI mainGUI){
     this.mainGUI = mainGUI;
     }*/

    @Override
    public void run()
    {
        System.out.println("MSG balanceTask.java: calling updateAverageBalance()");
        GUI.MasterTable.updateAverageBalance();

    }
}
