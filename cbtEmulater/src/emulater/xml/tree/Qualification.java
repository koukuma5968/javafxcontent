package emulater.xml.tree;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import emulater.xml.XmlElementInterface;

@XmlRootElement(name="Qualification")
@XmlAccessorType(XmlAccessType.FIELD)
public class Qualification implements XmlElementInterface {

    @XmlElement(name="Category")
    private List<Category> Category;

    public List<Category> getCategory() {
        return Category;
    }

}
