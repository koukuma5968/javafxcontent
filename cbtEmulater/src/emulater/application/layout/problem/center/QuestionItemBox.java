package emulater.application.layout.problem.center;

import emulater.application.names.problem.QuestionItem;
import emulater.util.RequestCipher;
import emulater.xml.problem.Question;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;

public class QuestionItemBox extends ScrollPane {

    public QuestionItemBox() {
        super();
        super.getStyleClass().add(QuestionItem.QUEST_BOX.getStyleName());
    }

    public void setItem(Question question) {

        BorderPane pane = new BorderPane();
        pane.getStyleClass().add(QuestionItem.QUEST_BORDER.getStyleName());

        Label statement = new Label();
        statement.getStyleClass().add(QuestionItem.STATEMENT.getStyleName());
        statement.setText(RequestCipher.decode(question.getStatement()));
        pane.setTop(statement);

        AnswerItemBox answer  = new AnswerItemBox();
        answer.setAnswer(question.getAnswer());

        String codetext = RequestCipher.decode(question.getCode());
        if (!"".equals(codetext)) {

            CodeField code = new CodeField();
            code.setCode(codetext);

            pane.setCenter(code);

            pane.setBottom(answer);

        } else {
            pane.setCenter(answer);
        }

        super.setContent(pane);
    }
}
