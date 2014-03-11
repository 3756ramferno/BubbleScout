/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bubblescout;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.image.ColorModel;

/**
 *
 * @author Jared
 */
public class Bubble
{
    int xCoordinate;
    int yCoordinate;
    final int BUBBLE_WIDTH = 30;
    final int BUBBLE_HEIGHT = 30;
    int darknessThreshold = 50;
    
    
    void Bubble(int xCoordinate, int yCoordinate)
    {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }//End of constructor
    
    
    //Checks if the Bubble is filled in, returns a boolean
    boolean isFilled()
    {
        int shadeCount = 0;
        int pixelCount = 0;
        int averageShade;
        boolean isFilled;
        
        
        //Check coordinates for pixel colors
        for(int x = 0; x < BUBBLE_WIDTH;  x++)
        {
            for(int y = 0; y < BUBBLE_HEIGHT; y++)
            {
                shadeCount += ScoutSheets.image.getData(new Rectangle(xCoordinate, yCoordinate, BUBBLE_WIDTH, BUBBLE_HEIGHT)).getSample(x, y, 0);
                pixelCount++;
            }
        }
        
        //Average RGB pixel shade from array
        averageShade = shadeCount / pixelCount;
        if(averageShade >= darknessThreshold)
            isFilled = true;
        else
            isFilled = false;
        
        return isFilled;
    }//End of checkIsFilled()
    
}//End of class
