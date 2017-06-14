import javax.swing.*;
import java.io.*;
import java.util.*;
/**
 * A very hard-hitting enemy. Very dangerous if not killed quickly.
 */
public class Shade extends Enemy
{
    private int wisdom;
    private int constitution;
    public Shade()
    {
        super();
        hp = 1000;
        damage = 1;
        loot = 200;
        cooldown = 1;
        wisdom = 0;
        icon = new ImageIcon("Shade.jpg");
    }

    public ImageIcon intro()
    {
        System.out.println("You encounter a sinister shade.\nThe shade takes on your form, gaining your abilities. ");
        return icon;
    }

    public int attack(Player p)
    {
        if(hp > 250)
        {
            int strike = super.attack(p);
            System.out.println("The shade strikes you for " + strike + " damage.");
            return strike;
        }
        else
        {
            heal();
            return 0;
        }

    }

    public void heal()
    {
        Random roll = new Random();
        int heal = roll.nextInt(50) + (wisdom / 3);
        if (hp + heal > (constitution * 6))
        {
            hp = constitution * 6; // prevents overhealing
        }
        else
        {
            hp += heal;
        }
        System.out.println("The shade heals for " + heal + " health.\n");
    }

    /**
     * copies the player's stats
     */
    public void power_Up(Player p)
    {
        constitution = p.getConstitution();
        hp = constitution * 6;
        damage = p.getStrength();
        wisdom = p.getWisdom();
    }

    /**
     * no special ability
     */
    public void special(Player p)
    {
        attack(p);
    }

}

