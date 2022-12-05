# **The Bad Dungeon Escape Cheatsheet**

## **Commands**

These are the list of valid command combinations

1. To MOVE, enter "go" and the desired direction.
2. Valid directions are "up", "down", "left", "right", and "back"
3. To SEARCH a ROOM, enter "search room".
4. To PICK up an ITEM, enter "pick" and the desired item.
5. To USE an ITEM, enter "use" and the desired item.
6. To RETURN an ITEM to your inventory, enter "return" and the desired item.
7. To VIEW your INVENTORY, enter "view inventory".
8. To VIEW HELP, enter "view help".
9. To VIEW the DESCRIPTION of current room, enter "view description".
10. TO SAVE the GAME, enter "save game".
11. To QUIT the GAME, enter "quit game".

Here is the list of all available items:

"cloth", "lamp", "screwdriver", "shelf", "wood", "table", "box", "bucket", "knife", "chair", "plate", "cabinets", "food", "spoon", "fork", "rats", "book", "magazine", "iPod", "pen", "desk", "gloves", "cushion", "candle", "couch", "notebook", "sandwich", "mug", "cover", "rose", "vase", "bowl", "chains", "pillows", "blanket", "bed", "shirt", "rug", "mirror", "paper", "toothpaste", "toothbrush", "shampoo", "lotion", "razor", "picture", "leaf", "parabola", "mask", "toy", "control", "flag", "torch"

## **DISCLAIMERS**

1) Items are automatically dropped from your inventory once used. Be wise, some items can only be used once. Also, some rooms are locked. You might need to solve a riddle, have a specific item, or a code. Good luck getting out.

2) When you exit the elevator and "go back", the description reads as if you are at the top of the elevator again, as we left it built into the description.

3) Since the only valid directional commands are "up", "down", "left", "right", and "back", for some rooms that are on the same level, the directions are hinted at in the description, ie. "a hallway leading _up_ to...".

4) Ocassionally, the program will exit/end unprompted, leading the player unable to continue the game by entering more commands, and requires re-running the program. We believe this is a Replit issue unrelated to our program.

## **TBD Escape Map**

![TBD Escape Map](/TBD_Escape_Map.png)


## **Challenges (Special Features)**

1) Riddles - If you answer wrong, you remain in the same location. You will have to enter the desired direction again to be able to get another riddle for the direction you want to go in. (View below for a list of riddles used)

2) You have to have a specific item (a knife found in the kitchen) to access a specific location (go right in Living-Room)

3) There is a terminal location on the right of the Living-Room that brings the user back to the dungeon if accessed (using knife)

4) You cannot go back once you enter the roof.

5）You have to enter a code to access the elevator --> the code can be found by picking up paper in the bathroom. Enter "use paper" to view code before going in elevator. When prompted for the code, you cannot immediately view the paper for the code; you must enter the desired direction again.

6) In order to find where to go on the elevator, you must "pick" the control.

### **Riddles**

1) Who has a ring but no finger? --> telephone

2) Who has a bank but no money? --> river

3) What will get wet while drying? --> towel

4) What has to be broken before you can use it? --> egg

5) What is full of holes but still holds water? -> sponge

6) What is always in front of you but can’t be seen? --> future

7) What goes up but never comes down? --> age

8) The more of this there is, the less you see. What is it?--> darkness

9) What has many keys but can’t open a single lock? --> piano

10) What gets bigger when more is taken away? --> hole


## **How to win The Bad Dungeon Escape**

Start in Dungeon --> `go up` --> *Solve Riddle* --> Now in Library --> `go left` --> Now in Kitchen --> `go up` --> Now in Dining Room --> `go right` --> Now in Hallway --> `go right` --> *Solve Riddle* --> Now in Bathroom --> `pick paper` --> `go back` --> Now in Hallway --> `go up` --> Now in Bedroom --> `go up` --> Now on Roof --> `use paper` --> **Memorize code** --> `go right` --> *Enter code* --> Now in Elevator --> `pick control` --> `go down` --> Now in Sub Basement --> `go right` --> **EXIT GAME!!**

## References

1) [Add image to md file in replit](https://replit.com/talk/ask/Teams-For-Education-Images-in-Markdown/56837)

2) [Add color to console text](https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println)

3) [Check whether a file is empty](https://www.technicalkeeda.com/java-tutorials/how-to-check-if-a-file-is-empty-or-not-using-java)

4) [Riddles](https://parade.com/947956/parade/riddles/)

5) [Idea for Player class](https://www.youtube.com/watch?v=5yclc-pp2zE&t=124s)

6) [Print HashMap](https://www.delftstack.com/howto/java/how-to-print-hashmap-in-java/)
