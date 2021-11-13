package emulater.application.names.problem;

public enum TerminationItem {

    VIEW("term-view"),
    IMAGE("term-image"),
    LABEL("term-label");

    private TerminationItem(String styleName) {
        this.styleName = styleName;
    }

    private String styleName;

    public String getStyleName() {
        return styleName;
    }

}
