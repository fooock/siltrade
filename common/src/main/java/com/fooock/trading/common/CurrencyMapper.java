package com.fooock.trading.common;

import com.fooock.core.instrument.Instrument;
import com.fooock.core.mapper.Mapper;
import org.knowm.xchange.currency.CurrencyPair;

/**
 *
 */
public final class CurrencyMapper implements Mapper<Instrument, CurrencyPair> {

    @Override
    public CurrencyPair map(Instrument from) {
        return new CurrencyPair(from.currencyPair());
    }
}
