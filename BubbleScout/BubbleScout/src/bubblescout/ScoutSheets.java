/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bubblescout;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

/**
 *
 * @author Jared
 */
public class ScoutSheets
{
    static Integer nextImageNumber;
    static BufferedImage image;
    static String[] imageFilenames;
    static File[] imageFiles;
    static String writeString = "";
        
    //Method to open the next unscanned image
    public static void openNextSheet(String filename)
    {        
        filename = nextImageNumber.toString();
        
        try {
            //Open next image file
            image = ImageIO.read(new File(filename));
        } catch (IOException ex) {
            Logger.getLogger(ScoutSheets.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("End of available files, or open error.");
        }
    }
    
    
    //Method to scan all unscanned images
    public static void scanAll() throws IOException
    {
        //Scan openNext and scanBubbles util file exception
        for(int x = 0; x < imageFilenames.length; x++)
        {
            openNextSheet(imageFilenames[x]);
            harvestSheetData();
        }
        
    }//End of scanAll()
    
    
    public static void selectFiles()
    {
//        JFileChooser fileChooser = new JFileChooser();
//        imageFiles = fileChooser.getSelectedFiles();
        imageFiles = new File[]{new File("C:/Users/Jared/Documents/GitHub/BubbleScout/BubbleScout/BubbleSheetScans/1")};    //Temporary
        
        for(int x = 0; x < imageFiles.length; x++)
            imageFilenames[x] = imageFiles[x].getAbsolutePath();
        
    }//End of selectFiles()
    
    
    public static void harvestSheetData()
    {
        System.out.println("Saving...");
        System.out.println("Collecting data from Bubbles...");
        
        writeString = "";
        //Add match number, team number, to beginning of string
        
        //Add bubblegroup data to string
        for(int x = 0; x < BubbleGroup.bubbleGroupList.size(); x++)
        {
            //Add number of filled bubbles to string
            writeString += BubbleGroup.bubbleGroupList.get(x).getNumberFilled();

            //Add comma separation character
            writeString += ",";
        }
        
        //Add new line character to end of string
        writeString += "/n";
        
        //Send string to csv file
        BubbleScout.csvFile.addToQue(writeString);
        BubbleScout.csvFile.commit();
        BubbleScout.csvFile.close();
                
    }//End of harvestSheetData()
    
    
    //Method to import the bubble groups and points from a file
    public static void readTemplateData() throws IOException
    {
        //Select template file
        String templateFilename;
        JFileChooser csvFileChooser = new JFileChooser();
        csvFileChooser.setDialogTitle("Select csv template file");
        templateFilename = csvFileChooser.getSelectedFile().getAbsolutePath();
        
        //Open template file
        System.out.println("Opening " + templateFilename + "...");
        BufferedReader in;
        in = new BufferedReader(new FileReader(templateFilename));
        
        
        //Extract data from csv template file
        String[] csValues;
        String inString;
        int xCoords;
        int yCoords;
        
        System.out.println("Reading template data...");
        
        while(true) //Breaks within the loop if the end of the file is reached
        {
            inString = in.readLine();
            if(inString.equals(""))
                break;              //Ends file reading loop
            
            csValues = inString.split(",");
            
            //Create new group with title
            BubbleGroup.bubbleGroupList.add(new BubbleGroup(csValues[0]));

            
            //Create bubbles with coordinates
            for(int x = 1; x < csValues.length; x+=2)
            {
                xCoords = Integer.parseInt(csValues[x]);
                yCoords = Integer.parseInt(csValues[x+1]);                
                
                //Creates a new bubble, in the last bubbleGroup, using the coordinated from the template file
                BubbleGroup.addBubble(xCoords, yCoords);
            }
        }                
        
        System.out.println("Closing template file...");
        in.close();
        
    }//End of readTemplateData()
    
}//End of class
