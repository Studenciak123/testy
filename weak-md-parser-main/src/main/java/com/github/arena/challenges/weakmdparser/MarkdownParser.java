package com.github.arena.challenges.weakmdparser;

public class MarkdownParser {

    private final ServiceLine serviceLine;

    MarkdownParser() {
        this.serviceLine = new ServiceLine();
    }

    public String parse(String markdown) {
        return serviceLine.parse(markdown);
    }
}
