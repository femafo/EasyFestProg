module com.easyfest.easyfest {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;
    requires mysql.connector.j;


    opens com.easyfest.easyfest to javafx.fxml;
    exports com.easyfest.easyfest;
}