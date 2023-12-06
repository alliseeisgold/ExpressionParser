package org.expression.binaryoperations;

import org.expression.interfaces.Expression;
import org.expression.interfaces.GeneralExpression;

public class Multiply extends BinaryOperation {
    public Multiply(GeneralExpression left, GeneralExpression right) {
        super(left, right, "*");
    }
    @Override
    protected int operationResult(int left, int right) {
        return left * right;
    }
}
