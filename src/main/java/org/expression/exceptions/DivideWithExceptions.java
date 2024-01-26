package org.expression.exceptions;

import org.expression.binaryoperations.arithmetic.Divide;
import org.expression.interfaces.GeneralExpression;

public class DivideWithExceptions extends Divide {
    public DivideWithExceptions(GeneralExpression left, GeneralExpression right) {
        super(left, right);
    }

    @Override
    protected int operationResult(int left, int right) {
        if (right == 0) {
            throw new ZeroDivisionException();
        }
        if (right == -1 && left == Integer.MIN_VALUE) {
            throw new OverflowException();
        }
        return super.operationResult(left, right);
    }
}
