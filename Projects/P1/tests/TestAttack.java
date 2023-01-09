import java.io.*;
import junit.framework.*;
import java.awt.Color;

public class TestAttack extends TestCase {

  public void testAttack() throws FileNotFoundException {
    NoFrame frame = new NoFrame();

    Ghost ghost = frame.addGhost(new Location(1, 1), "casper", Color.red);
    PacMan pacman = frame.addPacMan(new Location(2, 1));
    boolean check = true;

    assertTrue(ghost.attack());
    System.out.println("Passed ghost right attack");

    NoFrame frame2 = new NoFrame();

    Ghost ghost2 = frame2.addGhost(new Location(3, 1), "casper", Color.red);
    PacMan pacman2 = frame2.addPacMan(new Location(2, 1));

    assertTrue(ghost2.attack());
    System.out.println("Passed ghost left attack");
  }
}
