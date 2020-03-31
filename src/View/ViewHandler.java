package View;

import Controller.ControllerBossSplatoon;
import Controller.ControllerKeyboard;
import Controller.ControllerMenu;
import Controller.ControllerSelect;
import Model.ModelGame;
import Model.Player;
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
    private ViewBossSelection vSelect;
    private ViewBossSplatoon vSplatoon;
    private ModelGame modelGame;
    private ControllerMenu controllerMenu;
    private ControllerSelect controllerSelect;
    private Player player;
    private ControllerKeyboard keyListen;

    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        root = new Group();
        scene = new Scene(root, 1000, 600, Color.BLACK);
        vMenu = new ViewMainMenu(this,root);
        vSelect = new ViewBossSelection(this,root);
        vSplatoon = new ViewBossSplatoon(this,root,player);
        controllerSelect = new ControllerSelect(this);
        controllerMenu = new ControllerMenu(this);
        keyListen = new ControllerKeyboard(this,modelGame,player);

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

    public void setEventHandlerSelect(ControllerSelect cs){
        vSelect.setEvents(cs);
    }

    public ViewBossSelection getvSelect(){
        return vSelect;
    }

    public void setvSelect(){
        vSelect.initView();
    }

    public void setEventKeyboard(ControllerKeyboard kl){
        vSplatoon.setEvents(kl);
    }

    public ViewBossSplatoon getvSplatoon(){
        return vSplatoon;
    }
    public void setvSplatoon(){
        vSplatoon.initView();
    }


    public void setEventHandlerSplatoon(ControllerBossSplatoon bs) { vSplatoon.setEvent(bs); }
}
