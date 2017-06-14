import javax.swing.*;
import java.io.*;
import java.util.*;
/**
 * Along with Vampire, the strongest enemy, focused on damage.
 */
public class Beholder extends Enemy
{
    public Beholder()
    {
        super();
        hp = 1000;
        damage = 10;
        loot = 300;
        cooldown = 1;
        icon = new ImageIcon("Beholder.jpg");
    }
    public ImageIcon intro()
    {
        System.out.println("You encounter a Beholder.");
        return icon;
    }
    public int attack(Player p)
    {
        int strike = super.attack(p);
        System.out.println("The Beholder blasts with lasers for you for " + strike + " damage.");
        return strike;
    }
    /**
     * chooses one of three deadly beams
     */
    public void special(Player p)
    {
        Random roll = new Random();
        int beam = (int)(Math.random() * 100);
        if(beam >= 0 && beam < 60)
        {
            System.out.println("The Beholder shoots a frost beam,\nfreezing you and using the time to attack twice.");
            attack(p);
            attack(p);
        }       
        if(beam >= 60 && beam < 90)
        {
            System.out.println("The Beholder shoots a charm beam,\nlowering your ability to fight and forces you to give it treasure.");
            attack(p);
            p.setTreasure(p.getTreasure() - 50);
            if(p.getTreasure() < 0)
            {
                p.setTreasure(0);
            }
            p.setStrength(p.getStrength() - 10);
            if(p.getStrength() < 0)
            {
                p.setStrength(0);
            }
        }
        if(beam >= 90 && beam < 100)
        {
            System.out.println("The Beholder shoots a beam of pure pain that reduces your HP by 2/3!");
            p.setHP(p.getHP() / 3);
        }
    }
}
