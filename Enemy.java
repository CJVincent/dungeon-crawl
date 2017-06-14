import java.util.*;
import javax.swing.*;
public abstract class Enemy
{
    protected int hp, damage, loot, cooldown, turn;
    protected ImageIcon icon;
    public Enemy()
    {
        hp = 10; // starting hp
        damage = 10; // attack strength
        loot = 10; // base treasure received when killed
        cooldown = 3; // turns inbetween uses of special. Cooldown of 1 means it's used every turn
        turn = 0; // turn counter, doesn't need overriding
        icon = null; // image displayed
    }

    /**
     * Occurs when enemy is encountered. Displays enemy introduction and image
     */
    public abstract ImageIcon intro();

    /**
     * set icon to i
     */
    public void setIcon(ImageIcon i)
    {
        icon = i;
    }
    
    
    /**
     * set hp to x
     */
    public void setHP(int x)
    {
        hp = x;
    }

    /**
     * set loot to x
     */
    public void setLoot(int x)
    {
        loot = x;
    }

    /**
     * set damage to x
     */
    public void setDamage(int x)
    {
        damage = x;
    }

    /**
     * @return damage
     */
    public int getDamage()
    {
        return damage;
    }

    /**
     * @return hp
     */
    public int getHP()
    {
        return hp;
    }

    /**
     * @return loot
     */
    public int getLoot()
    {
        return loot;
    }

    /**
     * @return icon
     */
    public ImageIcon getIcon()
    {
        return icon;
    }
    /**
     * check if enemy is still alive (hp is greater than 0)
     */
    public boolean isAlive()
    {
        return hp > 0;
    }
    /**
     * Makes the enemy stronger based on player level
     */
    public void power_Up(Player p)
    {
        hp += 20 * p.getLevel();
        damage += 10 * p.getLevel();
    }
    /**
     * increments turn counter, attacks if alive and special ability is still on cooldown, uses special otherwise
     */
    public void turn(Player p)
    {
        turn++;
        if(isAlive())
        {
            System.out.println("Enemy's turn.");
            if(turn % cooldown != 0)
            {
                attack(p);
            }
            else
            {
                turn = 0;
                special(p);
            }
        }
    }

    /**
     * for subclasses: System.out.println(" *flavor text* " + super(p) + " damage.");
     */
    public int attack(Player p)
    {
        Random roll = new Random();
        int strike =(int) (Math.random() * 10) + damage;
        if((int)(Math.random() * 100) < 105 - p.getAgility()) //monster crit chance based on player's agility
        {
            strike *= 2;
            System.out.println("Critical Hit!");
        }
        p.setHP(p.getHP() - strike);
        return strike;
    }

    /**
     * Each Enemy type has a unique ability that is used every *cooldown* turns, in place of its attack
     */
    public abstract void special(Player p);

}
