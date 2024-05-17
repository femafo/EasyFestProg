module com.easyfest.easyfest {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.easyfest.easyfest to javafx.fxml;
    exports com.easyfest.easyfest;
}