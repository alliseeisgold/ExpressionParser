package org.expression;

public interface ToMiniString {
    default String toMiniString() {
        return toString();
    }
}
