import javax.swing.*;
import java.io.*;
/**
 * A high-damage enemy with relatively low health.
 */
public class Dragon extends Enemy
{
    public Dragon()
    {
        super();
        hp = 500;
        damage = 35;
        loot = 100;
        cooldown = 6;
        icon = new ImageIcon("Dragon.jpg");
    }
    public ImageIcon intro()
    {
        System.out.println("You encounter a mighty dragon.");
        return icon;
    }
    public int attack(Player p)
    {
        int strike = super.attack(p);
        System.out.println("The dragon swings at you for " + strike + " damage.");
        return strike;
    }
    /**
     * deals 100 damage to the player
     */
    public void special(Player p)
    {
        p.setHP(p.getHP() - 100);
        System.out.println("The dragon breaths fire at you for 100 damage!");
    }
}