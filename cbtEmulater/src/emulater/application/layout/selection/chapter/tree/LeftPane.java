package emulater.application.layout.selection.chapter.tree;

import emulater.application.layout.selection.chapter.tree.item.QualificationList;
import emulater.application.layout.selection.chapter.tree.menu.SubMenuBox;
import emulater.util.EmulaterLogger;
import javafx.scene.layout.BorderPane;

public class LeftPane extends BorderPane {

    private final String cName = LeftPane.class.getSimpleName();

    public LeftPane() {
        super();
        EmulaterLogger.info(cName, "選択メニュー初期化");
        setSubMenuItem();
        setQualification();
    }

    private void setSubMenuItem() {

        SubMenuBox sub = new SubMenuBox();
        super.setLeft(sub);

    }

    private void setQualification() {

        QualificationList tree = new QualificationList();

        super.setCenter(tree);

    }
}
