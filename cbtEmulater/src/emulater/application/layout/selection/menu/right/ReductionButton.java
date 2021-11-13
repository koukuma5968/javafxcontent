package emulater.application.layout.selection.menu.right;

import emulater.application.names.chapter.TopMenuItemNames;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ReductionButton extends Button {

    public ReductionButton() {
        super();
        super.getStyleClass().add(TopMenuItemNames.REDUCT.getStyleName());
        init();
    }

    private void init() {

        super.setText("―");

        super.setOnMouseClicked(event -> {

            Stage stage = (Stage) ((ReductionButton) event.getSource()).getScene().getWindow();
            if (stage.isIconified()) {
                stage.setIconified(false);
            } else {
                stage.setIconified(true);
            }
        });
    }
}
