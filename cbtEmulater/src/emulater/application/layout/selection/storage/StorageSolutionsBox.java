package emulater.application.layout.selection.storage;

import emulater.application.bean.CheckAnswerBean;
import emulater.application.names.storage.StoragePaneNames;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class StorageSolutionsBox extends VBox {

    public StorageSolutionsBox() {
        super();
        super.getStyleClass().add(StoragePaneNames.NUM_BOX.getStyleName());
    }

    public void setNumBox(ObservableList<CheckAnswerBean> beanList) {

        int anscount = beanList.filtered(bean -> "〇".equals(bean.getCorrection())).size();

        setLabel("正答数", StoragePaneNames.TEXT_LABEL);

        setLabel(anscount + " / " + beanList.size() + " 問", StoragePaneNames.NUM_LABEL);

        setLabel("正答率", StoragePaneNames.TEXT_LABEL);

        setLabel((anscount * 100 / beanList.size()) + " %", StoragePaneNames.NUM_LABEL);

    }

    private void setLabel(String text, StoragePaneNames names) {

        Label label = new Label();
        label.getStyleClass().add(names.getStyleName());
        label.setText(text);

        AnchorPane anc = new AnchorPane();
        AnchorPane.setLeftAnchor(label, 10d);
        AnchorPane.setRightAnchor(label, 10d);
        anc.getChildren().add(label);

        super.getChildren().add(anc);

    }
}
