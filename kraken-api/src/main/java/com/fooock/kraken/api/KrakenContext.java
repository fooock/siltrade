package com.fooock.kraken.api;

import com.fooock.trading.common.ExchangeContext;
import org.knowm.xchange.kraken.KrakenExchange;

/**
 *
 */
final class KrakenContext extends ExchangeContext {

    KrakenContext() {
        super(KrakenExchange.class.getName());
    }
}
