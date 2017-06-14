import javax.swing.*;
import java.io.*;
/**
 * An enemy that changes up the game by rerolling player's stats.
 */
public class Jester extends Enemy
{
    public Jester()
    {
        super();
        hp = 400;
        damage = 10;
        loot = 70;
        cooldown = 4;
        icon = new ImageIcon("Jester.jpg");
    }

    public ImageIcon intro()
    {
        System.out.println("You encounter an evil jester.");
        return icon;
    }

    public int attack(Player p)
    {
        int strike = super.attack(p);
        System.out.println("The jester slaps you for " + strike + " damage.");
        return strike;
    }

    /**
     * scrambles the players stats
     */
    public void special(Player p)
    {
        p.setStrength(0); // puts stat total off balance
        int hpSave = p.getHP();
        p.roll();
        p.setHP(hpSave);
        System.out.println("The jester plays a trick on you, rerolling your stats (permanently)!");
    }
}

