package org.expression.exceptions;

public interface GeneralSourceWithException {
    boolean hasNext();
    char nextSymbol();
    ParsingException exception(String message);
    String getInformation();
}
