package org.expression.binaryoperations;

import org.expression.Expression;

public class Divide extends BinaryOperation {
    public Divide(Expression left, Expression right) {
        super(left, right, "/");
    }
    @Override
    protected int operationResult(int left, int right) {
        return left / right;
    }
}
