package com.easyfest.easyfest;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class Forgotpassword
{
    @javafx.fxml.FXML
    private AnchorPane forgotontr;
    @javafx.fxml.FXML
    private Button continuarbid;
    @javafx.fxml.FXML
    private TextField correorecupid;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void continuarbutton(ActionEvent actionEvent) {
        try {
            AnchorPane forget2 = FXMLLoader.load(getClass().getResource("forgotpassword2.fxml"));
            this.forgotontr.getChildren().setAll(forget2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}