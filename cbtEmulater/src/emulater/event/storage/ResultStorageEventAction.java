package emulater.event.storage;

import emulater.application.layout.grad.bottom.ResultStoragePane;
import emulater.application.layout.problem.ProblemView;
import emulater.event.EventActionService;
import emulater.util.FileUtil;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ResultStorageEventAction extends EventActionService {

    @Override
    protected void doEvent() {

        ProblemView view = (ProblemView) ((ResultStoragePane) super.getEvent().getSource()).getScene().getRoot();

        int ret = FileUtil.outputAnswerObject(view.getStorage());

        Platform.runLater(()-> {
            Alert info = new Alert(AlertType.INFORMATION);

            info.setHeaderText("確認");
            info.setTitle("保存");

            if (ret == 0) {
                info.setContentText("保存に失敗しました。");
            } else if (ret == 1) {
                info.setContentText("すでに保存済みです。");
            } else {
                info.setContentText("結果を保存しました。");
            }
            info.showAndWait();
        });
    }

}
