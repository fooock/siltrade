package com.fooock.poloniex.api;

import com.fooock.core.Tick;
import com.fooock.core.currency.Currency;
import org.knowm.xchange.currency.CurrencyPair;

import java.io.IOException;

/**
 *
 */
public final class Poloniex {

    private static final Currency CURRENCY = CurrencyPair.XRP_BTC::toString;

    public static void main(String[] args) throws IOException {
        final PoloniexContext poloniexContext = new PoloniexContext();
        final Tick tick = poloniexContext.tick(CURRENCY);

        System.out.println(tick);
    }
}
