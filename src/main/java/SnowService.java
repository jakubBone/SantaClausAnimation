import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.util.Duration;
import model.SantaModel;
import model.SnowModel;
import model.WallModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SnowService {
    private Group staticGroup;
    private Group dynamicGroup;
    private SantaModel santaModel;
    private WallModel wallModel;

    public SnowService(Group staticGroup, Group dynamicGroup) {
        this.staticGroup = staticGroup;
        this.dynamicGroup = dynamicGroup;
    }

    public void initializeScene() {
        addBackgroundWall();
        addSanta();
        startAnimation();
    }

    private void startAnimation() {
        List<SnowModel> snowflakes = createSnowflakes();
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(50), event -> updateSnow(snowflakes)));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(1000), event -> updateSantaMovement()));
        timeline1.setCycleCount(Timeline.INDEFINITE);
        timeline1.play();
    }

    private void updateSnow(List<SnowModel> snowflakes) {
        Random random = new Random();
        for (SnowModel snowflake : snowflakes) {
            snowflake.setTranslateY(snowflake.getTranslateY() + 5); // Falling
            if (snowflake.getTranslateY() > 300) { // Reset at bottom
                resetSnowflakesPosition(snowflake, random);
            }
        }
        createSnowLayer();
    }

    private void updateSantaMovement() {
        santaModel.animateMovement();
    }

    private List<SnowModel> createSnowflakes() {
        List<SnowModel> snowflakes = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            SnowModel snowflake = new SnowModel();
            spawnSnowflakes(snowflake);
            dynamicGroup.getChildren().add(snowflake);
            snowflakes.add(snowflake);
        }
        return snowflakes;
    }

    private void spawnSnowflakes(SnowModel snowModel){
        Random random = new Random();
        snowModel.setTranslateX(random.nextDouble() *  800 - 800 / 2.0);
        snowModel.setTranslateY(random.nextDouble() * - 600);
        snowModel.setTranslateZ(random.nextDouble() * 600 - 600 / 2.0);
    }

    private void createSnowLayer() {
        Random random = new Random();
        for (int i = 0; i < 2; i++) {
            SnowModel snowflake = new SnowModel();
            snowflake.setTranslateX(500 - random.nextDouble() * 1200); // Random X
            snowflake.setTranslateY(100 + random.nextDouble() * 150); // Random Y
            staticGroup.getChildren().add(snowflake);
            Timeline twinkle = new Timeline(
                    new KeyFrame(Duration.seconds(30)),
                    new KeyFrame(Duration.seconds(30)),
                    new KeyFrame(Duration.seconds(30)));

            twinkle.setCycleCount(Timeline.INDEFINITE);
            twinkle.play();
        }
    }

    private void resetSnowflakesPosition(SnowModel snowflake, Random random) {
        snowflake.setTranslateY(-300);
        snowflake.setTranslateX(random.nextDouble() * 800 - 400);
        snowflake.setTranslateZ(random.nextDouble() * 600 - 300);
    }
    private void addBackgroundWall() {
        this.wallModel = new WallModel();
        staticGroup.getChildren().add(wallModel);
    }

    private void addSanta() {
        this.santaModel = new SantaModel();
        staticGroup.getChildren().add(santaModel);
    }

    public Group getDynamicGroup() {
        return dynamicGroup;
    }
}
