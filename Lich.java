import javax.swing.*;
import java.io.*;
/**
 * An enemy designed to cripple player instead of outright killing.
 */
public class Lich extends Enemy
{
    public Lich()
    {
        super();
        hp = 550;
        damage = 1;
        loot = 100;
        cooldown = 5;
        icon = new ImageIcon("Lich.jpg");
    }
    public ImageIcon intro()
    {
        System.out.println("You encounter a lich.");
        return icon;
    }
    public int attack(Player p)
    {
        int strike = super.attack(p);
        System.out.println("The lich's chilling presence hurts you for " + strike + " damage.");
        return strike;
    }
    /**
     * cuts player's hp in half
     */
    public void special(Player p)
    {
        p.setHP(p.getHP() / 2 + 1);
        System.out.println("The lich drains your soul, cutting your HP in half!");
    }
}

