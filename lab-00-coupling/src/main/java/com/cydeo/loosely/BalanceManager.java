package com.cydeo.loosely;

import java.math.BigDecimal;
import java.util.UUID;

public class BalanceManager {
    Balance balance;
    public boolean checkout(BigDecimal checkoutAmount){
        BigDecimal balanceAmount = balance.getAmount();
        return balanceAmount.subtract(checkoutAmount).compareTo(BigDecimal.ZERO) > 0;
    }
}
