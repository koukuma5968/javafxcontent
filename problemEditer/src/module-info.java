module problemEditer {
    exports problemEditer.stage;
    requires com.sun.xml.bind;
    requires javafx.graphics;
    requires javafx.controls;
    requires java.xml.bind;
    requires java.xml;
    opens problemEditer.stage;
}