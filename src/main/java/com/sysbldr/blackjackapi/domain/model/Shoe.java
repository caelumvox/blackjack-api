package com.sysbldr.blackjackapi.domain.model;

import com.sysbldr.blackjackapi.domain.exception.ShuffleException;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Set;

public class Shoe {
    private static int DECK_SIZE = 52;
    private static int SHUFFLE_SIZE = DECK_SIZE;

    private LinkedList<Card> cards = new LinkedList<>();

    public Shoe(Set<Card> cards) {
        this.cards.addAll(cards);
    }

    public void shuffle() throws ShuffleException {
        if (cards.size() % DECK_SIZE != 0) {
            throw new ShuffleException("Deck is not a complete multiple of decks!");
        }
        Collections.shuffle(cards);
    }

    public boolean isLowOnHands() {
        return cards.size() < SHUFFLE_SIZE;
    }

    public Card draw() {
        return cards.removeFirst();
    }

    public void addCards(Set<Card> cards) {
        this.cards.addAll(cards);
    }

    public Card dealCard() {
        return cards.removeFirst();
    }
}
