package emulater.application.names.problem;

public enum CertificationNameItem {

    LABEL_NAME("question-cert-name");

    private CertificationNameItem(String styleName) {
        this.styleName = styleName;
    }

    private String styleName;

    public String getStyleName() {
        return styleName;
    }

}
