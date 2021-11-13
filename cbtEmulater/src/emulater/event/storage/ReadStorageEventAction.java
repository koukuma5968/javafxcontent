package emulater.event.storage;

import java.util.ArrayList;

import emulater.application.bean.StorageBean;
import emulater.application.layout.selection.SelectionView;
import emulater.application.layout.selection.chapter.tree.LeftPane;
import emulater.application.layout.selection.chapter.tree.item.QualificationList;
import emulater.application.layout.selection.chapter.tree.menu.SubMenuItem;
import emulater.event.EventActionService;
import emulater.util.FileUtil;
import javafx.application.Platform;

public class ReadStorageEventAction extends EventActionService {

    @Override
    protected void doEvent() {
        LeftPane left = (LeftPane) ((SelectionView) ((SubMenuItem) getEvent().getSource()).getScene().getRoot()).getLeft();
        QualificationList qua = (QualificationList) left.getCenter();

        ArrayList<StorageBean> storages = FileUtil.inputAnswerObject();

        Platform.runLater(() -> qua.setStorage(storages));
    }

}
