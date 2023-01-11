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
![image](https://user-images.githubusercontent.com/121910361/211635265-32ed6821-6182-4828-8650-dcbd48ab7165.png)
![image](https://user-images.githubusercontent.com/121910361/211635379-9774b4e2-4085-436e-8013-3fe7d0f0e57f.png)


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

-------------------------------
amanthanvi (Aman Thanvi)
-------------------------------
  Worked on:
  
  - PacMan Class: `is_ghost_in_range()`
  
  - Ghost Class: `is_pacman_in_range()`
  
  - Map Class: `attack(String name)`
  
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
  
-------------------------------
emeraldswag312 (Anirudha Uppugunduri)
-------------------------------
  Worked on:

  -PacMan Class: move()

  -Ghost Class: move()

  -Map Class: move()
  
PacMan Class
-------------------------------
move()
-------------------------------
  -Type: () -> boolean
  
  -Description: 
  
  This method randomly chooses one move out of all possible
  moves that it can take. It will not move if there are no
  possible moves.

  -Example: 
  
  //pacman at location (1,1) can move to (1,2),(2,1). It randomly chooses (1,2)
  
  pacman.move() -> true
  
  -Tests:
  
  JUnit tests will check for when pacman is trapped and cannot move and will check
  for when pacman can move.

Ghost Class
-------------------------------
move()
-------------------------------
  -Type () -> boolean

  -Description:

  This method randomly chooses one move out of all possible
  moves that it can take. It will not move if there are no 
  possible moves.

  -Example: 

  //Ghost at location (1,1) can move to (1,2),(2,1). It randomly chooses (1,2).
  
  ghost.move() -> true
  
  -Tests:
  
  Junit tests will check for when ghost is surrounded by pacmans and can move onto pacmans
  as well as onto spaces without pacmans.
  
Map Class
-------------------------------
move()
-------------------------------
  -Type () -> boolean
  
  -Description:
  
  This method takes the parameters and checks if they are within the map such as
  moving a name to a location that is within the map and legal while also checking
  if a component is on the field with the given name. This method fails if any 
  parameter check fails.
  
  -Example:
  
  //Pacman at location (1,1) wants to be moved to (1,2). (1,2) is a legal move, so 
  //the necessary instance variables are modified while changing the location of
  //the component.
  
  map.move("pacman", new Location(0,0), Map.Type.PACMAN)) -> false
  
  -Tests:
  
  Junit tests will check for when the component can and cannot be moved to a location.
  For example, it cannot move into a wall. It also tests valid locations that components
  can move to.


