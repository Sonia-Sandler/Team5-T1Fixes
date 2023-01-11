import java.io.*;
import junit.framework.*;
import java.awt.Color;

public class TestGhostMove extends TestCase {

  public void testGhostMove() throws FileNotFoundException {
	  NoFrame frame = new NoFrame();
	  
	  // Tests that pacman's location is changing when trapped by pacmans
	  Ghost ghost = frame.addGhost(new Location(1, 1), "Blinky", Color.red);
	  PacMan pacman = frame.addPacMan(new Location(2, 1));
	  PacMan pacman2 = frame.addPacMan(new Location(1, 2));
	  
	  Location loc = new Location(1, 1);
	  ghost.move();
	  assertFalse(ghost.myLoc.x == loc.x && ghost.myLoc.y == loc.y);
  }
}
