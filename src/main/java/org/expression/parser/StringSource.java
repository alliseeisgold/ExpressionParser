package org.expression.parser;

import org.expression.exceptions.ExpressionException;

public class StringSource implements GeneralSource {
    private final String data;
    private int index;


    public StringSource() {
        this.data = "";
    }

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
    public ExpressionException exception(String message) {
        return new ExpressionException(index + " " + message);
    }
}
