package org.expression.binaryoperations;

import org.expression.Expression;

public class Subtract extends BinaryOperation {
    public Subtract(Expression left, Expression right) {
        super(left, right, "-");
    }

    @Override
    protected int operationResult(int left, int right) {
        return left - right;
    }
}
