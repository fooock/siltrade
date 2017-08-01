package com.fooock.poloniex.api;

import com.fooock.core.Runner;
import com.fooock.core.exchange.ExchangeLifecycle;
import com.fooock.trading.common.ExchangeRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 */
public final class Poloniex implements ExchangeLifecycle {
    private final Logger logger = LoggerFactory.getLogger(Poloniex.class);

    private void init() {
        // Poloniex context
        final PoloniexContext poloniexContext = new PoloniexContext();

        // Poloniex exchange runner
        final Runner exchangeRunner = new ExchangeRunner.Builder(poloniexContext, this)
                .create();
        exchangeRunner.start();
    }

    @Override
    public void onExchangeError(String msg) {
        logger.error(msg);
    }

    public static void main(String[] args) {
        new Poloniex().init();
    }
}
