/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bubblescout.ui;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Dale
 */
public class Image extends JLabel{
	public Image(String img){
		super(new ImageIcon(getImage(img)));
	}
	
	public static BufferedImage getImage(String img){
		BufferedImage lblPic = null;
		try {
			lblPic = ImageIO.read(new File("assets/img/"+img));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lblPic;
	}
}
