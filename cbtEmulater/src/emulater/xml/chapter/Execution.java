package emulater.xml.chapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import emulater.xml.XmlElementInterface;

@XmlAccessorType(XmlAccessType.FIELD)
public class Execution implements XmlElementInterface {

    @XmlElement(name="Title")
    private String title;

    @XmlElement(name="Path")
    private String path;

    public String getTitle() {
        return title;
    }

    public String getPath() {
        return path;
    }

}
