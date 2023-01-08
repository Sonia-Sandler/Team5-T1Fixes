import java.util.ArrayList;
import java.util.HashSet;

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
    int y = this.myLoc.y;

    ArrayList<Location> newLocations = new ArrayList<Location>();
    ArrayList<Location> result = new ArrayList<Location>();
    newLocations.add(new Location(x - 1, y));
    newLocations.add(new Location(x + 1, y));
    newLocations.add(new Location(x, y - 1));
    newLocations.add(new Location(x, y + 1));

    for (Location i : newLocations){

      HashSet<Map.Type> curr = this.myMap.getLoc(i);

      if(curr != null && !curr.contains(Map.Type.GHOST) && !curr.contains(Map.Type.WALL) && 
      !curr.contains(Map.Type.PACMAN)) {

        result.add(i);

      }
  
    } 
    
    return result;


  }

  public boolean move() {
    return false;
  }

  public boolean is_ghost_in_range() {
    return false;
  }

  public JComponent consume() {
    return null;
  }
}
