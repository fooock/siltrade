package com.fooock.trading.common.mapper;

import com.fooock.core.Number;
import com.fooock.core.mapper.Mapper;
import org.knowm.xchange.currency.Currency;
import org.knowm.xchange.dto.account.Balance;

import java.math.BigDecimal;

/**
 *
 */
public final class BalanceMapper implements Mapper<Balance, com.fooock.core.account.Balance> {

    private final CurrencyMapper currencyMapper = new CurrencyMapper();

    @Override
    public com.fooock.core.account.Balance map(Balance from) {
        final Currency currency = from.getCurrency();
        final BigDecimal available = from.getAvailable();
        final BigDecimal availableForWithdrawal = from.getAvailableForWithdrawal();
        final BigDecimal borrowed = from.getBorrowed();
        final BigDecimal depositing = from.getDepositing();
        final BigDecimal frozen = from.getFrozen();
        final BigDecimal loaned = from.getLoaned();
        final BigDecimal total = from.getTotal();
        final BigDecimal withdrawing = from.getWithdrawing();
        return new com.fooock.core.account.Balance(currencyMapper.map(currency),
                new Number(available.toString()),
                new Number(availableForWithdrawal.toString()),
                new Number(borrowed.toString()),
                new Number(depositing.toString()),
                new Number(frozen.toString()),
                new Number(loaned.toString()),
                new Number(total.toString()),
                new Number(withdrawing.toString()));
    }
}
