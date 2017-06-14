import javax.swing.*;
import java.io.*;
/**
 * An enemy that gets more lethal as time as goes on, because low Agility means high crit chance for enemy.
 */
public class Spider extends Enemy
{
    public Spider()
    {
        super();
        hp = 300;
        damage = 15;
        loot = 25;
        cooldown = 4;
        icon = new ImageIcon("Spider.jpg");
    }
    public ImageIcon intro()
    {
        System.out.println("You encounter a spider.");
        return icon;
    }
    public int attack(Player p)
    {
        int strike = super.attack(p);
        System.out.println("The spider spits venom at you for " + strike + " damage.");
        return strike;
    }
    /**
     * lowers player's agility by 30
     */
    public void special(Player p)
    {
        p.setAgility(p.getAgility() - 30);
        System.out.println("The spider shoots web at you, lowering you agility.");
        if (p.getAgility() < 0)
        {
            p.setAgility(0);
        }
    }
}

