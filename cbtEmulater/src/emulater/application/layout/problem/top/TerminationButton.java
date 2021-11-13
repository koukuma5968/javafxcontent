package emulater.application.layout.problem.top;

import emulater.application.names.problem.TerminationItem;
import emulater.event.problem.term.TerminationEventHandler;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class TerminationButton extends HBox {

    public TerminationButton() {
        super();
        super.getStyleClass().add(TerminationItem.VIEW.getStyleName());
    }

    public void setButton() {

        ImageView image = new ImageView();
        image.getStyleClass().add(TerminationItem.IMAGE.getStyleName());
        super.getChildren().add(image);

        Label start = new Label();
        start.setText("試験終了");
        start.getStyleClass().add(TerminationItem.LABEL.getStyleName());
        super.getChildren().add(start);

        for (TerminationEventHandler handler : TerminationEventHandler.values()) {
            super.addEventHandler(handler.getEventType(), handler.getEvent());
        }
    }
}
