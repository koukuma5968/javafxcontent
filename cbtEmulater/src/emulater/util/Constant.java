package emulater.util;

import java.io.File;
import java.time.format.DateTimeFormatter;

public class Constant {

    public static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("HH時mm分ss秒");

    public static final DateTimeFormatter DAY_FORMAT = DateTimeFormatter.ofPattern("yyyy年MM月dd日");

    public static final DateTimeFormatter OUTPUT_FORMAT = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

    public static final String BASE_DIR = new File(".").getAbsoluteFile().getParentFile().getPath();
}
