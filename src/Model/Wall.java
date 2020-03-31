package Model;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Wall {
    private Rectangle zoneFight;
    private Group root;

    public Wall(Group root){
        this.root = root;

        zoneFight = initRectangle(365,260,270,250);

        root.getChildren().add(zoneFight);

    }

    private Rectangle initRectangle(int x, int y, int width, int height){
        Rectangle r = new Rectangle();
        r.setX(x);
        r.setY(y);
        r.setWidth(width);
        r.setHeight(height);
        r.setStroke(Color.WHITE);
        r.setFill(null);
        r.setStrokeWidth(8);
        return r;
    }
}
