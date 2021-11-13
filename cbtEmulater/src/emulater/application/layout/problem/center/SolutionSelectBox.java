package emulater.application.layout.problem.center;

import java.util.StringTokenizer;

import emulater.application.bean.AnswerInterface;
import emulater.application.names.problem.QuestionItem;
import emulater.util.RequestCipher;
import emulater.xml.problem.Question;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.HBox;

public class SolutionSelectBox extends HBox {

    public SolutionSelectBox() {
        super();
        super.getStyleClass().add(QuestionItem.SOLUTION.getStyleName());
    }

    public void setSelectBox(Question question) {

        question.getAnswer().stream().forEach(ans -> {

            CheckBox check = new CheckBox();
            check.getStyleClass().add(QuestionItem.SOLUTION_CHECK.getStyleName());
            check.setText(RequestCipher.decode(ans.getId()));
            super.getChildren().add(check);

        });
    }

    public void setStorageSelectBox(AnswerInterface ansbean) {

        ansbean.getQueBean().getAnswer().stream().forEach(ans -> {

            CheckBox check = new CheckBox();
            check.getStyleClass().add(QuestionItem.SOLUTION_CHECK.getStyleName());
            check.setText(RequestCipher.decode(ans.getId()));

            StringTokenizer token = new  StringTokenizer(ansbean.getUserSel(), ",");
            while (token.hasMoreTokens()) {
                String sel = token.nextToken();
                if (check.getText().equals(sel)) {
                    check.setSelected(true);
                }
            }
            super.getChildren().add(check);

        });
    }
}
