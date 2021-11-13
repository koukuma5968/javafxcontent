package emulater.xml.tree;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import emulater.xml.XmlElementInterface;

@XmlAccessorType(XmlAccessType.FIELD)
public class Target implements XmlElementInterface {

    @XmlElement(name="Name")
    private String name;

    public String getName() {
        return name;
    }

    @XmlElement(name="Path")
    private String path;

    public String getPath() {
        return path;
    }
}
