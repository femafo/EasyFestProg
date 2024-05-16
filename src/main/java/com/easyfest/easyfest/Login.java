package com.easyfest.easyfest;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Login implements Initializable {

    @FXML
    private Button loginid;
    @FXML
    private TextField passwordid;
    @FXML
    private Label regisid;
    @FXML
    private TextField usermailid;
    @FXML
    private CheckBox recuerdameid;
    @FXML
    private Label forgotid;
    @FXML
    private AnchorPane LoginPageid;

    @FXML
    public void login(ActionEvent actionEvent) {
    }

    @FXML
    public void forget(Event event) {
        try {
            AnchorPane forget = FXMLLoader.load(getClass().getResource("forgotpassword.fxml"));
            this.LoginPageid.getChildren().setAll(forget);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void resgistro(Event event) {
        try {
            AnchorPane registro = FXMLLoader.load(getClass().getResource("registro.fxml"));
            this.LoginPageid.getChildren().setAll(registro);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}