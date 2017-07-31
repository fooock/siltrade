package com.fooock.core.account;

import java.util.List;

/**
 *
 */
public final class Wallet {

    private final String id;
    private final String name;
    private final List<Balance> balances;

    public Wallet(String id, String name, List<Balance> balances) {
        this.id = id;
        this.name = name;
        this.balances = balances;
    }

    public String id() {
        return id;
    }

    public String name() {
        return name;
    }

    public List<Balance> balances() {
        return balances;
    }
}
