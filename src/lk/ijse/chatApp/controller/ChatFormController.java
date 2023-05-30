package lk.ijse.chatApp.controller;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.FileChooser;
import lk.ijse.chatApp.util.Style;

import java.io.*;
import java.net.Socket;

public class ChatFormController extends Thread {

    public TextField txtMessage;
    public Pane EmojiPane;
    public javafx.scene.layout.VBox VBox;
    public Text txtClientName;

    BufferedReader reader;
    PrintWriter writer;
    Socket socket;

    private FileChooser fileChooser;
    private File filePath;


    public void initialize() {
        txtClientName.setText(LoginFormController.userName);
        EmojiPane.setVisible(false);
        try {
            socket = new Socket("localhost", 8888);
            System.out.println("Socket is connected with server!");
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);

            this.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
@Override
    public void run() {
        try {
            while (true) {


                String msg = reader.readLine();
                String[] tokens = msg.split(" ");
                String cmd = tokens[0];


                StringBuilder fullMsg = new StringBuilder();
                for (int i = 1; i < tokens.length; i++) {
                    fullMsg.append(tokens[i] + " ");
                }


                String[] msgToAr = msg.split(" ");
                String st = "";
                for (int i = 0; i < msgToAr.length - 1; i++) {
                    st += msgToAr[i + 1] + " ";
                }


                Text text = new Text(st);
                String firstChars = "";
                if (st.length() > 3) {
                    firstChars = st.substring(0, 3);

                }
                //
                     else {

                    TextFlow tempFlow = new TextFlow();

                    if (!cmd.equalsIgnoreCase(txtClientName.getText() + "-")) {
                        Text txtName = new Text(cmd + " ");
                        txtName.getStyleClass().add("txtName");
                        tempFlow.getChildren().add(txtName);
                    }

                    tempFlow.getChildren().add(text);
                    tempFlow.setMaxWidth(200);
                    TextFlow flow = new TextFlow(tempFlow);

                    HBox hBox = new HBox(12);
                    Style.setStyleOther(hBox, text, flow);


                    if (!cmd.equalsIgnoreCase(txtClientName.getText() + "-")) {
                        VBox.setAlignment(Pos.TOP_LEFT);
                        hBox.setAlignment(Pos.CENTER_LEFT);
                        hBox.getChildren().add(flow);


                    } else {

                        Text text2 = new Text(fullMsg + "");
                        TextFlow flow2 = new TextFlow(text2);
                        hBox.setAlignment(Pos.BOTTOM_RIGHT);
                        Style.setStyleMe(hBox, text2, flow2);

                        hBox.getChildren().add(flow2);
                    }

                  Platform.runLater(() -> VBox.getChildren().addAll(hBox));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    //msg send
    public void MSGSendMouseAction(MouseEvent mouseEvent) {
        String msg = txtMessage.getText();
        writer.println(txtClientName.getText() + "- " + msg);
        System.out.println("send Method======= " + txtClientName.getText() + "- " + msg);
        txtMessage.clear();
        if (msg.equalsIgnoreCase("exit")) {
            System.exit(0);
        }
    }

    //image
    public void picMouseClick(MouseEvent mouseEvent) {
    }

    //emoji
    public void emojiMouseClick(MouseEvent mouseEvent) {
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

