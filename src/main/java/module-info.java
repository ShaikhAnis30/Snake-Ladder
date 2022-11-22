module com.example.realsnakeladder {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.realsnakeladder to javafx.fxml;
    exports com.example.realsnakeladder;
}