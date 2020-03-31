package Timeline;

import Controller.ControllerKeyboard;
import View.ViewBossSplatoon;
import javafx.animation.AnimationTimer;

public class GameTL extends AnimationTimer {
    private final ControllerKeyboard controllerKeyboard;


    public GameTL(ControllerKeyboard controllerKeyboard){
        this.controllerKeyboard = controllerKeyboard;
        this.start();
    }

    @Override
    public void handle(long now) {
        if (controllerKeyboard.isUpPressed()){
            controllerKeyboard.getLauncher().getvSplatoon().move(ViewBossSplatoon.up);
            controllerKeyboard.getLauncher().getvSplatoon().checkPosition();
        }
        if(controllerKeyboard.isLeftPressed()){
            controllerKeyboard.getLauncher().getvSplatoon().move(ViewBossSplatoon.left);
            controllerKeyboard.getLauncher().getvSplatoon().checkPosition();
        }
        if(controllerKeyboard.isRightPressed()){
            controllerKeyboard.getLauncher().getvSplatoon().move(ViewBossSplatoon.right);
            controllerKeyboard.getLauncher().getvSplatoon().checkPosition();
        }
        if(controllerKeyboard.isDownPressed()){
            controllerKeyboard.getLauncher().getvSplatoon().move(ViewBossSplatoon.down);
            controllerKeyboard.getLauncher().getvSplatoon().checkPosition();
        }

    }
}