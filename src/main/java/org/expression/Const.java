package org.expression;

import org.expression.interfaces.Expression;
import org.expression.interfaces.GeneralExpression;

public final class Const implements GeneralExpression {
    private final int value;

    public Const(int value) {
        this.value = value;
    }

    @Override
    public int evaluate(int x) {
        return value;
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Const second) {
            return value == second.value;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(value);
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return value;
    }
}