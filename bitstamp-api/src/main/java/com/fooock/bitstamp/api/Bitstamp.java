package com.fooock.bitstamp.api;

import com.fooock.core.Tick;
import com.fooock.core.instrument.Instrument;
import org.knowm.xchange.currency.CurrencyPair;

import java.io.IOException;

/**
 *
 */
public class Bitstamp {

    private static final Instrument INSTRUMENT = CurrencyPair.BTC_USD::toString;

    public static void main(String[] args) throws IOException {
        final BitstampContext bitstampContext = new BitstampContext();
        final Tick tick = bitstampContext.tick(INSTRUMENT);

        System.out.println(tick);
    }
}
