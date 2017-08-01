package com.fooock.kraken.api;

import com.fooock.core.Runner;
import com.fooock.core.exchange.ExchangeLifecycle;
import com.fooock.trading.common.ExchangeRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 */
public final class Kraken implements ExchangeLifecycle {
    private final Logger logger = LoggerFactory.getLogger(Kraken.class);

    private void init() {
        // Kraken context
        final KrakenContext krakenContext = new KrakenContext();

        // Kraken exchange runner
        final Runner exchangeRunner = new ExchangeRunner.Builder(krakenContext, this)
                .create();
        exchangeRunner.start();
    }

    @Override
    public void onExchangeError(String msg) {
        logger.error(msg);
    }

    public static void main(String[] args) {
        new Kraken().init();
    }
}
