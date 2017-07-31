package com.fooock.core.currency;

/**
 *
 */
public final class Currency {

    private final String name;
    private final String symbol;
    private final String code;

    public Currency(String displayName, String symbol, String currencyCode) {
        this.name = displayName;
        this.symbol = symbol;
        this.code = currencyCode;
    }

    public String name() {
        return name;
    }

    public String symbol() {
        return symbol;
    }

    public String code() {
        return code;
    }
}
