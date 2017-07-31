package com.fooock.kraken.api;

import com.fooock.core.Runner;
import com.fooock.trading.common.ExchangeRunner;

/**
 *
 */
public final class Kraken {

    public static void main(String[] args) {
        // Kraken context
        final KrakenContext krakenContext = new KrakenContext();

        // Kraken exchange runner
        final Runner exchangeRunner = new ExchangeRunner.Builder(krakenContext)
                .create();
        exchangeRunner.initialize();
    }
}
