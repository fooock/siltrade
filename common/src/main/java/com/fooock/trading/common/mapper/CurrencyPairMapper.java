package com.fooock.trading.common.mapper;

import com.fooock.core.currency.CurrencyPair;
import com.fooock.core.mapper.Mapper;

/**
 *
 */
public final class CurrencyPairMapper implements Mapper<org.knowm.xchange.currency.CurrencyPair, CurrencyPair> {

    @Override
    public CurrencyPair map(org.knowm.xchange.currency.CurrencyPair from) {
        return new CurrencyPair(from.toString());
    }
}
