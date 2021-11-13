package emulater.event.exam;

import emulater.application.layout.selection.SelectionView;
import emulater.application.layout.selection.chapter.tree.LeftPane;
import emulater.application.layout.selection.chapter.tree.item.QualificationList;
import emulater.application.layout.selection.chapter.tree.menu.SubMenuItem;
import emulater.event.EventActionService;
import javafx.application.Platform;

public class ExaminationEventAction extends EventActionService {

    @Override
    protected void doEvent() {

        LeftPane left = (LeftPane) ((SelectionView) ((SubMenuItem) super.getEvent().getSource()).getScene().getRoot()).getLeft();
        QualificationList qua = (QualificationList) left.getCenter();

        Platform.runLater(() -> qua.setCategory());

    }

}
