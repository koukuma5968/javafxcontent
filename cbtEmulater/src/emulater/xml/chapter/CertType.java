package emulater.xml.chapter;

import emulater.xml.XmlElementInterface;

public enum CertType implements XmlElementInterface {

    NAME("試験名", ""),
    NUMBER("試験番号", ""),
    TIME("試験時間", "分"),
    QNUMBER("問題数", "問"),
    PASSLINE("合格ライン", "%"),
    EXAMFEE("試験料", "円");

    private CertType(String title, String value) {
        this.title = title;
        this.value = value;
    }

    private String title;

    private String value;

    public String getTitle() {
        return title;
    }

    public String getValue() {
        return value;
    }
}
