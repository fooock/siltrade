package com.fooock.bitstamp.api;

import com.fooock.trading.common.ExchangeContext;
import org.knowm.xchange.bitstamp.BitstampExchange;

/**
 *
 */
final class BitstampContext extends ExchangeContext {

    BitstampContext() {
        super(BitstampExchange.class.getName());
    }
}
