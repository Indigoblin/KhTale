package View;

import Controller.ControllerBossSplatoon;
import Controller.ControllerKeyboard;
import Model.Attacks.SplatoonAttack;
import Model.NpcSplatoon;
import Model.Player;
import Model.Wall;
import Tools.Path;
import javafx.scene.Group;
import javafx.scene.image.ImageView;

public class ViewBossSplatoon {
    private Group root;
    private ViewHandler vBSplatoon;
    private ControllerKeyboard keyListen;
    private ImageView spritePlayer;
    public static final String up = "Up";
    public static final String left = "Left";
    public static final String right = "Right";
    public static final String down = "Down";
    private int speedMove;
    private Wall zoneFight;
    public static Player player;
    private NpcSplatoon npcSplatoon;
    private SplatoonAttack splatoonAttack;

    public void move(String direction){
        switch (direction){
            case up:
                spritePlayer.setLayoutY(spritePlayer.getLayoutY()-speedMove);
                break;

            case left:
                spritePlayer.setLayoutX(spritePlayer.getLayoutX()-speedMove);
                break;

            case right:
                spritePlayer.setLayoutX(spritePlayer.getLayoutX()+speedMove);
                break;

            case down:
                spritePlayer.setLayoutY(spritePlayer.getLayoutY()+speedMove);
                break;
        }
    }

    public ViewBossSplatoon(ViewHandler vBSplatoon, Group root, Player player) {
        this.vBSplatoon = vBSplatoon;
        this.root = root;
        this.player = player;


        spritePlayer = new ImageView(Path.joueurFullHealth);
        spritePlayer.setFitHeight(100);
        spritePlayer.setFitWidth(140);
        spritePlayer.setX(430);
        spritePlayer.setY(360);
        speedMove = 7;
    }

    public void checkPosition(){
        if (spritePlayer.getLayoutX() < -117) {
            spritePlayer.setLayoutX(-117);
        }
        if (spritePlayer.getLayoutX() > 117){
            spritePlayer.setLayoutX(117);
        }
        if (spritePlayer.getLayoutY() > 80){
            spritePlayer.setLayoutY(80);
        }
        if (spritePlayer.getLayoutY() < -134){
            spritePlayer.setLayoutY(-134);
        }
    }



    void initView(){
        root.getChildren().clear();

        splatoonAttack = new SplatoonAttack(root);
        npcSplatoon = new NpcSplatoon(root);
        root.getChildren().add(spritePlayer);
        zoneFight = new Wall(root);

    }

    public void setEvents(ControllerKeyboard kl){
        root.getScene().setOnKeyPressed(kl);
        root.getScene().setOnKeyReleased(kl);
    }

    public void setEvent(ControllerBossSplatoon bs){

    }

    public Group getRoot() {
        return root;
    }
}
