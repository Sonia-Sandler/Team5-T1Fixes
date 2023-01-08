import java.io.*;
import java.util.ArrayList;

import junit.framework.*;
import java.awt.Color;

public class TestGhostValidMoves extends TestCase {

  public void testGhostValidMoves() throws FileNotFoundException {
    NoFrame frame = new NoFrame();

    //tests that ghost can move through pacman even if trapped.
    Ghost ghost = frame.addGhost(new Location(1, 1), "Joe", Color.red);
    PacMan pacman2 = frame.addPacMan(new Location(2, 1));
    PacMan pacman = frame.addPacMan(new Location(1, 2));
    

    ArrayList<Location> allowedMoves = new ArrayList<Location>();
    allowedMoves.add(new Location(2, 1));
    allowedMoves.add(new Location(1, 2));

    assertEquals(ghost.get_valid_moves(),(allowedMoves));
    System.out.println("Passed ghost being trapped by pacman.");


    NoFrame frame2 = new NoFrame();

    Ghost ghost2 = frame2.addGhost(new Location(500, 500), "Joe", Color.red);
    assertTrue(ghost2.get_valid_moves().isEmpty());
    System.out.println("Passed ghost in invalid location.");
  
  }
}
