package exercise1;
import java.io.Console;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import java.util.Random;

public class Test {

  private Random randomObject = new Random();

  public Map<Integer, Map<String, Object>> simulateQuestion() {
    Map<Integer, Map<String, Object>> questions = new HashMap<>();

    ArrayList<String> questionZeroOptions = new ArrayList<String>();
    questionZeroOptions.add(0, "Java default constructor");
    questionZeroOptions.add(1, "Java");
    questionZeroOptions.add(2, "Java method");
    questionZeroOptions.add(3, "Java Class"); //Right answer

    ArrayList<String> questionOneOptions = new ArrayList<String>();
    questionOneOptions.add(0, "Measurement of an object");
    questionOneOptions.add(1, "Height of an object.");
    questionOneOptions.add(2, "Properties of an object"); // right answer
    questionOneOptions.add(3, "Behaviour of an object");

    ArrayList<String> questionTwoOptions = new ArrayList<String>();
    questionTwoOptions.add(0, "Instance variables exist even before methods are called on an object and lasts only till methods are called on an object.");
    questionTwoOptions.add(1, "Instance variables exist before methods are called on an object, while the methods are executing and after the methods complete execution.");
    questionTwoOptions.add(2, "Instance variables exist before methods are called on an object, while the methods are executing and after the methods complete execution."); // right answer
    questionTwoOptions.add(3, "Instance variables starts its life only after a method is called on an object, and lasts till the  method completes its execution.");

    ArrayList<String> questionThreeOptions = new ArrayList<String>();
    questionThreeOptions.add(0, "Parameters are declared in a comma-separated parameter list.");
    questionThreeOptions.add(1, "Parameters are located inside the parentheses that follow the method name in the method declaration.");
    questionThreeOptions.add(2, "Parameters do not need to specify a datatype."); // right answer
    questionThreeOptions.add(3, "Parameter names must follow the naming rules of identifiers.");

    ArrayList<String> questionFourOptions = new ArrayList<String>();
    questionFourOptions.add(0, "It must return more than just one result to its caller.");
    questionFourOptions.add(1, "It must return one result only to the statement one line after the line from which it was called.");
    questionFourOptions.add(2, "It must return a result exactly to the point from which it was called.");
    questionFourOptions.add(3, "It must return one result to the statement immediately after the method body."); // right answer

    Map<String, Object> questionZero = new HashMap<>();
    questionZero.put("question", "Which of the following Java program units defines a group of related objects?");
    questionZero.put("options", questionZeroOptions );
    questionZero.put("answer", 3);

    Map<String, Object> questionOne = new HashMap<>();
    questionOne.put("question", "What does an instance variable describe?");
    questionOne.put("options", questionOneOptions );
    questionOne.put("answer", 2);

    Map<String, Object> questionTwo = new HashMap<>();
    questionTwo.put("question", "Which of the following statements is true in relation to the life of an instance variable?");
    questionTwo.put("options", questionTwoOptions );
    questionTwo.put("answer", 1);

    Map<String, Object> questionThree = new HashMap<>();
    questionThree.put("question", "Which of the following statements is false in relation to Java parameters?");
    questionThree.put("options", questionThreeOptions );
    questionThree.put("answer", 2);

    Map<String, Object> questionFour = new HashMap<>();
    questionFour.put("question", "When a method that specifies a return type other than void is called, what must the method do when it completes its task? and completes its task, the method must return a result to its calling method.");
    questionFour.put("options", questionFourOptions );
    questionFour.put("answer", 3);

    questions.put(0, questionZero);
    questions.put(1, questionOne);
    questions.put(2, questionTwo);
    questions.put(3, questionThree);
    questions.put(4, questionFour);

    return questions;
  }

  public boolean checkAnswer(Integer userAnswer, Integer questionAnswer) {
    return userAnswer == questionAnswer;
  }

  public String generateMessage(boolean gotTheRightAnswer) {
    int randomIndex = randomObject.nextInt(4); // Generate a random number between 0 and 3
    String message = "";

    switch (randomIndex) {
      case 0:
        if (gotTheRightAnswer) {
          message = "Excellent!";
        } else {
          message = "No. Please try again";
        }
        break;
      case 1:
        if (gotTheRightAnswer) {
          message = "Good!";
        } else {
          message = "Wrong. Try once more";
        }
        break;
      case 2:
        if (gotTheRightAnswer) {
          message = "Keep up the good work!";
        } else {
          message = "Don't give up!";
        }
        break;
      case 3:
        if (gotTheRightAnswer) {
          message = "Nice work!";
        } else {
          message = "No. Keep trying..";
        }
        break;
    }

    return message;
  }



  public void inputAnswer() {
    Integer questionNumber = 0;
    Map<Integer, Map<String, Object>> questions = simulateQuestion();

    for (Integer question : questions.keySet()) {
      ArrayList<String> options = (ArrayList<String>) questions.get(question).get("options");
      String[] optionArray = options.toArray(new String[0]);
      Integer questionAnswer = (Integer) questions.get(question).get("answer");
      Object userAnswer = JOptionPane.showInputDialog(null, questions.get(question).get("question"),
          "Question " + (questionNumber + 1), JOptionPane.QUESTION_MESSAGE, null, optionArray, optionArray[0]);
      Integer selectedAnswer = options.indexOf(userAnswer);
      boolean isAnswerRight = checkAnswer(selectedAnswer, questionAnswer);
      JOptionPane.showMessageDialog(null,generateMessage(isAnswerRight));
    }
  }
}
