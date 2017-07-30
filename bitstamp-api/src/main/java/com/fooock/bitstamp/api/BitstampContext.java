package com.fooock.bitstamp.api;

import com.fooock.core.Context;
import com.fooock.core.Tick;
import com.fooock.core.instrument.Instrument;
import com.fooock.trading.common.CurrencyMapper;
import com.fooock.trading.common.TickMapper;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeFactory;
import org.knowm.xchange.bitstamp.BitstampExchange;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.service.marketdata.MarketDataService;

import java.io.IOException;

/**
 *
 */
final class BitstampContext implements Context {

    private final MarketDataService marketDataService;
    private final CurrencyMapper currencyMapper = new CurrencyMapper();
    private final TickMapper tickMapper = new TickMapper();

    BitstampContext() {
        final Exchange exchange = ExchangeFactory.INSTANCE
                .createExchange(BitstampExchange.class.getName());
        marketDataService = exchange.getMarketDataService();
    }

    @Override
    public Tick tick(Instrument instrument) throws IOException {
        final Ticker ticker = marketDataService.getTicker(currencyMapper.map(instrument));
        return tickMapper.map(ticker);
    }
}
