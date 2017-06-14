import javax.swing.*;
import java.io.*;
/**
 * A powerful enemy at the start, but if the player can weather the storm, then he becomes weak.
 */
public class Ogre extends Enemy
{
    public Ogre()
    {
        super();
        hp = 600;
        damage = 60;
        loot = 70;
        cooldown = 3;
        icon = new ImageIcon("Ogre.jpg");
    }

    public ImageIcon intro()
    {
        System.out.println("You encounter an ogre.");
        icon = new ImageIcon("Ogre.jpg");
        return icon;
    }

    public int attack(Player p)
    {
        int strike = super.attack(p);
        System.out.println("The ogre punches you for " + strike + " damage.");
        return strike;
    }

    /**
     * starts off strong, gets weaker as fight goes on.
     */
    public void special(Player p)
    {
        p.setHP(p.getHP() - damage - 20);
        damage -= 20;
        if(damage < 1)
            damage = 1;  
        System.out.println("The ogre brutally punches you for " + (damage + 20) + " damage, tiring itself out a bit.");
    }
}
