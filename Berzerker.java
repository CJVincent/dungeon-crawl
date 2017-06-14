import javax.swing.*;
import java.io.*;
/**
 * A somewhat weak enemy with the potential to hit for a lot of damage.
 */
public class Berzerker extends Enemy
{
    public Berzerker()
    {
        super();
        hp = 300;
        damage = 10;
        loot = 40;
        cooldown = 3;
        icon = new ImageIcon("Berzerker.jpg");
    }
    public ImageIcon intro()
    {
        System.out.println("You encounter a crazed berzerker.");
        return icon;
    }
    public int attack(Player p)
    {
        int strike = super.attack(p);
        System.out.println("The Berzerker swings wildly in your general direction,\nhurting you for " + strike + " damage.");
        return strike;
    }
    /**
     * gains damage for each hp lost
     */
    public void special(Player p)
    {
        damage += 300 - hp;
        System.out.println("The Berzerker channels its pain into power,\nincreasing its damage by its lost HP.");
        attack(p);
    }
}

