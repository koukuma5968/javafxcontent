package emulater.application.layout.problem.center;

import java.util.List;

import emulater.application.names.problem.QuestionItem;
import emulater.util.RequestCipher;
import emulater.xml.problem.Answer;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AnswerItemBox extends VBox {

    public AnswerItemBox() {
        super();
        super.getStyleClass().add(QuestionItem.ANS.getStyleName());
    }

    public void setAnswer(List<Answer> ansList) {

        ansList.stream().forEach(ans -> {
            Label aid = new Label();
            aid.setText(RequestCipher.decode(ans.getId()) + "：");

            Label avalue = new Label();
            avalue.setText(RequestCipher.decode(ans.getValue()));

            HBox answer = new HBox();
            answer.getStyleClass().add(QuestionItem.ANS_BOX.getStyleName());
            answer.getChildren().add(aid);
            answer.getChildren().add(avalue);

            super.getChildren().add(answer);
        });

    }
}
