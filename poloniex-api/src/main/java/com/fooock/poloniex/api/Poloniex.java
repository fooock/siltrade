package com.fooock.poloniex.api;

import com.fooock.core.Tick;
import com.fooock.core.currency.Currency;

import java.io.IOException;
import java.util.List;

/**
 *
 */
public final class Poloniex {

    public static void main(String[] args) throws IOException {
        final PoloniexContext poloniexContext = new PoloniexContext();

        // Get supported currencies
        final List<Currency> currencies = poloniexContext.currencies();
        for (Currency currency : currencies) {
            System.out.println(currency);
        }

        // Get current tick
        final Tick tick = poloniexContext.tick(currencies.get(0));
        System.out.println(tick);
    }
}
