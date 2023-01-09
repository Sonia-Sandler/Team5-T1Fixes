import java.util.ArrayList;

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
    return null;
  }

  public boolean move() {
    return false;
  }

  public boolean is_pacman_in_range() {
    return false;
  }

  public boolean attack() {
    //Variables that store location values
    int x_val = myLoc.x;
    int y_val = myLoc.y;
    //Copndition that checks right
    if(myMap.getLoc(new Location(x_val + 1, y_val))
    .contains(Map.Type.PACMAN)){
      myMap.attack(myName);
      return true;
    }
    //Copndition that checks left
    if(myMap.getLoc(new Location(x_val - 1, y_val))
    .contains(Map.Type.PACMAN)){
      myMap.attack(myName);
      return true;
    }
    //Condition that checks down
    if(myMap.getLoc(new Location(x_val, y_val + 1))
    .contains(Map.Type.PACMAN)){
      myMap.attack(myName);
      return true;
    }
    //Condition that checks up
    if(myMap.getLoc(new Location(x_val, y_val - 1))
    .contains(Map.Type.PACMAN)){
      myMap.attack(myName);
      return true;
    }
    //Condition that checks down-right
    if(myMap.getLoc(new Location(x_val + 1, y_val + 1))
    .contains(Map.Type.PACMAN)){
      myMap.attack(myName);
      return true;
    }
    //Condition that checks down-left
    if(myMap.getLoc(new Location(x_val - 1, y_val + 1))
    .contains(Map.Type.PACMAN)){
      myMap.attack(myName);
      return true;
    }
    //Condition that checks up-left
    if(myMap.getLoc(new Location(x_val - 1, y_val - 1))
    .contains(Map.Type.PACMAN)){
      myMap.attack(myName);
      return true;
    }
    //Condition that chekcs up-right
    if(myMap.getLoc(new Location(x_val + 1, y_val - 1))
    .contains(Map.Type.PACMAN)){
      myMap.attack(myName);
      return true;
    }
    return false;
  }
}
