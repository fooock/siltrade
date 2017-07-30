package com.fooock.kraken.api;

import com.fooock.core.Tick;
import com.fooock.core.currency.Currency;
import com.fooock.core.exchange.Info;

import java.io.IOException;
import java.util.List;

/**
 *
 */
public final class Kraken {

    public static void main(String[] args) throws IOException {
        final KrakenContext krakenContext = new KrakenContext();

        // Exchange info
        final Info info = krakenContext.info();
        System.out.println(info);

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
