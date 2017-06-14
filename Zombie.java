import javax.swing.*;
import java.io.*;
/**
 * Another weak enemy, but not as abusable as the Skeleton.
 */
public class Zombie extends Enemy
{
    public Zombie()
    {
        super();
        hp = 150;
        damage = 12;
        loot = 10;
        cooldown = 3;
        icon = new ImageIcon("Zombie.jpg");
    }
    public ImageIcon intro()
    {
        System.out.println("You encounter a zombie.");
        return icon;
    }
    public int attack(Player p)
    {
        int strike = super.attack(p);
        System.out.println("The zombie claws at you for " + strike + " damage.");
        return strike;
    }
    /**
     * decreases player's stats by 10%
     */
    public void special(Player p)
    {
        p.setStrength((int)(p.getStrength() *0.9));
        p.setAgility((int)(p.getAgility() *0.9));
        p.setWisdom((int)(p.getWisdom() *0.9));
        p.setConstitution((int)(p.getConstitution() *0.9));
        p.setLuck((int)(p.getLuck() *0.9));
        p.setHP((int)(p.getHP() *0.9));
        System.out.println("The zombie's cloud of decay decreases your stats and HP by 10%.");
    }
}
