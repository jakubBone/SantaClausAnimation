package model;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class SantaModel extends Rectangle {
    public SantaModel() {
        javafx.scene.image.Image runwayImage = new Image(getClass().getResource("/image/santaImage1.png").toExternalForm());
        ImagePattern runwayPattern = new ImagePattern(runwayImage);
        this.setWidth(400 / 2);
        this.setHeight(600 / 2);
        this.setFill(runwayPattern);
        this.setTranslateX(900);
        this.setTranslateY(-200);
        this.setTranslateZ(100);
    }

    public void animateMovement() {
        for(ModelLocation nextLocation: getSantaWay()){
            double toX = nextLocation.getX();
            double toY = getTranslateY();
            double toZ = nextLocation.getZ();
            setInterpolation(this, toX, toY, toZ);
        }
    }

    public void setInterpolation(Node node, double toX, double toY, double toZ) {
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(5));
        transition.setNode(node);
        transition.setToX(toX);
        transition.setToY(toY);
        transition.setToZ(toZ);

        transition.setInterpolator(Interpolator.LINEAR);
        transition.play();
    }

    public List<ModelLocation> getSantaWay(){
        List<ModelLocation> santaWaypoint = new ArrayList<>();
        int step = 10;
        for (int x = 900; x >= 265; x -= step) {
            santaWaypoint.add(new ModelLocation(x, -200, 100));
        }
        return santaWaypoint;
    }
}
