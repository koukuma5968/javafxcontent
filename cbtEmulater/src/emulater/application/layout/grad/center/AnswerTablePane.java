package emulater.application.layout.grad.center;

import emulater.application.bean.CheckAnswerBean;
import emulater.application.names.grad.CheckAnswerNames;
import emulater.event.EventListener;
import emulater.event.review.CheckAnswerReviewEventHandler;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

public class AnswerTablePane extends BorderPane {

    public void setTableView(ObservableList<CheckAnswerBean> beanList) {

        Label l = new Label();
        l.setText("結果詳細（ダブルクリックで問題の詳細を確認できます。）");
        super.setTop(l);

        TableView<CheckAnswerBean> anstable = new TableView<CheckAnswerBean>();
        anstable.getStyleClass().add(CheckAnswerNames.CHECK_TABLE.getStyleName());

        anstable.getColumns().add(getTableColumn("番号", "number"));
        anstable.getColumns().add(getTableColumn("正答", "solution"));
        anstable.getColumns().add(getTableColumn("選択した解答", "userSel"));
        anstable.getColumns().add(getTableColumn("正誤", "correction"));

        anstable.setItems(beanList);

        for (EventListener handler : CheckAnswerReviewEventHandler.values()) {
            anstable.addEventHandler(handler.getEventType(), handler.getEvent());
        }

        super.setCenter(anstable);
    }

    private TableColumn<CheckAnswerBean, ?> getTableColumn(String title, String property) {

        TableColumn<CheckAnswerBean, String> col = new TableColumn<CheckAnswerBean, String>(title);
        col.setCellValueFactory(new PropertyValueFactory<>(property));
        col.setResizable(false);
        col.setPrefWidth(150);

        return col;
    }

}
