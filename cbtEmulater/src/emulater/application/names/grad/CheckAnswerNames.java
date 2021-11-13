package emulater.application.names.grad;

import emulater.application.names.StyleNamesInterface;

public enum CheckAnswerNames implements StyleNamesInterface {

    VIEW("checkans-view"),
    CHECK_TABLE("checkans-table"),
    NUM_BOX("checkans-num-box"),
    NUM_LABEL("checkans-num-label"),
    TEXT_LABEL("checkans-text-label");

    private CheckAnswerNames(String styleName) {
        this.styleName = styleName;
    }

    private String styleName;

    @Override
    public String getStyleName() {
        return styleName;
    }

}
