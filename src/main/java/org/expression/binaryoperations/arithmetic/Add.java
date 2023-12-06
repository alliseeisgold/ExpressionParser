package org.expression.binaryoperations.arithmetic;

import org.expression.binaryoperations.BinaryOperation;
import org.expression.interfaces.Expression;
import org.expression.interfaces.GeneralExpression;

public class Add extends BinaryOperation {
    public Add(GeneralExpression left, GeneralExpression right) {
        super(left, right, "+");
    }
    @Override
    protected int operationResult(int left, int right) {
        return left + right;
    }
}
