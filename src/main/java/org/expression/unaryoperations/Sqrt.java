package org.expression.unaryoperations;


import org.expression.interfaces.GeneralExpression;

public class Sqrt extends UnaryOperation {
    private Sqrt(GeneralExpression first) {
        super(first);
    }

    @Override
    protected int operationResult(int x) {
        if (x == 1) {
            return x;
        }
        int left = 1;
        int right = x / 2;
        while (right >= left) {
            int mid = left + (right - left) / 2;
            if (mid == x / mid) {
                return mid;
            }
            if (mid < x / mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left - 1;
    }

    @Override
    protected String getOperationString() {
        return "sqrt";
    }
}
