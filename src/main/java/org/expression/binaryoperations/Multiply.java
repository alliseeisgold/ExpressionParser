package org.expression.binaryoperations;

import org.expression.Expression;

public class Multiply extends BinaryOperation {
    public Multiply(Expression left, Expression right) {
        super(left, right, "*");
    }
    @Override
    protected int operationResult(int left, int right) {
        return left * right;
    }
}
