package emulater.event.problem.term;

import emulater.application.EmulateStage;
import emulater.application.layout.problem.ProblemView;
import emulater.application.layout.problem.top.ProblemMenu;
import emulater.application.layout.problem.top.TerminationButton;
import emulater.application.layout.problem.top.TimerPane;
import emulater.event.EventActionService;
import javafx.animation.Timeline;
import javafx.application.Platform;

public class TerminationEventAction extends EventActionService {

    @Override
    protected void doEvent() {

        TerminationButton term = (TerminationButton) super.getEvent().getSource();
        ProblemView view = (ProblemView) term.getScene().getRoot();
        TimerPane timerpane = (TimerPane) ((ProblemMenu) view.getTop()).getChildren().get(1);

        Platform.runLater(()-> {
            Timeline timeline = timerpane.getTimeline();
            timeline.stop();
            EmulateStage preStage = new EmulateStage();
            preStage.reStart(term);
        });

    }

}
