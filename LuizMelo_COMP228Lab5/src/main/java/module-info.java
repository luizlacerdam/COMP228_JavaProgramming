module com.example.luizmelo_comp228lab5 {
    requires javafx.controls;
    requires javafx.fxml;
  requires java.sql;
  requires java.desktop;

  opens com.example.luizmelo_comp228lab5 to javafx.fxml;
    exports com.example.luizmelo_comp228lab5;
}