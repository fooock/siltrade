package com.fooock.trading.common;

import com.fooock.core.Context;
import com.fooock.core.Runner;
import com.fooock.core.currency.CurrencyPair;
import com.fooock.core.exchange.ExchangeLifecycle;
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
    private final ExchangeLifecycle exchangeLifecycle;

    /**
     * Create this object
     *
     * @param builder Runner builder
     */
    private ExchangeRunner(Builder builder) {
        this.context = builder.context;
        this.exchangeLifecycle = builder.exchangeLifecycle;
    }

    /**
     * Initialize trading with bitstamp exchange
     */
    @Override
    public void start() {
        // Exchange info
        final Info info = context.info();
        logger.info("Initialize exchange: {} ({})", info.name(), info.web());

        // Get supported currencies
        final List<CurrencyPair> currencies = context.currencies();
        if (currencies == null || currencies.isEmpty()) {
            // Can't start the bot, no currencies to trade!
            exchangeLifecycle.onExchangeError("No currency pair found to trade, aborting!");
            return;
        }
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
        private final ExchangeLifecycle exchangeLifecycle;

        public Builder(Context context, ExchangeLifecycle exchangeLifecycle) {
            this.context = context;
            this.exchangeLifecycle = exchangeLifecycle;
        }

        public Runner create() {
            return new ExchangeRunner(this);
        }
    }
}
