package com.sysbldr.blackjackapi.domain.model;

import java.util.HashSet;
import java.util.Set;

public class DiscardPile {
    private Set<Card> discardPile = new HashSet<>();

    public Set<Card> getDiscardPile() {
        Set<Card> discardPile = new HashSet<>(this.discardPile);
        this.discardPile.clear();
        return discardPile;
    }

    public void dumpHand(Hand hand) {
        discardPile.addAll(hand.getCards());
    }
}
