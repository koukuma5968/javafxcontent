package emulater.application.names.chapter;

public enum TopMenuItemNames {

    MENU("topmenu"),
    TITLE("topmenu-title"),
    IMAGE("topmenu-title-image"),
    TITLE_TEXT("topmenu-title-text"),
    CLOSE("close-button"),
    EXPANS("expansion-button"),
    REDUCT("reduction-button");

    private TopMenuItemNames(String styleName) {
        this.styleName = styleName;
    }

    private String styleName;

    public String getStyleName() {
        return styleName;
    }

}
