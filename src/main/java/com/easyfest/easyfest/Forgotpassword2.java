package com.easyfest.easyfest;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class Forgotpassword2
{
    @javafx.fxml.FXML
    private Button changebid;
    @javafx.fxml.FXML
    private TextField newcontr2;
    @javafx.fxml.FXML
    private TextField newcontr1;
    @javafx.fxml.FXML
    private AnchorPane forgotpassword2;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void changecontrbutton(ActionEvent actionEvent) {
        try {
            AnchorPane login = FXMLLoader.load(getClass().getResource("login.fxml"));
            this.forgotpassword2.getChildren().setAll(login);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}