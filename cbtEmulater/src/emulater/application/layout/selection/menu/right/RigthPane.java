package emulater.application.layout.selection.menu.right;

import javafx.scene.layout.HBox;

public class RigthPane extends HBox {

    public RigthPane() {
        super();
        init();
    }

    private void init() {
        super.getChildren().add(new ReductionButton());
        super.getChildren().add(new ExpansionButton());
        super.getChildren().add(new CloseButton());
    }
}
