package org.expression.exceptions;

public class MainParser {
    protected char symbol;
    protected GeneralSourceWithException source;
    protected final char EOF = '\0';

    public MainParser() {
    }

    public MainParser(GeneralSourceWithException source) {
        this.source = source;
        nextSymbol();
    }

    public void changeSource(GeneralSourceWithException source) {
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

    protected boolean expect(final char expected) {
        if (symbol != expected) {
            return false;
        }
        nextSymbol();
        return true;
    }

    protected boolean isInInterval(char start, char end) {
        return symbol >= start && symbol <= end;
    }

    protected void getNumber(StringBuilder base) throws ParsingException {
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
