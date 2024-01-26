package org.expression.exceptions;

import org.expression.interfaces.GeneralExpression;
import org.expression.unaryoperations.Sqrt;

public class SqrtWithException extends Sqrt {
    public SqrtWithException(GeneralExpression first) {
        super(first);
    }

    @Override
    protected int operationResult(int x) {
        if (x < 0) {
            throw new SqrtFromNegativeException();
        }
        return super.operationResult(x);
    }

}
