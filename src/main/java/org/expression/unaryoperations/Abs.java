package org.expression.unaryoperations;

import org.expression.interfaces.GeneralExpression;

public class Abs extends UnaryOperation {

    public Abs(GeneralExpression expr) {
        super(expr);
    }
    @Override
    protected int operationResult(int x) {
        return Math.abs(x);
    }

    @Override
    protected String getOperationString() {
        return "abs";
    }
}
