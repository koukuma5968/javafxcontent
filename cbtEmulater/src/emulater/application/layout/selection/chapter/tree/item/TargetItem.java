package emulater.application.layout.selection.chapter.tree.item;

import java.time.format.DateTimeFormatter;

import emulater.application.bean.StorageBean;
import emulater.application.names.chapter.QualificationListNames;
import emulater.xml.tree.Target;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;

public class TargetItem extends TreeItem<Label> {

    private String Path;
    private boolean target;
    private StorageBean storage;

    public TargetItem() {
        super();
    }

    public void setTarget(Target target) {

        setPath(target.getPath());

        Label l = new Label();
        l.getStyleClass().add(QualificationListNames.TARGET_ITEM.getStyleName());
        l.setText(target.getName());
        super.setValue(l);
    }

    public String getPath() {
        return Path;
    }

    public void setPath(String path) {
        Path = path;
    }

    public void setStorageItem(StorageBean storage, DateTimeFormatter format, boolean target) {

        this.target = target;
        if(target) this.storage = storage;

        Label l = new Label();
        l.getStyleClass().add(QualificationListNames.TARGET_ITEM.getStyleName());
        l.setText(storage.getDay().format(format));
        super.setValue(l);

    }

    public boolean isTarget() {
        return target;
    }

    public StorageBean getStorage() {
        return storage;
    }

}
