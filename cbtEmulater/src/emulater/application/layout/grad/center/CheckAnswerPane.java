package emulater.application.layout.grad.center;

import emulater.application.bean.CheckAnswerBean;
import emulater.application.names.grad.CheckAnswerNames;
import javafx.collections.ObservableList;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class CheckAnswerPane extends HBox {

    public CheckAnswerPane() {
        super();
        super.getStyleClass().add(CheckAnswerNames.VIEW.getStyleName());
    }

    public void setAnswer(ObservableList<CheckAnswerBean> beanList) {

        SolutionsNumBox numBox = new SolutionsNumBox();
        numBox.setNumBox(beanList);

        HBox.setHgrow(numBox, Priority.ALWAYS);
        super.getChildren().add(numBox);

        AnswerTablePane anstable = new AnswerTablePane();
        anstable.setTableView(beanList);

        super.getChildren().add(anstable);

    }

}
