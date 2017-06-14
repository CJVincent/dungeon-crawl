import javax.swing.*;
import java.io.*;
/**
 * An enemy that gives a lot of treasure if killed quickly
 */
public class Mimic extends Enemy
{
    public Mimic()
    {
        super();
        hp = 800;
        damage = 15;
        loot = 200;
        cooldown = 3;
        icon = new ImageIcon("Mimic.jpg");
    }
    public ImageIcon intro()
    {
        System.out.println("You encounter a treasure chest! A monstrous one, that is.");
        return icon;
    }
    /**
     * Decreases its treasure count every time it attacks. When it runs out, the fight ends.
     */
    public int attack(Player p)
    {
        int strike = super.attack(p);
        System.out.println("The monster treasure chest spits some jewels at you for " + strike + " damage.");
        loot -= strike;
        if(loot <= 0)
        {
            loot = 0;
            System.out.println("The monster chest has spat out all its treasure! No point in fighting it now...");
            p.setLuck(0);
            hp = 0;
        }
        return strike;
    }
    /**
     * Does 60 damage and decreases its treasure amount considerably
     */
    public void special(Player p)
    {
        p.setHP(p.getHP() - 60);
        System.out.println("The monster chest spits a large, spiky crown at you, dealing 60 damage.");
        loot -= 60;
        if(loot <= 0)
        {
            loot = 0;
            System.out.println("The monster chest has spat out all its treasure! No point in fighting it now...");
            p.setLuck(0);
            hp = 0;
        }    
        
    }
}

