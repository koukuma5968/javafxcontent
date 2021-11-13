package emulater.xml.chapter;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

import emulater.xml.XmlElementInterface;

@XmlAccessorType(XmlAccessType.FIELD)
public class Item implements XmlElementInterface {

    @XmlElement(name="Number")
    private int number;

    @XmlElement(name="Title")
    private String title;

    @XmlElement(name="Path")
    private String path;

    @XmlElementWrapper(name="ClauseGroup")
    @XmlElement(name="Clause")
    private List<String> clause;

    public int getVersion() {
        return number;
    }

    public String getTitle() {
        return title;
    }

    public String getPath() {
        return path;
    }

    public List<String> getClause() {
        return clause;
    }

}
