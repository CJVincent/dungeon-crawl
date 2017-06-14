import javax.swing.*;
/**
 * An enemy that becomes unsafe for healing over time.
 */
public class Orc extends Enemy
{
    public Orc()
    {
        super();
        hp = 350;
        damage = 25;
        loot = 50;
        cooldown = 4;
        icon = new ImageIcon("Orc.jpg");
    }
    public ImageIcon intro()
    {
        System.out.println("You encounter an orc.");
        return icon;
    }
    public int attack(Player p)
    {
        int strike = super.attack(p);
        System.out.println("The orc whacks you for " + strike + " damage.");
        return strike;
    }
    /**
     * lowers player's wisdom by 30
     */
    public void special(Player p)
    {
        p.setWisdom(p.getWisdom() - 30);
        System.out.println("The orc bonks you on the head, lowering your wisdom");
        if (p.getWisdom() < 0)
        {
            p.setWisdom(0);
        }

    }
}