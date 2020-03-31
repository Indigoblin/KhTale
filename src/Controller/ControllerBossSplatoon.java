package Controller;

import Model.Attacks.SplatoonAttack;
import View.ViewHandler;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ControllerBossSplatoon implements EventHandler<MouseEvent> {
    private ViewHandler launcher;

    public ControllerBossSplatoon(ViewHandler viewHandler){
        this.launcher = viewHandler;
        this.launcher.setEventHandlerSplatoon(this);

    }

    @Override
    public void handle(MouseEvent mouseEvent) {

    }
}
