/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bubblescout.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Dale
 */
public class Router implements ActionListener{
    /*
    Delegates Tasks to sub-methods to handle user-input on Swing Comps
    */

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        System.out.println(cmd);
        
        if(cmd.equals("Setup New Template")){
            //Load New Window
            
        }else if(cmd.equals("Load Sheets")){
            
        }
    }
}
