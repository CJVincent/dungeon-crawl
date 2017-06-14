import javax.swing.*;
import java.io.*;
/**
 * A weak enemy that can be used for healing, at expense of losing treasure.
 */
public class Goblin extends Enemy
{
    public Goblin()
    {
        super();
        hp = 250;
        damage = 15;
        loot = 30;
        cooldown = 2;
        icon = new ImageIcon("Goblin.jpg");
    }
    public ImageIcon intro()
    {
        System.out.println("You encounter a goblin.");
        return icon;
    }
    public int attack(Player p)
    {
        int strike = super.attack(p);
        System.out.println("The goblin shanks you for " + strike + " damage.");
        return strike;
    }
    /**
     * steals 20 treasure from player
     */
    public void special(Player p)
    {
        p.setTreasure(p.getTreasure() - 20);
        System.out.println("The goblin steals 20 treasure from you.");
        if (p.getTreasure() < 0)
        {
            p.setTreasure(0);
        }

    }
}