package org.expression.exceptions;

public class MissedCloseParenthesis extends ParsingException {
    public MissedCloseParenthesis(String message) {
        super("Source without closing parenthesis. There:" + message);
    }
}
