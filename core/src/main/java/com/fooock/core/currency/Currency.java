package com.fooock.core.currency;

/**
 *
 */
public final class Currency {

    private final String currencyBase;

    public Currency(String currencyBase) {
        this.currencyBase = currencyBase;
    }

    public String currencyPair() {
        return currencyBase;
    }

    @Override
    public String toString() {
        return currencyBase;
    }
}
