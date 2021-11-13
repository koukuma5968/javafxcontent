package emulater.event.problem.question;

import emulater.application.layout.problem.ProblemView;
import emulater.application.layout.problem.bottom.GradingButton;
import emulater.application.layout.problem.top.ProblemMenu;
import emulater.application.layout.problem.top.TimerPane;
import emulater.event.EventActionService;
import javafx.animation.Timeline;
import javafx.application.Platform;

public class GradingEventAction extends EventActionService {

    @Override
    protected void doEvent() {

        ProblemView view = (ProblemView) ((GradingButton) super.getEvent().getSource()).getScene().getRoot();
        TimerPane timerpane = (TimerPane) ((ProblemMenu) view.getTop()).getChildren().get(1);

        Platform.runLater(()-> {
            Timeline timeline = timerpane.getTimeline();
            timeline.stop();
            view.setGrading();
        });


    }
}
