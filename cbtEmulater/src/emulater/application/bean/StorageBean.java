package emulater.application.bean;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class StorageBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private LocalDateTime day = null;

    private String name= null;

    private String time = null;

    private String result = null;

    private ArrayList<StorageAnswerBean> ansBeans = null;

    public LocalDateTime getDay() {
        return day;
    }

    public void setDay(LocalDateTime day) {
        this.day = day;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public ArrayList<StorageAnswerBean> getAnsBeans() {
        return ansBeans;
    }

    public void setAnsBeans(ArrayList<StorageAnswerBean> ansBeans) {
        this.ansBeans = ansBeans;
    }

}
