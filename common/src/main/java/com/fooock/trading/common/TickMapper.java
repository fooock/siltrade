package com.fooock.trading.common;

import com.fooock.core.Number;
import com.fooock.core.Tick;
import com.fooock.core.Time;
import com.fooock.core.mapper.Mapper;
import org.knowm.xchange.dto.marketdata.Ticker;

/**
 *
 */
public final class TickMapper implements Mapper<Ticker, Tick> {

    @Override
    public Tick map(Ticker from) {
        final Time time = new Time(from.getTimestamp());
        final Number open = new Number(from.getBid().toString());
        final Number high = new Number(from.getHigh().toString());
        final Number low = new Number(from.getLow().toString());
        final Number close = new Number(from.getAsk().toString());
        final Number volume = new Number(from.getVolume().toString());
        return new Tick(time, open, high, low, close, volume);
    }
}
