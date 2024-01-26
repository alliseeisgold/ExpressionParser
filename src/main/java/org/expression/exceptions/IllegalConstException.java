package org.expression.exceptions;

public class IllegalConstException extends ParsingException {
    public IllegalConstException(String message) {
        super("Illegal constant: " + message);
    }
}
