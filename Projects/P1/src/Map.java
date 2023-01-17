import java.util.HashMap;
import java.util.HashSet;
import javax.swing.JComponent;

public class Map {

  public enum Type {
    EMPTY,
    PACMAN,
    GHOST,
    WALL,
    COOKIE
  }

  private HashMap<Location, HashSet<Type>> field;
  private boolean gameOver;
  private int dim;

  private HashMap<String, Location> locations;
  private HashMap<String, JComponent> components;
  private HashSet<Type> emptySet;
  private HashSet<Type> wallSet;

  private int cookies = 0;

  public Map(int dim) {
    gameOver = false;
    locations = new HashMap<String, Location>();
    components = new HashMap<String, JComponent>();
    field = new HashMap<Location, HashSet<Type>>();

    emptySet = new HashSet<Type>();
    wallSet = new HashSet<Type>();
    emptySet.add(Type.EMPTY);
    wallSet.add(Type.WALL);
    this.dim = dim;
  }

  public void add(String name, Location loc, JComponent comp, Type type) {
    locations.put(name, loc);
    components.put(name, comp);
    if (!field.containsKey(loc))
      field.put(loc, new HashSet<Type>());
    field.get(loc).add(type);
  }

  public int getCookies() {
    return cookies;
  }

  public boolean isGameOver() {
    return gameOver;
  }

  public boolean move(String name, Location loc, Type type) {
    // update locations, components, and field
    // use the setLocation method for the component to move it to the new location
	  if (loc.x >= 24 || loc.x < 0 || loc.y >= 25 || loc.y < 0) {
		  return false;
	  }
	  
	  locations.remove(name);
	  locations.put(name, loc);
	  field.get(loc).add(type);
		  
	  JComponent comp = components.get(name);
	  comp.setLocation(loc.x, loc.y);
	
	  return true;
  }

  public HashSet<Type> getLoc(Location loc) {

    // wallSet and emptySet will help you write this method

    int x = loc.x;
    int y = loc.y;

    // first check if location is out of bounds.
    if (x >= 24 || x < 0 || y >= 25 || y < 0) {
      return null;
    }

    HashSet<Type> set = this.field.get(loc);

    // checks if set is empty (no walls, pacman, cookie, ghost)
    if (set == null) {
      return this.emptySet;
    }

    // checks if location is wall.
    for (Map.Type curr : set) {
      if (curr == Type.WALL) {
        return this.wallSet;
      }
    }
    return set;
    //HashSet<Type> set2 = new HashSet<Type>();
    //return set2;
  }

  /**
   * The method controls ghosts attacking pacman. If the ghost was able to
   * successfully attack pacman and update the display to do so return true,
   * otherwise return false.
   * 
   * @param Name the name of the ghost
   */
  public boolean attack(String Name) {

    if (locations.get(Name).equals(locations.get("pacman"))) {
      gameOver = true;
      return true;
    }
    return false;
  }
  /*Code used to test attack for attack method in Ghost.java - Justin Pratama
   *  public boolean attack(String Name) {
    gameOver = true;

    return true;
  }
   */

  /**
   * Returns true if the given location is a valid location, that is, not out of
   * bounds and not a wall.
   * 
   * @param loc The location to check.
   * @return True if the location is valid, false otherwise.
   */
  public boolean isValidLoc(Location loc) {
    int x = loc.x;
    int y = loc.y;

    // first check if location is out of bounds.
    if (x >= 24 || x < 0 || y >= 25 || y < 0) {
      return false;
    }

    HashSet<Type> set = this.field.get(loc);

    // checks if set is empty (no walls, pacman, cookie, ghost)
    if (set == null) {
      return true;
    }

    // checks if location is wall.
    for (Map.Type curr : set) {
      if (curr == Type.WALL) {
        return false;
      }
    }

    return true;
  }

   public JComponent eatCookie(String name) {
    // update locations, components, field, and cookies
    // the id for a cookie at (10, 1) is tok_x10_y1
    JComponent deleteCookie;
    // Checks if cookie is there in componenet

      // Checks if cookie is there in map
      if (field.get(locations.get(name)).contains(Map.Type.COOKIE) == true) {
      
        // decrement cookie count
        cookies = cookies + 1;
        // Following removes the cookie throughout


        String cookieLoc = "tok_x" + (locations.get(name)).x +
            "_y" + ((locations.get(name)).y);
          

        deleteCookie = components.get(cookieLoc);
        System.out.println(deleteCookie);

        field.remove(new Location(locations.get(name).x, locations.get(name).y));
        components.remove(name);
        locations.remove(name);
        
        

    
        // Returns cookie to be deleted
        return null;
      }
    
    return null;
  }
}
