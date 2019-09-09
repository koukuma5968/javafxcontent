package stage.smple1;

import javafx.application.Application;
import javafx.stage.Stage;

public class StageSmple1 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle(this.getClass().getSimpleName());
        primaryStage.show();
    }

}
