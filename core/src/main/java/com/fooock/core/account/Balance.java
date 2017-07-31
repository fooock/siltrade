package com.fooock.core.account;

import com.fooock.core.Number;
import com.fooock.core.currency.Currency;

/**
 *
 */
public final class Balance {

    private final Currency currency;

    private final Number available;
    private final Number availableForWithdrawal;
    private final Number borrowed;
    private final Number depositing;
    private final Number frozen;
    private final Number loaned;
    private final Number total;
    private final Number withdrawing;

    public Balance(Currency currency, Number available,
                   Number availableForWithdrawal, Number borrowed,
                   Number depositing, Number frozen, Number loaned,
                   Number total, Number withdrawing) {
        this.currency = currency;
        this.available = available;
        this.availableForWithdrawal = availableForWithdrawal;
        this.borrowed = borrowed;
        this.depositing = depositing;
        this.frozen = frozen;
        this.loaned = loaned;
        this.total = total;
        this.withdrawing = withdrawing;
    }

    public Currency currency() {
        return currency;
    }

    public Number available() {
        return available;
    }

    public Number availableForWithdrawal() {
        return availableForWithdrawal;
    }

    public Number borrowed() {
        return borrowed;
    }

    public Number depositing() {
        return depositing;
    }

    public Number frozen() {
        return frozen;
    }

    public Number loaned() {
        return loaned;
    }

    public Number total() {
        return total;
    }

    public Number withdrawing() {
        return withdrawing;
    }
}
