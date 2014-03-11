/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bubblescout;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Jared
 */
public class ScoutSheets
{
    static String sourceFolder;
    static String filename;
    static Integer nextImageNumber;
    static BufferedImage image;
        
    //Method to open the next unscanned image
    public static boolean openNextSheet()
    {
        boolean allSheetsScanned = false;
        
        sourceFolder = "C:/Users/Jared/Dropbox/Programming/Scouting Software";
        
        //Find what the next image number is
        nextImageNumber = BubbleScout.csvFile.countScannedSheets() + 1;
        filename = nextImageNumber.toString();
        
        try {
            //Open next image file
            image = ImageIO.read(new File(sourceFolder + filename));
        } catch (IOException ex) {
            Logger.getLogger(ScoutSheets.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("End of available files, or open error.");
            allSheetsScanned = true;
        }
        
        return allSheetsScanned;
    }
    
    //Method to scan all unscanned images
    public static void scanAll() throws IOException
    {
        //Scan openNext and scanBubbles util file exception
        while(openNextSheet())
            BubbleScout.harvestSheetData();
        
    }//End of scanAll()
    
    public static void initialize(String imageSourceFolder)
    {
        sourceFolder = imageSourceFolder;
    }
}
