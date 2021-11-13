package emulater.event.review;

import emulater.application.EmulateStage;
import emulater.event.EventActionService;
import javafx.application.Platform;

public class CloseReviewEventAction extends EventActionService {

    @Override
    protected void doEvent() {

        Platform.runLater(()-> {
            EmulateStage.closeReview();
        });

    }

}
