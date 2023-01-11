import junit.framework.*;

public class TestMapAttack extends TestCase {

  public void testMapAttack() throws FileNotFoundException {
    // Creating A Map
    NoFrame frame = new NoFrame(); // Creates A New Map With Walls and Tokens w/o a Display
    Map map = frame.getMap(); // Gets the Map You Just Created
    // Creating Players
    Ghost ghost = frame.addGhost(new Location(0, 0), "name", Color.red); // Creates a red ghost named "name" at location
                                                                         // x,y
    PacMan pacman = frame.addPacMan(new Location(1, 1)); // Creates PacMan at location x, y

    // alternatively if you don't need the PacMan or Ghost objects in your tests
    frame.initPlayers(); // Creates all of the players

    // Start The Game
    frame.startGame();
    if (map.attack(ghost.myName)) {
      System.out.println("Pacman was attacked. Game Over!");
    } else {
      System.out.println("Pacman was not attacked. Game not over!");
    }
  }
}
