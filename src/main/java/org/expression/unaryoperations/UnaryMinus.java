package org.expression.unaryoperations;

import org.expression.interfaces.GeneralExpression;

public class UnaryMinus extends UnaryOperation {

    public UnaryMinus(GeneralExpression expr) {
        super(expr);
    }

    @Override
    protected int operationResult(int x) {
        return -x;
    }

    @Override
    protected String getOperationString() {
        return "-";
    }
}
