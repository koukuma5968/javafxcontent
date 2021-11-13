package emulater.application.layout.selection.chapter.tree.menu;

import emulater.application.names.chapter.SubMenuBoxItemNames;
import emulater.application.names.chapter.SubMenuButtonItemNames;
import javafx.geometry.Orientation;
import javafx.scene.layout.TilePane;

public class SubMenuBox extends TilePane {

    public SubMenuBox() {
        super(Orientation.VERTICAL);
        super.getStyleClass().add(SubMenuBoxItemNames.VIEW.getStyleName());
        init();
    }

    private void init() {

        for (SubMenuButtonItemNames item : SubMenuButtonItemNames.values()) {

            SubMenuItem sub = new SubMenuItem();
            sub.setItem(item);

            super.getChildren().add(sub);
        }

    }

}
