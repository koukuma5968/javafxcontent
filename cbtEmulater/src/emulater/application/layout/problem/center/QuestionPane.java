package emulater.application.layout.problem.center;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import emulater.application.bean.AnswerInterface;
import emulater.application.bean.CheckAnswerBean;
import emulater.application.names.problem.QuestionItem;
import emulater.util.RequestCipher;
import emulater.xml.problem.Question;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class QuestionPane extends BorderPane {

    private String solution = null;
    private Question question = null;

    public QuestionPane(QuestionItem style) {
        super();
        super.getStyleClass().add(style.getStyleName());
    }

    public void initLayout(List<String> list) {

        ExplanBox explan = new ExplanBox();
        explan.setExplanText(list);

        super.setCenter(explan);

    }

    public void setQuestion(int index, Question question) {

        this.question = question;

        Label number = new Label();
        number.getStyleClass().add(QuestionItem.QUEST_NUM.getStyleName());
        number.setText("問" + (index + 1));

        super.setTop(number);

        QuestionItemBox box = new QuestionItemBox();
        box.setItem(question);

        AnchorPane anc = new AnchorPane();
        AnchorPane.setTopAnchor(box, 0d);
        AnchorPane.setLeftAnchor(box, 0d);
        AnchorPane.setRightAnchor(box, 0d);
        AnchorPane.setBottomAnchor(box, 0d);
        anc.getChildren().add(box);

        super.setCenter(anc);

        solution = RequestCipher.decode(question.getSolution());

        SolutionSelectBox solution = new SolutionSelectBox();
        solution.setSelectBox(question);

        super.setBottom(solution);

    }

    public CheckAnswerBean getCheckAnswer() {

        CheckAnswerBean bean = new CheckAnswerBean();

        bean.setNumber(((Label) super.getTop()).getText());
        bean.setSolution(this.solution);

        SolutionSelectBox select = (SolutionSelectBox) super.getBottom();

        StringBuilder userSel = new StringBuilder();

        select.getChildren().forEach(node -> {

            CheckBox check = (CheckBox) node;
            if (check.isSelected()) {
                userSel.append(check.getText());
                userSel.append(",");

            }

        });

        if (userSel.length() != 0) {
            userSel.deleteCharAt(userSel.length() - 1);
        }

        bean.setCorrection(this.solution.equals(userSel.toString()) ? "〇" : "×");
        bean.setUserSel(userSel.toString());

        return bean;
    }

    public List<Label> getSolurions() {

        List<Label> solList = new ArrayList<Label>();

        StringTokenizer token = new StringTokenizer(this.solution, ",");
        while (token.hasMoreTokens()) {
            Label l = new Label();
            l.setText(token.nextToken());
            solList.add(l);
        }

        return solList;
    }

    public Question getQuestion() {
        return question;
    }

    public void setStorageQuestion(AnswerInterface ansbean) {

        Label number = new Label();
        number.getStyleClass().add(QuestionItem.QUEST_NUM.getStyleName());
        number.setText(ansbean.getNumber());

        super.setTop(number);

        QuestionItemBox box = new QuestionItemBox();
        box.setItem(ansbean.getQueBean());

        AnchorPane anc = new AnchorPane();
        AnchorPane.setTopAnchor(box, 0d);
        AnchorPane.setLeftAnchor(box, 0d);
        AnchorPane.setRightAnchor(box, 0d);
        AnchorPane.setBottomAnchor(box, 0d);
        anc.getChildren().add(box);

        super.setCenter(anc);

        solution = RequestCipher.decode(ansbean.getQueBean().getSolution());

        SolutionSelectBox solution = new SolutionSelectBox();
        solution.setStorageSelectBox(ansbean);

        super.setBottom(solution);

    }

}
