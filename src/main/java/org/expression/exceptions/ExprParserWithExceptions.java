package org.expression.exceptions;

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
import org.expression.opinfo.Operations;
import org.expression.opinfo.OperationsInformation;
import org.expression.parser.TripleParser;
import org.expression.unaryoperations.UnaryMinus;

public class ExprParserWithExceptions extends MainParser implements TripleParser {
    private final int start = OperationsInformation.getStart();
    private final int step = OperationsInformation.getStep();

    public ExprParserWithExceptions(StringSource stringSource) {
        super(stringSource);
    }

    public ExprParserWithExceptions() {
        super();
    }

    private GeneralExpression parseConst(boolean isNegative) throws ParsingException {
        StringBuilder base = new StringBuilder();
        if (isNegative) {
            base.append('-');
        }
        getNumber(base);
        try {
            return new Const(Integer.parseInt(base.toString()));
        } catch (NumberFormatException e) {
            throw new IllegalConstException(base.toString());
        }
    }

    private GeneralExpression parseVariable(String variable) throws InvalidVariableException, MissedVariableException {
        if (OperationsInformation.isVariable(variable)) {
            return new Variable(variable);
        }
        if (variable.isEmpty()) {
            throw new MissedVariableException(source.getInformation());
        }
        throw new InvalidVariableException(variable, source.getInformation());
    }

    protected String parseOperationOrValue() {
        StringBuilder parsed = new StringBuilder();
        while (isInInterval('0', '9') || isInInterval('A', 'z')) {
            parsed.append(symbol);
            nextSymbol();
        }
        return parsed.toString();
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
            case ADD -> new AddWithException(first, second);
            case SUB -> new SubtractWithException(first, second);
            case MUL -> new MultiplyWithException(first, second);
            case DIV -> new DivideWithExceptions(first, second);
            case AND -> new BitwiseAnd(first, second);
            case XOR -> new BitwiseXor(first, second);
            case OR -> new BitwiseOr(first, second);
            default -> null;
        };
    }

    private GeneralExpression parseExpressionPart(int priority) throws ParsingException {
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

    public GeneralExpression parseExpression() throws ParsingException {
        skipWhiteSpaces();
        return parseExpressionPart(start);
    }

    private GeneralExpression parseValue() throws ParsingException {
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
            if (!expect(')')) {
                throw new MissedCloseParenthesis(source.getInformation());
            }
            return parsed;
        } else {
            String parsed = parseOperationOrValue();
            Operations operation = OperationsInformation.getUnaryOperation(parsed);
            if (operation != null)
                switch (operation) {
                    case SQRT:
                        return new SqrtWithException(parseValue());
                    case ABS:
                        return new AbsWithException(parseValue());
                }
            return parseVariable(parsed);
        }
    }

    @Override
    public ThreeVariableExpr parse(String expression) throws ParsingException {
        changeSource(new StringSource(expression));
        ThreeVariableExpr expr = parseExpression();
        if (!hasNext()) {
            return expr;
        }
        throw new MissedOpenParenthesis(source.getInformation());
    }

}
