import java.io.*;
import java.util.HashSet;
import java.awt.Color;
import junit.framework.*;

public class TestMapGetLoc extends TestCase {

  public void testMapGetLoc() throws FileNotFoundException {
    
    NoFrame frame = new NoFrame();
    
    //Tests if function can tell that this loc is an empty space.
    HashSet<Map.Type> empty = new HashSet<Map.Type>();;
    empty.add(Map.Type.EMPTY);
    assertEquals(frame.getMap().getLoc(new Location(9,11)), empty);
    System.out.println("Passed empty.");

    HashSet<Map.Type> wall = new HashSet<Map.Type>();;
    wall.add(Map.Type.WALL);
    assertEquals(frame.getMap().getLoc(new Location(0,0)), wall);
    System.out.println("Passed on wall.");
    
    HashSet<Map.Type> pac = new HashSet<Map.Type>();;
    pac.add(Map.Type.PACMAN);
    PacMan pacman = frame.addPacMan(new Location(9, 11));
    assertEquals(frame.getMap().getLoc(new Location(9,11)), pac);
    System.out.println("Passed pacman on empty.");
    
    //Tests if function can tell that there's a cookie
    HashSet<Map.Type> cookie = new HashSet<Map.Type>();;
    cookie.add(Map.Type.COOKIE);
    assertEquals(frame.getMap().getLoc(new Location(10,1)), cookie);
    System.out.println("Passed cookie.");
    
    HashSet<Map.Type> pacman_cookie = new HashSet<Map.Type>();;
    pacman_cookie.add(Map.Type.COOKIE);
    pacman_cookie.add(Map.Type.PACMAN);
    PacMan pacman2 = frame.addPacMan(new Location(10, 1));
    assertEquals(frame.getMap().getLoc(new Location(10,1)), pacman_cookie);
    System.out.println("Passed pacman on pacman + cookie.");

    HashSet<Map.Type> ghost_cookie = new HashSet<Map.Type>();;
    ghost_cookie.add(Map.Type.COOKIE);
    ghost_cookie.add(Map.Type.GHOST);
    Ghost ghost = frame.addGhost(new Location(11, 1), "Joe", Color.red);
    assertEquals(frame.getMap().getLoc(new Location(11,1)), ghost_cookie);
    System.out.println("Passed pacman on ghost + cookie.");
  
  }

  public void testBounds() throws FileNotFoundException {
    
    NoFrame frame = new NoFrame();
    //Ghost ghost = frame.addGhost(new Location(10, 10), "name", Color.red); //Creates a red ghost named "name" at location x,y

    //These tests check if getLoc correctly outputs null if location given is out of bounds.
    assertNull(frame.getMap().getLoc(new Location(24, 10)));
    assertNull(frame.getMap().getLoc(new Location(10, 25)));
    assertNull(frame.getMap().getLoc(new Location(-1, -1)));
    System.out.println("Passed on Out of Bounds.");

   
  }

}
