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
	int num = possibleMoves.size();
	if (num > 0){
		Random rand = new Random();
		this.myLoc = possibleMoves.get(rand.nextInt(num));
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
    int x = this.myLoc.x;
    int y = this.myLoc.y;

    ArrayList<Location> newLocations = new ArrayList<Location>();
    newLocations.add(new Location(x - 1, y));
    newLocations.add(new Location(x + 1, y));
    newLocations.add(new Location(x, y - 1));
    newLocations.add(new Location(x, y + 1));

    for (Location i : newLocations) {

      // get the contents of the map at this location
      HashSet<Map.Type> curr = this.myMap.getLoc(i);

      // if the contents is not null and contains a ghost
      if (curr != null && curr.contains(Map.Type.PACMAN)) {

        // return true
        return true;
      }

    }
    // if no pacman is found, return false
    return false;
  }

  public boolean attack() {
    // Variables that store location values
    int x_val = myLoc.x;
    int y_val = myLoc.y;
    // Copndition that checks right
    if (is_pacman_in_range()) {
      myMap.attack(myName);
      return true;
    }
   
    return true;
  }
}
