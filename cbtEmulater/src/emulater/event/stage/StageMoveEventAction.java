package emulater.event.stage;

import emulater.event.EventActionService;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class StageMoveEventAction extends EventActionService {

    private static double dragX = 0;
    private static double dragY = 0;

    @Override
    protected void doEvent() {

        MouseEvent event = (MouseEvent) super.getEvent();

        Stage stage = (Stage) ((Pane) event.getSource()).getScene().getWindow();

        if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {

            dragX = stage.getX() - event.getScreenX();
            dragY = stage.getY() - event.getScreenY();

        } else if (event.getEventType() == MouseEvent.MOUSE_DRAGGED) {

            if (event.isPrimaryButtonDown()) {
                stage.setX(event.getScreenX() + dragX);
                stage.setY(event.getScreenY() + dragY);
            }

        }

    }

}
