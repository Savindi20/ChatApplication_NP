package lk.ijse.chatApp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class AppInitializer extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("view/LoginForm.fxml"))));
        primaryStage.centerOnScreen();
        primaryStage.setTitle("Chat Application");
        primaryStage.getIcons().add(new Image("lk/ijse/chatApp/view/images/chat-icon.png"));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
