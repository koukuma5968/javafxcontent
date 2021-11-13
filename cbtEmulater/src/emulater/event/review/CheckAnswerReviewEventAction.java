package emulater.event.review;

import emulater.application.EmulateStage;
import emulater.application.bean.AnswerInterface;
import emulater.application.layout.problem.ProblemView;
import emulater.application.layout.problem.center.QuestionPane;
import emulater.application.names.problem.QuestionItem;
import emulater.event.EventActionService;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

public class CheckAnswerReviewEventAction extends EventActionService {

    @Override
    protected void doEvent() {

        if (super.getEvent() instanceof MouseEvent) {
            MouseEvent mouse = (MouseEvent)super.getEvent();
            if (mouse.getClickCount() != 2) {
                return;
            }
        }

        @SuppressWarnings("unchecked")
        TableView<AnswerInterface> table = (TableView<AnswerInterface>) super.getEvent().getSource();

        Parent par = table.getScene().getRoot();

        AnswerInterface ansbean = table.getSelectionModel().getSelectedItem();

        EmulateStage stage = new EmulateStage();

        if (EmulateStage.checkShowStage()) {
            Platform.runLater(()-> {

                QuestionPane que = null;
                if (par instanceof ProblemView) {
                    ProblemView view = (ProblemView) par;
                    que = view.getTargetQuestion(ansbean.getNumber());
                } else {
                    que = new QuestionPane(QuestionItem.VIEW_TITLE);
                    que.setStorageQuestion(ansbean);
                }
                stage.showReview(que);
            });
        }
    }

}
