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

import javax.swing.ImageIcon;
import static assignment.pkg3.Game.playerIndicator;
import static assignment.pkg3.Game.itemsInRoomList;
import static assignment.pkg3.Game.elevatorDialog;
import static assignment.pkg3.Game.itemsInBackpack;


/**
 *
 * @author Ernesto Rodriguez
 * @author Alex Estrugo
 */
public class Rooms
{
    private String currentLocation;
    private static final int NUMBER_OF_ITEMS = 2;
    private String[] itemsInRoom;
    private Items items = new Items();
    
    public Rooms()
    {
        itemsInRoom = new String[NUMBER_OF_ITEMS];
        currentLocation = "Floor 1";
    }
    
    /**
     * Displays the elevatorDialog when the player enters the elevator.
     *@author Alex Estrugo
     */
    private void hasReachedElevator()
    {
        elevatorDialog.setVisible(true);
    }
    
    /**
     * When the player attempts to move to a new room, depending on which direction they moved, updates the current location.
     *@param room the room the player is going to
     *@author Ernesto Rodriguez
     */   
    public void locationUpdater(String room)
    {
        currentLocation = room;
        playerIndicator.setIcon(new ImageIcon(getClass().getResource("/assignment/pkg3/locations/" + room + ".png")));  
        itemsInRoom(room);
        addItemsToList(itemsInRoom);
        flavorText(room);
        
        if(currentLocation.equals("elevator"))
        {
            hasReachedElevator();
        }
    }
    
    /**
     * Will add flavor text to the dairy as the player moves between floors.
     *@param room the room to add flavor text into
     *@author Alex Estrugo
     */  
    public void flavorText(String room)
    {
        if (room.equals("floor0_boilerroom"))
        {
            Game.addToDiary("There seems to be nothing here.");
        }
        else if (room.equals("Floor 2"))
        {
            Game.addToDiary("I'm starting to hear whispers. I feel a spook nearby.");
        }
        else if (room.equals("Floor 4"))
        {
            Game.addToDiary("There are some leftovers around the dining table being lit by a Candelabra.");
        }
        else if (room.equals("Floor 5"))
        {
            Game.addToDiary("The refrigerator seems to be eating something.");
        }
        else if (room.equals("Floor 9"))
        {
            Game.addToDiary("What cute dolls! They are even playing with each other!");
        }
    }
    
    /**
     * Will attempt to get the items that belong to that room.
     * @param room the room your attempting to get the items for.
     *@author Ernesto Rodriguez
     */
    private void itemsInRoom(String room)
    {
        if (room.equals("floor0_storageroom"))
        {
            itemsInRoom = items.lookForItems("Storageroom Chest");
        }
        else if (room.equals("Floor 2"))
        {
            itemsInRoom = items.lookForItems("Chest");
        }
        else if (room.equals("Floor 3"))
        {
            itemsInRoom = items.lookForItems("Mirror", "Shower", room);
        }
        else if (room.equals("Floor 4"))
        {
            itemsInRoom = items.lookForItems("Candelabra");
        }
        else if (room.equals("Floor 5"))
        {
            itemsInRoom = items.lookForItems("Refrigerator","Cabinet", room);
        }
        else if (room.equals("Floor 6"))
        {
            itemsInRoom = items.lookForItems("Dusty recipe box","Broom", room);
        }
        else if (room.equals("Floor 7"))
        {
            itemsInRoom = items.lookForItems("Rocking chair","Window", room);
        }
        else if (room.equals("Floor 8"))
        {
            itemsInRoom = items.lookForItems("Mirror","Shower", room);
        }
        else if (room.equals("Floor 9"))
        {
            itemsInRoom = items.lookForItems("Doll House","Dresser", room);
        }
        else if (room.equals("Floor 10"))
        {
            itemsInRoom = items.lookForItems("Jewelry Box");
        }
        else if (room.equals("Floor 11"))
        {
            itemsInRoom = items.lookForItems("Intricate Oil Lamp","Shower", room);
        }
        else if (room.equals("Floor 12"))
        {
            itemsInRoom = items.lookForItems("Attic Chest");
        }
        else
        {
            itemsInRoom[0] = null;
            itemsInRoom[1] = null;
        }
    }
    
    /**
     * Returns the current location of the player as a string.
     *@author Alex Estrugo
     * @return a string stating the player's current location.
     */
    public String getLocation()
    {
        return currentLocation;
    }
    
    /**
     * Places all variables to the initial conditions. 
     * Serves as a way to reset the game.
     *@author Alex Estrugo
     */
    public void restart()
    {
        currentLocation = "Floor 1";
        playerIndicator.setIcon(new ImageIcon(getClass().getResource("/assignment/pkg3/locations/Floor 1.png")));
        itemsInRoomList.clear();
        itemsInBackpack.clear();
        clearAllItems(itemsInRoom);
        items.restart();
    }
    
    /**
     * Add items to the main game GUI items in the room list.
     * @param item the string array you want to add the to the items in the room list.
     *@author Ernesto Rodriguez
     */
    private void addItemsToList(String[] item)
    {
        itemsInRoomList.clear();
        for (int i = 0; i < NUMBER_OF_ITEMS; i++)
        {
            if (item[i] != null)
                itemsInRoomList.addElement(item[i]);
        }       
    }
    
    /**
     * Used to get rid of all items in a room by replacing it with a null value. Mainly used for the restart function.
     * @param item the array you want to be replaced with null value.
     *@author Ernesto Rodriguez
     */
    private void clearAllItems(String[] item)
    {
        for (int i = 0; i < NUMBER_OF_ITEMS; i++)
            item[i] = null;
    }
    
    /**
     * Moves item from the items in room list to backpack list.
     * @param item item to remove from the room list and add to the backpack list
     *@author Alex Estrugo
     */
    public void removeItemAfterAdding(String item)
    {
        itemsInRoomList.removeElement(item);
        items.removeFromArray(item, currentLocation);
    }
    

    
    
       
}
