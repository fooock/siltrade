package com.fooock.poloniex.api;

import com.fooock.trading.common.ExchangeContext;
import org.knowm.xchange.poloniex.PoloniexExchange;

/**
 *
 */
final class PoloniexContext extends ExchangeContext {

    PoloniexContext() {
        super(PoloniexExchange.class.getName());
    }
}
