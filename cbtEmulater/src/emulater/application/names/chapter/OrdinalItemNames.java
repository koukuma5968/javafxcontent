package emulater.application.names.chapter;

public enum OrdinalItemNames {

    VIEW(0, "ordinal-view"),
    CONTENT_GRID(Double.MAX_VALUE, "ordinal-content-grid"),
    CONTENT_TITLE(Double.MAX_VALUE, "ordinal-content-title"),
    CONTENT_VALUE(Double.MAX_VALUE, "ordinal-content-value"),
    ORDINAL_HEAD(0, "ordinal-head"),
    ORDINAL_ITEM(0, "ordinal-clauesGroup"),
    ITEM_TITLE(Double.MAX_VALUE, "ordinal-title"),
    ITEM_VALUE(Double.MAX_VALUE, "ordinal-value");

    OrdinalItemNames(double maxWidth, String styleName) {
        this.maxWidth = maxWidth;
        this.styleName = styleName;
    }

    private double maxWidth;

    private String styleName;

    public double getMaxWidth() {
        return maxWidth;
    }

    public String getStyleName() {
        return styleName;
    }

}
