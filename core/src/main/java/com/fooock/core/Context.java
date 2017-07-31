package com.fooock.core;

import com.fooock.core.account.Account;
import com.fooock.core.currency.CurrencyPair;
import com.fooock.core.exchange.Info;

import java.io.IOException;
import java.util.List;

/**
 *
 */
public interface Context {

    Info info();

    Tick tick(CurrencyPair currencyPair) throws IOException;

    List<CurrencyPair> currencies();

    Account account() throws IOException;
}
