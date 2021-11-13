package emulater.application.layout.grad.center;

import emulater.application.layout.grad.top.ReviewCloseButton;
import emulater.application.layout.problem.center.QuestionPane;
import emulater.application.layout.problem.center.SolutionSelectBox;
import emulater.application.names.grad.ReviewPaneNames;
import emulater.event.EventListener;
import emulater.event.stage.TopMenuEventHandler;
import emulater.util.EmulaterLogger;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class ReviewPane extends BorderPane {

    private final String cName = ReviewPane.class.getSimpleName();

    public ReviewPane() {
        super();
        EmulaterLogger.info(cName, "試験結果詳細初期化");
    }

    public void setReview(QuestionPane que) {

        EmulaterLogger.info(cName, "試験結果詳細セット");
        ReviewCloseButton close = new ReviewCloseButton();
        close.setButton();

        AnchorPane anc = new AnchorPane();
        AnchorPane.setRightAnchor(close, 10d);
        AnchorPane.setTopAnchor(close, 10d);
        AnchorPane.setBottomAnchor(close, 10d);
        anc.getChildren().add(close);

        for (EventListener handler : TopMenuEventHandler.values()) {
            anc.addEventHandler(handler.getEventType(), handler.getEvent());
        }

        super.setTop(anc);

        ((SolutionSelectBox) que.getBottom()).getChildren().forEach(check -> {
            ((CheckBox) check).setDisable(true);
        });

        super.setCenter(que);

        HBox solBox = new HBox();
        solBox.getStyleClass().add(ReviewPaneNames.SOL_BOX.getStyleName());
        solBox.getChildren().add(new Label("正答"));
        solBox.getChildren().addAll(que.getSolurions());

        super.setBottom(solBox);
    }
}
