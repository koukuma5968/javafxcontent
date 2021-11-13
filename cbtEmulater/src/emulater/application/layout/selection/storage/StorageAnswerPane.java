package emulater.application.layout.selection.storage;

import java.util.ArrayList;

import emulater.application.bean.CheckAnswerBean;
import emulater.application.bean.StorageAnswerBean;
import emulater.application.bean.StorageBean;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class StorageAnswerPane extends HBox {

    public StorageAnswerPane() {
        super();
    }

    public void setAnswer(StorageBean storage) {

        ObservableList<CheckAnswerBean> observalList = FXCollections.observableArrayList();

        ArrayList<StorageAnswerBean> beanList = storage.getAnsBeans();
        for (StorageAnswerBean stBean : beanList) {
            CheckAnswerBean checkBean = new CheckAnswerBean();
            checkBean.setCorrection(stBean.getCorrection());
            checkBean.setNumber(stBean.getNumber());
            checkBean.setSolution(stBean.getSolution());
            checkBean.setUserSel(stBean.getUserSel());
            checkBean.setQueBean(stBean.getQueBean());
            observalList.add(checkBean);
        }

        StorageSolutionsBox numBox = new StorageSolutionsBox();
        numBox.setNumBox(observalList);

        HBox.setHgrow(numBox, Priority.ALWAYS);
        super.getChildren().add(numBox);

        StorageTablePane anstable = new StorageTablePane();
        anstable.setTableView(observalList);

        HBox.setHgrow(anstable, Priority.ALWAYS);
        super.getChildren().add(anstable);

    }

}
