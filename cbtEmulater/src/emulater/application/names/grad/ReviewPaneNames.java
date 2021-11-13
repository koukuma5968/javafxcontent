package emulater.application.names.grad;

import emulater.application.names.StyleNamesInterface;

public enum ReviewPaneNames implements StyleNamesInterface {

    SOL_BOX("review-sol-box"),
    CLOSE_BOX("close-box"),
    CLOSE_IMAGE("close-image"),
    CLOSE_LABEL("close-label"),
    STRAGE_BOX("storage-box"),
    STRAGE_IMAGE("storage-image"),
    STRAGE_LABEL("storage-label");

    private ReviewPaneNames(String styleName) {
        this.styleName = styleName;
    }

    private String styleName;

    @Override
    public String getStyleName() {
        return styleName;
    }

}
