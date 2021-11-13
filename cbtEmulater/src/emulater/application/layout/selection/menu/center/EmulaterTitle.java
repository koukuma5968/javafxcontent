package emulater.application.layout.selection.menu.center;

import emulater.application.names.chapter.TopMenuItemNames;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class EmulaterTitle extends HBox {

    public EmulaterTitle() {
        super();
        super.getStyleClass().add(TopMenuItemNames.TITLE.getStyleName());
        setTitle();
    }

    public void setTitle() {

        ImageView image = new ImageView();
        image.getStyleClass().add(TopMenuItemNames.IMAGE.getStyleName());
        super.getChildren().add(image);

        Label l = new Label();
        l.getStyleClass().add(TopMenuItemNames.TITLE_TEXT.getStyleName());
        l.setText("CBT試験エミュレータ");

        super.getChildren().add(l);
    }
}
