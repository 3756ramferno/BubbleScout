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
}
