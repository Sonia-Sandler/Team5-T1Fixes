import java.io.*;
import junit.framework.*;
import java.awt.Color;

public class TestMapMove extends TestCase {

  public void testMapMove() throws FileNotFoundException {
 
	  NoFrame frame = new NoFrame();
	  PacMan pacman = frame.addPacMan(new Location(1,1));
	  
	  assertFalse(frame.getMap().move(pacman.myName, new Location(0,0), Map.Type.PACMAN));
	  assertTrue(frame.getMap().move(pacman.myName, new Location(1,2), Map.Type.PACMAN));
	  
	  
	  Ghost ghost = frame.addGhost(new Location(3, 1), "Blinky", Color.red);
	  
	  assertFalse(frame.getMap().move(ghost.myName, new Location(3, 0), Map.Type.GHOST));
	  assertTrue(frame.getMap().move(pacman.myName, new Location(4,1), Map.Type.GHOST));
  }
}
