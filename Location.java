import java.util.*;

/**
  * Parent class for our rooms/locations
  */

public class Location {

  /** Location's index in ArrayList of location by floor in our game map */
  private int index;

  /** Name of location */
  private String name;

  /** Description of location */
  private String description;

  /** ArrayList of items that is specific to the location */
  private HashMap<String, Item> items = new HashMap<>();
  
  /** ArrayList of exits that is specific to the location */
  private HashMap<String, Exit> possibleExits = new HashMap<>();

  /** Determine whether location is terminal */
  private boolean specialFeature;

  /** Determine whether location is leads exit/death */
  private boolean finalLocation;

  /** Determine whether location has been before */
  private boolean hasBeenBefore;

  /** Determine whether no backtracking for location */
  private boolean noBack;

  public Location(int index, String name, String description, boolean specialFeature, boolean finalLocation, boolean hasBeenBefore, boolean noBack) {
    this.index = index;
    this.name = name;
    this.description = description;
    this.specialFeature = specialFeature;
    this.finalLocation = finalLocation;
    this.hasBeenBefore = hasBeenBefore;
    this.noBack = noBack;

    // initializing basic directions for exits
    possibleExits.put("up", null);
    possibleExits.put("down", null);
    possibleExits.put("left", null);
    possibleExits.put("right", null);
  }

  /** Getter for index */
  public int getIndex() {
    return index;
  }

  /** Setter for index*/
  public void setIndex(int nIndex) {
    index = nIndex;
  } 

  /** Getter for name */
  public String getName() {
    return name;
  }

  /** Setter for name */
  public void setName(String nName) {
    name = nName;
  }

  /** Getter for description */
  public String getDescription() {
    return description;
  }

  /** Setter for description */
  public void setDescription(String nDescription) {
    description = nDescription;
  }

  /** Accessor to items list in current location */
  public HashMap<String, Item> getItemsList() {
    return items;
  }

  /** Getter for an item using the key*/
  public Item getItem(String itemKey) {
    return items.get(itemKey);
  }

  /** add an item to the location */
  public void addItem(String itemKey, Item itemValue) {
    items.put(itemKey, itemValue);
  }

  /** remove an item to the location */
  public void removeItem(String itemKey) {
    items.remove(itemKey);
  }
  
  /** Accessor to Exits in location */
  public HashMap<String, Exit> getExitList() {
    return possibleExits;
  }

  /** Getter for an exit using the string direction */
  public Exit getExit(String direction) {
    return possibleExits.get(direction);
  }

  /** Add an exit to the location */
  public void addExit(String direction, Exit exit) {
    possibleExits.put(direction, exit);
  }

  /** remove an exit to the location */
  public void removeExit(String direction) {
    possibleExits.put(direction, null);
  }

  /** Getter for terminal */
  public boolean getSpecialFeature() {
    return specialFeature;
  }

  /** Setter for terminal */
  public void setSpecialFeature(boolean nSpecialFeature) {
    specialFeature = nSpecialFeature;
  }

  /** Getter for final location */
  public boolean getFinalLocation() {
    return finalLocation;
  }

  /** Setter for final location */
  public void setFinalLocation(boolean nFinalLocation) {
    finalLocation = nFinalLocation;
  }

  /** Getter for hasBeenBefore */
  public boolean getHasBeenBefore() {
    return hasBeenBefore;
  }

  /** Setter for hasBeenBefore */
  public void setHasBeenBefore(boolean nHasBeenBefore) {
    hasBeenBefore = nHasBeenBefore;
  }

  /** Getter for no backtracking */
  public boolean getNoBack() {
    return noBack;
  }

  /** Setter for no backtracking */
  public void setNoBack(boolean nNoBack) {
    noBack = nNoBack;
  }

  /** print description of location */
  public void printDescription() {
    System.out.println("\u001B[34m" + this.description + "\u001B[0m");
  }

  /** print items in location */
  public void printItems() {
    System.out.println(items.keySet());
  }

  /** print exits in location */
  public void printExits() {
    System.out.println(possibleExits.keySet());
  }

}