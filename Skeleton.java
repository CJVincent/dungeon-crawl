import javax.swing.*;
import java.io.*;
/**
 * The weakest and most common enemy, safe to use as a time to heal
 */
public class Skeleton extends Enemy
{
    public Skeleton()
    {
        super();
        hp = 100;
        damage = 10;
        loot = 5;
        cooldown = 1;
        icon = new ImageIcon("Skeleton.jpg");
    }
    public ImageIcon intro()
    {
        System.out.println("You encounter a skeleton.");
        return icon;
    }
    public int attack(Player p)
    {
        int strike = super.attack(p);
        System.out.println("The skeleton strikes you for " + strike + " damage.");
        return strike;
    }
    /**
     * no special ability
     */
    public void special(Player p)
    {
        attack(p);
    }
}
