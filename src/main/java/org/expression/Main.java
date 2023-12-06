package org.expression;

import org.expression.binaryoperations.Multiply;
import org.expression.binaryoperations.Subtract;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Subtract(
                new Multiply(
                        new Const(2),
                        new Variable("x")
                ),
                new Const(3)
        ).toString());
        System.out.println(new Multiply(new Const(2), new Variable("x"))
                .equals(new Multiply(new Const(2), new Variable("x"))));
    }
}