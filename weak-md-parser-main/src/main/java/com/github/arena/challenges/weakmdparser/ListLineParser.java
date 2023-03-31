package com.github.arena.challenges.weakmdparser;

public class ListLineParser {

    public String parse(String line) {
        if (isStartOfList(line)) {
            activeList = true;
            result.append("<ul>");
        } else if (isEndOfList(line)) {
            activeList = false;
            result.append("</ul>");
        }

        result.append(theLine);
    }

    private boolean isStartOfList(String line) {
        return line.matches("(<li>).*") && !line.matches("(<h).*") && !line.matches("(<p>).*");
    }

    private boolean isEndOfList(String line) {
        return !line.matches("(<li>).*");
    }
}