package com.fooock.trading.common;

import com.fooock.core.Context;
import com.fooock.core.Runner;
import com.fooock.core.currency.CurrencyPair;
import com.fooock.core.exchange.Info;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 *
 */
public final class ExchangeRunner implements Runner {
    private final Logger logger = LoggerFactory.getLogger(ExchangeRunner.class);

    private final Context context;

    /**
     * Create this object
     *
     * @param builder Runner builder
     */
    private ExchangeRunner(Builder builder) {
        this.context = builder.context;
    }

    /**
     * Initialize trading with bitstamp exchange
     */
    @Override
    public void initialize() {
        // Exchange info
        final Info info = context.info();
        logger.info("Initialize exchange: {} ({})", info.name(), info.web());

        // Get supported currencies
        final List<CurrencyPair> currencies = context.currencies();
        logger.info("Found {} currency pairs", currencies.size());
    }

    @Override
    public Context context() {
        return context;
    }

    /**
     * Builder to create {@link Runner}s
     */
    public static final class Builder {

        private final Context context;

        public Builder(Context context) {
            this.context = context;
        }

        public Runner create() {
            return new ExchangeRunner(this);
        }
    }
}
