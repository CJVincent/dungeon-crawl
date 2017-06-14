import java.util.*;
/**
 * The player character
 */
public class Player
{
    private int strength, agility, wisdom, constitution, luck, hp, treasure;
    private int strengthSave, agilitySave, wisdomSave, constitutionSave, luckSave;
    private boolean escape;
    private Random roll;
    /**
     * Initialize stats as 0.
     */
    public Player()
    {
        strength = 0; //damage
        agility = 0; // escape and crit 
        wisdom = 0; //healing
        constitution = 0; // max hp
        luck = 0; // bonus treasure
        treasure = 0; // measure of progress
        escape = false; // flag for escaping
        roll = new Random();
        //Save stats to restore to if enemies drain these stats
        strengthSave = strength;
        agilitySave = agility;
        wisdomSave= wisdom;
        constitutionSave = constitution;
        luckSave = luck;
    }

    /**
     * set strength to x
     */
    public void setStrength(int x)
    {
        strength = x;
    }

    /**
     * set agility to x
     */
    public void setAgility(int x)
    {
        agility = x;   
    }

    /**
     * set wisdom to x
     */
    public void setWisdom(int x)
    {
        wisdom = x;
    }

    /**
     * set constitution to x
     */
    public void setConstitution(int x)
    {
        constitution = x;
    }

    /**
     * set luck to x
     */
    public void setLuck(int x)
    {
        luck = x;
    }

    /**
     * set hp to x
     */
    public void setHP(int x)
    {
        hp = x;
    }

    /**
     * set treasure to x
     */
    public void setTreasure(int x)
    {
        treasure = x;
    }

    /**
     * @return strength
     */
    public int getStrength()
    {
        return strength;
    }

    /**
     * @return agility
     */
    public int getAgility()
    {
        return agility;
    }

    /**
     * @return wisdom
     */
    public int getWisdom()
    {
        return wisdom;
    }

    /**
     * @return constitution
     */
    public int getConstitution()
    {
        return constitution;
    }

    /**
     * @return luck
     */
    public int getLuck()
    {
        return luck;
    }

    /**
     * @return hp
     */
    public int getHP()
    {
        return hp;
    }

    /**
     * @return treasure
     */
    public int getTreasure()
    {
        return treasure;
    }

    /**
     * Roll stats. Stat total always equals 450,and no stat is lower than 51.
     */
    public void roll()
    {
        while (strength + agility + wisdom + constitution + luck != 450)
        {
            strength = roll.nextInt(50) + 51;
            agility = roll.nextInt(50) + 51;
            wisdom = roll.nextInt(50) + 51;
            constitution = roll.nextInt(50) + 51;
            luck = roll.nextInt(50) + 51;
        }
        //Save stats to restore to if enemies change these stats
        strengthSave = strength;
        agilitySave = agility;
        wisdomSave = wisdom;
        constitutionSave = constitution;
        luckSave = luck;
        hp = constitution * 6;
    }

    /**
     * check if player is still alive (hp is greater than 0)
     */
    public boolean isAlive()
    {
        return hp > 0;
    }
    
    /**
     * rolls for damage, decreases enemy's hp by that amount
     */
    public void attack(Enemy e)
    {
        int strike = roll.nextInt(60) + strength;
        if(roll.nextInt(1000) < agility) //higher agility = higher crit chance
        {
            strike *= 2;
            System.out.println("Critical Hit!");
        }
        System.out.println("You attack the enemy for " + strike + " damage.");
        e.setHP(e.getHP() - strike);
    }

    /**
     * rolls for heal amount, increases hp by that amount
     */
    public void heal()
    {
        int heal = roll.nextInt(35) + (wisdom / 3);
        if (hp + heal > (constitution * 6) && !(hp > constitution * 6))
        {
            hp = constitution * 6; // prevents overhealing
        }
        else if(hp < constitution * 6)
        {
            hp += heal;
        }
        else
        {
            System.out.println("You fail to heal because your current HP is higher than your max HP.\n");
            return;
        }
        System.out.println("You heal for " + heal + " health.\n");
    }

    
    /**
     * attempts to escape. escape chance is based on agility.
     */
    public void escape()
    {
        if(roll.nextInt(150) < agility)
        {
            escape = true;
            System.out.println("You successfully escape.\n");
        }
        else
        {
            System.out.println("You fail to escape.\n");
        }
    }

    /**
     * @return escape, the flag showing that player has escaped or not
     */
    public boolean isEscaping()
    {
        return escape;
    }
    
    /**
     * @return treasure divided by 1000, for making monsters stronger as player gets more treasure
     */
    public int getLevel() 
    {
        return treasure / 1000;
    }
    
    /**
     * sets stats back to normal after fight
     */
    public void restore()
    {
        strength = strengthSave;
        agility = agilitySave;
        wisdom = wisdomSave;
        constitution = constitutionSave;
        luck = luckSave;
        escape = false;
    }
}