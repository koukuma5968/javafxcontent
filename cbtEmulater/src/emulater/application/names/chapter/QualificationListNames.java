package emulater.application.names.chapter;

import emulater.application.names.StyleNamesInterface;

public enum QualificationListNames implements StyleNamesInterface {

    VIEW("treelist-pane"),
    CERT("cate-item"),
    TARGET_ITEM("target-item");

    private String styleName;

    private QualificationListNames(String styleName) {
        this.styleName = styleName;
    }

    @Override
    public String getStyleName() {
        return this.styleName;
    }

}
