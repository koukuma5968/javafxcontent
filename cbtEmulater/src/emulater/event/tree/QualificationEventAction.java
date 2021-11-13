package emulater.event.tree;

import emulater.application.layout.selection.SelectionView;
import emulater.application.layout.selection.chapter.tree.item.QualificationList;
import emulater.application.layout.selection.chapter.tree.item.TargetItem;
import emulater.event.EventActionService;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;

public class QualificationEventAction extends EventActionService {

    @Override
    protected void doEvent() {

        TreeItem<Label> item = ((QualificationList) super.getEvent().getSource()).getSelectionModel().getSelectedItem();

        if (item instanceof TargetItem) {
            Platform.runLater(() -> {
                Scene scene = ((QualificationList) super.getEvent().getSource()).getScene();
                SelectionView parent = (SelectionView) scene.getRoot();
                parent.setItemView(((TargetItem) item).getPath());
            });
        }
    }

}
