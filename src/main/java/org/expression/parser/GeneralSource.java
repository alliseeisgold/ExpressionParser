package org.expression.parser;

import org.expression.exceptions.ExpressionException;

public interface GeneralSource {
    boolean hasNext();
    char nextSymbol();
    ExpressionException exception(String message);
}
