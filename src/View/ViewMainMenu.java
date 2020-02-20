package View;

import Tools.Path;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ViewMainMenu {
    private ViewHandler vhMenu;
    private Button btnStart, btnQuit;
    private Group root;
    private Text screenText, screenTextBack;
    private Font fontScreenText, fontScreenTextBack;

    ViewMainMenu(ViewHandler vhMenu, Group root){
        this.vhMenu = vhMenu;
        this.root = root;

        // initialisation des boutons
        btnStart = initButton(150, 420, "Start");
        btnQuit = initButton(750,420,"Quit");

        initTitle();
        initView();
    }

    void initView(){
        root.getChildren().clear();
        root.getChildren().add(btnStart);
        root.getChildren().add(btnQuit);
        root.getChildren().add(screenTextBack);
        root.getChildren().add(screenText);
    }

    private Button initButton(int width, int height, String BtnTxt) {
        Button b = new Button();
        b.setLayoutX(width);
        b.setLayoutY(height);
        b.setText(BtnTxt);
        b.setBackground(null);
        fontScreenText = Font.loadFont(getClass().getResourceAsStream(Path.fontDTMSans), 40);
        b.setFont(fontScreenText);
        b.setTextFill(Color.WHITE);
        return b;
    }

    private Text titleScreen(String screenTitle, int width, int height){
        Text t = new Text();
        t.setText(screenTitle);
        t.setLayoutX(width);
        t.setLayoutY(height);
        return t;
    }

    private void initTitle(){
        screenTextBack = new Text();
        screenTextBack = titleScreen("KingdomTale",200,150);
        fontScreenTextBack = Font.loadFont(getClass().getResourceAsStream(Path.monsterFriendBack), 60);
        screenTextBack.setFont(fontScreenTextBack);
        screenTextBack.setFill(Color.GRAY);
        screenText = new Text();
        screenText = titleScreen("KingdomTale",200,150);
        fontScreenText = Font.loadFont(getClass().getResourceAsStream(Path.monsterFriendFore), 60);
        screenText.setFont(fontScreenText);
        screenText.setFill(Color.WHITE);
    }

    public Button getBtnStart() {
        return btnStart;
    }

    public Button getBtnQuit() {
        return btnQuit;
    }
}
