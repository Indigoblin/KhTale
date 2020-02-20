package Controller;

import View.ViewHandler;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ControllerMenu implements EventHandler<MouseEvent> {
    private ViewHandler launcher;

    public ControllerMenu(ViewHandler viewHandler){
        this.launcher = viewHandler;
        this.launcher.setEventHandlerMenu(this);
    }

    @Override
    public void handle(MouseEvent event) {
        if (event.getSource().equals(launcher.getvMenu().getBtnQuit())){
            System.exit(0);
        }
    }
}
