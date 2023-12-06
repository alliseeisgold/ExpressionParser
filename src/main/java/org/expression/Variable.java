package org.expression;

import org.expression.interfaces.Expression;
import org.expression.interfaces.GeneralExpression;

import java.util.NoSuchElementException;
import java.util.Objects;

public class Variable implements GeneralExpression {
    private final String name;

    public Variable(String name) {
        this.name = name;
    }

    @Override
    public int evaluate(int x) {
        return x;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Variable second) {
            return Objects.equals(name, second.name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return switch (name) {
            case "x" -> x;
            case "y" -> y;
            case "z" -> z;
            case null, default -> throw new NoSuchElementException("Illegal variable. Only x, y, z");
        };
    }
}
