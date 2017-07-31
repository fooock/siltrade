package com.fooock.trading.common.mapper;

import com.fooock.core.mapper.Mapper;
import org.knowm.xchange.currency.Currency;

/**
 *
 */
public final class CurrencyMapper implements Mapper<Currency, com.fooock.core.currency.Currency> {

    @Override
    public com.fooock.core.currency.Currency map(Currency from) {
        final String currencyCode = from.getCurrencyCode();
        final String displayName = from.getDisplayName();
        final String symbol = from.getSymbol();
        return new com.fooock.core.currency.Currency(displayName, symbol, currencyCode);
    }
}
