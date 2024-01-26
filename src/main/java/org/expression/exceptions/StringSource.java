package org.expression.exceptions;

public class StringSource implements GeneralSourceWithException {
    private final String data;
    private int index;

    public StringSource(String data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        return index < data.length();
    }

    @Override
    public char nextSymbol() {
        return data.charAt(index++);
    }

    @Override
    public ParsingException exception(String message) {
        return new ParsingException(index + " " + message);
    }

    @Override
    public String getInformation() {
        StringBuilder result = new StringBuilder().append("\n\n=================\n")
                .append(data, Math.max(0, index - 5), Math.min(index + 5, data.length())).append("\n");
        result.append(" ".repeat(Math.max(0, Math.max(0, index) - 2)));
        result.append("^").append("\n=================\n");
        return result.toString();
    }
}
