package emulater.application.layout.problem.top;

import emulater.application.layout.selection.chapter.center.exam.ExecutionBox;
import emulater.application.names.problem.ProblemItem;
import emulater.event.EventListener;
import emulater.event.stage.TopMenuEventHandler;
import javafx.scene.layout.AnchorPane;

public class ProblemMenu extends AnchorPane {

    public ProblemMenu() {
        super();
        super.getStyleClass().add(ProblemItem.MENU_VIEW.getStyleName());
    }

    public void setMenu(ExecutionBox exe) {

        CertificationName certName = new CertificationName();
        certName.setCertName(exe.getName());

        super.setLeftAnchor(certName, 0d);
        super.setTopAnchor(certName, 0d);
        super.setBottomAnchor(certName, 0d);
        super.getChildren().add(certName);

        TimerPane timer = new TimerPane();
        timer.setCounter(exe.getTime());

        super.setRightAnchor(timer, 200d);
        super.setTopAnchor(timer, 0d);
        super.setBottomAnchor(timer, 0d);
        super.getChildren().add(timer);

        TerminationButton termination = new TerminationButton();
        termination.setButton();

        super.setRightAnchor(termination, 0d);
        super.setTopAnchor(termination, 10d);
        super.setBottomAnchor(termination, 10d);
        super.getChildren().add(termination);

        for (EventListener handler : TopMenuEventHandler.values()) {
            super.addEventHandler(handler.getEventType(), handler.getEvent());
        }
    }

}
