package emulater.application.names.problem;

public enum TimerItem {

    TIMER("time-view");

    private TimerItem(String styleName) {
        this.styleName = styleName;
    }

    private String styleName;

    public String getStyleName() {
        return styleName;
    }

}
