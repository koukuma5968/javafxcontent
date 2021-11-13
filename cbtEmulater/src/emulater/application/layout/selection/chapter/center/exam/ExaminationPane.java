package emulater.application.layout.selection.chapter.center.exam;

import emulater.application.names.chapter.ExaminationtemNames;
import emulater.event.EventListener;
import emulater.event.exam.exe.ExecutionEventHandler;
import emulater.xml.chapter.CertType;
import emulater.xml.chapter.Chapter;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class ExaminationPane extends HBox {

    public ExaminationPane() {
        super();
        super.getStyleClass().add(ExaminationtemNames.VIEW_TITLE.getStyleName());
    }

    public void setLayout(String path, Chapter chapter) {

        chapter.getExamination().getExecution().forEach(exe -> {

            ImageView itemView = new ImageView();
            itemView.getStyleClass().add(ExaminationtemNames.IMAGE_BUTTON.getStyleName());

            Label itemLabel = new Label();
            itemLabel.setText(exe.getTitle());
            itemLabel.getStyleClass().add(ExaminationtemNames.ITEM_VALUE.getStyleName());

            ExecutionBox box = new ExecutionBox();
            box.getStyleClass().add(ExaminationtemNames.BUTTON_ITEM.getStyleName());
            box.setPath("prop/problem/" + path + "/chapter/" + exe.getPath());
            box.setExplanatory(chapter.getExplanatory());
            chapter.getCertification().stream().filter(cert -> CertType.NAME==cert.getCertType()).forEach(name -> box.setName(name.getValue()));
            chapter.getCertification().stream().filter(cert -> CertType.TIME==cert.getCertType()).forEach(time -> box.setTime(time.getValue()));
            chapter.getCertification().stream().filter(cert -> CertType.QNUMBER==cert.getCertType()).forEach(number -> box.setNumber(number.getValue()));
            chapter.getCertification().stream().filter(cert -> CertType.PASSLINE==cert.getCertType()).forEach(passline -> box.setPassLine(passline.getValue()));

            box.getChildren().add(itemView);
            box.getChildren().add(itemLabel);

            for (EventListener event : ExecutionEventHandler.values()) {
                box.addEventHandler(event.getEventType(), event.getEvent());
            }

            super.getChildren().add(box);
        });
    }

}
