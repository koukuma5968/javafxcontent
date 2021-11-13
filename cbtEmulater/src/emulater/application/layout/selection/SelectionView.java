package emulater.application.layout.selection;

import emulater.application.bean.StorageBean;
import emulater.application.layout.selection.chapter.center.CenterPane;
import emulater.application.layout.selection.chapter.tree.LeftPane;
import emulater.application.layout.selection.menu.TopMenuPane;
import emulater.application.layout.selection.storage.ShowStoragePane;
import emulater.application.names.chapter.SelectionViewNames;
import emulater.util.EmulaterLogger;
import javafx.scene.layout.BorderPane;

public class SelectionView extends BorderPane {

    private final String cName = SelectionView.class.getSimpleName();

    public SelectionView() {
        super();
        EmulaterLogger.info(cName, "選択画面初期化");
        super.getStyleClass().add(SelectionViewNames.VIEW.getStyleName());
        init();
    }

    private void init() {
        setMenu();
        setLeft();
        setCenter();
    }

    private void setMenu() {
        super.setTop(new TopMenuPane());
    }

    private void setLeft() {

        super.setLeft(new LeftPane());
    }

    private void setCenter() {
        super.setCenter(new CenterPane());
    }

    public void setItemView(String Path) {
        CenterPane center = new CenterPane();
        center.setChapter(Path);
        super.setCenter(center);
    }

    public void setStrageItem(StorageBean storage) {

        ShowStoragePane pane = new ShowStoragePane();
        pane.setStorage(storage);

        super.setCenter(pane);
    }

}
