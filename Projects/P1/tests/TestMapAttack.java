import java.awt.Color;
import junit.framework.*;
import org.junit.Assert;
import java.io.FileNotFoundException;

public class TestMapAttack extends TestCase {

  public void testMapAttack() throws FileNotFoundException {
    // Creating A Map
    NoFrame frame = new NoFrame(); // Creates A New Map With Walls and Tokens w/o a Display
    Map map = frame.getMap(); // Gets the Map You Just Created
    // Creating Players
    
    
    Ghost ghost = frame.addGhost(new Location(1, 3), "name", Color.red); // Creates a red ghost named "name" at location
                                                                         // x,y
    PacMan pacman = frame.addPacMan(new Location(1, 3)); // Creates PacMan at location x, y

   
    assertTrue(map.attack(ghost.myName));
  }
}
