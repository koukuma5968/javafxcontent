package emulater.application.names.problem;

public enum ProblemItem {

    VIEW_TITLE("problem-view"),
    MENU_VIEW("problem-menu"),
    MENU_BOX("problem-menu-box");

    private ProblemItem(String styleName) {
        this.styleName = styleName;
    }

    private String styleName;

    public String getStyleName() {
        return styleName;
    }

}
