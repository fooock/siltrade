package com.fooock.trading.common;

import com.fooock.core.Context;
import com.fooock.core.Tick;
import com.fooock.core.account.Account;
import com.fooock.core.currency.CurrencyPair;
import com.fooock.core.exchange.Info;
import com.fooock.trading.common.mapper.AccountInfoMapper;
import com.fooock.trading.common.mapper.CurrencyPairMapper;
import com.fooock.trading.common.mapper.TickMapper;
import com.fooock.trading.common.mapper.XCurrencyPairMapper;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeFactory;
import org.knowm.xchange.ExchangeSpecification;
import org.knowm.xchange.dto.account.AccountInfo;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.service.account.AccountService;
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
    private final AccountService accountService;

    private final XCurrencyPairMapper currencyMapper = new XCurrencyPairMapper();
    private final CurrencyPairMapper currencyPairMapper = new CurrencyPairMapper();
    private final TickMapper tickMapper = new TickMapper();
    private final AccountInfoMapper accountInfoMapper = new AccountInfoMapper();

    /**
     * Base class to start all exchanges
     *
     * @param exchangeName Exchange class name
     */
    protected ExchangeContext(String exchangeName) {
        exchange = ExchangeFactory.INSTANCE.createExchange(exchangeName);
        marketDataService = exchange.getMarketDataService();
        accountService = exchange.getAccountService();
    }

    @Override
    public Info info() {
        final ExchangeSpecification sp = exchange.getDefaultExchangeSpecification();
        return new Info(sp.getExchangeName(), sp.getExchangeDescription(), sp.getHost());
    }

    @Override
    public Tick tick(CurrencyPair currencyPair) throws IOException {
        final Ticker ticker = marketDataService.getTicker(currencyMapper.map(currencyPair));
        if (ticker == null) {
            throw new IOException(String.format(
                    "Tick not available for currencyPair %s in exchange %s", currencyPair.currencyPair(), info().name()));
        }
        return tickMapper.map(ticker);
    }

    @Override
    public List<CurrencyPair> currencies() {
        final List<org.knowm.xchange.currency.CurrencyPair> exchangeSymbols = exchange.getExchangeSymbols();
        final List<CurrencyPair> currencies = new ArrayList<>(exchangeSymbols.size());
        for (org.knowm.xchange.currency.CurrencyPair exchangeSymbol : exchangeSymbols) {
            currencies.add(currencyPairMapper.map(exchangeSymbol));
        }
        return currencies;
    }

    @Override
    public Account account() throws IOException {
        final AccountInfo accountInfo = accountService.getAccountInfo();
        if (accountInfo == null) {
            throw new IOException(String.format("Account for exchange %s not found", info().name()));
        }
        return accountInfoMapper.map(accountInfo);
    }
}
