package emulater.application.layout.selection.chapter.tree.menu;

import emulater.application.names.chapter.SubMenuBoxItemNames;
import emulater.application.names.chapter.SubMenuButtonItemNames;
import emulater.event.EventListener;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class SubMenuItem extends VBox {

    public SubMenuItem() {
        super.getStyleClass().add(SubMenuBoxItemNames.ITEM.getStyleName());
    }

    protected void setItem(SubMenuButtonItemNames item) {

        ImageView itemView = new ImageView();
        itemView.getStyleClass().add(item.getStyleName());

        Label itemLabel = new Label();
        itemLabel.setText(item.getText());
        itemLabel.getStyleClass().add(SubMenuBoxItemNames.ITEM_LABEL.getStyleName());

        super.getChildren().add(itemView);
        super.getChildren().add(itemLabel);

        for (EventListener event : item.getHandler()) {
            super.addEventHandler(event.getEventType(), event.getEvent());
        }
    }

}
