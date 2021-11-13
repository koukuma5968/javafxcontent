package emulater.util;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class EmulaterLogger {

    private static final Logger log = Logger.getLogger(EmulaterLogger.class.getSimpleName());
    private static final String filePath = Constant.BASE_DIR + "/log/ap.log";

    static {

        try {
            FileHandler fileHandler = new FileHandler(filePath, false);
            fileHandler.setFormatter(new SimpleFormatter());
            log.addHandler(fileHandler);
            log.setLevel(Level.FINE);
        } catch (SecurityException | IOException e) {
            error(EmulaterLogger.class.getSimpleName(), e);
        }

    }

    public static void info(String cName, String... msg) {

        StringBuilder sb = new StringBuilder(cName).append(" : ");

        for (String m : msg) {
            sb.append(m);
            sb.append(",");
        }
        log.info(sb.toString());

    }

    public static void error(String cName, Throwable e) {

        StringBuilder sb = new StringBuilder(cName);
        sb.append(" : ");
        sb.append(e.getClass().getName());
        sb.append(" : ");
        sb.append(e.getMessage());
        sb.append("\r\n");

        for (StackTraceElement el : e.getStackTrace()) {
            sb.append("\t").append(el.toString()).append("\r\n");
        }
        log.severe(sb.toString());
    }
}
