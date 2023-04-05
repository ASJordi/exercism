package easy;

import static java.lang.String.format;

public class LogLevels {

    public static String message(String logLine) {
        String regex = "\\[(INFO|WARNING|ERROR)\\]:";
        return logLine.replaceAll(regex, "").trim();
    }

    public static String logLevel(String logLine) {
        String info = "[INFO]:";
        String warning = "[WARNING]:";
        String error = "[ERROR]:";
        String msg = "";
        if (logLine.contains(info)) msg = "info";
        if (logLine.contains(warning)) msg = "warning";
        if (logLine.contains(error)) msg = "error";
        return msg.toLowerCase();
    }

    public static String reformat(String logLine) {
//        String msg = "";
//        String info = "[INFO]:";
//        String warning = "[WARNING]:";
//        String error = "[ERROR]:";
//        if (logLine.startsWith(info)) msg = logLine.replaceAll("\\[INFO\\]:", "").trim() + " (info)";
//        if (logLine.startsWith(warning)) msg = logLine.replaceAll("\\[WARNING\\]:", "").trim() + " (warning)";
//        if (logLine.startsWith(error)) msg = logLine.replaceAll("\\[ERROR\\]:", "").trim() + " (error)";
//
//        return msg;
        return format("%s (%s)", message(logLine), logLevel(logLine));
    }

}
