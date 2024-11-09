package exercise1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.HashSet;

public class App extends Application {
  private HashSet<String> selectedCourses = new HashSet<>();

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("Student Information");

    BorderPane root = new BorderPane();
    root.setPadding(new Insets(10));

    GridPane form = new GridPane();
    form.setHgap(10);
    form.setVgap(10);
    form.setPadding(new Insets(10));

    for (int i = 0; i < 7; i++) {
      RowConstraints row = new RowConstraints();
      row.setMinHeight(40);
      form.getRowConstraints().add(row);
    }

    Label nameLabel = new Label("Name:");
    TextField nameField = new TextField();
    Label addressLabel = new Label("Address:");
    TextField addressField = new TextField();
    Label cityLabel = new Label("City:");
    TextField cityField = new TextField();
    Label provinceLabel = new Label("Province:");
    TextField provinceField = new TextField();
    Label postalLabel = new Label("Postal Code:");
    TextField postalField = new TextField();
    Label phoneLabel = new Label("Phone Number:");
    TextField phoneField = new TextField();
    Label emailLabel = new Label("Email:");
    TextField emailField = new TextField();

    CheckBox studentCouncilBox = new CheckBox("Student Council");
    CheckBox volunteerWorkBox = new CheckBox("Volunteer Work");

    ToggleGroup majorGroup = new ToggleGroup();
    RadioButton csButton = new RadioButton("Computer Science");
    RadioButton businessButton = new RadioButton("Business");
    csButton.setToggleGroup(majorGroup);
    businessButton.setToggleGroup(majorGroup);

    HBox majorBox = new HBox(10, csButton, businessButton);

    ComboBox<String> courseComboBox = new ComboBox<>();
    ListView<String> courseList = new ListView<>();
    courseList.setPrefHeight(150);

    csButton.setOnAction(e -> {
      courseComboBox.getItems().clear();
      courseComboBox.getItems().addAll("Python", "C#", "Java");
    });

    businessButton.setOnAction(e -> {
      courseComboBox.getItems().clear();
      courseComboBox.getItems().addAll("Economics", "Finance", "Marketing");
    });

    courseComboBox.setOnAction(e -> {
      String selectedCourse = courseComboBox.getValue();
      if (selectedCourse != null && !selectedCourses.contains(selectedCourse)) {
        selectedCourses.add(selectedCourse);
        courseList.getItems().add(selectedCourse);
      }
    });

    VBox courseBox = new VBox(10, courseComboBox, courseList);

    form.addRow(0, nameLabel, nameField);
    form.add(addressLabel, 0, 1);
    form.add(addressField, 1, 1);
    form.add(provinceLabel, 0, 2);
    form.add(provinceField, 1, 2);
    form.add(cityLabel, 0, 3);
    form.add(cityField, 1, 3);
    form.add(postalLabel, 0, 4);
    form.add(postalField, 1, 4);
    form.add(phoneLabel, 0, 5);
    form.add(phoneField, 1, 5);
    form.add(emailLabel, 0, 6);
    form.add(emailField, 1, 6);
    form.add(studentCouncilBox, 2, 1);
    form.add(majorBox, 3, 0);
    form.add(volunteerWorkBox, 2, 5);

    form.add(courseBox, 3, 1, 1, 6);

    TextArea displayArea = new TextArea();
    displayArea.setEditable(false);
    displayArea.setWrapText(false);

    // Make the TextArea much larger than the ScrollPane to enable scrolling
    displayArea.setPrefSize(1200, 800);

    ScrollPane scrollPane = new ScrollPane(displayArea);
    scrollPane.setPrefHeight(200); // Limit the viewport height
    scrollPane.setPrefWidth(600); // Limit the viewport width
    scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
    scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

    Button displayButton = new Button("Display");
    displayButton.setOnAction(e -> {
      StringBuilder info = new StringBuilder();
      info.append(nameField.getText()).append(", ");
      info.append(addressField.getText()).append(", ");
      info.append(cityField.getText()).append(", ");
      info.append(provinceField.getText()).append(", ");
      info.append(postalField.getText()).append(", ");
      info.append(phoneField.getText()).append(", ");
      info.append(emailField.getText()).append("\n");

      info.append("Major: ");
      if (csButton.isSelected()) {
        info.append("Computer Science\n");
      } else if (businessButton.isSelected()) {
        info.append("Business\n");
      }

      info.append("Courses: ").append(String.join(", ", selectedCourses)).append("\n");

      info.append("Activities: ");
      if (studentCouncilBox.isSelected()) info.append("Student Council ");
      if (volunteerWorkBox.isSelected()) info.append("Volunteer Work");

      displayArea.setText(info.toString());
    });

    HBox buttonBox = new HBox(displayButton);
    buttonBox.setAlignment(Pos.CENTER);
    buttonBox.setPadding(new Insets(10));

    VBox displayBox = new VBox(10, buttonBox, scrollPane);
    displayBox.setPadding(new Insets(10));

    root.setCenter(form);
    root.setBottom(displayBox);

    primaryStage.setScene(new Scene(root, 800, 600));
    primaryStage.show();
  }
}
