package emulater.event.exam.exe;

import emulater.application.EmulateStage;
import emulater.application.layout.selection.chapter.center.exam.ExecutionBox;
import emulater.event.EventActionService;
import javafx.application.Platform;

public class ExecutionEventAction extends EventActionService {

    @Override
    protected void doEvent() {

        ExecutionBox exe = (ExecutionBox) super.getEvent().getSource();

        Platform.runLater(()-> {
            EmulateStage preStage = new EmulateStage();
            preStage.problemStart(exe);
        });

    }

}
