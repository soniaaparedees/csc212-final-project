/**
  * Connecting different locations together through exits
  * attribute in the class location
  */

import java.util.*;

public class Exit {

  /** Describe exit */
  private String description;

  /** whether target location of exit needs a riddle */
  private boolean riddle;

  /** target location of exit */
  private Location target;

  public Exit (String description, boolean riddle, Location target) {
    this.description = description;
    this.riddle = riddle;
    this.target = target;
  }

  /** getter for exit description */
  public String getDescription() {
    return this.description;
  }

  /** setter for exit description */
  public void setDescription(String nDescription) {
    this.description = nDescription;
  }

  /** getter for riddle boolean */
  public boolean isRiddle() {
    return this.riddle;
  }

  /** setter for riddle boolean */
  public void setIsRiddle(boolean nRiddle) {
    this.riddle = nRiddle;
  }

  /** getter for exit's target location */
  public Location getTarget(Player player) {
    if (riddle) {
      return getRiddleTarget();
    } else if (target.getNoBack()) {
      player.nStack();
      return this.target;
    } else if (target.getSpecialFeature()) {
      if (player.specialFeatureType()) {
        return this.target;
      } else {
        return null;
      }
    } else {
      return this.target;
    }
  }

  /** setter for target location */
  public void setTarget(Location nTarget) {
    this.target = nTarget;
  }


  /** Initializes riddle and ask them for user input
  * @return target location if riddle passed or null if riddle not passed
  */
  public Location getRiddleTarget() {
    ArrayList<String[]> riddles = new ArrayList<String[]>();

    String[] riddleOne = {"\nRiddle Time! Get the correct answer to go to the other side.\nWho has a ring but no finger?", "telephone"};
    String[] riddleTwo = {"\nRiddle Time! Get the correct answer to go to the other side.\nWho has a bank but no money?", "river"};
    String[] riddleThree = {"\nRiddle Time! Get the correct answer to go to the other side.\nWhat will get wet while drying?", "towel"};
    String[] riddleFour = {"\nRiddle Time! Get the correct answer to go to the other side.\nWhat has to be broken before you can use it?", "egg"};
    String[] riddleFive = {"\nRiddle Time! Get the correct answer to go to the other side.\nWhat is full of holes but still holds water?", "sponge"};
    String[] riddleSix = {"\nRiddle Time! Get the correct answer to go to the other side.\nWhat is always in front of you but can’t be seen?", "future"};
    String[] riddleSeven = {"\nRiddle Time! Get the correct answer to go to the other side.\nWhat goes up but never comes down?", "age"};
    String[] riddleEight = {"\nRiddle Time! Get the correct answer to go to the other side.\nThe more of this there is, the less you see. What is it?", "darkness"};
    String[] riddleNine = {"\nRiddle Time! Get the correct answer to go to the other side.\nWhat has many keys but can’t open a single lock?", "piano"};
    String[] riddleTen = {"\nRiddle Time! Get the correct answer to go to the other side.\nWhat gets bigger when more is taken away?", "hole"};

    riddles.add(riddleOne);
    riddles.add(riddleTwo);
    riddles.add(riddleThree);
    riddles.add(riddleFour);
    riddles.add(riddleFive);
    riddles.add(riddleSix);
    riddles.add(riddleSeven);
    riddles.add(riddleEight);
    riddles.add(riddleNine);
    riddles.add(riddleTen);

    Random rand = new Random();
    int index = rand.nextInt(riddles.size());

    Riddle riddleInstance = new Riddle(riddles.get(index)[0], riddles.get(index)[1]);
    
    boolean answer = riddleInstance.isSolved();

    if (answer) {
      return this.target;
    } else {
      System.out.println("Shoot! Wrong answer. You are still stuck here.");
      return null;
    }
  }
}
