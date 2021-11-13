package emulater.application.layout.selection.menu.right;

import emulater.application.names.chapter.TopMenuItemNames;
import javafx.application.Platform;
import javafx.scene.control.Button;

public class CloseButton extends Button {

    public CloseButton() {
        super();
        super.getStyleClass().add(TopMenuItemNames.CLOSE.getStyleName());
        init();
    }

    private void init() {

        super.setText("✕");

        super.setOnAction(e -> {
            Platform.exit();
            System.exit(0);
        });

    }
}
