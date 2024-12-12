package config;

import javafx.animation.Animation;
import javafx.animation.RotateTransition;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;

import javafx.util.Duration;
import lombok.Getter;

@Getter
public class Camera {
    private PerspectiveCamera camera;
    private Rotate rotateY;
    private Translate translate;

    public Camera() {
        this.camera = new PerspectiveCamera();
        this.rotateY = new Rotate(0, Rotate.Y_AXIS);
        this.translate = new Translate(-400, -400, 100);
        this.camera.getTransforms().addAll(translate);
    }
    public void rotate(Group group) {
        RotateTransition rotate = new RotateTransition(Duration.seconds(80), group);
        rotate.setAxis(Rotate.Y_AXIS);
        rotate.setByAngle(360);
        rotate.setCycleCount(Animation.INDEFINITE);
        rotate.play();
    }
}
