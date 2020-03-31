package Model;

import Tools.Path;
import javafx.scene.Group;
import javafx.scene.image.ImageView;

public class NpcSplatoon {
    private Group root;
    private ImageView callie, marie;

    public NpcSplatoon(Group root) {
        this.root = root;
        callie = new ImageView(Path.callie);
        callie.setY(25);
        callie.setX(250);

        marie = new ImageView(Path.marie);
        marie.setY(25);
        marie.setX(600);

        root.getChildren().add(callie);
        root.getChildren().add(marie);
    }
}