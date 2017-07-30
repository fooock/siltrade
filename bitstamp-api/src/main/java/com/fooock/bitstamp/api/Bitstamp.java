package com.fooock.bitstamp.api;

import com.fooock.core.Tick;
import com.fooock.core.currency.Currency;

import java.io.IOException;
import java.util.List;

/**
 *
 */
public class Bitstamp {

    public static void main(String[] args) throws IOException {
        final BitstampContext bitstampContext = new BitstampContext();

        // Get supported currencies
        final List<Currency> currencies = bitstampContext.currencies();
        for (Currency currency : currencies) {
            System.out.println(currency);
        }

        // Get current tick
        final Tick tick = bitstampContext.tick(currencies.get(0));
        System.out.println(tick);
    }
}
