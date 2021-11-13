package emulater.event.problem.question;

import emulater.application.layout.problem.ProblemView;
import emulater.application.layout.problem.bottom.NextPreviousBox;
import emulater.application.layout.problem.bottom.NextPreviousButton;
import emulater.event.EventActionService;
import javafx.application.Platform;

public class QuestionNextPreEventAction extends EventActionService {

    @Override
    protected void doEvent() {

        NextPreviousButton npButton = (NextPreviousButton) super.getEvent().getSource();
        ProblemView view = (ProblemView) ((NextPreviousBox) npButton.getParent()).getParent();

        Platform.runLater(()-> {

            switch (npButton.getBoxStyle()) {

                case PRE_BOX :
                    view.setPrevious();
                    break;

                case NEXT_BOX :
                    view.setNext();
                    break;

                default:
                    break;
            }
        });

    }

}
