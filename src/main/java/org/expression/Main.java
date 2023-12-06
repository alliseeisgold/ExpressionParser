package org.expression;

import org.expression.binaryoperations.arithmetic.Add;
import org.expression.binaryoperations.arithmetic.Multiply;
import org.expression.binaryoperations.arithmetic.Subtract;

public class Main {
    public static void main(String[] args) {
        int X = Integer.parseInt(args[0]);
        Variable x = new Variable("x");
        System.out.println(
                new Add(
                        new Subtract(
                                new Multiply(x, x),
                                new Multiply(new Const(2), x)),
                        new Const(1)).evaluate(X)
        );
    }
}