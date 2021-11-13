package emulater.application.layout.grad.bottom;

import emulater.application.names.grad.ReviewPaneNames;
import emulater.event.EventListener;
import emulater.event.storage.ResultStorageEventHandler;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class ResultStoragePane extends HBox {

    public ResultStoragePane() {
        super();
        super.getStyleClass().add(ReviewPaneNames.STRAGE_BOX.getStyleName());
    }

    public void setStrageButton() {

        ImageView image = new ImageView();
        image.getStyleClass().add(ReviewPaneNames.STRAGE_IMAGE.getStyleName());
        super.getChildren().add(image);

        Label start = new Label();
        start.setText("結果を保存");
        start.getStyleClass().add(ReviewPaneNames.STRAGE_LABEL.getStyleName());
        super.getChildren().add(start);

        for (EventListener handler : ResultStorageEventHandler.values()) {
            super.addEventHandler(handler.getEventType(), handler.getEvent());
        }
    }
}
