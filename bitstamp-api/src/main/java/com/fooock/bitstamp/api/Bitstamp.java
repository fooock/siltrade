package com.fooock.bitstamp.api;

import com.fooock.core.currency.Currency;
import com.fooock.core.exchange.Info;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

/**
 *
 */
public class Bitstamp {

    private final Logger logger = LoggerFactory.getLogger(Bitstamp.class);

    /**
     * Initialize trading with bitstamp exchange
     */
    private void initialize() {
        final BitstampContext bitstampContext = new BitstampContext();

        // Exchange info
        final Info info = bitstampContext.info();
        logger.info("Exchange: {} ({})", info.name(), info.web());

        // Get supported currencies
        final List<Currency> currencies = bitstampContext.currencies();
        logger.info("Found {} currency pairs", currencies.size());
    }

    public static void main(String[] args) throws IOException {
        new Bitstamp().initialize();
    }
}
