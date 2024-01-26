package org.expression.exceptions;

public class ZeroDivisionException extends GeneralException {
    public ZeroDivisionException() {
        super("Division by zero");
    }
}
