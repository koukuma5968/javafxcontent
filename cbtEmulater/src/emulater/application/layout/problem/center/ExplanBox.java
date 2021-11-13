package emulater.application.layout.problem.center;

import java.util.List;

import emulater.application.names.problem.QuestionItem;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class ExplanBox extends VBox {

    public ExplanBox() {
        super();
        super.getStyleClass().add(QuestionItem.EXPLAN_BOX.getStyleName());
    }

    public void setExplanText(List<String> list) {

        list.stream().forEach(explan -> {
            Text text = new Text();
            text.getStyleClass().add(QuestionItem.EXPLAN_TEXT.getStyleName());
            text.setText(explan);
            super.setMargin(text, new Insets(10, 5, 10, 5));
            super.getChildren().add(text);
        });

    }

}
