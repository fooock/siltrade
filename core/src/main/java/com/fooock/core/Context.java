package com.fooock.core;

import com.fooock.core.currency.Currency;

import java.io.IOException;
import java.util.List;

/**
 *
 */
public interface Context {

    Tick tick(Currency currency) throws IOException;

    List<Currency> currencies();
}
