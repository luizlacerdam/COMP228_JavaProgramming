package exercise1;
import java.io.Console;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

public class Test {

  public Map<Integer, Map<String, Object>> simulateQuestion() {

    Map<Integer, Map<String, Object>> questions = new HashMap<>();

    Map<Integer, String> questionZeroOptions = new HashMap<>();
    questionZeroOptions.put(0, "Java default constructor");
    questionZeroOptions.put(1, "Java");
    questionZeroOptions.put(2, "Java method");
    questionZeroOptions.put(3, "Java Class"); //Right answer

    Map<Integer, String> questionOneOptions = new HashMap<>();
    questionOneOptions.put(0, "Measurement of an object");
    questionOneOptions.put(1, "Height of an object.");
    questionOneOptions.put(2, "Properties of an object"); // right answer
    questionOneOptions.put(3, "Behaviour of an object");

    Map<Integer, String> questionTwoOptions = new HashMap<>();
    questionTwoOptions.put(0, "Instance variables exist even before methods are called on an object and lasts only till methods are called on an object.");
    questionTwoOptions.put(1, "Instance variables exist before methods are called on an object, while the methods are executing and after the methods complete execution.");
    questionTwoOptions.put(2, "Instance variables exist before methods are called on an object, while the methods are executing and after the methods complete execution."); // right answer
    questionTwoOptions.put(3, "Instance variables starts its life only after a method is called on an object, and lasts till the  method completes its execution.");

    Map<Integer, String> questionThreeOptions = new HashMap<>();
    questionThreeOptions.put(0, "Parameters are declared in a comma-separated parameter list.");
    questionThreeOptions.put(1, "Parameters are located inside the parentheses that follow the method name in the method declaration.");
    questionThreeOptions.put(2, "Parameters do not need to specify a datatype."); // right answer
    questionThreeOptions.put(3, "Parameter names must follow the naming rules of identifiers.");

    Map<Integer, String> questionFourOptions = new HashMap<>();
    questionFourOptions.put(0, "It must return more than just one result to its caller.");
    questionFourOptions.put(1, "It must return one result only to the statement one line after the line from which it was called.");
    questionFourOptions.put(2, "It must return one result to the statement immediately after the method body."); // right answer
    questionFourOptions.put(3, "It must return a result exactly to the point from which it was called.");

    Map<String, Object> questionZero = new HashMap<>();
    questionZero.put("question", "Which of the following Java program units defines a group of related objects?");
    questionZero.put("options", questionZeroOptions );

    Map<String, Object> questionOne = new HashMap<>();
    questionOne.put("question", "What does an instance variable describe?");
    questionOne.put("options", questionOneOptions );

    Map<String, Object> questionTwo = new HashMap<>();
    questionTwo.put("question", "Which of the following statements is true in relation to the life of an instance variable?");
    questionTwo.put("options", questionTwoOptions );

    Map<String, Object> questionThree = new HashMap<>();
    questionThree.put("question", "Which of the following statements is false in relation to Java parameters?");
    questionThree.put("options", questionThreeOptions );

    Map<String, Object> questionFour = new HashMap<>();
    questionFour.put("question", "When a method that specifies a return type other than void is called, what must the method do when it completes its task? and completes its task, the method must return a result to its calling method.");
    questionFour.put("options", questionFourOptions );

    questions.put(0, questionZero);
    questions.put(1, questionOne);
    questions.put(2, questionTwo);
    questions.put(3, questionThree);
    questions.put(4, questionFour);

    return questions;
  }

  public void checkAnswer() {

  }

  public void generateMessage() {

  }

  public void inputAnswer() {
    Map<Integer, Map<String, Object>> questions = simulateQuestion();


    JOptionPane.showInputDialog(null, "Test");
  }

}
