package emulater.xml.chapter;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import emulater.xml.XmlElementInterface;

@XmlRootElement(name="Chapter")
@XmlAccessorType(XmlAccessType.FIELD)
public class Chapter implements XmlElementInterface {

    @XmlAttribute(name="name")
    private String name;

    @XmlAttribute(name="language")
    private String language;

    @XmlElement(name="Version")
    private String version;

    @XmlElement(name="CertificationTitle")
    private String certificationTitle;

    @XmlElement(name="Certification")
    private List<Certification> certification;

    @XmlElementWrapper(name="Explanatory")
    @XmlElement(name="Text")
    private List<String> explanatory;

    @XmlElement(name="Examination")
    private Examination examination;

    @XmlElement(name="Ordinal")
    private List<Ordinal> ordinal;

    public String getName() {
        return name;
    }

    public String getLanguage() {
        return language;
    }

    public String getVersion() {
        return version;
    }

    public String getCertificationTitle() {
        return certificationTitle;
    }

    public List<Certification> getCertification() {
        return certification;
    }

    public List<String> getExplanatory() {
        return explanatory;
    }

    public Examination getExamination() {
        return examination;
    }

    public List<Ordinal> getOrdinal() {
        return ordinal;
    }
}
