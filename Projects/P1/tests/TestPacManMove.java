import static org.junit.Assert.assertNotEquals;

import java.awt.Color;
import java.io.*;
import java.util.ArrayList;

import junit.framework.*;

public class TestPacManMove extends TestCase {

  public void testPacManMove() throws FileNotFoundException {
	  
    // Testing location of Pacman when stuck
    NoFrame frame = new NoFrame();
    PacMan pacman = frame.addPacMan(new Location(1, 1));
    Ghost ghost = frame.addGhost(new Location(1, 2), "Pinky", Color.red);
    Ghost ghost2 = frame.addGhost(new Location(2, 1), "Clyde", Color.red);
    
    Location loc = new Location(1, 1);
    pacman.move();
    assertEquals(pacman.myLoc, loc);
    System.out.println("Expected Result: Pacman did not move.");
    
    // Testing location of Pacman when not stuck
    NoFrame frame2 = new NoFrame();
    PacMan pacman2 = frame2.addPacMan(new Location(1,1));
    
    pacman2.move();

    // Making sure that the location is not the same
    assertFalse(pacman2.myLoc.x == loc.x);
    assertFalse(pacman2.myLoc.y == loc.y);
    
    System.out.println("Expected Result: Pacman moved.");
  }
}
