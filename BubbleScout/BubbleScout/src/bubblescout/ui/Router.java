/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bubblescout.ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractButton;

/**
 *
 * @author Dale
 */
public class Router implements ActionListener{
    /*
    Delegates Tasks to sub-methods to handle user-input on Swing Comps
    */
    
    Object bubbleGroupActive = null;
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        Object src = e.getSource();
        System.out.println(cmd);
        
        if(cmd.equals("Setup New Template")){
            bubblescout.BubbleScout.WindowManager.hide("START");
            bubblescout.BubbleScout.WindowManager.display("TPL");
            
        }else if(cmd.equals("Load Sheets")){
            bubblescout.BubbleScout.WindowManager.hide("TPL");
            bubblescout.BubbleScout.WindowManager.display("START");
            
        }else{
            bubbleGroupActive = src;
            ((AbstractButton) bubbleGroupActive).setForeground(Color.WHITE);
            ((AbstractButton) bubbleGroupActive).setBackground(Color.BLUE);
        }
    }
}
