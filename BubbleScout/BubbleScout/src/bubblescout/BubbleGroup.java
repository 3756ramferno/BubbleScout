/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bubblescout;

import java.util.ArrayList;

/**
 *
 * @author Jared
 */
public class BubbleGroup 
{
    static ArrayList <BubbleGroup> bubbleGroupList = new ArrayList <>();
    ArrayList <Bubble> bubbleList = new ArrayList <>();
    String name;
    
    void BubbleGroup(String name)
    {
        this.name = name;
    }//End of constructor
    
    int getNumberFilled()
    {
        int numFilled = 0;
        
        for(int x = 0; x < bubbleList.size(); x++)
            if(bubbleList.get(x).isFilled())
                numFilled++;
        
        return numFilled;
    }//End of getNumberFilled
    
}//End of class
