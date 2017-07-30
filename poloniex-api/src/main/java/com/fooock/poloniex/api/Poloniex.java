package com.fooock.poloniex.api;

import com.fooock.core.Tick;
import com.fooock.core.currency.Currency;
import com.fooock.core.exchange.Info;

import java.io.IOException;
import java.util.List;

/**
 *
 */
public final class Poloniex {

    public static void main(String[] args) throws IOException {
        final PoloniexContext poloniexContext = new PoloniexContext();

        // Exchange info
        final Info info = poloniexContext.info();
        System.out.println(info);

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
