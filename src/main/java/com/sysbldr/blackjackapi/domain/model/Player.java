package com.sysbldr.blackjackapi.domain.model;

import java.math.BigDecimal;

public class Player {
    private BigDecimal bank;
    private final BigDecimal wager;
    private final Strategy strategy;

    public Player(Strategy strategy, BigDecimal bank, BigDecimal wager) {
        this.strategy = strategy;
        this.bank = bank;
        this.wager = wager;
    }

    public boolean hasBank() {
        return (bank.compareTo(wager) >= 0);
    }

    public BigDecimal getWager() {
        return wager;
    }

    public BigDecimal getBank() {
        return bank;
    }

    public BigDecimal deductWager() {
        bank = bank.subtract(wager);
        return getWager();
    }

    public void credit(BigDecimal credit) {
        bank = bank.add(credit);
    }

    public Action play(Hand hand, Card dealerUpCard) {
        return strategy.getAction(hand, dealerUpCard);
    }
}
