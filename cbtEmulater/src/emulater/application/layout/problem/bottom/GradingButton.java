package emulater.application.layout.problem.bottom;

import emulater.application.names.problem.GradingButtonNames;
import emulater.event.EventListener;
import emulater.event.problem.question.GradingEventHandler;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class GradingButton extends HBox {

    public GradingButton() {
        super();
        super.getStyleClass().add(GradingButtonNames.GRAD_BOX.getStyleName());
    }

    public void setButton(String labelText) {

        ImageView image = new ImageView();
        image.getStyleClass().add(GradingButtonNames.GRAD_IMAGE.getStyleName());
        super.getChildren().add(image);

        Label label = new Label();
        label.setText(labelText);
        label.getStyleClass().add(GradingButtonNames.GRAD_LABEL.getStyleName());
        super.getChildren().add(label);

        for (EventListener handler : GradingEventHandler.values()) {
            super.addEventHandler(handler.getEventType(), handler.getEvent());
        }

    }

}
