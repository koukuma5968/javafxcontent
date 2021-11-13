package emulater.application.layout.problem.bottom;

import emulater.application.names.problem.QuestionItem;
import emulater.event.EventListener;
import emulater.event.problem.question.QuestionStartEventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class StartLabelBox extends VBox {

    public StartLabelBox() {
        super();
        super.getStyleClass().add(QuestionItem.START_BOX.getStyleName());
    }

    public void setRunBox() {

        Text startlabel = new Text();
        startlabel.setText("「開始」を押して試験を開始してください。");
        startlabel.getStyleClass().add(QuestionItem.START_TEXT.getStyleName());

        super.getChildren().add(startlabel);
        super.setMargin(startlabel, new Insets(10, 0, 10, 0));

        HBox box = new HBox();
        box.getStyleClass().add(QuestionItem.RUN_BOX.getStyleName());

        for (EventListener handler : QuestionStartEventHandler.values()) {
            box.addEventHandler(handler.getEventType(), handler.getEvent());
        }

        ImageView image = new ImageView();
        image.getStyleClass().add(QuestionItem.IMAGE.getStyleName());
        box.getChildren().add(image);

        Label start = new Label();
        start.setText("開始");
        start.getStyleClass().add(QuestionItem.RUN_BUTTON.getStyleName());
        box.getChildren().add(start);

        super.getChildren().add(box);

    }
}
