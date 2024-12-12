package model;

import javafx.scene.paint.Color;

import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;

import lombok.Getter;

@Getter
public class SnowModel extends Sphere {
    public SnowModel() {
        this.setRadius(1);
        this.getMaterial();
        this.setMaterial(new PhongMaterial(Color.WHITE));
    }
}
