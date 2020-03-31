package Controller;

import Model.Attacks.SplatoonAttack;
import Tools.Music;
import View.ViewHandler;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ControllerSelect implements EventHandler<MouseEvent> {
    private ViewHandler launcher;

    public ControllerSelect(ViewHandler viewHandler){
        this.launcher = viewHandler;
        this.launcher.setEventHandlerSelect(this);
    }

    @Override
    public void handle(MouseEvent event) {
        if (event.getSource().equals(launcher.getvSelect().getSplatLv())){
            Music.startSplatoonLevelMusic();
            launcher.setvSplatoon();

            for (int i = 0; i < 20; i++) {
                SplatoonAttack firstPhase = new SplatoonAttack(launcher.getvSplatoon().getRoot());
                firstPhase.startFirstPhase();
            }
        }
    }
}
