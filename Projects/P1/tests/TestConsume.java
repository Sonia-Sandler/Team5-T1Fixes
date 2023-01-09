import java.io.*;
import junit.framework.*;
import java.awt.Color;

public class TestConsume extends TestCase {

  public void testConsume() throws FileNotFoundException {
    NoFrame frame = new NoFrame();
    Ghost ghost = frame.addGhost(new Location(3, 2), "casper", Color.red);
    PacMan pacman = frame.addPacMan(new Location(2, 2));
    //Cookie should be at location not be null
    assertNotNull(pacman.consume());
    System.out.println("passed pacman consume");
  }
}
