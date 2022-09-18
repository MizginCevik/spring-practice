package com.cydeo.loosely;

import java.math.BigDecimal;

public class BalanceManager {
//    private final Balance balance;
//
//    public BalanceManager(Balance balance) {
//        this.balance = balance;
//    }

    public boolean checkout(Balance balance, BigDecimal checkoutAmount){
        BigDecimal balanceAmount = balance.getAmount();
        return balanceAmount.subtract(checkoutAmount).compareTo(BigDecimal.ZERO) > 0;
    }
}
