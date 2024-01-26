package org.expression.parser;

import org.expression.Const;
import org.expression.Variable;
import org.expression.binaryoperations.arithmetic.Add;
import org.expression.binaryoperations.arithmetic.Divide;
import org.expression.binaryoperations.arithmetic.Multiply;
import org.expression.binaryoperations.arithmetic.Subtract;
import org.expression.binaryoperations.bitwise.BitwiseAnd;
import org.expression.binaryoperations.bitwise.BitwiseOr;
import org.expression.binaryoperations.bitwise.BitwiseXor;
import org.expression.interfaces.GeneralExpression;
import org.expression.interfaces.ThreeVariableExpr;
import org.expression.opinfo.*;
import org.expression.unaryoperations.UnaryMinus;

public class ExpressionParser extends Parser implements TripleParser {
    private final int start = OperationsInformation.getStart();
    private final int step = OperationsInformation.getStep();

    public ExpressionParser(StringSource source) {
        super(source);
    }

    public ExpressionParser() {
        super();
    }

    private GeneralExpression parseConst(boolean isNegative) {
        StringBuilder base = new StringBuilder();
        if (isNegative) {
            base.append('-');
        }
        getNumber(base);
        try {
            return new Const(Integer.parseInt(base.toString()));
        } catch (NumberFormatException e) {
            throw new AssertionError("Invalid number: " + base);
        }
    }

    private GeneralExpression parseVariable() {
        skipWhiteSpaces();
        String variable = Character.toString(symbol);
        nextSymbol();
        return new Variable(variable);
    }

    private Operations getBinaryOperator(int priority) {
        skipWhiteSpaces();
        for (Operations operation : OperationsInformation.getOperationFromPriority(priority)) {
            char operator = OperationsInformation.getBinaryOperator(operation);
            if (isExpected(operator)) {
                return operation;
            }
        }
        return null;
    }

    private GeneralExpression makeBinaryOperation(GeneralExpression first, GeneralExpression second, Operations operation) {
        return switch (operation) {
            case ADD -> new Add(first, second);
            case SUB -> new Subtract(first, second);
            case MUL -> new Multiply(first, second);
            case DIV -> new Divide(first, second);
            case AND -> new BitwiseAnd(first, second);
            case XOR -> new BitwiseXor(first, second);
            case OR -> new BitwiseOr(first, second);
            default -> null;
        };
    }

    private GeneralExpression parseExpressionPart(int priority) {
        skipWhiteSpaces();

        if (priority == OperationsInformation.getPriority(Operations.CONST)) {
            return parseValue();
        }
        GeneralExpression parsed = parseExpressionPart(priority + step);
        for (; ; ) {
            Operations current = getBinaryOperator(priority);

            if (current == null) {
                return parsed;
            }
            parsed = makeBinaryOperation(parsed, parseExpressionPart(priority + step), current);
        }
    }

    public GeneralExpression parseExpression() {
        skipWhiteSpaces();
        return parseExpressionPart(start);
    }

    private GeneralExpression parseValue() {
        skipWhiteSpaces();
        if (isInInterval('0', '9')) {
            return parseConst(false);
        } else if (isExpected('-')) {
            if (isInInterval('0', '9')) {
                return parseConst(true);
            }
            return new UnaryMinus(parseValue());
        } else if (isExpected('(')) {
            GeneralExpression parsed = parseExpression();
            skipWhiteSpaces();
            expect(')');
            return parsed;
        } else {
            return parseVariable();
        }
    }

    @Override
    public ThreeVariableExpr parse(String expression) throws Exception {
        return null;
    }
}

