package com.fooock.core.account;

import com.fooock.core.Number;

import java.util.List;

/**
 *
 */
public final class Account {

    private final String name;
    private final Number tradingFee;
    private final List<Wallet> wallets;

    public Account(String name, Number tradingFee, List<Wallet> wallets) {
        this.name = name;
        this.tradingFee = tradingFee;
        this.wallets = wallets;
    }

    public String name() {
        return name;
    }

    public Number tradingFee() {
        return tradingFee;
    }

    public List<Wallet> wallets() {
        return wallets;
    }
}
