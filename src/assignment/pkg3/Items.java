//********************************************************************************
// PANTHERID:  Alex Estrugo - 5210961, Ernesto Rodriguez - 4138075
// CLASS: COP 2210 – [Spring 18]
// ASSIGNMENT # [4]
// DATE: [4/17/2018]
//
//PATHERID OF ORIGINAL CODER: [4138075]
//
// I hereby swear and affirm that this work is solely my own, and not the work 
// or the derivative of the work of someone else, except as outlined in the 
// assignment instructions.
//********************************************************************************
package assignment.pkg3;

/**
 *
 * @author Ernesto Rodriguez
 * @author Alex Estrugo
 */
public class Items
{

    private String[] arrayOfAllItems = {"Chest", "Candelabra", "Mirror", "Shower", "Refrigerator", "Cabinet", "Dusty recipe box",
                                        "Broom", "Rocking chair", "Window", "Mirror", "Shower", "Doll House", "Dresser", "Jewelry Box",
                                        "Intricate Oil Lamp", "Shower", "Attic Chest", "Storageroom Chest"};
    
    /**
     * When the player reaches a new room this function should be called. It will look for items appropriate 
     * to that room.
     *@author Ernesto Rodriguez
     * @param item1 the first item to look for
     * @param item2 the second item to look for
     * @param room used to look for special cases where the same item is in multiple rooms.
     * @return returns the names of the items as a string array
     */
    public String[] lookForItems(String item1, String item2, String room)
    {
        int i = 0;
        int j = 0;
        String[] obtainedItems = {null, null};
        do
        {
            if (specialCases(room) == null)
            {
                if (item1.equals(arrayOfAllItems[i]) || item2.equals(arrayOfAllItems[i]))
                {
                    obtainedItems[j] = arrayOfAllItems[i];
                    j++;               
                }
                if (j == obtainedItems.length)
                    break;            

                i++; 
            }
            else
                return specialCases(room);
        }
        while (i < arrayOfAllItems.length);
        return obtainedItems;
    }
    
    /**
     * Same method as above but only with one parameter.
     *@author Ernesto Rodriguez
     * @param item1 the name of the item we are looking for
     * @return returns a String array with all the items belonging to that room.
     */
    public String[] lookForItems(String item1)
    {
        int i = 0;
        int j = 0;
        String[] obtainedItems = {null, null};
        do
        {
            if (item1.equals(arrayOfAllItems[i]))
            {
                obtainedItems[j] = arrayOfAllItems[i];
                j++;               
            }
            i++;                
        }
        while (i < arrayOfAllItems.length);
        return obtainedItems;
    }
    
    /**
     * Removes an item permanently by replacing it with a null value. Once the item is removed from
     * the primary item array it will no longer show up in the game unless it is restarted.
     *@author Ernesto Rodriguez
     * @param lookingFor item we are removing from the primary array
     * @param room used for special cases where the same items are found in multiple rooms.
     */
    public void removeFromArray(String lookingFor, String room)
    {
        int i = 0;
        if (room.equals("Floor 3"))
        {
            arrayOfAllItems[2] = null;
            arrayOfAllItems[3] = null; 
        }
        else if(room.equals("Floor 8"))
        {
            arrayOfAllItems[10] = null;
            arrayOfAllItems[11] = null; 
        }
        else if(room.equals("Floor 11"))
        {
            arrayOfAllItems[15] = null;
            arrayOfAllItems[16] = null;            
        }
        else
        {
            while (i < arrayOfAllItems.length)
            {
                if (lookingFor.equals(arrayOfAllItems[i]))
                {               
                    arrayOfAllItems[i] = null;
                }
                i++;                
            }
        }
        
    }
    
    /**
     * A method uses to detect items that belong in multiple rooms.
     *@author Alex Estrugo
     * @return Will return a string array with the items that belong to these special cases
     * will return a null if the room being looked at is not a special case.
     * @param room the room we are looking at to identify if it is a special case.
     */
    private String[] specialCases(String room)
    {
        String[] obtainedItems = {null, null};
        if (room.equals("Floor 3"))
        {
            obtainedItems[0] = arrayOfAllItems[2];
            obtainedItems[1] = arrayOfAllItems[3]; 
            return obtainedItems;
        }
        else if(room.equals("Floor 8"))
        {
            obtainedItems[0] = arrayOfAllItems[10];
            obtainedItems[1] = arrayOfAllItems[11]; 
            return obtainedItems;
        }
        else if(room.equals("Floor 11"))
        {
            obtainedItems[0] = arrayOfAllItems[15];
            obtainedItems[1] = arrayOfAllItems[16]; 
            return obtainedItems;
        }
        return null;
    }
    
    public void restart()
    {
        arrayOfAllItems = new String[] {"Chest", "Candelabra", "Mirror", "Shower", "Refrigerator", "Cabinet", "Dusty recipe box",
                                    "Broom", "Rocking chair", "Window", "Mirror", "Shower", "Doll House", "Dresser", "Jewelry Box",
                                    "Intricate Oil Lamp", "Shower", "Attic Chest", "Storageroom Chest"};
    }
        
}
