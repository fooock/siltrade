package com.fooock.core;

import com.fooock.core.currency.Currency;

import java.io.IOException;

/**
 *
 */
public interface Context {

    Tick tick(Currency currency) throws IOException;
}
