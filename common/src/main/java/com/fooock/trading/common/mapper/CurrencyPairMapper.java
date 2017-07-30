package com.fooock.trading.common.mapper;

import com.fooock.core.currency.Currency;
import com.fooock.core.mapper.Mapper;
import org.knowm.xchange.currency.CurrencyPair;

/**
 *
 */
public final class CurrencyPairMapper implements Mapper<CurrencyPair, Currency> {

    @Override
    public Currency map(CurrencyPair from) {
        return new Currency(from.toString());
    }
}
