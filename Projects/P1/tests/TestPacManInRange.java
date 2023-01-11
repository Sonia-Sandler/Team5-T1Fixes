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
    Ghost ghost = new Ghost("inky", new Location(0, 0), map);

    // Create a new PacMan
    PacMan pacman = new PacMan("pacman1", new Location(1, 1), map);

    // Check if PacMan is in range
    assertTrue(ghost.is_pacman_in_range());
  }
}
