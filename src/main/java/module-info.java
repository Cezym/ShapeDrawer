module com.program.shapedrawer {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.program.shapedrawer to javafx.fxml;
    exports com.program.shapedrawer;
}