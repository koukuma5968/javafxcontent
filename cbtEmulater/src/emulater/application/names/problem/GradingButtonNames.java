package emulater.application.names.problem;

import emulater.application.names.StyleNamesInterface;

public enum GradingButtonNames implements StyleNamesInterface {

    GRAD_BOX("grad-box"),
    GRAD_IMAGE("grad-image"),
    GRAD_LABEL("grad-label");

    private GradingButtonNames(String styleName) {
        this.styleName = styleName;
    }

    private String styleName;

    @Override
    public String getStyleName() {
        return styleName;
    }

}
