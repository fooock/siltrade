package com.fooock.trading.common.mapper;

import com.fooock.core.currency.CurrencyPair;
import com.fooock.core.mapper.Mapper;

/**
 *
 */
public final class XCurrencyPairMapper implements Mapper<CurrencyPair, org.knowm.xchange.currency.CurrencyPair> {

    @Override
    public org.knowm.xchange.currency.CurrencyPair map(CurrencyPair from) {
        return new org.knowm.xchange.currency.CurrencyPair(from.currencyPair());
    }
}
