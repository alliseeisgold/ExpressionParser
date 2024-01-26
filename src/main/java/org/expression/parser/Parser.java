package org.expression.parser;

public class Parser {
    protected char symbol;
    private GeneralSource source;
    protected final char EOF = '\0';

    public Parser() {
    }

    public Parser(GeneralSource source) {
        this.source = source;
        nextSymbol();
    }

    public void changeSource(GeneralSource source) {
        this.source = source;
        nextSymbol();
    }

    protected void nextSymbol() {
        symbol = source.hasNext() ? source.nextSymbol() : EOF;
    }

    protected boolean hasNext() {
        return symbol != EOF;
    }

    protected boolean isExpected(char expected) {
        if (symbol != expected) {
            return false;
        }
        nextSymbol();
        return true;
    }

    protected void expect(final char expected) {
        if (symbol != expected) {
            throw source.exception("Expected '" + expected + "', found '" + symbol + "'");
        }
        nextSymbol();
    }

    protected boolean isInInterval(char start, char end) {
        return symbol >= start && symbol <= end;
    }

    protected void getNumber(StringBuilder base) {
        if (isExpected('-')) {
            base.append('-');
        }
        if (isExpected('0')) {
            base.append('0');
        } else if (isInInterval('1', '9')) {
            while (isInInterval('0', '9')) {
                base.append(symbol);
                nextSymbol();
            }
        } else {
            throw source.exception("Invalid number");
        }
    }

    protected void skipWhiteSpaces() {
        for (; ; ) {
            if (!(isExpected(' ') || isExpected('\r') || isExpected('\n') || isExpected('\t'))) {
                break;
            }
            // skip
        }
    }
}
