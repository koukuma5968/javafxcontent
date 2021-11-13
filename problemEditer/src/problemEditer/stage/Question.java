package problemEditer.stage;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Question {

    @XmlAttribute(name="id")
    private String id;

    @XmlElement(name="Statement")
    private String statement;

    @XmlElement(name="Code")
    private String code;

    @XmlElement(name="Selections")
    private String selections;

    @XmlElement(name="Answer")
    private List<Answer> answer;

    @XmlElement(name="Solution")
    private String solution;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSelections() {
        return selections;
    }

    public void setSelections(String selections) {
        this.selections = selections;
    }

    public List<Answer> getAnswer() {
        return answer;
    }

    public void setAnswer(List<Answer> answer) {
        this.answer = answer;
    }

    public void addAnswer(Answer answer) {
        if (this.answer == null) {
            this.answer = new ArrayList<Answer>();
        }
        this.answer.add(answer);
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

}
