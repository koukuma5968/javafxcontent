package emulater.application.layout.selection.storage;

import emulater.application.bean.StorageBean;
import emulater.application.names.storage.StoragePaneNames;
import emulater.util.EmulaterLogger;
import javafx.scene.layout.BorderPane;

public class ShowStoragePane extends BorderPane {

    private final String cName = ShowStoragePane.class.getSimpleName();

    public ShowStoragePane() {
        super();
        EmulaterLogger.info(cName, "試験結果履歴画面初期化");
        super.getStyleClass().add(StoragePaneNames.VIEW.getStyleName());
    }

    public void setStorage(StorageBean storage) {

        StorageAnswerPane answer = new StorageAnswerPane();
        answer.setAnswer(storage);

        super.setCenter(answer);

    }

}
