package lk.ijse.chatApp.util;

import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class Style {
    public static void setStyleMe(HBox hBox, Text text2, TextFlow flow2) {
        hBox.setPadding(new Insets(5, 5, 5, 10));
        text2.setStyle("-fx-font-size: 15px");
        flow2.setStyle("-fx-color:rgb(239,242,255);"
                + "-fx-background-color: rgb(46, 204, 113);" +
                "-fx-background-radius: 20px");
        flow2.setPadding(new Insets(5, 10, 5, 10));
        text2.setFill(Color.color(0.934, 0.945, 0.996));
    }

    public static void setStyleOther(HBox hBox,Text text, TextFlow flow) {
        hBox.setPadding(new Insets(5, 5, 5, 10));
        text.setStyle("-fx-font-size: 15px");
        flow.setStyle("-fx-color:rgb(239,242,255);"
                + "-fx-background-color: rgb(52, 152, 219);" +
                "-fx-background-radius: 20px");
        flow.setPadding(new Insets(5, 10, 5, 10));
        text.setFill(Color.color(0.934, 0.945, 0.996));
    }
}
