package org.expression.exceptions;

public class MissedOpenParenthesis extends ParsingException {
    public MissedOpenParenthesis(String message) {
        super("Closing parenthesis without opening. There:" + message);
    }
}
