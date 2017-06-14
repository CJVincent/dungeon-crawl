import javax.swing.*;
import java.io.*;
/**
 * Along with Vampire, the strongest enemy, focused on endurance.
 */
public class Vampire extends Enemy
{
    private boolean batForm;
    public Vampire()
    {
        super();
        hp = 1000;
        damage = 20;
        loot = 300;
        cooldown = 1;
        batForm = false;
        icon = new ImageIcon("Vampire.jpg");
    }

    public ImageIcon intro()
    {
        System.out.println("You encounter a Vampire.");
        return icon;
    }

    /**
     * drains life equal to damage
     */
    public int attack(Player p)
    {
        int strike = super.attack(p);
        System.out.println("The vampire drains your life force for " + strike + " damage.");
        hp += strike;
        return strike;
    }

    /**
     * overrides setHP to give it chance to dodge
     */
    public void setHP(int x)
    {
        if(batForm)
        {
            int dodge = (int)(Math.random() * 100);
            if(dodge > 60)
            {
                System.out.println("The bat's too fast! Your attack missed!");
                return;
            }
            else
            {
                super.setHP(x);
            }
        }
        else
        {
            super.setHP(x);
        }
    }

    /**
     * turns to bat form, gaining ability to dodge at expense of damage
     */
    public void special(Player p)
    {
        if (hp < 250 && !batForm)
        {
            batForm = true;
            setIcon(new ImageIcon("Bat_Form.jpg"));
            setDamage(10);
            System.out.println("The vampire turns into a bat,\nmaking him hard to hit, but also lowering his attack power.");
        }
        attack(p);
    }
}

