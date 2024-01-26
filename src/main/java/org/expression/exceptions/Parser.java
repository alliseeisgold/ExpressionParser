package org.expression.exceptions;

import org.expression.interfaces.ThreeVariableExpr;

/**
 * @author Georgiy Korneev (kgeorgiy@kgeorgiy.info)
 */
public interface Parser {
    ThreeVariableExpr parse(String expression) throws ParsingException;
}
