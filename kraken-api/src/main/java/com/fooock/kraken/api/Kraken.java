package com.fooock.kraken.api;

import com.fooock.core.currency.Currency;
import com.fooock.core.exchange.Info;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 *
 */
public final class Kraken {

    private final Logger logger = LoggerFactory.getLogger(Kraken.class);

    /**
     * Initialize trading with kraken exchange
     */
    private void initialize() {
        final KrakenContext krakenContext = new KrakenContext();

        // Exchange info
        final Info info = krakenContext.info();
        logger.info("Initialize exchange: {} ({})", info.name(), info.web());

        // Get supported currencies
        final List<Currency> currencies = krakenContext.currencies();
        logger.info("Found {} currency pairs", currencies.size());
    }

    public static void main(String[] args) {
        new Kraken().initialize();
    }
}
