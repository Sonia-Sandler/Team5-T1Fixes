import java.io.*;
import junit.framework.*;
import java.awt.Color;

public class TestMapEatCookie extends TestCase {

  public void testMapEatCookie() throws FileNotFoundException {
    NoFrame frame = new NoFrame();
    Ghost ghost = frame.addGhost(new Location(3, 2), "casper", Color.red);
    PacMan pacman = frame.addPacMan(new Location(2, 2));

    assertNotNull(frame.getMap().eatCookie("pacman"));
    System.out.println("passed map eat cookie");
  }
}
