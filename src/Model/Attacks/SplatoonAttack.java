package Model.Attacks;

import Tools.Path;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.stage.Screen;
import javafx.util.Duration;

public class SplatoonAttack {
    private ImageView nmlAtk, hlAtk, ktcAtk;
    private Timeline softAtk, count;
    private Group grpAtk, root;
    private double speedAtk;
    private boolean sensAtk;

    public SplatoonAttack(Group root){
        this.root = root;
        grpAtk = new Group();

        // normal attaque
        nmlAtk = new ImageView(Path.normalAtkSplat);
        if(Math.random() < 0.5){
            sensAtk = true;
        }else{
            sensAtk = false;
            nmlAtk.setRotationAxis(new Point3D(0,1,0));
        }
        speedAtk = (Math.random() * 10000 ) + 5000;
        double startRandom = -10 * Math.random() * 250;
        grpAtk.setLayoutX(startRandom);
        int hauteurRandom = 265 + (int)(Math.random()*(206));
        grpAtk.setLayoutY(hauteurRandom);
        grpAtk.getChildren().add(nmlAtk);
        startCount();
        initSoftAtk();

        // healing attaque
        hlAtk = new ImageView(Path.healAtkSplat);

        // joke attaque (aucun effet, fait juste peur)
        ktcAtk = new ImageView(Path.ketchupAtkSplat);
    }

    private void initSoftAtk(){
        softAtk = new Timeline();

        if (sensAtk){
            softAtk.getKeyFrames().addAll(
                    new KeyFrame(Duration.ZERO,new KeyValue(grpAtk.layoutXProperty(),-200)),
                    new KeyFrame(new Duration(speedAtk), new KeyValue(grpAtk.layoutXProperty(), Screen.getPrimary().getBounds().getWidth())));
        }else{
            softAtk.getKeyFrames().addAll(
                    new KeyFrame(Duration.ZERO,new KeyValue(grpAtk.layoutXProperty(),Screen.getPrimary().getBounds().getWidth())),
                    new KeyFrame(new Duration(speedAtk), new KeyValue(grpAtk.layoutXProperty(),-200 )));
        }
        softAtk.setCycleCount(Animation.INDEFINITE);
    }

    private void startCount(){
        count = new Timeline(
                new KeyFrame(Duration.seconds(15))
        );

        count.setOnFinished(event -> softAtk.play());
    }

    public void startFirstPhase(){
        root.getChildren().add(grpAtk);
        count.play();
    }

    public void stopFirstPhase(){
        root.getChildren().remove(grpAtk);
        softAtk.stop();
    }

    public Group getGrpAtk() {
        return grpAtk;
    }
}
