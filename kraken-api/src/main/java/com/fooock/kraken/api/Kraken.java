package com.fooock.kraken.api;

import com.fooock.core.Tick;
import com.fooock.core.currency.Currency;

import java.io.IOException;
import java.util.List;

/**
 *
 */
public final class Kraken {

    public static void main(String[] args) throws IOException {
        final KrakenContext krakenContext = new KrakenContext();

        // Get supported currencies
        final List<Currency> currencies = krakenContext.currencies();
        for (Currency currency : currencies) {
            System.out.println(currency);
        }

        // Get current tick
        final Tick tick = krakenContext.tick(currencies.get(0));
        System.out.println(tick);
    }
}
