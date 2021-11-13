package emulater.event.stage;

import emulater.application.layout.selection.menu.right.ExpansionButton;
import emulater.event.EventActionService;
import javafx.application.Platform;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class FullScreenEventAction extends EventActionService {

    @Override
    protected void doEvent() {

        if (super.getEvent().getSource() instanceof ExpansionButton) {
            Stage stage = (Stage) ((Region) super.getEvent().getSource()).getScene().getWindow();
            Platform.runLater(()-> stage.setFullScreen(stage.isFullScreen() ? false:true));
        }

    }

}
