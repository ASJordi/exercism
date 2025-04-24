package medium;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class GrepTool {

    public String grep(String pattern, List<String> flags, List<String> files) {
        boolean printLineNumbers = flags.contains("-n");
        boolean caseInsensitive = flags.contains("-i");
        boolean printFileNames = flags.contains("-l");
        boolean matchEntireLines = flags.contains("-x");
        boolean invertMatch = flags.contains("-v");
        boolean multipleFiles = files.size() > 1;

        if (printFileNames) {
            return grepFileNames(pattern, caseInsensitive, matchEntireLines, invertMatch, files);
        }

        StringBuilder sb = new StringBuilder();

        for (String file : files) {
            var lines = getLines(file);

            for (int i = 0; i < lines.size(); i++) {
                var line = lines.get(i);
                boolean matches;

                if (caseInsensitive && matchEntireLines) matches = line.toLowerCase().equals(pattern.toLowerCase());
                else if (caseInsensitive) matches = line.toLowerCase().contains(pattern.toLowerCase());
                else if (matchEntireLines) matches = line.equals(pattern);
                else matches = line.contains(pattern);

                if (invertMatch) matches = !matches;

                if (matches) {
                    if (multipleFiles) sb.append(file).append(":");
                    if (printLineNumbers) sb.append(i + 1).append(":");
                    sb.append(line).append("\n");
                }
            }
        }

        return sb.toString().trim();
    }

    private String grepFileNames(String pattern, boolean caseInsensitive, boolean matchEntireLines, boolean invertMatch, List<String> files) {
        StringBuilder sb = new StringBuilder();

        for (String file : files) {
            var lines = getLines(file);
            boolean fileMatches = false;

            for (var line : lines) {
                boolean matches;

                if (caseInsensitive && matchEntireLines) {
                    matches = line.toLowerCase().equals(pattern.toLowerCase());
                } else if (caseInsensitive) {
                    matches = line.toLowerCase().contains(pattern.toLowerCase());
                } else if (matchEntireLines) {
                    matches = line.equals(pattern);
                } else {
                    matches = line.contains(pattern);
                }

                if (invertMatch) matches = !matches;

                if (matches) {
                    fileMatches = true;
                    break;
                }
            }

            if (fileMatches) sb.append(file).append("\n");
        }

        return sb.toString().trim();
    }

    private List<String> getLines(String file) {
        Path path = Paths.get(file);
        try {
            return Files.readAllLines(path, Charset.defaultCharset());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}