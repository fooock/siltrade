package com.fooock.core.currency;

/**
 *
 */
public final class CurrencyPair {

    private final String currencyBase;

    public CurrencyPair(String currencyBase) {
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
