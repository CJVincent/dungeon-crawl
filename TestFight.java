import java.io.*;
import java.util.*;
public class TestFight
{
    public static void main(String [] args)
    {
    Player p = new Player();
    p.roll();
    Enemy e = new Bomber();
    Battle b = new Battle(p, e);
    b.commence(new DungeonCrawl(b));
}
}
