package org.expression.opinfo;

import java.util.List;

public class OperationsInformation {
    private static final int start = 5;
    private static final int step = -1;

    public static int getStart() {
        return start;
    }

    public static int getStep() {
        return step;
    }

    public static int getPriority(Operations operation) {
        return switch (operation) {
            case OR -> start;
            case XOR -> start + step;
            case AND -> start + 2 * step;
            case ADD, SUB -> start + 3 * step;
            case MUL, DIV -> start + 4 * step;
            case SQRT, ABS, VAR, CONST -> start + 5 * step;
            default -> start + 6 * step;
        };
    }

    public static boolean isVariable(String variable) {
        return switch (variable) {
            case "x", "y", "z" -> true;
            default -> false;
        };
    }

    public static List<Operations> getOperationFromPriority(int priority) {
        return switch (priority) {
            case start -> List.of(Operations.OR);
            case start + step -> List.of(Operations.XOR);
            case start + 2 * step -> List.of(Operations.AND);
            case start + 3 * step -> List.of(Operations.ADD, Operations.SUB);
            case start + 4 * step -> List.of(Operations.MUL, Operations.DIV);
            default -> null;
        };
    }

    public static char getBinaryOperator(Operations operation) {
        return switch (operation) {
            case OR -> '|';
            case XOR -> '^';
            case AND -> '&';
            case ADD -> '+';
            case SUB -> '-';
            case MUL -> '*';
            case DIV -> '/';
            default -> '\0';
        };
    }

    public static Operations getUnaryOperation(String operator) {
        return switch (operator) {
            case "abs" -> Operations.ABS;
            case "sqrt" -> Operations.SQRT;
            default -> null;
        };
    }
}
