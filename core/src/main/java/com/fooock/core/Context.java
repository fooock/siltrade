package com.fooock.core;

import com.fooock.core.instrument.Instrument;

import java.io.IOException;

/**
 *
 */
public interface Context {

    Tick tick(Instrument instrument) throws IOException;
}
