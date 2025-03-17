package easy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class LogLineTest {

    @Test
    @Tag("task:1")
    @DisplayName("Parsing log level TRC")
    public void getLogLevelTrace() {
        var logLine = new LogLine("[TRC]: Line 84 - System.out.println(\"Hello World\");");
        assertEquals(LogLevel.valueOf("TRACE"), logLine.getLogLevel());
    }

    @Test
    @Tag("task:1")
    @DisplayName("Parsing log level DBG")
    public void parseLogLevelDbg() {
        var logLine = new LogLine("[DBG]: ; expected");
        assertEquals(LogLevel.valueOf("DEBUG"), logLine.getLogLevel());
    }

    @Test
    @Tag("task:1")
    @DisplayName("Parsing log level INF")
    public void parseLogLevelInf() {
        var logLine = new LogLine("[INF]: Timezone changed");
        assertEquals(LogLevel.valueOf("INFO"), logLine.getLogLevel());
    }

    @Test
    @Tag("task:1")
    @DisplayName("Parsing log level WRN")
    public void parseLogLevelWrn() {
        var logLine = new LogLine("[WRN]: Timezone not set");
        assertEquals(LogLevel.valueOf("WARNING"), logLine.getLogLevel());
    }

    @Test
    @Tag("task:1")
    @DisplayName("Parsing log level ERR")
    public void parseLogLevelErr() {
        var logLine = new LogLine("[ERR]: Disk full");
        assertEquals(LogLevel.valueOf("ERROR"), logLine.getLogLevel());
    }

    @Test
    @Tag("task:1")
    @DisplayName("Parsing log level FTL")
    public void parseLogLevelFtl() {
        var logLine = new LogLine("[FTL]: Not enough memory");
        assertEquals(LogLevel.valueOf("FATAL"), logLine.getLogLevel());
    }

    @Test
    @Tag("task:2")
    @DisplayName("Parsing unknown log level XYZ")
    public void parseLogLevelXyz() {
        var logLine = new LogLine("[XYZ]: Gibberish message.. beep boop..");
        assertEquals(LogLevel.valueOf("UNKNOWN"), logLine.getLogLevel());
    }

    @Test
    @Tag("task:2")
    @DisplayName("Parsing unknown log level ABC")
    public void parseLogLevelAbc() {
        var logLine = new LogLine("[ABC]: Gibberish message.. beep boop..");
        assertEquals(LogLevel.valueOf("UNKNOWN"), logLine.getLogLevel());
    }

    @Test
    @Tag("task:3")
    @DisplayName("Get short log output for log level UNKNOWN")
    public void getShortLogOutputUnknown() {
        var logLine = new LogLine("[ABC]: We're no strangers to love");
        assertEquals("0:We're no strangers to love", logLine.getOutputForShortLog());
    }

    @Test
    @Tag("task:3")
    @DisplayName("Get short log output for log level TRACE")
    public void getShortLogOutputTrace() {
        var logLine = new LogLine("[TRC]: You know the rules and so do I");
        assertEquals("1:You know the rules and so do I", logLine.getOutputForShortLog());
    }

    @Test
    @Tag("task:3")
    @DisplayName("Get short log output for log level DEBUG")
    public void getShortLogOutputDebug() {
        var logLine = new LogLine("[DBG]: A full commitment's what I'm thinking of");
        assertEquals("2:A full commitment's what I'm thinking of", logLine.getOutputForShortLog());
    }

    @Test
    @Tag("task:3")
    @DisplayName("Get short log output for log level INFO")
    public void getShortLogOutputInfo() {
        var logLine = new LogLine("[INF]: You wouldn't get this from any other guy");
        assertEquals("4:You wouldn't get this from any other guy", logLine.getOutputForShortLog());
    }

    @Test
    @Tag("task:3")
    @DisplayName("Get short log output for log level WARNING")
    public void getShortLogOutputWarning() {
        var logLine = new LogLine("[WRN]: I just wanna tell you how I'm feeling");
        assertEquals("5:I just wanna tell you how I'm feeling", logLine.getOutputForShortLog());
    }

    @Test
    @Tag("task:3")
    @DisplayName("Get short log output for log level ERROR")
    public void getShortLogOutputError() {
        var logLine = new LogLine("[ERR]: Gotta make you understand");
        assertEquals("6:Gotta make you understand", logLine.getOutputForShortLog());
    }

    @Test
    @Tag("task:3")
    @DisplayName("Get short log output for log level FATAL")
    public void getShortLogOutputFatal() {
        var logLine = new LogLine("[FTL]: Never gonna give you up");
        assertEquals("42:Never gonna give you up", logLine.getOutputForShortLog());
    }

}
