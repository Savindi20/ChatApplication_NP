package lk.ijse.chatApp.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginFormController {
    public JFXTextField txtUserNameLogin;

    static String userName;

    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {
        userName=txtUserNameLogin.getText();
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(LoginFormController.class.getResource("../view/ChatForm.fxml"))));
        stage.close();
        stage.setTitle("Chat Application");
        stage.getIcons().add(new Image("lk/ijse/chatApp/view/images/chat-icon.png"));
        stage.centerOnScreen();
        stage.setResizable(false);
        stage.show();
    }
}
