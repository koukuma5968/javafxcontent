package emulater.application.layout.problem.top;

import emulater.application.names.problem.CertificationNameItem;
import emulater.xml.chapter.CertType;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class CertificationName extends VBox {

    public CertificationName() {
        super();
        super.getStyleClass().add(CertificationNameItem.LABEL_NAME.getStyleName());
    }

    public void setCertName(String name) {

        super.getChildren().add(new Label(CertType.NAME.getTitle()));

        super.getChildren().add(new Label(name));

    }
}
