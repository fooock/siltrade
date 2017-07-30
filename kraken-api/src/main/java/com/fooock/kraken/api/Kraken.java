package com.fooock.kraken.api;

import com.fooock.core.Tick;
import com.fooock.core.instrument.Instrument;
import org.knowm.xchange.currency.CurrencyPair;

import java.io.IOException;

/**
 *
 */
public final class Kraken {

    private static final Instrument INSTRUMENT = CurrencyPair.BTC_USD::toString;

    public static void main(String[] args) throws IOException {
        final KrakenContext krakenContext = new KrakenContext();
        final Tick tick = krakenContext.tick(INSTRUMENT);

        System.out.println(tick);
    }
}
