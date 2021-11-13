package emulater.application.bean;

import emulater.xml.problem.Question;

public interface AnswerInterface {

    public String getNumber();

    public String getSolution();

    public String getUserSel();

    public String getCorrection();

    public Question getQueBean();
}
