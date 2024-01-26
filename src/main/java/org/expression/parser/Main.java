package org.expression.parser;

import org.expression.interfaces.GeneralExpression;

public class Main {
    public static void main(String[] args) {
        ExpressionParser parser = new ExpressionParser(new StringSource("x* (x - 2)*x + 1"));
        GeneralExpression result = parser.parseExpression();
        System.out.println(result.evaluate(5));
    }
}
