package View;

import Controller.ControllerMenu;
import Tools.Music;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ViewHandler extends Application {
    private Stage primaryStage;
    private Scene scene;
    private Group root;
    private ViewMainMenu vMenu;
    private ControllerMenu controllerMenu;

    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        root = new Group();
        scene = new Scene(root, 1000, 600, Color.BLACK);
        vMenu = new ViewMainMenu(this,root);
        controllerMenu = new ControllerMenu(this);

        Music.startMainMenuMusic();
        primaryStage.setTitle("KingdomTale");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public void setEventHandlerMenu(ControllerMenu cm) {
        vMenu.setEvents(cm);
    }

    public ViewMainMenu getvMenu() {
        return vMenu;
    }
}
