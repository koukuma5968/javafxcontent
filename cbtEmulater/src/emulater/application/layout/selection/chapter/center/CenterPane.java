package emulater.application.layout.selection.chapter.center;

import emulater.application.layout.selection.chapter.center.cert.CertificationPane;
import emulater.application.layout.selection.chapter.center.exam.ExaminationPane;
import emulater.application.layout.selection.chapter.center.ordinal.OrdinalPane;
import emulater.application.names.chapter.CenterPaneNames;
import emulater.util.EmulaterLogger;
import emulater.util.JAXBUtil;
import emulater.xml.chapter.Chapter;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class CenterPane extends BorderPane {

    private final String cName = CenterPane.class.getSimpleName();

    public CenterPane() {
        super();
        EmulaterLogger.info(cName, "チャプター画面初期化");
        super.getStyleClass().add(CenterPaneNames.VIEW.getStyleName());
        Label l = new Label("左のリストから選択");
        l.getStyleClass().add("init-title");
        super.setCenter(l);
    }

    public void setChapter(String path) {

        EmulaterLogger.info(cName, "チャプターセット");
        super.getChildren().clear();

        Chapter chapter = getCapterList(path);

        CertificationPane cert = new CertificationPane();
        cert.setLayout(chapter);
        super.setTop(cert);

        OrdinalPane ordinal = new OrdinalPane();
        ordinal.setLayout(chapter.getOrdinal());
        super.setCenter(ordinal);

        ExaminationPane exam = new ExaminationPane();
        exam.setLayout(path, chapter);
        super.setBottom(exam);
    }

    protected Chapter getCapterList(String path) {
        return (Chapter) JAXBUtil.getXmlObject(Chapter.class, JAXBUtil.PROBLEM_ROOT + path + JAXBUtil.CHAPTER_LIST);
    }

}
