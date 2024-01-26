package org.expression.parser;

import org.expression.interfaces.ThreeVariableExpr;

@FunctionalInterface
public interface TripleParser {
    ThreeVariableExpr parse(String expression) throws Exception;
}
