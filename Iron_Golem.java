import javax.swing.*;
import java.io.*;
/**
 * A enemy whose durability becomes it's most effective weapon.
 */
public class Iron_Golem extends Enemy
{
    private int armor;
    public Iron_Golem()
    {
        super();
        hp = 750;
        damage = 20;
        loot = 250;
        cooldown = 3;
        armor = 0;
        icon = new ImageIcon("Iron_Golem.jpg");
    }

    public ImageIcon intro()
    {
        System.out.println("You encounter an iron golem.");
        return icon;
    }

    public int attack(Player p)
    {
        if (hp <= 100)
        {
            special(p);
            return 0;
        }
        int strike = super.attack(p);
        System.out.println("The iron golem smashes you for " + strike + " damage.");
        return strike;
    }

    /**
     * overrides setHP to give it damage mitigation
     */
    public void setHP(int x)
    {
        if(hp < x + armor) // if true, armor completely blocks damage.
        {
            System.out.println("The iron golem's armor completely negates the damage");
            return;
        }
        else if(armor > 0)
        {
            System.out.println("The iron golem's armor prevents " + armor + " of the " + (hp - x) + " damage.");
            
        }
        hp = x + armor;
    }

    /**
     * builds up armor, regenerates hp, explodes armor if it is greater than 100.
     */
    public void special(Player p)
    {
        if(armor < 100)
        {
            armor += 20;
            hp += 50;
            System.out.println("The iron golem builds up its armor,\ngaining damage resistance and restoring 50 HP.");
        }
        else
        {
            p.setHP(p.getHP() - armor);
            System.out.println("The iron golem's armor explodes and showers you with hot shrapnel");
            armor = 0;
        }
    }
}

