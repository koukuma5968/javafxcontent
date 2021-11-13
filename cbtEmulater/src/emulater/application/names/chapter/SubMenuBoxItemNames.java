package emulater.application.names.chapter;

public enum SubMenuBoxItemNames {

    VIEW("submenu"),
    ITEM("submenu-item"),
    ITEM_LABEL("sub-text");

    private SubMenuBoxItemNames(String styleName) {
        this.styleName = styleName;
    }

    private String styleName;

    public String getStyleName() {
        return styleName;
    }

}
