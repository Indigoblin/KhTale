package View;

import Controller.ControllerSelect;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import Tools.Path;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ViewBossSelection {
    private ViewHandler vSelect;
    private Group root;
    private ImageView imgBoss;
    private VBox leftSide, splatBox, secondSide;
    private Text screenText, titleSplatoon, titlePasDispo;
    private Font fontScreenText;



    ViewBossSelection(ViewHandler vSelect, Group root){
        this.vSelect = vSelect;
        this.root = root;


        // initialisation des écrans des boss
        imgBoss = initImage();
        titleSplatoon = initTitleSplat();
        titlePasDispo = initTitleEmpty();

        imgBoss.setOnMouseEntered(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent hover) {
                imgBoss.setImage(new Image(Path.iconSplatoonH));
                titleSplatoon.setFill(Color.YELLOW);
            }
        });

        imgBoss.setOnMouseExited(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent exitHover) {
                imgBoss.setImage(new Image(Path.iconSplatoonLv));
                titleSplatoon.setFill(Color.WHITE);
            }
        });


        splatBox = new VBox(imgBoss,titleSplatoon);
        splatBox.setAlignment(Pos.CENTER);
        splatBox.setSpacing(10);

        secondSide = new VBox(titlePasDispo);
        secondSide.setAlignment(Pos.CENTER);
        secondSide.setSpacing(10);


        leftSide = new VBox(splatBox,secondSide);
        leftSide.setAlignment(Pos.CENTER);
        leftSide.setPadding(new Insets(75, 20, 15, 150));
        leftSide.setSpacing(150);

    }

    void initView(){
        root.getChildren().clear();
        root.getChildren().add(leftSide);
    }

    private Text titleBoss(String screenBoss, int size){
        Text t = new Text();
        t.setText(screenBoss);
        t.setFont(Font.font(size));
        return t;
    }

    private Text initTitleSplat(){
        screenText = new Text();
        screenText = titleBoss("Callie & Marie",20);
        fontScreenText = Font.loadFont(getClass().getResourceAsStream(Path.monsterFriendFore), 20);
        screenText.setFont(fontScreenText);
        screenText.setFill(Color.WHITE);
        return screenText;
    }

    private Text initTitleEmpty(){
        screenText = new Text();
        screenText = titleBoss("Pas encore dispo",20);
        fontScreenText = Font.loadFont(getClass().getResourceAsStream(Path.monsterFriendFore), 20);
        screenText.setFont(fontScreenText);
        screenText.setFill(Color.WHITE);
        return screenText;
    }

    private ImageView initImage(){
        ImageView img = new ImageView(Path.iconSplatoonLv);
        img.setFitHeight(175);
        img.setFitWidth(300);
        return img;
    }

    public ImageView getSplatLv(){
        return imgBoss;
    }

    public void setEvents(ControllerSelect cs) {
        imgBoss.setOnMouseClicked(cs);
    }
}
