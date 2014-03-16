/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bubblescout.ui;

import java.util.HashMap;

/**
 *
 * @author Dale
 */
public class WindowManager {
    
    PanelManager PanelManager = new PanelManager();
    
    //WINDOW MAP//
    HashMap<String, Window> windows = new HashMap<String, Window>();
    
    public WindowManager(){
        // SETUP WINDOWS MAP
        windows.put("START",new Window("BubbleScout",600,400));
        windows.put("TPL",new Window("BubbleScout: Create Template",600,400));
        
        // ASSEMBLE GUI
        windows.get("START").add(PanelManager.startPanel());
    }

    public void display(String window) {
        windows.get(window).setVisible(true);
    }
    public void hide(String window) {
        windows.get(window).setVisible(false);
    }
    
}
