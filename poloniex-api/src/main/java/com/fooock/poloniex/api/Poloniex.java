package com.fooock.poloniex.api;

import com.fooock.core.currency.Currency;
import com.fooock.core.exchange.Info;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 *
 */
public final class Poloniex {

    private final Logger logger = LoggerFactory.getLogger(Poloniex.class);

    /**
     * Initialize trading with poloniex exchange
     */
    private void initialize() {
        final PoloniexContext poloniexContext = new PoloniexContext();

        // Exchange info
        final Info info = poloniexContext.info();
        logger.info("Initialize exchange: {} ({})", info.name(), info.web());

        // Get supported currencies
        final List<Currency> currencies = poloniexContext.currencies();
        logger.info("Found {} currency pairs", currencies.size());
    }

    public static void main(String[] args) {
        new Poloniex().initialize();
    }
}
