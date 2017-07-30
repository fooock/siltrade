package com.fooock.poloniex.api;

import com.fooock.core.Tick;
import com.fooock.core.instrument.Instrument;
import org.knowm.xchange.currency.CurrencyPair;

import java.io.IOException;

/**
 *
 */
public final class Poloniex {

    private static final Instrument INSTRUMENT = CurrencyPair.XRP_BTC::toString;

    public static void main(String[] args) throws IOException {
        final PoloniexContext poloniexContext = new PoloniexContext();
        final Tick tick = poloniexContext.tick(INSTRUMENT);

        System.out.println(tick);
    }
}
