import java.io.*;
import junit.framework.*;
import java.awt.Color;

public class TestMapEatCookie extends TestCase {

  public void testMapEatCookie() throws FileNotFoundException {
    NoFrame frame = new NoFrame();
    Ghost ghost = frame.addGhost(new Location(1, 1), "casper", Color.red);
    PacMan pacman = frame.addPacMan(new Location(2, 1));

    assertNotNull(frame.getMap().eatCookie("tok_x2_y1"));
    System.out.println("passed map eat cookie");
  }
}
