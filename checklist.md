# **The Bad Dungeon Escape Checklist**
## Jennifer Wang, Sonia Paredes, Parunjodhi Munisamy

## Front-End Design (10 pts)

YES --- 2 pts: Game has a **functional text-based interface** that allows the player to control their movement through the game.

YES --- 2 pts: Submission includes a **cheat sheet** (`cheatsheet.md`) documenting all of the available commands, as well as a **description of the layout** of your game world's underlying physical layout; this can be described in words, or included as a separate image file if you prefer to sketch a map by hand.  If your game includes **challenges** that must be overcome to win, also describe them here.

YES --- 2 pts: Storyline driving the game is **engaging**, and individual elements of play make sense within the context of the story.

YES --- 2 pts: Game has **multiple possible paths / outcomes** (i.e. gameplay depends on player's choices and is not the same every time).

YES --- 1 pt: Gameplay supports **backtracking** (returning to previously-visited areas).

YES --- 1 pt: Some paths through the game have **restricted access** until the player has completed a task or acquired a specific item (i.e. a key to open a door, etc.).


## Back-End Design (10 pts)

YES --- 2 pts: Selected data structure(s) are **effective, efficient** at supporting the desired operations and program behavior.

YES --- 2 pts: Design justification includes a discussion of at least one (reasonable) **alternative data structure** that could have been used, and the reasons why you decided against this alternative.

**Justification**

We used a HashMap with Strings as keys and an ArrayList of Locations as values as the underlying data structure of our world. We also used HashMaps extenstively within our Player and Location classes particulary to deal with Items and Exits. We chose this for two primary reasons: efficiency and ease of modification. We know that HashMaps (in the best case scenario) would take constant time O(1) to search for a key. We initially worked our world and item lists as an ArrayList of ArrayLists. Since, ArrayLists require iteration (O(n) time) to search for a particular value, we realized that building our entire game on nested iterations was too tedious.

Another reason for choosing HashMaps over ArrayLists was better representation of our map. By using a Hashmap for our world, it was easy to specify which floor (the key) has which locations. Then, within a location it was easy to specify which direction leads to which exit. This is much better than using indices as connectors which can become fragile once changes to the structure are made.

Both HashMaps and ArrayLists were our main choices because they were easily modifiable. Floors, Locations, and Items can be easily added or removed from the world. 


YES ---  2 pts: The project makes effective use of **Java built-in classes** whenever they are appropriate.

YES --- 2 pts: The project's design is **extensible** (i.e. someone else could pick up where you left off, adding on or modifying the game without requiring a total rewrite).

YES --- 2 pts: Submission includes an **architecture diagram** describing the relationships between all classes.

![Architecture Diagram](/architectureDiagram.png)

## General Items (10 pts):

YES --- 4 pts: Program compiles without errors or warnings.

YES --- 2 pts: Executes fully & consistently without crashing (exception/freeze).

YES ---  2 pt: Complies with style guidelines (missing items 1 pt each):

      YES ---  Classes & class members all have Javadoc header comments.

      YES ---  Clear and consistent indentation of bracketed sections.

      YES ---  Adheres to Java conventions on naming & capitalization.

      YES --- Methods & variables all have clear and accurate names.

      YES ---  Methods avoid confusing side effects.

YES ---  1 pt: All required files included with submission (including completed checklist file).

YES ---  1 pt: `readme.md` contains your reflection on the project and responses to all prompts .