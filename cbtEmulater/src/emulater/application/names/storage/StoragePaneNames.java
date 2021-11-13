package emulater.application.names.storage;

import emulater.application.names.StyleNamesInterface;

public enum StoragePaneNames implements StyleNamesInterface {

    VIEW("storage-view"),
    CHECK_PANE("storage-pane"),
    CHECK_TABLE("storage-table"),
    NUM_BOX("storage-num-box"),
    NUM_LABEL("storage-num-label"),
    TEXT_LABEL("storage-text-label");

    private StoragePaneNames(String styleName) {
        this.styleName = styleName;
    }

    private String styleName;

    @Override
    public String getStyleName() {
        return styleName;
    }

}
