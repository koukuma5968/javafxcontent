package emulater.application.layout.selection.chapter.center.cert;

import java.util.List;

import emulater.application.names.chapter.CertificationItemNames;
import emulater.xml.XmlElementInterface;
import emulater.xml.chapter.Certification;
import emulater.xml.chapter.Chapter;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class CertificationPane extends BorderPane {

    public CertificationPane() {
        super();
        super.getStyleClass().add(CertificationItemNames.VIEW_TITLE.getStyleName());
    }

    public void setLayout(XmlElementInterface xml) {

        Chapter chapter = (Chapter) xml;

        super.setTop(getContents(CertificationItemNames.TOP_TITLE, chapter.getCertificationTitle()));

        super.setCenter(getheader(chapter.getCertification()));

    }

    private AnchorPane getheader(List<Certification> certification) {

        GridPane grid = new GridPane();
        grid.getStyleClass().add(CertificationItemNames.CERT_HEAD.getStyleName());

        certification.forEach(cert -> {

            VBox item = new VBox();
            item.getStyleClass().add(CertificationItemNames.CERT_ITEM.getStyleName());

            Label title = getContents(CertificationItemNames.ITEM_TITLE, cert.getCertType().getTitle());
            Label value = getContents(CertificationItemNames.ITEM_VALUE, cert.getValue() + cert.getCertType().getValue());

            item.getChildren().add(title);
            item.getChildren().add(value);

            GridPane.setHgrow(item, Priority.ALWAYS);
            GridPane.setVgrow(item, Priority.ALWAYS);
            GridPane.setConstraints(item, cert.getCertType().ordinal()%3, cert.getCertType().ordinal()/3);

            grid.getChildren().add(item);

        });

        AnchorPane anc = new AnchorPane();

        AnchorPane.setLeftAnchor(grid, 0d);
        AnchorPane.setRightAnchor(grid, 0d);
        anc.getChildren().add(grid);

        return anc;
    }

    private Label getContents(CertificationItemNames item, String value) {

        Label l = new Label();
        l.getStyleClass().add(item.getStyleName());
        l.setText(value);
        l.setMaxWidth(item.getMaxWidth());

        VBox.setVgrow(l, Priority.ALWAYS);

        return l;
    }

}
