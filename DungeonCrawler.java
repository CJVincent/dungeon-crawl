
import java.io.*;
import javax.swing.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Main Driver for game.
 */
public class DungeonCrawler
{
    private static Enemy e;
    private static Player p;
    private static List<String> population;
    private static Scanner input;
    private static DungeonCrawl c;
    private static Random roll;
    public static void main(String [] args) throws IOException
    {
        population = new ArrayList<String>();
        Scanner reader = new Scanner(new File("population.txt"));
        while(reader.hasNext()) // add enemy names to list enemies that can be spawned
        {
            String enemyClass = reader.next();
            population.add(enemyClass);
        }
        input = new Scanner(System.in);
        c = new DungeonCrawl(null);
        roll = new Random();
        System.out.println("Welcome to Dungeon Crawl! Your goal is to get as much treasure as possible. \nby killing monsters and not getting killed yourself. Press return to roll your character.");
        input.nextLine();
        p = new Player();
        p.roll();
        System.out.println("Strength gives extra damage when attacking. Your Strength is " + p.getStrength());
        System.out.println("Agility helps you run away more easily and lets you critically hit more often. Your Agility is " + p.getAgility());
        System.out.println("Wisdom allows you to heal more HP while in combat. Your Wisdom is " + p.getWisdom());
        System.out.println("Constitution determines how much HP you have. Your Constitution is " + p.getConstitution());
        System.out.println("Luck gives you bonus treasure when you defeat a monster. Your Luck is " + p.getLuck());
        System.out.println("\nSome enemies may manipulate these stats. They will almost always return to their default values after the battle.\n"
            + "\nEnter a number to select difficulty : 1 for Normal - get 1000 treasure. 2 for Hard - get 2000 treasure. \n3 for Extreme - get 3000 treasure. 4 for Endless mode.");
        int difficulty = 0;
        while (difficulty <= 0)
        {
            difficulty = input.nextInt();
        }
        System.out.println("You now enter the dungeon...");
        play(difficulty);
    }

    /**
     * gets an enemy name from population, creates a new instance of that, sets up battle, plays out battle, repeat
     * At end, displays victory / defeat messages and images
     */
    private static void play(int diff)
    {
        while((p.isAlive() && p.getTreasure() < 1000 * diff) || (p.isAlive() && diff >= 4))
        {
            int x = (int)(Math.random() * population.size()); // get random number corresponding to element in population
            String enemyName = population.get(x); // get name at that index
            try {   
                e = (Enemy) Class.forName(enemyName).newInstance(); // create enemy from name in population arraylist
            }
            catch (Exception ex) {
                System.out.println("Problem with " + enemyName + "Class or population file.");
                ex.printStackTrace();
                System.exit(1);
            }
            e.power_Up(p); // boost stats according to player level (amount of treasure / 1000)
            Battle b = new Battle(p, e); // create battle
            c.setBattle(b);// add battle to GUI
            b.commence(c); // play battle
            while(!c.playerAdvanced())
            {
                while (!c.playerAdvanced())
        {
            try 
            {
              Thread.sleep(100);
            } 
            catch (InterruptedException ex) 
            {
              Logger.getLogger(Battle.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            } //game won't advance until player hits continue.
        }
        c.endCombat();
        if(p.isAlive())
        {
            c.showImage(new ImageIcon("Victory.jpg"));
            System.out.println("You win! And with " + p.getHP() + " HP left!");
        }
        else
        {
            c.showImage(new ImageIcon("Death.jpg"));
            System.out.println("You are dead. Final treasure: " + p.getTreasure());
        }
        while(!c.playerAdvanced()){while (!c.playerAdvanced())
        {
            try 
            {
              Thread.sleep(100);
            } 
            catch (InterruptedException ex) 
            {
              Logger.getLogger(Battle.class.getName()).log(Level.SEVERE, null, ex);
            }
        }}
        c.cleanUp();
    }

}