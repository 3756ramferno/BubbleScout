/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bubblescout.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import bubblescout.ui.Router;
import java.awt.GridLayout;

/**
 *
 * @author Dale
 */
public class PanelManager {
    Router router = new Router();
    public JPanel startPanel(){
        JPanel pane = new JPanel(new BorderLayout());
        JPanel btnPane = new JPanel();
        Image logo = new Image("logo.png");
        JButton btnNewTemplate = new JButton("Setup New Template");
        JButton btnLoadSheets = new JButton("Load Sheets");
        logo.setPreferredSize(new Dimension(100,100));
        btnNewTemplate.setPreferredSize(new Dimension(220,40));
        btnLoadSheets.setPreferredSize(new Dimension(220,40));
        btnPane.setPreferredSize(new Dimension(220,80));
        logo.setHorizontalAlignment(SwingConstants.CENTER);  
        
        btnNewTemplate.addActionListener(router);
        btnLoadSheets.addActionListener(router);
        
        btnPane.add(btnNewTemplate);
        btnPane.add(btnLoadSheets);
        pane.add(logo, BorderLayout.PAGE_START);
        pane.add(btnPane, BorderLayout.CENTER);
        
        return pane;
    }
    
    // TPL PANEL
    public JPanel tplPanel(){
        JPanel pane = new JPanel(new BorderLayout());      
        pane.add(tplPanel_aside(), BorderLayout.WEST);
        
        return pane;
    }
    public JPanel tplPanel_aside(){
        JPanel pane = new JPanel();
        pane.setPreferredSize(new Dimension(200,400));
        
        //LOGO - STATIC
        Image logo = new Image("logo.png");
        logo.setPreferredSize(new Dimension(200,100));
        pane.add(logo);
        
        //BubbleGroups - Dynamic
        pane.add(tplPanel_aside_Group("EXAMPLE GROUP 1"));
        pane.add(tplPanel_aside_Group("EXAMPLE GROUP 2"));
        pane.add(tplPanel_aside_Group("EXAMPLE GROUP 3"));
        pane.add(tplPanel_aside_Group("EXAMPLE GROUP 4"));
        pane.add(tplPanel_aside_Group("EXAMPLE GROUP 5"));
        
        return pane;
    }
    public JPanel tplPanel_aside_Group(String group){
        JPanel pane = new JPanel();
        
        JButton groupTitle = new JButton(group);
        groupTitle.addActionListener(router);
        groupTitle.setPreferredSize(new Dimension(200,50));
        
        pane.add(groupTitle);
        
        return pane;
    }
}
