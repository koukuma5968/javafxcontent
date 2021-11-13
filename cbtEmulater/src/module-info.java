/**
 * @author user
 *
 */
module cbtEmulater {
    exports emulater.application;
    requires transitive com.sun.xml.bind;
    requires javafx.graphics;
    requires javafx.controls;
    requires java.xml.bind;
    requires javafx.base;
    requires java.desktop;
    requires java.logging;
    opens emulater.xml.tree;
    opens emulater.xml.chapter;
    opens emulater.xml.problem;
    opens emulater.application.bean;
}