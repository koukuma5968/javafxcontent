package emulater.event.problem.question;

import java.time.LocalTime;

import emulater.application.layout.problem.ProblemView;
import emulater.application.layout.problem.bottom.StartLabelBox;
import emulater.application.layout.problem.top.ProblemMenu;
import emulater.application.layout.problem.top.TimerPane;
import emulater.event.EventActionService;
import emulater.util.Constant;
import emulater.util.EmulaterLogger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class QuestionStartEventAction extends EventActionService {

    @Override
    protected void doEvent() {

        StartLabelBox startbox = (StartLabelBox) ((HBox) super.getEvent().getSource()).getParent();
        ProblemView view = (ProblemView) startbox.getParent();
        TimerPane timerpane = (TimerPane) ((ProblemMenu) view.getTop()).getChildren().get(1);

        Platform.runLater(()-> {
            view.setNext();
            Timeline timeline = timerpane.getTimeline();
            timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1), (event -> {

                timerpane.addCyclecount(1);
                EmulaterLogger.info(QuestionStartEventAction.class.getSimpleName(), String.valueOf(timerpane.getCyclecount()));
                EmulaterLogger.info(QuestionStartEventAction.class.getSimpleName(), String.valueOf(timeline.getCycleCount()));

                Text text = (Text) timerpane.getChildren().get(1);
                LocalTime timer = timerpane.getTimer().minusSeconds(1l);
                if (timeline.getCycleCount() <= timerpane.getCyclecount()) {
                    timeline.stop();
                    view.setGrading();
                } else {
                    timerpane.setTimer(timer);
                    text.setText(timerpane.getTimer().format(Constant.TIME_FORMAT));
                }
            })));
            timeline.play();
        });

    }

}
