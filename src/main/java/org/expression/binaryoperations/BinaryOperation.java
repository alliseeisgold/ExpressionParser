package org.expression.binaryoperations;

import org.expression.Expression;

import java.util.Objects;

public abstract class BinaryOperation implements Expression {
    private final Expression left;
    private final Expression right;

    private final String operationType;

    public BinaryOperation(Expression left, Expression right, String operationType) {
        this.left = left;
        this.right = right;
        this.operationType = operationType;
    }

    protected abstract int operationResult(int left, int right);

    @Override
    public String toString() {
        return "(" + left + " " + operationType + " " + right + ")";
    }

    @Override
    public int evaluate(int x) {
        return operationResult(left.evaluate(x), right.evaluate(x));
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right, this.getClass());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof BinaryOperation second) {
            return Objects.equals(this.getClass(), obj.getClass()) &&
                    Objects.equals(left, second.left) && Objects.equals(right, second.right);
        }
        return false;
    }
}
