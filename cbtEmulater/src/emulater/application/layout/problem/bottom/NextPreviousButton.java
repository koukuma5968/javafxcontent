package emulater.application.layout.problem.bottom;

import emulater.application.names.problem.NextPreviousLabelBoxNames;
import emulater.event.EventListener;
import emulater.event.problem.question.QuestionNextPreEventHandler;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class NextPreviousButton extends HBox {

    private NextPreviousLabelBoxNames boxStyle;

    public NextPreviousButton(NextPreviousLabelBoxNames boxStyle) {
        super();
        super.getStyleClass().add(boxStyle.getStyleName());
        this.boxStyle = boxStyle;
    }

    public void setButton(NextPreviousLabelBoxNames imageStyle, NextPreviousLabelBoxNames labelStyle, String labelText) {

        ImageView image = new ImageView();
        image.getStyleClass().add(imageStyle.getStyleName());
        super.getChildren().add(image);

        Label label = new Label();
        label.setText(labelText);
        label.getStyleClass().add(labelStyle.getStyleName());
        super.getChildren().add(label);

        for (EventListener handler : QuestionNextPreEventHandler.values()) {
            super.addEventHandler(handler.getEventType(), handler.getEvent());
        }

    }

    public NextPreviousLabelBoxNames getBoxStyle() {
        return boxStyle;
    }
}
