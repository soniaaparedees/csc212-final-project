import java.util.Arrays;

public class WordSplitter {

  // Pre-defined set of command input by input type
  public static String[] verbs = {"go", "pick", "use", "return", "drop", "view", "search", "quit", "save"};

  public static String[] directions = {"up", "down", "left", "right", "back"};
  
  private static String[] items = {"help", "room", "inventory", "game", "inventory", "description", "cloth", "lamp", "screwdriver", "shelf", "wood", "table", "box", "bucket", "knife", "chair", "plate", "cabinets", "food", "spoon", "fork", "rats", "book", "magazine", "iPod", "pen", "desk", "gloves", "cushion", "candle", "couch", "notebook", "sandwich", "mug", "cover", "rose", "vase", "bowl", "chains", "pillows", "blanket", "bed", "shirt", "rug", "mirror", "paper", "toothpaste", "toothbrush", "shampoo", "lotion", "razor", "picture", "leaf", "parabola", "mask", "toy", "control", "flag", "torch"};
  
  /*
  * Splits command into two words and returns the either 1st or 2nd word
  * @param s String to split
  * @param isFirst Boolean to know if the desired output is first or second word
  * @return first or second word, empty string if invalid
  */
  public static String split(String s, boolean isFirst) {
    String[] command= s.split(" ");
    // Check if we have a two word command
    if (command.length == 2) {
      // Check if first word is valid verb
      if (isVerb(command[0])) {
        // Check if second word is a valid direction or item
        if (isDirection(command[1])) {
          if (isFirst) {
            return command[0];
          } else {
            return command[1];
          }
        } else if (isItem(command[1])) {
          if (isFirst) {
            return command[0];
          } else {
            return command[1];
          }
        } else {
          return "";
        }
      } else {
        return "";
      }
    } else {
      return "";
    }
  }

  /* Check if command is valid verb */
  public static boolean isVerb(String s) {
    return Arrays.asList(verbs).contains(s);
  }

  /* Check if command is valid direction */
  public static boolean isDirection(String s) {
    return Arrays.asList(directions).contains(s);
  }

  /* Check if command is valid item */
  public static boolean isItem(String s) {
    return Arrays.asList(items).contains(s);
  }
  
}