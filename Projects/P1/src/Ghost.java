import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Ghost {
  String myName;
  Location myLoc;
  Map myMap;

  public Ghost(String name, Location loc, Map map) {
    this.myLoc = loc;
    this.myName = name;
    this.myMap = map;
  }

  public ArrayList<Location> get_valid_moves() {
    int x = this.myLoc.x;
    int y = this.myLoc.y;

    ArrayList<Location> newLocations = new ArrayList<Location>();
    ArrayList<Location> result = new ArrayList<Location>();
    newLocations.add(new Location(x - 1, y));
    newLocations.add(new Location(x + 1, y));
    newLocations.add(new Location(x, y - 1));
    newLocations.add(new Location(x, y + 1));

    for (Location i : newLocations) {

      HashSet<Map.Type> curr = this.myMap.getLoc(i);

      if (curr != null && !curr.contains(Map.Type.WALL)) {

        result.add(i);

      }

    }

    return result;
  }

  public boolean move() {
	  ArrayList<Location> possibleMoves = get_valid_moves();
	  if (possibleMoves.size() > 0) {
	      Random rand = new Random();
	      this.myLoc = possibleMoves.get(rand.nextInt(possibleMoves.size()));
	      return true;
	  }
	  return false;
  }

  /*
   * This function checks its surroundings to see if PacMan is in attack range.
   * The attack radius of a ghost is 1 which means that a ghost at location
   * (x, y) can attack PacMan as long as PacMan is located at (x-1, y-1) or
   * (x+1, y+1). If PacMan is in the attack range, this function returns true
   * otherwise it returns false.
   */
  public boolean is_pacman_in_range() {
    // If the Ghost's location is on one of the corners, only check valid directions
    // Top left
    if (myLoc.x == 0 && myLoc.y == 0) {
      if (myMap.getLoc(myLoc.shift(1, 0)).contains(Map.Type.PACMAN) ||
          myMap.getLoc(myLoc.shift(0, 1)).contains(Map.Type.PACMAN)) {
        return true;
      }
    }
    // Top right
    else if (myLoc.x == 24 && myLoc.y == 0) {
      if (myMap.getLoc(myLoc.shift(-1, 0)).contains(Map.Type.PACMAN) ||
          myMap.getLoc(myLoc.shift(0, 1)).contains(Map.Type.PACMAN)) {
        return true;
      }
    }

    // Bottom left
    else if (myLoc.x == 0 && myLoc.y == 23) {
      if (myMap.getLoc(myLoc.shift(1, 0)).contains(Map.Type.PACMAN) ||
          myMap.getLoc(myLoc.shift(0, -1)).contains(Map.Type.PACMAN)) {
        return true;
      }
    }

    // Bottom right
    else if (myLoc.x == 24 && myLoc.y == 24) {
      if (myMap.getLoc(myLoc.shift(-1, 0)).contains(Map.Type.PACMAN) ||
          myMap.getLoc(myLoc.shift(0, -1)).contains(Map.Type.PACMAN)) {
        return true;
      }
    }

    // If the Ghost's location is on one of the edges, only check valid directions
    // Top
    else if (myLoc.y == 0) {
      if (myMap.getLoc(myLoc.shift(-1, 0)).contains(Map.Type.PACMAN) ||
          myMap.getLoc(myLoc.shift(1, 0)).contains(Map.Type.PACMAN) ||
          myMap.getLoc(myLoc.shift(0, 1)).contains(Map.Type.PACMAN)) {
        return true;
      }
    }

    // Bottom
    else if (myLoc.y == 23) {
      if (myMap.getLoc(myLoc.shift(-1, 0)).contains(Map.Type.PACMAN) ||
          myMap.getLoc(myLoc.shift(1, 0)).contains(Map.Type.PACMAN) ||
          myMap.getLoc(myLoc.shift(0, -1)).contains(Map.Type.PACMAN)) {
        return true;
      }
    }

    // Left
    else if (myLoc.x == 0) {
      if (myMap.getLoc(myLoc.shift(1, 0)).contains(Map.Type.PACMAN) ||
          myMap.getLoc(myLoc.shift(0, -1)).contains(Map.Type.PACMAN) ||
          myMap.getLoc(myLoc.shift(0, 1)).contains(Map.Type.PACMAN)) {
        return true;
      }
    }
    // Right
    else if (myLoc.x == 24) {
      if (myMap.getLoc(myLoc.shift(-1, 0)).contains(Map.Type.PACMAN) ||
          myMap.getLoc(myLoc.shift(0, -1)).contains(Map.Type.PACMAN) ||
          myMap.getLoc(myLoc.shift(0, 1)).contains(Map.Type.PACMAN)) {
        return true;
      }
    }

    // For all other cases, check all directions
    else if (myMap.getLoc(myLoc.shift(-1, 0)).contains(Map.Type.PACMAN) ||
        myMap.getLoc(myLoc.shift(1, 0)).contains(Map.Type.PACMAN) ||
        myMap.getLoc(myLoc.shift(0, -1)).contains(Map.Type.PACMAN) ||
        myMap.getLoc(myLoc.shift(0, 1)).contains(Map.Type.PACMAN)) {
      return true;
    }

    return false;
  }

  public boolean attack() {
    // Variables that store location values
    int x_val = myLoc.x;
    int y_val = myLoc.y;
    // Copndition that checks right
    if (myMap.getLoc(new Location(x_val + 1, y_val))
        .contains(Map.Type.PACMAN)) {
      myMap.attack(myName);
      return true;
    }
    // Copndition that checks left
    if (myMap.getLoc(new Location(x_val - 1, y_val))
        .contains(Map.Type.PACMAN)) {
      myMap.attack(myName);
      return true;
    }
    // Condition that checks down
    if (myMap.getLoc(new Location(x_val, y_val + 1))
        .contains(Map.Type.PACMAN)) {
      myMap.attack(myName);
      return true;
    }
    // Condition that checks up
    if (myMap.getLoc(new Location(x_val, y_val - 1))
        .contains(Map.Type.PACMAN)) {
      myMap.attack(myName);
      return true;
    }
    // Condition that checks down-right
    if (myMap.getLoc(new Location(x_val + 1, y_val + 1))
        .contains(Map.Type.PACMAN)) {
      myMap.attack(myName);
      return true;
    }
    // Condition that checks down-left
    if (myMap.getLoc(new Location(x_val - 1, y_val + 1))
        .contains(Map.Type.PACMAN)) {
      myMap.attack(myName);
      return true;
    }
    // Condition that checks up-left
    if (myMap.getLoc(new Location(x_val - 1, y_val - 1))
        .contains(Map.Type.PACMAN)) {
      myMap.attack(myName);
      return true;
    }
    // Condition that chekcs up-right
    if (myMap.getLoc(new Location(x_val + 1, y_val - 1))
        .contains(Map.Type.PACMAN)) {
      myMap.attack(myName);
      return true;
    }
    return false;
  }
}
