package com.fooock.bitstamp.api;

import com.fooock.core.Tick;
import com.fooock.core.currency.Currency;
import org.knowm.xchange.currency.CurrencyPair;

import java.io.IOException;

/**
 *
 */
public class Bitstamp {

    private static final Currency CURRENCY = CurrencyPair.BTC_USD::toString;

    public static void main(String[] args) throws IOException {
        final BitstampContext bitstampContext = new BitstampContext();
        final Tick tick = bitstampContext.tick(CURRENCY);

        System.out.println(tick);
    }
}
