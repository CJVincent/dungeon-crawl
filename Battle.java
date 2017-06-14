import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
public class Battle
{
    public Player p;
    public Enemy e;
    /**
     * Sets up the two combatants
     */
    public Battle(Player plyr, Enemy enmy)
    {
        p = plyr;
        e = enmy;
    }

    /**
     * Plays out the fight between Player p and Enemy e, updating GUI when necessary.
     * Switches back and forth between player and enemy until one is dead.
     * @param the GUI object to be used
     */
    public void commence(DungeonCrawl c)
    {
        e.intro(); // Displays enemy introduction ("You encounter an x");
        ImageIcon icon = e.getIcon(); // stores enemy's image
        c.setVisible(true); // display GUI
        c.updateStats(e.getIcon()); // update stats of stat box
        c.startCombat(e.getIcon()); // display, attack, heal, run buttons, hide continue button
        System.out.println("Current HP: " + p.getHP());
        System.out.println("Current Enemy HP: " + e.getHP());
        while (p.isAlive() && e.isAlive()) // player and enemy take turns
        {
            if(p.isAlive() && e.isAlive())
            {
                while ((!c.playerAttacked() && !c.playerHealed() && !c.playerRan())) //waits for player
                { 
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Battle.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
            //reset flag variables
            c.setAttacked(false);
            c.setHealed(false);
            c.setRan(false);
            if(p.isEscaping()) // if player chose escape, and made escape attempt
            {
                break;
            }
            System.out.println("Current Enemy HP: " + e.getHP() + "\n");
            if(p.isAlive() && e.isAlive()) // enemy's turn, either attack or special
            {
                e.turn(p);
            }
            System.out.println("Current HP: " + p.getHP()+ "\n");
            c.updateStats(e.getIcon()); //update stats in stat box to reflect changes
        }
        //end of combat
        if(!p.isAlive()) //player is dead
        {
            c.endCombat(); // hide attack, heal, run buttons, show continue button
            c.updateStats(e.getIcon());
            return; //returns to DungeonCrawler
        }
        if(!e.isAlive()) // player wins
        {
            int spoils = giveLoot();
            p.restore();
            c.endCombat();
            if(spoils <= 0) //special case where treasure is gone, e.g after Bomber/Mimic battle
            {
                ImageIcon icon2 = new ImageIcon("Empty_Treasure.jpg"); 
                c.updateStats(icon2);
            }
            else
            {
                ImageIcon icon2 = new ImageIcon("Treasure.jpg");
                c.updateStats(icon2);
            }
        }
        else //player ran away
        {
            p.restore();
            c.endCombat();
            ImageIcon icon2 = new ImageIcon("Escape.jpg");
            c.updateStats(icon2);
            return; 
        }
    }

    /**
     * @return Player p.
     */
    public Player getPlayer()
    {
        return p;
    }

    /**
     * @return Enemy e.
     */
    public Enemy getEnemy()
    {
        return e;
    }

    /**
     * Gives the player their reward for winning
     */
    public int giveLoot()
    {
        Random roll = new Random();
        int spoils = 0;
        if(e.getLoot() <= 0)
            spoils = 0;
        else{spoils = roll.nextInt(p.getLuck()) + e.getLoot();}
        if(spoils <= 0)
        {
            System.out.println("You survived the battle, but you didn't get any treasure...");
        }
        p.setTreasure(p.getTreasure() + spoils);
        System.out.println("You defeat the enemy and gain " + spoils + " treasure. Your total treasure is now. " + p.getTreasure() +"\n");
        return spoils;
    }
}
