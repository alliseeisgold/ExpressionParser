package org.expression.exceptions;

import org.expression.interfaces.GeneralExpression;

public class Main {
    public static void main(String[] args) {
        ExprParserWithExceptions parser = new ExprParserWithExceptions(new StringSource("1000000*x*x*x*x*x/(x-1)"));
        GeneralExpression result = null;
        try {
            result = parser.parseExpression();
        } catch (ParsingException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("x f");
        for (int i = 0; i < 11; i++) {
            try {
                System.out.println(i + " " + result.evaluate(i));
            } catch (OverflowException e) {
                System.out.println(i + " overflow");
            } catch (ZeroDivisionException e) {
                System.out.println(i + " division by zero");
            }
        }
    }
}
