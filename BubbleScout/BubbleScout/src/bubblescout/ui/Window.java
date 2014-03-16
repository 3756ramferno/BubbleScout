/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bubblescout.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Dale
 */
public class Window extends JFrame{
    public Window(String name, int x, int y){
        setTitle(name);
        setSize(x,y);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
