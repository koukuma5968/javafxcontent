package emulater.application.names.chapter;

import emulater.application.names.StyleNamesInterface;

public enum SelectionViewNames implements StyleNamesInterface {

    VIEW("selection-pane");

    private String styleName;

    private SelectionViewNames(String styleName) {
        this.styleName = styleName;
    }

    @Override
    public String getStyleName() {
        return this.styleName;
    }

}
