package org.expression.exceptions;

import org.expression.interfaces.GeneralExpression;
import org.expression.unaryoperations.UnaryMinus;

public class UnaryMinusWithException extends UnaryMinus {
    public UnaryMinusWithException(GeneralExpression expr) {
        super(expr);
    }

    @Override
    protected int operationResult(int x) {
        if (x == Integer.MIN_VALUE) {
            throw new OverflowException();
        }
        return super.operationResult(x);
    }
}
