package com.fooock.trading.common;

import com.fooock.core.Context;
import com.fooock.core.Tick;
import com.fooock.core.currency.Currency;
import com.fooock.trading.common.mapper.CurrencyMapper;
import com.fooock.trading.common.mapper.TickMapper;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeFactory;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.service.marketdata.MarketDataService;

import java.io.IOException;

/**
 *
 */
public abstract class ExchangeContext implements Context {

    private final MarketDataService marketDataService;
    private final CurrencyMapper currencyMapper = new CurrencyMapper();
    private final TickMapper tickMapper = new TickMapper();

    protected ExchangeContext(String exchangeName) {
        final Exchange exchange = ExchangeFactory.INSTANCE
                .createExchange(exchangeName);
        marketDataService = exchange.getMarketDataService();
    }

    @Override
    public Tick tick(Currency currency) throws IOException {
        final Ticker ticker = marketDataService.getTicker(currencyMapper.map(currency));
        return tickMapper.map(ticker);
    }
}
