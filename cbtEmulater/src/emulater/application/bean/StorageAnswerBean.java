package emulater.application.bean;

import java.io.Serializable;

import emulater.xml.problem.Question;

public class StorageAnswerBean implements Serializable, AnswerInterface {

    private static final long serialVersionUID = 1L;

    private String number = null;

    private String solution = null;

    private String userSel = null;

    private String correction = null;

    private Question queBean = null;

    @Override
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    @Override
    public String getUserSel() {
        return userSel;
    }

    public void setUserSel(String userSel) {
        this.userSel = userSel;
    }

    @Override
    public String getCorrection() {
        return correction;
    }

    public void setCorrection(String correction) {
        this.correction = correction;
    }

    @Override
    public Question getQueBean() {
        return queBean;
    }

    public void setQueBean(Question queBean) {
        this.queBean = queBean;
    }

}
