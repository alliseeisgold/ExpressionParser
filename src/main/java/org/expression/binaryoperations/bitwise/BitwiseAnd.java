package org.expression.binaryoperations.bitwise;

import org.expression.binaryoperations.BinaryOperation;
import org.expression.interfaces.GeneralExpression;

public class BitwiseAnd extends BinaryOperation {
    public BitwiseAnd(GeneralExpression left, GeneralExpression right) {
        super(left, right, "&");
    }
    @Override
    protected int operationResult(int left, int right) {
        return left & right;
    }
}

