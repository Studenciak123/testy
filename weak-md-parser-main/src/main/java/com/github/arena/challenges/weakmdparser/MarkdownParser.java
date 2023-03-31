package com.github.arena.challenges.weakmdparser;

public class MarkdownParser {

    private final StringBuilder result = new StringBuilder();
    private boolean activeList = false;

    private final LineParser lineParser;
    private final ListLineParser listLineParser;

    public MarkdownParser() {
        this.lineParser = new LineParser();
        this.listLineParser = new ListLineParser();
    }

    public String parse(String markdown) {
        if (markdown == null)
            throw new NullPointerException();

        String[] lines = markdown.split("\n");

        for (var line : lines) {
            result.append(lineParser.parse(line));
            result.append(listLineParser.parse(line));
        }

        if (activeList)
            result.append("</ul>");

        return result.toString();
    }
}