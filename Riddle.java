import java.util.Scanner;

/** User interface class for riddle feature */
public class Riddle {

  /** riddle question */
  private String question;

  /** riddle answer */
  private String answer;

  /** whether riddle solved */
  public boolean solved = false;

  public Riddle(String question, String answer) {
    this.question = question;
    this.answer = answer;
  }

  /** Getter for question */
  public String getQuestion() {
    return question;
  }

  /** Setter for question */
  public void setQuestion(String question) {
    this.question = question;
  }
  /** Getter for answer */
  public String getAnswer() {
    return question;
  }

  /** Setter for answer */
  public void setAnswer(String answer) {
    this.answer = answer;
  }
  /** user interface to ask riddle
  * @return T/F: whether user solved riddle or not
  */
  public boolean isSolved() {
    System.out.println("\u001B[32m" + question + "\u001B[0m");
    Scanner scan = new Scanner(System.in);
    String input = scan.nextLine();

    String[] inputArr = input.split(" ");

    if (inputArr.length == 1) {
      if (input.toLowerCase().equals(this.answer)) {
        return solved = true;
      } else {
        return solved = false;
      }
    } else {
      if (inputArr[1].toLowerCase().equals(this.answer)) {
        return solved = true;
      } else {
        return solved = false;
      }
    }
    
  }
}