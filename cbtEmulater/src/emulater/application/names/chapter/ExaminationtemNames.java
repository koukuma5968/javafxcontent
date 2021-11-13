package emulater.application.names.chapter;

public enum ExaminationtemNames {

    VIEW_TITLE("exam-view"),
    BUTTON_ITEM("exam-item"),
    IMAGE_BUTTON("exam-button"),
    ITEM_VALUE("exam-value");

    private ExaminationtemNames(String styleName) {
        this.styleName = styleName;
    }

    private String styleName;

    public String getStyleName() {
        return styleName;
    }

}
