package Controller;

import Model.Attacks.SplatoonAttack;
import Model.ModelGame;
import Model.Player;
import Timeline.GameTL;
import View.ViewHandler;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class ControllerKeyboard implements EventHandler<KeyEvent> {
    private boolean upPressed = false;
    private boolean rightPressed = false;
    private boolean downPressed = false;
    private boolean leftPressed = false;
    private ViewHandler launcher;
    private ModelGame model;
    private Player player;
    private Group root;
    private GameTL jeuTimeLine;
    private SplatoonAttack splatoonAttack;

    public ControllerKeyboard(ViewHandler viewHandler, ModelGame model, Player player) {
        this.model = model;
        this.launcher = viewHandler;
        this.launcher.setEventKeyboard(this);
        jeuTimeLine = new GameTL(this);

    }

    public boolean isUpPressed() {
        return upPressed;
    }

    public boolean isRightPressed() {
        return rightPressed;
    }

    public boolean isDownPressed() {
        return downPressed;
    }

    public boolean isLeftPressed() {
        return leftPressed;
    }

    @Override
    public void handle(KeyEvent keyEvent) {
        if( keyEvent.getEventType().equals(KeyEvent.KEY_PRESSED) ) {
            if( keyEvent.getCode() == KeyCode.UP || keyEvent.getCode() == KeyCode.KP_UP || keyEvent.getCode() == KeyCode.Z ) {
                upPressed = true;
            }
            if( keyEvent.getCode() == KeyCode.RIGHT || keyEvent.getCode() == KeyCode.KP_RIGHT || keyEvent.getCode() == KeyCode.D ) {
                rightPressed = true;
            }
            if( keyEvent.getCode() == KeyCode.DOWN || keyEvent.getCode() == KeyCode.KP_DOWN || keyEvent.getCode() == KeyCode.S ) {
                downPressed = true;
            }
            if( keyEvent.getCode() == KeyCode.LEFT || keyEvent.getCode() == KeyCode.KP_LEFT || keyEvent.getCode() == KeyCode.Q ) {
                leftPressed = true;

            }
        } else if( keyEvent.getEventType().equals(KeyEvent.KEY_RELEASED) ) {
            if( keyEvent.getCode() == KeyCode.UP || keyEvent.getCode() == KeyCode.KP_UP || keyEvent.getCode() == KeyCode.Z ) {
                upPressed = false;
            }
            if( keyEvent.getCode() == KeyCode.RIGHT || keyEvent.getCode() == KeyCode.KP_RIGHT || keyEvent.getCode() == KeyCode.D ) {
                rightPressed = false;
            }
            if( keyEvent.getCode() == KeyCode.DOWN || keyEvent.getCode() == KeyCode.KP_DOWN || keyEvent.getCode() == KeyCode.S ) {
                downPressed = false;
            }
            if( keyEvent.getCode() == KeyCode.LEFT || keyEvent.getCode() == KeyCode.KP_LEFT || keyEvent.getCode() == KeyCode.Q ) {
                leftPressed = false;
            }
        }

    }

    public ViewHandler getLauncher() {
        return launcher;
    }
}