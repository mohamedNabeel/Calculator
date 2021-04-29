package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.stage.Screen;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception{

        Group root = new Group();
        stage.setTitle("Hello World");
        stage.setScene(Buttons.getScene());
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
