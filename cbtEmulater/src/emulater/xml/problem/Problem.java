package emulater.xml.problem;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import emulater.xml.XmlElementInterface;

@XmlRootElement(name="Problem")
@XmlAccessorType(XmlAccessType.FIELD)
public class Problem implements XmlElementInterface {

    @XmlElement(name="Question")
    private Question question;

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Question getQuestion() {
        return question;
    }
}
