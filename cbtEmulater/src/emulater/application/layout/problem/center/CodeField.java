package emulater.application.layout.problem.center;

import emulater.application.names.problem.QuestionItem;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class CodeField extends AnchorPane {

    public CodeField() {
        super();
        super.getStyleClass().add(QuestionItem.CODE_FIELD.getStyleName());
    }

    public void setCode(String text) {

        Label code = new Label();
        code.setText(text);
        code.getStyleClass().add(QuestionItem.CODE.getStyleName());

        AnchorPane.setTopAnchor(code, 0d);
        AnchorPane.setLeftAnchor(code, 0d);
        AnchorPane.setRightAnchor(code, 0d);
        AnchorPane.setBottomAnchor(code, 0d);
        super.getChildren().add(code);

    }
}
