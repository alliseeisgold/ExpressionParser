package org.expression.exceptions;

import org.expression.binaryoperations.arithmetic.Add;
import org.expression.interfaces.GeneralExpression;

public class AddWithException extends Add {
    public AddWithException(GeneralExpression left, GeneralExpression right) {
        super(left, right);
    }

    @Override
    protected int operationResult(int left, int right) {
        if ((right > 0 && (Integer.MAX_VALUE - right < left)) ||
                (right < 0 && (Integer.MIN_VALUE - right > right))) {
            throw new OverflowException();
        }
        return super.operationResult(left, right);
    }
}
