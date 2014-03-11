/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bubblescout;

/**
 *
 * @author Jared
 */
import com.googlecode.jcsv.reader.CSVReader;
import com.googlecode.jcsv.reader.internal.CSVReaderBuilder;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
public class CSVFile 
{
    String newLineCharacter;
    String filename;
    PrintWriter output;
    
    String sourceFolderPath;
    Reader reader;

    CSVReader<String[]> csvParser = CSVReaderBuilder.newDefaultReader(reader);
    List<String[]> data;
    
    
    public CSVFile() throws FileNotFoundException, IOException
    {        
        
    }//End of constructor
    
    
    public CSVFile(String filename)
    {
        this.filename = filename;
        
    }//End of constructor
    
    void close()
    {
        try {
            csvParser.close();
        reader.close();
        } catch (IOException ex) {
            Logger.getLogger(CSVFile.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error closing CSV file...");
        }
    }    
    
    //Method to check the number of the last line in the CSV file so that the 
    //program doesn't rescan the same images.
    int countScannedSheets()
    {
        int lastImageNumber = 0;
        
        try {
            reader = new FileReader(filename);
            data = csvParser.readAll();
        } //End of
        catch (FileNotFoundException ex) {
            Logger.getLogger(CSVFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CSVFile.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error reading data (CSVFfile:readAll())");
        }
            
        //Find the total number of rows (/n chars), saving that number in lastImageNumber, remember to not count the header row
        
        
        
        return lastImageNumber;
    }
    
    //Method to add values to the CSV list waiting to be commited to file
    void addToQue(String queString)
    {
        
        
    }//End of addToQue()
    
    //Method to commit the string to a CSV file
    void commit()
    {
        
    }//End of commit
    
                void write(String writeString) throws IOException
                {
                   //Print update
                    System.out.println("Saving to " + filename);

                    //Create print writer, no append
                    output = new PrintWriter(new BufferedWriter (new FileWriter(filename)), true);

                    //Close file
                    output.close();

                }//End of write()
    
}
