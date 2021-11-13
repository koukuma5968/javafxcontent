package emulater.application.names.chapter;

import emulater.application.names.StyleNamesInterface;

public enum CenterPaneNames implements StyleNamesInterface {

    VIEW("center-pane");

    private String styleName;

    private CenterPaneNames(String styleName) {
        this.styleName = styleName;
    }

    @Override
    public String getStyleName() {
        return this.styleName;
    }

}
