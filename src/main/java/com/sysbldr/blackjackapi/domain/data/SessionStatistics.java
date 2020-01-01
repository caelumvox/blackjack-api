package com.sysbldr.blackjackapi.domain.data;

import java.math.BigDecimal;

public class SessionStatistics {
    private BigDecimal bank;
    private int blackjackCount;

    public BigDecimal getBank() {
        return bank;
    }

    public void setBank(BigDecimal bank) {
        this.bank = bank;
    }

    public int getBlackjackCount() {
        return blackjackCount;
    }

    public void setBlackjackCount(int blackjackCount) {
        this.blackjackCount = blackjackCount;
    }
}
