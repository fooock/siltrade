package com.fooock.trading.common.mapper;

import com.fooock.core.account.Wallet;
import com.fooock.core.mapper.Mapper;
import org.knowm.xchange.currency.Currency;
import org.knowm.xchange.dto.account.Balance;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 */
public final class WalletMapper implements Mapper<org.knowm.xchange.dto.account.Wallet, Wallet> {

    private final BalanceMapper balanceMapper = new BalanceMapper();

    @Override
    public Wallet map(org.knowm.xchange.dto.account.Wallet from) {
        final String id = from.getId();
        final String name = from.getName();
        final Map<Currency, Balance> balances = from.getBalances();
        final List<com.fooock.core.account.Balance> bs = new ArrayList<>(balances.size());
        for (Map.Entry<Currency, Balance> entry : balances.entrySet()) {
            final Balance value = entry.getValue();
            bs.add(balanceMapper.map(value));
        }
        return new Wallet(id, name, bs);
    }
}
