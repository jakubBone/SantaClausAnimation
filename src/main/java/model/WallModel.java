package model;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class WallModel extends Rectangle {
    public WallModel() {
        Image runwayImage = new Image(getClass().getResource("/image/Santa.png").toExternalForm());
        ImagePattern runwayPattern = new ImagePattern(runwayImage);
        this.setWidth(1600/ 2.0);
        this.setHeight(1200 / 2.0);
        this.setFill(runwayPattern);
        this.setTranslateX(-400);
        this.setTranslateY(-400);
        this.setTranslateZ(100);
    }
}
