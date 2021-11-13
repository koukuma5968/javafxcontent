package emulater.application.layout.problem.bottom;

import emulater.application.names.problem.NextPreviousLabelBoxNames;
import javafx.scene.layout.AnchorPane;

public class NextPreviousBox extends AnchorPane {

    public NextPreviousBox() {
        super();
        super.getStyleClass().add(NextPreviousLabelBoxNames.VIEW_TITLE.getStyleName());
    }

    public void setNextPrevious(int index, int mSize) {

        if (index > 0) {
            NextPreviousButton pre = new NextPreviousButton(NextPreviousLabelBoxNames.PRE_BOX);
            pre.setButton(NextPreviousLabelBoxNames.PRE_IMAGE, NextPreviousLabelBoxNames.PRE_LABEL, "前の問題へ");
            AnchorPane.setLeftAnchor(pre, 10d);
            AnchorPane.setTopAnchor(pre, 10d);
            AnchorPane.setBottomAnchor(pre, 10d);
            super.getChildren().add(pre);
        }

        if (index < (mSize - 1)) {
            NextPreviousButton next = new NextPreviousButton(NextPreviousLabelBoxNames.NEXT_BOX);
            next.setButton(NextPreviousLabelBoxNames.NEXT_IMAGE, NextPreviousLabelBoxNames.NEXT_LABEL, "次の問題へ");
            AnchorPane.setRightAnchor(next, 10d);
            AnchorPane.setTopAnchor(next, 10d);
            AnchorPane.setBottomAnchor(next, 10d);
            super.getChildren().add(next);
        } else {
            GradingButton grad = new GradingButton();
            grad.setButton("採点");
            AnchorPane.setRightAnchor(grad, 10d);
            AnchorPane.setTopAnchor(grad, 10d);
            AnchorPane.setBottomAnchor(grad, 10d);
            super.getChildren().add(grad);
        }
    }
}
