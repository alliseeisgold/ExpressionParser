package org.expression.exceptions;

public class InvalidVariableException extends ParsingException {
    public InvalidVariableException(String variable, String source) {
        super("Invalid variable: " + variable + " " + source);
    }
}
