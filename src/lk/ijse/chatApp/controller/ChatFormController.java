package lk.ijse.chatApp.controller;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
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
import javafx.stage.Stage;
import lk.ijse.chatApp.util.Style;

import java.io.*;
import java.net.Socket;

public class ChatFormController extends Thread {

    public TextField txtMessage;
    public Pane EmojiPane;
    public javafx.scene.layout.VBox VBox;
    public Text txtClientName;
    public ScrollPane scrollPane;

    BufferedReader reader;
    PrintWriter writer;
    Socket socket;

    private FileChooser fileChooser;
    private File filePath;


    public void initialize() {
        txtClientName.setText(LoginFormController.userName);
        EmojiPane.setVisible(false);

        scrollPane.setOnMouseExited(e -> {
            scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
            scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        });
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
                //for the Images

                if (firstChars.equalsIgnoreCase("img")) {

                    st = st.substring(3, st.length() - 1);


                    File file = new File(st);
                    Image image = new Image(file.toURI().toString());

                    ImageView imageView = new ImageView(image);

                    imageView.setFitHeight(150);
                    imageView.setFitWidth(150);


                    HBox hBox = new HBox(10);
                    hBox.setAlignment(Pos.BOTTOM_RIGHT);


                    if (!cmd.equalsIgnoreCase(txtClientName.getText())) {

                        VBox.setAlignment(Pos.TOP_LEFT);
                        hBox.setAlignment(Pos.CENTER_LEFT);


                        Text text1 = new Text("  " + cmd + "  ");
                        text1.setFill(Color.color(0.934, 0.945, 0.996));

                        hBox.getChildren().add(text1);
                        hBox.getChildren().add(imageView);

                    } else {
                        hBox.setAlignment(Pos.BOTTOM_RIGHT);
                        hBox.getChildren().add(imageView);
                        Text text1 = new Text("      ");
                        hBox.getChildren().add(text1);

                        text1.setFill(Color.color(0.934, 0.945, 0.996));
                    }

                   Platform.runLater(() -> VBox.getChildren().addAll(hBox));


                    //
                } else {

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
        Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        fileChooser = new FileChooser();
        fileChooser.setTitle("Open Image");
        this.filePath = fileChooser.showOpenDialog(stage);
        writer.println(txtClientName.getText() + " " + "img" + filePath.getPath());
    }

    //emoji
    public void emojiMouseClick(MouseEvent mouseEvent) {
        EmojiPane.setVisible(true);
    }


    public void emoji1(MouseEvent mouseEvent) {
        String emoji = new String(Character.toChars(0x1F600));
        txtMessage.setText(emoji);
        EmojiPane.setVisible(false);
    }

    public void emoji2(MouseEvent mouseEvent) {
        String emoji = new String(Character.toChars(0x1F600));
        txtMessage.setText(emoji);
        EmojiPane.setVisible(false);
    }

    public void emoji3(MouseEvent mouseEvent) {
        String emoji = new String(Character.toChars(0x1F603));
        txtMessage.setText(emoji);
        EmojiPane.setVisible(false);
    }

    public void emoji4(MouseEvent mouseEvent) {
        String emoji = new String(Character.toChars(0x1F604));
        txtMessage.setText(emoji);
        EmojiPane.setVisible(false);
    }

    public void emoji5(MouseEvent mouseEvent) {
        String emoji = new String(Character.toChars(0x1F601));
        txtMessage.setText(emoji);
        EmojiPane.setVisible(false);
    }

    public void emoji6(MouseEvent mouseEvent) {
        String emoji = new String(Character.toChars(0x1F605));
        txtMessage.setText(emoji);
        EmojiPane.setVisible(false);
    }

    public void emoji7(MouseEvent mouseEvent) {
        String emoji = new String(Character.toChars(0x1F923));
        txtMessage.setText(emoji);
        EmojiPane.setVisible(false);
    }

    public void emoji8(MouseEvent mouseEvent) {
        String emoji = new String(Character.toChars(0x1F60D));
        txtMessage.setText(emoji);  EmojiPane.setVisible(false);
    }

    public void emoji9(MouseEvent mouseEvent) {
        String emoji = new String(Character.toChars(0x1F60E));
        txtMessage.setText(emoji);  EmojiPane.setVisible(false);
    }

    public void emoji10(MouseEvent mouseEvent) {
        String emoji = new String(Character.toChars(0x1F607));
        txtMessage.setText(emoji);  EmojiPane.setVisible(false);
    }

    public void emoji11(MouseEvent mouseEvent) {

        String emoji = new String(Character.toChars(0x1F608));
        txtMessage.setText(emoji);  EmojiPane.setVisible(false);
    }

    public void emoji12(MouseEvent mouseEvent) {
        String emoji = new String(Character.toChars(0x1F608));
        txtMessage.setText(emoji);  EmojiPane.setVisible(false);
    }


}

