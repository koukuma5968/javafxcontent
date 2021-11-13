package emulater.xml.chapter;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import emulater.xml.XmlElementInterface;

@XmlAccessorType(XmlAccessType.FIELD)
public class Examination implements XmlElementInterface {

    @XmlElement(name="Execution")
    private List<Execution> execution;

    public List<Execution> getExecution() {
        return execution;
    }

}
