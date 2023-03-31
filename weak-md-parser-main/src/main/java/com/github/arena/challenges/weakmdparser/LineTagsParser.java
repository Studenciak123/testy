package com.github.arena.challenges.weakmdparser;

class LineTagsParser {
    private final StringBuilder result = new StringBuilder();
    private boolean activeList = false;

    public StringBuilder parseLineWithListTags(String theLine) {
        if (isStartOfList(theLine)) {
            activeList = true;
            result.append("<ul>");
        } else if (isEndOfList(theLine)) {
            activeList = false;
            result.append("</ul>");
        }

        return result.append(theLine);
    }

    public boolean isActiveList() {
        return activeList;
    }

    private boolean isStartOfList(String theLine) {
        return theLine.matches("(<li>).*") && !theLine.matches("(<h).*") && !theLine.matches("(<p>).*") && !activeList;
    }

    private boolean isEndOfList(String theLine) {
        return !theLine.matches("(<li>).*") && activeList;
    }
}
