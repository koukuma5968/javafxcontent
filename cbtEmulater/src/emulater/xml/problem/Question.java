package emulater.xml.problem;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlAccessorType(XmlAccessType.FIELD)
public class Question implements Serializable {

    @XmlTransient
    private static final long serialVersionUID = 1L;

    @XmlAttribute(name="id")
    private String id;

    @XmlElement(name="Statement")
    private String statement;

    @XmlElement(name="Code")
    private String code;

    @XmlElement(name="Selections")
    private String selections;

    @XmlElement(name="Answer")
    private ArrayList<Answer> answer;

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

    public ArrayList<Answer> getAnswer() {
        return answer;
    }

    public void setAnswer(ArrayList<Answer> answer) {
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
