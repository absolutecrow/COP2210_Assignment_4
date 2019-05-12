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

import static assignment.pkg3.Game.backpack;
import static assignment.pkg3.Game.endingDialog;
import static assignment.pkg3.Game.endingTextBag;
import static assignment.pkg3.Game.endingTextEffect;
import static assignment.pkg3.Game.itemsGUI;
import static assignment.pkg3.Game.itemsInBackpack;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * 
 * @author Ernesto Rodriguez
 * @author Alex Estrugo
 */
public class Player
{
    private final Rooms player = new Rooms();   
    private static String playerName = new String();
    
    /**
     * Will store the player name entered into the playerName var.
     * @param playerName the player name being passed from the GUI into the Player class.
     * @author Ernesto Rodriguez
     */
    public void setPlayerName(String playerName)
    {
        Player.playerName = playerName;
    }
    
    /**
     * Will return the name that the user inputted.
     * @return The name of the player as a String.
     * @author Ernesto Rodriguez
     */
    public static String getPlayerName()
    {
        return playerName; 
    }
    
    /**
     * Method used to control the flow of the elevator. 
     * 2 Exclusive scenario used to check for the in-game Keys.
     * @param floor_number the number the player asked to go to.
     * @author Alex Estrugo
     */
    public void elevatorControl(String floor_number)
    {
        if (floor_number.equals("Floor 12") && !itemsInBackpack.contains("Key #1"))
        {
            Game.addToDiary("I attempted to open the elevator door, but it seemed to be lock. The elevator suddenly dropped when I attempted to open the door. I seem to be back on the first floor.");
            player.locationUpdater("Floor 1");
        }
        else if (floor_number.equals("Floor 12") && itemsInBackpack.contains("Key #1"))
        {
            Game.addToDiary("I located a hole on the elevator door and put in a key. The door successfully opened.");
            player.locationUpdater("Floor 12");
        }
        else if (floor_number.equals("Floor 1") && itemsInBackpack.contains("Key #2"))
        {
            Game.addToDiary("This key fits into this door. I may be able to escape.");
            player.locationUpdater("Floor 1_escapeoption");
        }
        else
            player.locationUpdater(floor_number);
    }
    
    /**
     * Displays the ending.
     *@author Ernesto Rodriguez
     */
    public void beatTheGame()
    {
        endingTextBag.setText("You beat the game!");
        endingTextEffect.setText("If you would like to play again. Click \"Restart\" below.");
        endingDialog.setTitle("Victory");
        endingDialog.setVisible(true);
    }
       
    /**
     * Used to move the character left.
     *@author Alex Estrugo
     */
    public void move_down()
    {
        if (!(player.getLocation().equals("Floor 0") || (player.getLocation().equals("outside"))))
        {
            player.locationUpdater("elevator");
        }
        else if (player.getLocation().equals("Floor 0"))
        {
            player.locationUpdater("floor0_storageroom");
        }
    }
    
    /**
     * Used to move the character up
     *@author Alex Estrugo
     */
    public void move_up()
    {
        if (player.getLocation().equals("floor0_storageroom"))
        {
            player.locationUpdater("elevator");
        }
        else if (player.getLocation().equals("Floor 0"))
        {
            player.locationUpdater("floor0_boilerroom");
        }
        else if (player.getLocation().equals("Floor 1_escapeoption"))
        {
            player.locationUpdater("outside");
            beatTheGame();
        }
    }   
    
    /**
     * Used to move the character right
     *@author Alex Estrugo
     */
    public void move_right()
    {
        if (player.getLocation().equals("floor0_boilerroom"))
        {
            player.locationUpdater("floor0_storageroom");
        }
    }
    
    /**
     * Used to move the character left
     *@author Alex Estrugo
     */
    public void move_left()
    {
        if (player.getLocation().equals("floor0_storageroom"))
        {
            player.locationUpdater("floor0_boilerroom");
        }
    }
    
    
    /**
     * Long list of if-else statements checking for the effect of each item.
     * Will print the effect to the endingDialog or infoDialog depending if the item kills the player or not.
     * @param item the item being checked.
     * @param examineLabel the dialog window label
     * @param textEffect the dialog window effect text area
     *@author Ernesto Rodriguez
     */
    public void explore_items(String item, JTextField examineLabel, JTextArea textEffect)
    { 
        
        examineLabel.setText("You get a " + backpack.getSelectedValue() + " from your bag and carefully examined it.");
                  
        if (item.equals("Chest"))
        {
            textEffect.setText("A ghost escapes and scares you to death.");
        }
        else if (item.equals("Candelabra"))
        {
            textEffect.setText("They light up by themselves and see a death shadow.");
        }
        else if (item.equals("Refrigerator"))
        {
            textEffect.setText("You open it and find some delicious soul food.");
        }
        else if (item.equals("Cabinet"))
        {
            textEffect.setText("The dishes and glasses start flying at you as soon as you open the door. You get hit in the head and feel yourself start moving towards a light.");
        }
        else if (item.equals("Dusty recipe box"))
        {
            textEffect.setText("You open it up and a recipe for chocolate devils food cake appears our of no where.");
        }
        else if (item.equals("Broom"))
        {
            textEffect.setText("It flies up in the air as soon as you touch it.");
        }
        else if (item.equals("Mirror"))
        {
            textEffect.setText("You see a bloody face looking back at you.");
        }
        else if (item.equals("Shower") && (player.getLocation().equals("Floor 3") || player.getLocation().equals("Floor 8")))
        {
            textEffect.setText("The room suddenly steams up and you feel fingers touching the back of your neck.");
        }
        else if (item.equals("Rocking chair"))
        {
            textEffect.setText("The chair starts rocking by itself with no one on it.");
        }
        else if (item.equals("Window"))
        {
            textEffect.setText("You see a child outside on a swing who suddenly disappears.");
        }
        else if (item.equals("Doll House"))
        {
            textEffect.setText("The dolls start dancing on their own.");
        }
        else if (item.equals("Dresser"))
        {
            textEffect.setText("A ghost flies out of the dresser as soon as you open it and goes right though your body.");
        }
        else if (item.equals("Jewelry Box"))
        {
            textEffect.setText("You find the cursed Hope Diamond and feel your doom.");
        }
        else if (item.equals("Intricate Oil Lamp"))
        {
            textEffect.setText("Rub the lamp and a genie pops out who says he’ll grant you 3 wishes.");
        }
        else if (item.equals("Shower") && player.getLocation().equals("Floor 11"))
        {
            textEffect.setText("Suddenly hear singing in the shower, but no one is there.");
        }
        else if (item.equals("Storageroom Chest"))
        {
            textEffect.setText("You open up the chest and find a key inside. You begin to wonder if this key is a spook or just a regular old key. Either way you put in your bag.");
            itemsInBackpack.addElement("Key #1");
            itemsInBackpack.removeElement("Storageroom Chest");
        }
        else if (item.equals("Attic Chest"))
        {
            textEffect.setText("Another key inside this chest. I wonder where this one will lead me too.");
            itemsInBackpack.addElement("Key #2");
            itemsInBackpack.removeElement("Attic Chest");
        }
        else if (item.equals("Key #1"))
        {
            textEffect.setText("It's a key.");
        }
        else if (item.equals("Key #2"))
        {
            textEffect.setText("It's a happy key.");
        }

    }
    
    /**
     * Adding the item from the list to the bag. 
     * Removes the item from the item array by replacing it with a null
     *@author Ernesto Rodriguez
     */
    public void add_items_to_bag()
    {
        itemsInBackpack.addElement(itemsGUI.getSelectedValue());
        player.removeItemAfterAdding(itemsGUI.getSelectedValue());
    }
    
    /**
     * Places all variables to the initial conditions. 
     * Serves as a way to reset the game.
     *@author Alex Estrugo
     */
    public void execute_restart()
    {
        player.restart();      
    }

}
