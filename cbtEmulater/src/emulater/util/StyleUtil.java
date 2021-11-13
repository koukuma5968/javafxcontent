package emulater.util;

import java.io.InputStream;
import java.net.URL;

import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.image.Image;

public class StyleUtil {

    private static final String cName = StyleUtil.class.getSimpleName();

    public static void setStylesheetFiles(Scene scene) {

        ObservableList<String> style = scene.getStylesheets();
        style.clear();

        URL path = StyleUtil.class.getClassLoader().getResource("emulater/util/css/style_blue.css");

        if (path == null) {
            path = StyleUtil.class.getResource("css/style_blue.css");
        }
        EmulaterLogger.info(cName, "cssPath=", path.toExternalForm());

        style.addAll(path.toExternalForm());
    }

    public static Image getSystemIcon() {

        InputStream is = StyleUtil.class.getResourceAsStream("icon/favicon.png");
        EmulaterLogger.info(cName, "iconPath=", is.toString());

        Image icon = new Image(is);

        return icon;
    }
}
