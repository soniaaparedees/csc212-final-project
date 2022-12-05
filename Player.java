import java.util.*;
import java.io.*;

/**
  * Move player from one location to another and keep track
  */

public class Player {

  /** description of player */
  private String description;

  /** current location of player */
  private Location location;

  /** path of player in terms of Locations */
  private ArrayDeque<Location> path = new ArrayDeque<>();

  /** stores items that the player picked up */
  private HashMap<String, Item> inventory = new HashMap<>();

  /** temporary variable to store item player is using */
  public Item temp;

  public Player(String description, Location startLocation) {
    this.description = description;
    this.location = startLocation;
    this.location.setHasBeenBefore(true);
    path.push(location);
  }

  /** Getter for description */
  public String getDescription() {
    return this.description;
  }

  /** Setter for description */
  public void setDescription(String nDescription) {
    this.description = nDescription;
  }

  /** Getter for player inventory*/
  public HashMap<String, Item> getInventory() {
    return inventory;
  }

  /** Getter for item in inventory */
  public Item getItemInventory(String item) {
    return inventory.get(item);
  }

  /** Adds item to player inventory */
  public void addItemInventory(String item) {
    System.out.println("\u001B[31m\n" + item.toUpperCase() + " has been added to your inventory!" + "\nYour Items: \u001B[0m");
    inventory.put(item, getLocation().getItemsList().get(item));
  }

  /** Removes item from player inventory */
  public void removeItemInventory(String item) {
    inventory.remove(item);
  }

  /** Empties current player inventory */
  public void emptyInventory() {
    inventory = new HashMap<String, Item>();
  }

  /** Getter for current location */
  public Location getLocation() {
    return this.location;
  }

  /** Setter for current location */
  public void setLocation(Location nLocation) {
    this.location = nLocation;
  }

  /** New stack */
  public void nStack() {
    path = new ArrayDeque<Location>();
  }

  /** Adds to player's visited locations 
  * @param nLocation location to be added to path
  */
  public void addToPath(Location nLocation) {
    if (nLocation != null) {
      setLocation(nLocation);
      this.location.setHasBeenBefore(true);
      path.push(this.location);
      this.location.printDescription();
    }
  }

  /** Sets current location as last location in path */
  public void goBack() {
    path.pop();
    if (path.size() == 0){
      System.out.println("\u001B[35m" + "\nYou can't go back, there's nowhere to go!\n" + "\u001B[0m");
    } else {
      Location previousLocation = path.pop();
      // update location
      setLocation(previousLocation);
      path.push(location);
      System.out.println("\u001B[35m" + "\nYou are now back in the previous room: " + location.getName() + "\u001B[0m");
    }
  }

  /** Checks if item key is in inventory */
  public boolean isItemInInventory(String item) {
    return inventory.containsKey(item);
  }

  /** Check whether location has any of the special features */
  public boolean specialFeatureType() {
    System.out.println("\u001B[32m");

    boolean answer = false;
    
    // Roof special feature
    if (this.location.getName().equals("Roof")) {
      System.out.println("\nYou need a code to proceed ahead. Please enter code:");

      Scanner scanPasscode = new Scanner(System.in);

      String passcode = scanPasscode.nextLine();

      if (passcode.equals("124214")) {
        System.out.println("You got it right!");
        answer = true;
      } else {
        System.out.println("The passcode you entered is wrong. You are still stuck on the roof.");
      }
    } 

    // Living Room special feature
    if (this.location.getName().equals("Living-Room")) {
      System.out.println("\nYou need a knife to pick the lock.");

      if (inventory.containsKey("knife")) {
        answer = true;
        System.out.println("It seems you do have a knife in your inventory! You can enter the next room.");
        try {Thread.sleep(3000);} catch (InterruptedException e) {};
      } else {
        System.out.println("It seems you do not have a knife. You are stuck here.");
      }
    }
    
    System.out.println("\u001B[0m");

    return answer;
  }

  /** Prints path */
  public void printPath() {
    ArrayDeque<Location> copyPath = this.path.clone();

    for (int i = 0; i < copyPath.size(); i++) {
      System.out.println(copyPath.pop().getDescription());
    }
  }

  /** Prints string set of all items in inventory */
  public void printInventory() {
    System.out.println("\u001B[31m" + inventory.keySet() + "\u001B[0m");
  }

  /** pick command
  * @param item item to be picked up
  */
  public void pick(String item) {
    // Check if item is in location
    if (this.getLocation().getItemsList().containsKey(item)) {
      // Check if item is accessible
      if (getLocation().getItemsList().get(item).isAccessible()) {
        // Check if item is in inventory
        if (isItemInInventory(item)) {
          System.out.println(item.toUpperCase() + " is already in your inventory.");
        } else {
          // Add to inventory
          addItemInventory(item);
          printInventory();
          // Remove from location
          getLocation().getItemsList().remove(item);
        }
      }
    } else {
      System.out.println("\u001B[31m\n" + "Sorry there's no " + item + " here" + "\u001b[0m");
    }
  }

  /** use command
  * Removes from inventory and temporarily stores item in * current location
  * @param item String of item to pick up
  */
  public void use(String item) {
    temp = inventory.get(item);
    // Check if item is in inventory
    if (isItemInInventory(item)) {
      // Usage description
      System.out.println("\u001b[33m"+ inventory.get(item).getDescription() + "\u001b[0m");
      // Temp add to location
      getLocation().addItem(item, getItemInventory(item));
      // Remove from inventory
      removeItemInventory(item);
    } else {
      System.out.println("\u001b[31;1m"+ "\nWhat are trying to do? You don't even have a " + item + "\u001b[0m");
    }
  }
 
  /** return item to inventory command
  * @param item item to be returned 
  */
  public void putBack(String item) {
    if (getLocation().getItemsList().containsKey(item)) {
      if (temp.isReusable()) {
        inventory.put(item, temp);
        getLocation().removeItem(item);
        System.out.println("\u001B[31m\n" + item.toUpperCase() + " has been returned to your inventory" + "\u001b[0m");
      } else {
        System.out.println("\u001B[31m\n" + "\nSorry you can only use " + item + "once." + "\u001b[0m");
      }
    } else {
      System.out.println("\u001b[31;1m"+ "\nWhat are trying to do? You don't even have " + item + " out." +"\u001b[0m");
    }
  }
  
  /** drop command
  * @param item item to be dropped in current location
  */
  public void drop(String item) {
    // add item dopped to current location's list of items
    if (isItemInInventory(item)) {
      getLocation().addItem(item, getItemInventory(item));
      removeItemInventory(item);
      System.out.println("\u001b[31;1m"+ "\nYou have respectfully dropped the " + item + "\u001b[0m");
    } else {
      System.out.println("\u001b[31;1m"+ "\nWhat are trying to do? You don't even have " + item + "\u001b[0m");
    }
  } 
  
  /** Prints list of valid commands */
  public void help() throws FileNotFoundException {
    File help = new File("help.txt");

    Scanner sc = new Scanner(help);

    System.out.println("\u001b[31;1m");

    while (sc.hasNextLine()) {
      System.out.println(sc.nextLine());
    }

    System.out.println("\u001b[0m");
  }

  /** Searches the room and prints at most half the items available */
  public void search() {
    System.out.println("\u001B[91m" + "\nThese are SOME items found in the room: ");
    
    Object[] keyItems = this.getLocation().getItemsList().keySet().toArray();
    
    ArrayList<Integer> temp = new ArrayList<>();
    int count = 0;

    while(count < keyItems.length) {
      Random randItem = new Random();
      int index = randItem.nextInt(keyItems.length); 

      if (!temp.contains(index)) {
        temp.add(index);
        System.out.println(keyItems[index]);
      }
      
      count = count + 2;
    }
    
    System.out.println("\u001B[0m");
  }

  /** quit command automatically saves current location */
  public void quit() throws IOException {
    // Added the save here
    Player.save(this);
    System.exit(0);
  }

  /** view room name command */
  public void roomDescription() {
    System.out.println("\u001B[35m" + "\nOh wow! You forgetful soul. You are now in the " + this.getLocation().getName() + "\u001B[0m");
    this.getLocation().printDescription();
  }

  /** play saved game command
  * @param gameMap HashMap of map of Locations
  * @return Player new instance of player in a specific location
  */
  public static Player playSaved(HashMap<String, ArrayList<Location>> gameMap) throws FileNotFoundException{
    File inputFile = new File("save.txt");

    Scanner fileSc = new Scanner(inputFile);

    String[] location = fileSc.nextLine().split(" ");

    String keyValue = "";

    if (location[0].equals("Sub basement")) {
      keyValue = "preBasement";
    } else if (location[0].equals("Storage-Room") || location[0].equals("Dungeon")) {
      keyValue = "Basement";
    } else if (location[0].equals("Kitchen") || location[0].equals("Living-Room") || location[0].equals("Library")) {
      keyValue = "First floor";
    } else if (location[0].equals("Dining-Room") || location[0].equals("Bedroom") || location[0].equals("Bathroom") || location[0].equals("Hallway")) {
      keyValue = "Second floor";
    } else {
      keyValue = "Third floor";
    }

    int locIndex = Integer.parseInt(location[1]);
    
    Player nPlayer= new Player("Saved player", gameMap.get(keyValue).get(locIndex));

    return nPlayer;
  }
  

  /** 
  * Saves player current location 
  * @param player Current player
  */
  public static void save(Player player) throws IOException {
    FileWriter myWriter = new FileWriter("save.txt");
    PrintWriter out = new PrintWriter(myWriter);
    
    out.println(player.getLocation().getName() + " " + player.getLocation().getIndex());
    
    out.close();
  }

}
