package emulater.application;

import emulater.application.layout.grad.center.ReviewPane;
import emulater.application.layout.problem.ProblemView;
import emulater.application.layout.problem.center.QuestionPane;
import emulater.application.layout.problem.top.TerminationButton;
import emulater.application.layout.selection.SelectionView;
import emulater.application.layout.selection.chapter.center.exam.ExecutionBox;
import emulater.util.EmulaterLogger;
import emulater.util.StyleUtil;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class EmulateStage extends Application {

    private final String cName = EmulateStage.class.getSimpleName();

    public EmulateStage() {
        super();
    }

    private static Stage gradingStage = null;

    @SuppressWarnings("exports")
    @Override
    public void start(Stage stage) throws Exception {

        EmulaterLogger.info(cName, "アプリケーション開始");
        SelectionView pane = new SelectionView();

        Scene scene = new Scene(pane);
        ObservableList<String> style = scene.getStylesheets();
        style.clear();

        StyleUtil.setStylesheetFiles(scene);

        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.getIcons().add(StyleUtil.getSystemIcon());
//        stage.setMinWidth(500);
//        stage.setWidth(950);
//        stage.setMinHeight(300);
//        stage.setHeight(600);
        stage.setFullScreen(true);
        stage.setFullScreenExitHint("");
        stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);

        stage.show();
    }

    @SuppressWarnings("exports")
    public void problemStart(ExecutionBox exe) {

        EmulaterLogger.info(cName, "試験問題開始");
        ProblemView pane = new ProblemView();
        pane.setLayout(exe);

        Scene scene = exe.getScene();
        scene.setRoot(pane);

        Stage stage = (Stage) scene.getWindow();
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.setFullScreenExitHint("");
        stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        stage.show();

    }

    @SuppressWarnings("exports")
    public void reStart(TerminationButton term) {

        SelectionView pane = new SelectionView();

        Scene scene = term.getScene();
        scene.setRoot(pane);
        Stage stage = (Stage) scene.getWindow();
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();

    }

    @SuppressWarnings("exports")
    public void showReview(QuestionPane que) {

        EmulaterLogger.info(cName, "試験結果開始");
        ReviewPane review = new ReviewPane();
        review.setReview(que);

        Scene scene = new Scene(review);
        ObservableList<String> style = scene.getStylesheets();
        style.clear();

        StyleUtil.setStylesheetFiles(scene);

        gradingStage = new Stage();
        gradingStage.setScene(scene);
        gradingStage.initStyle(StageStyle.UNDECORATED);
        gradingStage.getIcons().add(StyleUtil.getSystemIcon());
//        gradingStage.setFullScreen(true);
        gradingStage.setWidth(950);
        gradingStage.setHeight(600);
        gradingStage.setFullScreenExitHint("");
        gradingStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);

        gradingStage.show();

    }

    public static boolean checkShowStage() {
        return gradingStage == null;
    }

    public static void closeReview() {
        gradingStage.close();
        gradingStage = null;
    }
}
