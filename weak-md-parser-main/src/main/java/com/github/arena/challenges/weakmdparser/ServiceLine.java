package com.github.arena.challenges.weakmdparser;

class ServiceLine {

    private final LineParser lineParser;
    private final LineTagsParser parseLineWithListTags;
    private StringBuilder result = new StringBuilder();

    ServiceLine() {
        this.lineParser = new LineParser();
        this.parseLineWithListTags = new LineTagsParser();
    }

    public String parse(final String markdown) {
        if (markdown == null)
            throw new NullPointerException();

        String[] lines = markdown.split("\n");

        for (var line : lines) {
            String theLine = lineParser.parse(line);
            result = parseLineWithListTags.parseLineWithListTags(theLine);
        }

        if (parseLineWithListTags.isActiveList())
            result.append("</ul>");

        return result.toString();
    }
}
