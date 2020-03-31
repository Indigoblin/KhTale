package View;

import Controller.ControllerMenu;
import Tools.Path;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ViewMainMenu {
    private ViewHandler vMenu;
    private Button btnStart, btnQuit;
    private Group root;
    private VBox btnBox, titleBox;
    private Text screenText, screenTextBack;
    private Font fontScreenText, fontScreenTextBack;

    ViewMainMenu(ViewHandler vMenu, Group root){
        this.vMenu = vMenu;
        this.root = root;

        // initialisation des boutons
        btnStart = initButton(20, "Start");

        btnStart.setOnMouseEntered(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent hover) {
                btnStart.setTextFill(Color.YELLOW);
            }
        });

        btnStart.setOnMouseExited(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent exitHover) {
                btnStart.setTextFill(Color.WHITE);
            }
        });

        btnQuit = initButton(20,"Quit");
        btnQuit.setOnMouseEntered(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent hover) {
                btnQuit.setTextFill(Color.YELLOW);
            }
        });

        btnQuit.setOnMouseExited(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent exitHover) {
                btnQuit.setTextFill(Color.WHITE);
            }
        });

        initTitle();

        // initialisation des vbox
        titleBox = new VBox(screenText,screenTextBack);
        titleBox.setPadding(new Insets(150, 20, 15, 200));
        titleBox.setAlignment(Pos.CENTER);

        btnBox = new VBox(btnStart,btnQuit);
        btnBox.setPadding(new Insets(350, 20, 15, 425));
        btnBox.setSpacing(28);
        btnBox.setAlignment(Pos.CENTER);


        initView();
    }

    void initView(){
        root.getChildren().clear();
        root.getChildren().add(titleBox);
        root.getChildren().add(btnBox);
    }

    private Button initButton(int size, String BtnTxt) {
        Button b = new Button();
        b.setText(BtnTxt);
        b.setBackground(null);
        fontScreenText = Font.loadFont(getClass().getResourceAsStream(Path.fontDTMSans), 40);
        b.setFont(Font.font(size));
        b.setFont(fontScreenText);
        b.setTextFill(Color.WHITE);
        b.getStyleClass().add("btnMenu");
        return b;
    }

    private Text titleScreen(String screenTitle, int size){
        Text t = new Text();
        t.setText(screenTitle);
        t.setFont(Font.font(size));
        return t;
    }

    private void initTitle(){
        screenTextBack = new Text();
        screenTextBack = titleScreen("KingdomTale",40);
        fontScreenTextBack = Font.loadFont(getClass().getResourceAsStream(Path.monsterFriendBack), 60);
        screenTextBack.setFont(fontScreenTextBack);
        screenTextBack.setFill(Color.GRAY);
        screenText = new Text();
        screenText = titleScreen("KingdomTale",40);
        fontScreenText = Font.loadFont(getClass().getResourceAsStream(Path.monsterFriendFore), 60);
        screenText.setFont(fontScreenText);
        screenText.setFill(Color.WHITE);
    }

    public void setEvents(ControllerMenu cm) {
        btnStart.setOnMouseClicked(cm);
        btnQuit.setOnMouseClicked(cm);
    }

    public Button getBtnStart() {
        return btnStart;
    }

    public Button getBtnQuit() {
        return btnQuit;
    }
}
