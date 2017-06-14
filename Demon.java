import javax.swing.*;
import java.io.*;
/**
 * An enemy that offers little chance to heal. If encountered on low hp, running is pretty much only option.
 */
public class Demon extends Enemy
{
    public Demon()
    {
        super();
        hp = 750;
        damage = 30;
        loot = 200;
        cooldown = 1;
        icon = new ImageIcon("Demon.jpg");
    }
    public ImageIcon intro()
    {
        System.out.println("You encounter a demon.");
        return icon;
    }
    public int attack(Player p)
    {
        int strike = super.attack(p);
        System.out.println("The demon strikes you for " + strike + " damage.");
        return strike;
    }
    /**
     * 
     */
    public void special(Player p)
    {
        System.out.println("The demon curses you, setting your constitution to 0.");
        p.setConstitution(0);
        cooldown = Integer.MAX_VALUE;
    }
}

