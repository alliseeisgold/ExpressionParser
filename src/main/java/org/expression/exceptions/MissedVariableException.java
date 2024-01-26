package org.expression.exceptions;

public class MissedVariableException extends ParsingException {
    public MissedVariableException(String message) {
        super("Missing variable there: " + message);
    }
}
