package model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ModelLocation {
    private int x;
    private int y;
    private int z;

    public ModelLocation(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
