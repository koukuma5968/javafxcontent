package emulater.application.bean;

import emulater.xml.problem.Question;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CheckAnswerBean implements AnswerInterface {

    private StringProperty number = new SimpleStringProperty();

    private StringProperty solution = new SimpleStringProperty();

    private StringProperty userSel = new SimpleStringProperty();

    private StringProperty correction = new SimpleStringProperty();

    private Question queBean = null;

    @Override
    public String getNumber() {
        return number.get();
    }

    public void setNumber(String number) {
        this.number.setValue(number);
    }

    @Override
    public String getSolution() {
        return solution.get();
    }

    public void setSolution(String solution) {
        this.solution.setValue(solution);
    }

    @Override
    public String getUserSel() {
        return userSel.get();
    }

    public void setUserSel(String userSel) {
        this.userSel.setValue(userSel);
    }

    @Override
    public String getCorrection() {
        return correction.get();
    }

    public void setCorrection(String correction) {
        this.correction.setValue(correction);
    }

    @Override
    public Question getQueBean() {
        return queBean;
    }

    public void setQueBean(Question queBean) {
        this.queBean = queBean;
    }

}
