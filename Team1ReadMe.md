# Project 1: PacMan Team1
## Group: William He, Justin Pratama, Aman Thanvi, Anirudha Uppugunduri

-------------------------------
Running Code from the Command Line
-------------------------------
```
javac -cp "src/" src/*.java
java -cp "src/" StartMenu
```

-------------------------------
Display of Pacman Game
-------------------------------
(To be added)

-------------------------------
Team members and functions
-------------------------------
-------------------------------
umdjpratama (Justin Pratama)
-------------------------------
  Worked on:
  
  -PacMan Class: consume()
  
  -Ghost Class: attack()
  
  -Map Class: eatCookie(String Name)
  
 PacMan Class
-------------------------------
consume() 
-------------------------------
  -Type: () -> JComponent
  
  -Description: 
  
  Function is meant to imitate the consumption of cookies
  that is present in the original pacman game, references eatCookie in the map
  class to do so.

  -Example: 
  
  //pacman at location (2,2) and a cookie is at (2,2)
  
  pacman.consume() -> /*Cookie component with location (2,2)*/

  //pacman at location (2,2) and there is no cookie
  
  pacman.consume() -> null
  
  -Tests:
  
  JUnit tests will check for if null is not returned and essentially if a
  cookie component is at the correct position.
  
Ghost Class
-------------------------------
attack() 
-------------------------------
  -Type: () -> boolean
  
  -Description: 
  
  Function is meant to imitate the ghost attacking the player
  pacman, essentially changing the gameOver condition in map.

  -Example: 
  
  //pacman at location (2,2) and a ghost is at (2,1)
  
  ghost.attack() -> true

  //pacman at location (2,2) and ghost at (5,2)
  
  ghost.attack() -> false
  
  -Tests:
  
  JUnit tests will check for if ghost is available to attack
  the pacman player as it is in close proximity to the player.
  
Map Class
-------------------------------
eatCookie() 
-------------------------------
  -Type: () -> JComponent
  
  -Description: 
  
  Function is meant to imitate the functionality of eating a cookie,
  how the board changes and the cookie is removed.

  -Example: 
  
  //pacman at location (2,2) and a cookie is at (2,2)
  
  map.eatCookie() -> /*Cookie component with location (2,2)*/

  //pacman at location (2,2) and no cookie
  
  map.eatCookie() -> Null
  
  -Tests:
  
  JUnit tests will check for if a cookie is the right position and, if so, 
  will remove it from the map through components, field, etc. This is tested
  through a notNull assertion to see if it works.
  
-------------------------------
whe1123 (William He)
-------------------------------
  Worked on:
  
  -PacMan Class: get_valid_moves()
  
  -Ghost Class: get_valid_moves()
  
  -Map Class: getLoc(Location loc)
  
PacMan Class
-------------------------------
get_valid_moves() 
-------------------------------
  -Type: () -> ArrayList<Location>
  
  -Description: 
  
  This function returns all possible moves that 
  the pacman can take at its current position.
  (Pacman can't go into a position where there's a ghost
   or another pacman).

  -Example: 
  
  //pacman at location (5,5) and there is a wall on position (4,5) and a ghost
  on position (5,4)
  
  pacman.get_valid_moves() -> {(6,5), (5,6)}

  //pacman at location (5,5) and there are no obstacles
  
  pacman.get_valid_moves() -> {(4,5), (6,5), (5,4), (5,6)}
  
  -Tests:
  
  JUnit tests will check for when pacman is trapped, in an invalid location,
  or in a position where the pacman has possible moves.

Ghost Class
------------------------------- 
get_valid_moves()
-------------------------------
  -Type: () -> ArrayList<Location>
  
  -Description: 
  
  This function returns all possible moves that 
  the ghost can take at its current position.
  (Ghosts can't go through walls but can go through
   other Pacman and Ghosts).

  -Example: 
  
  //Ghost at location (5,5) and there is a wall on position (4,5) and on position (5,4)
  
  Ghost.get_valid_moves() -> {(6,5), (5,6)}

  //Ghost at location (5,5) and there are no obstacles
  
  Ghost.get_valid_moves() -> {(4,5), (6,5), (5,4), (5,6)}
  
  -Tests:
  
  JUnit tests will check for when ghost is trapped, in an invalid location,
  or in a position where the ghost has possible moves.

  
Map Class
-------------------------------  
getLoc(Location loc)
-------------------------------
  -Type: (Location Loc) -> HashSet<Type>
  
  -Description: 
  
  This function takes in a given location
   and returns what's currently on that location. 
  (Empty, Pacman, Cookie, Ghost, Wall)

  -Example: 
  
  //pacman at location (5,5)
  
  map.getLoc(new Location (5,5) -> Map.Type.PACMAN

  //cookie and ghost at location (5,6)
  
  map.getLoc(new Location (5,5) -> [Map.Type.COOKIE, Map.Type.GHOST]

  -Tests:
  
  JUnit tests will check for locations with 
  Empty, Pacman, Cookie, Ghost, and Wall
  will also check when there are more than one object
  at a spot. (If location has a wall it will always just return
  Map.Type.WALL). Tests also check for invalid/out of bounds locations.

