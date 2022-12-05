import java.util.*;

/**
* Parent class for an item
*/

public class Item {

  /** Describe item */
  private String description;

  /** whether item can be picked up */
  private boolean canPick;

  /** whether item can be reused */
  private boolean canReuse;

  public Item(String description, boolean canPick, boolean canReuse) {
    this.description = description;
    this.canPick = canPick;
    this.canReuse = canReuse;
  }

  /** Getter for item description */
  public String getDescription() {
    return description;
  }
  
  /** Setter for item description */
  public void setDescription(String s) {
    description = s;
  }

  /** Getter for canPick */
  public boolean getCanPick() {
    return canPick;
  }

  /** Switch access as needed to change canPick*/
  public void switchAccess() {
    if (canPick) {
      canPick = false;
    } else {
      canPick = true;
    }
  }

  /** Getter for canReuse */
  public boolean isReusable() {
    return canReuse;
  }

  /** Setter for canReuse */
  public void setCanReuse(Boolean nCanReuse) {
    this.canReuse = nCanReuse;
  }

  /** Check whether item is accessible 
  * @return T/F item is accessible or not
  */
  public boolean isAccessible() {
    if (canPick) {
      return true;
    } else {
      System.out.println("\u001B[33m" + description + "\u001B[0m");
      return false;
    }
  }
}


