package com.fooock.poloniex.api;

import com.fooock.core.Runner;
import com.fooock.trading.common.ExchangeRunner;

/**
 *
 */
public final class Poloniex {

    public static void main(String[] args) {
        // Poloniex context
        final PoloniexContext poloniexContext = new PoloniexContext();

        // Poloniex exchange runner
        final Runner exchangeRunner = new ExchangeRunner.Builder(poloniexContext)
                .create();
        exchangeRunner.initialize();
    }
}
