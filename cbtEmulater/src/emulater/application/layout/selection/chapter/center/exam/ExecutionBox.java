package emulater.application.layout.selection.chapter.center.exam;

import java.util.List;

import javafx.scene.layout.HBox;

public class ExecutionBox extends HBox {

    private String path;

    private String name;

    private String time;

    private String number;

    private String passLine;

    private List<String> explanatory;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPassLine() {
        return passLine;
    }

    public void setPassLine(String passLine) {
        this.passLine = passLine;
    }

    public List<String> getExplanatory() {
        return explanatory;
    }

    public void setExplanatory(List<String> explanatory) {
        this.explanatory = explanatory;
    }

}
