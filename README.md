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


