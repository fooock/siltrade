package com.fooock.bitstamp.api;

import com.fooock.core.Runner;
import com.fooock.trading.common.ExchangeRunner;

/**
 *
 */
public final class Bitstamp {

    public static void main(String[] args) {
        // Bitstamp context
        final BitstampContext bitstampContext = new BitstampContext();

        // Bitstamp exchange runner
        final Runner exchangeRunner = new ExchangeRunner.Builder(bitstampContext)
                .create();
        exchangeRunner.initialize();
    }
}
