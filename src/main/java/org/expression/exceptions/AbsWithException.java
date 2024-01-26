package org.expression.exceptions;

import org.expression.interfaces.GeneralExpression;
import org.expression.unaryoperations.Abs;

public class AbsWithException extends Abs {
    public AbsWithException(GeneralExpression expr) {
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
