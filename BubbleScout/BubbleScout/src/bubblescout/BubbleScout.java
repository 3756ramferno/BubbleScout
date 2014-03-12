/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bubblescout;

import java.io.IOException;
import javax.swing.JFileChooser;

/**
 *
 * @author Jared
 */
public class BubbleScout 
{
    static CSVFile csvFile;
    static String csvFilename;
    
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException 
    {
        // TODO code application logic here
        
        
        /**************** TEST CODE ******************/
//        JFileChooser csvFileChooser = new JFileChooser();
//        csvFileChooser.setDialogTitle("Select csv file");
//        csvFilename = csvFileChooser.getSelectedFile().getAbsolutePath();
//        csvFile = new CSVFile(csvFilename);
        csvFile = new CSVFile("C:/Users/Jared/Documents/GitHub/BubbleScout/BubbleScout.txt2csv.csv");
        ScoutSheets.readTemplateData();
        ScoutSheets.selectFiles();
        ScoutSheets.scanAll();
    }
        
}//End of class
