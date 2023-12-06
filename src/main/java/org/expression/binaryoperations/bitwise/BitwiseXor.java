package org.expression.binaryoperations.bitwise;

import org.expression.binaryoperations.BinaryOperation;
import org.expression.interfaces.GeneralExpression;

public class BitwiseXor extends BinaryOperation {
    public BitwiseXor(GeneralExpression left, GeneralExpression right) {
        super(left, right, "^");
    }

    @Override
    protected int operationResult(int left, int right) {
        return left ^ right;
    }
}
