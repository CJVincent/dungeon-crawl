import javax.swing.*;
import java.io.*;
/**
 * An enemy that is simultaneously harmless and lethal.
 */
public class Slime extends Enemy
{
    public Slime()
    {
        super();
        hp = 200;
        damage = 1;
        loot = 45;
        cooldown = 1;
        icon = new ImageIcon("Slime.jpg");
    }

    public ImageIcon intro()
    {
        System.out.println("You encounter a Gelatinous Cube.");
        return icon;
    }

    /**
     * Grows each turn, and kills the player instantly if it gets too big (size represented by hp);
     */
    public void special(Player p)
    {
        System.out.println("The cube grows ominously...");
        hp += (int) (Math.random() * 100) + 25;
        if(hp >= 500)
        {
            System.out.println("The cube has grown so big it swallows you whole. Game Over.");
            p.setHP(0);
        }
    }
}
