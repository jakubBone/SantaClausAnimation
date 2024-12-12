
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import config.Camera;
import config.ChristmasSong;
public class Animation extends Application {
    private Scene scene;
    private Camera camera;
    private SnowService snowService;

    public Animation() {
        Group staticGroup = new Group();
        Group dynamicGroup = new Group();
        Group rootGroup = new Group(staticGroup, dynamicGroup);
        this.scene = new Scene(rootGroup, 800, 600, Color.BLACK);
        this.camera = new Camera();
        this.snowService = new SnowService(staticGroup, dynamicGroup);
    }

    @Override
    public void start(Stage primaryStage) {
        new ChristmasSong().start();

        setupScene();
        snowService.initializeScene();

        primaryStage.setTitle("Snow is falling.. Merry Christmas everyone!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void setupScene() {
        scene.setCamera(camera.getCamera());
        scene.setFill(Color.BLACK);
        camera.rotate(snowService.getDynamicGroup());
    }

    public static void main(String[] args) {
        launch(args);
    }
}