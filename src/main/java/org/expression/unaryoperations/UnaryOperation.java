package org.expression.unaryoperations;

import org.expression.interfaces.GeneralExpression;

import java.util.Objects;

public abstract class UnaryOperation implements GeneralExpression {

    protected final GeneralExpression current;

    public UnaryOperation(GeneralExpression current) {
        this.current = current;
    }

    protected abstract int operationResult(int x);

    @Override
    public int evaluate(int x) {
        return operationResult(current.evaluate(x));
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return operationResult(current.evaluate(x, y, z));
    }

    @Override
    public String toString() {
        return "(" + getOperationString() + current + ")";
    }

    protected abstract String getOperationString();

    @Override
    public int hashCode() {
        return Objects.hash(current, getOperationString());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof UnaryOperation newOperation) {
            return Objects.equals(current, newOperation.current)
                    && Objects.equals(getOperationString(), newOperation.getOperationString());
        }
        return false;
    }
}
