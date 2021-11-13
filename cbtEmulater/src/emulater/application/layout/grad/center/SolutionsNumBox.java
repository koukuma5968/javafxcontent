package emulater.application.layout.grad.center;

import emulater.application.bean.CheckAnswerBean;
import emulater.application.layout.grad.bottom.ResultStoragePane;
import emulater.application.names.grad.CheckAnswerNames;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class SolutionsNumBox extends VBox {

    public SolutionsNumBox() {
        super();
        super.getStyleClass().add(CheckAnswerNames.NUM_BOX.getStyleName());
    }

    public void setNumBox(ObservableList<CheckAnswerBean> beanList) {

        int anscount = beanList.filtered(bean -> "〇".equals(bean.getCorrection())).size();

        setLabel("正答数", CheckAnswerNames.TEXT_LABEL);

        setLabel(anscount + " / " + beanList.size() + " 問", CheckAnswerNames.NUM_LABEL);

        setLabel("正答率", CheckAnswerNames.TEXT_LABEL);

        setLabel((anscount * 100 / beanList.size()) + " %", CheckAnswerNames.NUM_LABEL);

        ResultStoragePane storage = new ResultStoragePane();
        storage.setStrageButton();

        AnchorPane anc = new AnchorPane();
        AnchorPane.setLeftAnchor(storage, 250d);
        AnchorPane.setRightAnchor(storage, 250d);
        anc.getChildren().add(storage);

        super.getChildren().add(anc);
    }

    private void setLabel(String text, CheckAnswerNames names) {

        Label label = new Label();
        label.getStyleClass().add(names.getStyleName());
        label.setText(text);

        AnchorPane anc = new AnchorPane();
        AnchorPane.setLeftAnchor(label, 150d);
        AnchorPane.setRightAnchor(label, 150d);
        anc.getChildren().add(label);

        super.getChildren().add(anc);

    }
}
