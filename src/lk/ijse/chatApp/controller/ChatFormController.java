package lk.ijse.chatApp.controller;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class ChatFormController implements Initializable {
    public VBox ClientVBox;
    public TextField txtMessage;
    public Label LabelClientName;

    public void MSGSendMouseAction(MouseEvent mouseEvent) {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        LabelClientName.setText(LoginFormController.userName);
    }

    public void emoji1(MouseEvent mouseEvent) {
    }

    public void emoji2(MouseEvent mouseEvent) {
    }

    public void emoji3(MouseEvent mouseEvent) {
    }

    public void emoji4(MouseEvent mouseEvent) {
    }

    public void emoji5(MouseEvent mouseEvent) {
    }

    public void emoji6(MouseEvent mouseEvent) {
    }

    public void emoji7(MouseEvent mouseEvent) {
    }

    public void emoji8(MouseEvent mouseEvent) {
    }

    public void emoji9(MouseEvent mouseEvent) {
    }

    public void emoji10(MouseEvent mouseEvent) {
    }

    public void emoji11(MouseEvent mouseEvent) {
    }

    public void emoji12(MouseEvent mouseEvent) {
    }
}
