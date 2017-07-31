package com.fooock.trading.common.mapper;

import com.fooock.core.Number;
import com.fooock.core.account.Account;
import com.fooock.core.mapper.Mapper;
import org.knowm.xchange.dto.account.AccountInfo;
import org.knowm.xchange.dto.account.Wallet;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class AccountInfoMapper implements Mapper<AccountInfo, Account> {

    private final WalletMapper walletMapper = new WalletMapper();

    @Override
    public Account map(AccountInfo from) {
        final BigDecimal tradingFee = from.getTradingFee();
        final String username = from.getUsername();
        final Map<String, Wallet> wallets = from.getWallets();
        final List<com.fooock.core.account.Wallet> ws = new ArrayList<>(wallets.size());
        for (Map.Entry<String, Wallet> entry : wallets.entrySet()) {
            final Wallet wallet = entry.getValue();
            ws.add(walletMapper.map(wallet));
        }
        return new Account(username, new Number(tradingFee.toString()), ws);
    }
}
