package com.fooock.trading.common.mapper;

import com.fooock.core.currency.Currency;
import com.fooock.core.mapper.Mapper;
import org.knowm.xchange.currency.CurrencyPair;

/**
 *
 */
public final class CurrencyMapper implements Mapper<Currency, CurrencyPair> {

    @Override
    public CurrencyPair map(Currency from) {
        return new CurrencyPair(from.currencyPair());
    }
}
