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
}
