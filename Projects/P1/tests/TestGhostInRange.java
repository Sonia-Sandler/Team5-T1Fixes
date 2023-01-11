import java.awt.Color;
import java.io.*;
import junit.framework.*;

public class TestGhostInRange extends TestCase {

  /*
   * This method tests the is_ghost_in_range() method in PacMan.java
   */
  public void testGhostInRange() throws FileNotFoundException {
    // Creating A Map
    NoFrame frame = new NoFrame(); // Creates A New Map With Walls and Tokens w/o a Display
    Map map = frame.getMap(); // Get the map
    // Creating Players
    Ghost ghost = frame.addGhost(new Location(5, 5), "name", Color.red); // Creates a red ghost named "name" at location
    // x,y
    PacMan pacman = frame.addPacMan(new Location(5, 6)); // Creates PacMan at location x, y

    assertTrue(pacman.is_ghost_in_range()); // Test if ghost is in range
  }
}
