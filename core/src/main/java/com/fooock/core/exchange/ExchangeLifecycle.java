package com.fooock.core.exchange;

/**
 *
 */
public interface ExchangeLifecycle {

    /**
     * Called when the system can't start or a critical error occurs
     */
    void onExchangeError(String msg);
}
