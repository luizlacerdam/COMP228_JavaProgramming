module com.example.luizmelo_comp228lab4 {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;

    // Open the `exercise1` package to JavaFX modules for reflection
    opens exercise1 to javafx.graphics;

    // Export the `exercise1` package if it needs to be accessible outside this module
    exports exercise1;
}
