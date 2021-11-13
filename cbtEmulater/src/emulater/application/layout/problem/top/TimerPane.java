package emulater.application.layout.problem.top;

import java.time.LocalTime;

import emulater.application.names.problem.TimerItem;
import emulater.util.Constant;
import emulater.xml.chapter.CertType;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class TimerPane extends HBox {

    private Timeline timeline = new Timeline();
    private LocalTime timer = null;
    private int cyclecount = 0;

    public int getCyclecount() {
        return cyclecount;
    }

    public void addCyclecount(int cyclecount) {
        this.cyclecount += cyclecount;
    }

    public LocalTime getTimer() {
        return timer;
    }

    public void setTimer(LocalTime timer) {
        this.timer = timer;
    }

    public Timeline getTimeline() {
        return timeline;
    }

    public TimerPane() {
        super.getStyleClass().add(TimerItem.TIMER.getStyleName());
    }

    public void setCounter(String timelimit) {

        super.getChildren().add(new Label(CertType.TIME.getTitle() + "："));

        Text timecount = new Text();
        timer = LocalTime.MIN.plusMinutes(Long.parseLong(timelimit));

        timecount.setText(timer.format(Constant.TIME_FORMAT));
        timeline.setCycleCount(Integer.parseInt(timelimit) * 60);

        super.getChildren().add(timecount);
    }

}
