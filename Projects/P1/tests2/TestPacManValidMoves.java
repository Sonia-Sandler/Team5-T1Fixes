import java.io.*;
import java.util.ArrayList;

import junit.framework.*;
import java.awt.Color;

public class TestPacManValidMoves extends TestCase {

  public void testPacManValidMoves() throws FileNotFoundException {
    
    NoFrame frame = new NoFrame();

    //tests when pacman is completely trapped.
    Ghost ghost = frame.addGhost(new Location(1, 2), "Joe", Color.red);
    Ghost ghost2 = frame.addGhost(new Location(2, 1), "Joe2", Color.red);
    PacMan pacman = frame.addPacMan(new Location(1, 1));
    ArrayList<Location> empty = new ArrayList<Location>();

    assertTrue(pacman.get_valid_moves().isEmpty());
    System.out.println("Passed pacman being trapped.");


    NoFrame frame2 = new NoFrame();

    //Tests when pacman is not trapped.
    ArrayList<Location> allowedMoves = new ArrayList<Location>();
    allowedMoves.add(new Location(2, 1));
    allowedMoves.add(new Location(4, 1));
    
    PacMan pacman2 = frame2.addPacMan(new Location(3, 1));
    assertTrue(pacman2.get_valid_moves().equals(allowedMoves));
    System.out.println("Passed pacman not trapped.");

    PacMan pacman3 = frame2.addPacMan(new Location(500, 500));
    assertTrue(pacman3.get_valid_moves().isEmpty());
    System.out.println("Passed pacman invalid location.");
  
  }
}
