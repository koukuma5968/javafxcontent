package emulater.application.names.problem;

import emulater.application.names.StyleNamesInterface;

public enum NextPreviousLabelBoxNames implements StyleNamesInterface {

    VIEW_TITLE("npLabel-view"),
    PRE_BOX("previous-box"),
    PRE_IMAGE("previous-image"),
    PRE_LABEL("previous-label"),
    NEXT_BOX("next-box"),
    NEXT_IMAGE("next-image"),
    NEXT_LABEL("next-label");

    private NextPreviousLabelBoxNames(String styleName) {
        this.styleName = styleName;
    }

    private String styleName;

    @Override
    public String getStyleName() {
        return styleName;
    }

}
