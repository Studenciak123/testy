package com.github.arena.challenges.weakmdparser;


public class LineParser {

    public String parse(String line) {
        String theLine = parseHeader(line);

        if (theLine == null)
            theLine = parseListItem(line);

        if (theLine == null)
            theLine = parseParagraph(line);

        return theLine;
    }

    private String parseHeader(String markdown) {
        int count = 0;

        for (int i = 0; i < markdown.length() && markdown.charAt(i) == '#'; i++)
            count++;

        if (count == 0)
            return null;

        return "<h" + (count) + ">" + markdown.substring(count + 1) + "</h" + (count) + ">";
    }

    private String parseListItem(String markdown) {
        if (markdown.startsWith("*"))
            return "<li>" + parseSomeSymbols(markdown.substring(2)) + "</li>";

        return null;
    }

    private String parseParagraph(String markdown) {
        return "<p>" + parseSomeSymbols(markdown) + "</p>";
    }

    private String parseSomeSymbols(String markdown) {
        String workingOn = markdown.replaceAll("__(.+)__", "<strong>$1</strong>");

        return workingOn.replaceAll("_(.+)_","<em>$1</em>");
    }
}