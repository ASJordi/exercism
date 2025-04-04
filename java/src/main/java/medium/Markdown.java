package medium;

import java.util.regex.Pattern;

public class Markdown {

    private static final Pattern BOLD_PATTERN = Pattern.compile("__(.+?)__");
    private static final Pattern ITALIC_PATTERN = Pattern.compile("_(.+?)_");

    public String parse(String markdown) {
        String[] lines = markdown.split("\n");
        StringBuilder result = new StringBuilder();
        boolean isListActive = false;

        for (String line : lines) {
            String parsedLine = parseLine(line);
            boolean isListItem = parsedLine.startsWith("<li>");

            if (isListItem && !isListActive) {
                isListActive = true;
                result.append("<ul>");
            } else if (!isListItem && isListActive) {
                isListActive = false;
                result.append("</ul>");
            }

            result.append(parsedLine);
        }

        if (isListActive) result.append("</ul>");

        return result.toString();
    }

    private String parseLine(String line) {
        String parsedHeader = parseHeader(line);
        if (parsedHeader != null) return parsedHeader;

        String parsedListItem = parseListItem(line);
        if (parsedListItem != null) return parsedListItem;

        return parseParagraph(line);
    }

    private String parseHeader(String line) {
        int headerLevel = 0;

        while (headerLevel < line.length() && headerLevel < 6 && line.charAt(headerLevel) == '#') {
            headerLevel++;
        }

        if (headerLevel == 0 || headerLevel > 6 || (headerLevel < line.length() && line.charAt(headerLevel) != ' ')) return null;

        String headerContent = line.substring(headerLevel + 1);
        return String.format("<h%d>%s</h%d>", headerLevel, headerContent, headerLevel);
    }

    private String parseListItem(String line) {
        if (!line.startsWith("* ")) return null;

        String content = line.substring(2);
        String formattedContent = applyTextFormatting(content);

        return String.format("<li>%s</li>", formattedContent);
    }

    private String parseParagraph(String line) {
        String formattedContent = applyTextFormatting(line);
        return String.format("<p>%s</p>", formattedContent);
    }

    private String applyTextFormatting(String text) {
        String result = BOLD_PATTERN.matcher(text).replaceAll("<strong>$1</strong>");
        return ITALIC_PATTERN.matcher(result).replaceAll("<em>$1</em>");
    }
}