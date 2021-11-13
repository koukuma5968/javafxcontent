package emulater.xml.tree;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

import emulater.xml.XmlElementInterface;

@XmlAccessorType(XmlAccessType.FIELD)
public class Category implements XmlElementInterface {

    @XmlAttribute(name="name")
    private String name;

    @XmlElementWrapper(name="TargetGroup")
    @XmlElement(name="Target")
    private List<Target> target;

    public String getName() {
        return name;
    }

    public List<Target> getTarget() {
        return target;
    }

}
