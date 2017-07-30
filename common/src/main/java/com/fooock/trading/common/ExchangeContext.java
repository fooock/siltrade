package com.fooock.trading.common;

import com.fooock.core.Context;
import com.fooock.core.Tick;
import com.fooock.core.currency.Currency;
import com.fooock.core.exchange.Info;
import com.fooock.trading.common.mapper.CurrencyMapper;
import com.fooock.trading.common.mapper.CurrencyPairMapper;
import com.fooock.trading.common.mapper.TickMapper;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeFactory;
import org.knowm.xchange.ExchangeSpecification;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.service.marketdata.MarketDataService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public abstract class ExchangeContext implements Context {

    private final Exchange exchange;
    private final MarketDataService marketDataService;

    private final CurrencyMapper currencyMapper = new CurrencyMapper();
    private final CurrencyPairMapper currencyPairMapper = new CurrencyPairMapper();
    private final TickMapper tickMapper = new TickMapper();

    protected ExchangeContext(String exchangeName) {
        exchange = ExchangeFactory.INSTANCE
                .createExchange(exchangeName);
        marketDataService = exchange.getMarketDataService();
    }

    @Override
    public Info info() {
        final ExchangeSpecification specification = exchange.getDefaultExchangeSpecification();
        return new Info(specification.getExchangeName(),
                specification.getExchangeDescription(), specification.getHost());
    }

    @Override
    public Tick tick(Currency currency) throws IOException {
        final Ticker ticker = marketDataService.getTicker(currencyMapper.map(currency));
        return tickMapper.map(ticker);
    }

    @Override
    public List<Currency> currencies() {
        final List<CurrencyPair> exchangeSymbols = exchange.getExchangeSymbols();
        final List<Currency> currencies = new ArrayList<>(exchangeSymbols.size());
        for (CurrencyPair exchangeSymbol : exchangeSymbols) {
            currencies.add(currencyPairMapper.map(exchangeSymbol));
        }
        return currencies;
    }
}
