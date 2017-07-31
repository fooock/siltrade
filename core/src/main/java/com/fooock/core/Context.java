package com.fooock.core;

import com.fooock.core.account.Account;
import com.fooock.core.currency.Currency;
import com.fooock.core.exchange.Info;

import java.io.IOException;
import java.util.List;

/**
 *
 */
public interface Context {

    Info info();

    Tick tick(Currency currency) throws IOException;

    List<Currency> currencies();

    Account account() throws IOException;
}
