module com.example.studentgroupapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.studentgroupapp to javafx.fxml;
    exports com.example.studentgroupapp;
}