package org.expression.exceptions;

import org.expression.binaryoperations.arithmetic.Multiply;
import org.expression.interfaces.GeneralExpression;

public class MultiplyWithException extends Multiply {
    public MultiplyWithException(GeneralExpression left, GeneralExpression right) {
        super(left, right);
    }

    @Override
    protected int operationResult(int left, int right) {
        int maxToOverflow = Integer.MAX_VALUE;
        if ((left < 0 && right > 0) ||
                (left > 0 && right < 0)) {
            maxToOverflow = Integer.MIN_VALUE;
        }
        if ((left == -1 && right == Integer.MIN_VALUE) ||
                (right == -1 && left == Integer.MIN_VALUE) ||
                (left != 0 && right < 0 && right < maxToOverflow / left) ||
                (left != -1 && left != 0 && right > 0 && right > maxToOverflow / left)) {
            throw new OverflowException();
        }
        return super.operationResult(left, right);
    }
}
