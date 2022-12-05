import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

/**
  * set up the game and keep track of user input
  * 
  */ 

public class Adventure {
  // Set up has map of locations

  public static void main(String[] args) throws FileNotFoundException, IOException {
    HashMap<String, ArrayList<Location>> world = new HashMap<>();
    
    // INITIALIZING ALL LEVELS AND ROOMS

        // LEVEL: Sub-basement
        ArrayList<Location> preBasement = new ArrayList<Location>();

        Location subBasement = new Location(0, "Sub-basement", "\nYou step out of the elevator into this musty room. It is pretty much dark except for a light at the end of what looks like a tunnel on your right. Do you risk it or not?", false, false, false, false);

        preBasement.add(subBasement);

        // LEVEL: Basement
        ArrayList<Location> basement = new ArrayList<Location>();

        Location storageRoom = new Location(0, "Storage-Room", "\nYou find yourself in a storage room of sorts. There are nondescript shapes covered in cloth and it smells musty...", false, false, false, false);

        Location dungeon = new Location(1, "Dungeon", "\nThis appears to be a dungeon of sorts. \nThere is a dim light on some stairs going up, and a metal door on the left.", false, false, false, false);

        basement.add(storageRoom);
        basement.add(dungeon);

        // LEVEL: First floor
        ArrayList<Location> firstFloor = new ArrayList<Location>();

        Location kitchen = new Location(0, "Kitchen", "\nMmm something's cooking, it smells like... mystery meat soup? No one's watching the stove.\nThe room with the books is to the right,\nand there's a spiral stairwell leading up.\nThere's a short hallway leading down to a room, a soft wavering light coming through.", false, false, false, false);

        Location library = new Location(1, "Library", "\nStacks of old books line this room, surprisingly free of dust.\nTo your left, the scent of herbs waft through a door that's slightly ajar.\nTo the right, there is a doorway with a dim wavering light coming through.\nThere are stairs leading back down to the basement.", false, false, false, false);

        Location livingRoom = new Location(2, "Living-Room", "\nYou are in a cozy room furnished with leather couches and lit by a toasty fire crackling in a brick fireplace.\nThe room with the books is to the right.\nThere is a short hallway leading up to a deliciously scented place.\nYou hear low voices coming from a door on the right.", false, false, false, false);

        Location terminalLocation = new Location(3, "Terminal-Location", "\nYou find yourself looking at a couple of surprised faces. Before you can do anything else, a fist meets your temple and everything goes to black.", true, false, false, false);

        firstFloor.add(kitchen);
        firstFloor.add(library);
        firstFloor.add(livingRoom);
        firstFloor.add(terminalLocation);

        // LEVEL: Second floor
        ArrayList<Location> secondFloor = new ArrayList<Location>();

        Location diningRoom = new Location(0, "Dining-Room", "\nA rectangular dining table covered with a white satin cloth lays before you, set with two sets of shining silverware and ceramic plates.\nThere's a hallway to your right.\n There's a spiral stairwell down to the kitchen.", false, false, false, false);

        Location hallway = new Location(1, "Hallway", "\nIt seems like you entered a hallway. You see two doors across each other, one to your left and another to your right. At the end of the hallway, you notice a large picture frame.\nThere's a door to the right.\nThere's a door to the dining room on the left.\nThe end of the hallway leads up to another door. A dog lies next to the door at the end of the hall with a long femur-shaped bone in its mouth... best to let the dog sleep.", false, false, false, false);

        Location bathroom = new Location(2, "Bathroom", "\nThis room appears to be a large bathroom with a large sauna. There is a small mirror lying on the counter scattered with products: toothbrush, toothpaste and many more. The shower curtains look torn. There are blood trails running down the shower to the counter. You are starting to feel squirmy.", false, false, false, false);

        Location bedroom = new Location(3, "Bedroom", "\nIn the center of the room, there is a huge bed. There is an eerie silence all throughout. It looks dirty, with stained blankets, pillows and surprisingly chains too...You can feel a light breeze coming from above.\nYou look up and there is a slightly open latch and a ladder hanging from the roof. Finally, this can be an escape!!", false, false, false, false);

        secondFloor.add(diningRoom);
        secondFloor.add(hallway);
        secondFloor.add(bathroom);
        secondFloor.add(bedroom);

        // LEVEL: Third Floor
        ArrayList<Location> thirdFloor = new ArrayList<Location>();

        Location roof = new Location(0, "Roof", "\nYou climb up the ladder with great difficulty. Oomph, you can see the sky. There are dark grey clouds and it look gloomy. But, you can breathe in fresh air again. You climb out completely of the latch. *POW* The latch abruptly closes. You run to see if you can open it. Oh no! It is stuck and you are too. There are some items lying round but you are too anxious to focus. You look around and it looks that there might be a structure to your right. It could be your way out.", false, false, false, true);

        Location elevator = new Location(1, "Elevator", "\nYes, you were able to get in the elevator. It doesn't look like a normal one though. You are starting to feel claustrophobic. You try to control your breath and see if there is something that might help you figure how to make the elevator work. You see a control lying on the ground.", true, false, false, false);

        thirdFloor.add(roof);
        thirdFloor.add(elevator);
    
    // ADDING ITEMS IN EACH ROOM

        // LEVEL: Sub-basement

        // LEVEL: Basement
        /* Storage Room */
        storageRoom.addItem("cloth", new Item("\nNow, you wrap the cloth around your bloody hands.", true, true));

        storageRoom.addItem("lamp", new Item("\nLight comes out of the lamp and you are momentarily blinded.", true, true));

        storageRoom.addItem("screwdriver", new Item("\nOh no! The screwdriver. It's broken!", true, true));

        storageRoom.addItem("shelf", new Item("\nDusty shelf.", false, false));
        
        storageRoom.addItem("wood", new Item("\nA piece of wood.", false, false));

        /* Dungeon */
        dungeon.addItem("table", new Item("\nOh no! The table. It's broken!", false, false));

        dungeon.addItem("box", new Item("\nIt is just a red box, you fool!", false, false));

        dungeon.addItem("bucket", new Item("\nAn empty bucket lying on the ground.", false, false));

        dungeon.addItem("chair", new Item("\nYou sit on the chair now.", true, true));

        // LEVEL: First floor
        /* Kitchen */
        kitchen.addItem("plate", new Item("\nYou now have a plate in your hand.", true, false));

        kitchen.addItem("cabinets", new Item("\nThe cabinets are closed.", false, false));

        kitchen.addItem("food", new Item("\nYou have now eaten the crumbs you found in the kitchen.", true, false));
        
        kitchen.addItem("spoon", new Item("\nYou now have a spoon to use. For what? Who knows?", true, true));
        
        kitchen.addItem("fork", new Item("\nWhat are you going to do with a fork? Can't save you from anything...", false, false));

        kitchen.addItem("rats", new Item("\nRats...RUNNN", false, false));

        kitchen.addItem("knife", new Item("\nYou now have a knife in your hand.", true, true));

        /* Library */
        library.addItem("book", new Item("\nThe book title is THE SILENCE OF THE LAMBS.", false, false));

        library.addItem("magazine", new Item("\nThe magazine is FLESHLY FLAVORS - A COOKBOOK.", false, false));

        library.addItem("iPod", new Item("\nBOOM BOOM BOOM is the sound coming out of it...scaryyy.", false, false));

        library.addItem("pen", new Item("\nYou now have a pen with no ink.", true, true));

        library.addItem("desk", new Item("\nThere is a bloody book, stained magazine and iPod.", false, false));

        library.addItem("gloves", new Item("\nYou have now worn some gloves. Ouu...What are you planning?", true, true));

        /* Living Room */
        livingRoom.addItem("cushion", new Item("\nYou pick it up. It feels familiar...almost like...HUMAN SKIN!!?? AHHH", false, false));

        livingRoom.addItem("candle", new Item("\nThe candle is now lit. Ow! It's hot! You extinguish it.", true, false));

        livingRoom.addItem("couch", new Item("\nThe couches are of leather.", false, false));

        livingRoom.addItem("notebook", new Item("\nThe notebook has torn pages with some unreadable handwriting.", false, false));

        // LEVEL: Second floor
        /* Dining Room */
        diningRoom.addItem("sandwich", new Item("\nYou cannot pick the half-eaten sandwich. It could be poisonous. Where are the survival instincts?", false, false));

        diningRoom.addItem("mug", new Item("\nThere is steaming fumes coming from the mug. It is a deep red color, almost too much like blood...Is someone here?", false, false));

        diningRoom.addItem("cover", new Item("\nIt looks like a microwave cover.", true, false));

        diningRoom.addItem("rose", new Item("\nYou are now holding a rose. Oh no! It has spikes. You drop it.", false, false));

        diningRoom.addItem("vase", new Item("\nWhat are you going to do with a vase? It is going back in your inventory.", true, true));

        diningRoom.addItem("bowl", new Item("\nIt looks like a dog bowl...There are some orange fur floating in the water...Is there a dog here!?", false, false));

        /* Bedroom */
        bedroom.addItem("chains", new Item("\nUnfortunately, you cannot pick the chains up. They are sealed to the bedpost and look bloody. Now, your hands are stained and require a cloth to clean them up.", false, false));

        bedroom.addItem("pillows", new Item("\nWhy do you need pillows? Put those down!", false, false));

        bedroom.addItem("blanket", new Item("\nYou have wrapped the blanket around yourself. Good job!", true, true));

        bedroom.addItem("bed", new Item("\nThe bed is stuck to the floor, chains welded in the bed post, pillows thrown around and a blanket spread across.", false, false));

        bedroom.addItem("shirt", new Item("\nYou have now worn the shirt", true, false));
        
        bedroom.addItem("rug", new Item("\nCompared to the rest of the room, the rug is surprisingly clean. But what are you going to do with the rug?", false, false));

        /* Bathroom */
        bathroom.addItem("mirror" , new Item("\nOh no! You cut yourself and your finger is bleeding. But on looking closer you can see a piece of paper with a code (124214) written on it. It seems a good idea to pick it up.", false, false));

        bathroom.addItem("paper", new Item("\nCode: 124214.", true, true));

        bathroom.addItem("toothpaste", new Item("\nIt is just mint-flavored toothpaste. Now is not the time to brush your teeth.", false, false));

        bathroom.addItem("toothbrush", new Item("\nYou are not seriously about to use someone else's toothbrush.", false, false));

        bathroom.addItem("shampoo", new Item("\nNot the time to wash your hair!", false, false));

        bathroom.addItem("lotion", new Item("\nYou are now moisturized.", true, false));

        bathroom.addItem("razor", new Item("\nBlood is dripping down the blades. EWWWW. Someone must have had a shaving accident.", false, false));

        /* Hallway */
        hallway.addItem("picture", new Item("\nThere's a photo of a young couple and a golden retriever. They are outside on a nice green lawn. They look happy.", false, false));

        // LEVEL: Third Floor
        /* Roof */
        roof.addItem("leaf", new Item("\nNow the leaf has flown away", true, false));

        roof.addItem("parabola", new Item("\nLooks at the cord is going into a window on the lower levels.", false, false));

        roof.addItem("mask", new Item("\nThat is a used mask. You do not want to pick that up.", false, false));

        roof.addItem("toy", new Item("\nIt looks like that the dog has been on the roof. Its chewy toy is lying around.", false, false));

        /* Elevator */
        elevator.addItem("control", new Item("There is something engraved on the control. \"The escape is down!\"\n", false, false));

        elevator.addItem("flag", new Item("That is not a flag you recognize.", false, false));

        elevator.addItem("torch", new Item("You cannot pick that up. It cannot be that easy now!", false, false));

    // ADDING EXITS TO EACH ROOM
    
        // LEVEL: Sub-basement
        subBasement.addExit("right", new Exit("Exit", false, new Location(0, "Exit", "\nYou have made it out of the TBD house!! Congratulations. Now go face the pandemic you brave soul!\n", false, true, false, true)));

        subBasement.addExit("up", new Exit("Elevator", false, elevator));

        // LEVEL: Basement
        /* Storage Room */
        storageRoom.addExit("right", new Exit("Dungeon", false, dungeon));

        /* Dungeon */
        dungeon.addExit("left", new Exit("Storage Room", false, storageRoom));

        dungeon.addExit("up", new Exit("Library", true, library));
      
        // LEVEL: First floor
        /* Kitchen */
        kitchen.addExit("up", new Exit("Dining Room", false, diningRoom));

        kitchen.addExit("right", new Exit("Library", false, library));

        kitchen.addExit("down", new Exit("Living Room", true, livingRoom));

        /* Library */
        library.addExit("down", new Exit("Dungeon", true, dungeon));

        library.addExit("left", new Exit("Kitchen", false, kitchen));

        library.addExit("right", new Exit("Living Room", false, livingRoom));

        /* Living Room */
        livingRoom.addExit("left", new Exit("Library", false, library));

        livingRoom.addExit("right", new Exit("Terminal Location", false, terminalLocation));

        livingRoom.addExit("up", new Exit("Kitchen", true, kitchen));

        // LEVEL: Second floor
        /* Dining Room */
        diningRoom.addExit("down", new Exit("Kitchen", false, kitchen));

        diningRoom.addExit("right", new Exit("Hallway", false, hallway));

        /* Hallway */
        hallway.addExit("left", new Exit("Dining Room", false, diningRoom));

        hallway.addExit("up", new Exit("Bedroom", false, bedroom));

        hallway.addExit("right", new Exit("Bathroom", true, bathroom));

        /* Bedroom */
        bedroom.addExit("up", new Exit("Roof", false, roof));

        bedroom.addExit("down", new Exit("Hallway", false, hallway));

        /* Bathroom */
        bathroom.addExit("left", new Exit("Bathroom", true, hallway));

        // LEVEL: Third Floor
        roof.addExit("right", new Exit("Elevator", false, elevator));

        elevator.addExit("left", new Exit("Roof", false, roof));

        elevator.addExit("down", new Exit("Sub basement", false, subBasement));
    
    // ADDING LEVELS TO HASHMAP
    world.put("Sub basement", preBasement);
    world.put("Basement", basement);
    world.put("First floor", firstFloor);
    world.put("Second floor", secondFloor);
    world.put("Third floor", thirdFloor);

    // Start new or play saved game
    
    // Setting up user interface
    boolean playAgain = true;
    
    while (playAgain) { 
      Scanner input = new Scanner(System.in);

      System.out.println("\033[4;37m" + "\033[1;92m" + "\nENTER 1 to play saved game\nENTER 2 to start new game" + "\u001B[0m");
      String savedGame = input.nextLine();

      // Initialzing palyer
      Player p1 = null;

      File savedFile = new File("save.txt");

      // Asking whether user want to play saved game or not
      if (savedGame.equals("1")) {
        if (savedFile.length() != 0) {
          p1 = Player.playSaved(world);
        } else {
          // no previous saved game found
          System.out.println("\nNo saved game found. Starting new game.\n");
          p1 = new Player("Player 1", dungeon);
        }
      } else {
        if (!savedGame.equals("2")) {
          System.out.println("\nNumber not found. Starting new game.\n");
        }
        FileWriter myWriter = new FileWriter("save.txt");
        p1 = new Player("Player 1", dungeon);
      }
      
      String command;
      
      // print design
      File design = new File("design.txt");

      Scanner designSc = new Scanner(design);

      while(designSc.hasNext()) {
        System.out.println(designSc.nextLine());
      }

      designSc.close();

      // making it more game like
      System.out.println("\nLoading...\n");

      try {Thread.sleep(2000);} catch (InterruptedException e) {};
      p1.help();

      System.out.println("\u001B[34m" + "You wake up in a dark room. The air is dank and there's a pounding in your head. You blink and start to see your surroundings." + "\u001B[0m");
      p1.getLocation().printDescription();

      // getting input from user to move throughout the game
      while (true) {
        System.out.println("");
        command = input.nextLine().toLowerCase();
        
        String commandFirst = WordSplitter.split(command, true);
        String commandSecond = WordSplitter.split(command, false);
        
        // Check
        //System.out.println(commandSecond);

        // For directions
        if (WordSplitter.isDirection(commandSecond)) {
          // backtracking
          if (commandSecond.equals("back")) {
            p1.goBack();
          // if no room in that direction
          } else if (p1.getLocation().getExitList().get(commandSecond) == null) {
            System.out.println("\u001B[91m" + "\nLocation cannot be accessed." + "\u001B[0m");
          //if there is room in that direction
          } else {
            p1.addToPath(p1.getLocation().getExitList().get(commandSecond).getTarget(p1));
          }
        // Item related actions
        } else if (WordSplitter.isItem(commandSecond)) {

          // Picking up an item
          // Check if item is in location
          if (commandFirst.equals("pick")) {
            p1.pick(commandSecond);
          // Using an item
          } else if (commandFirst.equals("use")) {
            p1.use(commandSecond);
          // Returning an item
          } else if (commandFirst.equals("return")) {
            p1.putBack(commandSecond);
          // Dropping an item
          } else if (commandFirst.equals("drop")) {
            p1.drop(commandSecond);
          } else if (commandFirst.equals("view")) {
            // View help commands
             if (commandSecond.equals("help")) {
               p1.help();
            // View inventory
             } else if (commandSecond.equals("inventory")) {
               p1.printInventory();
            // View description
             } else if (commandSecond.equals("description")) {
               p1.roomDescription();
             } else {
             }
          // Searching room
          } else if (commandFirst.equals("search")) {
            if (commandSecond.equals("room")) {
              p1.search();
            }
          // Quit game
          } else if (commandFirst.equals("quit")) {
            p1.quit();
          // Save game
          } else if (commandFirst.equals("save")) {
            Player.save(p1);
          } else {
          } 
        // If input is invalid
        } else {
          System.out.println("Invalid Command\n");
        }
        
        // Test: print item
        //System.out.println("Items in location: " + p1.getLocation().getItemsList());

        // exit loop if won
        if (p1.getLocation().getFinalLocation()){
          break;
        }

        // Restarting game if user is in terminal location 
        if (p1.getLocation().getName().equals("Terminal-Location")) {
          p1.emptyInventory();
          p1.nStack();
          System.out.println("\nUh oh...\n");
          try {Thread.sleep(5000);} catch (InterruptedException e) {};
          System.out.println("\u001B[34m" + "You wake up in a dark room. The air is dank and there's a pounding in your head. You blink and start to see your surroundings." + "\u001B[0m");
          p1.addToPath(dungeon);
        }
      }

      // whether user wants to play again
      try {Thread.sleep(3000);} catch (InterruptedException e) {};
      System.out.println("\nDo you wanna play again?");
      String answer = input.nextLine();

      if (answer.toLowerCase().equals("yes") || answer.toLowerCase().equals("y")) {
        playAgain = true;
      } else {
        playAgain = false;
      }
    
    }
  }

}

