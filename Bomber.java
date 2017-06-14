import javax.swing.*;
import java.io.*;
/**
 * A high risk, high reward enemy
 */
public class Bomber extends Enemy
{
    public Bomber()
    {
        super();
        hp = 500;
        damage = 1;
        loot = 300;
        cooldown = 1;
        icon = new ImageIcon("Bomber.jpg");
    }

    public ImageIcon intro()
    {
        System.out.println("You encounter a sentient bomb.");

        return icon;
    }

    /**
     * 1/5 chance of Exploding
     */
    public void special(Player p)
    {
        if ((int)(Math.random() * 5) == 0)
        {
            setIcon(new ImageIcon("Explosion.jpg"));
            System.out.println("BOOM! The bomb explodes, along with all its treasure!");
            p.setHP(p.getHP() - 250);
            loot = 0;
            p.setLuck(1);
            hp = 0;
        }
        else
        {
            System.out.println("Tick...");
        }
    }
}

