package com.fooock.bitstamp.api;

import com.fooock.core.Runner;
import com.fooock.core.exchange.ExchangeLifecycle;
import com.fooock.trading.common.ExchangeRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 */
public final class Bitstamp implements ExchangeLifecycle {
    private final Logger logger = LoggerFactory.getLogger(Bitstamp.class);

    private void init() {
        // Bitstamp context
        final BitstampContext bitstampContext = new BitstampContext();

        // Bitstamp exchange runner
        final Runner exchangeRunner = new ExchangeRunner.Builder(bitstampContext, this)
                .create();
        exchangeRunner.start();
    }

    @Override
    public void onExchangeError(String msg) {
        logger.error(msg);
    }

    public static void main(String[] args) {
        new Bitstamp().init();
    }
}
