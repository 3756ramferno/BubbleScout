/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bubblescout;

import java.io.IOException;

/**
 *
 * @author Jared
 */
public class BubbleScout 
{
    static CSVFile csvFile;
    static String writeString = "";
    
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException 
    {
        // TODO code application logic here
        
        /**************** TEST CODE ******************/
        csvFile = new CSVFile();
        
        //570, 550 bubble
        ScoutSheets.initialize("C:/Users/Jared/Dropbox/Programming/Scouting Software");
        ScoutSheets.openNextSheet();
        ScoutSheets.scanAll();
    }
        
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
        csvFile.addToQue(writeString);
        csvFile.commit();
        csvFile.close();
                
    }//End of harvestSheetData()
}//End of class
