package emulater.application.layout.selection.chapter.tree.item;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;

import emulater.application.bean.StorageBean;
import emulater.application.names.chapter.QualificationListNames;
import emulater.event.storage.ShowStorageEventHandler;
import emulater.event.tree.QualificationEventHandler;
import emulater.util.Constant;
import emulater.util.JAXBUtil;
import emulater.xml.tree.Qualification;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

public class QualificationList extends TreeView<Label> {

    public QualificationList() {
        super();
        super.getStyleClass().add(QualificationListNames.VIEW.getStyleName());
    }

    public void setCategory() {

        TreeItem<Label> root = new TreeItem<Label>();

        Qualification itemBean = (Qualification) JAXBUtil.getXmlObject(Qualification.class, JAXBUtil.QUALIFICATION);

        itemBean.getCategory().forEach(category -> {

            Label catel = new Label(category.getName());
            catel.getStyleClass().add(QualificationListNames.CERT.getStyleName());

            TreeItem<Label> cate = new TreeItem<Label>(catel);

            category.getTarget().forEach(target -> {

                TargetItem item = new TargetItem();
                item.setTarget(target);
                cate.getChildren().add(item);

            });

            root.getChildren().add(cate);

        });

        super.setRoot(root);
        super.setShowRoot(false);

        for (ShowStorageEventHandler handler : ShowStorageEventHandler.values()) {
            super.removeEventHandler(handler.getEventType(), handler.getEvent());
        }

        for (QualificationEventHandler handler : QualificationEventHandler.values()) {
            super.addEventHandler(handler.getEventType(), handler.getEvent());
        }

    }

    public void setStorage(ArrayList<StorageBean> storages) {

        TreeItem<Label> root = new TreeItem<Label>();

        Comparator<StorageBean> comparator = Comparator.comparing(StorageBean::getDay).reversed();
        storages.stream().sorted(comparator).forEach(storage -> {

            Optional<TreeItem<Label>> cateitem = root.getChildren().stream().filter(item -> {
                return item.getValue().getText().equals(storage.getName());
            }).findFirst();

            TreeItem<Label> cate = null;
            TargetItem day = null;

            if (cateitem.isEmpty()) {

                Label catel = new Label();
                catel.setText(storage.getName());
                catel.getStyleClass().add(QualificationListNames.CERT.getStyleName());
                cate = new TreeItem<Label>(catel);

                day = new TargetItem();
                day.setStorageItem(storage, Constant.DAY_FORMAT, false);

                cate.getChildren().add(day);

                root.getChildren().add(cate);
            } else {
                cate = cateitem.get();

                Optional<TreeItem<Label>> dayitem = cate.getChildren().stream().filter(item -> {
                    return item.getValue().getText().equals(storage.getDay().format(Constant.DAY_FORMAT));
                }).findFirst();

                if (dayitem.isEmpty()) {
                    day = new TargetItem();
                    day.setStorageItem(storage, Constant.DAY_FORMAT, false);

                    cate.getChildren().add(day);
                } else {
                    day = (TargetItem) dayitem.get();
                }
            }
            TargetItem time = new TargetItem();
            time.setStorageItem(storage, Constant.TIME_FORMAT, true);
            day.getChildren().add(time);

        });

        super.setRoot(root);
        super.setShowRoot(false);

        for (QualificationEventHandler handler : QualificationEventHandler.values()) {
            super.removeEventHandler(handler.getEventType(), handler.getEvent());
        }

        for (ShowStorageEventHandler handler : ShowStorageEventHandler.values()) {
            super.addEventHandler(handler.getEventType(), handler.getEvent());
        }

    }

}
