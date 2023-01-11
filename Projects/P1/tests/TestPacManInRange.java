import java.io.*;
import junit.framework.*;

public class TestPacManInRange extends TestCase {
  /*
   * Test for is_pacman_in_range() in Ghost.java
   */
  public void testPacManInRange() throws FileNotFoundException {
    // Creating A Map
    NoFrame frame = new NoFrame(); // Creates A New Map With Walls and Tokens w/o a Display
    Map map = frame.getMap(); // Gets the Map

    // Create a new ghost
    Ghost ghost = new Ghost("inky", new Location(5, 5), map);

    // Create a new PacMan
    PacMan pacman = frame.addPacMan(new Location(6, 5));

    // Check if PacMan is in range
    assertTrue(ghost.is_pacman_in_range());
  }
}
