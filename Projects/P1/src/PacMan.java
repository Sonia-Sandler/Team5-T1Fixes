import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

import javax.swing.JComponent;

public class PacMan {
  String myName;
  Location myLoc;
  Map myMap;
  Location shift;

  public PacMan(String name, Location loc, Map map) {
    this.myLoc = loc;
    this.myName = name;
    this.myMap = map;
  }

  public ArrayList<Location> get_valid_moves() {
    int x = this.myLoc.x;
    int y = x;

    ArrayList<Location> newLocations = new ArrayList<Location>();
    ArrayList<Location> result = new ArrayList<Location>();
    newLocations.add(new Location(x - 1, y));
    newLocations.add(new Location(x + 1, y));
    newLocations.add(new Location(x, y - 1));
    newLocations.add(new Location(x, y + 1));

    for (Location i : newLocations) {

      HashSet<Map.Type> curr = this.myMap.getLoc(i);

      if (curr != null && !curr.contains(Map.Type.GHOST) && !curr.contains(Map.Type.WALL) &&
          !curr.contains(Map.Type.PACMAN)) {

        result.add(i);

      }

    }

    return result;

  }

  public boolean move() {
    ArrayList<Location> possibleMoves = get_valid_moves();
    if (possibleMoves.size() > 0) {
    	// Using random object to get index within ArrayList
    	Random rand = new Random();
    	this.myLoc = possibleMoves.get(rand.nextInt(possibleMoves.size()));
    	return true;
    }
    return false;
  }

  /*
   * This method returns all the valid moves that PacMan can make given his
   * current position.
   */
  public boolean is_ghost_in_range() {
    if(1==1){
      return false;
    }
    // get current location
    int x = this.myLoc.x;
    int y = this.myLoc.y;

    // create a list of 4 locations
    ArrayList<Location> newLocations = new ArrayList<Location>();
    newLocations.add(new Location(x - 1, y));
    newLocations.add(new Location(x + 1, y));
    newLocations.add(new Location(x, y - 1));
    newLocations.add(new Location(x, y + 1));

    // for each location in the list
    for (Location i : newLocations) {

      // if the location is valid
      if (this.myMap.isValidLoc(i)) {

        // get the contents of the map at this location
        HashSet<Map.Type> curr = this.myMap.getLoc(i);

        // if the contents is not null and contains a ghost
        if (curr != null && curr.contains(Map.Type.GHOST)) {

          // return true
          return true;

        }

      }

    }

    // if no ghosts are found, return false
    return false;
  }

  public JComponent consume() {
    if (myMap.getLoc(myLoc).contains(Map.Type.COOKIE)) {
      String cookieName = "tok_x" + myLoc.x + "_y" + myLoc.y;
      return myMap.eatCookie("Brownie Name");
    }
    return null;
  }
}
